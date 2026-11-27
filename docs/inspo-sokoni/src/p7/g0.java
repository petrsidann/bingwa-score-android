package p7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f14229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<o7.i> f14230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseAuth f14231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o7.a0 f14232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0 f14233e;

    public g0(a0 a0Var, Activity activity, TaskCompletionSource<o7.i> taskCompletionSource, FirebaseAuth firebaseAuth, o7.a0 a0Var2) {
        this.f14233e = a0Var;
        this.f14229a = new WeakReference<>(activity);
        this.f14230b = taskCompletionSource;
        this.f14231c = firebaseAuth;
        this.f14232d = a0Var2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f14229a.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f14230b.setException(zzadr.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            a0.d(context);
            return;
        }
        if (!intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            if (k1.d(intent)) {
                this.f14230b.setException(zzadr.zza(k1.a(intent)));
                a0.d(context);
                return;
            } else {
                if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
                    this.f14230b.setException(zzadr.zza(r.a("WEB_CONTEXT_CANCELED")));
                    a0.d(context);
                    return;
                }
                return;
            }
        }
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
            a0 a0Var = this.f14233e;
            TaskCompletionSource<o7.i> taskCompletionSource = this.f14230b;
            this.f14231c.B(a0.a(intent)).addOnSuccessListener(new c0(a0Var, taskCompletionSource, context)).addOnFailureListener(new z(a0Var, taskCompletionSource, context));
            return;
        }
        if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
            a0 a0Var2 = this.f14233e;
            TaskCompletionSource<o7.i> taskCompletionSource2 = this.f14230b;
            this.f14232d.Z(a0.a(intent)).addOnSuccessListener(new f0(a0Var2, taskCompletionSource2, context)).addOnFailureListener(new b0(a0Var2, taskCompletionSource2, context));
        } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
            a0 a0Var3 = this.f14233e;
            TaskCompletionSource<o7.i> taskCompletionSource3 = this.f14230b;
            this.f14232d.a0(a0.a(intent)).addOnSuccessListener(new h0(a0Var3, taskCompletionSource3, context)).addOnFailureListener(new e0(a0Var3, taskCompletionSource3, context));
        } else {
            this.f14230b.setException(zzadr.zza(r.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        }
    }
}
