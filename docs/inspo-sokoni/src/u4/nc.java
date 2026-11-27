package u4;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class nc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ me f16610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f16611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n0 f16612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f16613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ qb f16614f;

    public nc(qb qbVar, boolean z10, me meVar, boolean z11, n0 n0Var, String str) {
        this.f16609a = z10;
        this.f16610b = meVar;
        this.f16611c = z11;
        this.f16612d = n0Var;
        this.f16613e = str;
        this.f16614f = qbVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        long jB;
        long j10;
        long jA;
        f5 f5Var = this.f16614f.f16738d;
        if (f5Var == null) {
            this.f16614f.zzj().C().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f16609a) {
            com.google.android.gms.common.internal.r.l(this.f16610b);
            this.f16614f.O(f5Var, this.f16611c ? null : this.f16612d, this.f16610b);
        } else {
            boolean zP = this.f16614f.a().p(p0.P0);
            try {
                if (TextUtils.isEmpty(this.f16613e)) {
                    com.google.android.gms.common.internal.r.l(this.f16610b);
                    if (zP) {
                        jA = this.f16614f.f16624a.zzb().a();
                        try {
                            jB = this.f16614f.f16624a.zzb().b();
                        } catch (RemoteException e10) {
                            e = e10;
                            jB = 0;
                            j10 = jA;
                            this.f16614f.zzj().C().b("Failed to send event to the service", e);
                            if (zP && j10 != 0) {
                                t5.a(this.f16614f.f16624a).b(36301, 13, j10, this.f16614f.f16624a.zzb().a(), (int) (this.f16614f.f16624a.zzb().b() - jB));
                            }
                            this.f16614f.m0();
                        }
                    } else {
                        jA = 0;
                        jB = 0;
                    }
                    try {
                        f5Var.Y(this.f16612d, this.f16610b);
                        if (zP) {
                            this.f16614f.zzj().G().a("Logging telemetry for logEvent");
                            t5.a(this.f16614f.f16624a).b(36301, 0, jA, this.f16614f.f16624a.zzb().a(), (int) (this.f16614f.f16624a.zzb().b() - jB));
                        }
                    } catch (RemoteException e11) {
                        e = e11;
                        j10 = jA;
                        this.f16614f.zzj().C().b("Failed to send event to the service", e);
                        if (zP) {
                            t5.a(this.f16614f.f16624a).b(36301, 13, j10, this.f16614f.f16624a.zzb().a(), (int) (this.f16614f.f16624a.zzb().b() - jB));
                        }
                    }
                } else {
                    f5Var.c0(this.f16612d, this.f16613e, this.f16614f.zzj().K());
                }
            } catch (RemoteException e12) {
                e = e12;
                jB = 0;
                j10 = 0;
            }
        }
        this.f16614f.m0();
    }
}
