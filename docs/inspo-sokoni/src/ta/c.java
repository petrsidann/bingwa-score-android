package ta;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c implements fb.b, ta.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f15883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, f> f15884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<b>> f15885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f15886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f15887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, fb.b.InterfaceC0141b> f15888f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f15889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f15890h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakHashMap<fb.b.c, d> f15891i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f15892j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f15893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f15895c;

        public b(ByteBuffer byteBuffer, int i10, long j10) {
            this.f15893a = byteBuffer;
            this.f15894b = i10;
            this.f15895c = j10;
        }
    }

    /* JADX INFO: renamed from: ta.c$c, reason: collision with other inner class name */
    public static class C0288c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f15896a;

        public C0288c(ExecutorService executorService) {
            this.f15896a = executorService;
        }

        @Override // ta.c.d
        public void a(Runnable runnable) {
            this.f15896a.execute(runnable);
        }
    }

    public interface d {
        void a(Runnable runnable);
    }

    public static class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExecutorService f15897a = qa.a.e().b();

        @Override // ta.c.i
        public d a(fb.b.d dVar) {
            return dVar.a() ? new h(this.f15897a) : new C0288c(this.f15897a);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb.b.a f15898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f15899b;

        public f(fb.b.a aVar, d dVar) {
            this.f15898a = aVar;
            this.f15899b = dVar;
        }
    }

    public static class g implements fb.b.InterfaceC0141b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlutterJNI f15900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f15902c = new AtomicBoolean(false);

        public g(FlutterJNI flutterJNI, int i10) {
            this.f15900a = flutterJNI;
            this.f15901b = i10;
        }

        @Override // fb.b.InterfaceC0141b
        public void a(ByteBuffer byteBuffer) {
            if (this.f15902c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f15900a.invokePlatformMessageEmptyResponseCallback(this.f15901b);
            } else {
                this.f15900a.invokePlatformMessageResponseCallback(this.f15901b, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f15903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue<Runnable> f15904b = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f15905c = new AtomicBoolean(false);

        public h(ExecutorService executorService) {
            this.f15903a = executorService;
        }

        @Override // ta.c.d
        public void a(Runnable runnable) {
            this.f15904b.add(runnable);
            this.f15903a.execute(new Runnable() { // from class: ta.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15906a.e();
                }
            });
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final void f() {
            if (this.f15905c.compareAndSet(false, true)) {
                try {
                    Runnable runnablePoll = this.f15904b.poll();
                    if (runnablePoll != null) {
                        runnablePoll.run();
                    }
                } finally {
                    this.f15905c.set(false);
                    if (!this.f15904b.isEmpty()) {
                        this.f15903a.execute(new Runnable() { // from class: ta.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f15907a.f();
                            }
                        });
                    }
                }
            }
        }
    }

    public interface i {
        d a(fb.b.d dVar);
    }

    public static class j implements fb.b.c {
        public j() {
        }
    }

    public c(FlutterJNI flutterJNI) {
        this(flutterJNI, new e());
    }

    public c(FlutterJNI flutterJNI, i iVar) {
        this.f15884b = new HashMap();
        this.f15885c = new HashMap();
        this.f15886d = new Object();
        this.f15887e = new AtomicBoolean(false);
        this.f15888f = new HashMap();
        this.f15889g = 1;
        this.f15890h = new ta.g();
        this.f15891i = new WeakHashMap<>();
        this.f15883a = flutterJNI;
        this.f15892j = iVar;
    }

    public static void k(Error error) {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, int i10, f fVar, ByteBuffer byteBuffer, long j10) {
        ub.e.v("PlatformChannel ScheduleHandler on " + str, i10);
        try {
            ub.e eVarZ = ub.e.z("DartMessenger#handleMessageFromDart on " + str);
            try {
                l(fVar, byteBuffer, i10);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
                if (eVarZ != null) {
                    eVarZ.close();
                }
                this.f15883a.cleanupMessageData(j10);
            } catch (Throwable th) {
                if (eVarZ != null) {
                    try {
                        eVarZ.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            this.f15883a.cleanupMessageData(j10);
            throw th3;
        }
    }

    @Override // fb.b
    public fb.b.c a(fb.b.d dVar) {
        d dVarA = this.f15892j.a(dVar);
        j jVar = new j();
        this.f15891i.put(jVar, dVarA);
        return jVar;
    }

    @Override // fb.b
    public void c(String str, fb.b.a aVar, fb.b.c cVar) {
        d dVar;
        if (aVar == null) {
            qa.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f15886d) {
                this.f15884b.remove(str);
            }
            return;
        }
        if (cVar != null) {
            dVar = this.f15891i.get(cVar);
            if (dVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            dVar = null;
        }
        qa.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f15886d) {
            this.f15884b.put(str, new f(aVar, dVar));
            List<b> listRemove = this.f15885c.remove(str);
            if (listRemove == null) {
                return;
            }
            for (b bVar : listRemove) {
                j(str, this.f15884b.get(str), bVar.f15893a, bVar.f15894b, bVar.f15895c);
            }
        }
    }

    @Override // fb.b
    public void d(String str, fb.b.a aVar) {
        c(str, aVar, null);
    }

    @Override // fb.b
    public void e(String str, ByteBuffer byteBuffer) {
        qa.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        f(str, byteBuffer, null);
    }

    @Override // fb.b
    public void f(String str, ByteBuffer byteBuffer, fb.b.InterfaceC0141b interfaceC0141b) {
        ub.e eVarZ = ub.e.z("DartMessenger#send on " + str);
        try {
            qa.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i10 = this.f15889g;
            this.f15889g = i10 + 1;
            if (interfaceC0141b != null) {
                this.f15888f.put(Integer.valueOf(i10), interfaceC0141b);
            }
            if (byteBuffer == null) {
                this.f15883a.dispatchEmptyPlatformMessage(str, i10);
            } else {
                this.f15883a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i10);
            }
            if (eVarZ != null) {
                eVarZ.close();
            }
        } catch (Throwable th) {
            if (eVarZ != null) {
                try {
                    eVarZ.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // ta.f
    public void g(int i10, ByteBuffer byteBuffer) {
        qa.b.f("DartMessenger", "Received message reply from Dart.");
        fb.b.InterfaceC0141b interfaceC0141bRemove = this.f15888f.remove(Integer.valueOf(i10));
        if (interfaceC0141bRemove != null) {
            try {
                qa.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                interfaceC0141bRemove.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e10) {
                k(e10);
            } catch (Exception e11) {
                qa.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e11);
            }
        }
    }

    @Override // ta.f
    public void h(String str, ByteBuffer byteBuffer, int i10, long j10) {
        f fVar;
        boolean z10;
        qa.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f15886d) {
            fVar = this.f15884b.get(str);
            z10 = this.f15887e.get() && fVar == null;
            if (z10) {
                if (!this.f15885c.containsKey(str)) {
                    this.f15885c.put(str, new LinkedList());
                }
                this.f15885c.get(str).add(new b(byteBuffer, i10, j10));
            }
        }
        if (z10) {
            return;
        }
        j(str, fVar, byteBuffer, i10, j10);
    }

    public final void j(final String str, final f fVar, final ByteBuffer byteBuffer, final int i10, final long j10) {
        d dVar = fVar != null ? fVar.f15899b : null;
        ub.e.e("PlatformChannel ScheduleHandler on " + str, i10);
        Runnable runnable = new Runnable() { // from class: ta.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f15877a.m(str, i10, fVar, byteBuffer, j10);
            }
        };
        if (dVar == null) {
            dVar = this.f15890h;
        }
        dVar.a(runnable);
    }

    public final void l(f fVar, ByteBuffer byteBuffer, int i10) {
        if (fVar != null) {
            try {
                qa.b.f("DartMessenger", "Deferring to registered handler to process message.");
                fVar.f15898a.a(byteBuffer, new g(this.f15883a, i10));
                return;
            } catch (Error e10) {
                k(e10);
                return;
            } catch (Exception e11) {
                qa.b.c("DartMessenger", "Uncaught exception in binary message listener", e11);
            }
        } else {
            qa.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f15883a.invokePlatformMessageEmptyResponseCallback(i10);
    }
}
