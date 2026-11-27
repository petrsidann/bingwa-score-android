package u4;

import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class p8 implements Callable<List<sd>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ me f16700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f16701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o7 f16702c;

    public p8(o7 o7Var, me meVar, Bundle bundle) {
        this.f16700a = meVar;
        this.f16701b = bundle;
        this.f16702c = o7Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<sd> call() {
        this.f16702c.f16621a.I0();
        return this.f16702c.f16621a.h(this.f16700a, this.f16701b);
    }
}
