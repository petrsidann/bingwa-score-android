package u4;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public final class kc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hb f16462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ qb f16463b;

    public kc(qb qbVar, hb hbVar) {
        this.f16462a = hbVar;
        this.f16463b = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j10;
        String str;
        String str2;
        String packageName;
        f5 f5Var = this.f16463b.f16738d;
        if (f5Var == null) {
            this.f16463b.zzj().C().a("Failed to send current screen to service");
            return;
        }
        try {
            hb hbVar = this.f16462a;
            if (hbVar == null) {
                j10 = 0;
                str = null;
                str2 = null;
                packageName = this.f16463b.zza().getPackageName();
            } else {
                j10 = hbVar.f16313c;
                str = hbVar.f16311a;
                str2 = hbVar.f16312b;
                packageName = this.f16463b.zza().getPackageName();
            }
            f5Var.f0(j10, str, str2, packageName);
            this.f16463b.m0();
        } catch (RemoteException e10) {
            this.f16463b.zzj().C().b("Failed to send current screen to the service", e10);
        }
    }
}
