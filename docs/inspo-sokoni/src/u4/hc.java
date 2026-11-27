package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class hc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16318b;

    public hc(qb qbVar, me meVar) {
        this.f16317a = meVar;
        this.f16318b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f5 f5Var = this.f16318b.f16738d;
        if (f5Var == null) {
            this.f16318b.zzj().H().a("Failed to send app backgrounded");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16317a);
            f5Var.t0(this.f16317a);
            this.f16318b.m0();
        } catch (RemoteException e10) {
            this.f16318b.zzj().C().b("Failed to send app backgrounded to the service", e10);
        }
    }
}
