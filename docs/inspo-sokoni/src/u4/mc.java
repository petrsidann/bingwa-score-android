package u4;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

/* JADX INFO: loaded from: classes.dex */
public final class mc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f16523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzdq f16525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ qb f16526d;

    public mc(qb qbVar, n0 n0Var, String str, zzdq zzdqVar) {
        this.f16523a = n0Var;
        this.f16524b = str;
        this.f16525c = zzdqVar;
        this.f16526d = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrW = null;
        try {
            try {
                f5 f5Var = this.f16526d.f16738d;
                if (f5Var == null) {
                    this.f16526d.zzj().C().a("Discarding data. Failed to send event to service to bundle");
                } else {
                    bArrW = f5Var.W(this.f16523a, this.f16524b);
                    this.f16526d.m0();
                }
            } catch (RemoteException e10) {
                this.f16526d.zzj().C().b("Failed to send event to the service to bundle", e10);
            }
        } finally {
            this.f16526d.g().R(this.f16525c, bArrW);
        }
    }
}
