package o7;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class i1 implements Continuation<c0, Task<Void>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f13742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f13743c;

    public i1(a0 a0Var, String str, e eVar) {
        this.f13741a = str;
        this.f13742b = eVar;
        this.f13743c = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<c0> task) {
        return FirebaseAuth.getInstance(this.f13743c.n0()).O((String) com.google.android.gms.common.internal.r.l(task.getResult().g()), this.f13741a, this.f13742b);
    }
}
