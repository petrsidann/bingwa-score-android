package p7;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class e1 implements OnFailureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f14210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Activity f14212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f14213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f14214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j1 f14215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f14216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d0 f14217h;

    public e1(d0 d0Var, FirebaseAuth firebaseAuth, String str, Activity activity, boolean z10, boolean z11, j1 j1Var, TaskCompletionSource taskCompletionSource) {
        this.f14210a = firebaseAuth;
        this.f14211b = str;
        this.f14212c = activity;
        this.f14213d = z10;
        this.f14214e = z11;
        this.f14215f = j1Var;
        this.f14216g = taskCompletionSource;
        this.f14217h = d0Var;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        Log.e(d0.f14194b, "Failed to get reCAPTCHA enterprise token: " + exc.getMessage() + "\n\n Using fallback methods.");
        if (this.f14210a.r0().d("PHONE_PROVIDER")) {
            this.f14217h.c(this.f14210a, this.f14211b, this.f14212c, this.f14213d, this.f14214e, this.f14215f, this.f14216g);
        } else {
            this.f14216g.setResult(new u1().b());
        }
    }
}
