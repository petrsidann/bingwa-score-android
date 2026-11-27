package p7;

import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;

/* JADX INFO: loaded from: classes.dex */
public final class x0 implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f14337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecaptchaAction f14338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Continuation f14339d;

    public x0(String str, b1 b1Var, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.f14336a = str;
        this.f14337b = b1Var;
        this.f14338c = recaptchaAction;
        this.f14339d = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzadr.zzc((Exception) com.google.android.gms.common.internal.r.l(task.getException()))) {
            return task;
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + this.f14336a);
        }
        return this.f14337b.b(this.f14336a, Boolean.TRUE, this.f14338c).continueWithTask(this.f14339d);
    }
}
