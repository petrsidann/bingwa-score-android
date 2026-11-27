package p7;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzae;
import com.google.android.gms.internal.p002firebaseauthapi.zzagt;
import com.google.android.gms.internal.p002firebaseauthapi.zzv;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a1 implements Continuation<zzagt, Task<RecaptchaTasksClient>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b1 f14165b;

    public a1(b1 b1Var, String str) {
        this.f14164a = str;
        this.f14165b = b1Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<RecaptchaTasksClient> then(Task<zzagt> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException(new y0((String) com.google.android.gms.common.internal.r.l(((Exception) com.google.android.gms.common.internal.r.l(task.getException())).getMessage())));
        }
        zzagt result = task.getResult();
        String strZza = result.zza();
        if (zzae.zzc(strZza)) {
            return Tasks.forException(new y0("No Recaptcha Enterprise siteKey configured for tenant/project " + this.f14164a));
        }
        List<String> listZza = zzv.zza('/').zza((CharSequence) strZza);
        String str = listZza.size() != 4 ? null : listZza.get(3);
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format " + strZza));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant " + this.f14164a);
        }
        b1 b1Var = this.f14165b;
        Task<RecaptchaTasksClient> taskA = b1Var.f14173f.a((Application) b1Var.f14171d.m(), str);
        b1.c(this.f14165b, result, taskA, this.f14164a);
        return taskA;
    }
}
