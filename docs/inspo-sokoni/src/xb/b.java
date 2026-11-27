package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements y1 {
    @Override // xb.y1
    public void A() {
    }

    @Override // xb.y1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void d(int i10) {
        if (a() < i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // xb.y1
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        d(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // xb.y1
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
