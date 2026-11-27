package y3;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import z3.o;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.google.android.gms.common.api.e<GoogleSignInOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f19349a = new j(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f19350b = 1;

    public b(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, s3.a.f15434c, googleSignInOptions, new com.google.android.gms.common.api.e.a.C0074a().c(new com.google.android.gms.common.api.internal.a()).a());
    }

    public Task<Void> b() {
        return q.b(o.b(asGoogleApiClient(), getApplicationContext(), c() == 3));
    }

    public final synchronized int c() {
        int i10;
        i10 = f19350b;
        if (i10 == 1) {
            Context applicationContext = getApplicationContext();
            c4.e eVarN = c4.e.n();
            int iH = eVarN.h(applicationContext, 12451000);
            if (iH == 0) {
                i10 = 4;
                f19350b = 4;
            } else if (eVarN.b(applicationContext, iH, null) != null || DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                i10 = 2;
                f19350b = 2;
            } else {
                i10 = 3;
                f19350b = 3;
            }
        }
        return i10;
    }

    public Task<Void> signOut() {
        return q.b(o.c(asGoogleApiClient(), getApplicationContext(), c() == 3));
    }
}
