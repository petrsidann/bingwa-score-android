package o7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class j2 implements p7.x, p7.t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13751a;

    public j2(FirebaseAuth firebaseAuth) {
        this.f13751a = firebaseAuth;
    }

    @Override // p7.t1
    public final void a(zzagw zzagwVar, a0 a0Var) {
        this.f13751a.l0(a0Var, zzagwVar, true, true);
    }

    @Override // p7.x
    public final void zza(Status status) {
        int iT = status.T();
        if (iT == 17011 || iT == 17021 || iT == 17005) {
            this.f13751a.F();
        }
    }
}
