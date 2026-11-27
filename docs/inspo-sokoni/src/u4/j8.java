package u4;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class j8 implements Callable<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16392b;

    public j8(o7 o7Var, me meVar) {
        this.f16391a = meVar;
        this.f16392b = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ q call() {
        this.f16392b.f16621a.I0();
        return new q(this.f16392b.f16621a.c(this.f16391a.f16528a));
    }
}
