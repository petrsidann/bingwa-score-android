package u4;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbz;

/* JADX INFO: loaded from: classes.dex */
public final class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7 f16753a;

    public r6(ge geVar) {
        this.f16753a = geVar.B0();
    }

    public final Bundle a(String str, zzbz zzbzVar) {
        this.f16753a.zzl().j();
        if (zzbzVar == null) {
            this.f16753a.zzj().H().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle bundleZza = zzbzVar.zza(bundle);
            if (bundleZza != null) {
                return bundleZza;
            }
            this.f16753a.zzj().C().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e10) {
            this.f16753a.zzj().C().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            return null;
        }
    }

    public final boolean b() {
        try {
            l4.c cVarA = l4.d.a(this.f16753a.zza());
            if (cVarA != null) {
                return cVarA.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f16753a.zzj().G().a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e10) {
            this.f16753a.zzj().G().b("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
