package p7;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Continuation<zzags, Task<IntegrityTokenResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f14283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntegrityManager f14284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f14285c;

    public m1(d0 d0Var, String str, IntegrityManager integrityManager) {
        this.f14283a = str;
        this.f14284b = integrityManager;
        this.f14285c = d0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<IntegrityTokenResponse> then(Task<zzags> task) {
        if (task.isSuccessful()) {
            this.f14285c.f14196a = task.getResult().zza();
            return this.f14284b.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(task.getResult().zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.f14283a.getBytes("UTF-8")), 11))).build());
        }
        Log.e(d0.f14194b, "Problem retrieving Play Integrity producer project:  " + task.getException().getMessage());
        return Tasks.forException(task.getException());
    }
}
