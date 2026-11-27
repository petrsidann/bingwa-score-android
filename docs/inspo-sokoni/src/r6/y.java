package r6;

import e7.c0;
import e7.d0;
import e7.i0;
import e7.z;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f15075a = Charset.forName("UTF-8");

    public static d0.c a(c0.c cVar) {
        return d0.c.S().A(cVar.R().S()).z(cVar.U()).y(cVar.T()).x(cVar.S()).build();
    }

    public static d0 b(c0 c0Var) {
        d0.b bVarY = d0.S().y(c0Var.U());
        Iterator<c0.c> it = c0Var.T().iterator();
        while (it.hasNext()) {
            bVarY.x(a(it.next()));
        }
        return bVarY.build();
    }

    public static void c(c0.c cVar) throws GeneralSecurityException {
        if (!cVar.V()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(cVar.S())));
        }
        if (cVar.T() == i0.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(cVar.S())));
        }
        if (cVar.U() == z.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(cVar.S())));
        }
    }

    public static void d(c0 c0Var) throws GeneralSecurityException {
        int iU = c0Var.U();
        int i10 = 0;
        boolean z10 = false;
        boolean z11 = true;
        for (c0.c cVar : c0Var.T()) {
            if (cVar.U() == z.ENABLED) {
                c(cVar);
                if (cVar.S() == iU) {
                    if (z10) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z10 = true;
                }
                if (cVar.R().R() != e7.y.c.ASYMMETRIC_PUBLIC) {
                    z11 = false;
                }
                i10++;
            }
        }
        if (i10 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z10 && !z11) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
