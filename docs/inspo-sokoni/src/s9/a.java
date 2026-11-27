package s9;

import android.content.Context;
import android.os.Build;
import fb.f;
import fb.i;
import fb.j;

/* JADX INFO: loaded from: classes.dex */
public class a implements xa.a, j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f15653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f15654b;

    public final void a(Context context, fb.b bVar) {
        j jVar = new j(bVar, "flutter_sms_inbox");
        this.f15653a = jVar;
        jVar.e(this);
        j jVar2 = new j(bVar, "plugins.juliusgithaiga.com/querySMS", f.f8283a);
        this.f15654b = jVar2;
        jVar2.e(new b(context));
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        a(bVar.a(), bVar.b());
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        this.f15653a.e(null);
        this.f15654b.e(null);
        this.f15654b = null;
        this.f15653a = null;
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
