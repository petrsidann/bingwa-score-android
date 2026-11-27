package bc;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import oe.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final char[] f3049e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3053d;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3056c = -1;

        public static String b(String str, int i10, int i11) {
            String strD = a.d(str, i10, i11, false);
            if (!strD.startsWith("[") || !strD.endsWith("]")) {
                return f(strD);
            }
            InetAddress inetAddressE = e(strD, 1, strD.length() - 1);
            if (inetAddressE == null) {
                return null;
            }
            byte[] address = inetAddressE.getAddress();
            if (address.length == 16) {
                return i(address);
            }
            throw new AssertionError();
        }

        public static boolean c(String str) {
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        public static boolean d(String str, int i10, int i11, byte[] bArr, int i12) {
            int i13 = i12;
            while (i10 < i11) {
                if (i13 == bArr.length) {
                    return false;
                }
                if (i13 != i12) {
                    if (str.charAt(i10) != '.') {
                        return false;
                    }
                    i10++;
                }
                int i14 = i10;
                int i15 = 0;
                while (i14 < i11) {
                    char cCharAt = str.charAt(i14);
                    if (cCharAt < '0' || cCharAt > '9') {
                        break;
                    }
                    if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + cCharAt) - 48) > 255) {
                        return false;
                    }
                    i14++;
                }
                if (i14 - i10 == 0) {
                    return false;
                }
                bArr[i13] = (byte) i15;
                i13++;
                i10 = i14;
            }
            return i13 == i12 + 4;
        }

        /* JADX WARN: Code duplicated, block: B:31:0x004f  */
        /* JADX WARN: Code duplicated, block: B:34:0x005a A[LOOP:1: B:30:0x004d->B:34:0x005a, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:59:0x0060 A[EDGE_INSN: B:59:0x0060->B:35:0x0060 BREAK  A[LOOP:1: B:30:0x004d->B:34:0x005a], SYNTHETIC] */
        public static InetAddress e(String str, int i10, int i11) {
            int i12;
            int i13;
            int iA;
            byte[] bArr = new byte[16];
            int i14 = 0;
            int i15 = -1;
            int i16 = -1;
            while (i10 < i11) {
                if (i14 == 16) {
                    return null;
                }
                int i17 = i10 + 2;
                if (i17 <= i11 && str.regionMatches(i10, "::", 0, 2)) {
                    if (i15 != -1) {
                        return null;
                    }
                    i14 += 2;
                    i15 = i14;
                    if (i17 == i11) {
                        break;
                    }
                    i16 = i17;
                    i12 = 0;
                    i10 = i16;
                    while (i10 < i11) {
                        iA = a.a(str.charAt(i10));
                        if (iA == -1) {
                            break;
                            break;
                        }
                        i12 = (i12 << 4) + iA;
                        i10++;
                    }
                    i13 = i10 - i16;
                    if (i13 != 0) {
                    }
                    return null;
                }
                if (i14 != 0) {
                    if (!str.regionMatches(i10, ":", 0, 1)) {
                        if (!str.regionMatches(i10, ".", 0, 1) || !d(str, i16, i11, bArr, i14 - 2)) {
                            return null;
                        }
                        i14 += 2;
                        break;
                    }
                    i10++;
                }
                i16 = i10;
                i12 = 0;
                i10 = i16;
                while (i10 < i11) {
                    iA = a.a(str.charAt(i10));
                    if (iA == -1) {
                        break;
                    }
                    i12 = (i12 << 4) + iA;
                    i10++;
                }
                i13 = i10 - i16;
                if (i13 != 0 || i13 > 4) {
                    return null;
                }
                int i18 = i14 + 1;
                bArr[i14] = (byte) ((i12 >>> 8) & 255);
                i14 = i18 + 1;
                bArr[i18] = (byte) (i12 & 255);
            }
            if (i14 != 16) {
                if (i15 == -1) {
                    return null;
                }
                int i19 = i14 - i15;
                System.arraycopy(bArr, i15, bArr, 16 - i19, i19);
                Arrays.fill(bArr, i15, (16 - i14) + i15, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }

        public static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty() || c(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public static String i(byte[] bArr) {
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < bArr.length) {
                int i14 = i12;
                while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                    i14 += 2;
                }
                int i15 = i14 - i12;
                if (i15 > i13) {
                    i10 = i12;
                    i13 = i15;
                }
                i12 = i14 + 2;
            }
            d dVar = new d();
            while (i11 < bArr.length) {
                if (i11 == i10) {
                    dVar.writeByte(58);
                    i11 += i13;
                    if (i11 == 16) {
                        dVar.writeByte(58);
                    }
                } else {
                    if (i11 > 0) {
                        dVar.writeByte(58);
                    }
                    dVar.q0(((bArr[i11] & 255) << 8) | (bArr[i11 + 1] & 255));
                    i11 += 2;
                }
            }
            return dVar.e0();
        }

        public a a() {
            if (this.f3054a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f3055b != null) {
                return new a(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int g() {
            int i10 = this.f3056c;
            return i10 != -1 ? i10 : a.b(this.f3054a);
        }

        public b h(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String strB = b(str, 0, str.length());
            if (strB != null) {
                this.f3055b = strB;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public b j(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f3056c = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        public b k(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f3054a = str2;
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3054a);
            sb2.append("://");
            if (this.f3055b.indexOf(58) != -1) {
                sb2.append('[');
                sb2.append(this.f3055b);
                sb2.append(']');
            } else {
                sb2.append(this.f3055b);
            }
            int iG = g();
            if (iG != a.b(this.f3054a)) {
                sb2.append(':');
                sb2.append(iG);
            }
            return sb2.toString();
        }
    }

    public a(b bVar) {
        this.f3050a = bVar.f3054a;
        this.f3051b = bVar.f3055b;
        this.f3052c = bVar.g();
        this.f3053d = bVar.toString();
    }

    public static int a(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static String d(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                d dVar = new d();
                dVar.v0(str, i10, i12);
                e(dVar, str, i12, i11, z10);
                return dVar.e0();
            }
        }
        return str.substring(i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void e(d dVar, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int iCodePointAt = str.codePointAt(i10);
            if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                int iA = a(str.charAt(i10 + 1));
                int iA2 = a(str.charAt(i12));
                if (iA == -1 || iA2 == -1) {
                    dVar.w0(iCodePointAt);
                } else {
                    dVar.writeByte((iA << 4) + iA2);
                    i10 = i12;
                }
            } else if (iCodePointAt == 43 && z10) {
                dVar.writeByte(32);
            } else {
                dVar.w0(iCodePointAt);
            }
            i10 += Character.charCount(iCodePointAt);
        }
    }

    public String c() {
        return this.f3051b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f3053d.equals(this.f3053d);
    }

    public int f() {
        return this.f3052c;
    }

    public int hashCode() {
        return this.f3053d.hashCode();
    }

    public String toString() {
        return this.f3053d;
    }
}
