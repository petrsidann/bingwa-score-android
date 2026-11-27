package m0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class h {

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12895b;

        /* JADX INFO: renamed from: m0.h$a$a, reason: collision with other inner class name */
        public static class C0212a extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f12896a;

            public C0212a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f12896a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f12896a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f12894a = str;
            this.f12895b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0212a(runnable, this.f12894a, this.f12895b);
        }
    }

    public static class b<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Callable<T> f12897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public o0.a<T> f12898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Handler f12899c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o0.a f12900a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f12901b;

            public a(o0.a aVar, Object obj) {
                this.f12900a = aVar;
                this.f12901b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f12900a.accept(this.f12901b);
            }
        }

        public b(Handler handler, Callable<T> callable, o0.a<T> aVar) {
            this.f12897a = callable;
            this.f12898b = aVar;
            this.f12899c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T tCall;
            try {
                tCall = this.f12897a.call();
            } catch (Exception unused) {
                tCall = null;
            }
            this.f12899c.post(new a(this.f12898b, tCall));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static <T> void b(Executor executor, Callable<T> callable, o0.a<T> aVar) {
        executor.execute(new b(m0.b.a(), callable, aVar));
    }

    public static <T> T c(ExecutorService executorService, Callable<T> callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
