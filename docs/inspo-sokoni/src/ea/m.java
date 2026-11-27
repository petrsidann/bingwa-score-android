package ea;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f7520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f7521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f7522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f7523f;

    public m(String str, int i10) {
        this.f7518a = str;
        this.f7519b = i10;
    }

    public boolean b() {
        k kVar = this.f7523f;
        return kVar != null && kVar.b();
    }

    public Integer d() {
        k kVar = this.f7523f;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public void e(final k kVar) {
        this.f7521d.post(new Runnable() { // from class: ea.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f7516a.c(kVar);
            }
        });
    }

    public synchronized void f() {
        HandlerThread handlerThread = this.f7520c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f7520c = null;
            this.f7521d = null;
        }
    }

    public synchronized void g(Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(this.f7518a, this.f7519b);
        this.f7520c = handlerThread;
        handlerThread.start();
        this.f7521d = new Handler(this.f7520c.getLooper());
        this.f7522e = runnable;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void c(k kVar) {
        kVar.f7515b.run();
        this.f7523f = kVar;
        this.f7522e.run();
    }
}
