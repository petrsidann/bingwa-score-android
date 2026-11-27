package e8;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d9.d0> f7182b;

    public i(List<d9.d0> list, boolean z10) {
        this.f7182b = list;
        this.f7181a = z10;
    }

    public final int a(List<a1> list, h8.h hVar) {
        int i10;
        l8.b.d(this.f7182b.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f7182b.size(); i12++) {
            a1 a1Var = list.get(i12);
            d9.d0 d0Var = this.f7182b.get(i12);
            if (a1Var.f7093b.equals(h8.q.f9757b)) {
                l8.b.d(h8.y.C(d0Var), "Bound has a non-key value where the key path is being used %s", d0Var);
                i10 = h8.k.l(d0Var.x0()).compareTo(hVar.getKey());
            } else {
                d9.d0 d0VarL = hVar.l(a1Var.c());
                l8.b.d(d0VarL != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                i10 = h8.y.i(d0Var, d0VarL);
            }
            if (a1Var.b().equals(a1.a.DESCENDING)) {
                i10 *= -1;
            }
            i11 = i10;
            if (i11 != 0) {
                break;
            }
        }
        return i11;
    }

    public List<d9.d0> b() {
        return this.f7182b;
    }

    public boolean c() {
        return this.f7181a;
    }

    public String d() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (d9.d0 d0Var : this.f7182b) {
            if (!z10) {
                sb2.append(",");
            }
            sb2.append(h8.y.b(d0Var));
            z10 = false;
        }
        return sb2.toString();
    }

    public boolean e(List<a1> list, h8.h hVar) {
        int iA = a(list, hVar);
        if (this.f7181a) {
            if (iA >= 0) {
                return true;
            }
        } else if (iA > 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f7181a == iVar.f7181a && this.f7182b.equals(iVar.f7182b);
    }

    public boolean f(List<a1> list, h8.h hVar) {
        int iA = a(list, hVar);
        if (this.f7181a) {
            if (iA <= 0) {
                return true;
            }
        } else if (iA < 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f7181a ? 1 : 0) * 31) + this.f7182b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bound(inclusive=");
        sb2.append(this.f7181a);
        sb2.append(", position=");
        for (int i10 = 0; i10 < this.f7182b.size(); i10++) {
            if (i10 > 0) {
                sb2.append(" and ");
            }
            sb2.append(h8.y.b(this.f7182b.get(i10)));
        }
        sb2.append(")");
        return sb2.toString();
    }
}
