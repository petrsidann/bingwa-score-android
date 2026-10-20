import json, os, threading, time, urllib.request, urllib.error
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer

PORT = int(os.environ.get("BRAIN_PORT", "8787"))
LOCK = threading.Lock()
COOLDOWN, MODEL_BAD, DISCOVERED = {}, {}, {}

PROVIDERS = [
    ("gemini", "https://generativelanguage.googleapis.com/v1beta/openai/", "GEMINI_API_KEY",
     ["gemini-flash-latest", "gemini-2.5-flash", "gemini-2.0-flash"], {}),
    ("openrouter", "https://openrouter.ai/api/v1", "OPENROUTER_API_KEY",
     ["qwen/qwen3-coder:free"], {"HTTP-Referer": "https://bingwascore.com", "X-Title": "BingwaBrain"}),
    ("nvidia", "https://integrate.api.nvidia.com/v1", "NVIDIA_API_KEY",
     ["meta/llama-3.3-70b-instruct"], {}),
    ("cerebras", "https://api.cerebras.ai/v1", "CEREBRAS_API_KEY",
     ["llama-3.3-70b", "llama3.1-8b"], {}),
]

def http_json(url, key=None, xh=None, data=None, timeout=60):
    h = {"Content-Type": "application/json"}
    if key: h["Authorization"] = f"Bearer {key}"
    if xh: h.update(xh)
    req = urllib.request.Request(url, data=json.dumps(data).encode() if data else None, headers=h)
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read().decode())

def discover(name, base, key, xh):
    try:
        ids = [m.get("id", "") for m in http_json(base.rstrip("/") + "/models", key, xh).get("data", [])]
        if name == "openrouter":
            free = [i for i in ids if i.endswith(":free")]
            pref = [i for i in free if any(k in i for k in ("coder", "deepseek", "llama-3.3", "qwen"))]
            pick = (pref or free)[:6]
        elif name == "nvidia":
            pref = [i for i in ids if any(k in i for k in ("llama-3.3", "nemotron", "llama-3.1"))]
            pick = (pref or ids)[:4]
        elif name == "cerebras":
            pick = ids[:4]
        else:
            pick = []
        with LOCK:
            DISCOVERED[name] = pick; MODEL_BAD.pop(name, None)
        print(f"[brain] {name} discovered {len(pick)} models", flush=True)
    except Exception as e:
        print(f"[brain] discover {name} failed: {e}", flush=True)

def models_for(name, static):
    with LOCK: disc = list(DISCOVERED.get(name, []))
    return (disc + [m for m in static if m not in disc]) if disc else list(static)

class H(BaseHTTPRequestHandler):
    def log_message(self, *a): pass
    def _send(self, obj, code=200):
        b = json.dumps(obj).encode()
        self.send_response(code); self.send_header("Content-Type", "application/json")
        self.send_header("Content-Length", str(len(b))); self.end_headers(); self.wfile.write(b)
    def do_GET(self):
        if self.path.startswith("/v1/models"):
            self._send({"object": "list", "data": [{"id": m, "object": "model"}
                        for p in PROVIDERS for m in models_for(p[0], p[3])]})
        elif self.path.startswith("/reset"):
            with LOCK: COOLDOWN.clear(); MODEL_BAD.clear()
            for n, b, e, s, x in PROVIDERS:
                if os.environ.get(e): threading.Thread(target=discover, args=(n, b, os.environ[e], x)).start()
            self._send({"status": "reset"})
        else:
            self._send({"status": "alive", "chain": [p[0] for p in PROVIDERS],
                        "discovered": {k: len(v) for k, v in DISCOVERED.items()},
                        "cooled": {k: int(v - time.time()) for k, v in COOLDOWN.items() if v > time.time()}})
    def do_POST(self):
        payload = json.loads(self.rfile.read(int(self.headers.get("Content-Length", 0))) or b"{}")
        wanted, now, errs = payload.get("model", ""), time.time(), []
        for name, base, env, static, xh in PROVIDERS:
            key = os.environ.get(env)
            if not key: continue
            if COOLDOWN.get(name, 0) > now:
                errs.append(f"{name}:cooling"); continue
            with LOCK: bad = set(MODEL_BAD.get(name, ()))
            cands = ([wanted] if wanted in models_for(name, static) else models_for(name, static))
            cands = [c for c in cands if c not in bad] or cands
            for m in cands:
                payload["model"] = m
                try:
                    r = urllib.request.urlopen(urllib.request.Request(
                        base.rstrip("/") + "/chat/completions", data=json.dumps(payload).encode(),
                        headers={"Authorization": f"Bearer {key}", "Content-Type": "application/json", **xh}),
                        timeout=600)
                    if payload.get("stream"):
                        self.send_response(200)
                        self.send_header("Content-Type", "text/event-stream")
                        self.send_header("Cache-Control", "no-cache"); self.end_headers()
                        while True:
                            ch = r.read(4096)
                            if not ch: break
                            self.wfile.write(ch); self.wfile.flush()
                    else:
                        self._send(json.loads(r.read().decode()))
                    print(f"[brain] served via {name}/{m}", flush=True); return
                except urllib.error.HTTPError as e:
                    body = e.read().decode()[:300]
                    if e.code in (400, 404, 410) and "model" in body.lower():
                        with LOCK: MODEL_BAD.setdefault(name, set()).add(m)
                        errs.append(f"{name}/{m}:badmodel"); continue
                    if e.code in (401, 403): COOLDOWN[name] = now + 86400
                    elif e.code in (402, 429): COOLDOWN[name] = now + 3600
                    else: COOLDOWN[name] = now + 120
                    errs.append(f"{name}:{e.code}"); break
                except Exception as e:
                    errs.append(f"{name}:{type(e).__name__}")
                    with LOCK: COOLDOWN[name] = now + 120
                    break
        self._send({"error": {"message": "all providers down: " + " | ".join(errs)}}, 502)

if __name__ == "__main__":
    for n, b, e, s, x in PROVIDERS:
        k = os.environ.get(e)
        if k: threading.Thread(target=discover, args=(n, b, k, x), daemon=True).start()
    print(f"BingwaBrain v2 :{PORT}", flush=True)
    ThreadingHTTPServer(("127.0.0.1", PORT), H).serve_forever()