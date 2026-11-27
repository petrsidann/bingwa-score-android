package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class fc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16201b;

    public fc(qb qbVar, me meVar) {
        this.f16200a = meVar;
        this.f16201b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        f5 f5Var = this.f16201b.f16738d;
        if (f5Var == null) {
            this.f16201b.zzj().C().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16200a);
            f5Var.C0(this.f16200a);
            this.f16201b.m().G();
            this.f16201b.O(f5Var, null, this.f16200a);
            this.f16201b.m0();
        } catch (RemoteException e10) {
            this.f16201b.zzj().C().b("Failed to send app launch to the service", e10);
        }
    }
}
