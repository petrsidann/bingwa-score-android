package eb;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f7605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7606c;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (i.this.f7605b == null) {
                return;
            }
            String str = iVar.f8284a;
            qa.b.f("MouseCursorChannel", "Received '" + str + "' message.");
            try {
                if (((str.hashCode() == -1307105544 && str.equals("activateSystemCursor")) ? (byte) 0 : (byte) -1) != 0) {
                    return;
                }
                try {
                    i.this.f7605b.a((String) ((HashMap) iVar.f8285b).get("kind"));
                    dVar.a(Boolean.TRUE);
                } catch (Exception e10) {
                    dVar.b("error", "Error when setting cursors: " + e10.getMessage(), null);
                }
            } catch (Exception e11) {
                dVar.b("error", "Unhandled error: " + e11.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str);
    }

    public i(ta.a aVar) {
        a aVar2 = new a();
        this.f7606c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/mousecursor", fb.q.f8299b);
        this.f7604a = jVar;
        jVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f7605b = bVar;
    }
}
