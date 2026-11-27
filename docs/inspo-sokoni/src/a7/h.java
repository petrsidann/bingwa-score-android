package a7;

import com.google.crypto.tink.shaded.protobuf.c0;
import e7.i0;
import java.security.GeneralSecurityException;
import r6.x;
import z6.n;
import z6.q;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g7.a f401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z6.j<c, z6.m> f402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z6.i<z6.m> f403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z6.c<a7.a, z6.l> f404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final z6.b<z6.l> f405e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406a;

        static {
            int[] iArr = new int[i0.values().length];
            f406a = iArr;
            try {
                iArr[i0.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f406a[i0.CRUNCHY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f406a[i0.LEGACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f406a[i0.RAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        g7.a aVarD = q.d("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f401a = aVarD;
        f402b = z6.j.a(new z6.j.b() { // from class: a7.d
        }, c.class, z6.m.class);
        f403c = z6.i.a(new z6.i.b() { // from class: a7.e
        }, aVarD, z6.m.class);
        f404d = z6.c.a(new z6.c.b() { // from class: a7.f
        }, a7.a.class, z6.l.class);
        f405e = z6.b.a(new z6.b.InterfaceC0342b() { // from class: a7.g
            @Override // z6.b.InterfaceC0342b
            public final r6.f a(n nVar, x xVar) {
                return h.b((z6.l) nVar, xVar);
            }
        }, aVarD, z6.l.class);
    }

    public static a7.a b(z6.l lVar, x xVar) throws GeneralSecurityException {
        if (!lVar.f().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
        try {
            e7.a aVarU = e7.a.U(lVar.g(), com.google.crypto.tink.shaded.protobuf.q.b());
            if (aVarU.S() == 0) {
                return a7.a.d(c(aVarU.R(), lVar.e()), g7.b.a(aVarU.Q().z(), x.b(xVar)), lVar.c());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (c0 | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static c c(e7.c cVar, i0 i0Var) {
        return c.a(cVar.P(), f(i0Var));
    }

    public static void d() {
        e(z6.h.a());
    }

    public static void e(z6.h hVar) {
        hVar.g(f402b);
        hVar.f(f403c);
        hVar.e(f404d);
        hVar.d(f405e);
    }

    public static c.a f(i0 i0Var) throws GeneralSecurityException {
        int i10 = a.f406a[i0Var.ordinal()];
        if (i10 == 1) {
            return c.a.f396b;
        }
        if (i10 == 2) {
            return c.a.f397c;
        }
        if (i10 == 3) {
            return c.a.f398d;
        }
        if (i10 == 4) {
            return c.a.f399e;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + i0Var.a());
    }
}
