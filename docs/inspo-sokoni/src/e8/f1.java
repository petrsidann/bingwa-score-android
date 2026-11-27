package e8;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import g8.n4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f1 implements k8.s0.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7142o = "f1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.k0 f7143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k8.s0 f7144b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7147e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c8.j f7155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f7156n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<b1, d1> f7145c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, List<b1>> f7146d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedHashSet<h8.k> f7148f = new LinkedHashSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<h8.k, Integer> f7149g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, b> f7150h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g8.n1 f7151i = new g8.n1();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<c8.j, Map<Integer, TaskCompletionSource<Void>>> f7152j = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final h1 f7154l = h1.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<Integer, List<TaskCompletionSource<Void>>> f7153k = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7157a;

        static {
            int[] iArr = new int[v0.a.values().length];
            f7157a = iArr;
            try {
                iArr[v0.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7157a[v0.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h8.k f7158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7159b;

        public b(h8.k kVar) {
            this.f7158a = kVar;
        }
    }

    public interface c {
        void a(z0 z0Var);

        void b(b1 b1Var, vb.l1 l1Var);

        void c(List<y1> list);
    }

    public f1(g8.k0 k0Var, k8.s0 s0Var, c8.j jVar, int i10) {
        this.f7143a = k0Var;
        this.f7144b = s0Var;
        this.f7147e = i10;
        this.f7155m = jVar;
    }

    public void A(b1 b1Var) {
        h("stopListeningToRemoteStore");
        d1 d1Var = this.f7145c.get(b1Var);
        l8.b.d(d1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        int iB = d1Var.b();
        List<b1> list = this.f7146d.get(Integer.valueOf(iB));
        list.remove(b1Var);
        if (list.isEmpty()) {
            this.f7144b.S(iB);
        }
    }

    public final void B(v0 v0Var) {
        h8.k kVarA = v0Var.a();
        if (this.f7149g.containsKey(kVarA) || this.f7148f.contains(kVarA)) {
            return;
        }
        l8.v.a(f7142o, "New document in limbo: %s", kVarA);
        this.f7148f.add(kVarA);
        s();
    }

    public <TResult> Task<TResult> C(l8.g gVar, b8.x1 x1Var, l8.t<k1, Task<TResult>> tVar) {
        return new o1(gVar, this.f7144b, x1Var, tVar).i();
    }

    public final void D(List<v0> list, int i10) {
        for (v0 v0Var : list) {
            int i11 = a.f7157a[v0Var.b().ordinal()];
            if (i11 == 1) {
                this.f7151i.a(v0Var.a(), i10);
                B(v0Var);
            } else {
                if (i11 != 2) {
                    throw l8.b.a("Unknown limbo change type: %s", v0Var.b());
                }
                l8.v.a(f7142o, "Document no longer in limbo: %s", v0Var.a());
                h8.k kVarA = v0Var.a();
                this.f7151i.f(kVarA, i10);
                if (!this.f7151i.c(kVarA)) {
                    v(kVarA);
                }
            }
        }
    }

    public void E(List<i8.f> list, TaskCompletionSource<Void> taskCompletionSource) {
        h("writeMutations");
        g8.n nVarT0 = this.f7143a.t0(list);
        g(nVarT0.b(), taskCompletionSource);
        i(nVarT0.c(), null);
        this.f7144b.t();
    }

    @Override // k8.s0.c
    public void a(z0 z0Var) {
        h("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<b1, d1>> it = this.f7145c.entrySet().iterator();
        while (it.hasNext()) {
            x1 x1VarE = it.next().getValue().c().e(z0Var);
            l8.b.d(x1VarE.a().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (x1VarE.b() != null) {
                arrayList.add(x1VarE.b());
            }
        }
        this.f7156n.c(arrayList);
        this.f7156n.a(z0Var);
    }

    @Override // k8.s0.c
    public s7.e<h8.k> b(int i10) {
        b bVar = this.f7150h.get(Integer.valueOf(i10));
        if (bVar != null && bVar.f7159b) {
            return h8.k.k().i(bVar.f7158a);
        }
        s7.e<h8.k> eVarK = h8.k.k();
        if (this.f7146d.containsKey(Integer.valueOf(i10))) {
            for (b1 b1Var : this.f7146d.get(Integer.valueOf(i10))) {
                if (this.f7145c.containsKey(b1Var)) {
                    eVarK = eVarK.l(this.f7145c.get(b1Var).c().k());
                }
            }
        }
        return eVarK;
    }

    @Override // k8.s0.c
    public void c(int i10, vb.l1 l1Var) {
        h("handleRejectedListen");
        b bVar = this.f7150h.get(Integer.valueOf(i10));
        h8.k kVar = bVar != null ? bVar.f7158a : null;
        if (kVar == null) {
            this.f7143a.m0(i10);
            u(i10, l1Var);
            return;
        }
        this.f7149g.remove(kVar);
        this.f7150h.remove(Integer.valueOf(i10));
        s();
        h8.v vVar = h8.v.f9777b;
        d(new k8.n0(vVar, Collections.emptyMap(), Collections.emptyMap(), Collections.singletonMap(kVar, h8.r.t(kVar, vVar)), Collections.singleton(kVar)));
    }

    @Override // k8.s0.c
    public void d(k8.n0 n0Var) {
        h("handleRemoteEvent");
        for (Map.Entry<Integer, k8.v0> entry : n0Var.d().entrySet()) {
            Integer key = entry.getKey();
            k8.v0 value = entry.getValue();
            b bVar = this.f7150h.get(key);
            if (bVar != null) {
                l8.b.d((value.b().size() + value.c().size()) + value.d().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.b().size() > 0) {
                    bVar.f7159b = true;
                } else if (value.c().size() > 0) {
                    l8.b.d(bVar.f7159b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.d().size() > 0) {
                    l8.b.d(bVar.f7159b, "Received remove for limbo target document without add.", new Object[0]);
                    bVar.f7159b = false;
                }
            }
        }
        i(this.f7143a.x(n0Var), n0Var);
    }

    @Override // k8.s0.c
    public void e(int i10, vb.l1 l1Var) {
        h("handleRejectedWrite");
        s7.c<h8.k, h8.h> cVarL0 = this.f7143a.l0(i10);
        if (!cVarL0.isEmpty()) {
            q(l1Var, "Write failed at %s", cVarL0.k().s());
        }
        r(i10, l1Var);
        w(i10);
        i(cVarL0, null);
    }

    @Override // k8.s0.c
    public void f(i8.h hVar) {
        h("handleSuccessfulWrite");
        r(hVar.b().e(), null);
        w(hVar.b().e());
        i(this.f7143a.v(hVar), null);
    }

    public final void g(int i10, TaskCompletionSource<Void> taskCompletionSource) {
        Map<Integer, TaskCompletionSource<Void>> map = this.f7152j.get(this.f7155m);
        if (map == null) {
            map = new HashMap<>();
            this.f7152j.put(this.f7155m, map);
        }
        map.put(Integer.valueOf(i10), taskCompletionSource);
    }

    public final void h(String str) {
        l8.b.d(this.f7156n != null, "Trying to call %s before setting callback", str);
    }

    public final void i(s7.c<h8.k, h8.h> cVar, k8.n0 n0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<b1, d1>> it = this.f7145c.entrySet().iterator();
        while (it.hasNext()) {
            d1 value = it.next().getValue();
            w1 w1VarC = value.c();
            w1.b bVarH = w1VarC.h(cVar);
            boolean z10 = false;
            if (bVarH.b()) {
                bVarH = w1VarC.i(this.f7143a.C(value.a(), false).a(), bVarH);
            }
            k8.v0 v0Var = n0Var == null ? null : n0Var.d().get(Integer.valueOf(value.b()));
            if (n0Var != null && n0Var.e().get(Integer.valueOf(value.b())) != null) {
                z10 = true;
            }
            x1 x1VarD = value.c().d(bVarH, v0Var, z10);
            D(x1VarD.a(), value.b());
            if (x1VarD.b() != null) {
                arrayList.add(x1VarD.b());
                arrayList2.add(g8.l0.a(value.b(), x1VarD.b()));
            }
        }
        this.f7156n.c(arrayList);
        this.f7143a.i0(arrayList2);
    }

    public final boolean j(vb.l1 l1Var) {
        vb.l1.b bVarM = l1Var.m();
        return (bVarM == vb.l1.b.FAILED_PRECONDITION && (l1Var.n() != null ? l1Var.n() : "").contains("requires an index")) || bVarM == vb.l1.b.PERMISSION_DENIED;
    }

    public final void k() {
        Iterator<Map.Entry<Integer, List<TaskCompletionSource<Void>>>> it = this.f7153k.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<TaskCompletionSource<Void>> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                it2.next().setException(new com.google.firebase.firestore.f("'waitForPendingWrites' task is cancelled due to User change.", com.google.firebase.firestore.f.a.CANCELLED));
            }
        }
        this.f7153k.clear();
    }

    public void l(c8.j jVar) {
        boolean z10 = !this.f7155m.equals(jVar);
        this.f7155m = jVar;
        if (z10) {
            k();
            i(this.f7143a.M(jVar), null);
        }
        this.f7144b.u();
    }

    public final y1 m(b1 b1Var, int i10, com.google.protobuf.i iVar) {
        g8.l1 l1VarC = this.f7143a.C(b1Var, true);
        y1.a aVarJ = y1.a.NONE;
        if (this.f7146d.get(Integer.valueOf(i10)) != null) {
            aVarJ = this.f7145c.get(this.f7146d.get(Integer.valueOf(i10)).get(0)).c().j();
        }
        k8.v0 v0VarA = k8.v0.a(aVarJ == y1.a.SYNCED, iVar);
        w1 w1Var = new w1(b1Var, l1VarC.b());
        x1 x1VarC = w1Var.c(w1Var.h(l1VarC.a()), v0VarA);
        D(x1VarC.a(), i10);
        this.f7145c.put(b1Var, new d1(b1Var, i10, w1Var));
        if (!this.f7146d.containsKey(Integer.valueOf(i10))) {
            this.f7146d.put(Integer.valueOf(i10), new ArrayList(1));
        }
        this.f7146d.get(Integer.valueOf(i10)).add(b1Var);
        return x1VarC.b();
    }

    public int n(b1 b1Var, boolean z10) {
        h("listen");
        l8.b.d(!this.f7145c.containsKey(b1Var), "We already listen to query: %s", b1Var);
        n4 n4VarW = this.f7143a.w(b1Var.D());
        this.f7156n.c(Collections.singletonList(m(b1Var, n4VarW.h(), n4VarW.d())));
        if (z10) {
            this.f7144b.F(n4VarW);
        }
        return n4VarW.h();
    }

    public void o(b1 b1Var) {
        h("listenToRemoteStore");
        l8.b.d(this.f7145c.containsKey(b1Var), "This is the first listen to query: %s", b1Var);
        this.f7144b.F(this.f7143a.w(b1Var.D()));
    }

    public void p(d8.f fVar, b8.v0 v0Var) {
        try {
            try {
                d8.e eVarD = fVar.d();
                if (this.f7143a.N(eVarD)) {
                    v0Var.e(b8.w0.b(eVarD));
                    try {
                        fVar.b();
                        return;
                    } catch (IOException e10) {
                        l8.v.e("SyncEngine", "Exception while closing bundle", e10);
                        return;
                    }
                }
                v0Var.f(b8.w0.a(eVarD));
                d8.d dVar = new d8.d(this.f7143a, eVarD);
                long j10 = 0;
                while (true) {
                    d8.c cVarF = fVar.f();
                    if (cVarF == null) {
                        i(dVar.b(), null);
                        this.f7143a.a(eVarD);
                        v0Var.e(b8.w0.b(eVarD));
                        try {
                            fVar.b();
                            return;
                        } catch (IOException e11) {
                            l8.v.e("SyncEngine", "Exception while closing bundle", e11);
                            return;
                        }
                    }
                    long jE = fVar.e();
                    b8.w0 w0VarA = dVar.a(cVarF, jE - j10);
                    if (w0VarA != null) {
                        v0Var.f(w0VarA);
                    }
                    j10 = jE;
                }
            } catch (Exception e12) {
                l8.v.e("Firestore", "Loading bundle failed : %s", e12);
                v0Var.d(new com.google.firebase.firestore.f("Bundle failed to load", com.google.firebase.firestore.f.a.INVALID_ARGUMENT, e12));
                try {
                    fVar.b();
                } catch (IOException e13) {
                    l8.v.e("SyncEngine", "Exception while closing bundle", e13);
                }
            }
        } catch (Throwable th) {
            try {
                fVar.b();
            } catch (IOException e14) {
                l8.v.e("SyncEngine", "Exception while closing bundle", e14);
            }
            throw th;
        }
    }

    public final void q(vb.l1 l1Var, String str, Object... objArr) {
        if (j(l1Var)) {
            l8.v.e("Firestore", "%s: %s", String.format(str, objArr), l1Var);
        }
    }

    public final void r(int i10, vb.l1 l1Var) {
        Integer numValueOf;
        TaskCompletionSource<Void> taskCompletionSource;
        Map<Integer, TaskCompletionSource<Void>> map = this.f7152j.get(this.f7155m);
        if (map == null || (taskCompletionSource = map.get((numValueOf = Integer.valueOf(i10)))) == null) {
            return;
        }
        if (l1Var != null) {
            taskCompletionSource.setException(l8.g0.u(l1Var));
        } else {
            taskCompletionSource.setResult(null);
        }
        map.remove(numValueOf);
    }

    public final void s() {
        while (!this.f7148f.isEmpty() && this.f7149g.size() < this.f7147e) {
            Iterator<h8.k> it = this.f7148f.iterator();
            h8.k next = it.next();
            it.remove();
            int iC = this.f7154l.c();
            this.f7150h.put(Integer.valueOf(iC), new b(next));
            this.f7149g.put(next, Integer.valueOf(iC));
            this.f7144b.F(new n4(b1.b(next.s()).D(), iC, -1L, g8.k1.LIMBO_RESOLUTION));
        }
    }

    public void t(TaskCompletionSource<Void> taskCompletionSource) {
        if (!this.f7144b.n()) {
            l8.v.a(f7142o, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int iD = this.f7143a.D();
        if (iD == -1) {
            taskCompletionSource.setResult(null);
            return;
        }
        if (!this.f7153k.containsKey(Integer.valueOf(iD))) {
            this.f7153k.put(Integer.valueOf(iD), new ArrayList());
        }
        this.f7153k.get(Integer.valueOf(iD)).add(taskCompletionSource);
    }

    public final void u(int i10, vb.l1 l1Var) {
        for (b1 b1Var : this.f7146d.get(Integer.valueOf(i10))) {
            this.f7145c.remove(b1Var);
            if (!l1Var.o()) {
                this.f7156n.b(b1Var, l1Var);
                q(l1Var, "Listen for %s failed", b1Var);
            }
        }
        this.f7146d.remove(Integer.valueOf(i10));
        s7.e<h8.k> eVarD = this.f7151i.d(i10);
        this.f7151i.h(i10);
        for (h8.k kVar : eVarD) {
            if (!this.f7151i.c(kVar)) {
                v(kVar);
            }
        }
    }

    public final void v(h8.k kVar) {
        this.f7148f.remove(kVar);
        Integer num = this.f7149g.get(kVar);
        if (num != null) {
            this.f7144b.S(num.intValue());
            this.f7149g.remove(kVar);
            this.f7150h.remove(num);
            s();
        }
    }

    public final void w(int i10) {
        if (this.f7153k.containsKey(Integer.valueOf(i10))) {
            Iterator<TaskCompletionSource<Void>> it = this.f7153k.get(Integer.valueOf(i10)).iterator();
            while (it.hasNext()) {
                it.next().setResult(null);
            }
            this.f7153k.remove(Integer.valueOf(i10));
        }
    }

    public Task<Map<String, d9.d0>> x(b1 b1Var, List<com.google.firebase.firestore.a> list) {
        return this.f7144b.J(b1Var, list);
    }

    public void y(c cVar) {
        this.f7156n = cVar;
    }

    public void z(b1 b1Var, boolean z10) {
        h("stopListening");
        d1 d1Var = this.f7145c.get(b1Var);
        l8.b.d(d1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        this.f7145c.remove(b1Var);
        int iB = d1Var.b();
        List<b1> list = this.f7146d.get(Integer.valueOf(iB));
        list.remove(b1Var);
        if (list.isEmpty()) {
            this.f7143a.m0(iB);
            if (z10) {
                this.f7144b.S(iB);
            }
            u(iB, vb.l1.f17405e);
        }
    }
}
