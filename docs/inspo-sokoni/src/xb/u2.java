package xb;

/* JADX INFO: loaded from: classes2.dex */
public final class u2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f18991l = new b(r2.f18900a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r2 f18992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f18995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f18997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f18998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f18999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f19000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f19001j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f19002k;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r2 f19003a;

        public b(r2 r2Var) {
            this.f19003a = r2Var;
        }

        public u2 a() {
            return new u2(this.f19003a);
        }
    }

    public interface c {
    }

    public u2() {
        this.f19001j = f1.a();
        this.f18992a = r2.f18900a;
    }

    public u2(r2 r2Var) {
        this.f19001j = f1.a();
        this.f18992a = r2Var;
    }

    public static b a() {
        return f18991l;
    }

    public void b() {
        this.f18997f++;
    }

    public void c() {
        this.f18993b++;
        this.f18994c = this.f18992a.a();
    }

    public void d() {
        this.f19001j.add(1L);
        this.f19002k = this.f18992a.a();
    }

    public void e(int i10) {
        if (i10 == 0) {
            return;
        }
        this.f18999h += (long) i10;
        this.f19000i = this.f18992a.a();
    }

    public void f(boolean z10) {
        if (z10) {
            this.f18995d++;
        } else {
            this.f18996e++;
        }
    }

    public void g(c cVar) {
        this.f18998g = (c) j6.m.o(cVar);
    }
}
