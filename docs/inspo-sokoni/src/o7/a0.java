package o7;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.internal.p002firebaseauthapi.zzagw;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends d4.a implements b1 {
    @Override // o7.b1
    public abstract String P();

    public Task<Void> S() {
        return FirebaseAuth.getInstance(n0()).R(this);
    }

    public Task<c0> T(boolean z10) {
        return FirebaseAuth.getInstance(n0()).Y(this, z10);
    }

    public abstract b0 U();

    public abstract h0 V();

    public abstract List<? extends b1> W();

    public abstract String X();

    public abstract boolean Y();

    public Task<i> Z(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        return FirebaseAuth.getInstance(n0()).T(this, hVar);
    }

    public Task<i> a0(h hVar) {
        com.google.android.gms.common.internal.r.l(hVar);
        return FirebaseAuth.getInstance(n0()).w0(this, hVar);
    }

    public Task<Void> b0() {
        return FirebaseAuth.getInstance(n0()).o0(this);
    }

    public Task<Void> c0() {
        return FirebaseAuth.getInstance(n0()).Y(this, false).continueWithTask(new h1(this));
    }

    public Task<Void> d0(e eVar) {
        return FirebaseAuth.getInstance(n0()).Y(this, false).continueWithTask(new j1(this, eVar));
    }

    public Task<i> e0(Activity activity, n nVar) {
        com.google.android.gms.common.internal.r.l(activity);
        com.google.android.gms.common.internal.r.l(nVar);
        return FirebaseAuth.getInstance(n0()).L(activity, nVar, this);
    }

    public Task<i> f0(Activity activity, n nVar) {
        com.google.android.gms.common.internal.r.l(activity);
        com.google.android.gms.common.internal.r.l(nVar);
        return FirebaseAuth.getInstance(n0()).n0(activity, nVar, this);
    }

    public Task<i> g0(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return FirebaseAuth.getInstance(n0()).p0(this, str);
    }

    @Override // o7.b1
    public abstract String h();

    @Deprecated
    public Task<Void> h0(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return FirebaseAuth.getInstance(n0()).v0(this, str);
    }

    public Task<Void> i0(String str) {
        com.google.android.gms.common.internal.r.f(str);
        return FirebaseAuth.getInstance(n0()).y0(this, str);
    }

    @Override // o7.b1
    public abstract Uri j();

    public Task<Void> j0(o0 o0Var) {
        return FirebaseAuth.getInstance(n0()).V(this, o0Var);
    }

    public Task<Void> k0(c1 c1Var) {
        com.google.android.gms.common.internal.r.l(c1Var);
        return FirebaseAuth.getInstance(n0()).W(this, c1Var);
    }

    public Task<Void> l0(String str) {
        return m0(str, null);
    }

    public Task<Void> m0(String str, e eVar) {
        return FirebaseAuth.getInstance(n0()).Y(this, false).continueWithTask(new i1(this, str, eVar));
    }

    public abstract h7.f n0();

    public abstract a0 o0(List<? extends b1> list);

    public abstract void p0(zzagw zzagwVar);

    public abstract a0 q0();

    @Override // o7.b1
    public abstract String r();

    public abstract void r0(List<m1> list);

    public abstract zzagw s0();

    public abstract void t0(List<j0> list);

    public abstract List<m1> u0();

    @Override // o7.b1
    public abstract String w();

    public abstract String zzd();

    public abstract String zze();

    public abstract List<String> zzg();
}
