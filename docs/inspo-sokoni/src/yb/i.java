package yb;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import oe.t;
import vb.a1;
import vb.b1;
import vb.d0;
import vb.e0;
import vb.f0;
import vb.i1;
import vb.l0;
import vb.l1;
import vb.m1;
import xb.c1;
import xb.j2;
import xb.k1;
import xb.o2;
import xb.q0;
import xb.r0;
import xb.u2;
import xb.v0;
import xb.w;
import xb.w0;

/* JADX INFO: loaded from: classes2.dex */
public class i implements w, yb.b.a, r.d {
    public static final Map<ac.a, l1> V = Q();
    public static final Logger W = Logger.getLogger(i.class.getName());
    public final SocketFactory A;
    public SSLSocketFactory B;
    public HostnameVerifier C;
    public Socket D;
    public int E;
    public final Deque<h> F;
    public final zb.b G;
    public c1 H;
    public boolean I;
    public long J;
    public long K;
    public boolean L;
    public final Runnable M;
    public final int N;
    public final boolean O;
    public final u2 P;
    public final w0<h> Q;
    public f0.b R;
    public final e0 S;
    public int T;
    public Runnable U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f19568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f19571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j6.r<j6.p> f19572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ac.j f19574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k1.a f19575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public yb.b f19576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f19577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f19578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l0 f19579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Integer, h> f19581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Executor f19582o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j2 f19583p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f19584q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f19585r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f19586s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f19587t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public vb.a f19588u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l1 f19589v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f19590w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v0 f19591x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f19592y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f19593z;

    public class a extends w0<h> {
        public a() {
        }

        @Override // xb.w0
        public void b() {
            i.this.f19575h.e(true);
        }

        @Override // xb.w0
        public void c() {
            i.this.f19575h.e(false);
        }
    }

    public class b implements u2.c {
        public b() {
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f19596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ yb.a f19597b;

        public class a implements t {
            public a() {
            }

            @Override // oe.t, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // oe.t
            public long s(oe.d dVar, long j10) {
                return -1L;
            }
        }

        public c(CountDownLatch countDownLatch, yb.a aVar) {
            this.f19596a = countDownLatch;
            this.f19597b = aVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            i iVar;
            e eVar;
            Socket socketS;
            SSLSession session;
            Socket socket;
            try {
                this.f19596a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            oe.f fVarB = oe.i.b(new a());
            try {
                try {
                    i iVar2 = i.this;
                    e0 e0Var = iVar2.S;
                    if (e0Var == null) {
                        socketS = iVar2.A.createSocket(i.this.f19568a.getAddress(), i.this.f19568a.getPort());
                    } else {
                        if (!(e0Var.b() instanceof InetSocketAddress)) {
                            throw l1.f17419s.q("Unsupported SocketAddress implementation " + i.this.S.b().getClass()).c();
                        }
                        i iVar3 = i.this;
                        socketS = iVar3.S(iVar3.S.c(), (InetSocketAddress) i.this.S.b(), i.this.S.d(), i.this.S.a());
                    }
                    Socket socket2 = socketS;
                    if (i.this.B != null) {
                        SSLSocket sSLSocketB = o.b(i.this.B, i.this.C, socket2, i.this.V(), i.this.W(), i.this.G);
                        session = sSLSocketB.getSession();
                        socket = sSLSocketB;
                    } else {
                        session = null;
                        socket = socket2;
                    }
                    socket.setTcpNoDelay(true);
                    oe.f fVarB2 = oe.i.b(oe.i.e(socket));
                    this.f19597b.G(oe.i.d(socket), socket);
                    i iVar4 = i.this;
                    iVar4.f19588u = iVar4.f19588u.d().d(d0.f17330a, socket.getRemoteSocketAddress()).d(d0.f17331b, socket.getLocalSocketAddress()).d(d0.f17332c, session).d(q0.f18842a, session == null ? i1.NONE : i1.PRIVACY_AND_INTEGRITY).a();
                    i iVar5 = i.this;
                    iVar5.f19587t = iVar5.new e(iVar5.f19574g.a(fVarB2, true));
                    synchronized (i.this.f19578k) {
                        i.this.D = (Socket) j6.m.p(socket, "socket");
                        if (session != null) {
                            i.this.R = new f0.b(new f0.c(session));
                        }
                    }
                } catch (m1 e10) {
                    i.this.j0(0, ac.a.INTERNAL_ERROR, e10.a());
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f19574g.a(fVarB, true));
                    iVar.f19587t = eVar;
                } catch (Exception e11) {
                    i.this.f(e11);
                    iVar = i.this;
                    eVar = iVar.new e(iVar.f19574g.a(fVarB, true));
                    iVar.f19587t = eVar;
                }
            } catch (Throwable th) {
                i iVar6 = i.this;
                iVar6.f19587t = iVar6.new e(iVar6.f19574g.a(fVarB, true));
                throw th;
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = i.this.U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f19582o.execute(i.this.f19587t);
            synchronized (i.this.f19578k) {
                i.this.E = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
                i.this.k0();
            }
            i.this.getClass();
        }
    }

    public class e implements ac.b.a, Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ac.b f19602b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f19601a = new j(Level.FINE, (Class<?>) i.class);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19603c = true;

        public e(ac.b bVar) {
            this.f19602b = bVar;
        }

        public final int a(List<ac.d> list) {
            long jY = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                ac.d dVar = list.get(i10);
                jY += (long) (dVar.f452a.y() + 32 + dVar.f453b.y());
            }
            return (int) Math.min(jY, 2147483647L);
        }

