package ne;

import android.os.Build;
import fb.i;
import fb.j;

/* JADX INFO: loaded from: classes2.dex */
public class a implements xa.a, j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f13597a;

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        j jVar = new j(bVar.b(), "flutter_native_splash");
        this.f13597a = jVar;
        jVar.e(this);
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f13597a.e(null);
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        if (!iVar.f8284a.equals("getPlatformVersion")) {
            dVar.c();
            return;
        }
        dVar.a("Android " + Build.VERSION.RELEASE);
    }
}
