package xb;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<vb.l1.b> f18966c;

    public t0(int i10, long j10, Set<vb.l1.b> set) {
        this.f18964a = i10;
        this.f18965b = j10;
        this.f18966c = k6.t.r(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t0.class != obj.getClass()) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f18964a == t0Var.f18964a && this.f18965b == t0Var.f18965b && j6.i.a(this.f18966c, t0Var.f18966c);
    }

    public int hashCode() {
        return j6.i.b(Integer.valueOf(this.f18964a), Long.valueOf(this.f18965b), this.f18966c);
    }

    public String toString() {
        return j6.g.b(this).b("maxAttempts", this.f18964a).c("hedgingDelayNanos", this.f18965b).d("nonFatalStatusCodes", this.f18966c).toString();
    }
}
