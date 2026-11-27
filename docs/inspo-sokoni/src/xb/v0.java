package xb;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class v0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Logger f19014g = Logger.getLogger(v0.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j6.p f19016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<t.a, Executor> f19017c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f19019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19020f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f19021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f19022b;

        public a(t.a aVar, long j10) {
            this.f19021a = aVar;
            this.f19022b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19021a.b(this.f19022b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t.a f19023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f19024b;

        public b(t.a aVar, Throwable th) {
            this.f19023a = aVar;
            this.f19024b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19023a.a(this.f19024b);
        }
    }

    public v0(long j10, j6.p pVar) {
        this.f19015a = j10;
        this.f19016b = pVar;
    }

    public static Runnable b(t.a aVar, long j10) {
        return new a(aVar, j10);
    }

    public static Runnable c(t.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f19014g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(t.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(t.a aVar, Executor executor) {
        synchronized (this) {
            if (!this.f19018d) {
                this.f19017c.put(aVar, executor);
            } else {
                Throwable th = this.f19019e;
                e(executor, th != null ? c(aVar, th) : b(aVar, this.f19020f));
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            if (this.f19018d) {
                return false;
            }
            this.f19018d = true;
            long jD = this.f19016b.d(TimeUnit.NANOSECONDS);
            this.f19020f = jD;
            Map<t.a, Executor> map = this.f19017c;
            this.f19017c = null;
            for (Map.Entry<t.a, Executor> entry : map.entrySet()) {
                e(entry.getValue(), b(entry.getKey(), jD));
            }
            return true;
        }
    }

    public void f(Throwable th) {
        synchronized (this) {
            if (this.f19018d) {
                return;
            }
            this.f19018d = true;
            this.f19019e = th;
            Map<t.a, Executor> map = this.f19017c;
            this.f19017c = null;
            for (Map.Entry<t.a, Executor> entry : map.entrySet()) {
                g(entry.getKey(), entry.getValue(), th);
            }
        }
    }

    public long h() {
        return this.f19015a;
    }
}
