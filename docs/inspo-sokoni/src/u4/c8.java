package u4;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class c8 implements Callable<List<bf>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o7 f16071d;

    public c8(o7 o7Var, String str, String str2, String str3) {
        this.f16068a = str;
        this.f16069b = str2;
        this.f16070c = str3;
        this.f16071d = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<bf> call() {
        this.f16071d.f16621a.I0();
        return this.f16071d.f16621a.s0().I0(this.f16068a, this.f16069b, this.f16070c);
    }
}
