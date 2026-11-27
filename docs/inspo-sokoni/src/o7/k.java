package o7;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static h a(String str, String str2) {
        com.google.android.gms.common.internal.r.f(str);
        com.google.android.gms.common.internal.r.f(str2);
        return new j(str, str2);
    }

    public static h b(String str, String str2) {
        if (j.W(str2)) {
            return new j(str, null, str2, null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
