package eb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, List<fb.j.d>> f7577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fb.j.c f7578c;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            c.a(c.this);
        }
    }

    public c(ta.a aVar) {
        a aVar2 = new a();
        this.f7578c = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/deferredcomponent", fb.q.f8299b);
        this.f7576a = jVar;
        jVar.e(aVar2);
        qa.a.e().a();
        this.f7577b = new HashMap();
    }

    public static /* synthetic */ ua.a a(c cVar) {
        cVar.getClass();
        return null;
    }
}
