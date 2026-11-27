package p7;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class p1 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14308a;

    public p1(d0 d0Var, TaskCompletionSource taskCompletionSource) {
        this.f14308a = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(d0.f14194b, String.format("Failed to get reCAPTCHA token with error [%s]- calling backend without app verification", exc.getMessage()));
        if ((exc instanceof o7.q) && ((o7.q) exc).a().endsWith("UNAUTHORIZED_DOMAIN")) {
            this.f14308a.setException(exc);
        } else {
            this.f14308a.setResult(new u1().b());
        }
    }
}
