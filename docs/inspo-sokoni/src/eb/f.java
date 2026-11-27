package eb;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f7585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7586c;

    public class a implements fb.j.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<Long, Long> f7587a = new HashMap();

        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            if (f.this.f7585b != null) {
                String str = iVar.f8284a;
                str.hashCode();
                if (!str.equals("getKeyboardState")) {
                    dVar.c();
                    return;
                } else {
                    try {
                        this.f7587a = f.this.f7585b.b();
                    } catch (IllegalStateException e10) {
                        dVar.b("error", e10.getMessage(), null);
                    }
                }
            }
            dVar.a(this.f7587a);
        }
    }

    public interface b {
        Map<Long, Long> b();
    }

    public f(fb.b bVar) {
        a aVar = new a();
        this.f7586c = aVar;
        fb.j jVar = new fb.j(bVar, "flutter/keyboard", fb.q.f8299b);
        this.f7584a = jVar;
        jVar.e(aVar);
    }

    public void b(b bVar) {
        this.f7585b = bVar;
    }
}
