package d3;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class m implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6349a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f6350a;

        public a(Runnable runnable) {
            this.f6350a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6350a.run();
            } catch (Exception e10) {
                h3.a.c("Executor", "Background execution failure.", e10);
            }
        }
    }

    public m(Executor executor) {
        this.f6349a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f6349a.execute(new a(runnable));
    }
}
