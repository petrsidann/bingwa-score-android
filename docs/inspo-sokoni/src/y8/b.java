package y8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y8.a f19429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile y8.a f19430b;

    /* JADX INFO: renamed from: y8.b$b, reason: collision with other inner class name */
    public static class C0337b implements y8.a {
        public C0337b() {
        }

        @Override // y8.a
        public ExecutorService a(ThreadFactory threadFactory, c cVar) {
            return b(1, threadFactory, cVar);
        }

        public ExecutorService b(int i10, ThreadFactory threadFactory, c cVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        C0337b c0337b = new C0337b();
        f19429a = c0337b;
        f19430b = c0337b;
    }

    public static y8.a a() {
        return f19430b;
    }
}
