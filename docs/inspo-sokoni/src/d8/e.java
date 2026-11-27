package d8;

import h8.v;

/* JADX INFO: loaded from: classes.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f6486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6488e;

    public e(String str, int i10, v vVar, int i11, long j10) {
        this.f6484a = str;
        this.f6485b = i10;
        this.f6486c = vVar;
        this.f6487d = i11;
        this.f6488e = j10;
    }

    public String a() {
        return this.f6484a;
    }

    public v b() {
        return this.f6486c;
    }

    public int c() {
        return this.f6485b;
    }

    public long d() {
        return this.f6488e;
    }

    public int e() {
        return this.f6487d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f6485b == eVar.f6485b && this.f6487d == eVar.f6487d && this.f6488e == eVar.f6488e && this.f6484a.equals(eVar.f6484a)) {
            return this.f6486c.equals(eVar.f6486c);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((this.f6484a.hashCode() * 31) + this.f6485b) * 31) + this.f6487d) * 31;
        long j10 = this.f6488e;
        return ((iHashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f6486c.hashCode();
    }
}
