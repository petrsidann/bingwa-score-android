package yb;

import java.io.IOException;
import java.net.Socket;
import xb.j2;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements oe.r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j2 f19473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final yb.b.a f19474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19475e;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public oe.r f19479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Socket f19480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19483r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f19471a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oe.d f19472b = new oe.d();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f19476f = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19477l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19478m = false;

    /* JADX INFO: renamed from: yb.a$a, reason: collision with other inner class name */
    public class C0339a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fc.b f19484b;

        public C0339a() {
            super(a.this, null);
            this.f19484b = fc.c.f();
        }

        @Override // yb.a.e
        public void a() {
            int i10;
            oe.d dVar = new oe.d();
            fc.e eVarH = fc.c.h("WriteRunnable.runWrite");
            try {
                fc.c.e(this.f19484b);
                synchronized (a.this.f19471a) {
                    dVar.X(a.this.f19472b, a.this.f19472b.z());
                    a.this.f19476f = false;
                    i10 = a.this.f19483r;
                }
                a.this.f19479n.X(dVar, dVar.size());
                synchronized (a.this.f19471a) {
                    a.v(a.this, i10);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public class b extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fc.b f19486b;

        public b() {
            super(a.this, null);
            this.f19486b = fc.c.f();
        }

        @Override // yb.a.e
        public void a() {
            oe.d dVar = new oe.d();
            fc.e eVarH = fc.c.h("WriteRunnable.runFlush");
            try {
                fc.c.e(this.f19486b);
                synchronized (a.this.f19471a) {
                    dVar.X(a.this.f19472b, a.this.f19472b.size());
                    a.this.f19477l = false;
                }
                a.this.f19479n.X(dVar, dVar.size());
                a.this.f19479n.flush();
                if (eVarH != null) {
                    eVarH.close();
                }
            } catch (Throwable th) {
                if (eVarH != null) {
                    try {
                        eVarH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f19479n != null && a.this.f19472b.size() > 0) {
                    a.this.f19479n.X(a.this.f19472b, a.this.f19472b.size());
                }
            } catch (IOException e10) {
                a.this.f19474d.f(e10);
            }
            a.this.f19472b.close();
            try {
                if (a.this.f19479n != null) {
                    a.this.f19479n.close();
                }
            } catch (IOException e11) {
                a.this.f19474d.f(e11);
            }
            try {
                if (a.this.f19480o != null) {
                    a.this.f19480o.close();
                }
            } catch (IOException e12) {
                a.this.f19474d.f(e12);
            }
        }
    }

    public class d extends yb.c {
        public d(ac.c cVar) {
            super(cVar);
        }

        @Override // yb.c, ac.c
        public void b(int i10, ac.a aVar) {
            a.E(a.this);
            super.b(i10, aVar);
        }

        @Override // yb.c, ac.c
        public void f(boolean z10, int i10, int i11) {
            if (z10) {
                a.E(a.this);
            }
            super.f(z10, i10, i11);
        }

        @Override // yb.c, ac.c
        public void x(ac.i iVar) {
            a.E(a.this);
            super.x(iVar);
        }
    }

    public abstract class e implements Runnable {
        public e() {
        }

        public /* synthetic */ e(a aVar, C0339a c0339a) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f19479n == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e10) {
                a.this.f19474d.f(e10);
            }
        }
    }

    public a(j2 j2Var, yb.b.a aVar, int i10) {
        this.f19473c = (j2) j6.m.p(j2Var, "executor");
        this.f19474d = (yb.b.a) j6.m.p(aVar, "exceptionHandler");
        this.f19475e = i10;
    }

    public static /* synthetic */ int E(a aVar) {
        int i10 = aVar.f19482q;
        aVar.f19482q = i10 + 1;
        return i10;
    }

    public static a J(j2 j2Var, yb.b.a aVar, int i10) {
        return new a(j2Var, aVar, i10);
    }

    public static /* synthetic */ int v(a aVar, int i10) {
        int i11 = aVar.f19483r - i10;
        aVar.f19483r = i11;
        return i11;
    }

    public void G(oe.r rVar, Socket socket) {
        j6.m.v(this.f19479n == null, "AsyncSink's becomeConnected should only be called once.");
        this.f19479n = (oe.r) j6.m.p(rVar, "sink");
        this.f19480o = (Socket) j6.m.p(socket, "socket");
    }

    public ac.c I(ac.c cVar) {
        return new d(cVar);
    }

    @Override // oe.r
    public void X(oe.d dVar, long j10) throws IOException {
        j6.m.p(dVar, "source");
        if (this.f19478m) {
            throw new IOException("closed");
        }
        fc.e eVarH = fc.c.h("AsyncSink.write");
        try {
            synchronized (this.f19471a) {
                this.f19472b.X(dVar, j10);
                int i10 = this.f19483r + this.f19482q;
                this.f19483r = i10;
                boolean z10 = false;
                this.f19482q = 0;
                if (this.f19481p || i10 <= this.f19475e) {
                    if (!this.f19476f && !this.f19477l && this.f19472b.z() > 0) {
                        this.f19476f = true;
                    }
                    if (eVarH != null) {
                        eVarH.close();
                        return;
                    }
                    return;
                }
                this.f19481p = true;
                z10 = true;
                if (!z10) {
                    this.f19473c.execute(new C0339a());
                    if (eVarH != null) {
                        eVarH.close();
                        return;
                    }
                    return;
                }
                try {
                    this.f19480o.close();
                } catch (IOException e10) {
                    this.f19474d.f(e10);
                }
                if (eVarH != null) {
                    eVarH.close();
                }
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // oe.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f19478m) {
            return;
        }
        this.f19478m = true;
        this.f19473c.execute(new c());
    }

    @Override // oe.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f19478m) {
            throw new IOException("closed");
        }
        fc.e eVarH = fc.c.h("AsyncSink.flush");
        try {
            synchronized (this.f19471a) {
                if (this.f19477l) {
                    if (eVarH != null) {
                        eVarH.close();
                    }
                } else {
                    this.f19477l = true;
                    this.f19473c.execute(new b());
                    if (eVarH != null) {
                        eVarH.close();
                    }
                }
            }
        } catch (Throwable th) {
            if (eVarH != null) {
                try {
                    eVarH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
