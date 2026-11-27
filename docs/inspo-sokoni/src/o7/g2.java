package o7;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: loaded from: classes.dex */
public final class g2 implements p7.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f13737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseAuth f13738b;

    public g2(FirebaseAuth firebaseAuth, a0 a0Var) {
        this.f13737a = a0Var;
        this.f13738b = firebaseAuth;
    }

    @Override // p7.y
    public final void zza() {
        if (this.f13738b.f5384f == null || !this.f13738b.f5384f.h().equalsIgnoreCase(this.f13737a.h())) {
            return;
        }
        this.f13738b.I0();
    }

    @Override // p7.x
    public final void zza(Status status) {
        if (status.T() == 17011 || status.T() == 17021 || status.T() == 17005) {
            this.f13738b.F();
        }
    }
}
