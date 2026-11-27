package xb;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 implements vb.k0<Object>, t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.l0 f19042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xb.j.a f19045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f19046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f19047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScheduledExecutorService f19048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vb.f0 f19049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n f19050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f19051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final vb.f f19052k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<vb.l> f19053l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final vb.p1 f19054m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f19055n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile List<vb.y> f19056o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public xb.j f19057p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j6.p f19058q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public vb.p1.d f19059r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public vb.p1.d f19060s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k1 f19061t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public w f19064w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile k1 f19065x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public vb.l1 f19067z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Collection<w> f19062u = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final w0<w> f19063v = new a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile vb.r f19066y = vb.r.a(vb.q.IDLE);

    public class a extends w0<w> {
        public a() {
        }

        @Override // xb.w0
        public void b() {
            y0.this.f19046e.a(y0.this);
        }

        @Override // xb.w0
        public void c() {
            y0.this.f19046e.b(y0.this);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f19059r = null;
            y0.this.f19052k.a(vb.f.a.INFO, "CONNECTING after backoff");
            y0.this.O(vb.q.CONNECTING);
            y0.this.U();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y0.this.f19066y.c() == vb.q.IDLE) {
                y0.this.f19052k.a(vb.f.a.INFO, "CONNECTING as requested");
                y0.this.O(vb.q.CONNECTING);
                y0.this.U();
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f19071a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k1 k1Var = y0.this.f19061t;
                y0.this.f19060s = null;
                y0.this.f19061t = null;
                k1Var.c(vb.l1.f17420t.q("InternalSubchannel closed transport due to address change"));
            }
        }

        public d(List list) {
            this.f19071a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            k1 k1Var;
            SocketAddress socketAddressA = y0.this.f19055n.a();
            y0.this.f19055n.h(this.f19071a);
            y0.this.f19056o = this.f19071a;
            vb.q qVarC = y0.this.f19066y.c();
            vb.q qVar = vb.q.READY;
            if ((qVarC != qVar && y0.this.f19066y.c() != vb.q.CONNECTING) || y0.this.f19055n.g(socketAddressA)) {
                k1Var = null;
            } else if (y0.this.f19066y.c() == qVar) {
                k1Var = y0.this.f19065x;
                y0.this.f19065x = null;
                y0.this.f19055n.f();
                y0.this.O(vb.q.IDLE);
            } else {
                y0.this.f19064w.c(vb.l1.f17420t.q("InternalSubchannel closed pending transport due to address change"));
                y0.this.f19064w = null;
                y0.this.f19055n.f();
                y0.this.U();
                k1Var = null;
            }
            if (k1Var != null) {
                if (y0.this.f19060s != null) {
                    y0.this.f19061t.c(vb.l1.f17420t.q("InternalSubchannel closed transport early due to address change"));
                    y0.this.f19060s.a();
                    y0.this.f19060s = null;
                    y0.this.f19061t = null;
                }
                y0.this.f19061t = k1Var;
                y0 y0Var = y0.this;
                y0Var.f19060s = y0Var.f19054m.c(new a(), 5L, TimeUnit.SECONDS, y0.this.f19048g);
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f19074a;

        public e(vb.l1 l1Var) {
            this.f19074a = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vb.q qVarC = y0.this.f19066y.c();
            vb.q qVar = vb.q.SHUTDOWN;
            if (qVarC == qVar) {
                return;
            }
            y0.this.f19067z = this.f19074a;
            k1 k1Var = y0.this.f19065x;
            w wVar = y0.this.f19064w;
            y0.this.f19065x = null;
            y0.this.f19064w = null;
            y0.this.O(qVar);
            y0.this.f19055n.f();
            if (y0.this.f19062u.isEmpty()) {
                y0.this.Q();
            }
            y0.this.L();
            if (y0.this.f19060s != null) {
                y0.this.f19060s.a();
                y0.this.f19061t.c(this.f19074a);
                y0.this.f19060s = null;
                y0.this.f19061t = null;
            }
            if (k1Var != null) {
                k1Var.c(this.f19074a);
            }
            if (wVar != null) {
                wVar.c(this.f19074a);
            }
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f19052k.a(vb.f.a.INFO, "Terminated");
            y0.this.f19046e.d(y0.this);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f19077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f19078b;

        public g(w wVar, boolean z10) {
            this.f19077a = wVar;
            this.f19078b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f19063v.e(this.f19077a, this.f19078b);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f19080a;

        public h(vb.l1 l1Var) {
            this.f19080a = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(y0.this.f19062u).iterator();
            while (it.hasNext()) {
                ((k1) it.next()).d(this.f19080a);
            }
        }
    }

    public static final class i extends k0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f19082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f19083b;

        public class a extends i0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r f19084a;

            /* JADX INFO: renamed from: xb.y0$i$a$a, reason: collision with other inner class name */
            public class C0330a extends j0 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ s f19086a;

                public C0330a(s sVar) {
                    this.f19086a = sVar;
                }

                @Override // xb.j0, xb.s
                public void c(vb.l1 l1Var, s.a aVar, vb.a1 a1Var) {
                    i.this.f19083b.a(l1Var.o());
                    super.c(l1Var, aVar, a1Var);
                }

                @Override // xb.j0
                public s e() {
                    return this.f19086a;
                }
            }

            public a(r rVar) {
                this.f19084a = rVar;
            }

            @Override // xb.i0, xb.r
            public void g(s sVar) {
                i.this.f19083b.b();
                super.g(new C0330a(sVar));
            }

            @Override // xb.i0
            public r m() {
                return this.f19084a;
            }
        }

        public i(w wVar, n nVar) {
            this.f19082a = wVar;
            this.f19083b = nVar;
        }

        public /* synthetic */ i(w wVar, n nVar, a aVar) {
            this(wVar, nVar);
        }

        @Override // xb.k0
        public w b() {
            return this.f19082a;
        }

        @Override // xb.k0, xb.t
        public r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
            return new a(super.h(b1Var, a1Var, cVar, kVarArr));
        }
    }

    public static abstract class j {
        public abstract void a(y0 y0Var);

        public abstract void b(y0 y0Var);

        public abstract void c(y0 y0Var, vb.r rVar);

        public abstract void d(y0 y0Var);
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<vb.y> f19088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19090c;

        public k(List<vb.y> list) {
            this.f19088a = list;
        }

        public SocketAddress a() {
            return this.f19088a.get(this.f19089b).a().get(this.f19090c);
        }

        public vb.a b() {
            return this.f19088a.get(this.f19089b).b();
        }

        public void c() {
            vb.y yVar = this.f19088a.get(this.f19089b);
            int i10 = this.f19090c + 1;
            this.f19090c = i10;
            if (i10 >= yVar.a().size()) {
                this.f19089b++;
                this.f19090c = 0;
            }
        }

        public boolean d() {
            return this.f19089b == 0 && this.f19090c == 0;
        }

        public boolean e() {
            return this.f19089b < this.f19088a.size();
        }

        public void f() {
            this.f19089b = 0;
            this.f19090c = 0;
        }

        public boolean g(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f19088a.size(); i10++) {
                int iIndexOf = this.f19088a.get(i10).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f19089b = i10;
                    this.f19090c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public void h(List<vb.y> list) {
            this.f19088a = list;
            f();
        }
    }

    public class l implements k1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w f19091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19092b = false;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y0.this.f19057p = null;
                if (y0.this.f19067z != null) {
                    j6.m.v(y0.this.f19065x == null, "Unexpected non-null activeTransport");
                    l lVar = l.this;
                    lVar.f19091a.c(y0.this.f19067z);
                    return;
                }
                w wVar = y0.this.f19064w;
                l lVar2 = l.this;
                w wVar2 = lVar2.f19091a;
                if (wVar == wVar2) {
                    y0.this.f19065x = wVar2;
                    y0.this.f19064w = null;
                    y0.this.O(vb.q.READY);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vb.l1 f19095a;

            public b(vb.l1 l1Var) {
                this.f19095a = l1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (y0.this.f19066y.c() == vb.q.SHUTDOWN) {
                    return;
                }
                k1 k1Var = y0.this.f19065x;
                l lVar = l.this;
                if (k1Var == lVar.f19091a) {
                    y0.this.f19065x = null;
                    y0.this.f19055n.f();
                    y0.this.O(vb.q.IDLE);
                    return;
                }
                w wVar = y0.this.f19064w;
                l lVar2 = l.this;
                if (wVar == lVar2.f19091a) {
                    j6.m.x(y0.this.f19066y.c() == vb.q.CONNECTING, "Expected state is CONNECTING, actual state is %s", y0.this.f19066y.c());
                    y0.this.f19055n.c();
                    if (y0.this.f19055n.e()) {
                        y0.this.U();
                        return;
                    }
                    y0.this.f19064w = null;
                    y0.this.f19055n.f();
                    y0.this.T(this.f19095a);
                }
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                y0.this.f19062u.remove(l.this.f19091a);
                if (y0.this.f19066y.c() == vb.q.SHUTDOWN && y0.this.f19062u.isEmpty()) {
                    y0.this.Q();
                }
            }
        }

        public l(w wVar) {
            this.f19091a = wVar;
        }

        @Override // xb.k1.a
        public void a() {
            y0.this.f19052k.a(vb.f.a.INFO, "READY");
            y0.this.f19054m.execute(new a());
        }

        @Override // xb.k1.a
        public void b(vb.l1 l1Var) {
            y0.this.f19052k.b(vb.f.a.INFO, "{0} SHUTDOWN with {1}", this.f19091a.g(), y0.this.S(l1Var));
            this.f19092b = true;
            y0.this.f19054m.execute(new b(l1Var));
        }

        @Override // xb.k1.a
        public void c() {
            j6.m.v(this.f19092b, "transportShutdown() must be called before transportTerminated().");
            y0.this.f19052k.b(vb.f.a.INFO, "{0} Terminated", this.f19091a.g());
            y0.this.f19049h.i(this.f19091a);
            y0.this.R(this.f19091a, false);
            Iterator it = y0.this.f19053l.iterator();
            while (it.hasNext()) {
                ((vb.l) it.next()).b(this.f19091a.getAttributes());
            }
            y0.this.f19054m.execute(new c());
        }

        @Override // xb.k1.a
        public vb.a d(vb.a aVar) {
            for (vb.l lVar : y0.this.f19053l) {
                aVar = (vb.a) j6.m.q(lVar.a(aVar), "Filter %s returned null", lVar);
            }
            return aVar;
        }

        @Override // xb.k1.a
        public void e(boolean z10) {
            y0.this.R(this.f19091a, z10);
        }
    }

    public static final class m extends vb.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.l0 f19098a;

        @Override // vb.f
        public void a(vb.f.a aVar, String str) {
            o.d(this.f19098a, aVar, str);
        }

        @Override // vb.f
        public void b(vb.f.a aVar, String str, Object... objArr) {
            o.e(this.f19098a, aVar, str, objArr);
        }
    }

    public y0(List<vb.y> list, String str, String str2, xb.j.a aVar, u uVar, ScheduledExecutorService scheduledExecutorService, j6.r<j6.p> rVar, vb.p1 p1Var, j jVar, vb.f0 f0Var, n nVar, p pVar, vb.l0 l0Var, vb.f fVar, List<vb.l> list2) {
        j6.m.p(list, "addressGroups");
        j6.m.e(!list.isEmpty(), "addressGroups is empty");
        M(list, "addressGroups contains null entry");
        List<vb.y> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f19056o = listUnmodifiableList;
        this.f19055n = new k(listUnmodifiableList);
        this.f19043b = str;
        this.f19044c = str2;
        this.f19045d = aVar;
        this.f19047f = uVar;
        this.f19048g = scheduledExecutorService;
        this.f19058q = rVar.get();
        this.f19054m = p1Var;
        this.f19046e = jVar;
        this.f19049h = f0Var;
        this.f19050i = nVar;
        this.f19051j = (p) j6.m.p(pVar, "channelTracer");
        this.f19042a = (vb.l0) j6.m.p(l0Var, "logId");
        this.f19052k = (vb.f) j6.m.p(fVar, "channelLogger");
        this.f19053l = list2;
    }

    public static void M(List<?> list, String str) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            j6.m.p(it.next(), str);
        }
    }

    public final void L() {
        this.f19054m.f();
        vb.p1.d dVar = this.f19059r;
        if (dVar != null) {
            dVar.a();
            this.f19059r = null;
            this.f19057p = null;
        }
    }

    public vb.q N() {
        return this.f19066y.c();
    }

    public final void O(vb.q qVar) {
        this.f19054m.f();
        P(vb.r.a(qVar));
    }

    public final void P(vb.r rVar) {
        this.f19054m.f();
        if (this.f19066y.c() != rVar.c()) {
            j6.m.v(this.f19066y.c() != vb.q.SHUTDOWN, "Cannot transition out of SHUTDOWN to " + rVar);
            this.f19066y = rVar;
            this.f19046e.c(this, rVar);
        }
    }

    public final void Q() {
        this.f19054m.execute(new f());
    }

    public final void R(w wVar, boolean z10) {
        this.f19054m.execute(new g(wVar, z10));
    }

    public final String S(vb.l1 l1Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l1Var.m());
        if (l1Var.n() != null) {
            sb2.append("(");
            sb2.append(l1Var.n());
            sb2.append(")");
        }
        if (l1Var.l() != null) {
            sb2.append("[");
            sb2.append(l1Var.l());
            sb2.append("]");
        }
        return sb2.toString();
    }

    public final void T(vb.l1 l1Var) {
        this.f19054m.f();
        P(vb.r.b(l1Var));
        if (this.f19057p == null) {
            this.f19057p = this.f19045d.get();
        }
        long jA = this.f19057p.a();
        j6.p pVar = this.f19058q;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jD = jA - pVar.d(timeUnit);
        this.f19052k.b(vb.f.a.INFO, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", S(l1Var), Long.valueOf(jD));
        j6.m.v(this.f19059r == null, "previous reconnectTask is not done");
        this.f19059r = this.f19054m.c(new b(), jD, timeUnit, this.f19048g);
    }

    public final void U() {
        SocketAddress socketAddressC;
        vb.e0 e0Var;
        this.f19054m.f();
        j6.m.v(this.f19059r == null, "Should have no reconnectTask scheduled");
        if (this.f19055n.d()) {
            this.f19058q.f().g();
        }
        SocketAddress socketAddressA = this.f19055n.a();
        a aVar = null;
        if (socketAddressA instanceof vb.e0) {
            e0Var = (vb.e0) socketAddressA;
            socketAddressC = e0Var.c();
        } else {
            socketAddressC = socketAddressA;
            e0Var = null;
        }
        vb.a aVarB = this.f19055n.b();
        String str = (String) aVarB.b(vb.y.f17549d);
        u.a aVar2 = new u.a();
        if (str == null) {
            str = this.f19043b;
        }
        u.a aVarG = aVar2.e(str).f(aVarB).h(this.f19044c).g(e0Var);
        m mVar = new m();
        mVar.f19098a = g();
        i iVar = new i(this.f19047f.F(socketAddressC, aVarG, mVar), this.f19050i, aVar);
        mVar.f19098a = iVar.g();
        this.f19049h.c(iVar);
        this.f19064w = iVar;
        this.f19062u.add(iVar);
        Runnable runnableA = iVar.a(new l(iVar));
        if (runnableA != null) {
            this.f19054m.b(runnableA);
        }
        this.f19052k.b(vb.f.a.INFO, "Started transport {0}", mVar.f19098a);
    }

    public void V(List<vb.y> list) {
        j6.m.p(list, "newAddressGroups");
        M(list, "newAddressGroups contains null entry");
        j6.m.e(!list.isEmpty(), "newAddressGroups is empty");
        this.f19054m.execute(new d(Collections.unmodifiableList(new ArrayList(list))));
    }

    @Override // xb.t2
    public t b() {
        k1 k1Var = this.f19065x;
        if (k1Var != null) {
            return k1Var;
        }
        this.f19054m.execute(new c());
        return null;
    }

    public void c(vb.l1 l1Var) {
        this.f19054m.execute(new e(l1Var));
    }

    public void d(vb.l1 l1Var) {
        c(l1Var);
        this.f19054m.execute(new h(l1Var));
    }

    @Override // vb.r0
    public vb.l0 g() {
        return this.f19042a;
    }

    public String toString() {
        return j6.g.b(this).c("logId", this.f19042a.d()).d("addressGroups", this.f19056o).toString();
    }
}
