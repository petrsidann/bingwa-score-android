package nd;

import gd.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f13582c;

    public k(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f13582c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f13582c.run();
        } finally {
            this.f13580b.a();
        }
    }

    public String toString() {
        return "Task[" + q0.a(this.f13582c) + '@' + q0.b(this.f13582c) + ", " + this.f13579a + ", " + this.f13580b + ']';
    }
}
