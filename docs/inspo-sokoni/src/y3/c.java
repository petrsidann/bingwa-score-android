package y3;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.google.android.gms.common.api.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f19351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f19352b;

    public GoogleSignInAccount a() {
        return this.f19352b;
    }

    @Override // com.google.android.gms.common.api.k
    public Status getStatus() {
        return this.f19351a;
    }
}
