package eb;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb.j f7608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fb.j.c f7609b;

    public class a implements fb.j.c {
        public a() {
        }

        @Override // fb.j.c
        public void onMethodCall(fb.i iVar, fb.j.d dVar) {
            dVar.a(null);
        }
    }

    public j(ta.a aVar) {
        a aVar2 = new a();
        this.f7609b = aVar2;
        fb.j jVar = new fb.j(aVar, "flutter/navigation", fb.f.f8283a);
        this.f7608a = jVar;
        jVar.e(aVar2);
    }

    public void a() {
        qa.b.f("NavigationChannel", "Sending message to pop route.");
        this.f7608a.c("popRoute", null);
    }

    public void b(String str) {
        qa.b.f("NavigationChannel", "Sending message to push route information '" + str + "'");
        HashMap map = new HashMap();
        map.put("location", str);
        this.f7608a.c("pushRouteInformation", map);
    }

    public void c(String str) {
        qa.b.f("NavigationChannel", "Sending message to set initial route to '" + str + "'");
        this.f7608a.c("setInitialRoute", str);
    }
}
