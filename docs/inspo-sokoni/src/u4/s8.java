package u4;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class s8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s8 f16793c = new s8(null, null, 100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumMap<a, v8> f16794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16795b;

    public enum a {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16801a;

        a(String str) {
            this.f16801a = str;
        }
    }

    public s8(Boolean bool, Boolean bool2, int i10) {
        EnumMap<a, v8> enumMap = new EnumMap<>(a.class);
        this.f16794a = enumMap;
        enumMap.put(a.AD_STORAGE, j(null));
        enumMap.put(a.ANALYTICS_STORAGE, j(null));
        this.f16795b = i10;
    }

    public s8(EnumMap<a, v8> enumMap, int i10) {
        EnumMap<a, v8> enumMap2 = new EnumMap<>(a.class);
        this.f16794a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f16795b = i10;
    }

    public static char a(v8 v8Var) {
        if (v8Var == null) {
            return '-';
        }
        int iOrdinal = v8Var.ordinal();
        if (iOrdinal == 1) {
            return '+';
        }
        if (iOrdinal != 2) {
            return iOrdinal != 3 ? '-' : '1';
        }
        return '0';
    }

    public static String c(int i10) {
        if (i10 == -30) {
            return "TCF";
        }
        if (i10 == -20) {
            return "API";
        }
        if (i10 == -10) {
            return "MANIFEST";
        }
        if (i10 == 0) {
            return "1P_API";
        }
        if (i10 == 30) {
            return "1P_INIT";
        }
        if (i10 != 90) {
            return i10 != 100 ? "OTHER" : "UNKNOWN";
        }
        return "REMOTE_CONFIG";
    }

    public static String d(Bundle bundle) {
        String string;
        a[] aVarArr = u8.STORAGE.f16863a;
        int length = aVarArr.length;
        int i10 = 0;
        while (true) {
            Boolean bool = null;
            if (i10 >= length) {
                return null;
            }
            a aVar = aVarArr[i10];
            if (bundle.containsKey(aVar.f16801a) && (string = bundle.getString(aVar.f16801a)) != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
                if (bool == null) {
                    return string;
                }
            }
            i10++;
        }
    }

    public static s8 e(Bundle bundle, int i10) {
        if (bundle == null) {
            return new s8(null, null, i10);
        }
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : u8.STORAGE.f16863a) {
            enumMap.put(aVar, k(bundle.getString(aVar.f16801a)));
        }
        return new s8(enumMap, i10);
    }

    public static s8 f(String str, int i10) {
        EnumMap enumMap = new EnumMap(a.class);
        if (str == null) {
            str = "";
        }
        a[] aVarArrD = u8.STORAGE.d();
        for (int i11 = 0; i11 < aVarArrD.length; i11++) {
            int i12 = i11 + 2;
            enumMap.put(aVarArrD[i11], i12 < str.length() ? i(str.charAt(i12)) : v8.UNINITIALIZED);
        }
        return new s8(enumMap, i10);
    }

    public static s8 h(v8 v8Var, v8 v8Var2, int i10) {
        EnumMap enumMap = new EnumMap(a.class);
        enumMap.put(a.AD_STORAGE, v8Var);
        enumMap.put(a.ANALYTICS_STORAGE, v8Var2);
        return new s8(enumMap, -10);
    }

    public static v8 i(char c10) {
        if (c10 == '+') {
            return v8.POLICY;
        }
        if (c10 != '0') {
            return c10 != '1' ? v8.UNINITIALIZED : v8.GRANTED;
        }
        return v8.DENIED;
    }

    public static v8 j(Boolean bool) {
        if (bool == null) {
            return v8.UNINITIALIZED;
        }
        return bool.booleanValue() ? v8.GRANTED : v8.DENIED;
    }

    public static v8 k(String str) {
        if (str == null) {
            return v8.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return v8.GRANTED;
        }
        return str.equals("denied") ? v8.DENIED : v8.UNINITIALIZED;
    }

    public static boolean l(int i10, int i11) {
        return ((i10 == -20 && i11 == -30) || ((i10 == -30 && i11 == -20) || i10 == i11)) || i10 < i11;
    }

    public static String o(v8 v8Var) {
        int iOrdinal = v8Var.ordinal();
        if (iOrdinal == 2) {
            return "denied";
        }
        if (iOrdinal != 3) {
            return null;
        }
        return "granted";
    }

    public static s8 p(String str) {
        return f(str, 100);
    }

    public final int b() {
        return this.f16795b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s8)) {
            return false;
        }
        s8 s8Var = (s8) obj;
        for (a aVar : u8.STORAGE.f16863a) {
            if (this.f16794a.get(aVar) != s8Var.f16794a.get(aVar)) {
                return false;
            }
        }
        return this.f16795b == s8Var.f16795b;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    public final s8 g(s8 s8Var) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : u8.STORAGE.f16863a) {
            v8 v8Var = this.f16794a.get(aVar);
            v8 v8Var2 = s8Var.f16794a.get(aVar);
            if (v8Var == null) {
                v8Var = v8Var2;
            } else if (v8Var2 != null) {
                v8 v8Var3 = v8.UNINITIALIZED;
                if (v8Var == v8Var3) {
                    v8Var = v8Var2;
                } else if (v8Var2 != v8Var3) {
                    v8 v8Var4 = v8.POLICY;
                    if (v8Var == v8Var4) {
                        v8Var = v8Var2;
                    } else if (v8Var2 != v8Var4) {
                        v8 v8Var5 = v8.DENIED;
                        v8Var = (v8Var == v8Var5 || v8Var2 == v8Var5) ? v8Var5 : v8.GRANTED;
                    }
                }
            }
            if (v8Var != null) {
                enumMap.put(aVar, v8Var);
            }
        }
        return new s8(enumMap, 100);
    }

    public final int hashCode() {
        int iHashCode = this.f16795b * 17;
        Iterator<v8> it = this.f16794a.values().iterator();
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    public final boolean m(a aVar) {
        return this.f16794a.get(aVar) != v8.DENIED;
    }

    public final Bundle n() {
        Bundle bundle = new Bundle();
        Iterator it = this.f16794a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String strO = o((v8) entry.getValue());
            if (strO != null) {
                bundle.putString(((a) entry.getKey()).f16801a, strO);
            }
        }
        return bundle;
    }

    public final s8 q(s8 s8Var) {
        EnumMap enumMap = new EnumMap(a.class);
        for (a aVar : u8.STORAGE.f16863a) {
            v8 v8Var = this.f16794a.get(aVar);
            if (v8Var == v8.UNINITIALIZED) {
                v8Var = s8Var.f16794a.get(aVar);
            }
            if (v8Var != null) {
                enumMap.put(aVar, v8Var);
            }
        }
        return new s8(enumMap, this.f16795b);
    }

    public final v8 r() {
        v8 v8Var = this.f16794a.get(a.AD_STORAGE);
        return v8Var == null ? v8.UNINITIALIZED : v8Var;
    }

    public final boolean s(s8 s8Var) {
        for (a aVar : (a[]) this.f16794a.keySet().toArray(new a[0])) {
            v8 v8Var = this.f16794a.get(aVar);
            v8 v8Var2 = s8Var.f16794a.get(aVar);
            v8 v8Var3 = v8.DENIED;
            if (v8Var == v8Var3 && v8Var2 != v8Var3) {
                return true;
            }
        }
        return false;
    }

    public final v8 t() {
        v8 v8Var = this.f16794a.get(a.ANALYTICS_STORAGE);
        return v8Var == null ? v8.UNINITIALIZED : v8Var;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(c(this.f16795b));
        for (a aVar : u8.STORAGE.f16863a) {
            sb2.append(",");
            sb2.append(aVar.f16801a);
            sb2.append("=");
            v8 v8Var = this.f16794a.get(aVar);
            if (v8Var == null) {
                v8Var = v8.UNINITIALIZED;
            }
            sb2.append(v8Var);
        }
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    public final String u() {
        int iOrdinal;
        StringBuilder sb2 = new StringBuilder("G1");
        for (a aVar : u8.STORAGE.d()) {
            v8 v8Var = this.f16794a.get(aVar);
            char c10 = '-';
            if (v8Var != null && (iOrdinal = v8Var.ordinal()) != 0) {
                if (iOrdinal == 1) {
                    c10 = '1';
                } else if (iOrdinal == 2) {
                    c10 = '0';
                } else if (iOrdinal == 3) {
                    c10 = '1';
                }
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public final String v() {
        StringBuilder sb2 = new StringBuilder("G1");
        for (a aVar : u8.STORAGE.d()) {
            sb2.append(a(this.f16794a.get(aVar)));
        }
        return sb2.toString();
    }

    public final boolean w() {
        return m(a.AD_STORAGE);
    }

    public final boolean x() {
        return m(a.ANALYTICS_STORAGE);
    }

    public final boolean y() {
        Iterator<v8> it = this.f16794a.values().iterator();
        while (it.hasNext()) {
            if (it.next() != v8.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }
}
