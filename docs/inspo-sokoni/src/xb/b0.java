package xb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements k1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.p1 f18155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f18156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f18157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Runnable f18158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k1.a f18159h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public vb.l1 f18161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vb.t0.j f18162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f18163l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vb.l0 f18152a = vb.l0.a(b0.class, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18153b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Collection<e> f18160i = new LinkedHashSet();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f18164a;

        public a(k1.a aVar) {
            this.f18164a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18164a.e(true);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f18166a;

        public b(k1.a aVar) {
            this.f18166a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18166a.e(false);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.a f18168a;

        public c(k1.a aVar) {
            this.f18168a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18168a.c();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.l1 f18170a;

        public d(vb.l1 l1Var) {
            this.f18170a = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f18159h.b(this.f18170a);
        }
    }

    public class e extends c0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final vb.t0.g f18172j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final vb.s f18173k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final vb.k[] f18174l;

        public e(vb.t0.g gVar, vb.k[] kVarArr) {
            this.f18173k = vb.s.e();
            this.f18172j = gVar;
            this.f18174l = kVarArr;
        }

        public /* synthetic */ e(b0 b0Var, vb.t0.g gVar, vb.k[] kVarArr, a aVar) {
            this(gVar, kVarArr);
        }

        public final Runnable A(t tVar) {
            vb.s sVarB = this.f18173k.b();
            try {
                return w(tVar.h(this.f18172j.c(), this.f18172j.b(), this.f18172j.a(), this.f18174l));
            } finally {
                this.f18173k.f(sVarB);
            }
        }

        @Override // xb.c0, xb.r
        public void a(vb.l1 l1Var) {
            super.a(l1Var);
            synchronized (b0.this.f18153b) {
                if (b0.this.f18158g != null) {
                    boolean zRemove = b0.this.f18160i.remove(this);
                    if (!b0.this.q() && zRemove) {
                        b0.this.f18155d.b(b0.this.f18157f);
                        if (b0.this.f18161j != null) {
                            b0.this.f18155d.b(b0.this.f18158g);
                            b0.this.f18158g = null;
                        }
                    }
                }
            }
            b0.this.f18155d.a();
        }

        @Override // xb.c0, xb.r
        public void n(x0 x0Var) {
            if (this.f18172j.a().j()) {
                x0Var.a("wait_for_ready");
            }
            super.n(x0Var);
        }

        @Override // xb.c0
        public void u(vb.l1 l1Var) {
            for (vb.k kVar : this.f18174l) {
                kVar.i(l1Var);
            }
        }
    }

    public b0(Executor executor, vb.p1 p1Var) {
        this.f18154c = executor;
        this.f18155d = p1Var;
    }

    @Override // xb.k1
    public final Runnable a(k1.a aVar) {
        this.f18159h = aVar;
        this.f18156e = new a(aVar);
        this.f18157f = new b(aVar);
        this.f18158g = new c(aVar);
        return null;
    }

    @Override // xb.k1
    public final void c(vb.l1 l1Var) {
        Runnable runnable;
        synchronized (this.f18153b) {
            if (this.f18161j != null) {
                return;
            }
            this.f18161j = l1Var;
            this.f18155d.b(new d(l1Var));
            if (!q() && (runnable = this.f18158g) != null) {
                this.f18155d.b(runnable);
                this.f18158g = null;
            }
            this.f18155d.a();
        }
    }

    @Override // xb.k1
    public final void d(vb.l1 l1Var) {
        Collection<e> collection;
        Runnable runnable;
        c(l1Var);
        synchronized (this.f18153b) {
            collection = this.f18160i;
            runnable = this.f18158g;
            this.f18158g = null;
            if (!collection.isEmpty()) {
                this.f18160i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable runnableW = eVar.w(new g0(l1Var, s.a.REFUSED, eVar.f18174l));
                if (runnableW != null) {
                    runnableW.run();
                }
            }
            this.f18155d.execute(runnable);
        }
    }

    @Override // vb.r0
    public vb.l0 g() {
        return this.f18152a;
    }

    @Override // xb.t
    public final r h(vb.b1<?, ?> b1Var, vb.a1 a1Var, vb.c cVar, vb.k[] kVarArr) {
        r g0Var;
        try {
            w1 w1Var = new w1(b1Var, a1Var, cVar);
            vb.t0.j jVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f18153b) {
                    if (this.f18161j == null) {
                        vb.t0.j jVar2 = this.f18162k;
                        if (jVar2 != null) {
                            if (jVar != null && j10 == this.f18163l) {
                                g0Var = o(w1Var, kVarArr);
                                break;
                            }
                            j10 = this.f18163l;
                            t tVarK = r0.k(jVar2.a(w1Var), cVar.j());
                            if (tVarK != null) {
                                g0Var = tVarK.h(w1Var.c(), w1Var.b(), w1Var.a(), kVarArr);
                            } else {
                                jVar = jVar2;
                            }
                        } else {
                            g0Var = o(w1Var, kVarArr);
                            break;
                        }
                    } else {
                        g0Var = new g0(this.f18161j, kVarArr);
                        break;
                    }
                }
                this.f18155d.a();
                return g0Var;
            }
            this.f18155d.a();
            return g0Var;
        } catch (Throwable th) {
            this.f18155d.a();
            throw th;
        }
    }

    public final e o(vb.t0.g gVar, vb.k[] kVarArr) {
        e eVar = new e(this, gVar, kVarArr, null);
        this.f18160i.add(eVar);
        if (p() == 1) {
            this.f18155d.b(this.f18156e);
        }
        for (vb.k kVar : kVarArr) {
            kVar.j();
        }
        return eVar;
    }

    public final int p() {
        int size;
        synchronized (this.f18153b) {
            size = this.f18160i.size();
        }
        return size;
    }

    public final boolean q() {
        boolean z10;
        synchronized (this.f18153b) {
            z10 = !this.f18160i.isEmpty();
        }
        return z10;
    }

    public final void r(vb.t0.j jVar) {
        Runnable runnable;
        synchronized (this.f18153b) {
            this.f18162k = jVar;
            this.f18163l++;
            if (jVar != null && q()) {
                ArrayList<e> arrayList = new ArrayList(this.f18160i);
                ArrayList arrayList2 = new ArrayList();
                for (e eVar : arrayList) {
                    vb.t0.f fVarA = jVar.a(eVar.f18172j);
                    vb.c cVarA = eVar.f18172j.a();
                    t tVarK = r0.k(fVarA, cVarA.j());
                    if (tVarK != null) {
                        Executor executorE = this.f18154c;
                        if (cVarA.e() != null) {
                            executorE = cVarA.e();
                        }
                        Runnable runnableA = eVar.A(tVarK);
                        if (runnableA != null) {
                            executorE.execute(runnableA);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f18153b) {
                    if (q()) {
                        this.f18160i.removeAll(arrayList2);
                        if (this.f18160i.isEmpty()) {
                            this.f18160i = new LinkedHashSet();
                        }
                        if (!q()) {
                            this.f18155d.b(this.f18157f);
                            if (this.f18161j != null && (runnable = this.f18158g) != null) {
                                this.f18155d.b(runnable);
                                this.f18158g = null;
                            }
                        }
                        this.f18155d.a();
                    }
                }
            }
        }
    }
}
