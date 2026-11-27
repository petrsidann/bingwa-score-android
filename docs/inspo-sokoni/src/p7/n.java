package p7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Continuation<o7.i, Task<o7.i>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f14286a;

    public n(o oVar) {
        this.f14286a = oVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<o7.i> then(Task<o7.i> task) {
        if (this.f14286a.f14293d == null) {
            return task;
        }
        if (task.isSuccessful()) {
            o7.i result = task.getResult();
            return Tasks.forResult(new h2((i) result.N(), (f2) result.A(), this.f14286a.f14293d));
        }
        Exception exception = task.getException();
        if (exception instanceof o7.x) {
            ((o7.x) exception).e(this.f14286a.f14293d);
        }
        return Tasks.forException(exception);
    }
}
