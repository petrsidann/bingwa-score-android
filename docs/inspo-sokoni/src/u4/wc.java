package u4;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
public final class wc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f16936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uc f16937b;

    public wc(uc ucVar, ComponentName componentName) {
        this.f16936a = componentName;
        this.f16937b = ucVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        qb.Q(this.f16937b.f16875c, this.f16936a);
    }
}
