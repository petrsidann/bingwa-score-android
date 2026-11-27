package o7;

import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class i2 implements Continuation<RecaptchaTasksClient, Task<Void>> {
    public i2(FirebaseAuth firebaseAuth) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<RecaptchaTasksClient> task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new q("INTERNAL_ERROR", zzae.zzb(exception != null ? exception.getMessage() : "")));
    }
}
