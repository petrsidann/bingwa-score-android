package u4;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class m8 implements Callable<List<sd>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f16512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16513c;

    public m8(o7 o7Var, me meVar, Bundle bundle) {
        this.f16511a = meVar;
        this.f16512b = bundle;
        this.f16513c = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<sd> call() {
        this.f16513c.f16621a.I0();
        return this.f16513c.f16621a.h(this.f16511a, this.f16512b);
    }
}
