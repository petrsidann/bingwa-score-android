package f8;

import com.google.protobuf.i;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[][] f8254c = {new byte[]{0, 0}, new byte[]{-128, 0}, new byte[]{-64, 0}, new byte[]{-32, 0}, new byte[]{-16, 0}, new byte[]{-8, 0}, new byte[]{-4, 0}, new byte[]{-2, 0}, new byte[]{-1, 0}, new byte[]{-1, -128}, new byte[]{-1, -64}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8256b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8255a = new byte[1024];

    public byte[] a() {
        return Arrays.copyOf(this.f8255a, this.f8256b);
    }

    public final void b(int i10) {
        int i11 = i10 + this.f8256b;
        byte[] bArr = this.f8255a;
        if (i11 <= bArr.length) {
            return;
        }
        int length = bArr.length * 2;
        if (length >= i11) {
            i11 = length;
        }
        this.f8255a = Arrays.copyOf(bArr, i11);
    }

    public void c(byte[] bArr) {
        b(bArr.length);
        for (byte b10 : bArr) {
            byte[] bArr2 = this.f8255a;
            int i10 = this.f8256b;
            this.f8256b = i10 + 1;
            bArr2[i10] = b10;
        }
    }

    public final int d(long j10) {
        if (j10 < 0) {
            j10 = ~j10;
        }
        return f.a((64 - Long.numberOfLeadingZeros(j10)) + 1, 7, RoundingMode.UP);
    }

    public final int e(long j10) {
        return f.a(64 - Long.numberOfLeadingZeros(j10), 8, RoundingMode.UP);
    }

    public final void f(byte b10) {
        if (b10 == 0) {
            l((byte) 0);
            l((byte) -1);
        } else if (b10 != -1) {
            l(b10);
        } else {
            l((byte) -1);
            l((byte) 0);
        }
    }

    public final void g(byte b10) {
        if (b10 == 0) {
            m((byte) 0);
            m((byte) -1);
        } else if (b10 != -1) {
            m(b10);
        } else {
            m((byte) -1);
            m((byte) 0);
        }
    }

    public void h(i iVar) {
        for (int i10 = 0; i10 < iVar.size(); i10++) {
            f(iVar.j(i10));
        }
        p();
    }

    public void i(i iVar) {
        for (int i10 = 0; i10 < iVar.size(); i10++) {
            g(iVar.j(i10));
        }
        q();
    }

    public void j(double d10) {
        long jDoubleToLongBits = Double.doubleToLongBits(d10);
        t(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void k(double d10) {
        long jDoubleToLongBits = Double.doubleToLongBits(d10);
        u(jDoubleToLongBits ^ (jDoubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public final void l(byte b10) {
        b(1);
        byte[] bArr = this.f8255a;
        int i10 = this.f8256b;
        this.f8256b = i10 + 1;
        bArr[i10] = b10;
    }

    public final void m(byte b10) {
        b(1);
        byte[] bArr = this.f8255a;
        int i10 = this.f8256b;
        this.f8256b = i10 + 1;
        bArr[i10] = (byte) (~b10);
    }

    public void n() {
        l((byte) -1);
        l((byte) -1);
    }

    public void o() {
        m((byte) -1);
        m((byte) -1);
    }

    public final void p() {
        l((byte) 0);
        l((byte) 1);
    }

    public final void q() {
        m((byte) 0);
        m((byte) 1);
    }

    public void r(long j10) {
        int i10;
        long j11 = j10 < 0 ? ~j10 : j10;
        if (j11 < 64) {
            b(1);
            byte[] bArr = this.f8255a;
            int i11 = this.f8256b;
            this.f8256b = i11 + 1;
            bArr[i11] = (byte) (j10 ^ ((long) f8254c[1][0]));
            return;
        }
        int iD = d(j11);
        b(iD);
        if (iD < 2) {
            throw new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", Integer.valueOf(iD)));
        }
        byte b10 = j10 < 0 ? (byte) -1 : (byte) 0;
        int i12 = this.f8256b;
        if (iD == 10) {
            i10 = i12 + 2;
            byte[] bArr2 = this.f8255a;
            bArr2[i12] = b10;
            bArr2[i12 + 1] = b10;
        } else if (iD == 9) {
            i10 = i12 + 1;
            this.f8255a[i12] = b10;
        } else {
            i10 = i12;
        }
        for (int i13 = (iD - 1) + i12; i13 >= i10; i13--) {
            this.f8255a[i13] = (byte) (255 & j10);
            j10 >>= 8;
        }
        byte[] bArr3 = this.f8255a;
        int i14 = this.f8256b;
        byte b11 = bArr3[i14];
        byte[] bArr4 = f8254c[iD];
        bArr3[i14] = (byte) (b11 ^ bArr4[0]);
        int i15 = i14 + 1;
        bArr3[i15] = (byte) (bArr4[1] ^ bArr3[i15]);
        this.f8256b = i14 + iD;
    }

    public void s(long j10) {
        r(~j10);
    }

    public void t(long j10) {
        int iE = e(j10);
        b(iE + 1);
        byte[] bArr = this.f8255a;
        int i10 = this.f8256b;
        int i11 = i10 + 1;
        this.f8256b = i11;
        bArr[i10] = (byte) iE;
        int i12 = i11 + iE;
        while (true) {
            i12--;
            int i13 = this.f8256b;
            if (i12 < i13) {
                this.f8256b = i13 + iE;
                return;
            } else {
                this.f8255a[i12] = (byte) (255 & j10);
                j10 >>>= 8;
            }
        }
    }

    public void u(long j10) {
        int iE = e(j10);
        b(iE + 1);
        byte[] bArr = this.f8255a;
        int i10 = this.f8256b;
        int i11 = i10 + 1;
        this.f8256b = i11;
        bArr[i10] = (byte) (~iE);
        int i12 = i11 + iE;
        while (true) {
            i12--;
            int i13 = this.f8256b;
            if (i12 < i13) {
                this.f8256b = i13 + iE;
                return;
            } else {
                this.f8255a[i12] = (byte) (~(255 & j10));
                j10 >>>= 8;
            }
        }
    }

    public void v(CharSequence charSequence) {
        int i10;
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int iCharAt = charSequence.charAt(i11);
            if (iCharAt >= 128) {
                if (iCharAt < 2048) {
                    i10 = (iCharAt >>> 6) | 960;
                } else {
                    if (iCharAt < 55296 || 57343 < iCharAt) {
                        f((byte) ((iCharAt >>> 12) | 480));
                        i10 = ((iCharAt >>> 6) & 63) | 128;
                    } else {
                        iCharAt = Character.codePointAt(charSequence, i11);
                        i11++;
                        f((byte) ((iCharAt >>> 18) | 240));
                        f((byte) (((iCharAt >>> 12) & 63) | 128));
                        f((byte) (((iCharAt >>> 6) & 63) | 128));
                    }
                    iCharAt = (iCharAt & 63) | 128;
                }
                f((byte) i10);
                iCharAt = (iCharAt & 63) | 128;
            }
            f((byte) iCharAt);
            i11++;
        }
        p();
    }

    public void w(CharSequence charSequence) {
        int i10;
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length) {
            int iCharAt = charSequence.charAt(i11);
            if (iCharAt >= 128) {
                if (iCharAt < 2048) {
                    i10 = (iCharAt >>> 6) | 960;
                } else {
                    if (iCharAt < 55296 || 57343 < iCharAt) {
                        g((byte) ((iCharAt >>> 12) | 480));
                        i10 = ((iCharAt >>> 6) & 63) | 128;
                    } else {
                        iCharAt = Character.codePointAt(charSequence, i11);
                        i11++;
                        g((byte) ((iCharAt >>> 18) | 240));
                        g((byte) (((iCharAt >>> 12) & 63) | 128));
                        g((byte) (((iCharAt >>> 6) & 63) | 128));
                    }
                    iCharAt = (iCharAt & 63) | 128;
                }
                g((byte) i10);
                iCharAt = (iCharAt & 63) | 128;
            }
            g((byte) iCharAt);
            i11++;
        }
        q();
    }
}
