package xb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class u1 extends vb.t0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vb.t0.e f18978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vb.t0.i f18979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public vb.q f18980i = vb.q.IDLE;

    public class a implements vb.t0.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vb.t0.i f18981a;

        public a(vb.t0.i iVar) {
            this.f18981a = iVar;
        }

        @Override // vb.t0.k
        public void a(vb.r rVar) {
            u1.this.i(this.f18981a, rVar);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18983a;

        static {
            int[] iArr = new int[vb.q.values().length];
            f18983a = iArr;
            try {
                iArr[vb.q.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18983a[vb.q.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18983a[vb.q.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18983a[vb.q.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f18984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f18985b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l10) {
            this.f18984a = bool;
            this.f18985b = l10;
        }
    }

    public static final class d extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.f f18986a;

        public d(vb.t0.f fVar) {
            this.f18986a = (vb.t0.f) j6.m.p(fVar, "result");
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            return this.f18986a;
        }

        public String toString() {
            return j6.g.a(d.class).d("result", this.f18986a).toString();
        }
    }

    public final class e extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.i f18987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f18988b = new AtomicBoolean(false);

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f18987a.f();
            }
        }

        public e(vb.t0.i iVar) {
            this.f18987a = (vb.t0.i) j6.m.p(iVar, "subchannel");
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            if (this.f18988b.compareAndSet(false, true)) {
                u1.this.f18978g.d().execute(new a());
            }
            return vb.t0.f.g();
        }
    }

    public u1(vb.t0.e eVar) {
        this.f18978g = (vb.t0.e) j6.m.p(eVar, "helper");
    }

    @Override // vb.t0
    public vb.l1 a(vb.t0.h hVar) {
        c cVar;
        Boolean bool;
        List<vb.y> listA = hVar.a();
        if (listA.isEmpty()) {
            vb.l1 l1VarQ = vb.l1.f17420t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(l1VarQ);
            return l1VarQ;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f18984a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, cVar.f18985b != null ? new Random(cVar.f18985b.longValue()) : new Random());
            listA = arrayList;
        }
        vb.t0.i iVar = this.f18979h;
        if (iVar == null) {
            vb.t0.i iVarA = this.f18978g.a(vb.t0.b.d().e(listA).c());
            iVarA.h(new a(iVarA));
            this.f18979h = iVarA;
            j(vb.q.CONNECTING, new d(vb.t0.f.h(iVarA)));
            iVarA.f();
        } else {
            iVar.i(listA);
        }
        return vb.l1.f17405e;
    }

    @Override // vb.t0
    public void c(vb.l1 l1Var) {
        vb.t0.i iVar = this.f18979h;
        if (iVar != null) {
            iVar.g();
            this.f18979h = null;
        }
        j(vb.q.TRANSIENT_FAILURE, new d(vb.t0.f.f(l1Var)));
    }

    @Override // vb.t0
    public void e() {
        vb.t0.i iVar = this.f18979h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // vb.t0
    public void f() {
        vb.t0.i iVar = this.f18979h;
        if (iVar != null) {
            iVar.g();
        }
    }

    public final void i(vb.t0.i iVar, vb.r rVar) {
        vb.t0.j eVar;
        vb.t0.j dVar;
        vb.q qVarC = rVar.c();
        if (qVarC == vb.q.SHUTDOWN) {
            return;
        }
        vb.q qVar = vb.q.TRANSIENT_FAILURE;
        if (qVarC == qVar || qVarC == vb.q.IDLE) {
            this.f18978g.e();
        }
        if (this.f18980i == qVar) {
            if (qVarC == vb.q.CONNECTING) {
                return;
            }
            if (qVarC == vb.q.IDLE) {
                e();
                return;
            }
        }
        int i10 = b.f18983a[qVarC.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                dVar = new d(vb.t0.f.g());
            } else if (i10 == 3) {
                eVar = new d(vb.t0.f.h(iVar));
            } else {
                if (i10 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + qVarC);
                }
                dVar = new d(vb.t0.f.f(rVar.d()));
            }
            j(qVarC, dVar);
        }
        eVar = new e(iVar);
        dVar = eVar;
        j(qVarC, dVar);
    }

    public final void j(vb.q qVar, vb.t0.j jVar) {
        this.f18980i = qVar;
        this.f18978g.f(qVar, jVar);
    }
}
