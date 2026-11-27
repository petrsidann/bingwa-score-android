package z3;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class v extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19795a;

    public v(Context context) {
        this.f19795a = context;
    }

    @Override // z3.r
    public final void H() {
        b();
        c cVarB = c.b(this.f19795a);
        GoogleSignInAccount googleSignInAccountC = cVarB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f3617q;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = cVarB.d();
        }
        y3.b bVarA = com.google.android.gms.auth.api.signin.a.a(this.f19795a, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            bVarA.b();
        } else {
            bVarA.signOut();
        }
    }

    public final void b() {
        if (j4.r.a(this.f19795a, Binder.getCallingUid())) {
            return;
        }
        throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
    }

    @Override // z3.r
    public final void p() {
        b();
        p.a(this.f19795a).b();
    }
}
