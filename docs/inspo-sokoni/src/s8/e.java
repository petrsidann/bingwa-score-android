package s8;

import java.util.concurrent.TimeUnit;
import p8.p;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f15644d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f15645e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f15646a = p.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15648c;

    public static boolean c(int i10) {
        return i10 == 429 || (i10 >= 500 && i10 < 600);
    }

    public static boolean d(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    public final synchronized long a(int i10) {
        if (c(i10)) {
            return (long) Math.min(Math.pow(2.0d, this.f15648c) + this.f15646a.e(), f15645e);
        }
        return f15644d;
    }

    public synchronized boolean b() {
        return this.f15648c == 0 || this.f15646a.a() > this.f15647b;
    }

    public final synchronized void e() {
        this.f15648c = 0;
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f15648c++;
        this.f15647b = this.f15646a.a() + a(i10);
    }
}
