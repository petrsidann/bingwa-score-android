package c4;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends k0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f3375f;

    public /* synthetic */ i0(Callable callable, j0 j0Var) {
        super();
        this.f3375f = callable;
    }

    @Override // c4.k0
    public final String a() {
        try {
            return (String) this.f3375f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
