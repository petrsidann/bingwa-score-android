package u4;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

/* JADX INFO: loaded from: classes.dex */
public final class yb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ me f16986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f16987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzdq f16988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ qb f16989f;

    public yb(qb qbVar, String str, String str2, me meVar, boolean z10, zzdq zzdqVar) {
        this.f16984a = str;
        this.f16985b = str2;
        this.f16986c = meVar;
        this.f16987d = z10;
        this.f16988e = zzdqVar;
        this.f16989f = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                f5 f5Var = this.f16989f.f16738d;
                if (f5Var == null) {
                    this.f16989f.zzj().C().c("Failed to get user properties; not connected to service", this.f16984a, this.f16985b);
                } else {
                    com.google.android.gms.common.internal.r.l(this.f16986c);
                    bundle = af.C(f5Var.U0(this.f16984a, this.f16985b, this.f16987d, this.f16986c));
                    this.f16989f.m0();
                }
            } catch (RemoteException e10) {
                this.f16989f.zzj().C().c("Failed to get user properties; remote exception", this.f16984a, e10);
            }
        } finally {
            this.f16989f.g().N(this.f16988e, bundle);
        }
    }
}
