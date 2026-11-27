package p7;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.internal.p002firebaseauthapi.zze;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static f4.a f14311h = new f4.a("TokenRefresher", "FirebaseAuth:");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h7.f f14312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f14313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f14314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HandlerThread f14316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f14317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f14318g;

    public t(h7.f fVar) {
        f14311h.g("Initializing TokenRefresher", new Object[0]);
        h7.f fVar2 = (h7.f) com.google.android.gms.common.internal.r.l(fVar);
        this.f14312a = fVar2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.f14316e = handlerThread;
        handlerThread.start();
        this.f14317f = new zze(this.f14316e.getLooper());
        this.f14318g = new w(this, fVar2.q());
        this.f14315d = 300000L;
    }

    public final void b() {
        this.f14317f.removeCallbacks(this.f14318g);
    }

    public final void c() {
        f14311h.g("Scheduling refresh for " + (this.f14313b - this.f14315d), new Object[0]);
        b();
        this.f14314c = Math.max((this.f14313b - j4.g.d().a()) - this.f14315d, 0L) / 1000;
        this.f14317f.postDelayed(this.f14318g, this.f14314c * 1000);
    }

    public final void d() {
        long j10;
        int i10 = (int) this.f14314c;
        if (i10 == 30 || i10 == 60 || i10 == 120 || i10 == 240 || i10 == 480) {
            j10 = 2 * this.f14314c;
        } else {
            j10 = i10 != 960 ? 30L : 960L;
        }
        this.f14314c = j10;
        this.f14313b = j4.g.d().a() + (this.f14314c * 1000);
        f14311h.g("Scheduling refresh for " + this.f14313b, new Object[0]);
        this.f14317f.postDelayed(this.f14318g, this.f14314c * 1000);
    }
}
