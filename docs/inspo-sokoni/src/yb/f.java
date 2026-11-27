package yb;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import vb.r1;
import vb.x0;
import vb.z;
import xb.c1;
import xb.h1;
import xb.l2;
import xb.m2;
import xb.p1;
import xb.r0;
import xb.u;
import xb.u2;
import xb.w;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends z<f> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f19505r = Logger.getLogger(f.class.getName());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final zb.b f19506s = new zb.b.C0345b(zb.b.f20446f).g(zb.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zb.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zb.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zb.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zb.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zb.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).j(zb.k.TLS_1_2).h(true).e();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f19507t = TimeUnit.DAYS.toNanos(1000);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l2.d<Executor> f19508u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p1<Executor> f19509v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final EnumSet<r1> f19510w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f19511a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SocketFactory f19515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SSLSocketFactory f19516f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HostnameVerifier f19518h;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19524n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u2.b f19512b = u2.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p1<Executor> f19513c = f19509v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p1<ScheduledExecutorService> f19514d = m2.c(r0.f18876v);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zb.b f19519i = f19506s;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f19520j = c.TLS;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f19521k = Long.MAX_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f19522l = r0.f18868n;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19523m = 65535;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f19525o = 4194304;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f19526p = com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f19527q = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f19517g = false;

    public class a implements l2.d<Executor> {
        @Override // xb.l2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // xb.l2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(r0.j("grpc-okhttp-%d", true));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19529b;

        static {
            int[] iArr = new int[c.values().length];
            f19529b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19529b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[yb.e.values().length];
            f19528a = iArr2;
            try {
                iArr2[yb.e.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19528a[yb.e.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum c {
        TLS,
        PLAINTEXT
    }

    public final class d implements h1.b {
        public d() {
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }

        @Override // xb.h1.b
        public int a() {
            return f.this.i();
        }
    }

    public final class e implements h1.c {
        public e() {
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }

        @Override // xb.h1.c
        public u a() {
            return f.this.f();
        }
    }

    /* JADX INFO: renamed from: yb.f$f, reason: collision with other inner class name */
    public static final class C0340f implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1<Executor> f19535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f19536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p1<ScheduledExecutorService> f19537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f19538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u2.b f19539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SocketFactory f19540f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final SSLSocketFactory f19541l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final HostnameVerifier f19542m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final zb.b f19543n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f19544o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f19545p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final long f19546q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final xb.g f19547r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final long f19548s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final int f19549t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f19550u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f19551v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f19552w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f19553x;

        /* JADX INFO: renamed from: yb.f$f$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ xb.g.b f19554a;

            public a(xb.g.b bVar) {
                this.f19554a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19554a.a();
            }
        }

        public C0340f(p1<Executor> p1Var, p1<ScheduledExecutorService> p1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, zb.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, u2.b bVar2, boolean z12) {
            this.f19535a = p1Var;
            this.f19536b = p1Var.a();
            this.f19537c = p1Var2;
            this.f19538d = p1Var2.a();
            this.f19540f = socketFactory;
            this.f19541l = sSLSocketFactory;
            this.f19542m = hostnameVerifier;
            this.f19543n = bVar;
            this.f19544o = i10;
            this.f19545p = z10;
            this.f19546q = j10;
            this.f19547r = new xb.g("keepalive time nanos", j10);
            this.f19548s = j11;
            this.f19549t = i11;
            this.f19550u = z11;
            this.f19551v = i12;
            this.f19552w = z12;
            this.f19539e = (u2.b) j6.m.p(bVar2, "transportTracerFactory");
        }

        public /* synthetic */ C0340f(p1 p1Var, p1 p1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, zb.b bVar, int i10, boolean z10, long j10, long j11, int i11, boolean z11, int i12, u2.b bVar2, boolean z12, a aVar) {
            this(p1Var, p1Var2, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i10, z10, j10, j11, i11, z11, i12, bVar2, z12);
        }

        @Override // xb.u
        public w F(SocketAddress socketAddress, u.a aVar, vb.f fVar) {
            if (this.f19553x) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            xb.g.b bVarD = this.f19547r.d();
            i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(bVarD));
            if (this.f19545p) {
                iVar.T(true, bVarD.b(), this.f19548s, this.f19550u);
            }
            return iVar;
        }

        @Override // xb.u
        public ScheduledExecutorService P() {
            return this.f19538d;
        }

        @Override // xb.u
        public Collection<Class<? extends SocketAddress>> a0() {
            return f.j();
        }

        @Override // xb.u, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f19553x) {
                return;
            }
            this.f19553x = true;
            this.f19535a.b(this.f19536b);
            this.f19537c.b(this.f19538d);
        }
    }

    static {
        a aVar = new a();
        f19508u = aVar;
        f19509v = m2.c(aVar);
        f19510w = EnumSet.of(r1.MTLS, r1.CUSTOM_MANAGERS);
    }

    public f(String str) {
        a aVar = null;
        this.f19511a = new h1(str, new e(this, aVar), new d(this, aVar));
    }

    public static f h(String str) {
        return new f(str);
    }

    public static Collection<Class<? extends SocketAddress>> j() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // vb.z
    public x0<?> e() {
        return this.f19511a;
    }

    public C0340f f() {
        return new C0340f(this.f19513c, this.f19514d, this.f19515e, g(), this.f19518h, this.f19519i, this.f19525o, this.f19521k != Long.MAX_VALUE, this.f19521k, this.f19522l, this.f19523m, this.f19524n, this.f19526p, this.f19512b, false, null);
    }

    public SSLSocketFactory g() {
        int i10 = b.f19529b[this.f19520j.ordinal()];
        if (i10 == 1) {
            return null;
        }
        if (i10 != 2) {
            throw new RuntimeException("Unknown negotiation type: " + this.f19520j);
        }
        try {
            if (this.f19516f == null) {
                this.f19516f = SSLContext.getInstance("Default", zb.h.e().g()).getSocketFactory();
            }
            return this.f19516f;
        } catch (GeneralSecurityException e10) {
            throw new RuntimeException("TLS Provider failure", e10);
        }
    }

    public int i() {
        int i10 = b.f19529b[this.f19520j.ordinal()];
        if (i10 == 1) {
            return 80;
        }
        if (i10 == 2) {
            return 443;
        }
        throw new AssertionError(this.f19520j + " not handled");
    }

    @Override // vb.x0
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f c(long j10, TimeUnit timeUnit) {
        j6.m.e(j10 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.f19521k = nanos;
        long jL = c1.l(nanos);
        this.f19521k = jL;
        if (jL >= f19507t) {
            this.f19521k = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // vb.x0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public f d() {
        j6.m.v(!this.f19517g, "Cannot change security when using ChannelCredentials");
        this.f19520j = c.PLAINTEXT;
        return this;
    }
}
