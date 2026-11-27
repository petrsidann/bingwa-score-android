package o7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class j1 implements Continuation<c0, Task<Void>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f13749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f13750b;

    public j1(a0 a0Var, e eVar) {
        this.f13749a = eVar;
        this.f13750b = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<c0> task) {
        return FirebaseAuth.getInstance(this.f13750b.n0()).P(this.f13749a, (String) com.google.android.gms.common.internal.r.l(task.getResult().g()));
    }
}
