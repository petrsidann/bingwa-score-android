package k8;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import g8.k1;
import g8.n4;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import vb.l1;

/* JADX INFO: loaded from: classes.dex */
public final class s0 implements z0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.f f11794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g8.k0 f11796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q f11797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f11798e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l0 f11800g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a1 f11802i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b1 f11803j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z0 f11804k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11801h = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, n4> f11799f = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Deque<i8.g> f11805l = new ArrayDeque();

    public class a implements a1.a {
        public a() {
        }

        @Override // k8.u0
        public void a() {
            s0.this.x();
        }

        @Override // k8.u0
        public void b(l1 l1Var) {
            s0.this.w(l1Var);
        }

        @Override // k8.a1.a
        public void e(h8.v vVar, y0 y0Var) {
            s0.this.v(vVar, y0Var);
        }
    }

    public class b implements b1.a {
        public b() {
        }

        @Override // k8.u0
        public void a() {
            s0.this.f11803j.E();
        }

        @Override // k8.u0
        public void b(l1 l1Var) {
            s0.this.A(l1Var);
        }

        @Override // k8.b1.a
        public void c(h8.v vVar, List<i8.i> list) {
            s0.this.C(vVar, list);
        }

        @Override // k8.b1.a
        public void d() {
            s0.this.B();
        }
    }

    public interface c {
        void a(e8.z0 z0Var);

        s7.e<h8.k> b(int i10);

        void c(int i10, l1 l1Var);

        void d(n0 n0Var);

        void e(int i10, l1 l1Var);

        void f(i8.h hVar);
    }

    public s0(h8.f fVar, final c cVar, g8.k0 k0Var, q qVar, final l8.g gVar, n nVar) {
        this.f11794a = fVar;
        this.f11795b = cVar;
        this.f11796c = k0Var;
        this.f11797d = qVar;
        this.f11798e = nVar;
        Objects.requireNonNull(cVar);
        this.f11800g = new l0(gVar, new l0.a() { // from class: k8.p0
            @Override // k8.l0.a
            public final void a(e8.z0 z0Var) {
                cVar.a(z0Var);
            }
        });
        this.f11802i = qVar.e(new a());
        this.f11803j = qVar.f(new b());
        nVar.a(new l8.n() { // from class: k8.q0
            @Override // l8.n
            public final void accept(Object obj) {
                this.f11782a.E(gVar, (n.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(n.a aVar) {
        if (aVar.equals(n.a.REACHABLE) && this.f11800g.c().equals(e8.z0.ONLINE)) {
            return;
        }
        if (!(aVar.equals(n.a.UNREACHABLE) && this.f11800g.c().equals(e8.z0.OFFLINE)) && n()) {
            l8.v.a("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(l8.g gVar, final n.a aVar) {
        gVar.l(new Runnable() { // from class: k8.r0
            @Override // java.lang.Runnable
            public final void run() {
                this.f11786a.D(aVar);
            }
        });
    }

    public final void A(l1 l1Var) {
        if (l1Var.o()) {
            l8.b.d(!N(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!l1Var.o() && !this.f11805l.isEmpty()) {
            if (this.f11803j.A()) {
                y(l1Var);
            } else {
                z(l1Var);
            }
        }
        if (N()) {
            R();
        }
    }

    public final void B() {
        this.f11796c.o0(this.f11803j.z());
        Iterator<i8.g> it = this.f11805l.iterator();
        while (it.hasNext()) {
            this.f11803j.F(it.next().h());
        }
    }

    public final void C(h8.v vVar, List<i8.i> list) {
        this.f11795b.f(i8.h.a(this.f11805l.poll(), vVar, list, this.f11803j.z()));
        t();
    }

    public void F(n4 n4Var) {
        Integer numValueOf = Integer.valueOf(n4Var.h());
        if (this.f11799f.containsKey(numValueOf)) {
            return;
        }
        this.f11799f.put(numValueOf, n4Var);
        if (M()) {
            Q();
        } else if (this.f11802i.m()) {
            L(n4Var);
        }
    }

    public final void G(y0.d dVar) {
        l8.b.d(dVar.a() != null, "Processing target error without a cause", new Object[0]);
        for (Integer num : dVar.d()) {
            if (this.f11799f.containsKey(num)) {
                this.f11799f.remove(num);
                this.f11804k.q(num.intValue());
                this.f11795b.c(num.intValue(), dVar.a());
            }
        }
    }

    public final void H(h8.v vVar) {
        l8.b.d(!vVar.equals(h8.v.f9777b), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        n0 n0VarC = this.f11804k.c(vVar);
        for (Map.Entry<Integer, v0> entry : n0VarC.d().entrySet()) {
            v0 value = entry.getValue();
            if (!value.e().isEmpty()) {
                int iIntValue = entry.getKey().intValue();
                n4 n4Var = this.f11799f.get(Integer.valueOf(iIntValue));
                if (n4Var != null) {
                    this.f11799f.put(Integer.valueOf(iIntValue), n4Var.k(value.e(), vVar));
                }
            }
        }
        for (Map.Entry<Integer, k1> entry2 : n0VarC.e().entrySet()) {
            int iIntValue2 = entry2.getKey().intValue();
            n4 n4Var2 = this.f11799f.get(Integer.valueOf(iIntValue2));
            if (n4Var2 != null) {
                this.f11799f.put(Integer.valueOf(iIntValue2), n4Var2.k(com.google.protobuf.i.f5753b, n4Var2.f()));
                K(iIntValue2);
                L(new n4(n4Var2.g(), iIntValue2, n4Var2.e(), entry2.getValue()));
            }
        }
        this.f11795b.d(n0VarC);
    }

    public final void I() {
        this.f11801h = false;
        r();
        this.f11800g.i(e8.z0.UNKNOWN);
        this.f11803j.l();
        this.f11802i.l();
        s();
    }

    public Task<Map<String, d9.d0>> J(e8.b1 b1Var, List<com.google.firebase.firestore.a> list) {
        return n() ? this.f11797d.n(b1Var, list) : Tasks.forException(new com.google.firebase.firestore.f("Failed to get result from server.", com.google.firebase.firestore.f.a.UNAVAILABLE));
    }

    public final void K(int i10) {
        this.f11804k.o(i10);
        this.f11802i.B(i10);
    }

    public final void L(n4 n4Var) {
        this.f11804k.o(n4Var.h());
        if (!n4Var.d().isEmpty() || n4Var.f().compareTo(h8.v.f9777b) > 0) {
            n4Var = n4Var.i(Integer.valueOf(b(n4Var.h()).size()));
        }
        this.f11802i.C(n4Var);
    }

    public final boolean M() {
        return (!n() || this.f11802i.n() || this.f11799f.isEmpty()) ? false : true;
    }

    public final boolean N() {
        return (!n() || this.f11803j.n() || this.f11805l.isEmpty()) ? false : true;
    }

    public void O() {
        l8.v.a("RemoteStore", "Shutting down", new Object[0]);
        this.f11798e.shutdown();
        this.f11801h = false;
        r();
        this.f11797d.o();
        this.f11800g.i(e8.z0.UNKNOWN);
    }

    public void P() {
        s();
    }

    public final void Q() {
        l8.b.d(M(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f11804k = new z0(this.f11794a, this);
        this.f11802i.v();
        this.f11800g.e();
    }

    public final void R() {
        l8.b.d(N(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.f11803j.v();
    }

    public void S(int i10) {
        l8.b.d(this.f11799f.remove(Integer.valueOf(i10)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i10));
        if (this.f11802i.m()) {
            K(i10);
        }
        if (this.f11799f.isEmpty()) {
            if (this.f11802i.m()) {
                this.f11802i.q();
            } else if (n()) {
                this.f11800g.i(e8.z0.UNKNOWN);
            }
        }
    }

    @Override // k8.z0.c
    public n4 a(int i10) {
        return this.f11799f.get(Integer.valueOf(i10));
    }

    @Override // k8.z0.c
    public s7.e<h8.k> b(int i10) {
        return this.f11795b.b(i10);
    }

    public final void l(i8.g gVar) {
        l8.b.d(m(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.f11805l.add(gVar);
        if (this.f11803j.m() && this.f11803j.A()) {
            this.f11803j.F(gVar.h());
        }
    }

    public final boolean m() {
        return n() && this.f11805l.size() < 10;
    }

    public boolean n() {
        return this.f11801h;
    }

    public final void o() {
        this.f11804k = null;
    }

    public e8.k1 p() {
        return new e8.k1(this.f11797d);
    }

    public void q() {
        this.f11801h = false;
        r();
        this.f11800g.i(e8.z0.OFFLINE);
    }

    public final void r() {
        this.f11802i.w();
        this.f11803j.w();
        if (!this.f11805l.isEmpty()) {
            l8.v.a("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f11805l.size()));
            this.f11805l.clear();
        }
        o();
    }

    public void s() {
        this.f11801h = true;
        if (n()) {
            this.f11803j.D(this.f11796c.H());
            if (M()) {
                Q();
            } else {
                this.f11800g.i(e8.z0.UNKNOWN);
            }
            t();
        }
    }

    public void t() {
        int iE = this.f11805l.isEmpty() ? -1 : this.f11805l.getLast().e();
        while (m()) {
            i8.g gVarK = this.f11796c.K(iE);
            if (gVarK == null) {
                if (this.f11805l.size() != 0) {
                    break;
                }
                this.f11803j.q();
                break;
            }
            l(gVarK);
            iE = gVarK.e();
        }
        if (N()) {
            R();
        }
    }

    public void u() {
        if (n()) {
            l8.v.a("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            I();
        }
    }

    public final void v(h8.v vVar, y0 y0Var) {
        this.f11800g.i(e8.z0.ONLINE);
        l8.b.d((this.f11802i == null || this.f11804k == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z10 = y0Var instanceof y0.d;
        y0.d dVar = z10 ? (y0.d) y0Var : null;
        if (dVar != null && dVar.b().equals(y0.e.Removed) && dVar.a() != null) {
            G(dVar);
            return;
        }
        if (y0Var instanceof y0.b) {
            this.f11804k.i((y0.b) y0Var);
        } else if (y0Var instanceof y0.c) {
            this.f11804k.j((y0.c) y0Var);
        } else {
            l8.b.d(z10, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.f11804k.k((y0.d) y0Var);
        }
        if (vVar.equals(h8.v.f9777b) || vVar.compareTo(this.f11796c.G()) < 0) {
            return;
        }
        H(vVar);
    }

    public final void w(l1 l1Var) {
        if (l1Var.o()) {
            l8.b.d(!M(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        o();
        if (!M()) {
            this.f11800g.i(e8.z0.UNKNOWN);
        } else {
            this.f11800g.d(l1Var);
            Q();
        }
    }

    public final void x() {
        Iterator<n4> it = this.f11799f.values().iterator();
        while (it.hasNext()) {
            L(it.next());
        }
    }

    public final void y(l1 l1Var) {
        l8.b.d(!l1Var.o(), "Handling write error with status OK.", new Object[0]);
        if (q.j(l1Var)) {
            i8.g gVarPoll = this.f11805l.poll();
            this.f11803j.l();
            this.f11795b.e(gVarPoll.e(), l1Var);
            t();
        }
    }

    public final void z(l1 l1Var) {
        l8.b.d(!l1Var.o(), "Handling write error with status OK.", new Object[0]);
        if (q.i(l1Var)) {
            l8.v.a("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", l8.g0.B(this.f11803j.z()), l1Var);
            b1 b1Var = this.f11803j;
            com.google.protobuf.i iVar = b1.f11651v;
            b1Var.D(iVar);
            this.f11796c.o0(iVar);
        }
    }
}
