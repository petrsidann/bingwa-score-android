package u4;

/* JADX INFO: loaded from: classes.dex */
public final class ib {
    public static String a(String str, String[] strArr, String[] strArr2) {
        com.google.android.gms.common.internal.r.l(strArr);
        com.google.android.gms.common.internal.r.l(strArr2);
        int iMin = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            String str2 = strArr[i10];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i10];
            }
        }
        return null;
    }
}
