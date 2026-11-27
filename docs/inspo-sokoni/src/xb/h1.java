package xb;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 extends vb.x0<h1> {
    public static final Logger H = Logger.getLogger(h1.class.getName());
    public static final long I = TimeUnit.MINUTES.toMillis(30);
    public static final long J = TimeUnit.SECONDS.toMillis(1);
    public static final p1<? extends Executor> K = m2.c(r0.f18875u);
    public static final vb.w L = vb.w.c();
    public static final vb.p M = vb.p.a();
    public static final Method N;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final c F;
    public final b G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1<? extends Executor> f18604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p1<? extends Executor> f18605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<vb.h> f18606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vb.e1 f18607d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<vb.l> f18608e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18609f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vb.b f18610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SocketAddress f18611h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f18612i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f18613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f18614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vb.w f18616m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vb.p f18617n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f18618o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18619p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18620q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f18621r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f18622s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f18623t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public vb.f0 f18624u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f18625v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map<String, ?> f18626w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f18627x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public vb.h1 f18628y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f18629z;

    public interface b {
        int a();
    }

    public interface c {
        u a();
    }

    public static final class d implements b {
        public d() {
        }

        @Override // xb.h1.b
        public int a() {
            return 443;
        }
    }

    static {
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("io.grpc.census.InternalCensusStatsAccessor");
            Class<?> cls2 = Boolean.TYPE;
            declaredMethod = cls.getDeclaredMethod("getClientInterceptor", cls2, cls2, cls2, cls2);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            H.log(Level.FINE, "Unable to apply census stats", e10);
            declaredMethod = null;
        }
        N = declaredMethod;
    }

    public h1(String str, vb.e eVar, vb.b bVar, c cVar, b bVar2) {
        p1<? extends Executor> p1Var = K;
        this.f18604a = p1Var;
        this.f18605b = p1Var;
        this.f18606c = new ArrayList();
        this.f18607d = vb.e1.b();
        this.f18608e = new ArrayList();
        this.f18614k = "pick_first";
        this.f18616m = L;
        this.f18617n = M;
        this.f18618o = I;
        this.f18619p = 5;
        this.f18620q = 5;
        this.f18621r = 16777216L;
        this.f18622s = 1048576L;
        this.f18623t = true;
        this.f18624u = vb.f0.g();
        this.f18627x = true;
        this.f18629z = true;
        this.A = true;
        this.B = true;
        this.C = false;
        this.D = true;
        this.E = true;
        this.f18609f = (String) j6.m.p(str, "target");
        this.f18610g = bVar;
        this.F = (c) j6.m.p(cVar, "clientTransportFactoryBuilder");
        this.f18611h = null;
        if (bVar2 != null) {
            this.G = bVar2;
        } else {
            this.G = new d();
        }
    }

    public h1(String str, c cVar, b bVar) {
        this(str, null, null, cVar, bVar);
    }

    @Override // vb.x0
    public vb.w0 a() {
        return new i1(new g1(this, this.F.a(), new f0.a(), m2.c(r0.f18875u), r0.f18877w, f(), r2.f18900a));
    }

    public int e() {
        return this.G.a();
    }

    public List<vb.h> f() {
        boolean z10;
        vb.h hVar;
        ArrayList arrayList = new ArrayList(this.f18606c);
        List<vb.h> listA = vb.j0.a();
        if (listA != null) {
            arrayList.addAll(listA);
            z10 = true;
        } else {
            z10 = false;
        }
        vb.h hVar2 = null;
        if (!z10 && this.f18629z) {
            Method method = N;
            if (method != null) {
                try {
                    hVar = (vb.h) method.invoke(null, Boolean.valueOf(this.A), Boolean.valueOf(this.B), Boolean.valueOf(this.C), Boolean.valueOf(this.D));
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    H.log(Level.FINE, "Unable to apply census stats", e10);
                    hVar = null;
                }
            } else {
                hVar = null;
            }
            if (hVar != null) {
                arrayList.add(0, hVar);
            }
        }
        if (!z10 && this.E) {
            try {
                hVar2 = (vb.h) Class.forName("io.grpc.census.InternalCensusTracingAccessor").getDeclaredMethod("getClientInterceptor", new Class[0]).invoke(null, new Object[0]);
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                H.log(Level.FINE, "Unable to apply census stats", e11);
            }
            if (hVar2 != null) {
                arrayList.add(0, hVar2);
            }
        }
        return arrayList;
    }
}
