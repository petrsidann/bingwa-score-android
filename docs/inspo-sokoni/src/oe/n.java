package oe;

import java.io.EOFException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f13884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f13885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13886c;

    public n(t source) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f13884a = source;
        this.f13885b = new d();
    }

    @Override // oe.f
    public byte[] H(long j10) throws EOFException {
        V(j10);
        return this.f13885b.H(j10);
    }

    @Override // oe.f
    public void V(long j10) throws EOFException {
        if (!d(j10)) {
            throw new EOFException();
        }
    }

    @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.f13886c) {
            return;
        }
        this.f13886c = true;
        this.f13884a.close();
        this.f13885b.t();
    }

    public boolean d(long j10) {
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f13886c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.f13885b.size() < j10) {
            if (this.f13884a.s(this.f13885b, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // oe.f
    public g i(long j10) throws EOFException {
        V(j10);
        return this.f13885b.i(j10);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f13886c;
    }

    @Override // oe.f
    public d o() {
        return this.f13885b;
    }

    @Override // oe.f
    public boolean p() {
        if (!this.f13886c) {
            return this.f13885b.p() && this.f13884a.s(this.f13885b, 8192L) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (this.f13885b.size() == 0 && this.f13884a.s(this.f13885b, 8192L) == -1) {
            return -1;
        }
        return this.f13885b.read(sink);
    }

    @Override // oe.f
    public byte readByte() throws EOFException {
        V(1L);
        return this.f13885b.readByte();
    }

    @Override // oe.f
    public int readInt() throws EOFException {
        V(4L);
        return this.f13885b.readInt();
    }

    @Override // oe.f
    public short readShort() throws EOFException {
        V(2L);
        return this.f13885b.readShort();
    }

    @Override // oe.t
    public long s(d sink, long j10) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        if (!(!this.f13886c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f13885b.size() == 0 && this.f13884a.s(this.f13885b, 8192L) == -1) {
            return -1L;
        }
        return this.f13885b.s(sink, Math.min(j10, this.f13885b.size()));
    }

    @Override // oe.f
    public void skip(long j10) throws EOFException {
        if (!(!this.f13886c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j10 > 0) {
            if (this.f13885b.size() == 0 && this.f13884a.s(this.f13885b, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f13885b.size());
            this.f13885b.skip(jMin);
            j10 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f13884a + ')';
    }
}
