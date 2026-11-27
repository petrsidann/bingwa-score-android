package h7;

import com.google.android.gms.common.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class l extends Exception {
    @Deprecated
    public l() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str) {
        super(str);
        r.g(str, "Detail message must not be empty");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(String str, Throwable th) {
        super(str, th);
        r.g(str, "Detail message must not be empty");
    }
}
