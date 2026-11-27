package u4;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class w7 implements Callable<List<bf>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o7 f16931b;

    public w7(o7 o7Var, String str) {
        this.f16930a = str;
        this.f16931b = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<bf> call() {
        this.f16931b.f16621a.I0();
        return this.f16931b.f16621a.s0().d1(this.f16930a);
    }
}
