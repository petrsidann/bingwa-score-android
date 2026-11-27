package o7;

import com.google.android.gms.internal.p002firebaseauthapi.zzahs;
import com.google.android.gms.internal.p002firebaseauthapi.zzahy;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class h2 implements Continuation<zzahs, Task<y0>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13740a;

    public h2(FirebaseAuth firebaseAuth) {
        this.f13740a = firebaseAuth;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<y0> then(Task<zzahs> task) {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) com.google.android.gms.common.internal.r.l(task.getException()));
        }
        zzahs result = task.getResult();
        if (result instanceof zzahy) {
            zzahy zzahyVar = (zzahy) result;
            return Tasks.forResult(new p7.i1(com.google.android.gms.common.internal.r.f(zzahyVar.zzf()), com.google.android.gms.common.internal.r.f(zzahyVar.zze()), zzahyVar.zzc(), zzahyVar.zzb(), zzahyVar.zzd(), com.google.android.gms.common.internal.r.f(zzahyVar.zza()), this.f13740a));
        }
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + result.getClass().getName() + ".");
    }
}
