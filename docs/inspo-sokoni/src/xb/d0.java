package xb;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends vb.c1 {
    public static final g A;
    public static String B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f18374s = Logger.getLogger(d0.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Set<String> f18375t = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f18376u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f18377v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f18378w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f18379x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f18380y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f18381z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.h1 f18382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Random f18383b = new Random();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile b f18384c = d.INSTANCE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<f> f18385d = new AtomicReference<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l2.d<Executor> f18389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final vb.p1 f18391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j6.p f18392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18393l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Executor f18395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f18396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final vb.c1.h f18397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f18398q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vb.c1.e f18399r;

    public interface b {
        List<InetAddress> d(String str);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.l1 f18400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<vb.y> f18401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vb.c1.c f18402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vb.a f18403d;

        public c() {
        }
    }

    public enum d implements b {
        INSTANCE;

        @Override // xb.d0.b
        public List<InetAddress> d(String str) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    public final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.c1.e f18406a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f18408a;

            public a(boolean z10) {
                this.f18408a = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f18408a) {
                    d0 d0Var = d0.this;
                    d0Var.f18393l = true;
                    if (d0Var.f18390i > 0) {
                        d0.this.f18392k.f().g();
                    }
                }
                d0.this.f18398q = false;
            }
        }

        public e(vb.c1.e eVar) {
            this.f18406a = (vb.c1.e) j6.m.p(eVar, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            vb.p1 p1Var;
            a aVar;
            Logger logger = d0.f18374s;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                d0.f18374s.finer("Attempting DNS resolution of " + d0.this.f18387f);
            }
            c cVarO = null;
            try {
                try {
                    vb.y yVarN = d0.this.n();
                    vb.c1.g.a aVarD = vb.c1.g.d();
                    if (yVarN != null) {
                        if (d0.f18374s.isLoggable(level)) {
                            d0.f18374s.finer("Using proxy address " + yVarN);
                        }
                        aVarD.b(Collections.singletonList(yVarN));
                    } else {
                        cVarO = d0.this.o(false);
                        if (cVarO.f18400a != null) {
                            this.f18406a.b(cVarO.f18400a);
                            d0.this.f18391j.execute(new a(cVarO != null && cVarO.f18400a == null));
                            return;
                        }
                        if (cVarO.f18401b != null) {
                            aVarD.b(cVarO.f18401b);
                        }
                        if (cVarO.f18402c != null) {
                            aVarD.d(cVarO.f18402c);
                        }
                        vb.a aVar2 = cVarO.f18403d;
                        if (aVar2 != null) {
                            aVarD.c(aVar2);
                        }
                    }
                    this.f18406a.c(aVarD.a());
                    z10 = cVarO != null && cVarO.f18400a == null;
                    p1Var = d0.this.f18391j;
                    aVar = new a(z10);
                } catch (IOException e10) {
                    this.f18406a.b(vb.l1.f17420t.q("Unable to resolve host " + d0.this.f18387f).p(e10));
                    z10 = 0 != 0 && null.f18400a == null;
                    p1Var = d0.this.f18391j;
                    aVar = new a(z10);
                }
                p1Var.execute(aVar);
            } catch (Throwable th) {
                d0.this.f18391j.execute(new a(0 != 0 && null.f18400a == null));
                throw th;
            }
        }
    }

    public interface f {
        List<String> a(String str);
    }

    public interface g {
        f a();

        Throwable b();
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        f18376u = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        f18377v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        f18378w = property3;
        f18379x = Boolean.parseBoolean(property);
        f18380y = Boolean.parseBoolean(property2);
        f18381z = Boolean.parseBoolean(property3);
        A = v(d0.class.getClassLoader());
    }

    public d0(String str, String str2, vb.c1.b bVar, l2.d<Executor> dVar, j6.p pVar, boolean z10) {
        j6.m.p(bVar, "args");
        this.f18389h = dVar;
        URI uriCreate = URI.create("//" + ((String) j6.m.p(str2, "name")));
        j6.m.k(uriCreate.getHost() != null, "Invalid DNS name: %s", str2);
        this.f18386e = (String) j6.m.q(uriCreate.getAuthority(), "nameUri (%s) doesn't have an authority", uriCreate);
        this.f18387f = uriCreate.getHost();
        this.f18388g = uriCreate.getPort() == -1 ? bVar.a() : uriCreate.getPort();
        this.f18382a = (vb.h1) j6.m.p(bVar.c(), "proxyDetector");
        this.f18390i = s(z10);
        this.f18392k = (j6.p) j6.m.p(pVar, "stopwatch");
        this.f18391j = (vb.p1) j6.m.p(bVar.f(), "syncContext");
        Executor executorB = bVar.b();
        this.f18395n = executorB;
        this.f18396o = executorB == null;
        this.f18397p = (vb.c1.h) j6.m.p(bVar.e(), "serviceConfigParser");
    }

    public static boolean C(boolean z10, boolean z11, String str) {
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(":")) {
            return false;
        }
        boolean z12 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt != '.') {
                z12 &= cCharAt >= '0' && cCharAt <= '9';
            }
        }
        return true ^ z12;
    }

    public static final List<String> p(Map<String, ?> map) {
        return b1.g(map, "clientLanguage");
    }

    public static final List<String> q(Map<String, ?> map) {
        return b1.g(map, "clientHostname");
    }

    public static String r() {
        if (B == null) {
            try {
                B = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e10) {
                throw new RuntimeException(e10);
            }
        }
        return B;
    }

    public static long s(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty("networkaddress.cache.ttl");
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                f18374s.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
            }
        }
        return j10 > 0 ? TimeUnit.SECONDS.toNanos(j10) : j10;
    }

    public static final Double t(Map<String, ?> map) {
        return b1.h(map, "percentage");
    }

    public static g v(ClassLoader classLoader) {
        Logger logger;
        Level level;
        String str;
        try {
            try {
                try {
                    g gVar = (g) Class.forName("xb.z0", true, classLoader).asSubclass(g.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (gVar.b() == null) {
                        return gVar;
                    }
                    logger = f18374s;
                    level = Level.FINE;
                    str = "JndiResourceResolverFactory not available, skipping.";
                    e = gVar.b();
                    logger.log(level, str, e);
                    return null;
                } catch (Exception e10) {
                    e = e10;
                    logger = f18374s;
                    level = Level.FINE;
                    str = "Can't construct JndiResourceResolverFactory, skipping.";
                }
            } catch (Exception e11) {
                e = e11;
                logger = f18374s;
                level = Level.FINE;
                str = "Can't find JndiResourceResolverFactory ctor, skipping.";
            }
        } catch (ClassCastException e12) {
            e = e12;
            logger = f18374s;
            level = Level.FINE;
            str = "Unable to cast JndiResourceResolverFactory, skipping.";
        } catch (ClassNotFoundException e13) {
            e = e13;
            logger = f18374s;
            level = Level.FINE;
            str = "Unable to find JndiResourceResolverFactory, skipping.";
        }
    }

    public static Map<String, ?> w(Map<String, ?> map, Random random, String str) {
        boolean z10;
        boolean z11;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            j6.w.a(f18375t.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> listP = p(map);
        if (listP != null && !listP.isEmpty()) {
            Iterator<String> it = listP.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z11 = false;
                    break;
                }
                if ("java".equalsIgnoreCase(it.next())) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return null;
            }
        }
        Double dT = t(map);
        if (dT != null) {
            int iIntValue = dT.intValue();
            j6.w.a(iIntValue >= 0 && iIntValue <= 100, "Bad percentage: %s", dT);
            if (random.nextInt(100) >= iIntValue) {
                return null;
            }
        }
        List<String> listQ = q(map);
        if (listQ != null && !listQ.isEmpty()) {
            Iterator<String> it2 = listQ.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
                if (it2.next().equals(str)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return null;
            }
        }
        Map<String, ?> mapJ = b1.j(map, "serviceConfig");
        if (mapJ != null) {
            return mapJ;
        }
        throw new j6.x(String.format("key '%s' missing in '%s'", map, "serviceConfig"));
    }

    public static vb.c1.c x(List<String> list, Random random, String str) {
        vb.l1 l1Var;
        String str2;
        try {
            Iterator<Map<String, ?>> it = y(list).iterator();
            Map<String, ?> mapW = null;
            while (it.hasNext()) {
                try {
                    mapW = w(it.next(), random, str);
                    if (mapW != null) {
                        break;
                    }
                } catch (RuntimeException e10) {
                    e = e10;
                    l1Var = vb.l1.f17407g;
                    str2 = "failed to pick service config choice";
                    return vb.c1.c.b(l1Var.q(str2).p(e));
                }
            }
            if (mapW == null) {
                return null;
            }
            return vb.c1.c.a(mapW);
        } catch (IOException | RuntimeException e11) {
            e = e11;
            l1Var = vb.l1.f17407g;
            str2 = "failed to parse TXT records";
        }
    }

    public static List<Map<String, ?>> y(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.startsWith("grpc_config=")) {
                Object objA = a1.a(str.substring(12));
                if (!(objA instanceof List)) {
                    throw new ClassCastException("wrong type " + objA);
                }
                arrayList.addAll(b1.a((List) objA));
            } else {
                f18374s.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            }
        }
        return arrayList;
    }

    public final List<vb.y> A() {
        Exception e10 = null;
        try {
            try {
                List<InetAddress> listD = this.f18384c.d(this.f18387f);
                ArrayList arrayList = new ArrayList(listD.size());
                Iterator<InetAddress> it = listD.iterator();
                while (it.hasNext()) {
                    arrayList.add(new vb.y(new InetSocketAddress(it.next(), this.f18388g)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e11) {
                e10 = e11;
                j6.u.f(e10);
                throw new RuntimeException(e10);
            }
        } catch (Throwable th) {
            if (e10 != null) {
                f18374s.log(Level.FINE, "Address resolution failure", (Throwable) e10);
            }
            throw th;
        }
    }

    public final vb.c1.c B() {
        List<String> listEmptyList = Collections.emptyList();
        f fVarU = u();
        if (fVarU != null) {
            try {
                listEmptyList = fVarU.a("_grpc_config." + this.f18387f);
            } catch (Exception e10) {
                f18374s.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e10);
            }
        }
        if (listEmptyList.isEmpty()) {
            f18374s.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.f18387f});
            return null;
        }
        vb.c1.c cVarX = x(listEmptyList, this.f18383b, r());
        if (cVarX != null) {
            return cVarX.d() != null ? vb.c1.c.b(cVarX.d()) : this.f18397p.a((Map) cVarX.c());
        }
        return null;
    }

    @Override // vb.c1
    public String a() {
        return this.f18386e;
    }

    @Override // vb.c1
    public void b() {
        j6.m.v(this.f18399r != null, "not started");
        z();
    }

    @Override // vb.c1
    public void c() {
        if (this.f18394m) {
            return;
        }
        this.f18394m = true;
        Executor executor = this.f18395n;
        if (executor == null || !this.f18396o) {
            return;
        }
        this.f18395n = (Executor) l2.f(this.f18389h, executor);
    }

    @Override // vb.c1
    public void d(vb.c1.e eVar) {
        j6.m.v(this.f18399r == null, "already started");
        if (this.f18396o) {
            this.f18395n = (Executor) l2.d(this.f18389h);
        }
        this.f18399r = (vb.c1.e) j6.m.p(eVar, "listener");
        z();
    }

    public final boolean m() {
        if (this.f18393l) {
            long j10 = this.f18390i;
            if (j10 != 0 && (j10 <= 0 || this.f18392k.d(TimeUnit.NANOSECONDS) <= this.f18390i)) {
                return false;
            }
        }
        return true;
    }

    public final vb.y n() {
        vb.g1 g1VarA = this.f18382a.a(InetSocketAddress.createUnresolved(this.f18387f, this.f18388g));
        if (g1VarA != null) {
            return new vb.y(g1VarA);
        }
        return null;
    }

    public c o(boolean z10) {
        c cVar = new c();
        try {
            cVar.f18401b = A();
        } catch (Exception e10) {
            if (!z10) {
                cVar.f18400a = vb.l1.f17420t.q("Unable to resolve host " + this.f18387f).p(e10);
                return cVar;
            }
        }
        if (f18381z) {
            cVar.f18402c = B();
        }
        return cVar;
    }

    public f u() {
        g gVar;
        if (!C(f18379x, f18380y, this.f18387f)) {
            return null;
        }
        f fVar = this.f18385d.get();
        return (fVar != null || (gVar = A) == null) ? fVar : gVar.a();
    }

    public final void z() {
        if (this.f18398q || this.f18394m || !m()) {
            return;
        }
        this.f18398q = true;
        this.f18395n.execute(new e(this.f18399r));
    }
}
