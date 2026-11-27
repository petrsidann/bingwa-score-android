package u4;

import com.google.android.gms.internal.measurement.zzfw;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f16009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f16010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f16011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f16012f;

    public b(String str, int i10) {
        this.f16007a = str;
        this.f16008b = i10;
    }

    public static Boolean b(double d10, zzfw.zzd zzdVar) {
        try {
            return h(new BigDecimal(d10), zzdVar, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean c(long j10, zzfw.zzd zzdVar) {
        try {
            return h(new BigDecimal(j10), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean d(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    public static Boolean e(String str, zzfw.zzd zzdVar) {
        if (!we.c0(str)) {
            return null;
        }
        try {
            return h(new BigDecimal(str), zzdVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean f(String str, zzfw.zzf.zza zzaVar, boolean z10, String str2, List<String> list, String str3, v5 v5Var) {
        boolean zStartsWith;
        if (str == null) {
            return null;
        }
        if (zzaVar == zzfw.zzf.zza.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && zzaVar != zzfw.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (jf.f16408a[zzaVar.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z10 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (v5Var != null) {
                        v5Var.H().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                zStartsWith = str.startsWith(str2);
                break;
            case 3:
                zStartsWith = str.endsWith(str2);
                break;
            case 4:
                zStartsWith = str.contains(str2);
                break;
            case 5:
                zStartsWith = str.equals(str2);
                break;
            case 6:
                if (list == null) {
                    return null;
                }
                zStartsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(zStartsWith);
    }

    public static Boolean g(String str, zzfw.zzf zzfVar, v5 v5Var) {
        List<String> list;
        com.google.android.gms.common.internal.r.l(zzfVar);
        if (str == null || !zzfVar.zzj() || zzfVar.zzb() == zzfw.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzfw.zzf.zza zzaVarZzb = zzfVar.zzb();
        zzfw.zzf.zza zzaVar = zzfw.zzf.zza.IN_LIST;
        if (zzaVarZzb == zzaVar) {
            if (zzfVar.zza() == 0) {
                return null;
            }
        } else if (!zzfVar.zzi()) {
            return null;
        }
        zzfw.zzf.zza zzaVarZzb2 = zzfVar.zzb();
        boolean zZzg = zzfVar.zzg();
        String strZze = (zZzg || zzaVarZzb2 == zzfw.zzf.zza.REGEXP || zzaVarZzb2 == zzaVar) ? zzfVar.zze() : zzfVar.zze().toUpperCase(Locale.ENGLISH);
        if (zzfVar.zza() == 0) {
            list = null;
        } else {
            List<String> listZzf = zzfVar.zzf();
            if (!zZzg) {
                ArrayList arrayList = new ArrayList(listZzf.size());
                Iterator<String> it = listZzf.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                listZzf = Collections.unmodifiableList(arrayList);
            }
            list = listZzf;
        }
        return f(str, zzaVarZzb2, zZzg, strZze, list, zzaVarZzb2 == zzfw.zzf.zza.REGEXP ? strZze : null, v5Var);
    }

    public static Boolean h(BigDecimal bigDecimal, zzfw.zzd zzdVar, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        com.google.android.gms.common.internal.r.l(zzdVar);
        if (zzdVar.zzh() && zzdVar.zza() != zzfw.zzd.zza.UNKNOWN_COMPARISON_TYPE) {
            zzfw.zzd.zza zzaVarZza = zzdVar.zza();
            zzfw.zzd.zza zzaVar = zzfw.zzd.zza.BETWEEN;
            if (zzaVarZza == zzaVar) {
                if (!zzdVar.zzl() || !zzdVar.zzk()) {
                    return null;
                }
            } else if (!zzdVar.zzi()) {
                return null;
            }
            zzfw.zzd.zza zzaVarZza2 = zzdVar.zza();
            if (zzdVar.zza() == zzaVar) {
                if (we.c0(zzdVar.zzf()) && we.c0(zzdVar.zze())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzdVar.zzf());
                        bigDecimal4 = new BigDecimal(zzdVar.zze());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            }
            if (!we.c0(zzdVar.zzd())) {
                return null;
            }
            try {
                bigDecimal2 = new BigDecimal(zzdVar.zzd());
                bigDecimal3 = null;
                bigDecimal4 = null;
            } catch (NumberFormatException unused2) {
            }
            if (zzaVarZza2 == zzaVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 != null) {
            }
            int i10 = jf.f16409b[zzaVarZza2.ordinal()];
            boolean z10 = false;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4 || bigDecimal3 == null) {
                            return null;
                        }
                        if (bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    }
                    if (bigDecimal2 != null) {
                        if (d10 == 0.0d) {
                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                        }
                        if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) < 0) {
                            z10 = true;
                        }
                        return Boolean.valueOf(z10);
                    }
                } else if (bigDecimal2 != null) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
            } else if (bigDecimal2 != null) {
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
            }
        }
        return null;
    }

    public abstract int a();

    public abstract boolean i();

    public abstract boolean j();
}
