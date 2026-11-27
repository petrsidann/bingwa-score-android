package u4;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f0 f16176f = new f0(null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f16179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumMap<s8.a, v8> f16181e;

    public f0(Boolean bool, int i10) {
        this((Boolean) null, i10, (Boolean) null, (String) null);
    }

    public f0(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap<s8.a, v8> enumMap = new EnumMap<>(s8.a.class);
        this.f16181e = enumMap;
        enumMap.put(s8.a.AD_USER_DATA, s8.j(bool));
        this.f16177a = i10;
        this.f16178b = l();
        this.f16179c = bool2;
        this.f16180d = str;
    }

    public f0(EnumMap<s8.a, v8> enumMap, int i10, Boolean bool, String str) {
        EnumMap<s8.a, v8> enumMap2 = new EnumMap<>(s8.a.class);
        this.f16181e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f16177a = i10;
        this.f16178b = l();
        this.f16179c = bool;
        this.f16180d = str;
    }

    public static Boolean b(Bundle bundle) {
        v8 v8VarK;
        if (bundle == null || (v8VarK = s8.k(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int i10 = e0.f16126a[v8VarK.ordinal()];
        if (i10 == 3) {
            return Boolean.FALSE;
        }
        if (i10 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static f0 c(Bundle bundle, int i10) {
        if (bundle == null) {
            return new f0(null, i10);
        }
        EnumMap enumMap = new EnumMap(s8.a.class);
        for (s8.a aVar : u8.DMA.d()) {
            enumMap.put(aVar, s8.k(bundle.getString(aVar.f16801a)));
        }
        return new f0((EnumMap<s8.a, v8>) enumMap, i10, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static f0 d(String str) {
        if (str == null || str.length() <= 0) {
            return f16176f;
        }
        String[] strArrSplit = str.split(":");
        int i10 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(s8.a.class);
        s8.a[] aVarArrD = u8.DMA.d();
        int length = aVarArrD.length;
        int i11 = 1;
        int i12 = 0;
        while (i12 < length) {
            enumMap.put(aVarArrD[i12], s8.i(strArrSplit[i11].charAt(0)));
            i12++;
            i11++;
        }
        return new f0((EnumMap<s8.a, v8>) enumMap, i10, (Boolean) null, (String) null);
    }

    public static f0 e(v8 v8Var, int i10) {
        EnumMap enumMap = new EnumMap(s8.a.class);
        enumMap.put(s8.a.AD_USER_DATA, v8Var);
        return new f0((EnumMap<s8.a, v8>) enumMap, -10, (Boolean) null, (String) null);
    }

    public final int a() {
        return this.f16177a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (this.f16178b.equalsIgnoreCase(f0Var.f16178b) && Objects.equals(this.f16179c, f0Var.f16179c)) {
            return Objects.equals(this.f16180d, f0Var.f16180d);
        }
        return false;
    }

    public final Bundle f() {
        Bundle bundle = new Bundle();
        Iterator it = this.f16181e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strO = s8.o((v8) entry.getValue());
            if (strO != null) {
                bundle.putString(((s8.a) entry.getKey()).f16801a, strO);
            }
        }
        Boolean bool = this.f16179c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.f16180d;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final v8 g() {
        v8 v8Var = this.f16181e.get(s8.a.AD_USER_DATA);
        return v8Var == null ? v8.UNINITIALIZED : v8Var;
    }

    public final Boolean h() {
        return this.f16179c;
    }

    public final int hashCode() {
        int i10;
        Boolean bool = this.f16179c;
        if (bool == null) {
            i10 = 3;
        } else {
            i10 = bool == Boolean.TRUE ? 7 : 13;
        }
        String str = this.f16180d;
        return this.f16178b.hashCode() + (i10 * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    public final String i() {
        return this.f16180d;
    }

    public final String j() {
        return this.f16178b;
    }

    public final boolean k() {
        Iterator<v8> it = this.f16181e.values().iterator();
        while (it.hasNext()) {
            if (it.next() != v8.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String l() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f16177a);
        for (s8.a aVar : u8.DMA.d()) {
            sb2.append(":");
            sb2.append(s8.a(this.f16181e.get(aVar)));
        }
        return sb2.toString();
    }

    public final String toString() {
        int i10;
        String str;
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(s8.c(this.f16177a));
        for (s8.a aVar : u8.DMA.d()) {
            sb2.append(",");
            sb2.append(aVar.f16801a);
            sb2.append("=");
            v8 v8Var = this.f16181e.get(aVar);
            if (v8Var == null || (i10 = e0.f16126a[v8Var.ordinal()]) == 1) {
                sb2.append("uninitialized");
            } else {
                if (i10 == 2) {
                    str = "eu_consent_policy";
                } else if (i10 == 3) {
                    str = "denied";
                } else if (i10 == 4) {
                    str = "granted";
                }
                sb2.append(str);
            }
        }
        if (this.f16179c != null) {
            sb2.append(",isDmaRegion=");
            sb2.append(this.f16179c);
        }
        if (this.f16180d != null) {
            sb2.append(",cpsDisplayStr=");
            sb2.append(this.f16180d);
        }
        return sb2.toString();
    }
}
