package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class ec implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16168b;

    public ec(qb qbVar, me meVar) {
        this.f16167a = meVar;
        this.f16168b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f5 f5Var = this.f16168b.f16738d;
        if (f5Var == null) {
            this.f16168b.zzj().C().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16167a);
            f5Var.O0(this.f16167a);
        } catch (RemoteException e10) {
            this.f16168b.zzj().C().b("Failed to reset data on the service: remote exception", e10);
        }
        this.f16168b.m0();
    }
}
