package u4;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class ga implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f16216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e9 f16217b;

    public ga(e9 e9Var, Bundle bundle) {
        this.f16216a = bundle;
        this.f16217b = e9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e9.c1(this.f16217b, this.f16216a);
    }
}
