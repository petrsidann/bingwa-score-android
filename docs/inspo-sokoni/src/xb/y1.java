package xb;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface y1 extends Closeable {
    void A();

    default void K() {
    }

    void N(OutputStream outputStream, int i10);

    void W(ByteBuffer byteBuffer);

    int a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    y1 l(int i10);

    boolean markSupported();

    int readUnsignedByte();

    void reset();

    void skipBytes(int i10);

    void w(byte[] bArr, int i10, int i11);
}
