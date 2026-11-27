package u4;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class k8 implements Callable<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f16440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16442c;

    public k8(o7 o7Var, n0 n0Var, String str) {
        this.f16440a = n0Var;
        this.f16441b = str;
        this.f16442c = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() {
        this.f16442c.f16621a.I0();
        return this.f16442c.f16621a.C0().u(this.f16440a, this.f16441b);
    }
}
