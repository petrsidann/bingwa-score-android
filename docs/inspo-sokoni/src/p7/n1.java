package p7;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class n1 implements OnSuccessListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14289a;

    public n1(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        this.f14289a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(String str) {
        this.f14289a.setResult(new u1().c(str).b());
    }
}
