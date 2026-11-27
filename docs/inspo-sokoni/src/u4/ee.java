package u4;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ee extends wd {
    public ee(ge geVar) {
        super(geVar);
    }

    public static boolean u(String str) {
        String strA = p0.f16679t.a(null);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        for (String str2 : strA.split(",")) {
            if (str.equalsIgnoreCase(str2.trim())) {
                return true;
            }
        }
        return false;
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ j a() {
        return super.a();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ h0 c() {
        return super.c();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ s5 d() {
        return super.d();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ we k() {
        return super.k();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ kf l() {
        return super.l();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ s m() {
        return super.m();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ u6 n() {
        return super.n();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ad o() {
        return super.o();
    }

    @Override // u4.wd
    public final /* bridge */ /* synthetic */ ee p() {
        return super.p();
    }

    public final he q(String str) {
        zzgf.zzo.zza zzaVar;
        j jVarA = a();
        d5<Boolean> d5Var = p0.K0;
        he heVar = null;
        if (!jVarA.p(d5Var)) {
            h6 h6VarQ0 = m().Q0(str);
            if (h6VarQ0 != null && s(str, h6VarQ0.m())) {
                if (h6VarQ0.C()) {
                    zzj().G().a("sgtm upload enabled in manifest.");
                    zzgc.zzd zzdVarI = n().I(h6VarQ0.l());
                    if (zzdVarI != null && zzdVarI.zzq()) {
                        String strZzf = zzdVarI.zzh().zzf();
                        if (!TextUtils.isEmpty(strZzf)) {
                            String strZzd = zzdVarI.zzh().zzd();
                            zzj().G().c("sgtm configured with upload_url, server_info", strZzf, TextUtils.isEmpty(strZzd) ? "Y" : "N");
                            if (TextUtils.isEmpty(strZzd)) {
                                heVar = new he(strZzf, fb.SGTM);
                            } else {
                                HashMap map = new HashMap();
                                map.put("x-sgtm-server-info", strZzd);
                                if (!TextUtils.isEmpty(h6VarQ0.v())) {
                                    map.put("x-gtm-server-preview", h6VarQ0.v());
                                }
                                heVar = new he(strZzf, map, fb.SGTM);
                            }
                        }
                    }
                }
                return heVar != null ? heVar : new he(t(str), fb.GOOGLE_ANALYTICS);
            }
            return new he(t(str), fb.GOOGLE_ANALYTICS);
        }
        h6 h6VarQ1 = m().Q0(str);
        if (h6VarQ1 == null || !h6VarQ1.C()) {
            return new he(t(str), fb.GOOGLE_ANALYTICS);
        }
        zzgf.zzo.zzb zzbVarZza = zzgf.zzo.zza();
        zzgf.zzo.zzd zzdVar = zzgf.zzo.zzd.GA_UPLOAD;
        zzgf.zzo.zzb zzbVarZza2 = zzbVarZza.zza(zzdVar).zza((zzgf.zzo.zza) com.google.android.gms.common.internal.r.l(zzgf.zzo.zza.zza(h6VarQ1.F())));
        if (!s(str, h6VarQ1.m())) {
            zzbVarZza2.zza(zzgf.zzo.zzc.NOT_IN_ROLLOUT);
            return new he(t(str), Collections.emptyMap(), fb.GOOGLE_ANALYTICS, (zzgf.zzo) ((zzkg) zzbVarZza2.zzaj()));
        }
        String strL = h6VarQ1.l();
        zzbVarZza2.zza(zzdVar);
        zzgc.zzd zzdVarI2 = n().I(h6VarQ1.l());
        if (zzdVarI2 == null || !zzdVarI2.zzq()) {
            zzj().G().b("[sgtm] Missing sgtm_setting in remote config. appId", strL);
            zzbVarZza2.zza(zzgf.zzo.zzc.MISSING_SGTM_SETTINGS);
        } else {
            HashMap map2 = new HashMap();
            if (!TextUtils.isEmpty(h6VarQ1.v())) {
                map2.put("x-gtm-server-preview", h6VarQ1.v());
            }
            String strZze = zzdVarI2.zzh().zze();
            zzgf.zzo.zza zzaVarZza = zzgf.zzo.zza.zza(h6VarQ1.F());
            if (zzaVarZza == null || zzaVarZza == zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE) {
                if (!a().p(d5Var)) {
                    zzaVar = zzgf.zzo.zza.SERVICE_FLAG_OFF;
                } else if (u(h6VarQ1.l())) {
                    zzaVar = zzgf.zzo.zza.PINNED_TO_SERVICE_UPLOAD;
                } else if (TextUtils.isEmpty(strZze)) {
                    zzaVar = zzgf.zzo.zza.MISSING_SGTM_SERVER_URL;
                } else {
                    zzj().G().b("[sgtm] Eligible for client side upload. appId", strL);
                    zzbVarZza2.zza(zzgf.zzo.zzd.SDK_CLIENT_UPLOAD).zza(zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE);
                    heVar = new he(strZze, map2, fb.SGTM_CLIENT, (zzgf.zzo) ((zzkg) zzbVarZza2.zzaj()));
                }
                zzbVarZza2.zza(zzaVar);
            } else {
                zzbVarZza2.zza(zzaVarZza);
            }
            zzdVarI2.zzh().zzf();
            zzdVarI2.zzh().zzd();
            if (TextUtils.isEmpty(strZze)) {
                zzbVarZza2.zza(zzgf.zzo.zzc.NON_PLAY_MISSING_SGTM_SERVER_URL);
                zzj().G().b("[sgtm] Local service, missing sgtm_server_url", h6VarQ1.l());
            } else {
                zzj().G().b("[sgtm] Eligible for local service direct upload. appId", strL);
                zzbVarZza2.zza(zzgf.zzo.zzd.SDK_SERVICE_UPLOAD).zza(zzgf.zzo.zzc.SERVICE_UPLOAD_ELIGIBLE);
                heVar = new he(strZze, map2, fb.SGTM, (zzgf.zzo) ((zzkg) zzbVarZza2.zzaj()));
            }
        }
        return heVar != null ? heVar : new he(t(str), Collections.emptyMap(), fb.GOOGLE_ANALYTICS, (zzgf.zzo) ((zzkg) zzbVarZza2.zzaj()));
    }

    public final boolean r(String str, zzgf.zzo.zza zzaVar) {
        zzgc.zzd zzdVarI;
        j();
        return a().p(p0.K0) && zzaVar == zzgf.zzo.zza.CLIENT_UPLOAD_ELIGIBLE && !u(str) && (zzdVarI = n().I(str)) != null && zzdVarI.zzq() && !zzdVarI.zzh().zze().isEmpty();
    }

    public final boolean s(String str, String str2) {
        h6 h6VarQ0;
        zzgc.zzd zzdVarI = n().I(str);
        if (zzdVarI == null || (h6VarQ0 = m().Q0(str)) == null) {
            return false;
        }
        if ((zzdVarI.zzq() && zzdVarI.zzh().zza() == 100) || g().A0(str, h6VarQ0.v())) {
            return true;
        }
        return !TextUtils.isEmpty(str2) && Math.abs(str2.hashCode() % 100) < zzdVarI.zzh().zza();
    }

    public final String t(String str) {
        String strO = n().O(str);
        if (TextUtils.isEmpty(strO)) {
            return p0.f16675r.a(null);
        }
        Uri uri = Uri.parse(p0.f16675r.a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strO + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ j4.d zzb() {
        return super.zzb();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ g zzd() {
        return super.zzd();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ v5 zzj() {
        return super.zzj();
    }

    @Override // u4.o8, u4.q8
    public final /* bridge */ /* synthetic */ d7 zzl() {
        return super.zzl();
    }
}
