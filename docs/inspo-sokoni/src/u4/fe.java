package u4;

/* JADX INFO: loaded from: classes.dex */
public abstract class fe extends wd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16202c;

    public fe(ge geVar) {
        super(geVar);
        this.f16938b.L0();
    }

    public final void q() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void r() {
        if (this.f16202c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        t();
        this.f16938b.K0();
        this.f16202c = true;
    }

    public final boolean s() {
        return this.f16202c;
    }

    public abstract boolean t();
}
