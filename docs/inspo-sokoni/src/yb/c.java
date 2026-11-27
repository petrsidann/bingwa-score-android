package yb;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements ac.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ac.c f19495a;

    public c(ac.c cVar) {
        this.f19495a = (ac.c) j6.m.p(cVar, "delegate");
    }

    @Override // ac.c
    public void M(boolean z10, int i10, oe.d dVar, int i11) {
        this.f19495a.M(z10, i10, dVar, i11);
    }

    @Override // ac.c
    public int T() {
        return this.f19495a.T();
    }

    @Override // ac.c
    public void U(boolean z10, boolean z11, int i10, int i11, List<ac.d> list) {
        this.f19495a.U(z10, z11, i10, i11, list);
    }

    @Override // ac.c
    public void b(int i10, ac.a aVar) {
        this.f19495a.b(i10, aVar);
    }

    @Override // ac.c
    public void b0(ac.i iVar) {
        this.f19495a.b0(iVar);
    }

    @Override // ac.c
    public void c(int i10, long j10) {
        this.f19495a.c(i10, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f19495a.close();
    }

    @Override // ac.c
    public void f(boolean z10, int i10, int i11) {
        this.f19495a.f(z10, i10, i11);
    }

    @Override // ac.c
    public void flush() {
        this.f19495a.flush();
    }

    @Override // ac.c
    public void m(int i10, ac.a aVar, byte[] bArr) {
        this.f19495a.m(i10, aVar, bArr);
    }

    @Override // ac.c
    public void q() {
        this.f19495a.q();
    }

    @Override // ac.c
    public void x(ac.i iVar) {
        this.f19495a.x(iVar);
    }
}
