package p7;

import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.internal.p002firebaseauthapi.zzagt;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Task<RecaptchaTasksClient>> f14169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzagt f14170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h7.f f14171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FirebaseAuth f14172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f14173f;

    public b1(h7.f fVar, FirebaseAuth firebaseAuth) {
        this(fVar, firebaseAuth, new z0());
    }

    public b1(h7.f fVar, FirebaseAuth firebaseAuth, w0 w0Var) {
        this.f14168a = new Object();
        this.f14169b = new HashMap();
        this.f14171d = fVar;
        this.f14172e = firebaseAuth;
        this.f14173f = w0Var;
    }

    public static /* synthetic */ void c(b1 b1Var, zzagt zzagtVar, Task task, String str) {
        synchronized (b1Var.f14168a) {
            b1Var.f14170c = zzagtVar;
            b1Var.f14169b.put(str, task);
        }
    }

    public static String g(String str) {
        return zzae.zzc(str) ? "*" : str;
    }

    public final Task<RecaptchaTasksClient> a(String str, Boolean bool) {
        Task<RecaptchaTasksClient> taskF;
        String strG = g(str);
        return (bool.booleanValue() || (taskF = f(strG)) == null) ? this.f14172e.M("RECAPTCHA_ENTERPRISE").continueWithTask(new a1(this, strG)) : taskF;
    }

    public final Task<String> b(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        String strG = g(str);
        Task<RecaptchaTasksClient> taskF = f(strG);
        if (bool.booleanValue() || taskF == null) {
            taskF = a(strG, bool);
        }
        return taskF.continueWithTask(new d1(this, recaptchaAction));
    }

    public final boolean d(String str) {
        String strZzb;
        com.google.android.gms.common.internal.r.l(str);
        zzagt zzagtVar = this.f14170c;
        if (zzagtVar == null || (strZzb = zzagtVar.zzb(str)) == null) {
            return false;
        }
        return strZzb.equals("AUDIT");
    }

    public final boolean e(String str) {
        boolean z10;
        synchronized (this.f14168a) {
            zzagt zzagtVar = this.f14170c;
            z10 = zzagtVar != null && zzagtVar.zzc(str);
        }
        return z10;
    }

    public final Task<RecaptchaTasksClient> f(String str) {
        Task<RecaptchaTasksClient> task;
        synchronized (this.f14168a) {
            task = this.f14169b.get(str);
        }
        return task;
    }
}
