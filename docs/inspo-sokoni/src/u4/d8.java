package u4;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class d8 implements Callable<List<h>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o7 f16112d;

    public d8(o7 o7Var, String str, String str2, String str3) {
        this.f16109a = str;
        this.f16110b = str2;
        this.f16111c = str3;
        this.f16112d = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<h> call() {
        this.f16112d.f16621a.I0();
        return this.f16112d.f16621a.s0().K(this.f16109a, this.f16110b, this.f16111c);
    }
}
