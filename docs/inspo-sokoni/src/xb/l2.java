package xb;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final l2 f18715d = new l2(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<d<?>, c> f18716a = new IdentityHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f18717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f18718c;

    public class a implements e {
        @Override // xb.l2.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(r0.j("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f18719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f18720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f18721c;

        public b(c cVar, d dVar, Object obj) {
            this.f18719a = cVar;
            this.f18720b = dVar;
            this.f18721c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (l2.this) {
                if (this.f18719a.f18724b == 0) {
                    try {
                        this.f18720b.b(this.f18721c);
                        l2.this.f18716a.remove(this.f18720b);
                        if (l2.this.f18716a.isEmpty()) {
                            l2.this.f18718c.shutdown();
                            l2.this.f18718c = null;
                        }
                    } catch (Throwable th) {
                        l2.this.f18716a.remove(this.f18720b);
                        if (l2.this.f18716a.isEmpty()) {
                            l2.this.f18718c.shutdown();
                            l2.this.f18718c = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ScheduledFuture<?> f18725c;

        public c(Object obj) {
            this.f18723a = obj;
        }
    }

    public interface d<T> {
        T a();

        void b(T t10);
    }

    public interface e {
        ScheduledExecutorService a();
    }

    public l2(e eVar) {
        this.f18717b = eVar;
    }

    public static <T> T d(d<T> dVar) {
        return (T) f18715d.e(dVar);
    }

    public static <T> T f(d<T> dVar, T t10) {
        return (T) f18715d.g(dVar, t10);
    }

    public synchronized <T> T e(d<T> dVar) {
        c cVar;
        cVar = this.f18716a.get(dVar);
        if (cVar == null) {
            cVar = new c(dVar.a());
            this.f18716a.put(dVar, cVar);
        }
        ScheduledFuture<?> scheduledFuture = cVar.f18725c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            cVar.f18725c = null;
        }
        cVar.f18724b++;
        return (T) cVar.f18723a;
    }

    public synchronized <T> T g(d<T> dVar, T t10) {
        c cVar = this.f18716a.get(dVar);
        if (cVar == null) {
            throw new IllegalArgumentException("No cached instance found for " + dVar);
        }
        j6.m.e(t10 == cVar.f18723a, "Releasing the wrong instance");
        j6.m.v(cVar.f18724b > 0, "Refcount has already reached zero");
        int i10 = cVar.f18724b - 1;
        cVar.f18724b = i10;
        if (i10 == 0) {
            j6.m.v(cVar.f18725c == null, "Destroy task already scheduled");
            if (this.f18718c == null) {
                this.f18718c = this.f18717b.a();
            }
            cVar.f18725c = this.f18718c.schedule(new d1(new b(cVar, dVar, t10)), 1L, TimeUnit.SECONDS);
        }
        return null;
    }
}
