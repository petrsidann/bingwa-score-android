package p1;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<Params, Progress, Result> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f14089f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f14090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Executor f14091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static f f14092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile Executor f14093o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h<Params, Result> f14094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FutureTask<Result> f14095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g f14096c = g.PENDING;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f14097d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f14098e = new AtomicBoolean();

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f14099a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f14099a.getAndIncrement());
        }
    }

    public class b extends h<Params, Result> {
        public b() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.concurrent.Callable
        public Result call() {
            c.this.f14098e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) c.this.b(this.f14109a);
                Binder.flushPendingCommands();
                c.this.l(result);
                return result;
            } catch (Throwable th) {
                try {
                    c.this.f14097d.set(true);
                    throw th;
                } catch (Throwable th2) {
                    c.this.l(result);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: p1.c$c, reason: collision with other inner class name */
    public class C0246c extends FutureTask<Result> {
        public C0246c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                c.this.m(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (CancellationException unused) {
                c.this.m(null);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14102a;

        static {
            int[] iArr = new int[g.values().length];
            f14102a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14102a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class e<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f14103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Data[] f14104b;

        public e(c cVar, Data... dataArr) {
            this.f14103a = cVar;
            this.f14104b = dataArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f14103a.d(eVar.f14104b[0]);
            } else {
                if (i10 != 2) {
                    return;
                }
                eVar.f14103a.k(eVar.f14104b);
            }
        }
    }

    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class h<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Params[] f14109a;
    }

    static {
        a aVar = new a();
        f14089f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f14090l = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f14091m = threadPoolExecutor;
        f14093o = threadPoolExecutor;
    }

    public c() {
        b bVar = new b();
        this.f14094a = bVar;
        this.f14095b = new C0246c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (c.class) {
            if (f14092n == null) {
                f14092n = new f();
            }
            fVar = f14092n;
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f14097d.set(true);
        return this.f14095b.cancel(z10);
    }

    public abstract Result b(Params... paramsArr);

    public final c<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f14096c == g.PENDING) {
            this.f14096c = g.RUNNING;
            j();
            this.f14094a.f14109a = paramsArr;
            executor.execute(this.f14095b);
            return this;
        }
        int i10 = d.f14102a[this.f14096c.ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i10 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f14096c = g.FINISHED;
    }

    public final boolean f() {
        return this.f14097d.get();
    }

    public void g() {
    }

    public void h(Result result) {
        g();
    }

    public void i(Result result) {
    }

    public void j() {
    }

    public void k(Progress... progressArr) {
    }

    public Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    public void m(Result result) {
        if (this.f14098e.get()) {
            return;
        }
        l(result);
    }
}
