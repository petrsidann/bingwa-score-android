package xb;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f18726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vb.b f18727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18728c;

    public class a extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f18729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18730b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile vb.l1 f18732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public vb.l1 f18733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public vb.l1 f18734f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f18731c = new AtomicInteger(-2147483647);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final n1.a f18735g = new C0328a();

        /* JADX INFO: renamed from: xb.m$a$a, reason: collision with other inner class name */
        public class C0328a implements n1.a {
            public C0328a() {
            }

            @Override // xb.n1.a
            public void a() {
                if (a.this.f18731c.decrementAndGet() == 0) {
                    a.this.j();
                }
            }
        }

        public class b extends vb.b.AbstractC0303b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.b1 f18738a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vb.c f18739b;

            public b(vb.b1 b1Var, vb.c cVar) {
                this.f18738a = b1Var;
                this.f18739b = cVar;
            }
        }

        public a(w wVar, String str) {
            this.f18729a = (w) j6.m.p(wVar, "delegate");
            this.f18730b = (String) j6.m.p(str, "authority");
        }

        @Override // xb.k0
        public w b() {
            return this.f18729a;
        }

        @Override // xb.k0, xb.k1
        public void c(vb.l1 l1Var) {
            j6.m.p(l1Var, "status");
            synchronized (this) {
                if (this.f18731c.get() < 0) {
                    this.f18732d = l1Var;
                    this.f18731c.addAndGet(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
                    if (this.f18731c.get() != 0) {
                        this.f18733e = l1Var;
                    } else {
                        super.c(l1Var);
                    }
                }
            }
        }

        @Override // xb.k0, xb.k1
        public void d(vb.l1 l1Var) {
            j6.m.p(l1Var, "status");
            synchronized (this) {
                if (this.f18731c.get() < 0) {
                    this.f18732d = l1Var;
                    this.f18731c.addAndGet(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER);
                } else if (this.f18734f != null) {
                    return;
                }
                if (this.f18731c.get() != 0) {
                    this.f18734f = l1Var;
                } else {
                    super.d(l1Var);
                }
            }
        }

        @Override // xb.k0, xb.t
        public r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
            vb.b bVarC = cVar.c();
            if (bVarC == null) {
                bVarC = m.this.f18727b;
            } else if (m.this.f18727b != null) {
                bVarC = new vb.n(m.this.f18727b, bVarC);
            }
            if (bVarC == null) {
                return this.f18731c.get() >= 0 ? new g0(this.f18732d, kVarArr) : this.f18729a.h(b1Var, a1Var, cVar, kVarArr);
            }
            n1 n1Var = new n1(this.f18729a, b1Var, a1Var, cVar, this.f18735g, kVarArr);
            if (this.f18731c.incrementAndGet() > 0) {
                this.f18735g.a();
                return new g0(this.f18732d, kVarArr);
            }
            try {
                bVarC.a(new b(b1Var, cVar), ((bVarC instanceof vb.n0) && ((vb.n0) bVarC).a() && cVar.e() != null) ? cVar.e() : m.this.f18728c, n1Var);
            } catch (Throwable th) {
                n1Var.b(vb.l1.f17413m.q("Credentials should use fail() instead of throwing exceptions").p(th));
            }
            return n1Var.d();
        }

        public final void j() {
            synchronized (this) {
                if (this.f18731c.get() != 0) {
                    return;
                }
                vb.l1 l1Var = this.f18733e;
                vb.l1 l1Var2 = this.f18734f;
                this.f18733e = null;
                this.f18734f = null;
                if (l1Var != null) {
                    super.c(l1Var);
                }
                if (l1Var2 != null) {
                    super.d(l1Var2);
                }
            }
        }
    }

    public m(u uVar, vb.b bVar, Executor executor) {
        this.f18726a = (u) j6.m.p(uVar, "delegate");
        this.f18727b = bVar;
        this.f18728c = (Executor) j6.m.p(executor, "appExecutor");
    }

    @Override // xb.u
    public w F(SocketAddress socketAddress, u.a aVar, vb.f fVar) {
        return new a(this.f18726a.F(socketAddress, aVar, fVar), aVar.a());
    }

    @Override // xb.u
    public ScheduledExecutorService P() {
        return this.f18726a.P();
    }

    @Override // xb.u
    public Collection<Class<? extends SocketAddress>> a0() {
        return this.f18726a.a0();
    }

    @Override // xb.u, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18726a.close();
    }
}
