package z3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lock f19778c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f19779d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lock f19780a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f19781b;

    public c(Context context) {
        this.f19781b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static c b(Context context) {
        com.google.android.gms.common.internal.r.l(context);
        f19778c.lock();
        try {
            if (f19779d == null) {
                f19779d = new c(context.getApplicationContext());
            }
            return f19779d;
        } finally {
            f19778c.unlock();
        }
    }

    public static final String i(String str, String str2) {
        return str + ":" + str2;
    }

    public void a() {
        this.f19780a.lock();
        try {
            this.f19781b.edit().clear().apply();
        } finally {
            this.f19780a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInAccount", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.Z(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public GoogleSignInOptions d() {
        String strG;
        String strG2 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strG2) || (strG = g(i("googleSignInOptions", strG2))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.a0(strG);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String e() {
        return g("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        com.google.android.gms.common.internal.r.l(googleSignInAccount);
        com.google.android.gms.common.internal.r.l(googleSignInOptions);
        h("defaultGoogleSignInAccount", googleSignInAccount.a0());
        com.google.android.gms.common.internal.r.l(googleSignInAccount);
        com.google.android.gms.common.internal.r.l(googleSignInOptions);
        String strA0 = googleSignInAccount.a0();
        h(i("googleSignInAccount", strA0), googleSignInAccount.b0());
        h(i("googleSignInOptions", strA0), googleSignInOptions.e0());
    }

    public final String g(String str) {
        this.f19780a.lock();
        try {
            return this.f19781b.getString(str, null);
        } finally {
            this.f19780a.unlock();
        }
    }

    public final void h(String str, String str2) {
        this.f19780a.lock();
        try {
            this.f19781b.edit().putString(str, str2).apply();
        } finally {
            this.f19780a.unlock();
        }
    }
}
