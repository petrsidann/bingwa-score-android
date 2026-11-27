package p7;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;

/* JADX INFO: loaded from: classes.dex */
public final class d1 implements Continuation<RecaptchaTasksClient, Task<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecaptchaAction f14197a;

    public d1(b1 b1Var, RecaptchaAction recaptchaAction) {
        this.f14197a = recaptchaAction;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<String> then(Task<RecaptchaTasksClient> task) {
        if (task.isSuccessful()) {
            return task.getResult().executeTask(this.f14197a);
        }
        Exception exc = (Exception) com.google.android.gms.common.internal.r.l(task.getException());
        if (!(exc instanceof y0)) {
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - " + exc.getMessage());
        }
        return Tasks.forResult("");
    }
}
