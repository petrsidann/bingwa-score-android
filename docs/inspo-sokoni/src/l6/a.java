package l6;

import j6.m;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12496a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12497b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12498c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12499d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12500e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: renamed from: l6.a$a, reason: collision with other inner class name */
    public static final class C0208a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f12502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f12504d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12505e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12506f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f12507g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f12508h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f12509i;

        public C0208a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        public C0208a(String str, char[] cArr, byte[] bArr, boolean z10) {
            this.f12501a = (String) m.o(str);
            this.f12502b = (char[]) m.o(cArr);
            try {
                int iD = m6.a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f12504d = iD;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
                int i10 = 1 << (3 - iNumberOfTrailingZeros);
                this.f12505e = i10;
                this.f12506f = iD >> iNumberOfTrailingZeros;
                this.f12503c = cArr.length - 1;
                this.f12507g = bArr;
                boolean[] zArr = new boolean[i10];
                for (int i11 = 0; i11 < this.f12506f; i11++) {
                    zArr[m6.a.a(i11 * 8, this.f12504d, RoundingMode.CEILING)] = true;
                }
                this.f12508h = zArr;
                this.f12509i = z10;
            } catch (ArithmeticException e10) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e10);
            }
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i10 = 0; i10 < cArr.length; i10++) {
                char c10 = cArr[i10];
                boolean z10 = true;
                m.f(c10 < 128, "Non-ASCII character: %s", c10);
                if (bArr[c10] != -1) {
                    z10 = false;
                }
                m.f(z10, "Duplicate character: %s", c10);
                bArr[c10] = (byte) i10;
            }
            return bArr;
        }

        public int c(char c10) throws d {
            if (c10 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            byte b10 = this.f12507g[c10];
            if (b10 != -1) {
                return b10;
            }
            if (c10 <= ' ' || c10 == 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c10));
            }
            throw new d("Unrecognized character: " + c10);
        }

        public char d(int i10) {
            return this.f12502b[i10];
        }

        public boolean e(int i10) {
            return this.f12508h[i10 % this.f12505e];
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0208a)) {
                return false;
            }
            C0208a c0208a = (C0208a) obj;
            return this.f12509i == c0208a.f12509i && Arrays.equals(this.f12502b, c0208a.f12502b);
        }

        public boolean f(char c10) {
            byte[] bArr = this.f12507g;
            return c10 < bArr.length && bArr[c10] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f12502b) + (this.f12509i ? 1231 : 1237);
        }

        public String toString() {
            return this.f12501a;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final char[] f12510h;

        public b(String str, String str2) {
            this(new C0208a(str, str2.toCharArray()));
        }

        public b(C0208a c0208a) {
            super(c0208a, null);
            this.f12510h = new char[512];
            m.d(c0208a.f12502b.length == 16);
            for (int i10 = 0; i10 < 256; i10++) {
                this.f12510h[i10] = c0208a.d(i10 >>> 4);
                this.f12510h[i10 | 256] = c0208a.d(i10 & 15);
            }
        }

        @Override // l6.a.e, l6.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.o(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequence.length()) {
                bArr[i11] = (byte) ((this.f12511f.c(charSequence.charAt(i10)) << 4) | this.f12511f.c(charSequence.charAt(i10 + 1)));
                i10 += 2;
                i11++;
            }
            return i11;
        }

        @Override // l6.a.e, l6.a
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            m.o(appendable);
            m.t(i10, i10 + i11, bArr.length);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = bArr[i10 + i12] & 255;
                appendable.append(this.f12510h[i13]);
                appendable.append(this.f12510h[i13 | 256]);
            }
        }

        @Override // l6.a.e
        public a n(C0208a c0208a, Character ch) {
            return new b(c0208a);
        }
    }

    public static final class c extends e {
        public c(String str, String str2, Character ch) {
            this(new C0208a(str, str2.toCharArray()), ch);
        }

        public c(C0208a c0208a, Character ch) {
            super(c0208a, ch);
            m.d(c0208a.f12502b.length == 64);
        }

        @Override // l6.a.e, l6.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            m.o(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f12511f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceL.length()) {
                int i12 = i10 + 1;
                int i13 = i12 + 1;
                int iC = (this.f12511f.c(charSequenceL.charAt(i10)) << 18) | (this.f12511f.c(charSequenceL.charAt(i12)) << 12);
                int i14 = i11 + 1;
                bArr[i11] = (byte) (iC >>> 16);
                if (i13 < charSequenceL.length()) {
                    int i15 = i13 + 1;
                    int iC2 = iC | (this.f12511f.c(charSequenceL.charAt(i13)) << 6);
                    i11 = i14 + 1;
                    bArr[i14] = (byte) ((iC2 >>> 8) & 255);
                    if (i15 < charSequenceL.length()) {
                        i13 = i15 + 1;
                        i14 = i11 + 1;
                        bArr[i11] = (byte) ((iC2 | this.f12511f.c(charSequenceL.charAt(i15))) & 255);
                    } else {
                        i10 = i15;
                    }
                }
                i11 = i14;
                i10 = i13;
            }
            return i11;
        }

        @Override // l6.a.e, l6.a
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            m.o(appendable);
            int i12 = i10 + i11;
            m.t(i10, i12, bArr.length);
            while (i11 >= 3) {
                int i13 = i10 + 1;
                int i14 = i13 + 1;
                int i15 = ((bArr[i10] & 255) << 16) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                appendable.append(this.f12511f.d(i15 >>> 18));
                appendable.append(this.f12511f.d((i15 >>> 12) & 63));
                appendable.append(this.f12511f.d((i15 >>> 6) & 63));
                appendable.append(this.f12511f.d(i15 & 63));
                i11 -= 3;
                i10 = i14 + 1;
            }
            if (i10 < i12) {
                m(appendable, bArr, i10, i12 - i10);
            }
        }

        @Override // l6.a.e
        public a n(C0208a c0208a, Character ch) {
            return new c(c0208a, ch);
        }
    }

    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C0208a f12511f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Character f12512g;

        public e(String str, String str2, Character ch) {
            this(new C0208a(str, str2.toCharArray()), ch);
        }

        public e(C0208a c0208a, Character ch) {
            this.f12511f = (C0208a) m.o(c0208a);
            m.k(ch == null || !c0208a.f(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f12512g = ch;
        }

        @Override // l6.a
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            C0208a c0208a;
            m.o(bArr);
            CharSequence charSequenceL = l(charSequence);
            if (!this.f12511f.e(charSequenceL.length())) {
                throw new d("Invalid input length " + charSequenceL.length());
            }
            int i10 = 0;
            int i11 = 0;
            while (i10 < charSequenceL.length()) {
                long jC = 0;
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    c0208a = this.f12511f;
                    if (i12 >= c0208a.f12505e) {
                        break;
                    }
                    jC <<= c0208a.f12504d;
                    if (i10 + i12 < charSequenceL.length()) {
                        jC |= (long) this.f12511f.c(charSequenceL.charAt(i13 + i10));
                        i13++;
                    }
                    i12++;
                }
                int i14 = c0208a.f12506f;
                int i15 = (i14 * 8) - (i13 * c0208a.f12504d);
                int i16 = (i14 - 1) * 8;
                while (i16 >= i15) {
                    bArr[i11] = (byte) ((jC >>> i16) & 255);
                    i16 -= 8;
                    i11++;
                }
                i10 += this.f12511f.f12505e;
            }
            return i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f12511f.equals(eVar.f12511f) && Objects.equals(this.f12512g, eVar.f12512g);
        }

        @Override // l6.a
        public void g(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            m.o(appendable);
            m.t(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (i12 < i11) {
                m(appendable, bArr, i10 + i12, Math.min(this.f12511f.f12506f, i11 - i12));
                i12 += this.f12511f.f12506f;
            }
        }

        public int hashCode() {
            return this.f12511f.hashCode() ^ Objects.hashCode(this.f12512g);
        }

        @Override // l6.a
        public int i(int i10) {
            return (int) (((((long) this.f12511f.f12504d) * ((long) i10)) + 7) / 8);
        }

        @Override // l6.a
        public int j(int i10) {
            C0208a c0208a = this.f12511f;
            return c0208a.f12505e * m6.a.a(i10, c0208a.f12506f, RoundingMode.CEILING);
        }

        @Override // l6.a
        public a k() {
            return this.f12512g == null ? this : n(this.f12511f, null);
        }

        @Override // l6.a
        public CharSequence l(CharSequence charSequence) {
            m.o(charSequence);
            Character ch = this.f12512g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void m(Appendable appendable, byte[] bArr, int i10, int i11) throws IOException {
            m.o(appendable);
            m.t(i10, i10 + i11, bArr.length);
            int i12 = 0;
            m.d(i11 <= this.f12511f.f12506f);
            long j10 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                j10 = (j10 | ((long) (bArr[i10 + i13] & 255))) << 8;
            }
            int i14 = ((i11 + 1) * 8) - this.f12511f.f12504d;
            while (i12 < i11 * 8) {
                C0208a c0208a = this.f12511f;
                appendable.append(c0208a.d(((int) (j10 >>> (i14 - i12))) & c0208a.f12503c));
                i12 += this.f12511f.f12504d;
            }
            if (this.f12512g != null) {
                while (i12 < this.f12511f.f12506f * 8) {
                    appendable.append(this.f12512g.charValue());
                    i12 += this.f12511f.f12504d;
                }
            }
        }

        public a n(C0208a c0208a, Character ch) {
            return new e(c0208a, ch);
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.f12511f);
            if (8 % this.f12511f.f12504d != 0) {
                if (this.f12512g == null) {
                    str = ".omitPadding()";
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.f12512g);
                    str = "')";
                }
                sb2.append(str);
            }
            return sb2.toString();
        }
    }

    public static a a() {
        return f12496a;
    }

    public static byte[] h(byte[] bArr, int i10) {
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i10];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public final byte[] c(CharSequence charSequence) {
        CharSequence charSequenceL = l(charSequence);
        byte[] bArr = new byte[i(charSequenceL.length())];
        return h(bArr, d(bArr, charSequenceL));
    }

    public abstract int d(byte[] bArr, CharSequence charSequence);

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i10, int i11) {
        m.t(i10, i10 + i11, bArr.length);
        StringBuilder sb2 = new StringBuilder(j(i11));
        try {
            g(sb2, bArr, i10, i11);
            return sb2.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i10, int i11);

    public abstract int i(int i10);

    public abstract int j(int i10);

    public abstract a k();

    public abstract CharSequence l(CharSequence charSequence);
}
