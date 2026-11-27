package p7;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements OnSuccessListener<o7.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f14185b;

    public c0(a0 a0Var, TaskCompletionSource taskCompletionSource, Context context) {
        this.f14184a = taskCompletionSource;
        this.f14185b = context;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final /* synthetic */ void onSuccess(o7.i iVar) {
        this.f14184a.setResult(iVar);
        a0.d(this.f14185b);
    }
}
