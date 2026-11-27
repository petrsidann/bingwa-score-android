package u4;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class s5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<String[]> f16784b = new AtomicReference<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<String[]> f16785c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference<String[]> f16786d = new AtomicReference<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5 f16787a;

    public s5(r5 r5Var) {
        this.f16787a = r5Var;
    }

    public static String c(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        com.google.android.gms.common.internal.r.l(strArr);
        com.google.android.gms.common.internal.r.l(strArr2);
        com.google.android.gms.common.internal.r.l(atomicReference);
        com.google.android.gms.common.internal.r.a(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (Objects.equals(str, strArr[i10])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i10] == null) {
                        strArr3[i10] = strArr2[i10] + "(" + strArr[i10] + ")";
                    }
                    str2 = strArr3[i10];
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(Bundle bundle) {
        String strE;
        if (bundle == null) {
            return null;
        }
        if (!this.f16787a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(f(str));
            sb2.append("=");
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                strE = e(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                strE = e((Object[]) obj);
            } else {
                strE = obj instanceof ArrayList ? e(((ArrayList) obj).toArray()) : String.valueOf(obj);
            }
            sb2.append(strE);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f16787a.zza() ? str : c(str, y8.f16976c, y8.f16974a, f16784b);
    }

    public final String d(n0 n0Var) {
        String string = null;
        if (n0Var == null) {
            return null;
        }
        if (!this.f16787a.zza()) {
            return n0Var.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(n0Var.f16571c);
        sb2.append(",name=");
        sb2.append(b(n0Var.f16569a));
        sb2.append(",params=");
        i0 i0Var = n0Var.f16570b;
        if (i0Var != null) {
            string = !this.f16787a.zza() ? i0Var.toString() : a(i0Var.V());
        }
        sb2.append(string);
        return sb2.toString();
    }

    public final String e(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Object obj : objArr) {
            String strA = obj instanceof Bundle ? a((Bundle) obj) : String.valueOf(obj);
            if (strA != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(strA);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        return !this.f16787a.zza() ? str : c(str, x8.f16951b, x8.f16950a, f16785c);
    }

    public final String g(String str) {
        if (str == null) {
            return null;
        }
        if (!this.f16787a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return c(str, a9.f15989b, a9.f15988a, f16786d);
        }
        return "experiment_id(" + str + ")";
    }
}
