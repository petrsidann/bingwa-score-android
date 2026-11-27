package xb;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 extends vb.t0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Logger f18934p = Logger.getLogger(s1.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vb.t0.e f18935g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public d f18937i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public vb.p1.d f18940l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public vb.q f18941m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public vb.q f18942n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f18943o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<SocketAddress, h> f18936h = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f18938j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f18939k = true;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18944a;

        static {
            int[] iArr = new int[vb.q.values().length];
            f18944a = iArr;
            try {
                iArr[vb.q.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18944a[vb.q.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18944a[vb.q.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18944a[vb.q.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18944a[vb.q.SHUTDOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s1.this.f18940l = null;
            if (s1.this.f18937i.b()) {
                s1.this.e();
            }
        }
    }

    public final class c implements vb.t0.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vb.r f18946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f18947b;

        public c() {
            this.f18946a = vb.r.a(vb.q.IDLE);
        }

        public /* synthetic */ c(s1 s1Var, a aVar) {
            this();
        }

        @Override // vb.t0.k
        public void a(vb.r rVar) {
            s1.f18934p.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{rVar, this.f18947b.f18958a});
            this.f18946a = rVar;
            if (s1.this.f18937i.c() && ((h) s1.this.f18936h.get(s1.this.f18937i.a())).f18960c == this) {
                s1.this.w(this.f18947b);
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<vb.y> f18949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f18950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f18951c;

        public d(List<vb.y> list) {
            this.f18949a = list == null ? Collections.emptyList() : list;
        }

        public SocketAddress a() {
            if (c()) {
                return this.f18949a.get(this.f18950b).a().get(this.f18951c);
            }
            throw new IllegalStateException("Index is past the end of the address group list");
        }

        public boolean b() {
            if (!c()) {
                return false;
            }
            vb.y yVar = this.f18949a.get(this.f18950b);
            int i10 = this.f18951c + 1;
            this.f18951c = i10;
            if (i10 < yVar.a().size()) {
                return true;
            }
            int i11 = this.f18950b + 1;
            this.f18950b = i11;
            this.f18951c = 0;
            return i11 < this.f18949a.size();
        }

        public boolean c() {
            return this.f18950b < this.f18949a.size();
        }

        public void d() {
            this.f18950b = 0;
            this.f18951c = 0;
        }

        public boolean e(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f18949a.size(); i10++) {
                int iIndexOf = this.f18949a.get(i10).a().indexOf(socketAddress);
                if (iIndexOf != -1) {
                    this.f18950b = i10;
                    this.f18951c = iIndexOf;
                    return true;
                }
            }
            return false;
        }

        public int f() {
            List<vb.y> list = this.f18949a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void g(k6.q<vb.y> qVar) {
            List<vb.y> listEmptyList = qVar;
            if (qVar == null) {
                listEmptyList = Collections.emptyList();
            }
            this.f18949a = listEmptyList;
            d();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Boolean f18952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f18953b;
    }

    public static final class f extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.f f18954a;

        public f(vb.t0.f fVar) {
            this.f18954a = (vb.t0.f) j6.m.p(fVar, "result");
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            return this.f18954a;
        }

        public String toString() {
            return j6.g.a(f.class).d("result", this.f18954a).toString();
        }
    }

    public final class g extends vb.t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s1 f18955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f18956b = new AtomicBoolean(false);

        public g(s1 s1Var) {
            this.f18955a = (s1) j6.m.p(s1Var, "pickFirstLeafLoadBalancer");
        }

        @Override // vb.t0.j
        public vb.t0.f a(vb.t0.g gVar) {
            if (this.f18956b.compareAndSet(false, true)) {
                vb.p1 p1VarD = s1.this.f18935g.d();
                final s1 s1Var = this.f18955a;
                Objects.requireNonNull(s1Var);
                p1VarD.execute(new Runnable() { // from class: xb.t1
                    @Override // java.lang.Runnable
                    public final void run() {
                        s1Var.e();
                    }
                });
            }
            return vb.t0.f.g();
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vb.t0.i f18958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vb.q f18959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f18960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18961d = false;

        public h(vb.t0.i iVar, vb.q qVar, c cVar) {
            this.f18958a = iVar;
            this.f18959b = qVar;
            this.f18960c = cVar;
        }

        public final vb.q f() {
            return this.f18960c.f18946a.c();
        }

        public vb.q g() {
            return this.f18959b;
        }

        public vb.t0.i h() {
            return this.f18958a;
        }

        public boolean i() {
            return this.f18961d;
        }

        public final void j(vb.q qVar) {
            boolean z10;
            this.f18959b = qVar;
            if (qVar == vb.q.READY || qVar == vb.q.TRANSIENT_FAILURE) {
                z10 = true;
            } else if (qVar != vb.q.IDLE) {
                return;
            } else {
                z10 = false;
            }
            this.f18961d = z10;
        }
    }

    public s1(vb.t0.e eVar) {
        vb.q qVar = vb.q.IDLE;
        this.f18941m = qVar;
        this.f18942n = qVar;
        this.f18943o = r0.g("GRPC_EXPERIMENTAL_XDS_DUALSTACK_ENDPOINTS", false);
        this.f18935g = (vb.t0.e) j6.m.p(eVar, "helper");
    }

    @Override // vb.t0
    public vb.l1 a(vb.t0.h hVar) {
        vb.q qVar;
        e eVar;
        Boolean bool;
        if (this.f18941m == vb.q.SHUTDOWN) {
            return vb.l1.f17415o.q("Already shut down");
        }
        List<vb.y> listA = hVar.a();
        if (listA.isEmpty()) {
            vb.l1 l1VarQ = vb.l1.f17420t.q("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(l1VarQ);
            return l1VarQ;
        }
        Iterator<vb.y> it = listA.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                vb.l1 l1VarQ2 = vb.l1.f17420t.q("NameResolver returned address list with null endpoint. addrs=" + hVar.a() + ", attrs=" + hVar.b());
                c(l1VarQ2);
                return l1VarQ2;
            }
        }
        this.f18939k = true;
        if ((hVar.c() instanceof e) && (bool = (eVar = (e) hVar.c()).f18952a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listA);
            Collections.shuffle(arrayList, eVar.f18953b != null ? new Random(eVar.f18953b.longValue()) : new Random());
            listA = arrayList;
        }
        k6.q<vb.y> qVarK = k6.q.r().j(listA).k();
        d dVar = this.f18937i;
        if (dVar == null) {
            this.f18937i = new d(qVarK);
        } else if (this.f18941m == vb.q.READY) {
            SocketAddress socketAddressA = dVar.a();
            this.f18937i.g(qVarK);
            if (this.f18937i.e(socketAddressA)) {
                return vb.l1.f17405e;
            }
            this.f18937i.d();
        } else {
            dVar.g(qVarK);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.f18936h.keySet());
        HashSet hashSet2 = new HashSet();
        k6.t0<vb.y> it2 = qVarK.iterator();
        while (it2.hasNext()) {
            hashSet2.addAll(it2.next().a());
        }
        for (SocketAddress socketAddress : hashSet) {
            if (!hashSet2.contains(socketAddress)) {
                this.f18936h.remove(socketAddress).h().g();
            }
        }
        if (hashSet.size() != 0 && (qVar = this.f18941m) != vb.q.CONNECTING && qVar != vb.q.READY) {
            vb.q qVar2 = vb.q.IDLE;
            if (qVar == qVar2) {
                v(qVar2, new g(this));
            } else if (qVar == vb.q.TRANSIENT_FAILURE) {
            }
            return vb.l1.f17405e;
        }
        vb.q qVar3 = vb.q.CONNECTING;
        this.f18941m = qVar3;
        v(qVar3, new f(vb.t0.f.g()));
        n();
        e();
        return vb.l1.f17405e;
    }

    @Override // vb.t0
    public void c(vb.l1 l1Var) {
        Iterator<h> it = this.f18936h.values().iterator();
        while (it.hasNext()) {
            it.next().h().g();
        }
        this.f18936h.clear();
        v(vb.q.TRANSIENT_FAILURE, new f(vb.t0.f.f(l1Var)));
    }

    @Override // vb.t0
    public void e() {
        d dVar = this.f18937i;
        if (dVar == null || !dVar.c() || this.f18941m == vb.q.SHUTDOWN) {
            return;
        }
        SocketAddress socketAddressA = this.f18937i.a();
        vb.t0.i iVarH = this.f18936h.containsKey(socketAddressA) ? this.f18936h.get(socketAddressA).h() : o(socketAddressA);
        int i10 = a.f18944a[this.f18936h.get(socketAddressA).g().ordinal()];
        if (i10 == 1) {
            iVarH.f();
            this.f18936h.get(socketAddressA).j(vb.q.CONNECTING);
        } else {
            if (i10 != 2) {
                if (i10 == 3) {
                    f18934p.warning("Requesting a connection even though we have a READY subchannel");
                    return;
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    this.f18937i.b();
                    e();
                    return;
                }
            }
            if (!this.f18943o) {
                iVarH.f();
                return;
            }
        }
        t();
    }

    @Override // vb.t0
    public void f() {
        f18934p.log(Level.FINE, "Shutting down, currently have {} subchannels created", Integer.valueOf(this.f18936h.size()));
        vb.q qVar = vb.q.SHUTDOWN;
        this.f18941m = qVar;
        this.f18942n = qVar;
        n();
        Iterator<h> it = this.f18936h.values().iterator();
        while (it.hasNext()) {
            it.next().h().g();
        }
        this.f18936h.clear();
    }

    public final void n() {
        vb.p1.d dVar = this.f18940l;
        if (dVar != null) {
            dVar.a();
            this.f18940l = null;
        }
    }

    public final vb.t0.i o(SocketAddress socketAddress) {
        c cVar = new c(this, null);
        final vb.t0.i iVarA = this.f18935g.a(vb.t0.b.d().e(k6.z.i(new vb.y(socketAddress))).b(vb.t0.f17505c, cVar).c());
        if (iVarA == null) {
            f18934p.warning("Was not able to create subchannel for " + socketAddress);
            throw new IllegalStateException("Can't create subchannel");
        }
        h hVar = new h(iVarA, vb.q.IDLE, cVar);
        cVar.f18947b = hVar;
        this.f18936h.put(socketAddress, hVar);
        if (iVarA.c().b(vb.t0.f17506d) == null) {
            cVar.f18946a = vb.r.a(vb.q.READY);
        }
        iVarA.h(new vb.t0.k() { // from class: xb.r1
            @Override // vb.t0.k
            public final void a(vb.r rVar) {
                this.f18898a.r(iVarA, rVar);
            }
        });
        return iVarA;
    }

    public final SocketAddress p(vb.t0.i iVar) {
        return iVar.a().a().get(0);
    }

    public final boolean q() {
        d dVar = this.f18937i;
        if (dVar == null || dVar.c() || this.f18936h.size() < this.f18937i.f()) {
            return false;
        }
        Iterator<h> it = this.f18936h.values().iterator();
        while (it.hasNext()) {
            if (!it.next().i()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void r(vb.t0.i iVar, vb.r rVar) {
        vb.q qVarC = rVar.c();
        h hVar = this.f18936h.get(p(iVar));
        if (hVar == null || hVar.h() != iVar || qVarC == vb.q.SHUTDOWN) {
            return;
        }
        vb.q qVar = vb.q.IDLE;
        if (qVarC == qVar) {
            this.f18935g.e();
        }
        hVar.j(qVarC);
        vb.q qVar2 = this.f18941m;
        vb.q qVar3 = vb.q.TRANSIENT_FAILURE;
        if (qVar2 == qVar3 || this.f18942n == qVar3) {
            if (qVarC == vb.q.CONNECTING) {
                return;
            }
            if (qVarC == qVar) {
                e();
                return;
            }
        }
        int i10 = a.f18944a[qVarC.ordinal()];
        if (i10 == 1) {
            this.f18937i.d();
            this.f18941m = qVar;
            v(qVar, new g(this));
            return;
        }
        if (i10 == 2) {
            vb.q qVar4 = vb.q.CONNECTING;
            this.f18941m = qVar4;
            v(qVar4, new f(vb.t0.f.g()));
            return;
        }
        if (i10 == 3) {
            u(hVar);
            this.f18937i.e(p(iVar));
            this.f18941m = vb.q.READY;
            w(hVar);
            return;
        }
        if (i10 != 4) {
            throw new IllegalArgumentException("Unsupported state:" + qVarC);
        }
        if (this.f18937i.c() && this.f18936h.get(this.f18937i.a()).h() == iVar && this.f18937i.b()) {
            n();
            e();
        }
        if (q()) {
            this.f18941m = qVar3;
            v(qVar3, new f(vb.t0.f.f(rVar.d())));
            int i11 = this.f18938j + 1;
            this.f18938j = i11;
            if (i11 >= this.f18937i.f() || this.f18939k) {
                this.f18939k = false;
                this.f18938j = 0;
                this.f18935g.e();
            }
        }
    }

    public final void t() {
        if (this.f18943o) {
            vb.p1.d dVar = this.f18940l;
            if (dVar == null || !dVar.b()) {
                this.f18940l = this.f18935g.d().c(new b(), 250L, TimeUnit.MILLISECONDS, this.f18935g.c());
            }
        }
    }

    public final void u(h hVar) {
        n();
        for (h hVar2 : this.f18936h.values()) {
            if (!hVar2.h().equals(hVar.f18958a)) {
                hVar2.h().g();
            }
        }
        this.f18936h.clear();
        hVar.j(vb.q.READY);
        this.f18936h.put(p(hVar.f18958a), hVar);
    }

    public final void v(vb.q qVar, vb.t0.j jVar) {
        if (qVar == this.f18942n && (qVar == vb.q.IDLE || qVar == vb.q.CONNECTING)) {
            return;
        }
        this.f18942n = qVar;
        this.f18935g.f(qVar, jVar);
    }

    public final void w(h hVar) {
        vb.t0.j fVar;
        vb.q qVar = hVar.f18959b;
        vb.q qVar2 = vb.q.READY;
        if (qVar != qVar2) {
            return;
        }
        if (hVar.f() == qVar2) {
            fVar = new vb.t0.d(vb.t0.f.h(hVar.f18958a));
        } else {
            vb.q qVarF = hVar.f();
            qVar2 = vb.q.TRANSIENT_FAILURE;
            if (qVarF != qVar2) {
                if (this.f18942n != qVar2) {
                    v(hVar.f(), new f(vb.t0.f.g()));
                    return;
                }
                return;
            }
            fVar = new f(vb.t0.f.f(hVar.f18960c.f18946a.d()));
        }
        v(qVar2, fVar);
    }
}
