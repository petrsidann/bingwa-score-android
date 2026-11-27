package xb;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements l1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l1.b f18436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<InputStream> f18437c = new ArrayDeque();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18438a;

        public a(int i10) {
            this.f18438a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f18436b.d(this.f18438a);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18440a;

        public b(boolean z10) {
            this.f18440a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f18436b.c(this.f18440a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f18442a;

        public c(Throwable th) {
            this.f18442a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f18436b.e(this.f18442a);
        }
    }

    public interface d {
        void f(Runnable runnable);
    }

    public f(l1.b bVar, d dVar) {
        this.f18436b = (l1.b) j6.m.p(bVar, "listener");
        this.f18435a = (d) j6.m.p(dVar, "transportExecutor");
    }

    @Override // xb.l1.b
    public void a(q2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f18437c.add(next);
            }
        }
    }

    @Override // xb.l1.b
    public void c(boolean z10) {
        this.f18435a.f(new b(z10));
    }

    @Override // xb.l1.b
    public void d(int i10) {
        this.f18435a.f(new a(i10));
    }

    @Override // xb.l1.b
    public void e(Throwable th) {
        this.f18435a.f(new c(th));
    }

    public InputStream f() {
        return this.f18437c.poll();
    }
}
