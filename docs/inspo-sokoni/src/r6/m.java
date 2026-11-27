package r6;

import e7.c0;
import e7.d0;
import e7.z;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f15046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c7.a f15047b = c7.a.f3409b;

    public m(c0 c0Var) {
        this.f15046a = c0Var;
    }

    public static void a(e7.t tVar) throws GeneralSecurityException {
        if (tVar == null || tVar.P().size() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static void b(c0 c0Var) throws GeneralSecurityException {
        if (c0Var == null || c0Var.S() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public static c0 c(e7.t tVar, a aVar, byte[] bArr) throws GeneralSecurityException {
        try {
            c0 c0VarW = c0.W(aVar.b(tVar.P().z(), bArr), com.google.crypto.tink.shaded.protobuf.q.b());
            b(c0VarW);
            return c0VarW;
        } catch (com.google.crypto.tink.shaded.protobuf.c0 unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public static e7.t d(c0 c0Var, a aVar, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrA = aVar.a(c0Var.i(), bArr);
        try {
            if (c0.W(aVar.b(bArrA, bArr), com.google.crypto.tink.shaded.protobuf.q.b()).equals(c0Var)) {
                return e7.t.Q().x(com.google.crypto.tink.shaded.protobuf.i.k(bArrA)).y(y.b(c0Var)).build();
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (com.google.crypto.tink.shaded.protobuf.c0 unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    public static final m e(c0 c0Var) throws GeneralSecurityException {
        b(c0Var);
        return new m(c0Var);
    }

    public static final m j(o oVar, a aVar) {
        return k(oVar, aVar, new byte[0]);
    }

    public static final m k(o oVar, a aVar, byte[] bArr) throws GeneralSecurityException {
        e7.t tVarA = oVar.a();
        a(tVarA);
        return new m(c(tVarA, aVar, bArr));
    }

    public c0 f() {
        return this.f15046a;
    }

    public d0 g() {
        return y.b(this.f15046a);
    }

    public <P> P h(Class<P> cls) throws GeneralSecurityException {
        Class<?> clsC = w.c(cls);
        if (clsC != null) {
            return (P) i(cls, clsC);
        }
        throw new GeneralSecurityException("No wrapper found for " + cls.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <B, P> P i(Class<P> cls, Class<B> cls2) throws GeneralSecurityException {
        y.d(this.f15046a);
        u.b bVarJ = u.j(cls2);
        bVarJ.e(this.f15047b);
        for (c0.c cVar : this.f15046a.T()) {
            if (cVar.U() == z.ENABLED) {
                Object objD = w.d(cVar.R(), cls2);
                if (cVar.S() == this.f15046a.U()) {
                    bVarJ.a(objD, cVar);
                } else {
                    bVarJ.b(objD, cVar);
                }
            }
        }
        return (P) w.n(bVarJ.d(), cls);
    }

    public void l(p pVar, a aVar) {
        m(pVar, aVar, new byte[0]);
    }

    public void m(p pVar, a aVar, byte[] bArr) {
        pVar.a(d(this.f15046a, aVar, bArr));
    }

    public String toString() {
        return g().toString();
    }
}
