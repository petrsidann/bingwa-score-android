package jb;

import android.content.Context;
import android.net.ConnectivityManager;
import fb.j;

/* JADX INFO: loaded from: classes2.dex */
public class d implements xa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f11339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fb.c f11340b;

    public final void a(fb.b bVar, Context context) {
        this.f11339a = new j(bVar, "plugins.flutter.io/connectivity");
        this.f11340b = new fb.c(bVar, "plugins.flutter.io/connectivity_status");
        a aVar = new a((ConnectivityManager) context.getSystemService("connectivity"));
        c cVar = new c(aVar);
        b bVar2 = new b(context, aVar);
        this.f11339a.e(cVar);
        this.f11340b.d(bVar2);
    }

    public final void b() {
        this.f11339a.e(null);
        this.f11340b.d(null);
        this.f11339a = null;
        this.f11340b = null;
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        a(bVar.b(), bVar.a());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        b();
    }
}
