package xb;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Random f18444a = new Random();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18445b = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18446c = TimeUnit.MINUTES.toNanos(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f18447d = 1.6d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f18448e = 0.2d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18449f = this.f18445b;

    public static final class a implements j.a {
        @Override // xb.j.a
        public j get() {
            return new f0();
        }
    }

    @Override // xb.j
    public long a() {
        long j10 = this.f18449f;
        double d10 = j10;
        this.f18449f = Math.min((long) (this.f18447d * d10), this.f18446c);
        double d11 = this.f18448e;
        return j10 + b((-d11) * d10, d11 * d10);
    }

    public final long b(double d10, double d11) {
        j6.m.d(d11 >= d10);
        return (long) ((this.f18444a.nextDouble() * (d11 - d10)) + d10);
    }
}
