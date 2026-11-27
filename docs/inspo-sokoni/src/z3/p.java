package z3;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f19791d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f19792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GoogleSignInAccount f19793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GoogleSignInOptions f19794c;

    public p(Context context) {
        c cVarB = c.b(context);
        this.f19792a = cVarB;
        this.f19793b = cVarB.c();
        this.f19794c = cVarB.d();
    }

    public static synchronized p a(Context context) {
        return d(context.getApplicationContext());
    }

    public static synchronized p d(Context context) {
        p pVar = f19791d;
        if (pVar != null) {
            return pVar;
        }
        p pVar2 = new p(context);
        f19791d = pVar2;
        return pVar2;
    }

    public final synchronized void b() {
        this.f19792a.a();
        this.f19793b = null;
        this.f19794c = null;
    }

    public final synchronized void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f19792a.f(googleSignInAccount, googleSignInOptions);
        this.f19793b = googleSignInAccount;
        this.f19794c = googleSignInOptions;
    }
}
