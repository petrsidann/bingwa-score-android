package gd;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class q1 {
    public static final j0 a(Executor executor) {
        j0 j0Var;
        b1 b1Var = executor instanceof b1 ? (b1) executor : null;
        return (b1Var == null || (j0Var = b1Var.f9139a) == null) ? new p1(executor) : j0Var;
    }

    public static final o1 b(ExecutorService executorService) {
        return new p1(executorService);
    }
}
