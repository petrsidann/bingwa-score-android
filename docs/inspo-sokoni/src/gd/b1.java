package gd;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f9139a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        j0 j0Var = this.f9139a;
        oc.j jVar = oc.j.f13812a;
        if (j0Var.d0(jVar)) {
            this.f9139a.c0(jVar, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f9139a.toString();
    }
}
