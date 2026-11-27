package oe;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class h implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f13876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f13877b;

    public h(InputStream input, u timeout) {
        kotlin.jvm.internal.k.e(input, "input");
        kotlin.jvm.internal.k.e(timeout, "timeout");
        this.f13876a = input;
        this.f13877b = timeout;
    }

    @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13876a.close();
    }

    @Override // oe.t
    public long s(d sink, long j10) throws IOException {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
        }
        try {
            this.f13877b.c();
            o oVarL0 = sink.l0(1);
            int i10 = this.f13876a.read(oVarL0.f13888a, oVarL0.f13890c, (int) Math.min(j10, 8192 - oVarL0.f13890c));
            if (i10 != -1) {
                oVarL0.f13890c += i10;
                long j11 = i10;
                sink.i0(sink.size() + j11);
                return j11;
            }
            if (oVarL0.f13889b != oVarL0.f13890c) {
                return -1L;
            }
            sink.f13862a = oVarL0.b();
            p.b(oVarL0);
            return -1L;
        } catch (AssertionError e10) {
            if (i.c(e10)) {
                throw new IOException(e10);
            }
            throw e10;
        }
    }

    public String toString() {
        return "source(" + this.f13876a + ')';
    }
}
