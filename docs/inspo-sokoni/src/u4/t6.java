package u4;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbz;

/* JADX INFO: loaded from: classes.dex */
public final class t6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbz f16827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f16828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q6 f16829c;

    public t6(q6 q6Var, zzbz zzbzVar, ServiceConnection serviceConnection) {
        this.f16827a = zzbzVar;
        this.f16828b = serviceConnection;
        this.f16829c = q6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x5 x5VarC;
        String str;
        q6 q6Var = this.f16829c;
        r6 r6Var = q6Var.f16726b;
        String str2 = q6Var.f16725a;
        zzbz zzbzVar = this.f16827a;
        ServiceConnection serviceConnection = this.f16828b;
        Bundle bundleA = r6Var.a(str2, zzbzVar);
        r6Var.f16753a.zzl().j();
        r6Var.f16753a.j();
        if (bundleA != null) {
            long j10 = bundleA.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                x5VarC = r6Var.f16753a.zzj().H();
                str = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = bundleA.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    x5VarC = r6Var.f16753a.zzj().C();
                    str = "No referrer defined in Install Referrer response";
                } else {
                    r6Var.f16753a.zzj().G().b("InstallReferrer API result", string);
                    Bundle bundleY = r6Var.f16753a.K().y(Uri.parse("?" + string));
                    if (bundleY == null) {
                        x5VarC = r6Var.f16753a.zzj().C();
                        str = "No campaign params defined in Install Referrer result";
                    } else {
                        if (bundleY.containsKey("gclid") || bundleY.containsKey("gbraid")) {
                            long j11 = bundleA.getLong("referrer_click_timestamp_server_seconds", 0L) * 1000;
                            if (j11 > 0) {
                                bundleY.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == r6Var.f16753a.C().f16332h.a()) {
                            r6Var.f16753a.zzj().G().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (r6Var.f16753a.n()) {
                            r6Var.f16753a.C().f16332h.b(j10);
                            r6Var.f16753a.zzj().G().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            bundleY.putString("_cis", "referrer API v2");
                            r6Var.f16753a.E().T("auto", "_cmp", bundleY, str2);
                        }
                    }
                }
            }
            x5VarC.a(str);
        }
        if (serviceConnection != null) {
            i4.b.b().c(r6Var.f16753a.zza(), serviceConnection);
        }
    }
}
