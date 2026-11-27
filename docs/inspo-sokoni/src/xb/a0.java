package xb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class a0<ReqT, RespT> extends vb.g<ReqT, RespT> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f18103j = Logger.getLogger(a0.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final vb.g<Object, Object> f18104k = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture<?> f18105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb.s f18107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f18108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vb.g.a<RespT> f18109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vb.g<ReqT, RespT> f18110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public vb.l1 f18111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Runnable> f18112h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k<RespT> f18113i;

    public class a extends y {
        public a(vb.s sVar) {
            super(sVar);
        }

        @Override // xb.y
        public void a() {
            a0.this.m();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f18115a;

        public b(StringBuilder sb2) {
            this.f18115a = sb2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.k(vb.l1.f17409i.q(this.f18115a.toString()), true);
        }
    }

    public class c extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f18117b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(a0.this.f18107c);
            this.f18117b = kVar;
        }

        @Override // xb.y
        public void a() {
            this.f18117b.g();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.g.a f18119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vb.a1 f18120b;

        public d(vb.g.a aVar, vb.a1 a1Var) {
            this.f18119a = aVar;
            this.f18120b = a1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f18110f.e(this.f18119a, this.f18120b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f18122a;

        public e(vb.l1 l1Var) {
            this.f18122a = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f18110f.a(this.f18122a.n(), this.f18122a.l());
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f18124a;

        public f(Object obj) {
            this.f18124a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            a0.this.f18110f.d(this.f18124a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18126a;

        public g(int i10) {
            this.f18126a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f18110f.c(this.f18126a);
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.this.f18110f.b();
        }
    }

    public class i extends vb.g<Object, Object> {
        @Override // vb.g
        public void a(String str, Throwable th) {
        }

        @Override // vb.g
        public void b() {
        }

        @Override // vb.g
        public void c(int i10) {
        }

        @Override // vb.g
        public void d(Object obj) {
        }

        @Override // vb.g
        public void e(vb.g.a<Object> aVar, vb.a1 a1Var) {
        }
    }

    public final class j extends y {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.g.a<RespT> f18129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vb.l1 f18130c;

        public j(vb.g.a<RespT> aVar, vb.l1 l1Var) {
            super(a0.this.f18107c);
            this.f18129b = aVar;
            this.f18130c = l1Var;
        }

        @Override // xb.y
        public void a() {
            this.f18129b.a(this.f18130c, new vb.a1());
        }
    }

    public static final class k<RespT> extends vb.g.a<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.g.a<RespT> f18132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f18133b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Runnable> f18134c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18135a;

            public a(vb.a1 a1Var) {
                this.f18135a = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f18132a.b(this.f18135a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f18137a;

            public b(Object obj) {
                this.f18137a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f18132a.c(this.f18137a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f18139a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vb.a1 f18140b;

            public c(vb.l1 l1Var, vb.a1 a1Var) {
                this.f18139a = l1Var;
                this.f18140b = a1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f18132a.a(this.f18139a, this.f18140b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f18132a.d();
            }
        }

        public k(vb.g.a<RespT> aVar) {
            this.f18132a = aVar;
        }

        @Override // vb.g.a
        public void a(vb.l1 l1Var, vb.a1 a1Var) {
            f(new c(l1Var, a1Var));
        }

        @Override // vb.g.a
        public void b(vb.a1 a1Var) {
            if (this.f18133b) {
                this.f18132a.b(a1Var);
            } else {
                f(new a(a1Var));
            }
        }

        @Override // vb.g.a
        public void c(RespT respt) {
            if (this.f18133b) {
                this.f18132a.c(respt);
            } else {
                f(new b(respt));
            }
        }

        @Override // vb.g.a
        public void d() {
            if (this.f18133b) {
                this.f18132a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                if (this.f18133b) {
                    runnable.run();
                } else {
                    this.f18134c.add(runnable);
                }
            }
        }

        public void g() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    if (this.f18134c.isEmpty()) {
                        this.f18134c = null;
                        this.f18133b = true;
                        return;
                    } else {
                        list = this.f18134c;
                        this.f18134c = arrayList;
                    }
                }
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    public a0(Executor executor, ScheduledExecutorService scheduledExecutorService, vb.u uVar) {
        this.f18106b = (Executor) j6.m.p(executor, "callExecutor");
        j6.m.p(scheduledExecutorService, "scheduler");
        this.f18107c = vb.s.e();
        this.f18105a = o(scheduledExecutorService, uVar);
    }

    @Override // vb.g
    public final void a(String str, Throwable th) {
        vb.l1 l1Var = vb.l1.f17406f;
        if (str == null) {
            str = "Call cancelled without message";
        }
        vb.l1 l1VarQ = l1Var.q(str);
        if (th != null) {
            l1VarQ = l1VarQ.p(th);
        }
        k(l1VarQ, false);
    }

    @Override // vb.g
    public final void b() {
        l(new h());
    }

    @Override // vb.g
    public final void c(int i10) {
        if (this.f18108d) {
            this.f18110f.c(i10);
        } else {
            l(new g(i10));
        }
    }

    @Override // vb.g
    public final void d(ReqT reqt) {
        if (this.f18108d) {
            this.f18110f.d(reqt);
        } else {
            l(new f(reqt));
        }
    }

    @Override // vb.g
    public final void e(vb.g.a<RespT> aVar, vb.a1 a1Var) {
        vb.l1 l1Var;
        boolean z10;
        j6.m.v(this.f18109e == null, "already started");
        synchronized (this) {
            this.f18109e = (vb.g.a) j6.m.p(aVar, "listener");
            l1Var = this.f18111g;
            z10 = this.f18108d;
            if (!z10) {
                k<RespT> kVar = new k<>(aVar);
                this.f18113i = kVar;
                aVar = kVar;
            }
        }
        if (l1Var != null) {
            this.f18106b.execute(new j(aVar, l1Var));
        } else if (z10) {
            this.f18110f.e(aVar, a1Var);
        } else {
            l(new d(aVar, a1Var));
        }
    }

    public void j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(vb.l1 l1Var, boolean z10) {
        boolean z11;
        vb.g.a<RespT> aVar;
        synchronized (this) {
            if (this.f18110f == null) {
                q(f18104k);
                aVar = this.f18109e;
                this.f18111g = l1Var;
                z11 = false;
            } else {
                if (z10) {
                    return;
                }
                z11 = true;
                aVar = null;
            }
            if (z11) {
                l(new e(l1Var));
            } else {
                if (aVar != null) {
                    this.f18106b.execute(new j(aVar, l1Var));
                }
                m();
            }
            j();
        }
    }

    public final void l(Runnable runnable) {
        synchronized (this) {
            if (this.f18108d) {
                runnable.run();
            } else {
                this.f18112h.add(runnable);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        r0.next().run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m() {
        k<RespT> kVar;
        List<Runnable> list;
        List<Runnable> arrayList = new ArrayList<>();
        while (true) {
            synchronized (this) {
                if (this.f18112h.isEmpty()) {
                    break;
                }
                list = this.f18112h;
                this.f18112h = arrayList;
            }
            if (kVar != null) {
                this.f18106b.execute(new c(kVar));
            }
            list.clear();
            arrayList = list;
        }
        this.f18112h = null;
        this.f18108d = true;
        kVar = this.f18113i;
        if (kVar != null) {
            this.f18106b.execute(new c(kVar));
        }
    }

    public final boolean n(vb.u uVar, vb.u uVar2) {
        if (uVar2 == null) {
            return true;
        }
        if (uVar == null) {
            return false;
        }
        return uVar.o(uVar2);
    }

    public final ScheduledFuture<?> o(ScheduledExecutorService scheduledExecutorService, vb.u uVar) {
        String str;
        vb.u uVarG = this.f18107c.g();
        if (uVar == null && uVarG == null) {
            return null;
        }
        long jR = uVar != null ? uVar.r(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (uVarG != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (uVarG.r(timeUnit) < jR) {
                jR = uVarG.r(timeUnit);
                Logger logger = f18103j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jR)));
                    sb2.append(uVar == null ? " Explicit call timeout was not set." : String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(uVar.r(timeUnit))));
                    logger.fine(sb2.toString());
                }
            }
        }
        long jAbs = Math.abs(jR);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jR) % timeUnit2.toNanos(1L);
        StringBuilder sb3 = new StringBuilder();
        String str2 = n(uVarG, uVar) ? "Context" : "CallOptions";
        if (jR < 0) {
            sb3.append("ClientCall started after ");
            sb3.append(str2);
            str = " deadline was exceeded. Deadline has been exceeded for ";
        } else {
            sb3.append("Deadline ");
            sb3.append(str2);
            str = " will be exceeded in ";
        }
        sb3.append(str);
        sb3.append(nanos);
        sb3.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb3.append("s. ");
        return scheduledExecutorService.schedule(new b(sb3), jR, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(vb.g<ReqT, RespT> gVar) {
        synchronized (this) {
            if (this.f18110f != null) {
                return null;
            }
            q((vb.g) j6.m.p(gVar, "call"));
            return new a(this.f18107c);
        }
    }

    public final void q(vb.g<ReqT, RespT> gVar) {
        vb.g<ReqT, RespT> gVar2 = this.f18110f;
        j6.m.x(gVar2 == null, "realCall already set to %s", gVar2);
        ScheduledFuture<?> scheduledFuture = this.f18105a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f18110f = gVar;
    }

    public String toString() {
        return j6.g.b(this).d("realCall", this.f18110f).toString();
    }
}
