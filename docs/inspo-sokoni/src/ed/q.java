package ed;

/* JADX INFO: loaded from: classes2.dex */
public class q extends p {
    public static final String l(char[] cArr) {
        kotlin.jvm.internal.k.e(cArr, "<this>");
        return new String(cArr);
    }

    public static final String m(char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.k.e(cArr, "<this>");
        mc.d.f13286a.a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    public static final boolean n(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        return !z10 ? str.regionMatches(i10, other, i11, i12) : str.regionMatches(z10, i10, other, i11, i12);
    }

    public static final String o(String str, String oldValue, String newValue, boolean z10) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(oldValue, "oldValue");
        kotlin.jvm.internal.k.e(newValue, "newValue");
        int i10 = 0;
        int iZ = t.z(str, oldValue, 0, z10);
        if (iZ < 0) {
            return str;
        }
        int length = oldValue.length();
        int iA = bd.h.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iZ);
            sb2.append(newValue);
            i10 = iZ + length;
            if (iZ >= str.length()) {
                break;
            }
            iZ = t.z(str, oldValue, iZ + iA, z10);
        } while (iZ > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        kotlin.jvm.internal.k.d(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ String p(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return o(str, str2, str3, z10);
    }

    public static final boolean q(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return !z10 ? str.startsWith(prefix) : n(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean r(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return q(str, str2, z10);
    }
}
