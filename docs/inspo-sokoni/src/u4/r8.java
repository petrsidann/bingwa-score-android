package u4;

/* JADX INFO: loaded from: classes.dex */
public abstract class r8 extends o8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16756b;

    public r8(k7 k7Var) {
        super(k7Var);
        this.f16624a.l();
    }

    public void k() {
    }

    public final void l() {
        if (!o()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (this.f16756b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (p()) {
            return;
        }
        this.f16624a.k();
        this.f16756b = true;
    }

    public final void n() {
        if (this.f16756b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        k();
        this.f16624a.k();
        this.f16756b = true;
    }

    public final boolean o() {
        return this.f16756b;
    }

    public abstract boolean p();
}
