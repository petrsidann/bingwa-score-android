package r6;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static k a(String str) throws GeneralSecurityException {
        k kVar = w.h().get(str);
        if (kVar != null) {
            return kVar;
        }
        throw new GeneralSecurityException("cannot find key template: " + str);
    }
}
