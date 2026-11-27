package vb;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c1 {

    public class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f17304a;

        public a(f fVar) {
            this.f17304a = fVar;
        }

        @Override // vb.c1.e, vb.c1.f
        public void b(l1 l1Var) {
            this.f17304a.b(l1Var);
        }

        @Override // vb.c1.e
        public void c(g gVar) {
            this.f17304a.a(gVar.a(), gVar.b());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h1 f17307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p1 f17308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h f17309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f17310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final vb.f f17311f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Executor f17312g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f17313h;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Integer f17314a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public h1 f17315b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public p1 f17316c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public h f17317d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f17318e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public vb.f f17319f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public Executor f17320g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f17321h;

            public b a() {
                return new b(this.f17314a, this.f17315b, this.f17316c, this.f17317d, this.f17318e, this.f17319f, this.f17320g, this.f17321h, null);
            }

            public a b(vb.f fVar) {
                this.f17319f = (vb.f) j6.m.o(fVar);
                return this;
            }

            public a c(int i10) {
                this.f17314a = Integer.valueOf(i10);
                return this;
            }

            public a d(Executor executor) {
                this.f17320g = executor;
                return this;
            }

            public a e(String str) {
                this.f17321h = str;
                return this;
            }

            public a f(h1 h1Var) {
                this.f17315b = (h1) j6.m.o(h1Var);
                return this;
            }

            public a g(ScheduledExecutorService scheduledExecutorService) {
                this.f17318e = (ScheduledExecutorService) j6.m.o(scheduledExecutorService);
                return this;
            }

            public a h(h hVar) {
                this.f17317d = (h) j6.m.o(hVar);
                return this;
            }

            public a i(p1 p1Var) {
                this.f17316c = (p1) j6.m.o(p1Var);
                return this;
            }
        }

        public b(Integer num, h1 h1Var, p1 p1Var, h hVar, ScheduledExecutorService scheduledExecutorService, vb.f fVar, Executor executor, String str) {
            this.f17306a = ((Integer) j6.m.p(num, "defaultPort not set")).intValue();
            this.f17307b = (h1) j6.m.p(h1Var, "proxyDetector not set");
            this.f17308c = (p1) j6.m.p(p1Var, "syncContext not set");
            this.f17309d = (h) j6.m.p(hVar, "serviceConfigParser not set");
            this.f17310e = scheduledExecutorService;
            this.f17311f = fVar;
            this.f17312g = executor;
            this.f17313h = str;
        }

        public /* synthetic */ b(Integer num, h1 h1Var, p1 p1Var, h hVar, ScheduledExecutorService scheduledExecutorService, vb.f fVar, Executor executor, String str, a aVar) {
            this(num, h1Var, p1Var, hVar, scheduledExecutorService, fVar, executor, str);
        }

        public static a g() {
            return new a();
        }

        public int a() {
            return this.f17306a;
        }

        public Executor b() {
            return this.f17312g;
        }

        public h1 c() {
            return this.f17307b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f17310e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public h e() {
            return this.f17309d;
        }

        public p1 f() {
            return this.f17308c;
        }

        public String toString() {
            return j6.g.b(this).b("defaultPort", this.f17306a).d("proxyDetector", this.f17307b).d("syncContext", this.f17308c).d("serviceConfigParser", this.f17309d).d("scheduledExecutorService", this.f17310e).d("channelLogger", this.f17311f).d("executor", this.f17312g).d("overrideAuthority", this.f17313h).toString();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f17322a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f17323b;

        public c(Object obj) {
            this.f17323b = j6.m.p(obj, "config");
            this.f17322a = null;
        }

        public c(l1 l1Var) {
            this.f17323b = null;
            this.f17322a = (l1) j6.m.p(l1Var, "status");
            j6.m.k(!l1Var.o(), "cannot use OK status: %s", l1Var);
        }

        public static c a(Object obj) {
            return new c(obj);
        }

        public static c b(l1 l1Var) {
            return new c(l1Var);
        }

        public Object c() {
            return this.f17323b;
        }

        public l1 d() {
            return this.f17322a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return j6.i.a(this.f17322a, cVar.f17322a) && j6.i.a(this.f17323b, cVar.f17323b);
        }

        public int hashCode() {
            return j6.i.b(this.f17322a, this.f17323b);
        }

        public String toString() {
            j6.g.b bVarB;
            String str;
            Object obj;
            if (this.f17323b != null) {
                bVarB = j6.g.b(this);
                str = "config";
                obj = this.f17323b;
            } else {
                bVarB = j6.g.b(this);
                str = "error";
                obj = this.f17322a;
            }
            return bVarB.d(str, obj).toString();
        }
    }

    public static abstract class d {
        public abstract String a();

        public abstract c1 b(URI uri, b bVar);
    }

    public static abstract class e implements f {
        @Override // vb.c1.f
        @Deprecated
        public final void a(List<y> list, vb.a aVar) {
            c(g.d().b(list).c(aVar).a());
        }

        @Override // vb.c1.f
        public abstract void b(l1 l1Var);

        public abstract void c(g gVar);
    }

    public interface f {
        void a(List<y> list, vb.a aVar);

        void b(l1 l1Var);
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<y> f17324a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.a f17325b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f17326c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public List<y> f17327a = Collections.emptyList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vb.a f17328b = vb.a.f17234c;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c f17329c;

            public g a() {
                return new g(this.f17327a, this.f17328b, this.f17329c);
            }

            public a b(List<y> list) {
                this.f17327a = list;
                return this;
            }

            public a c(vb.a aVar) {
                this.f17328b = aVar;
                return this;
            }

            public a d(c cVar) {
                this.f17329c = cVar;
                return this;
            }
        }

        public g(List<y> list, vb.a aVar, c cVar) {
            this.f17324a = Collections.unmodifiableList(new ArrayList(list));
            this.f17325b = (vb.a) j6.m.p(aVar, "attributes");
            this.f17326c = cVar;
        }

        public static a d() {
            return new a();
        }

        public List<y> a() {
            return this.f17324a;
        }

        public vb.a b() {
            return this.f17325b;
        }

        public c c() {
            return this.f17326c;
        }

        public a e() {
            return d().b(this.f17324a).c(this.f17325b).d(this.f17326c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return j6.i.a(this.f17324a, gVar.f17324a) && j6.i.a(this.f17325b, gVar.f17325b) && j6.i.a(this.f17326c, gVar.f17326c);
        }

        public int hashCode() {
            return j6.i.b(this.f17324a, this.f17325b, this.f17326c);
        }

        public String toString() {
            return j6.g.b(this).d("addresses", this.f17324a).d("attributes", this.f17325b).d("serviceConfig", this.f17326c).toString();
        }
    }

    public static abstract class h {
        public abstract c a(Map<String, ?> map);
    }

    public abstract String a();

    public void b() {
    }

    public abstract void c();

    public void d(e eVar) {
        e(eVar);
    }

    public void e(f fVar) {
        if (fVar instanceof e) {
            d((e) fVar);
        } else {
            d(new a(fVar));
        }
    }
}