        @Override // ac.b.a
        public void b(int i10, ac.a aVar) {
            this.f19601a.h(j.a.INBOUND, i10, aVar);
            l1 l1VarE = i.o0(aVar).e("Rst Stream");
            boolean z10 = l1VarE.m() == l1.b.CANCELLED || l1VarE.m() == l1.b.DEADLINE_EXCEEDED;
            synchronized (i.this.f19578k) {
                h hVar = (h) i.this.f19581n.get(Integer.valueOf(i10));
                if (hVar != null) {
                    fc.c.d("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.t().h0());
                    i.this.U(i10, l1VarE, aVar == ac.a.REFUSED_STREAM ? xb.s.a.REFUSED : xb.s.a.PROCESSED, z10, null, null);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0075  */
        /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:24:0x0075, please report this as an issue */
        @Override // ac.b.a
        public void c(int i10, long j10) {
            boolean z10;
            this.f19601a.k(j.a.INBOUND, i10, j10);
            if (j10 == 0) {
                if (i10 == 0) {
                    i.this.e0(ac.a.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    i.this.U(i10, l1.f17419s.q("Received 0 flow control window increment."), xb.s.a.PROCESSED, false, ac.a.PROTOCOL_ERROR, null);
                    return;
                }
            }
            synchronized (i.this.f19578k) {
                try {
                    if (i10 == 0) {
                        i.this.f19577j.g(null, (int) j10);
                        return;
                    }
                    h hVar = (h) i.this.f19581n.get(Integer.valueOf(i10));
                    if (hVar == null) {
                        z10 = i.this.b0(i10) ? false : true;
                        if (z10) {
                            i.this.e0(ac.a.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i10);
                        }
                    }
                    i.this.f19577j.g(hVar.t().b0(), (int) j10);
                    if (z10) {
                        i.this.e0(ac.a.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i10);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ac.b.a
        public void f(boolean z10, int i10, int i11) {
            v0 v0Var;
            long j10 = (((long) i10) << 32) | (((long) i11) & 4294967295L);
            this.f19601a.e(j.a.INBOUND, j10);
            if (!z10) {
                synchronized (i.this.f19578k) {
                    i.this.f19576i.f(true, i10, i11);
                }
                return;
            }
            synchronized (i.this.f19578k) {
                v0Var = null;
                if (i.this.f19591x == null) {
                    i.W.warning("Received unexpected ping ack. No ping outstanding");
                } else if (i.this.f19591x.h() == j10) {
                    v0 v0Var2 = i.this.f19591x;
                    i.this.f19591x = null;
                    v0Var = v0Var2;
                } else {
                    i.W.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(i.this.f19591x.h()), Long.valueOf(j10)));
                }
            }
            if (v0Var != null) {
                v0Var.d();
            }
        }

        @Override // ac.b.a
        public void g() {
        }

        @Override // ac.b.a
        public void h(boolean z10, boolean z11, int i10, int i11, List<ac.d> list, ac.e eVar) {
            l1 l1VarQ;
            int iA;
            this.f19601a.d(j.a.INBOUND, i10, list, z11);
            boolean z12 = true;
            if (i.this.N == Integer.MAX_VALUE || (iA = a(list)) <= i.this.N) {
                l1VarQ = null;
            } else {
                l1 l1Var = l1.f17414n;
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                objArr[0] = z11 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(i.this.N);
                objArr[2] = Integer.valueOf(iA);
                l1VarQ = l1Var.q(String.format(locale, "Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (i.this.f19578k) {
                h hVar = (h) i.this.f19581n.get(Integer.valueOf(i10));
                if (hVar == null) {
                    if (i.this.b0(i10)) {
                        i.this.f19576i.b(i10, ac.a.STREAM_CLOSED);
                    }
                } else if (l1VarQ == null) {
                    fc.c.d("OkHttpClientTransport$ClientFrameHandler.headers", hVar.t().h0());
                    hVar.t().j0(list, z11);
                } else {
                    if (!z11) {
                        i.this.f19576i.b(i10, ac.a.CANCEL);
                    }
                    hVar.t().N(l1VarQ, false, new a1());
                }
                z12 = false;
            }
            if (z12) {
                i.this.e0(ac.a.PROTOCOL_ERROR, "Received header for unknown stream: " + i10);
            }
        }

        @Override // ac.b.a
        public void i(boolean z10, ac.i iVar) {
            boolean zF;
            this.f19601a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f19578k) {
                if (n.b(iVar, 4)) {
                    i.this.E = n.a(iVar, 4);
                }
                if (n.b(iVar, 7)) {
                    zF = i.this.f19577j.f(n.a(iVar, 7));
                } else {
                    zF = false;
                }
                if (this.f19603c) {
                    i iVar2 = i.this;
                    iVar2.f19588u = iVar2.f19575h.d(i.this.f19588u);
                    i.this.f19575h.a();
                    this.f19603c = false;
                }
                i.this.f19576i.x(iVar);
                if (zF) {
                    i.this.f19577j.h();
                }
                i.this.k0();
            }
        }

        @Override // ac.b.a
        public void j(int i10, int i11, int i12, boolean z10) {
        }

        @Override // ac.b.a
        public void k(int i10, ac.a aVar, oe.g gVar) {
            this.f19601a.c(j.a.INBOUND, i10, aVar, gVar);
            if (aVar == ac.a.ENHANCE_YOUR_CALM) {
                String strC = gVar.C();
                i.W.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, strC));
                if ("too_many_pings".equals(strC)) {
                    i.this.M.run();
                }
            }
            l1 l1VarE = r0.h.l(aVar.f442a).e("Received Goaway");
            if (gVar.y() > 0) {
                l1VarE = l1VarE.e(gVar.C());
            }
            i.this.j0(i10, null, l1VarE);
        }

        @Override // ac.b.a
        public void l(boolean z10, int i10, oe.f fVar, int i11, int i12) {
            this.f19601a.b(j.a.INBOUND, i10, fVar.o(), i11, z10);
            h hVarY = i.this.Y(i10);
            if (hVarY != null) {
                long j10 = i11;
                fVar.V(j10);
                oe.d dVar = new oe.d();
                dVar.X(fVar.o(), j10);
                fc.c.d("OkHttpClientTransport$ClientFrameHandler.data", hVarY.t().h0());
                synchronized (i.this.f19578k) {
                    hVarY.t().i0(dVar, z10, i12 - i11);
                }
            } else {
                if (!i.this.b0(i10)) {
                    i.this.e0(ac.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i10);
                    return;
                }
                synchronized (i.this.f19578k) {
                    i.this.f19576i.b(i10, ac.a.STREAM_CLOSED);
                }
                fVar.skip(i11);
            }
            i.D(i.this, i12);
            if (i.this.f19586s >= i.this.f19573f * 0.5f) {
                synchronized (i.this.f19578k) {
                    i.this.f19576i.c(0, i.this.f19586s);
                }
                i.this.f19586s = 0;
            }
        }

        @Override // ac.b.a
        public void m(int i10, int i11, List<ac.d> list) {
            this.f19601a.g(j.a.INBOUND, i10, i11, list);
            synchronized (i.this.f19578k) {
                i.this.f19576i.b(i10, ac.a.PROTOCOL_ERROR);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            l1 l1VarQ;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f19602b.y(this)) {
                try {
                    if (i.this.H != null) {
                        i.this.H.m();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.j0(0, ac.a.PROTOCOL_ERROR, l1.f17419s.q("error in frame handler").p(th));
                        try {
                            this.f19602b.close();
                        } catch (IOException e10) {
                            e = e10;
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                        } catch (RuntimeException e11) {
                            if (!"bio == null".equals(e11.getMessage())) {
                                throw e11;
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            this.f19602b.close();
                        } catch (IOException e12) {
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e12);
                        } catch (RuntimeException e13) {
                            if (!"bio == null".equals(e13.getMessage())) {
                                throw e13;
                            }
                        }
                        i.this.f19575h.c();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (i.this.f19578k) {
                l1VarQ = i.this.f19589v;
            }
            if (l1VarQ == null) {
                l1VarQ = l1.f17420t.q("End of stream or IOException");
            }
            i.this.j0(0, ac.a.INTERNAL_ERROR, l1VarQ);
            try {
                this.f19602b.close();
            } catch (IOException e14) {
                e = e14;
                i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
            } catch (RuntimeException e15) {
                if (!"bio == null".equals(e15.getMessage())) {
                    throw e15;
                }
            }
            i.this.f19575h.c();
            Thread.currentThread().setName(name);
        }
    }

    public i(f.C0340f c0340f, InetSocketAddress inetSocketAddress, String str, String str2, vb.a aVar, j6.r<j6.p> rVar, ac.j jVar, e0 e0Var, Runnable runnable) {
        this.f19571d = new Random();
        this.f19578k = new Object();
        this.f19581n = new HashMap();
        this.E = 0;
        this.F = new LinkedList();
        this.Q = new a();
        this.T = 30000;
        this.f19568a = (InetSocketAddress) j6.m.p(inetSocketAddress, "address");
        this.f19569b = str;
        this.f19585r = c0340f.f19544o;
        this.f19573f = c0340f.f19549t;
        this.f19582o = (Executor) j6.m.p(c0340f.f19536b, "executor");
        this.f19583p = new j2(c0340f.f19536b);
        this.f19584q = (ScheduledExecutorService) j6.m.p(c0340f.f19538d, "scheduledExecutorService");
        this.f19580m = 3;
        SocketFactory socketFactory = c0340f.f19540f;
        this.A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.B = c0340f.f19541l;
        this.C = c0340f.f19542m;
        this.G = (zb.b) j6.m.p(c0340f.f19543n, "connectionSpec");
        this.f19572e = (j6.r) j6.m.p(rVar, "stopwatchFactory");
        this.f19574g = (ac.j) j6.m.p(jVar, "variant");
        this.f19570c = r0.h("okhttp", str2);
        this.S = e0Var;
        this.M = (Runnable) j6.m.p(runnable, "tooManyPingsRunnable");
        this.N = c0340f.f19551v;
        this.P = c0340f.f19539e.a();
        this.f19579l = l0.a(getClass(), inetSocketAddress.toString());
        this.f19588u = vb.a.c().d(q0.f18843b, aVar).a();
        this.O = c0340f.f19552w;
        Z();
    }

    public i(f.C0340f c0340f, InetSocketAddress inetSocketAddress, String str, String str2, vb.a aVar, e0 e0Var, Runnable runnable) {
        this(c0340f, inetSocketAddress, str, str2, aVar, r0.f18877w, new ac.g(), e0Var, runnable);
    }

    public static /* synthetic */ int D(i iVar, int i10) {
        int i11 = iVar.f19586s + i10;
        iVar.f19586s = i11;
        return i11;
    }

    public static Map<ac.a, l1> Q() {
        EnumMap enumMap = new EnumMap(ac.a.class);
        ac.a aVar = ac.a.NO_ERROR;
        l1 l1Var = l1.f17419s;
        enumMap.put(aVar, l1Var.q("No error: A GRPC status of OK should have been sent"));
        enumMap.put(ac.a.PROTOCOL_ERROR, l1Var.q("Protocol error"));
        enumMap.put(ac.a.INTERNAL_ERROR, l1Var.q("Internal error"));
        enumMap.put(ac.a.FLOW_CONTROL_ERROR, l1Var.q("Flow control error"));
        enumMap.put(ac.a.STREAM_CLOSED, l1Var.q("Stream closed"));
        enumMap.put(ac.a.FRAME_TOO_LARGE, l1Var.q("Frame too large"));
        enumMap.put(ac.a.REFUSED_STREAM, l1.f17420t.q("Refused stream"));
        enumMap.put(ac.a.CANCEL, l1.f17406f.q("Cancelled"));
        enumMap.put(ac.a.COMPRESSION_ERROR, l1Var.q("Compression error"));
        enumMap.put(ac.a.CONNECT_ERROR, l1Var.q("Connect error"));
        enumMap.put(ac.a.ENHANCE_YOUR_CALM, l1.f17414n.q("Enhance your calm"));
        enumMap.put(ac.a.INADEQUATE_SECURITY, l1.f17412l.q("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    public static String f0(t tVar) throws EOFException {
        oe.d dVar = new oe.d();
        while (tVar.s(dVar, 1L) != -1) {
            if (dVar.E(dVar.size() - 1) == 10) {
                return dVar.g0();
            }
        }
        throw new EOFException("\\n not found: " + dVar.Q().q());
    }

    public static l1 o0(ac.a aVar) {
        l1 l1Var = V.get(aVar);
        if (l1Var != null) {
            return l1Var;
        }
        return l1.f17407g.q("Unknown http2 error code: " + aVar.f442a);
    }

    public final bc.b R(InetSocketAddress inetSocketAddress, String str, String str2) {
        bc.a aVarA = new bc.a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        bc.b.C0054b c0054bD = new bc.b.C0054b().e(aVarA).d("Host", aVarA.c() + ":" + aVarA.f()).d("User-Agent", this.f19570c);
        if (str != null && str2 != null) {
            c0054bD.d("Proxy-Authorization", zb.c.a(str, str2));
        }
        return c0054bD.c();
    }

    public final Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) throws m1 {
        Socket socketCreateSocket = null;
        try {
            socketCreateSocket = inetSocketAddress2.getAddress() != null ? this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socketCreateSocket.setTcpNoDelay(true);
            socketCreateSocket.setSoTimeout(this.T);
            t tVarE = oe.i.e(socketCreateSocket);
            oe.e eVarA = oe.i.a(oe.i.d(socketCreateSocket));
            bc.b bVarR = R(inetSocketAddress, str, str2);
            bc.a aVarB = bVarR.b();
            eVarA.u(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", aVarB.c(), Integer.valueOf(aVarB.f()))).u("\r\n");
            int iB = bVarR.a().b();
            for (int i10 = 0; i10 < iB; i10++) {
                eVarA.u(bVarR.a().a(i10)).u(": ").u(bVarR.a().c(i10)).u("\r\n");
            }
            eVarA.u("\r\n");
            eVarA.flush();
            zb.j jVarA = zb.j.a(f0(tVarE));
            while (!f0(tVarE).equals("")) {
            }
            int i11 = jVarA.f20503b;
            if (i11 >= 200 && i11 < 300) {
                socketCreateSocket.setSoTimeout(0);
                return socketCreateSocket;
            }
            oe.d dVar = new oe.d();
            try {
                socketCreateSocket.shutdownOutput();
                tVarE.s(dVar, 1024L);
            } catch (IOException e10) {
                dVar.u("Unable to read body: " + e10.toString());
            }
            try {
                socketCreateSocket.close();
            } catch (IOException unused) {
            }
            throw l1.f17420t.q(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(jVarA.f20503b), jVarA.f20504c, dVar.e0())).c();
        } catch (IOException e11) {
            if (socketCreateSocket != null) {
                r0.d(socketCreateSocket);
            }
            throw l1.f17420t.q("Failed trying to connect with proxy").p(e11).c();
        }
    }

    public void T(boolean z10, long j10, long j11, boolean z11) {
        this.I = z10;
        this.J = j10;
        this.K = j11;
        this.L = z11;
    }

    public void U(int i10, l1 l1Var, xb.s.a aVar, boolean z10, ac.a aVar2, a1 a1Var) {
        synchronized (this.f19578k) {
            h hVarRemove = this.f19581n.remove(Integer.valueOf(i10));
            if (hVarRemove != null) {
                if (aVar2 != null) {
                    this.f19576i.b(i10, ac.a.CANCEL);
                }
                if (l1Var != null) {
                    h.b bVarM = hVarRemove.t();
                    if (a1Var == null) {
                        a1Var = new a1();
                    }
                    bVarM.M(l1Var, aVar, z10, a1Var);
                }
                if (!k0()) {
                    m0();
                    c0(hVarRemove);
                }
            }
        }
    }

    public String V() {
        URI uriB = r0.b(this.f19569b);
        return uriB.getHost() != null ? uriB.getHost() : this.f19569b;
    }

    public int W() {
        URI uriB = r0.b(this.f19569b);
        return uriB.getPort() != -1 ? uriB.getPort() : this.f19568a.getPort();
    }

    public final Throwable X() {
        synchronized (this.f19578k) {
            l1 l1Var = this.f19589v;
            if (l1Var != null) {
                return l1Var.c();
            }
            return l1.f17420t.q("Connection closed").c();
        }
    }

    public h Y(int i10) {
        h hVar;
        synchronized (this.f19578k) {
            hVar = this.f19581n.get(Integer.valueOf(i10));
        }
        return hVar;
    }

    public final void Z() {
        synchronized (this.f19578k) {
            this.P.g(new b());
        }
    }

    @Override // xb.k1
    public Runnable a(k1.a aVar) {
        this.f19575h = (k1.a) j6.m.p(aVar, "listener");
        if (this.I) {
            c1 c1Var = new c1(new c1.c(this), this.f19584q, this.J, this.K, this.L);
            this.H = c1Var;
            c1Var.p();
        }
        yb.a aVarJ = yb.a.J(this.f19583p, this, 10000);
        ac.c cVarI = aVarJ.I(this.f19574g.b(oe.i.a(aVarJ), true));
        synchronized (this.f19578k) {
            yb.b bVar = new yb.b(this, cVarI);
            this.f19576i = bVar;
            this.f19577j = new r(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f19583p.execute(new c(countDownLatch, aVarJ));
        try {
            h0();
            countDownLatch.countDown();
            this.f19583p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    public boolean a0() {
        return this.B == null;
    }

    @Override // yb.r.d
    public r.c[] b() {
        r.c[] cVarArr;
        synchronized (this.f19578k) {
            cVarArr = new r.c[this.f19581n.size()];
            Iterator<h> it = this.f19581n.values().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                cVarArr[i10] = it.next().t().b0();
                i10++;
            }
        }
        return cVarArr;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000c  */
    public boolean b0(int i10) {
        boolean z10;
        synchronized (this.f19578k) {
            if (i10 < this.f19580m) {
                z10 = true;
                if ((i10 & 1) != 1) {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // xb.k1
    public void c(l1 l1Var) {
        synchronized (this.f19578k) {
            if (this.f19589v != null) {
                return;
            }
            this.f19589v = l1Var;
            this.f19575h.b(l1Var);
            m0();
        }
    }

    public final void c0(h hVar) {
        if (this.f19593z && this.F.isEmpty() && this.f19581n.isEmpty()) {
            this.f19593z = false;
            c1 c1Var = this.H;
            if (c1Var != null) {
                c1Var.o();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, false);
        }
    }

    @Override // xb.k1
    public void d(l1 l1Var) {
        c(l1Var);
        synchronized (this.f19578k) {
            Iterator<Map.Entry<Integer, h>> it = this.f19581n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, h> next = it.next();
                it.remove();
                next.getValue().t().N(l1Var, false, new a1());
                c0(next.getValue());
            }
            for (h hVar : this.F) {
                hVar.t().M(l1Var, xb.s.a.MISCARRIED, true, new a1());
                c0(hVar);
            }
            this.F.clear();
            m0();
        }
    }

    @Override // xb.t
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public h h(b1<?, ?> b1Var, a1 a1Var, vb.c cVar, vb.k[] kVarArr) throws Throwable {
        j6.m.p(b1Var, "method");
        j6.m.p(a1Var, "headers");
        o2 o2VarH = o2.h(kVarArr, getAttributes(), a1Var);
        synchronized (this.f19578k) {
            try {
                try {
                    return new h(b1Var, a1Var, this.f19576i, this, this.f19577j, this.f19578k, this.f19585r, this.f19573f, this.f19569b, this.f19570c, o2VarH, this.P, cVar, this.O);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // xb.t
    public void e(xb.t.a aVar, Executor executor) {
        long jNextLong;
        synchronized (this.f19578k) {
            boolean z10 = true;
            j6.m.u(this.f19576i != null);
            if (this.f19592y) {
                v0.g(aVar, executor, X());
                return;
            }
            v0 v0Var = this.f19591x;
            if (v0Var != null) {
                jNextLong = 0;
                z10 = false;
            } else {
                jNextLong = this.f19571d.nextLong();
                j6.p pVar = this.f19572e.get();
                pVar.g();
                v0 v0Var2 = new v0(jNextLong, pVar);
                this.f19591x = v0Var2;
                this.P.b();
                v0Var = v0Var2;
            }
            if (z10) {
                this.f19576i.f(false, (int) (jNextLong >>> 32), (int) jNextLong);
            }
            v0Var.a(aVar, executor);
        }
    }

    public final void e0(ac.a aVar, String str) {
        j0(0, aVar, o0(aVar).e(str));
    }

    @Override // yb.b.a
    public void f(Throwable th) {
        j6.m.p(th, "failureCause");
        j0(0, ac.a.INTERNAL_ERROR, l1.f17420t.p(th));
    }

    @Override // vb.r0
    public l0 g() {
        return this.f19579l;
    }

    public void g0(h hVar) {
        this.F.remove(hVar);
        c0(hVar);
    }

    @Override // xb.w
    public vb.a getAttributes() {
        return this.f19588u;
    }

    public final void h0() {
        synchronized (this.f19578k) {
            this.f19576i.q();
            ac.i iVar = new ac.i();
            n.c(iVar, 7, this.f19573f);
            this.f19576i.b0(iVar);
            int i10 = this.f19573f;
            if (i10 > 65535) {
                this.f19576i.c(0, i10 - 65535);
            }
        }
    }

    public final void i0(h hVar) {
        if (!this.f19593z) {
            this.f19593z = true;
            c1 c1Var = this.H;
            if (c1Var != null) {
                c1Var.n();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, true);
        }
    }

    public final void j0(int i10, ac.a aVar, l1 l1Var) {
        synchronized (this.f19578k) {
            if (this.f19589v == null) {
                this.f19589v = l1Var;
                this.f19575h.b(l1Var);
            }
            if (aVar != null && !this.f19590w) {
                this.f19590w = true;
                this.f19576i.m(0, aVar, new byte[0]);
            }
            Iterator<Map.Entry<Integer, h>> it = this.f19581n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, h> next = it.next();
                if (next.getKey().intValue() > i10) {
                    it.remove();
                    next.getValue().t().M(l1Var, xb.s.a.REFUSED, false, new a1());
                    c0(next.getValue());
                }
            }
            for (h hVar : this.F) {
                hVar.t().M(l1Var, xb.s.a.MISCARRIED, true, new a1());
                c0(hVar);
            }
            this.F.clear();
            m0();
        }
    }

    public final boolean k0() {
        boolean z10 = false;
        while (!this.F.isEmpty() && this.f19581n.size() < this.E) {
            l0(this.F.poll());
            z10 = true;
        }
        return z10;
    }

    public final void l0(h hVar) {
        j6.m.v(hVar.t().c0() == -1, "StreamId already assigned");
        this.f19581n.put(Integer.valueOf(this.f19580m), hVar);
        i0(hVar);
        hVar.t().f0(this.f19580m);
        if ((hVar.L() != b1.d.UNARY && hVar.L() != b1.d.SERVER_STREAMING) || hVar.N()) {
            this.f19576i.flush();
        }
        int i10 = this.f19580m;
        if (i10 < 2147483645) {
            this.f19580m = i10 + 2;
        } else {
            this.f19580m = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
            j0(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER, ac.a.NO_ERROR, l1.f17420t.q("Stream ids exhausted"));
        }
    }

    public final void m0() {
        if (this.f19589v == null || !this.f19581n.isEmpty() || !this.F.isEmpty() || this.f19592y) {
            return;
        }
        this.f19592y = true;
        c1 c1Var = this.H;
        if (c1Var != null) {
            c1Var.q();
        }
        v0 v0Var = this.f19591x;
        if (v0Var != null) {
            v0Var.f(X());
            this.f19591x = null;
        }
        if (!this.f19590w) {
            this.f19590w = true;
            this.f19576i.m(0, ac.a.NO_ERROR, new byte[0]);
        }
        this.f19576i.close();
    }

    public void n0(h hVar) {
        if (this.f19589v != null) {
            hVar.t().M(this.f19589v, xb.s.a.MISCARRIED, true, new a1());
        } else if (this.f19581n.size() < this.E) {
            l0(hVar);
        } else {
            this.F.add(hVar);
            i0(hVar);
        }
    }

    public String toString() {
        return j6.g.b(this).c("logId", this.f19579l.d()).d("address", this.f19568a).toString();
    }
}
