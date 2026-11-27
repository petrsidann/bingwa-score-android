package tb;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements xa.a, ya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f15917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f15918b;

    @Override // ya.a
    public void onAttachedToActivity(ya.c cVar) {
        if (this.f15917a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            this.f15918b.d(cVar.g());
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        b bVar2 = new b(bVar.a(), null);
        this.f15918b = bVar2;
        a aVar = new a(bVar2);
        this.f15917a = aVar;
        aVar.e(bVar.b());
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        if (this.f15917a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
        } else {
            this.f15918b.d(null);
        }
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        a aVar = this.f15917a;
        if (aVar == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
            return;
        }
        aVar.f();
        this.f15917a = null;
        this.f15918b = null;
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c cVar) {
        onAttachedToActivity(cVar);
    }
}
