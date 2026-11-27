package u4;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class jc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f16403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qb f16404c;

    public jc(qb qbVar, me meVar, Bundle bundle) {
        this.f16402a = meVar;
        this.f16403b = bundle;
        this.f16404c = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f5 f5Var = this.f16404c.f16738d;
        if (f5Var == null) {
            this.f16404c.zzj().C().a("Failed to send default event parameters to service");
            return;
        }
        try {
            com.google.android.gms.common.internal.r.l(this.f16402a);
            f5Var.w0(this.f16403b, this.f16402a);
        } catch (RemoteException e10) {
            this.f16404c.zzj().C().b("Failed to send default event parameters to service", e10);
        }
    }
}
