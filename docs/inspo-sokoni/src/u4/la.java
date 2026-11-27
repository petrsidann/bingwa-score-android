package u4;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzdq;

/* JADX INFO: loaded from: classes.dex */
public final class la implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdq f16488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16489b;

    public la(e9 e9Var, zzdq zzdqVar) {
        this.f16488a = zzdqVar;
        this.f16489b = e9Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0057  */
    /* JADX WARN: Code duplicated, block: B:20:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Long lValueOf;
        id idVarR = this.f16489b.r();
        if (idVarR.e().I().x()) {
            if (!idVarR.e().u(idVarR.zzb().a()) && idVarR.e().f16343s.a() != 0) {
                lValueOf = Long.valueOf(idVarR.e().f16343s.a());
            }
            if (lValueOf != null) {
                this.f16489b.f16624a.K().M(this.f16488a, lValueOf.longValue());
            }
            try {
                this.f16488a.zza(null);
            } catch (RemoteException e10) {
                this.f16489b.f16624a.zzj().C().b("getSessionId failed with exception", e10);
                return;
            }
        }
        idVarR.zzj().I().a("Analytics storage consent denied; will not get session id");
        lValueOf = null;
        if (lValueOf != null) {
            this.f16489b.f16624a.K().M(this.f16488a, lValueOf.longValue());
        } else {
            this.f16488a.zza(null);
        }
    }
}
