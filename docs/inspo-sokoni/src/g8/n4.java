package g8;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e8.g1 f8884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k1 f8887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h8.v f8888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h8.v f8889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.protobuf.i f8890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f8891h;

    /* JADX WARN: Illegal instructions before constructor call */
    public n4(e8.g1 g1Var, int i10, long j10, k1 k1Var) {
        h8.v vVar = h8.v.f9777b;
        this(g1Var, i10, j10, k1Var, vVar, vVar, k8.a1.f11646t, null);
    }

    public n4(e8.g1 g1Var, int i10, long j10, k1 k1Var, h8.v vVar, h8.v vVar2, com.google.protobuf.i iVar, Integer num) {
        this.f8884a = (e8.g1) l8.x.b(g1Var);
        this.f8885b = i10;
        this.f8886c = j10;
        this.f8889f = vVar2;
        this.f8887d = k1Var;
        this.f8888e = (h8.v) l8.x.b(vVar);
        this.f8890g = (com.google.protobuf.i) l8.x.b(iVar);
        this.f8891h = num;
    }

    public Integer a() {
        return this.f8891h;
    }

    public h8.v b() {
        return this.f8889f;
    }

    public k1 c() {
        return this.f8887d;
    }

    public com.google.protobuf.i d() {
        return this.f8890g;
    }

    public long e() {
        return this.f8886c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n4.class != obj.getClass()) {
            return false;
        }
        n4 n4Var = (n4) obj;
        return this.f8884a.equals(n4Var.f8884a) && this.f8885b == n4Var.f8885b && this.f8886c == n4Var.f8886c && this.f8887d.equals(n4Var.f8887d) && this.f8888e.equals(n4Var.f8888e) && this.f8889f.equals(n4Var.f8889f) && this.f8890g.equals(n4Var.f8890g) && Objects.equals(this.f8891h, n4Var.f8891h);
    }

    public h8.v f() {
        return this.f8888e;
    }

    public e8.g1 g() {
        return this.f8884a;
    }

    public int h() {
        return this.f8885b;
    }

    public int hashCode() {
        return (((((((((((((this.f8884a.hashCode() * 31) + this.f8885b) * 31) + ((int) this.f8886c)) * 31) + this.f8887d.hashCode()) * 31) + this.f8888e.hashCode()) * 31) + this.f8889f.hashCode()) * 31) + this.f8890g.hashCode()) * 31) + Objects.hashCode(this.f8891h);
    }

    public n4 i(Integer num) {
        return new n4(this.f8884a, this.f8885b, this.f8886c, this.f8887d, this.f8888e, this.f8889f, this.f8890g, num);
    }

    public n4 j(h8.v vVar) {
        return new n4(this.f8884a, this.f8885b, this.f8886c, this.f8887d, this.f8888e, vVar, this.f8890g, this.f8891h);
    }

    public n4 k(com.google.protobuf.i iVar, h8.v vVar) {
        return new n4(this.f8884a, this.f8885b, this.f8886c, this.f8887d, vVar, this.f8889f, iVar, null);
    }

    public n4 l(long j10) {
        return new n4(this.f8884a, this.f8885b, j10, this.f8887d, this.f8888e, this.f8889f, this.f8890g, this.f8891h);
    }

    public String toString() {
        return "TargetData{target=" + this.f8884a + ", targetId=" + this.f8885b + ", sequenceNumber=" + this.f8886c + ", purpose=" + this.f8887d + ", snapshotVersion=" + this.f8888e + ", lastLimboFreeSnapshotVersion=" + this.f8889f + ", resumeToken=" + this.f8890g + ", expectedCount=" + this.f8891h + '}';
    }
}
