package u4;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class b8 implements Callable<List<bf>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f16020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o7 f16022d;

    public b8(o7 o7Var, String str, String str2, String str3) {
        this.f16019a = str;
        this.f16020b = str2;
        this.f16021c = str3;
        this.f16022d = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<bf> call() {
        this.f16022d.f16621a.I0();
        return this.f16022d.f16621a.s0().I0(this.f16019a, this.f16020b, this.f16021c);
    }
}
