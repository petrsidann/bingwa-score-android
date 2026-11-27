package p7;

import android.content.Context;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f14209b;

    public e0(a0 a0Var, TaskCompletionSource taskCompletionSource, Context context) {
        this.f14208a = taskCompletionSource;
        this.f14209b = context;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f14208a.setException(exc);
        a0.d(this.f14209b);
    }
}
