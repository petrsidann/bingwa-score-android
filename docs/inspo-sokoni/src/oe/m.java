package oe;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f13881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f13882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13883c;

    public m(r sink) {
        kotlin.jvm.internal.k.e(sink, "sink");
        this.f13881a = sink;
        this.f13882b = new d();
    }

    @Override // oe.r
    public void X(d source, long j10) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.X(source, j10);
        d();
    }

    @Override // oe.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f13883c) {
            return;
        }
        if (this.f13882b.size() > 0) {
            r rVar = this.f13881a;
            d dVar = this.f13882b;
            rVar.X(dVar, dVar.size());
        }
        th = null;
        try {
            this.f13881a.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.f13883c = true;
        if (th != null) {
            throw th;
        }
    }

    public e d() {
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        long jZ = this.f13882b.z();
        if (jZ > 0) {
            this.f13881a.X(this.f13882b, jZ);
        }
        return this;
    }

    @Override // oe.e, oe.r, java.io.Flushable
    public void flush() {
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f13882b.size() > 0) {
            r rVar = this.f13881a;
            d dVar = this.f13882b;
            rVar.X(dVar, dVar.size());
        }
        this.f13881a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f13883c;
    }

    public String toString() {
        return "buffer(" + this.f13881a + ')';
    }

    @Override // oe.e
    public e u(String string) {
        kotlin.jvm.internal.k.e(string, "string");
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.u(string);
        return d();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f13882b.write(source);
        d();
        return iWrite;
    }

    @Override // oe.e
    public e write(byte[] source) {
        kotlin.jvm.internal.k.e(source, "source");
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.write(source);
        return d();
    }

    @Override // oe.e
    public e writeByte(int i10) {
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.writeByte(i10);
        return d();
    }

    @Override // oe.e
    public e writeInt(int i10) {
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.writeInt(i10);
        return d();
    }

    @Override // oe.e
    public e writeShort(int i10) {
        if (!(!this.f13883c)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f13882b.writeShort(i10);
        return d();
    }
}
