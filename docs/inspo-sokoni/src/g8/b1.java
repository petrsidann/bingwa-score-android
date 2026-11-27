package g8;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b1 extends h1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m1 f8680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8681k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v0 f8673c = new v0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<c8.j, z0> f8674d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w0 f8676f = new w0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d1 f8677g = new d1(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s0 f8678h = new s0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c1 f8679i = new c1();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<c8.j, t0> f8675e = new HashMap();

    public static b1 o() {
        b1 b1Var = new b1();
        b1Var.u(new u0(b1Var));
        return b1Var;
    }

    public static b1 p(q0.b bVar, p pVar) {
        b1 b1Var = new b1();
        b1Var.u(new y0(b1Var, bVar, pVar));
        return b1Var;
    }

    @Override // g8.h1
    public a a() {
        return this.f8678h;
    }

    @Override // g8.h1
    public b b(c8.j jVar) {
        t0 t0Var = this.f8675e.get(jVar);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0();
        this.f8675e.put(jVar, t0Var2);
        return t0Var2;
    }

    @Override // g8.h1
    public g c() {
        return this.f8673c;
    }

    @Override // g8.h1
    public e1 e(c8.j jVar, m mVar) {
        z0 z0Var = this.f8674d.get(jVar);
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(this, jVar);
        this.f8674d.put(jVar, z0Var2);
        return z0Var2;
    }

    @Override // g8.h1
    public f1 f() {
        return new a1();
    }

    @Override // g8.h1
    public m1 g() {
        return this.f8680j;
    }

    @Override // g8.h1
    public boolean j() {
        return this.f8681k;
    }

    @Override // g8.h1
    public <T> T k(String str, l8.y<T> yVar) {
        this.f8680j.f();
        try {
            return yVar.get();
        } finally {
            this.f8680j.d();
        }
    }

    @Override // g8.h1
    public void l(String str, Runnable runnable) {
        this.f8680j.f();
        try {
            runnable.run();
        } finally {
            this.f8680j.d();
        }
    }

    @Override // g8.h1
    public void m() {
        l8.b.d(this.f8681k, "MemoryPersistence shutdown without start", new Object[0]);
        this.f8681k = false;
    }

    @Override // g8.h1
    public void n() {
        l8.b.d(!this.f8681k, "MemoryPersistence double-started!", new Object[0]);
        this.f8681k = true;
    }

    @Override // g8.h1
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public w0 d(c8.j jVar) {
        return this.f8676f;
    }

    public Iterable<z0> r() {
        return this.f8674d.values();
    }

    @Override // g8.h1
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c1 h() {
        return this.f8679i;
    }

    @Override // g8.h1
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public d1 i() {
        return this.f8677g;
    }

    public final void u(m1 m1Var) {
        this.f8680j = m1Var;
    }
}
