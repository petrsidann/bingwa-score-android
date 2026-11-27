package xb;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1.b f18418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xb.f f18419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1 f18420c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18421a;

        public a(int i10) {
            this.f18421a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f18420c.isClosed()) {
                return;
            }
            try {
                e.this.f18420c.d(this.f18421a);
            } catch (Throwable th) {
                e.this.f18419b.e(th);
                e.this.f18420c.close();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y1 f18423a;

        public b(y1 y1Var) {
            this.f18423a = y1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.this.f18420c.t(this.f18423a);
            } catch (Throwable th) {
                e.this.f18419b.e(th);
                e.this.f18420c.close();
            }
        }
    }

    public class c implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y1 f18425a;

        public c(y1 y1Var) {
            this.f18425a = y1Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18425a.close();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f18420c.k();
        }
    }

    /* JADX INFO: renamed from: xb.e$e, reason: collision with other inner class name */
    public class RunnableC0327e implements Runnable {
        public RunnableC0327e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f18420c.close();
        }
    }

    public class f extends g implements Closeable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Closeable f18429d;

        public f(Runnable runnable, Closeable closeable) {
            super(e.this, runnable, null);
            this.f18429d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18429d.close();
        }
    }

    public class g implements q2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f18431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18432b;

        public g(Runnable runnable) {
            this.f18432b = false;
            this.f18431a = runnable;
        }

        public /* synthetic */ g(e eVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        public final void d() {
            if (this.f18432b) {
                return;
            }
            this.f18431a.run();
            this.f18432b = true;
        }

        @Override // xb.q2.a
        public InputStream next() {
            d();
            return e.this.f18419b.f();
        }
    }

    public interface h extends xb.f.d {
    }

    public e(l1.b bVar, h hVar, l1 l1Var) {
        n2 n2Var = new n2((l1.b) j6.m.p(bVar, "listener"));
        this.f18418a = n2Var;
        xb.f fVar = new xb.f(n2Var, hVar);
        this.f18419b = fVar;
        l1Var.O(fVar);
        this.f18420c = l1Var;
    }

    @Override // xb.z
    public void close() {
        this.f18420c.Q();
        this.f18418a.a(new g(this, new RunnableC0327e(), null));
    }

    @Override // xb.z
    public void d(int i10) {
        this.f18418a.a(new g(this, new a(i10), null));
    }

    @Override // xb.z
    public void e(int i10) {
        this.f18420c.e(i10);
    }

    @Override // xb.z
    public void k() {
        this.f18418a.a(new g(this, new d(), null));
    }

    @Override // xb.z
    public void t(y1 y1Var) {
        this.f18418a.a(new f(new b(y1Var), new c(y1Var)));
    }

    @Override // xb.z
    public void v(vb.v vVar) {
        this.f18420c.v(vVar);
    }
}
