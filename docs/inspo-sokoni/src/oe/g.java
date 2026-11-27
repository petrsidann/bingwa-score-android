package oe;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Serializable, Comparable<g> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f13871d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g f13872e = new g(new byte[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f13874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient String f13875c;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final g a(String str) {
            kotlin.jvm.internal.k.e(str, "<this>");
            g gVar = new g(v.a(str));
            gVar.x(str);
            return gVar;
        }

        public final g b(byte... data) {
            kotlin.jvm.internal.k.e(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(this, size)");
            return new g(bArrCopyOf);
        }
    }

    public g(byte[] data) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f13873a = data;
    }

    public static final g i(String str) {
        return f13871d.a(str);
    }

    public static final g t(byte... bArr) {
        return f13871d.b(bArr);
    }

    public g A() {
        for (int i10 = 0; i10 < l().length; i10++) {
            byte b10 = l()[i10];
            if (b10 >= 65 && b10 <= 90) {
                byte[] bArrL = l();
                byte[] bArrCopyOf = Arrays.copyOf(bArrL, bArrL.length);
                kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b10 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b11 = bArrCopyOf[i11];
                    if (b11 >= 65 && b11 <= 90) {
                        bArrCopyOf[i11] = (byte) (b11 + 32);
                    }
                }
                return new g(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] B() {
        byte[] bArrL = l();
        byte[] bArrCopyOf = Arrays.copyOf(bArrL, bArrL.length);
        kotlin.jvm.internal.k.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String C() {
        String strP = p();
        if (strP != null) {
            return strP;
        }
        String strB = v.b(r());
        x(strB);
        return strB;
    }

    public void D(d buffer, int i10, int i11) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        pe.b.c(this, buffer, i10, i11);
    }

    public String d() {
        return oe.a.b(l(), null, 1, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (gVar.y() == l().length && gVar.v(0, l(), 0, l().length)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r0 < r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L13;
     */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(g other) {
        kotlin.jvm.internal.k.e(other, "other");
        int iY = y();
        int iY2 = other.y();
        int iMin = Math.min(iY, iY2);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iK = k(i10) & 255;
            int iK2 = other.k(i10) & 255;
            if (iK == iK2) {
            }
        }
        if (iY == iY2) {
            return 0;
        }
    }

    public int hashCode() {
        int iN = n();
        if (iN != 0) {
            return iN;
        }
        int iHashCode = Arrays.hashCode(l());
        w(iHashCode);
        return iHashCode;
    }

    public final byte k(int i10) {
        return s(i10);
    }

    public final byte[] l() {
        return this.f13873a;
    }

    public final int n() {
        return this.f13874b;
    }

    public int o() {
        return l().length;
    }

    public final String p() {
        return this.f13875c;
    }

    public String q() {
        char[] cArr = new char[l().length * 2];
        int i10 = 0;
        for (byte b10 : l()) {
            int i11 = i10 + 1;
            cArr[i10] = pe.b.d()[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = pe.b.d()[b10 & 15];
        }
        return ed.q.l(cArr);
    }

    public byte[] r() {
        return l();
    }

    public byte s(int i10) {
        return l()[i10];
    }

    public String toString() {
        StringBuilder sb2;
        String str;
        if (!(l().length == 0)) {
            int iB = pe.b.b(l(), 64);
            if (iB != -1) {
                String strC = C();
                String strSubstring = strC.substring(0, iB);
                kotlin.jvm.internal.k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strP = ed.q.p(ed.q.p(ed.q.p(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iB < strC.length()) {
                    sb2 = new StringBuilder();
                    sb2.append("[size=");
                    sb2.append(l().length);
                    sb2.append(" text=");
                    sb2.append(strP);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("[text=");
                    sb2.append(strP);
                    sb2.append(']');
                }
                return sb2.toString();
            }
            if (l().length <= 64) {
                str = "[hex=" + q() + ']';
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(l().length);
                sb2.append(" hex=");
                int iC = b.c(this, 64);
                if (!(iC <= l().length)) {
                    throw new IllegalArgumentException(("endIndex > length(" + l().length + ')').toString());
                }
                if (!(iC + 0 >= 0)) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                sb2.append((iC == l().length ? this : new g(mc.j.h(l(), 0, iC))).q());
            }
            sb2.append("…]");
            return sb2.toString();
        }
        str = "[size=0]";
        return str;
    }

    public boolean u(int i10, g other, int i11, int i12) {
        kotlin.jvm.internal.k.e(other, "other");
        return other.v(i11, l(), i10, i12);
    }

    public boolean v(int i10, byte[] other, int i11, int i12) {
        kotlin.jvm.internal.k.e(other, "other");
        return i10 >= 0 && i10 <= l().length - i12 && i11 >= 0 && i11 <= other.length - i12 && b.a(l(), i10, other, i11, i12);
    }

    public final void w(int i10) {
        this.f13874b = i10;
    }

    public final void x(String str) {
        this.f13875c = str;
    }

    public final int y() {
        return o();
    }

    public final boolean z(g prefix) {
        kotlin.jvm.internal.k.e(prefix, "prefix");
        return u(0, prefix, 0, prefix.y());
    }
}
