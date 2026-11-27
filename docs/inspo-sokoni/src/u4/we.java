package u4;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzad;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzlp;
import com.google.android.gms.internal.measurement.zzoy;
import com.google.android.gms.internal.measurement.zzpf;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class we extends fe {
    public we(ge geVar) {
        super(geVar);
    }

    public static zzgf.zzh B(zzgf.zzf zzfVar, String str) {
        for (zzgf.zzh zzhVar : zzfVar.zzh()) {
            if (zzhVar.zzg().equals(str)) {
                return zzhVar;
            }
        }
        return null;
    }

    public static <BuilderT extends zzlp> BuilderT C(BuilderT buildert, byte[] bArr) {
        zzjt zzjtVarZza = zzjt.zza();
        return zzjtVarZza != null ? (BuilderT) buildert.zza(bArr, zzjtVarZza) : (BuilderT) buildert.zza(bArr);
    }

    public static Object D(zzgf.zzf zzfVar, String str, Object obj) {
        Object objB0 = b0(zzfVar, str);
        return objB0 == null ? obj : objB0;
    }

    public static String H(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("Dynamic ");
        }
        if (z11) {
            sb2.append("Sequence ");
        }
        if (z12) {
            sb2.append("Session-Scoped ");
        }
        return sb2.toString();
    }

    public static List<Long> I(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static void N(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static void O(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                N(builder, str3, string, set);
            }
        }
    }

    public static void P(zzgf.zzf.zza zzaVar, String str, Object obj) {
        List<zzgf.zzh> listZzf = zzaVar.zzf();
        int i10 = 0;
        while (true) {
            if (i10 >= listZzf.size()) {
                i10 = -1;
                break;
            } else if (str.equals(listZzf.get(i10).zzg())) {
                break;
            } else {
                i10++;
            }
        }
        zzgf.zzh.zza zzaVarZza = zzgf.zzh.zze().zza(str);
        if (obj instanceof Long) {
            zzaVarZza.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzaVarZza.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzaVarZza.zza(((Double) obj).doubleValue());
        }
        if (i10 >= 0) {
            zzaVar.zza(i10, zzaVarZza);
        } else {
            zzaVar.zza(zzaVarZza);
        }
    }

    public static void S(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
    }

    public static void U(StringBuilder sb2, int i10, String str, zzfw.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        S(sb2, i10);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzdVar.zzh()) {
            W(sb2, i10, "comparison_type", zzdVar.zza().name());
        }
        if (zzdVar.zzj()) {
            W(sb2, i10, "match_as_float", Boolean.valueOf(zzdVar.zzg()));
        }
        if (zzdVar.zzi()) {
            W(sb2, i10, "comparison_value", zzdVar.zzd());
        }
        if (zzdVar.zzl()) {
            W(sb2, i10, "min_comparison_value", zzdVar.zzf());
        }
        if (zzdVar.zzk()) {
            W(sb2, i10, "max_comparison_value", zzdVar.zze());
        }
        S(sb2, i10);
        sb2.append("}\n");
    }

    public static void V(StringBuilder sb2, int i10, String str, zzgf.zzm zzmVar) {
        if (zzmVar == null) {
            return;
        }
        S(sb2, 3);
        sb2.append(str);
        sb2.append(" {\n");
        if (zzmVar.zzb() != 0) {
            S(sb2, 4);
            sb2.append("results: ");
            int i11 = 0;
            for (Long l10 : zzmVar.zzi()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l10);
                i11 = i12;
            }
            sb2.append('\n');
        }
        if (zzmVar.zzd() != 0) {
            S(sb2, 4);
            sb2.append("status: ");
            int i13 = 0;
            for (Long l11 : zzmVar.zzk()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb2.append(", ");
                }
                sb2.append(l11);
                i13 = i14;
            }
            sb2.append('\n');
        }
        if (zzmVar.zza() != 0) {
            S(sb2, 4);
            sb2.append("dynamic_filter_timestamps: {");
            int i15 = 0;
            for (zzgf.zze zzeVar : zzmVar.zzh()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zzeVar.zzf() ? Integer.valueOf(zzeVar.zza()) : null);
                sb2.append(":");
                sb2.append(zzeVar.zze() ? Long.valueOf(zzeVar.zzb()) : null);
                i15 = i16;
            }
            sb2.append("}\n");
        }
        if (zzmVar.zzc() != 0) {
            S(sb2, 4);
            sb2.append("sequence_filter_timestamps: {");
            int i17 = 0;
            for (zzgf.zzn zznVar : zzmVar.zzj()) {
                int i18 = i17 + 1;
                if (i17 != 0) {
                    sb2.append(", ");
                }
                sb2.append(zznVar.zzf() ? Integer.valueOf(zznVar.zzb()) : null);
                sb2.append(": [");
                Iterator<Long> it = zznVar.zze().iterator();
                int i19 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i20 = i19 + 1;
                    if (i19 != 0) {
                        sb2.append(", ");
                    }
                    sb2.append(jLongValue);
                    i19 = i20;
                }
                sb2.append("]");
                i17 = i18;
            }
            sb2.append("}\n");
        }
        S(sb2, 3);
        sb2.append("}\n");
    }

    public static void W(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        S(sb2, i10 + 1);
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        sb2.append('\n');
    }

    public static boolean Z(List<Long> list, int i10) {
        if (i10 < (list.size() << 6)) {
            return ((1 << (i10 % 64)) & list.get(i10 / 64).longValue()) != 0;
        }
        return false;
    }

    public static boolean a0(n0 n0Var, me meVar) {
        com.google.android.gms.common.internal.r.l(n0Var);
        com.google.android.gms.common.internal.r.l(meVar);
        return (TextUtils.isEmpty(meVar.f16529b) && TextUtils.isEmpty(meVar.f16543u)) ? false : true;
    }

    public static Object b0(zzgf.zzf zzfVar, String str) {
        zzgf.zzh zzhVarB = B(zzfVar, str);
        if (zzhVarB == null) {
            return null;
        }
        if (zzhVarB.zzn()) {
            return zzhVarB.zzh();
        }
        if (zzhVarB.zzl()) {
            return Long.valueOf(zzhVarB.zzd());
        }
        if (zzhVarB.zzj()) {
            return Double.valueOf(zzhVarB.zza());
        }
        if (zzhVarB.zzc() > 0) {
            return e0(zzhVarB.zzi());
        }
        return null;
    }

    public static boolean c0(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static Bundle[] e0(List<zzgf.zzh> list) {
        ArrayList arrayList = new ArrayList();
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                Bundle bundle = new Bundle();
                for (zzgf.zzh zzhVar2 : zzhVar.zzi()) {
                    if (zzhVar2.zzn()) {
                        bundle.putString(zzhVar2.zzg(), zzhVar2.zzh());
                    } else if (zzhVar2.zzl()) {
                        bundle.putLong(zzhVar2.zzg(), zzhVar2.zzd());
                    } else if (zzhVar2.zzj()) {
                        bundle.putDouble(zzhVar2.zzg(), zzhVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int u(zzgf.zzk.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < zzaVar.zzd(); i10++) {
            if (str.equals(zzaVar.zzk(i10).zzg())) {
                return i10;
            }
        }
        return -1;
    }

    public static Bundle x(List<zzgf.zzh> list) {
        Bundle bundle = new Bundle();
        for (zzgf.zzh zzhVar : list) {
            String strZzg = zzhVar.zzg();
            if (zzhVar.zzj()) {
                bundle.putDouble(strZzg, zzhVar.zza());
            } else if (zzhVar.zzk()) {
                bundle.putFloat(strZzg, zzhVar.zzb());
            } else if (zzhVar.zzn()) {
                bundle.putString(strZzg, zzhVar.zzh());
            } else if (zzhVar.zzl()) {
                bundle.putLong(strZzg, zzhVar.zzd());
            }
        }
        return bundle;
    }

    public final zzgf.zzf A(g0 g0Var) {
        zzgf.zzf.zza zzaVarZza = zzgf.zzf.zze().zza(g0Var.f16208e);
        for (String str : g0Var.f16209f) {
            zzgf.zzh.zza zzaVarZza2 = zzgf.zzh.zze().zza(str);
            Object objX = g0Var.f16209f.X(str);
            com.google.android.gms.common.internal.r.l(objX);
            Q(zzaVarZza2, objX);
            zzaVarZza.zza(zzaVarZza2);
        }
        if (!TextUtils.isEmpty(g0Var.f16206c) && g0Var.f16209f.X("_o") == null) {
            zzaVarZza.zza((zzgf.zzh) ((zzkg) zzgf.zzh.zze().zza("_o").zzb(g0Var.f16206c).zzaj()));
        }
        return (zzgf.zzf) ((zzkg) zzaVarZza.zzaj());
    }

    public final String E(zzfw.zzb zzbVar) {
        if (zzbVar == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nevent_filter {\n");
        if (zzbVar.zzl()) {
            W(sb2, 0, "filter_id", Integer.valueOf(zzbVar.zzb()));
        }
        W(sb2, 0, "event_name", d().b(zzbVar.zzf()));
        String strH = H(zzbVar.zzh(), zzbVar.zzi(), zzbVar.zzj());
        if (!strH.isEmpty()) {
            W(sb2, 0, "filter_type", strH);
        }
        if (zzbVar.zzk()) {
            U(sb2, 1, "event_count_filter", zzbVar.zze());
        }
        if (zzbVar.zza() > 0) {
            sb2.append("  filters {\n");
            Iterator<zzfw.zzc> it = zzbVar.zzg().iterator();
            while (it.hasNext()) {
                T(sb2, 2, it.next());
            }
        }
        S(sb2, 1);
        sb2.append("}\n}\n");
        return sb2.toString();
    }

    public final String F(zzfw.zze zzeVar) {
        if (zzeVar == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nproperty_filter {\n");
        if (zzeVar.zzi()) {
            W(sb2, 0, "filter_id", Integer.valueOf(zzeVar.zza()));
        }
        W(sb2, 0, "property_name", d().g(zzeVar.zze()));
        String strH = H(zzeVar.zzf(), zzeVar.zzg(), zzeVar.zzh());
        if (!strH.isEmpty()) {
            W(sb2, 0, "filter_type", strH);
        }
        T(sb2, 1, zzeVar.zzb());
        sb2.append("}\n");
        return sb2.toString();
    }

    public final String G(zzgf.zzj zzjVar) {
        zzgf.zzc zzcVarZzw;
        if (zzjVar == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nbatch {\n");
        if (zzjVar.zzh()) {
            W(sb2, 0, "upload_subdomain", zzjVar.zze());
        }
        if (zzjVar.zzg()) {
            W(sb2, 0, "sgtm_join_id", zzjVar.zzd());
        }
        for (zzgf.zzk zzkVar : zzjVar.zzf()) {
            if (zzkVar != null) {
                S(sb2, 1);
                sb2.append("bundle {\n");
                if (zzkVar.zzbs()) {
                    W(sb2, 1, "protocol_version", Integer.valueOf(zzkVar.zzf()));
                }
                if (zzpf.zza() && a().D(zzkVar.zzab(), p0.H0) && zzkVar.zzbv()) {
                    W(sb2, 1, "session_stitching_token", zzkVar.zzaq());
                }
                W(sb2, 1, "platform", zzkVar.zzao());
                if (zzkVar.zzbn()) {
                    W(sb2, 1, "gmp_version", Long.valueOf(zzkVar.zzo()));
                }
                if (zzkVar.zzcb()) {
                    W(sb2, 1, "uploading_gmp_version", Long.valueOf(zzkVar.zzu()));
                }
                if (zzkVar.zzbl()) {
                    W(sb2, 1, "dynamite_version", Long.valueOf(zzkVar.zzm()));
                }
                if (zzkVar.zzbe()) {
                    W(sb2, 1, "config_version", Long.valueOf(zzkVar.zzk()));
                }
                W(sb2, 1, "gmp_app_id", zzkVar.i_());
                W(sb2, 1, "admob_app_id", zzkVar.zzaa());
                W(sb2, 1, "app_id", zzkVar.zzab());
                W(sb2, 1, "app_version", zzkVar.zzae());
                if (zzkVar.zzba()) {
                    W(sb2, 1, "app_version_major", Integer.valueOf(zzkVar.zzb()));
                }
                W(sb2, 1, "firebase_instance_id", zzkVar.zzak());
                if (zzkVar.zzbj()) {
                    W(sb2, 1, "dev_cert_hash", Long.valueOf(zzkVar.zzl()));
                }
                W(sb2, 1, "app_store", zzkVar.zzad());
                if (zzkVar.zzca()) {
                    W(sb2, 1, "upload_timestamp_millis", Long.valueOf(zzkVar.zzt()));
                }
                if (zzkVar.zzbx()) {
                    W(sb2, 1, "start_timestamp_millis", Long.valueOf(zzkVar.zzr()));
                }
                if (zzkVar.zzbm()) {
                    W(sb2, 1, "end_timestamp_millis", Long.valueOf(zzkVar.zzn()));
                }
                if (zzkVar.zzbr()) {
                    W(sb2, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzkVar.zzq()));
                }
                if (zzkVar.zzbq()) {
                    W(sb2, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzkVar.zzp()));
                }
                W(sb2, 1, "app_instance_id", zzkVar.zzac());
                W(sb2, 1, "resettable_device_id", zzkVar.zzap());
                W(sb2, 1, "ds_id", zzkVar.zzaj());
                if (zzkVar.zzbp()) {
                    W(sb2, 1, "limited_ad_tracking", Boolean.valueOf(zzkVar.zzax()));
                }
                W(sb2, 1, "os_version", zzkVar.zzan());
                W(sb2, 1, "device_model", zzkVar.zzai());
                W(sb2, 1, "user_default_language", zzkVar.zzar());
                if (zzkVar.zzbz()) {
                    W(sb2, 1, "time_zone_offset_minutes", Integer.valueOf(zzkVar.zzh()));
                }
                if (zzkVar.zzbd()) {
                    W(sb2, 1, "bundle_sequential_index", Integer.valueOf(zzkVar.zzc()));
                }
                if (zzkVar.zzbi()) {
                    W(sb2, 1, "delivery_index", Integer.valueOf(zzkVar.zzd()));
                }
                if (zzkVar.zzbu()) {
                    W(sb2, 1, "service_upload", Boolean.valueOf(zzkVar.zzay()));
                }
                W(sb2, 1, "health_monitor", zzkVar.zzam());
                if (zzkVar.zzbt()) {
                    W(sb2, 1, "retry_counter", Integer.valueOf(zzkVar.zzg()));
                }
                if (zzkVar.zzbg()) {
                    W(sb2, 1, "consent_signals", zzkVar.zzag());
                }
                if (zzkVar.zzbo()) {
                    W(sb2, 1, "is_dma_region", Boolean.valueOf(zzkVar.zzaw()));
                }
                if (zzkVar.zzbh()) {
                    W(sb2, 1, "core_platform_services", zzkVar.zzah());
                }
                if (zzkVar.zzbf()) {
                    W(sb2, 1, "consent_diagnostics", zzkVar.zzaf());
                }
                if (zzkVar.zzby()) {
                    W(sb2, 1, "target_os_version", Long.valueOf(zzkVar.zzs()));
                }
                if (zzoy.zza() && a().D(zzkVar.zzab(), p0.Q0)) {
                    W(sb2, 1, "ad_services_version", Integer.valueOf(zzkVar.zza()));
                    if (zzkVar.zzbb() && (zzcVarZzw = zzkVar.zzw()) != null) {
                        S(sb2, 2);
                        sb2.append("attribution_eligibility_status {\n");
                        W(sb2, 2, "eligible", Boolean.valueOf(zzcVarZzw.zzf()));
                        W(sb2, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzcVarZzw.zzh()));
                        W(sb2, 2, "pre_r", Boolean.valueOf(zzcVarZzw.zzi()));
                        W(sb2, 2, "r_extensions_too_old", Boolean.valueOf(zzcVarZzw.zzj()));
                        W(sb2, 2, "adservices_extension_too_old", Boolean.valueOf(zzcVarZzw.zze()));
                        W(sb2, 2, "ad_storage_not_allowed", Boolean.valueOf(zzcVarZzw.zzd()));
                        W(sb2, 2, "measurement_manager_disabled", Boolean.valueOf(zzcVarZzw.zzg()));
                        S(sb2, 2);
                        sb2.append("}\n");
                    }
                }
                if (zzkVar.zzaz()) {
                    zzgf.zza zzaVarZzv = zzkVar.zzv();
                    S(sb2, 2);
                    sb2.append("ad_campaign_info {\n");
                    if (zzaVarZzv.zzn()) {
                        W(sb2, 2, "deep_link_gclid", zzaVarZzv.zzh());
                    }
                    if (zzaVarZzv.zzm()) {
                        W(sb2, 2, "deep_link_gbraid", zzaVarZzv.zzg());
                    }
                    if (zzaVarZzv.zzl()) {
                        W(sb2, 2, "deep_link_gad_source", zzaVarZzv.zzf());
                    }
                    if (zzaVarZzv.zzo()) {
                        W(sb2, 2, "deep_link_session_millis", Long.valueOf(zzaVarZzv.zza()));
                    }
                    if (zzaVarZzv.zzs()) {
                        W(sb2, 2, "market_referrer_gclid", zzaVarZzv.zzk());
                    }
                    if (zzaVarZzv.zzr()) {
                        W(sb2, 2, "market_referrer_gbraid", zzaVarZzv.zzj());
                    }
                    if (zzaVarZzv.zzq()) {
                        W(sb2, 2, "market_referrer_gad_source", zzaVarZzv.zzi());
                    }
                    if (zzaVarZzv.zzp()) {
                        W(sb2, 2, "market_referrer_click_millis", Long.valueOf(zzaVarZzv.zzb()));
                    }
                    S(sb2, 2);
                    sb2.append("}\n");
                }
                if (zzkVar.zzbc()) {
                    W(sb2, 1, "batching_timestamp_millis", Long.valueOf(zzkVar.zzj()));
                }
                if (zzkVar.zzbw()) {
                    zzgf.zzo zzoVarZzz = zzkVar.zzz();
                    S(sb2, 2);
                    sb2.append("sgtm_diagnostics {\n");
                    W(sb2, 2, "upload_type", zzoVarZzz.zzd().name());
                    W(sb2, 2, "client_upload_eligibility", zzoVarZzz.zzb().name());
                    W(sb2, 2, "service_upload_eligibility", zzoVarZzz.zzc().name());
                    S(sb2, 2);
                    sb2.append("}\n");
                }
                List<zzgf.zzp> listZzau = zzkVar.zzau();
                if (listZzau != null) {
                    for (zzgf.zzp zzpVar : listZzau) {
                        if (zzpVar != null) {
                            S(sb2, 2);
                            sb2.append("user_property {\n");
                            W(sb2, 2, "set_timestamp_millis", zzpVar.zzl() ? Long.valueOf(zzpVar.zzd()) : null);
                            W(sb2, 2, "name", d().g(zzpVar.zzg()));
                            W(sb2, 2, "string_value", zzpVar.zzh());
                            W(sb2, 2, "int_value", zzpVar.zzk() ? Long.valueOf(zzpVar.zzc()) : null);
                            W(sb2, 2, "double_value", zzpVar.zzi() ? Double.valueOf(zzpVar.zza()) : null);
                            S(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzgf.zzd> listZzas = zzkVar.zzas();
                zzkVar.zzab();
                if (listZzas != null) {
                    for (zzgf.zzd zzdVar : listZzas) {
                        if (zzdVar != null) {
                            S(sb2, 2);
                            sb2.append("audience_membership {\n");
                            if (zzdVar.zzg()) {
                                W(sb2, 2, "audience_id", Integer.valueOf(zzdVar.zza()));
                            }
                            if (zzdVar.zzh()) {
                                W(sb2, 2, "new_audience", Boolean.valueOf(zzdVar.zzf()));
                            }
                            V(sb2, 2, "current_data", zzdVar.zzd());
                            if (zzdVar.zzi()) {
                                V(sb2, 2, "previous_data", zzdVar.zze());
                            }
                            S(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                List<zzgf.zzf> listZzat = zzkVar.zzat();
                if (listZzat != null) {
                    for (zzgf.zzf zzfVar : listZzat) {
                        if (zzfVar != null) {
                            S(sb2, 2);
                            sb2.append("event {\n");
                            W(sb2, 2, "name", d().b(zzfVar.zzg()));
                            if (zzfVar.zzk()) {
                                W(sb2, 2, "timestamp_millis", Long.valueOf(zzfVar.zzd()));
                            }
                            if (zzfVar.zzj()) {
                                W(sb2, 2, "previous_timestamp_millis", Long.valueOf(zzfVar.zzc()));
                            }
                            if (zzfVar.zzi()) {
                                W(sb2, 2, "count", Integer.valueOf(zzfVar.zza()));
                            }
                            if (zzfVar.zzb() != 0) {
                                X(sb2, 2, zzfVar.zzh());
                            }
                            S(sb2, 2);
                            sb2.append("}\n");
                        }
                    }
                }
                S(sb2, 1);
                sb2.append("}\n");
            }
        }
        sb2.append("} // End-of-batch\n");
        return sb2.toString();
    }

    public final List<Long> J(List<Long> list, List<Integer> list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().H().b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    zzj().H().c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    public final Map<String, Object> K(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(K((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj2 = arrayList2.get(i10);
                            i10++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(K((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(K((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public final n0 L(zzad zzadVar) {
        Object obj;
        Bundle bundleY = y(zzadVar.zzc(), true);
        String string = (!bundleY.containsKey("_o") || (obj = bundleY.get("_o")) == null) ? "app" : obj.toString();
        String strB = y8.b(zzadVar.zzb());
        if (strB == null) {
            strB = zzadVar.zzb();
        }
        return new n0(strB, new i0(bundleY), string, zzadVar.zza());
    }

    public final sd M(String str, zzgf.zzk.zza zzaVar, zzgf.zzf.zza zzaVar2, String str2) {
        String strValueOf;
        String strValueOf2;
        int iIndexOf;
        if (!zzoy.zza() || !a().D(str, p0.Q0)) {
            return null;
        }
        long jA = zzb().a();
        String[] strArrSplit = a().B(str, p0.f16672p0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        ee eeVarP = p();
        String strO = eeVarP.n().O(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(eeVarP.a().B(str, p0.f16658i0));
        builder.authority(TextUtils.isEmpty(strO) ? eeVarP.a().B(str, p0.f16660j0) : strO + "." + eeVarP.a().B(str, p0.f16660j0));
        builder.path(eeVarP.a().B(str, p0.f16662k0));
        N(builder, "gmp_app_id", zzaVar.zzy(), setUnmodifiableSet);
        N(builder, "gmp_version", "114010", setUnmodifiableSet);
        String strZzv = zzaVar.zzv();
        j jVarA = a();
        d5<Boolean> d5Var = p0.T0;
        if (jVarA.D(str, d5Var) && n().X(str)) {
            strZzv = "";
        }
        N(builder, "app_instance_id", strZzv, setUnmodifiableSet);
        N(builder, "rdid", zzaVar.zzaa(), setUnmodifiableSet);
        N(builder, "bundle_id", zzaVar.zzu(), setUnmodifiableSet);
        String strZze = zzaVar2.zze();
        String strA = y8.a(strZze);
        if (!TextUtils.isEmpty(strA)) {
            strZze = strA;
        }
        N(builder, "app_event_name", strZze, setUnmodifiableSet);
        N(builder, "app_version", String.valueOf(zzaVar.zzb()), setUnmodifiableSet);
        String strZzz = zzaVar.zzz();
        if (a().D(str, d5Var) && n().b0(str) && !TextUtils.isEmpty(strZzz) && (iIndexOf = strZzz.indexOf(".")) != -1) {
            strZzz = strZzz.substring(0, iIndexOf);
        }
        N(builder, "os_version", strZzz, setUnmodifiableSet);
        N(builder, "timestamp", String.valueOf(zzaVar2.zzc()), setUnmodifiableSet);
        if (zzaVar.zzae()) {
            N(builder, "lat", "1", setUnmodifiableSet);
        }
        N(builder, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), setUnmodifiableSet);
        N(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        N(builder, "trigger_uri_timestamp", String.valueOf(jA), setUnmodifiableSet);
        N(builder, "request_uuid", str2, setUnmodifiableSet);
        List<zzgf.zzh> listZzf = zzaVar2.zzf();
        Bundle bundle = new Bundle();
        for (zzgf.zzh zzhVar : listZzf) {
            String strZzg = zzhVar.zzg();
            if (zzhVar.zzj()) {
                strValueOf2 = String.valueOf(zzhVar.zza());
            } else if (zzhVar.zzk()) {
                strValueOf2 = String.valueOf(zzhVar.zzb());
            } else if (zzhVar.zzn()) {
                strValueOf2 = zzhVar.zzh();
            } else if (zzhVar.zzl()) {
                strValueOf2 = String.valueOf(zzhVar.zzd());
            }
            bundle.putString(strZzg, strValueOf2);
        }
        O(builder, a().B(str, p0.f16670o0).split("\\|"), bundle, setUnmodifiableSet);
        List<zzgf.zzp> listZzac = zzaVar.zzac();
        Bundle bundle2 = new Bundle();
        for (zzgf.zzp zzpVar : listZzac) {
            String strZzg2 = zzpVar.zzg();
            if (zzpVar.zzi()) {
                strValueOf = String.valueOf(zzpVar.zza());
            } else if (zzpVar.zzj()) {
                strValueOf = String.valueOf(zzpVar.zzb());
            } else if (zzpVar.zzm()) {
                strValueOf = zzpVar.zzh();
            } else if (zzpVar.zzk()) {
                strValueOf = String.valueOf(zzpVar.zzc());
            }
            bundle2.putString(strZzg2, strValueOf);
        }
        O(builder, a().B(str, p0.f16668n0).split("\\|"), bundle2, setUnmodifiableSet);
        N(builder, "dma", zzaVar.zzad() ? "1" : "0", setUnmodifiableSet);
        if (!zzaVar.zzx().isEmpty()) {
            N(builder, "dma_cps", zzaVar.zzx(), setUnmodifiableSet);
        }
        if (a().p(p0.V0) && zzaVar.zzaf()) {
            zzgf.zza zzaVarZzg = zzaVar.zzg();
            if (!zzaVarZzg.zzh().isEmpty()) {
                N(builder, "dl_gclid", zzaVarZzg.zzh(), setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzg().isEmpty()) {
                N(builder, "dl_gbraid", zzaVarZzg.zzg(), setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzf().isEmpty()) {
                N(builder, "dl_gs", zzaVarZzg.zzf(), setUnmodifiableSet);
            }
            if (zzaVarZzg.zza() > 0) {
                N(builder, "dl_ss_ts", String.valueOf(zzaVarZzg.zza()), setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzk().isEmpty()) {
                N(builder, "mr_gclid", zzaVarZzg.zzk(), setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzj().isEmpty()) {
                N(builder, "mr_gbraid", zzaVarZzg.zzj(), setUnmodifiableSet);
            }
            if (!zzaVarZzg.zzi().isEmpty()) {
                N(builder, "mr_gs", zzaVarZzg.zzi(), setUnmodifiableSet);
            }
            if (zzaVarZzg.zzb() > 0) {
                N(builder, "mr_click_ts", String.valueOf(zzaVarZzg.zzb()), setUnmodifiableSet);
            }
        }
        return new sd(builder.build().toString(), jA, 1);
    }

    public final void Q(zzgf.zzh.zza zzaVar, Object obj) {
        com.google.android.gms.common.internal.r.l(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            zzj().C().b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                zzgf.zzh.zza zzaVarZze = zzgf.zzh.zze();
                for (String str : bundle.keySet()) {
                    zzgf.zzh.zza zzaVarZza = zzgf.zzh.zze().zza(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzaVarZza.zza(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzaVarZza.zzb((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzaVarZza.zza(((Double) obj2).doubleValue());
                    }
                    zzaVarZze.zza(zzaVarZza);
                }
                if (zzaVarZze.zza() > 0) {
                    arrayList.add((zzgf.zzh) ((zzkg) zzaVarZze.zzaj()));
                }
            }
        }
        zzaVar.zza(arrayList);
    }

    public final void R(zzgf.zzp.zza zzaVar, Object obj) {
        com.google.android.gms.common.internal.r.l(obj);
        zzaVar.zzc().zzb().zza();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzj().C().b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void T(StringBuilder sb2, int i10, zzfw.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        S(sb2, i10);
        sb2.append("filter {\n");
        if (zzcVar.zzg()) {
            W(sb2, i10, "complement", Boolean.valueOf(zzcVar.zzf()));
        }
        if (zzcVar.zzi()) {
            W(sb2, i10, "param_name", d().f(zzcVar.zze()));
        }
        if (zzcVar.zzj()) {
            int i11 = i10 + 1;
            zzfw.zzf zzfVarZzd = zzcVar.zzd();
            if (zzfVarZzd != null) {
                S(sb2, i11);
                sb2.append("string_filter");
                sb2.append(" {\n");
                if (zzfVarZzd.zzj()) {
                    W(sb2, i11, "match_type", zzfVarZzd.zzb().name());
                }
                if (zzfVarZzd.zzi()) {
                    W(sb2, i11, "expression", zzfVarZzd.zze());
                }
                if (zzfVarZzd.zzh()) {
                    W(sb2, i11, "case_sensitive", Boolean.valueOf(zzfVarZzd.zzg()));
                }
                if (zzfVarZzd.zza() > 0) {
                    S(sb2, i11 + 1);
                    sb2.append("expression_list {\n");
                    for (String str : zzfVarZzd.zzf()) {
                        S(sb2, i11 + 2);
                        sb2.append(str);
                        sb2.append("\n");
                    }
                    sb2.append("}\n");
                }
                S(sb2, i11);
                sb2.append("}\n");
            }
        }
        if (zzcVar.zzh()) {
            U(sb2, i10 + 1, "number_filter", zzcVar.zzc());
        }
        S(sb2, i10);
        sb2.append("}\n");
    }

    public final void X(StringBuilder sb2, int i10, List<zzgf.zzh> list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        for (zzgf.zzh zzhVar : list) {
            if (zzhVar != null) {
                S(sb2, i11);
                sb2.append("param {\n");
                W(sb2, i11, "name", zzhVar.zzm() ? d().f(zzhVar.zzg()) : null);
                W(sb2, i11, "string_value", zzhVar.zzn() ? zzhVar.zzh() : null);
                W(sb2, i11, "int_value", zzhVar.zzl() ? Long.valueOf(zzhVar.zzd()) : null);
                W(sb2, i11, "double_value", zzhVar.zzj() ? Double.valueOf(zzhVar.zza()) : null);
                if (zzhVar.zzc() > 0) {
                    X(sb2, i11, zzhVar.zzi());
                }
                S(sb2, i11);
                sb2.append("}\n");
            }
        }
    }

    public final boolean Y(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(zzb().a() - j10) > j11;
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

    public final byte[] d0(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            zzj().C().b("Failed to gzip content", e10);
            throw e10;
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ i6 e() {
        return super.e();
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ ab f() {
        return super.f();
    }

    public final byte[] f0(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i10 = gZIPInputStream.read(bArr2);
                if (i10 <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i10);
            }
        } catch (IOException e10) {
            zzj().C().b("Failed to ungzip content", e10);
            throw e10;
        }
    }

    @Override // u4.o8
    public final /* bridge */ /* synthetic */ af g() {
        return super.g();
    }

    public final List<Integer> g0() {
        Map<String, String> mapB = p0.b(this.f16938b.zza());
        if (mapB == null || mapB.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = p0.f16636a0.a(null).intValue();
        for (Map.Entry<String, String> entry : mapB.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i10 = Integer.parseInt(entry.getValue());
                    if (i10 != 0) {
                        arrayList.add(Integer.valueOf(i10));
                        if (arrayList.size() >= iIntValue) {
                            zzj().H().b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e10) {
                    zzj().H().b("Experiment ID NumberFormatException", e10);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
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

    @Override // u4.fe
    public final boolean t() {
        return false;
    }

    public final long v(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return w(str.getBytes(Charset.forName("UTF-8")));
    }

    public final long w(byte[] bArr) {
        com.google.android.gms.common.internal.r.l(bArr);
        g().j();
        MessageDigest messageDigestO0 = af.O0();
        if (messageDigestO0 != null) {
            return af.x(messageDigestO0.digest(bArr));
        }
        zzj().C().a("Failed to get MD5");
        return 0L;
    }

    public final Bundle y(Map<String, Object> map, boolean z10) {
        String string;
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                string = null;
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                string = obj.toString();
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(y((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
            bundle.putString(str, string);
        }
        return bundle;
    }

    public final <T extends Parcelable> T z(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (d4.b.a unused) {
            zzj().C().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
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
