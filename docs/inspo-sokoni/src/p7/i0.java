package p7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f14255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<String> f14256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f14257c;

    public i0(a0 a0Var, Activity activity, TaskCompletionSource<String> taskCompletionSource) {
        this.f14257c = a0Var;
        this.f14255a = new WeakReference<>(activity);
        this.f14256b = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f14255a.get() == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f14256b.setException(zzadr.zza(new Status(17499, "Activity that started the web operation is no longer alive; see logcat for details")));
            a0.d(context);
            return;
        }
        if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                a0.e(this.f14257c, intent, this.f14256b, context);
                return;
            }
            this.f14256b.setException(zzadr.zza(r.a("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
            return;
        }
        if (k1.d(intent)) {
            this.f14256b.setException(zzadr.zza(k1.a(intent)));
            a0.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.f14256b.setException(zzadr.zza(r.a("WEB_CONTEXT_CANCELED")));
            a0.d(context);
        }
    }
}
