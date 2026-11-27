package o7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class e2 implements Continuation<Void, Task<Void>> {
    public e2(FirebaseAuth firebaseAuth) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<Void> task) {
        return (!task.isSuccessful() && (task.getException() instanceof q) && ((q) task.getException()).a().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? Tasks.forResult(null) : task;
    }
}
