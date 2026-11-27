package p7;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m extends o7.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f14281a;

    public m(i iVar) {
        com.google.android.gms.common.internal.r.l(iVar);
        this.f14281a = iVar;
    }

    @Override // o7.h0
    public final Task<Void> a(o7.i0 i0Var, String str) {
        com.google.android.gms.common.internal.r.l(i0Var);
        i iVar = this.f14281a;
        return FirebaseAuth.getInstance(iVar.n0()).U(iVar, i0Var, str);
    }

    @Override // o7.h0
    public final List<o7.j0> b() {
        return this.f14281a.A0();
    }

    @Override // o7.h0
    public final Task<o7.l0> c() {
        return this.f14281a.T(false).continueWithTask(new l(this));
    }

    @Override // o7.h0
    public final Task<Void> d(String str) {
        com.google.android.gms.common.internal.r.f(str);
        i iVar = this.f14281a;
        return FirebaseAuth.getInstance(iVar.n0()).S(iVar, str);
    }
}
