package oe;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f13879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f13880b;

    public l(OutputStream out, u timeout) {
        kotlin.jvm.internal.k.e(out, "out");
        kotlin.jvm.internal.k.e(timeout, "timeout");
        this.f13879a = out;
        this.f13880b = timeout;
    }

    @Override // oe.r
    public void X(d source, long j10) throws IOException {
        kotlin.jvm.internal.k.e(source, "source");
        b.b(source.size(), 0L, j10);
        while (j10 > 0) {
            this.f13880b.c();
            o oVar = source.f13862a;
            kotlin.jvm.internal.k.b(oVar);
            int iMin = (int) Math.min(j10, oVar.f13890c - oVar.f13889b);
            this.f13879a.write(oVar.f13888a, oVar.f13889b, iMin);
            oVar.f13889b += iMin;
            long j11 = iMin;
            j10 -= j11;
            source.i0(source.size() - j11);
            if (oVar.f13889b == oVar.f13890c) {
                source.f13862a = oVar.b();
                p.b(oVar);
            }
        }
    }

    @Override // oe.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13879a.close();
    }

    @Override // oe.r, java.io.Flushable
    public void flush() throws IOException {
        this.f13879a.flush();
    }

    public String toString() {
        return "sink(" + this.f13879a + ')';
    }
}
