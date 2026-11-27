package b8;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w0 f2991g = new w0(0, 0, 0, 0, null, a.SUCCESS);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f2996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Exception f2997f;

    public enum a {
        ERROR,
        RUNNING,
        SUCCESS
    }

    public w0(int i10, int i11, long j10, long j11, Exception exc, a aVar) {
        this.f2992a = i10;
        this.f2993b = i11;
        this.f2994c = j10;
        this.f2995d = j11;
        this.f2996e = aVar;
        this.f2997f = exc;
    }

    public static w0 a(d8.e eVar) {
        return new w0(0, eVar.e(), 0L, eVar.d(), null, a.RUNNING);
    }

    public static w0 b(d8.e eVar) {
        return new w0(eVar.e(), eVar.e(), eVar.d(), eVar.d(), null, a.SUCCESS);
    }

    public long c() {
        return this.f2994c;
    }

    public int d() {
        return this.f2992a;
    }

    public a e() {
        return this.f2996e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w0.class != obj.getClass()) {
            return false;
        }
        w0 w0Var = (w0) obj;
        if (this.f2992a != w0Var.f2992a || this.f2993b != w0Var.f2993b || this.f2994c != w0Var.f2994c || this.f2995d != w0Var.f2995d || this.f2996e != w0Var.f2996e) {
            return false;
        }
        Exception exc = this.f2997f;
        Exception exc2 = w0Var.f2997f;
        if (exc != null) {
            return exc.equals(exc2);
        }
        return exc2 == null;
    }

    public long f() {
        return this.f2995d;
    }

    public int g() {
        return this.f2993b;
    }

    public int hashCode() {
        int i10 = ((this.f2992a * 31) + this.f2993b) * 31;
        long j10 = this.f2994c;
        int i11 = (i10 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f2995d;
        int iHashCode = (((i11 + ((int) (j11 ^ (j11 >>> 32)))) * 31) + this.f2996e.hashCode()) * 31;
        Exception exc = this.f2997f;
        return iHashCode + (exc != null ? exc.hashCode() : 0);
    }
}
