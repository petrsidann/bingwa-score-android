package mc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class k extends j {
    public static final String A(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Long, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(jArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) u(jArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static final <T> String B(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) v(tArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static final String C(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Short, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(sArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) w(sArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static /* synthetic */ String D(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return x(dArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static /* synthetic */ String E(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return y(fArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static /* synthetic */ String F(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return z(iArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static /* synthetic */ String G(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return A(jArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static /* synthetic */ String H(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return B(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static /* synthetic */ String I(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, xc.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return C(sArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final char J(char[] cArr) {
        kotlin.jvm.internal.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T K(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> List<T> L(T[] tArr, int i10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return o.g();
        }
        int length = tArr.length;
        if (i10 >= length) {
            return S(tArr);
        }
        if (i10 == 1) {
            return n.b(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C M(T[] tArr, C destination) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        for (T t10 : tArr) {
            destination.add(t10);
        }
        return destination;
    }

    public static final List<Byte> N(byte[] bArr) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? U(bArr) : n.b(Byte.valueOf(bArr[0]));
        }
        return o.g();
    }

    public static final List<Double> O(double[] dArr) {
        kotlin.jvm.internal.k.e(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? V(dArr) : n.b(Double.valueOf(dArr[0]));
        }
        return o.g();
    }

    public static final List<Float> P(float[] fArr) {
        kotlin.jvm.internal.k.e(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? W(fArr) : n.b(Float.valueOf(fArr[0]));
        }
        return o.g();
    }

    public static final List<Integer> Q(int[] iArr) {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? X(iArr) : n.b(Integer.valueOf(iArr[0]));
        }
        return o.g();
    }

    public static final List<Long> R(long[] jArr) {
        kotlin.jvm.internal.k.e(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? Y(jArr) : n.b(Long.valueOf(jArr[0]));
        }
        return o.g();
    }

    public static final <T> List<T> S(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Z(tArr) : n.b(tArr[0]);
        }
        return o.g();
    }

    public static final List<Short> T(short[] sArr) {
        kotlin.jvm.internal.k.e(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? a0(sArr) : n.b(Short.valueOf(sArr[0]));
        }
        return o.g();
    }

    public static final List<Byte> U(byte[] bArr) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    public static final List<Double> V(double[] dArr) {
        kotlin.jvm.internal.k.e(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    public static final List<Float> W(float[] fArr) {
        kotlin.jvm.internal.k.e(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    public static final List<Integer> X(int[] iArr) {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static final List<Long> Y(long[] jArr) {
        kotlin.jvm.internal.k.e(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static final <T> List<T> Z(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return new ArrayList(o.f(tArr));
    }

    public static final List<Short> a0(short[] sArr) {
        kotlin.jvm.internal.k.e(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    public static final <T> Set<T> b0(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) M(tArr, new LinkedHashSet(d0.a(tArr.length))) : g0.a(tArr[0]);
        }
        return h0.b();
    }

    public static final <T> boolean j(T[] tArr, T t10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return q(tArr, t10) >= 0;
    }

    public static final <T> List<T> k(T[] tArr, int i10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (i10 >= 0) {
            return L(tArr, bd.h.a(tArr.length - i10, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static final <T> List<T> l(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return (List) m(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C m(T[] tArr, C destination) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        for (T t10 : tArr) {
            if (t10 != null) {
                destination.add(t10);
            }
        }
        return destination;
    }

    public static final <T> T n(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static final <T> int o(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static final <T> T p(T[] tArr, int i10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        boolean z10 = false;
        if (i10 >= 0 && i10 < tArr.length) {
            z10 = true;
        }
        if (z10) {
            return tArr[i10];
        }
        return null;
    }

    public static final <T> int q(T[] tArr, T t10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kotlin.jvm.internal.k.a(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final <A extends Appendable> A r(double[] dArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Double, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(dArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (double d10 : dArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            buffer.append(lVar != null ? lVar.invoke(Double.valueOf(d10)) : String.valueOf(d10));
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A s(float[] fArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Float, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(fArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (float f10 : fArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            buffer.append(lVar != null ? lVar.invoke(Float.valueOf(f10)) : String.valueOf(f10));
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A t(int[] iArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Integer, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            buffer.append(lVar != null ? lVar.invoke(Integer.valueOf(i12)) : String.valueOf(i12));
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A u(long[] jArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Long, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(jArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (long j10 : jArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            buffer.append(lVar != null ? lVar.invoke(Long.valueOf(j10)) : String.valueOf(j10));
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T, A extends Appendable> A v(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ed.g.a(buffer, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A w(short[] sArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Short, ? extends CharSequence> lVar) throws IOException {
        kotlin.jvm.internal.k.e(sArr, "<this>");
        kotlin.jvm.internal.k.e(buffer, "buffer");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        buffer.append(prefix);
        int i11 = 0;
        for (short s10 : sArr) {
            i11++;
            if (i11 > 1) {
                buffer.append(separator);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            buffer.append(lVar != null ? lVar.invoke(Short.valueOf(s10)) : String.valueOf((int) s10));
        }
        if (i10 >= 0 && i11 > i10) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final String x(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Double, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(dArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) r(dArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static final String y(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Float, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(fArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) s(fArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }

    public static final String z(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i10, CharSequence truncated, xc.l<? super Integer, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.k.e(iArr, "<this>");
        kotlin.jvm.internal.k.e(separator, "separator");
        kotlin.jvm.internal.k.e(prefix, "prefix");
        kotlin.jvm.internal.k.e(postfix, "postfix");
        kotlin.jvm.internal.k.e(truncated, "truncated");
        return ((StringBuilder) t(iArr, new StringBuilder(), separator, prefix, postfix, i10, truncated, lVar)).toString();
    }
}
