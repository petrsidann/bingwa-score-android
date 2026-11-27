package ed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mc.w;

/* JADX INFO: loaded from: classes2.dex */
public class t extends q {

    public static final class a implements dd.b<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f7933a;

        public a(CharSequence charSequence) {
            this.f7933a = charSequence;
        }

        @Override // dd.b
        public Iterator<String> iterator() {
            return new e(this.f7933a);
        }
    }

    public static final int A(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        bd.d fVar = !z11 ? new bd.f(bd.h.a(i10, 0), bd.h.c(i11, charSequence.length())) : bd.h.g(bd.h.c(i10, x(charSequence)), bd.h.a(i11, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int iE = fVar.e();
            int iH = fVar.h();
            int i12 = fVar.i();
            if ((i12 <= 0 || iE > iH) && (i12 >= 0 || iH > iE)) {
                return -1;
            }
            while (!W(charSequence2, 0, charSequence, iE, charSequence2.length(), z10)) {
                if (iE == iH) {
                    return -1;
                }
                iE += i12;
            }
            return iE;
        }
        int iE2 = fVar.e();
        int iH2 = fVar.h();
        int i13 = fVar.i();
        if ((i13 <= 0 || iE2 > iH2) && (i13 >= 0 || iH2 > iE2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (q.n(str, 0, (String) charSequence, iE2, str.length(), z10)) {
                return iE2;
            }
            if (iE2 == iH2) {
                return -1;
            }
            iE2 += i13;
        }
    }

    public static /* synthetic */ int B(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return A(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static /* synthetic */ int C(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return y(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int D(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return z(charSequence, str, i10, z10);
    }

    public static final int E(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        boolean z11;
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(mc.k.J(chars), i10);
        }
        int iA = bd.h.a(i10, 0);
        int iX = x(charSequence);
        if (iA > iX) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iA);
            int length = chars.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z11 = false;
                    break;
                }
                if (b.d(chars[i11], cCharAt, z10)) {
                    z11 = true;
                    break;
                }
                i11++;
            }
            if (z11) {
                return iA;
            }
            if (iA == iX) {
                return -1;
            }
            iA++;
        }
    }

    public static final boolean F(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!ed.a.c(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static final int G(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? K(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int H(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z10 || !(charSequence instanceof String)) ? A(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int I(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = x(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return G(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int J(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = x(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return H(charSequence, str, i10, z10);
    }

    public static final int K(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(mc.k.J(chars), i10);
        }
        for (int iC = bd.h.c(i10, x(charSequence)); -1 < iC; iC--) {
            char cCharAt = charSequence.charAt(iC);
            boolean z11 = false;
            for (char c10 : chars) {
                if (b.d(c10, cCharAt, z10)) {
                    z11 = true;
                    break;
                }
            }
            if (z11) {
                return iC;
            }
        }
        return -1;
    }

    public static final dd.b<String> L(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List<String> M(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return dd.i.f(L(charSequence));
    }

    public static final CharSequence N(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        return sb2;
    }

    public static final String O(String str, int i10, char c10) {
        kotlin.jvm.internal.k.e(str, "<this>");
        return N(str, i10, c10).toString();
    }

    public static /* synthetic */ String P(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return O(str, i10, c10);
    }

    public static final dd.b<bd.f> Q(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        X(i11);
        return new d(charSequence, i10, i11, new xc.p() { // from class: ed.r
            @Override // xc.p
            public final Object invoke(Object obj, Object obj2) {
                return t.U(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final dd.b<bd.f> R(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        X(i11);
        final List listC = mc.j.c(strArr);
        return new d(charSequence, i10, i11, new xc.p() { // from class: ed.s
            @Override // xc.p
            public final Object invoke(Object obj, Object obj2) {
                return t.V(listC, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ dd.b S(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return Q(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ dd.b T(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return R(charSequence, strArr, i10, z10, i11);
    }

    public static final lc.i U(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.k.e(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iE = E(DelimitedRangesSequence, cArr, i10, z10);
        if (iE < 0) {
            return null;
        }
        return lc.m.a(Integer.valueOf(iE), 1);
    }

    public static final lc.i V(List list, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.k.e(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        lc.i<Integer, String> iVarW = w(DelimitedRangesSequence, list, i10, z10, false);
        if (iVarW != null) {
            return lc.m.a(iVarW.c(), Integer.valueOf(iVarW.d().length()));
        }
        return null;
    }

    public static final boolean W(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final void X(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List<String> Y(CharSequence charSequence, char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return a0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableE = dd.i.e(S(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(mc.p.m(iterableE, 10));
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            arrayList.add(d0(charSequence, (bd.f) it.next()));
        }
        return arrayList;
    }

    public static final List<String> Z(CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return a0(charSequence, str, z10, i10);
            }
        }
        Iterable iterableE = dd.i.e(T(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(mc.p.m(iterableE, 10));
        Iterator it = iterableE.iterator();
        while (it.hasNext()) {
            arrayList.add(d0(charSequence, (bd.f) it.next()));
        }
        return arrayList;
    }

    public static final List<String> a0(CharSequence charSequence, String str, boolean z10, int i10) {
        X(i10);
        int length = 0;
        int iZ = z(charSequence, str, 0, z10);
        if (iZ == -1 || i10 == 1) {
            return mc.n.b(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? bd.h.c(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iZ).toString());
            length = str.length() + iZ;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iZ = z(charSequence, str, length, z10);
        } while (iZ != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List b0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return Y(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List c0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return Z(charSequence, strArr, z10, i10);
    }

    public static final String d0(CharSequence charSequence, bd.f range) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(range, "range");
        return charSequence.subSequence(range.n().intValue(), range.l().intValue() + 1).toString();
    }

    public static final String e0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iC = C(str, c10, 0, false, 6, null);
        if (iC == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iC + 1, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String f0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iD = D(str, delimiter, 0, false, 6, null);
        if (iD == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iD + delimiter.length(), str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String g0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return e0(str, c10, str2);
    }

    public static /* synthetic */ String h0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return f0(str, str2, str3);
    }

    public static final String i0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int I = I(str, c10, 0, false, 6, null);
        if (I == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(I + 1, str.length());
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String j0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return i0(str, c10, str2);
    }

    public static final String k0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iC = C(str, c10, 0, false, 6, null);
        if (iC == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iC);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String l0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.k.e(str, "<this>");
        kotlin.jvm.internal.k.e(delimiter, "delimiter");
        kotlin.jvm.internal.k.e(missingDelimiterValue, "missingDelimiterValue");
        int iD = D(str, delimiter, 0, false, 6, null);
        if (iD == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iD);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String m0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return k0(str, c10, str2);
    }

    public static /* synthetic */ String n0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return l0(str, str2, str3);
    }

    public static final CharSequence o0(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = ed.a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static final boolean u(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(other, "other");
        if (other instanceof String) {
            if (D(charSequence, (String) other, 0, z10, 2, null) >= 0) {
                return true;
            }
        } else if (B(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean v(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return u(charSequence, charSequence2, z10);
    }

    public static final lc.i<Integer, String> w(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        int iE;
        Object next;
        String str;
        String str2;
        Object next2;
        String str3;
        if (!z10 && collection.size() == 1) {
            String str4 = (String) w.F(collection);
            int iD = !z11 ? D(charSequence, str4, i10, false, 4, null) : J(charSequence, str4, i10, false, 4, null);
            if (iD < 0) {
                return null;
            }
            return lc.m.a(Integer.valueOf(iD), str4);
        }
        bd.d fVar = !z11 ? new bd.f(bd.h.a(i10, 0), charSequence.length()) : bd.h.g(bd.h.c(i10, x(charSequence)), 0);
        if (charSequence instanceof String) {
            iE = fVar.e();
            int iH = fVar.h();
            int i11 = fVar.i();
            if ((i11 > 0 && iE <= iH) || (i11 < 0 && iH <= iE)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    do {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        str3 = (String) next2;
                    } while (!q.n(str3, 0, (String) charSequence, iE, str3.length(), z10));
                    str = (String) next2;
                    if (str != null) {
                        break;
                    }
                    if (iE != iH) {
                        iE += i11;
                    }
                }
                return lc.m.a(Integer.valueOf(iE), str);
            }
            return null;
        }
        iE = fVar.e();
        int iH2 = fVar.h();
        int i12 = fVar.i();
        if ((i12 > 0 && iE <= iH2) || (i12 < 0 && iH2 <= iE)) {
            while (true) {
                Iterator<T> it2 = collection.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    str2 = (String) next;
                } while (!W(str2, 0, charSequence, iE, str2.length(), z10));
                str = (String) next;
                if (str != null) {
                    break;
                }
                if (iE != iH2) {
                    iE += i12;
                }
            }
            return lc.m.a(Integer.valueOf(iE), str);
        }
        return null;
    }

    public static final int x(CharSequence charSequence) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int y(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? E(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static final int z(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.k.e(charSequence, "<this>");
        kotlin.jvm.internal.k.e(string, "string");
        return (z10 || !(charSequence instanceof String)) ? B(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }
}
