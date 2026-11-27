package eb;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.a<Object> f7581a;

    public interface a {
        void a(boolean z10);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KeyEvent f7582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Character f7583b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f7582a = keyEvent;
            this.f7583b = ch;
        }
    }

    public e(fb.b bVar) {
        this.f7581a = new fb.a<>(bVar, "flutter/keyevent", fb.e.f8282a);
    }

    public static fb.a.e<Object> b(final a aVar) {
        return new fb.a.e() { // from class: eb.d
            @Override // fb.a.e
            public final void a(Object obj) throws JSONException {
                e.d(aVar, obj);
            }
        };
    }

    public static /* synthetic */ void d(a aVar, Object obj) throws JSONException {
        boolean z10 = false;
        if (obj != null) {
            try {
                z10 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e10) {
                qa.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e10);
            }
        }
        aVar.a(z10);
    }

    public final Map<String, Object> c(b bVar, boolean z10) {
        HashMap map = new HashMap();
        map.put("type", z10 ? "keyup" : "keydown");
        map.put("keymap", "android");
        map.put("flags", Integer.valueOf(bVar.f7582a.getFlags()));
        map.put("plainCodePoint", Integer.valueOf(bVar.f7582a.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(bVar.f7582a.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(bVar.f7582a.getKeyCode()));
        map.put("scanCode", Integer.valueOf(bVar.f7582a.getScanCode()));
        map.put("metaState", Integer.valueOf(bVar.f7582a.getMetaState()));
        Character ch = bVar.f7583b;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(bVar.f7582a.getSource()));
        map.put("deviceId", Integer.valueOf(bVar.f7582a.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(bVar.f7582a.getRepeatCount()));
        return map;
    }

    public void e(b bVar, boolean z10, a aVar) {
        this.f7581a.d(c(bVar, z10), b(aVar));
    }
}
