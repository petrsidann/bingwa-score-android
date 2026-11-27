package u4;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class qc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16744a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f16745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f16747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f16748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ qb f16749f;

    public qc(qb qbVar, boolean z10, me meVar, boolean z11, h hVar, h hVar2) {
        this.f16745b = meVar;
        this.f16746c = z11;
        this.f16747d = hVar;
        this.f16748e = hVar2;
        this.f16749f = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        f5 f5Var = this.f16749f.f16738d;
        if (f5Var == null) {
            this.f16749f.zzj().C().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f16744a) {
            com.google.android.gms.common.internal.r.l(this.f16745b);
            this.f16749f.O(f5Var, this.f16746c ? null : this.f16747d, this.f16745b);
        } else {
            try {
                if (TextUtils.isEmpty(this.f16748e.f16265a)) {
                    com.google.android.gms.common.internal.r.l(this.f16745b);
                    f5Var.A(this.f16747d, this.f16745b);
                } else {
                    f5Var.j0(this.f16747d);
                }
            } catch (RemoteException e10) {
                this.f16749f.zzj().C().b("Failed to send conditional user property to the service", e10);
            }
        }
        this.f16749f.m0();
    }
}
