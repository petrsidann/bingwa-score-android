package xb;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f18415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f18416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<vb.l1.b> f18417f;

    public d2(int i10, long j10, long j11, double d10, Long l10, Set<vb.l1.b> set) {
        this.f18412a = i10;
        this.f18413b = j10;
        this.f18414c = j11;
        this.f18415d = d10;
        this.f18416e = l10;
        this.f18417f = k6.t.r(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f18412a == d2Var.f18412a && this.f18413b == d2Var.f18413b && this.f18414c == d2Var.f18414c && Double.compare(this.f18415d, d2Var.f18415d) == 0 && j6.i.a(this.f18416e, d2Var.f18416e) && j6.i.a(this.f18417f, d2Var.f18417f);
    }

    public int hashCode() {
        return j6.i.b(Integer.valueOf(this.f18412a), Long.valueOf(this.f18413b), Long.valueOf(this.f18414c), Double.valueOf(this.f18415d), this.f18416e, this.f18417f);
    }

    public String toString() {
        return j6.g.b(this).b("maxAttempts", this.f18412a).c("initialBackoffNanos", this.f18413b).c("maxBackoffNanos", this.f18414c).a("backoffMultiplier", this.f18415d).d("perAttemptRecvTimeoutNanos", this.f18416e).d("retryableStatusCodes", this.f18417f).toString();
    }
}
