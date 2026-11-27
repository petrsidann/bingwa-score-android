package yb;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ac.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f19491d = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f19492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ac.c f19493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f19494c = new j(Level.FINE, (Class<?>) i.class);

    public interface a {
        void f(Throwable th);
    }

    public b(a aVar, ac.c cVar) {
        this.f19492a = (a) j6.m.p(aVar, "transportExceptionHandler");
        this.f19493b = (ac.c) j6.m.p(cVar, "frameWriter");
    }

    public static Level d(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // ac.c
    public void M(boolean z10, int i10, oe.d dVar, int i11) {
        this.f19494c.b(j.a.OUTBOUND, i10, dVar.d(), i11, z10);
        try {
            this.f19493b.M(z10, i10, dVar, i11);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public int T() {
        return this.f19493b.T();
    }

    @Override // ac.c
    public void U(boolean z10, boolean z11, int i10, int i11, List<ac.d> list) {
        try {
            this.f19493b.U(z10, z11, i10, i11, list);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void b(int i10, ac.a aVar) {
        this.f19494c.h(j.a.OUTBOUND, i10, aVar);
        try {
            this.f19493b.b(i10, aVar);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void b0(ac.i iVar) {
        this.f19494c.i(j.a.OUTBOUND, iVar);
        try {
            this.f19493b.b0(iVar);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void c(int i10, long j10) {
        this.f19494c.k(j.a.OUTBOUND, i10, j10);
        try {
            this.f19493b.c(i10, j10);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f19493b.close();
        } catch (IOException e10) {
            f19491d.log(d(e10), "Failed closing connection", (Throwable) e10);
        }
    }

    @Override // ac.c
    public void f(boolean z10, int i10, int i11) {
        j jVar = this.f19494c;
        j.a aVar = j.a.OUTBOUND;
        long j10 = (4294967295L & ((long) i11)) | (((long) i10) << 32);
        if (z10) {
            jVar.f(aVar, j10);
        } else {
            jVar.e(aVar, j10);
        }
        try {
            this.f19493b.f(z10, i10, i11);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void flush() {
        try {
            this.f19493b.flush();
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void m(int i10, ac.a aVar, byte[] bArr) {
        this.f19494c.c(j.a.OUTBOUND, i10, aVar, oe.g.t(bArr));
        try {
            this.f19493b.m(i10, aVar, bArr);
            this.f19493b.flush();
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void q() {
        try {
            this.f19493b.q();
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }

    @Override // ac.c
    public void x(ac.i iVar) {
        this.f19494c.j(j.a.OUTBOUND);
        try {
            this.f19493b.x(iVar);
        } catch (IOException e10) {
            this.f19492a.f(e10);
        }
    }
}
