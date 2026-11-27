package eb;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f7663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7664c;

    public class a implements fb.j.c {
        public a() {
        }

        public static /* synthetic */ void e(fb.j.d dVar, c cVar) {
            if (cVar == null) {
                dVar.b("error", "Failed to resize the platform view", null);
                return;
            }
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(cVar.f7666a));
            map.put("height", Double.valueOf(cVar.f7667b));
            dVar.a(map);
        }

        public final void b(fb.i iVar, fb.j.d dVar) {
            try {
                m.this.f7663b.g(((Integer) iVar.b()).intValue());
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void c(fb.i iVar, fb.j.d dVar) {
            Map map = (Map) iVar.b();
            boolean z10 = true;
            boolean z11 = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
            try {
                if (z11) {
                    m.this.f7663b.c(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), d.a.HYBRID_ONLY, byteBufferWrap));
                } else {
                    if (!map.containsKey("hybridFallback") || !((Boolean) map.get("hybridFallback")).booleanValue()) {
                        z10 = false;
                    }
                    long jD = m.this.f7663b.d(new d(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z10 ? d.a.TEXTURE_WITH_HYBRID_FALLBACK : d.a.TEXTURE_WITH_VIRTUAL_FALLBACK, byteBufferWrap));
                    if (jD != -2) {
                        dVar.a(Long.valueOf(jD));
                        return;
                    } else if (!z10) {
                        throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                    }
                }
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void d(fb.i iVar, fb.j.d dVar) {
            try {
                m.this.f7663b.i(((Integer) ((Map) iVar.b()).get("id")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void f(fb.i iVar, fb.j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                m.this.f7663b.e(((Integer) map.get("id")).intValue(), ((Double) map.get("top")).doubleValue(), ((Double) map.get("left")).doubleValue());
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void g(fb.i iVar, final fb.j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                m.this.f7663b.h(new e(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new b() { // from class: eb.l
                    @Override // eb.m.b
                    public final void a(m.c cVar) {
                        m.a.e(dVar, cVar);
                    }
                });
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void h(fb.i iVar, fb.j.d dVar) {
            Map map = (Map) iVar.b();
            try {
                m.this.f7663b.b(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void i(fb.i iVar, fb.j.d dVar) {
            try {
                m.this.f7663b.a(((Boolean) iVar.b()).booleanValue());
                dVar.a(null);
            } catch (IllegalStateException e10) {
                dVar.b("error", m.c(e10), null);
            }
        }

        public final void j(fb.i iVar, fb.j.d dVar) {
            fb.j.d dVar2;
            List list = (List) iVar.b();
            try {
                m.this.f7663b.f(new f(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
                try {
                    dVar2.a(null);
                } catch (IllegalStateException e10) {
                    e = e10;
                    dVar2.b("error", m.c(e), null);
                }
            } catch (IllegalStateException e11) {
                e = e11;
                dVar2 = dVar;
            }
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (m.this.f7663b == null) {
            }
            qa.b.f("PlatformViewsChannel", "Received '" + iVar.f8284a + "' message.");
            String str = iVar.f8284a;
            str.hashCode();
            switch (str) {
                case "create":
                    c(iVar, dVar);
                    break;
                case "offset":
                    f(iVar, dVar);
                    break;
                case "resize":
                    g(iVar, dVar);
                    break;
                case "clearFocus":
                    b(iVar, dVar);
                    break;
                case "synchronizeToNativeViewHierarchy":
                    i(iVar, dVar);
                    break;
                case "touch":
                    j(iVar, dVar);
                    break;
                case "setDirection":
                    h(iVar, dVar);
                    break;
                case "dispose":
                    d(iVar, dVar);
                    break;
                default:
                    dVar.c();
                    break;
            }
        }
    }

    public interface b {
        void a(c cVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7667b;

        public c(int i10, int i11) {
            this.f7666a = i10;
            this.f7667b = i11;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f7670c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f7671d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f7672e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f7673f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f7674g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f7675h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ByteBuffer f7676i;

        public enum a {
            TEXTURE_WITH_VIRTUAL_FALLBACK,
            TEXTURE_WITH_HYBRID_FALLBACK,
            HYBRID_ONLY
        }

        public d(int i10, String str, double d10, double d11, double d12, double d13, int i11, a aVar, ByteBuffer byteBuffer) {
            this.f7668a = i10;
            this.f7669b = str;
            this.f7672e = d10;
            this.f7673f = d11;
            this.f7670c = d12;
            this.f7671d = d13;
            this.f7674g = i11;
            this.f7675h = aVar;
            this.f7676i = byteBuffer;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final double f7683c;

        public e(int i10, double d10, double d11) {
            this.f7681a = i10;
            this.f7682b = d10;
            this.f7683c = d11;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Number f7685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Number f7686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f7687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f7688e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f7689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Object f7690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f7691h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f7692i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f7693j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f7694k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f7695l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f7696m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f7697n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f7698o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f7699p;

        public f(int i10, Number number, Number number2, int i11, int i12, Object obj, Object obj2, int i13, int i14, float f10, float f11, int i15, int i16, int i17, int i18, long j10) {
            this.f7684a = i10;
            this.f7685b = number;
            this.f7686c = number2;
            this.f7687d = i11;
            this.f7688e = i12;
            this.f7689f = obj;
            this.f7690g = obj2;
            this.f7691h = i13;
            this.f7692i = i14;
            this.f7693j = f10;
            this.f7694k = f11;
            this.f7695l = i15;
            this.f7696m = i16;
            this.f7697n = i17;
            this.f7698o = i18;
            this.f7699p = j10;
        }
    }

    public interface g {
        void a(boolean z10);

        void b(int i10, int i11);

        void c(d dVar);

        long d(d dVar);

        void e(int i10, double d10, double d11);

        void f(f fVar);

        void g(int i10);

        void h(e eVar, b bVar);

        void i(int i10);
    }

    public m(ta.a aVar) {
        a aVar2 = new a();
        this.f7664c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/platform_views", fb.q.f8299b);
        this.f7662a = jVar;
        jVar.e(aVar2);
    }

    public static String c(Exception exc) {
        return qa.b.d(exc);
    }

    public void d(int i10) {
        fb.j jVar = this.f7662a;
        if (jVar == null) {
            return;
        }
        jVar.c("viewFocused", Integer.valueOf(i10));
    }

    public void e(g gVar) {
        this.f7663b = gVar;
    }
}
