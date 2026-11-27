package xb;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 extends m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<i1> f18641c = new ReferenceQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap<a, a> f18642d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f18643e = Logger.getLogger(i1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f18644b;

    public static final class a extends WeakReference<i1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f18645f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", "true"));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final RuntimeException f18646g = e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue<i1> f18647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<a, a> f18648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f18649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference<RuntimeException> f18650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f18651e;

        public a(i1 i1Var, vb.w0 w0Var, ReferenceQueue<i1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
            super(i1Var, referenceQueue);
            this.f18651e = new AtomicBoolean();
            this.f18650d = new SoftReference(f18645f ? new RuntimeException("ManagedChannel allocation site") : f18646g);
            this.f18649c = w0Var.toString();
            this.f18647a = referenceQueue;
            this.f18648b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        public static int b(ReferenceQueue<i1> referenceQueue) {
            int i10 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i10;
                }
                RuntimeException runtimeException = aVar.f18650d.get();
                aVar.c();
                if (!aVar.f18651e.get()) {
                    i10++;
                    Level level = Level.SEVERE;
                    if (i1.f18643e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        logRecord.setLoggerName(i1.f18643e.getName());
                        logRecord.setParameters(new Object[]{aVar.f18649c});
                        logRecord.setThrown(runtimeException);
                        i1.f18643e.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException e() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void c() {
            super.clear();
            this.f18648b.remove(this);
            this.f18650d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f18647a);
        }

        public final void d() {
            if (this.f18651e.getAndSet(true)) {
                return;
            }
            clear();
        }
    }

    public i1(vb.w0 w0Var) {
        this(w0Var, f18641c, f18642d);
    }

    public i1(vb.w0 w0Var, ReferenceQueue<i1> referenceQueue, ConcurrentMap<a, a> concurrentMap) {
        super(w0Var);
        this.f18644b = new a(this, w0Var, referenceQueue, concurrentMap);
    }

    @Override // xb.m0, vb.w0
    public vb.w0 m() {
        this.f18644b.d();
        return super.m();
    }

    @Override // xb.m0, vb.w0
    public vb.w0 n() {
        this.f18644b.d();
        return super.n();
    }
}
