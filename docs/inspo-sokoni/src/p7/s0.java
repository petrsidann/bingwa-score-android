package p7;

import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public abstract class s0<T> {
    public static /* synthetic */ Task a(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) com.google.android.gms.common.internal.r.l(task.getException());
        if (zzadr.zzd(exc)) {
            if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action " + String.valueOf(recaptchaAction));
            }
            if (firebaseAuth.r0() == null) {
                firebaseAuth.m0(new b1(firebaseAuth.l(), firebaseAuth));
            }
            return d(firebaseAuth.r0(), recaptchaAction, str, continuation);
        }
        Log.e("RecaptchaCallWrapper", "Initial task failed for action " + String.valueOf(recaptchaAction) + "with exception - " + exc.getMessage());
        return Tasks.forException(exc);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Task<T> d(b1 b1Var, RecaptchaAction recaptchaAction, String str, Continuation<String, Task<T>> continuation) {
        Task<String> taskB = b1Var.b(str, Boolean.FALSE, recaptchaAction);
        return taskB.continueWithTask(continuation).continueWithTask(new x0(str, b1Var, recaptchaAction, continuation));
    }

    public final Task<T> b(final FirebaseAuth firebaseAuth, final String str, final RecaptchaAction recaptchaAction, String str2) {
        final Continuation continuation = new Continuation() { // from class: p7.u0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                String str3;
                s0 s0Var = this.f14321a;
                if (task.isSuccessful()) {
                    str3 = (String) task.getResult();
                } else {
                    Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) com.google.android.gms.common.internal.r.l(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
                    str3 = "NO_RECAPTCHA";
                }
                return s0Var.c(str3);
            }
        };
        b1 b1VarR0 = firebaseAuth.r0();
        return (b1VarR0 == null || !b1VarR0.e(str2)) ? (Task<T>) c(null).continueWithTask(new Continuation() { // from class: p7.v0
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return s0.a(recaptchaAction, firebaseAuth, str, continuation, task);
            }
        }) : d(b1VarR0, recaptchaAction, str, continuation);
    }

    public abstract Task<T> c(String str);
}
