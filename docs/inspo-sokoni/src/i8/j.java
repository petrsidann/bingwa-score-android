package i8;

import d9.d0;
import h8.y;

/* JADX INFO: loaded from: classes.dex */
public class j implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f10541a;

    public j(d0 d0Var) {
        l8.b.d(y.B(d0Var), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.f10541a = d0Var;
    }

    @Override // i8.p
    public d0 a(d0 d0Var) {
        return y.B(d0Var) ? d0Var : d0.B0().N(0L).build();
    }

    @Override // i8.p
    public d0 b(d0 d0Var, d0 d0Var2) {
        return d0Var2;
    }

    @Override // i8.p
    public d0 c(d0 d0Var, h7.q qVar) {
        double dT0;
        d0.b bVarL;
        d0 d0VarA = a(d0Var);
        if (y.w(d0VarA) && y.w(this.f10541a)) {
            bVarL = d0.B0().N(g(d0VarA.v0(), f()));
        } else {
            if (y.w(d0VarA)) {
                dT0 = d0VarA.v0();
            } else {
                l8.b.d(y.v(d0VarA), "Expected NumberValue to be of type DoubleValue, but was ", d0Var.getClass().getCanonicalName());
                dT0 = d0VarA.t0();
            }
            bVarL = d0.B0().L(dT0 + e());
        }
        return bVarL.build();
    }

    public d0 d() {
        return this.f10541a;
    }

    public final double e() {
        if (y.v(this.f10541a)) {
            return this.f10541a.t0();
        }
        if (y.w(this.f10541a)) {
            return this.f10541a.v0();
        }
        throw l8.b.a("Expected 'operand' to be of Number type, but was " + this.f10541a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long f() {
        if (y.v(this.f10541a)) {
            return (long) this.f10541a.t0();
        }
        if (y.w(this.f10541a)) {
            return this.f10541a.v0();
        }
        throw l8.b.a("Expected 'operand' to be of Number type, but was " + this.f10541a.getClass().getCanonicalName(), new Object[0]);
    }

    public final long g(long j10, long j11) {
        long j12 = j10 + j11;
        if (((j10 ^ j12) & (j11 ^ j12)) >= 0) {
            return j12;
        }
        return j12 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }
}
