package u4;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

/* JADX INFO: loaded from: classes.dex */
public final class gc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdq f16224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qb f16225c;

    public gc(qb qbVar, me meVar, zzdq zzdqVar) {
        this.f16223a = meVar;
        this.f16224b = zzdqVar;
        this.f16225c = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strL0 = null;
        try {
            try {
                if (this.f16225c.e().I().x()) {
                    f5 f5Var = this.f16225c.f16738d;
                    if (f5Var == null) {
                        this.f16225c.zzj().C().a("Failed to get app instance id");
                    } else {
                        com.google.android.gms.common.internal.r.l(this.f16223a);
                        strL0 = f5Var.l0(this.f16223a);
                        if (strL0 != null) {
                            this.f16225c.n().Q0(strL0);
                            this.f16225c.e().f16333i.b(strL0);
                        }
                        this.f16225c.m0();
                    }
                } else {
                    this.f16225c.zzj().I().a("Analytics storage consent denied; will not get app instance id");
                    this.f16225c.n().Q0(null);
                    this.f16225c.e().f16333i.b(null);
                }
            } catch (RemoteException e10) {
                this.f16225c.zzj().C().b("Failed to get app instance id", e10);
            }
        } finally {
            this.f16225c.g().O(this.f16224b, null);
        }
    }
}
