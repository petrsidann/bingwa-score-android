package e8;

/* JADX INFO: loaded from: classes.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h8.q f7093b;

    public enum a {
        ASCENDING(1),
        DESCENDING(-1);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7097a;

        a(int i10) {
            this.f7097a = i10;
        }

        public int h() {
            return this.f7097a;
        }
    }

    public a1(a aVar, h8.q qVar) {
        this.f7092a = aVar;
        this.f7093b = qVar;
    }

    public static a1 d(a aVar, h8.q qVar) {
        return new a1(aVar, qVar);
    }

    public int a(h8.h hVar, h8.h hVar2) {
        int iH;
        int i10;
        if (this.f7093b.equals(h8.q.f9757b)) {
            iH = this.f7092a.h();
            i10 = hVar.getKey().compareTo(hVar2.getKey());
        } else {
            d9.d0 d0VarL = hVar.l(this.f7093b);
            d9.d0 d0VarL2 = hVar2.l(this.f7093b);
            l8.b.d((d0VarL == null || d0VarL2 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            iH = this.f7092a.h();
            i10 = h8.y.i(d0VarL, d0VarL2);
        }
        return iH * i10;
    }

    public a b() {
        return this.f7092a;
    }

    public h8.q c() {
        return this.f7093b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f7092a == a1Var.f7092a && this.f7093b.equals(a1Var.f7093b);
    }

    public int hashCode() {
        return ((899 + this.f7092a.hashCode()) * 31) + this.f7093b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7092a == a.ASCENDING ? "" : "-");
        sb2.append(this.f7093b.i());
        return sb2.toString();
    }
}
