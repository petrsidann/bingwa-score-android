package r6;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList<q> f15049a = new CopyOnWriteArrayList<>();

    public static q a(String str) throws GeneralSecurityException {
        for (q qVar : f15049a) {
            if (qVar.a(str)) {
                return qVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: " + str);
    }
}
