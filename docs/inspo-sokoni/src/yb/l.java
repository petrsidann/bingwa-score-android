package yb;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import xb.y1;

/* JADX INFO: loaded from: classes2.dex */
public class l extends xb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oe.d f19635a;

    public l(oe.d dVar) {
        this.f19635a = dVar;
    }

    @Override // xb.y1
    public void N(OutputStream outputStream, int i10) throws IOException {
        this.f19635a.t0(outputStream, i10);
    }

    @Override // xb.y1
    public void W(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // xb.y1
    public int a() {
        return (int) this.f19635a.size();
    }

    @Override // xb.b, xb.y1, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.f19635a.t();
    }

    public final void e() {
    }

    @Override // xb.y1
    public y1 l(int i10) {
        oe.d dVar = new oe.d();
        dVar.X(this.f19635a, i10);
        return new l(dVar);
    }

    @Override // xb.y1
    public int readUnsignedByte() {
        try {
            e();
            return this.f19635a.readByte() & 255;
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    @Override // xb.y1
    public void skipBytes(int i10) {
        try {
            this.f19635a.skip(i10);
        } catch (EOFException e10) {
            throw new IndexOutOfBoundsException(e10.getMessage());
        }
    }

    @Override // xb.y1
    public void w(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            int i12 = this.f19635a.read(bArr, i10, i11);
            if (i12 == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i11 + " bytes");
            }
            i11 -= i12;
            i10 += i12;
        }
    }
}
