package p7;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzadr;
import com.google.android.gms.internal.p002firebaseauthapi.zzafa;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14194b = "d0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f14195c = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f14196a;

    public static d0 b() {
        return f14195c;
    }

    public static /* synthetic */ void e(d0 d0Var, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, RecaptchaAction recaptchaAction, String str, Activity activity, boolean z10, boolean z11, j1 j1Var, Task task) {
        if (!task.isSuccessful()) {
            Log.e(f14194b, "Failed to initialize reCAPTCHA config: " + task.getException().getMessage());
        }
        if (firebaseAuth.r0() == null || !firebaseAuth.r0().e("PHONE_PROVIDER")) {
            d0Var.c(firebaseAuth, str, activity, z10, z11, j1Var, taskCompletionSource);
        } else {
            firebaseAuth.r0().b(firebaseAuth.q(), Boolean.FALSE, recaptchaAction).addOnSuccessListener(new n1(d0Var, taskCompletionSource)).addOnFailureListener(new e1(d0Var, firebaseAuth, str, activity, z10, z11, j1Var, taskCompletionSource));
        }
    }

    public static /* synthetic */ void f(d0 d0Var, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, j1 j1Var, Activity activity, Task task) {
        if ((!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) ? false : true) {
            taskCompletionSource.setResult(new u1().a(((IntegrityTokenResponse) task.getResult()).token()).b());
            return;
        }
        String message = task.getException() == null ? "" : task.getException().getMessage();
        Log.e(f14194b, "Play Integrity Token fetch failed, falling back to Recaptcha" + message);
        d0Var.d(firebaseAuth, j1Var, activity, taskCompletionSource);
    }

    public static boolean i(Exception exc) {
        if (exc instanceof o7.t) {
            return true;
        }
        return (exc instanceof o7.q) && ((o7.q) exc).a().endsWith("UNAUTHORIZED_DOMAIN");
    }

    public final Task<r1> a(final FirebaseAuth firebaseAuth, final String str, final Activity activity, final boolean z10, boolean z11, boolean z12, final RecaptchaAction recaptchaAction) {
        q1 u1Var;
        f fVar = (f) firebaseAuth.o();
        final j1 j1VarF = j1.f();
        if (!zzafm.zza(firebaseAuth.l()) && !fVar.h()) {
            String str2 = f14194b;
            Log.i(str2, "ForceRecaptchaV2Flow from phoneAuthOptions = " + z11 + ", ForceRecaptchav2Flow from firebaseSettings = " + fVar.f());
            boolean z13 = z11 || fVar.f();
            final TaskCompletionSource<r1> taskCompletionSource = new TaskCompletionSource<>();
            Task<String> taskE = j1VarF.e();
            if (taskE != null) {
                if (taskE.isSuccessful()) {
                    u1Var = new u1().d(taskE.getResult());
                } else {
                    Log.e(str2, "Error in previous reCAPTCHAV2 flow: " + taskE.getException().getMessage());
                    Log.e(str2, "Continuing with application verification as normal");
                }
            }
            if (z13 || z12) {
                c(firebaseAuth, str, activity, z10, z13, j1VarF, taskCompletionSource);
            } else {
                final boolean z14 = false;
                firebaseAuth.r().addOnCompleteListener(new OnCompleteListener() { // from class: p7.c
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        d0.e(this.f14175a, taskCompletionSource, firebaseAuth, recaptchaAction, str, activity, z10, z14, j1VarF, task);
                    }
                });
            }
            return taskCompletionSource.getTask();
        }
        u1Var = new u1();
        return Tasks.forResult(u1Var.b());
    }

    public final void c(final FirebaseAuth firebaseAuth, String str, final Activity activity, boolean z10, boolean z11, final j1 j1Var, final TaskCompletionSource<r1> taskCompletionSource) {
        if (!z10 || z11) {
            d(firebaseAuth, j1Var, activity, taskCompletionSource);
        } else {
            (!TextUtils.isEmpty(this.f14196a) ? Tasks.forResult(new zzags(this.f14196a)) : firebaseAuth.K()).continueWithTask(firebaseAuth.E0(), new m1(this, str, IntegrityManagerFactory.create(firebaseAuth.l().m()))).addOnCompleteListener(new OnCompleteListener() { // from class: p7.l1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    d0.f(this.f14276a, taskCompletionSource, firebaseAuth, j1Var, activity, task);
                }
            });
        }
    }

    public final void d(FirebaseAuth firebaseAuth, j1 j1Var, Activity activity, TaskCompletionSource<r1> taskCompletionSource) {
        Task<String> task;
        if (activity == null) {
            taskCompletionSource.setException(new o7.t());
            return;
        }
        p0.d(firebaseAuth.l().m(), firebaseAuth);
        com.google.android.gms.common.internal.r.l(activity);
        TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
        if (a0.b().h(activity, taskCompletionSource2)) {
            new zzafa(firebaseAuth, activity).zza();
            task = taskCompletionSource2.getTask();
        } else {
            task = Tasks.forException(zzadr.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        }
        task.addOnSuccessListener(new o1(this, taskCompletionSource)).addOnFailureListener(new p1(this, taskCompletionSource));
    }
}
