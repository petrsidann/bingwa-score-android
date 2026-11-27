package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class lc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16495b;

    public lc(qb qbVar, me meVar) {
        this.f16494a = meVar;
        this.f16495b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f5 f5Var = this.f16495b.f16738d;
        if (f5Var == null) {
            this.f16495b.zzj().C().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16494a);
            f5Var.F(this.f16494a);
            this.f16495b.m0();
        } catch (RemoteException e10) {
            this.f16495b.zzj().C().b("Failed to send measurementEnabled to the service", e10);
        }
    }
}
