package ea;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes.dex */
public class r implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HandlerThread f7537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f7538d;

    public r(String str, int i10) {
        this.f7535a = str;
        this.f7536b = i10;
    }

    @Override // ea.n
    public void b(k kVar) {
        this.f7538d.post(kVar.f7515b);
    }

    @Override // ea.n
    public void d() {
        HandlerThread handlerThread = this.f7537c;
        if (handlerThread != null) {
            handlerThread.quit();
            this.f7537c = null;
            this.f7538d = null;
        }
    }

    @Override // ea.n
    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.f7535a, this.f7536b);
        this.f7537c = handlerThread;
        handlerThread.start();
        this.f7538d = new Handler(this.f7537c.getLooper());
    }
}
