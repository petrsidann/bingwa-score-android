package i8;

import d9.d0;
import h8.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<d0> f10520a;

    /* JADX INFO: renamed from: i8.a$a, reason: collision with other inner class name */
    public static class C0175a extends a {
        public C0175a(List<d0> list) {
            super(list);
        }

        @Override // i8.a
        public d0 d(d0 d0Var) {
            d9.b.C0113b c0113bE = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                int i10 = 0;
                while (i10 < c0113bE.I()) {
                    if (y.r(c0113bE.H(i10), d0Var2)) {
                        c0113bE.K(i10);
                    } else {
                        i10++;
                    }
                }
            }
            return d0.B0().F(c0113bE).build();
        }
    }

    public static class b extends a {
        public b(List<d0> list) {
            super(list);
        }

        @Override // i8.a
        public d0 d(d0 d0Var) {
            d9.b.C0113b c0113bE = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                if (!y.q(c0113bE, d0Var2)) {
                    c0113bE.F(d0Var2);
                }
            }
            return d0.B0().F(c0113bE).build();
        }
    }

    public a(List<d0> list) {
        this.f10520a = Collections.unmodifiableList(list);
    }

    public static d9.b.C0113b e(d0 d0Var) {
        return y.u(d0Var) ? d0Var.p0().b() : d9.b.n0();
    }

    @Override // i8.p
    public d0 a(d0 d0Var) {
        return null;
    }

    @Override // i8.p
    public d0 b(d0 d0Var, d0 d0Var2) {
        return d(d0Var);
    }

    @Override // i8.p
    public d0 c(d0 d0Var, h7.q qVar) {
        return d(d0Var);
    }

    public abstract d0 d(d0 d0Var);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f10520a.equals(((a) obj).f10520a);
    }

    public List<d0> f() {
        return this.f10520a;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.f10520a.hashCode();
    }
}
