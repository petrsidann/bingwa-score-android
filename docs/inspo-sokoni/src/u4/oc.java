package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class oc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16632b;

    public oc(qb qbVar, me meVar) {
        this.f16631a = meVar;
        this.f16632b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f5 f5Var = this.f16632b.f16738d;
        if (f5Var == null) {
            this.f16632b.zzj().C().a("Failed to send consent settings to service");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16631a);
            f5Var.Y0(this.f16631a);
            this.f16632b.m0();
        } catch (RemoteException e10) {
            this.f16632b.zzj().C().b("Failed to send consent settings to the service", e10);
        }
    }
}
