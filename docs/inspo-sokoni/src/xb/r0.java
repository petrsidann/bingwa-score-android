package xb;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f18855a = Logger.getLogger(r0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<vb.l1.b> f18856b = Collections.unmodifiableSet(EnumSet.of(vb.l1.b.OK, vb.l1.b.INVALID_ARGUMENT, vb.l1.b.NOT_FOUND, vb.l1.b.ALREADY_EXISTS, vb.l1.b.FAILED_PRECONDITION, vb.l1.b.ABORTED, vb.l1.b.OUT_OF_RANGE, vb.l1.b.DATA_LOSS));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f18857c = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final vb.a1.g<Long> f18858d = vb.a1.g.e("grpc-timeout", new i());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final vb.a1.g<String> f18859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final vb.a1.g<byte[]> f18860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final vb.a1.g<String> f18861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final vb.a1.g<byte[]> f18862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final vb.a1.g<String> f18863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final vb.a1.g<String> f18864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final vb.a1.g<String> f18865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final vb.a1.g<String> f18866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j6.o f18867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f18868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f18869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f18870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final vb.h1 f18871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final vb.h1 f18872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final vb.c.C0304c<Boolean> f18873s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final vb.k f18874t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l2.d<Executor> f18875u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l2.d<ScheduledExecutorService> f18876v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j6.r<j6.p> f18877w;

    public class a implements vb.h1 {
        @Override // vb.h1
        public vb.g1 a(SocketAddress socketAddress) {
            return null;
        }
    }

    public class b extends vb.k {
    }

    public class c implements l2.d<Executor> {
        @Override // xb.l2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // xb.l2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Executor a() {
            return Executors.newCachedThreadPool(r0.j("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    public class d implements l2.d<ScheduledExecutorService> {
        @Override // xb.l2.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // xb.l2.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ScheduledExecutorService a() {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, r0.j("grpc-timer-%d", true));
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
            return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    public class e implements j6.r<j6.p> {
        @Override // j6.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public j6.p get() {
            return j6.p.c();
        }
    }

    public class f implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.k.a f18878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f18879b;

        public f(vb.k.a aVar, t tVar) {
            this.f18878a = aVar;
            this.f18879b = tVar;
        }

        @Override // vb.r0
        public vb.l0 g() {
            return this.f18879b.g();
        }

        @Override // xb.t
        public r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
            vb.k kVarA = this.f18878a.a(vb.k.b.a().b(cVar).a(), a1Var);
            j6.m.v(kVarArr[kVarArr.length - 1] == r0.f18874t, "lb tracer already assigned");
            kVarArr[kVarArr.length - 1] = kVarA;
            return this.f18879b.h(b1Var, a1Var, cVar, kVarArr);
        }
    }

    public static final class g implements vb.o0.a<byte[]> {
        public g() {
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // vb.a1.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f18880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final h f18881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f18882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f18883f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final h f18884l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f18885m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final h f18886n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final h f18887o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final h f18888p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final h f18889q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final h f18890r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final h f18891s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final h f18892t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final h f18893u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final h[] f18894v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final /* synthetic */ h[] f18895w;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.l1 f18897b;

        static {
            vb.l1 l1Var = vb.l1.f17420t;
            h hVar = new h("NO_ERROR", 0, 0, l1Var);
            f18880c = hVar;
            vb.l1 l1Var2 = vb.l1.f17419s;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, l1Var2);
            f18881d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, l1Var2);
            f18882e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, l1Var2);
            f18883f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, l1Var2);
            f18884l = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, l1Var2);
            f18885m = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, l1Var2);
            f18886n = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, l1Var);
            f18887o = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, vb.l1.f17406f);
            f18888p = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, l1Var2);
            f18889q = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, l1Var2);
            f18890r = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, vb.l1.f17414n.q("Bandwidth exhausted"));
            f18891s = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, vb.l1.f17412l.q("Permission denied as protocol is not secure enough to call"));
            f18892t = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, vb.l1.f17407g);
            f18893u = hVar14;
            f18895w = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f18894v = d();
        }

        public h(String str, int i10, int i11, vb.l1 l1Var) {
            super(str, i10);
            this.f18896a = i11;
            String str2 = "HTTP/2 error code: " + name();
            if (l1Var.n() != null) {
                str2 = str2 + " (" + l1Var.n() + ")";
            }
            this.f18897b = l1Var.q(str2);
        }

        public static h[] d() {
            h[] hVarArrValues = values();
            h[] hVarArr = new h[((int) hVarArrValues[hVarArrValues.length - 1].h()) + 1];
            for (h hVar : hVarArrValues) {
                hVarArr[(int) hVar.h()] = hVar;
            }
            return hVarArr;
        }

        public static h i(long j10) {
            h[] hVarArr = f18894v;
            if (j10 >= hVarArr.length || j10 < 0) {
                return null;
            }
            return hVarArr[(int) j10];
        }

        public static vb.l1 l(long j10) {
            h hVarI = i(j10);
            if (hVarI != null) {
                return hVarI.k();
            }
            return vb.l1.h(f18882e.k().m().i()).q("Unrecognized HTTP/2 error code: " + j10);
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f18895w.clone();
        }

        public long h() {
            return this.f18896a;
        }

        public vb.l1 k() {
            return this.f18897b;
        }
    }

    public static class i implements vb.a1.d<Long> {
        @Override // vb.a1.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long b(String str) {
            TimeUnit timeUnit;
            j6.m.e(str.length() > 0, "empty timeout");
            j6.m.e(str.length() <= 9, "bad timeout format");
            long j10 = Long.parseLong(str.substring(0, str.length() - 1));
            char cCharAt = str.charAt(str.length() - 1);
            if (cCharAt == 'H') {
                timeUnit = TimeUnit.HOURS;
            } else if (cCharAt == 'M') {
                timeUnit = TimeUnit.MINUTES;
            } else if (cCharAt == 'S') {
                timeUnit = TimeUnit.SECONDS;
            } else if (cCharAt == 'u') {
                timeUnit = TimeUnit.MICROSECONDS;
            } else {
                if (cCharAt != 'm') {
                    if (cCharAt == 'n') {
                        return Long.valueOf(j10);
                    }
                    throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
                }
                timeUnit = TimeUnit.MILLISECONDS;
            }
            return Long.valueOf(timeUnit.toNanos(j10));
        }

        @Override // vb.a1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(Long l10) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l10.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l10.longValue() < 100000000) {
                return l10 + "n";
            }
            if (l10.longValue() < 100000000000L) {
                return timeUnit.toMicros(l10.longValue()) + "u";
            }
            if (l10.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l10.longValue()) + "m";
            }
            if (l10.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l10.longValue()) + "S";
            }
            if (l10.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l10.longValue()) + "M";
            }
            return timeUnit.toHours(l10.longValue()) + "H";
        }
    }

    static {
        vb.a1.d<String> dVar = vb.a1.f17241e;
        f18859e = vb.a1.g.e("grpc-encoding", dVar);
        a aVar = null;
        f18860f = vb.o0.b("grpc-accept-encoding", new g(aVar));
        f18861g = vb.a1.g.e("content-encoding", dVar);
        f18862h = vb.o0.b("accept-encoding", new g(aVar));
        f18863i = vb.a1.g.e("content-length", dVar);
        f18864j = vb.a1.g.e("content-type", dVar);
        f18865k = vb.a1.g.e("te", dVar);
        f18866l = vb.a1.g.e("user-agent", dVar);
        f18867m = j6.o.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f18868n = timeUnit.toNanos(20L);
        f18869o = TimeUnit.HOURS.toNanos(2L);
        f18870p = timeUnit.toNanos(20L);
        f18871q = new x1();
        f18872r = new a();
        f18873s = vb.c.C0304c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f18874t = new b();
        f18875u = new c();
        f18876v = new d();
        f18877w = new e();
    }

    public static URI b(String str) {
        j6.m.p(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException("Invalid authority: " + str, e10);
        }
    }

    public static String c(String str) {
        j6.m.k(b(str).getAuthority().indexOf(64) == -1, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static void d(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e10) {
            f18855a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e10);
        }
    }

    public static void e(q2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                d(next);
            }
        }
    }

    public static vb.k[] f(vb.c cVar, vb.a1 a1Var, int i10, boolean z10) {
        List<vb.k.a> listI = cVar.i();
        int size = listI.size() + 1;
        vb.k[] kVarArr = new vb.k[size];
        vb.k.b bVarA = vb.k.b.a().b(cVar).d(i10).c(z10).a();
        for (int i11 = 0; i11 < listI.size(); i11++) {
            kVarArr[i11] = listI.get(i11).a(bVarA, a1Var);
        }
        kVarArr[size - 1] = f18874t;
        return kVarArr;
    }

    public static boolean g(String str, boolean z10) {
        String property = System.getenv(str);
        if (property == null) {
            property = System.getProperty(str);
        }
        if (z10) {
            return j6.q.a(property) || Boolean.parseBoolean(property);
        }
        return !j6.q.a(property) && Boolean.parseBoolean(property);
    }

    public static String h(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str2 != null) {
            sb2.append(str2);
            sb2.append(' ');
        }
        sb2.append("grpc-java-");
        sb2.append(str);
        sb2.append('/');
        sb2.append("1.62.2");
        return sb2.toString();
    }

    public static String i(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory j(String str, boolean z10) {
        return new p6.g().e(z10).f(str).b();
    }

    public static t k(vb.t0.f fVar, boolean z10) {
        vb.t0.i iVarC = fVar.c();
        t tVarB = iVarC != null ? ((t2) iVarC.e()).b() : null;
        if (tVarB != null) {
            vb.k.a aVarB = fVar.b();
            return aVarB == null ? tVarB : new f(aVarB, tVarB);
        }
        if (!fVar.a().o()) {
            if (fVar.d()) {
                return new h0(o(fVar.a()), s.a.DROPPED);
            }
            if (!z10) {
                return new h0(o(fVar.a()), s.a.PROCESSED);
            }
        }
        return null;
    }

    public static vb.l1.b l(int i10) {
        if (i10 >= 100 && i10 < 200) {
            return vb.l1.b.INTERNAL;
        }
        if (i10 != 400) {
            if (i10 == 401) {
                return vb.l1.b.UNAUTHENTICATED;
            }
            if (i10 == 403) {
                return vb.l1.b.PERMISSION_DENIED;
            }
            if (i10 == 404) {
                return vb.l1.b.UNIMPLEMENTED;
            }
            if (i10 != 429) {
                if (i10 != 431) {
                    switch (i10) {
                        case 502:
                        case 503:
                        case 504:
                            break;
                        default:
                            return vb.l1.b.UNKNOWN;
                    }
                }
            }
            return vb.l1.b.UNAVAILABLE;
        }
        return vb.l1.b.INTERNAL;
    }

    public static vb.l1 m(int i10) {
        return l(i10).h().q("HTTP status code " + i10);
    }

    public static boolean n(String str) {
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (!lowerCase.startsWith("application/grpc")) {
            return false;
        }
        if (lowerCase.length() == 16) {
            return true;
        }
        char cCharAt = lowerCase.charAt(16);
        return cCharAt == '+' || cCharAt == ';';
    }

    public static vb.l1 o(vb.l1 l1Var) {
        j6.m.d(l1Var != null);
        if (!f18856b.contains(l1Var.m())) {
            return l1Var;
        }
        return vb.l1.f17419s.q("Inappropriate status code from control plane: " + l1Var.m() + " " + l1Var.n()).p(l1Var.l());
    }

    public static boolean p(vb.c cVar) {
        return !Boolean.TRUE.equals(cVar.h(f18873s));
    }
}
