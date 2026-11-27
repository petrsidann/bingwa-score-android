package p7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.p002firebaseauthapi.zzaic;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a0 f14161c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14162a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BroadcastReceiver f14163b;

    public static o7.h a(Intent intent) {
        com.google.android.gms.common.internal.r.l(intent);
        return o7.x1.Z(((zzaic) d4.e.b(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzaic.CREATOR)).zzc(true));
    }

    public static a0 b() {
        if (f14161c == null) {
            f14161c = new a0();
        }
        return f14161c;
    }

    public static void d(Context context) {
        a0 a0Var = f14161c;
        a0Var.f14162a = false;
        if (a0Var.f14163b != null) {
            q1.a.b(context).e(f14161c.f14163b);
        }
        f14161c.f14163b = null;
    }

    public static /* synthetic */ void e(a0 a0Var, Intent intent, TaskCompletionSource taskCompletionSource, Context context) {
        taskCompletionSource.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
        d(context);
    }

    public final void c(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f14163b = broadcastReceiver;
        q1.a.b(activity).c(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    public final boolean h(Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        if (this.f14162a) {
            return false;
        }
        c(activity, new i0(this, activity, taskCompletionSource));
        this.f14162a = true;
        return true;
    }

    public final boolean i(Activity activity, TaskCompletionSource<o7.i> taskCompletionSource, FirebaseAuth firebaseAuth) {
        return j(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean j(Activity activity, TaskCompletionSource<o7.i> taskCompletionSource, FirebaseAuth firebaseAuth, o7.a0 a0Var) {
        if (this.f14162a) {
            return false;
        }
        c(activity, new g0(this, activity, taskCompletionSource, firebaseAuth, a0Var));
        this.f14162a = true;
        return true;
    }
}
