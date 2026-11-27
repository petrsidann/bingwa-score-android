package u4;

/* JADX INFO: loaded from: classes.dex */
public abstract class f4 extends g5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16182b;

    public f4(k7 k7Var) {
        super(k7Var);
        this.f16624a.l();
    }

    public final boolean s() {
        return this.f16182b;
    }

    public abstract boolean t();

    public final void u() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (this.f16182b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (t()) {
            return;
        }
        this.f16624a.k();
        this.f16182b = true;
    }

    public final void w() {
        if (this.f16182b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        x();
        this.f16624a.k();
        this.f16182b = true;
    }

    public void x() {
    }
}
