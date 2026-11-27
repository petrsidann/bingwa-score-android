package u4;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class e8 implements Callable<List<h>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o7 f16140d;

    public e8(o7 o7Var, String str, String str2, String str3) {
        this.f16137a = str;
        this.f16138b = str2;
        this.f16139c = str3;
        this.f16140d = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<h> call() {
        this.f16140d.f16621a.I0();
        return this.f16140d.f16621a.s0().K(this.f16137a, this.f16138b, this.f16139c);
    }
}
