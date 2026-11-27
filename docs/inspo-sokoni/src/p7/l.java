package p7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Continuation<o7.c0, Task<o7.l0>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f14274a;

    public l(m mVar) {
        this.f14274a = mVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<o7.l0> then(Task<o7.c0> task) {
        return !task.isSuccessful() ? Tasks.forException(task.getException()) : Tasks.forResult(p.T(task.getResult().g(), this.f14274a.f14281a));
    }
}
