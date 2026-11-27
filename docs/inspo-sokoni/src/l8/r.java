package l8;

import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f12584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.d f12585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f12587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f12589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f12590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g.b f12592i;

    public r(g gVar, g.d dVar) {
        this(gVar, dVar, 1000L, 1.5d, 60000L);
    }

    public r(g gVar, g.d dVar, long j10, double d10, long j11) {
        this.f12584a = gVar;
        this.f12585b = dVar;
        this.f12586c = j10;
        this.f12587d = d10;
        this.f12588e = j11;
        this.f12589f = j11;
        this.f12591h = new Date().getTime();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Runnable runnable) {
        this.f12591h = new Date().getTime();
        runnable.run();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0074 A[PHI: r2
  0x0074: PHI (r2v9 long) = (r2v7 long), (r2v8 long) binds: [B:6:0x0072, B:9:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    public void b(final Runnable runnable) {
        c();
        long jD = this.f12590g + d();
        long jMax = Math.max(0L, new Date().getTime() - this.f12591h);
        long jMax2 = Math.max(0L, jD - jMax);
        if (this.f12590g > 0) {
            v.a(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(jMax2), Long.valueOf(this.f12590g), Long.valueOf(jD), Long.valueOf(jMax));
        }
        this.f12592i = this.f12584a.k(this.f12585b, jMax2, new Runnable() { // from class: l8.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f12582a.e(runnable);
            }
        });
        long j10 = (long) (this.f12590g * this.f12587d);
        this.f12590g = j10;
        long j11 = this.f12586c;
        if (j10 < j11) {
            this.f12590g = j11;
        } else {
            j11 = this.f12589f;
            if (j10 > j11) {
                this.f12590g = j11;
            }
        }
        this.f12589f = this.f12588e;
    }

    public void c() {
        g.b bVar = this.f12592i;
        if (bVar != null) {
            bVar.c();
            this.f12592i = null;
        }
    }

    public final long d() {
        return (long) ((Math.random() - 0.5d) * this.f12590g);
    }

    public void f() {
        this.f12590g = 0L;
    }

    public void g() {
        this.f12590g = this.f12589f;
    }

    public void h(long j10) {
        this.f12589f = j10;
    }
}
