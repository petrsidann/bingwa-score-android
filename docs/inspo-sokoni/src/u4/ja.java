package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f16395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16396b;

    public ja(e9 e9Var, Bundle bundle) {
        this.f16395a = bundle;
        this.f16396b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9.V0(this.f16396b, this.f16395a);
    }
}
