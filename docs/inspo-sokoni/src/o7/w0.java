package o7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {
    public static Task<y0> a(l0 l0Var) {
        com.google.android.gms.common.internal.r.l(l0Var);
        p7.p pVar = (p7.p) l0Var;
        return FirebaseAuth.getInstance(pVar.S().n0()).a0(pVar);
    }

    public static v0 b(y0 y0Var, String str) {
        return new v0((String) com.google.android.gms.common.internal.r.l(str), (y0) com.google.android.gms.common.internal.r.l(y0Var), null);
    }

    public static v0 c(String str, String str2) {
        return new v0((String) com.google.android.gms.common.internal.r.l(str2), null, (String) com.google.android.gms.common.internal.r.l(str));
    }
}
