package r7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class z implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f15128f = Logger.getLogger(z.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f15129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<Runnable> f15130b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f15131c = c.IDLE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15132d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f15133e = new b(this, null);

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f15134a;

        public a(Runnable runnable) {
            this.f15134a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15134a.run();
        }

        public String toString() {
            return this.f15134a.toString();
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f15136a;

        public b() {
        }

        public /* synthetic */ b(z zVar, a aVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            if (r1 == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        
            r8.f15136a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        
            r7.z.f15128f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f15136a, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
        
            r8.f15136a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a() {
            boolean z10 = false;
            boolean zInterrupted = false;
            while (true) {
                try {
                    synchronized (z.this.f15130b) {
                        if (!z10) {
                            c cVar = z.this.f15131c;
                            c cVar2 = c.RUNNING;
                            if (cVar != cVar2) {
                                z.e(z.this);
                                z.this.f15131c = cVar2;
                                z10 = true;
                            }
                        }
                        Runnable runnable = (Runnable) z.this.f15130b.poll();
                        this.f15136a = runnable;
                        if (runnable == null) {
                            z.this.f15131c = c.IDLE;
                        }
                    }
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                    this.f15136a = null;
                } catch (Throwable th) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (z.this.f15130b) {
                    z.this.f15131c = c.IDLE;
                    throw e10;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f15136a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + z.this.f15131c + "}";
        }
    }

    public enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public z(Executor executor) {
        this.f15129a = (Executor) com.google.android.gms.common.internal.r.l(executor);
    }

    public static /* synthetic */ long e(z zVar) {
        long j10 = zVar.f15132d;
        zVar.f15132d = 1 + j10;
        return j10;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        com.google.android.gms.common.internal.r.l(runnable);
        synchronized (this.f15130b) {
            c cVar2 = this.f15131c;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j10 = this.f15132d;
                a aVar = new a(runnable);
                this.f15130b.add(aVar);
                c cVar3 = c.QUEUING;
                this.f15131c = cVar3;
                boolean z10 = true;
                try {
                    this.f15129a.execute(this.f15133e);
                    if (this.f15131c != cVar3) {
                        return;
                    }
                    synchronized (this.f15130b) {
                        if (this.f15132d == j10 && this.f15131c == cVar3) {
                            this.f15131c = cVar;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f15130b) {
                        c cVar4 = this.f15131c;
                        if ((cVar4 != c.IDLE && cVar4 != c.QUEUING) || !this.f15130b.removeLastOccurrence(aVar)) {
                            z10 = false;
                        }
                        if (!(e10 instanceof RejectedExecutionException) || z10) {
                            throw e10;
                        }
                    }
                    return;
                }
            }
            this.f15130b.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f15129a + "}";
    }
}
