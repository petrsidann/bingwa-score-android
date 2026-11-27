package u4;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class w9 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e9 f16934a;

    public w9(e9 e9Var) {
        this.f16934a = e9Var;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f16934a.zzl().y(runnable);
    }
}
