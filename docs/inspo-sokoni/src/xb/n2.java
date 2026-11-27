package xb;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class n2 extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1.b f18778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18779b;

    public n2(l1.b bVar) {
        this.f18778a = bVar;
    }

    @Override // xb.l0, xb.l1.b
    public void a(q2.a aVar) {
        if (!this.f18779b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            r0.d((Closeable) aVar);
        }
    }

    @Override // xb.l0
    public l1.b b() {
        return this.f18778a;
    }

    @Override // xb.l0, xb.l1.b
    public void c(boolean z10) {
        this.f18779b = true;
        super.c(z10);
    }

    @Override // xb.l0, xb.l1.b
    public void e(Throwable th) {
        this.f18779b = true;
        super.e(th);
    }
}
