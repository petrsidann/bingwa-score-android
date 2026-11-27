package xb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1 f19103a = new c(new byte[0]);

    public class a extends o0 {
        public a(y1 y1Var) {
            super(y1Var);
        }

        @Override // xb.y1, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static final class b extends InputStream implements vb.s0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y1 f19104a;

        public b(y1 y1Var) {
            this.f19104a = (y1) j6.m.p(y1Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f19104a.a();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f19104a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f19104a.A();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f19104a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f19104a.a() == 0) {
                return -1;
            }
            return this.f19104a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            if (this.f19104a.a() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f19104a.a(), i11);
            this.f19104a.w(bArr, i10, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f19104a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            int iMin = (int) Math.min(this.f19104a.a(), j10);
            this.f19104a.skipBytes(iMin);
            return iMin;
        }
    }

    public static class c extends xb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f19107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19108d;

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        public c(byte[] bArr, int i10, int i11) {
            this.f19108d = -1;
            j6.m.e(i10 >= 0, "offset must be >= 0");
            j6.m.e(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            j6.m.e(i12 <= bArr.length, "offset + length exceeds array boundary");
            this.f19107c = (byte[]) j6.m.p(bArr, "bytes");
            this.f19105a = i10;
            this.f19106b = i12;
        }

        @Override // xb.b, xb.y1
        public void A() {
            this.f19108d = this.f19105a;
        }

        @Override // xb.y1
        public void N(OutputStream outputStream, int i10) throws IOException {
            d(i10);
            outputStream.write(this.f19107c, this.f19105a, i10);
            this.f19105a += i10;
        }

        @Override // xb.y1
        public void W(ByteBuffer byteBuffer) {
            j6.m.p(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            d(iRemaining);
            byteBuffer.put(this.f19107c, this.f19105a, iRemaining);
            this.f19105a += iRemaining;
        }

        @Override // xb.y1
        public int a() {
            return this.f19106b - this.f19105a;
        }

        @Override // xb.y1
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public c l(int i10) {
            d(i10);
            int i11 = this.f19105a;
            this.f19105a = i11 + i10;
            return new c(this.f19107c, i11, i10);
        }

        @Override // xb.b, xb.y1
        public boolean markSupported() {
            return true;
        }

        @Override // xb.y1
        public int readUnsignedByte() {
            d(1);
            byte[] bArr = this.f19107c;
            int i10 = this.f19105a;
            this.f19105a = i10 + 1;
            return bArr[i10] & 255;
        }

        @Override // xb.b, xb.y1
        public void reset() {
            int i10 = this.f19108d;
            if (i10 == -1) {
                throw new InvalidMarkException();
            }
            this.f19105a = i10;
        }

        @Override // xb.y1
        public void skipBytes(int i10) {
            d(i10);
            this.f19105a += i10;
        }

        @Override // xb.y1
        public void w(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.f19107c, this.f19105a, bArr, i10, i11);
            this.f19105a += i11;
        }
    }

    public static y1 a() {
        return f19103a;
    }

    public static y1 b(y1 y1Var) {
        return new a(y1Var);
    }

    public static InputStream c(y1 y1Var, boolean z10) {
        if (!z10) {
            y1Var = b(y1Var);
        }
        return new b(y1Var);
    }

    public static byte[] d(y1 y1Var) {
        j6.m.p(y1Var, "buffer");
        int iA = y1Var.a();
        byte[] bArr = new byte[iA];
        y1Var.w(bArr, 0, iA);
        return bArr;
    }

    public static String e(y1 y1Var, Charset charset) {
        j6.m.p(charset, "charset");
        return new String(d(y1Var), charset);
    }

    public static y1 f(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }
}
