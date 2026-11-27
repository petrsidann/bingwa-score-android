package o;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f13598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f13599d = new Executor() { // from class: o.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.g(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f13600e = new Executor() { // from class: o.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f13601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13602b;

    public c() {
        d dVar = new d();
        this.f13602b = dVar;
        this.f13601a = dVar;
    }

    public static c f() {
        if (f13598c != null) {
            return f13598c;
        }
        synchronized (c.class) {
            if (f13598c == null) {
                f13598c = new c();
            }
        }
        return f13598c;
    }

    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // o.f
    public void a(Runnable runnable) {
        this.f13601a.a(runnable);
    }

    @Override // o.f
    public boolean b() {
        return this.f13601a.b();
    }

    @Override // o.f
    public void c(Runnable runnable) {
        this.f13601a.c(runnable);
    }
}
