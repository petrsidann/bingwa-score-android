package j4;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f11225a = new g();

    public static d d() {
        return f11225a;
    }

    @Override // j4.d
    public final long a() {
        return System.currentTimeMillis();
    }

    @Override // j4.d
    public final long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // j4.d
    public final long c() {
        return System.nanoTime();
    }
}
