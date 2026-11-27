package r6;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f15074a = new x();

    public static x a() {
        return f15074a;
    }

    public static x b(x xVar) throws GeneralSecurityException {
        if (xVar != null) {
            return xVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
