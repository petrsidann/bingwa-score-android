package ec;

import j6.m;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import vb.a1;
import vb.l1;
import vb.p1;
import vb.q;
import vb.r;
import vb.t0;
import vb.y;
import xb.k2;
import xb.r2;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends t0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final vb.a.c<b> f7822p = vb.a.c.a("addressTrackerKey");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f7823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p1 f7824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final t0.e f7825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ec.e f7826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public r2 f7827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ScheduledExecutorService f7828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p1.d f7829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Long f7830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final vb.f f7831o;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f7832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a f7833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f7834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f7835d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7836e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<i> f7837f = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public AtomicLong f7838a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public AtomicLong f7839b;

            public a() {
                this.f7838a = new AtomicLong();
                this.f7839b = new AtomicLong();
            }

            public void a() {
                this.f7838a.set(0L);
                this.f7839b.set(0L);
            }
        }

        public b(g gVar) {
            this.f7833b = new a();
            this.f7834c = new a();
            this.f7832a = gVar;
        }

        public boolean b(i iVar) {
            if (m() && !iVar.o()) {
                iVar.n();
            } else if (!m() && iVar.o()) {
                iVar.q();
            }
            iVar.p(this);
            return this.f7837f.add(iVar);
        }

        public void c() {
            int i10 = this.f7836e;
            this.f7836e = i10 == 0 ? 0 : i10 - 1;
        }

        public void d(long j10) {
            this.f7835d = Long.valueOf(j10);
            this.f7836e++;
            Iterator<i> it = this.f7837f.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }

        public double e() {
            return this.f7834c.f7839b.get() / f();
        }

        public long f() {
            return this.f7834c.f7838a.get() + this.f7834c.f7839b.get();
        }

        public void g(boolean z10) {
            g gVar = this.f7832a;
            if (gVar.f7852e == null && gVar.f7853f == null) {
                return;
            }
            (z10 ? this.f7833b.f7838a : this.f7833b.f7839b).getAndIncrement();
        }

        public boolean h(long j10) {
            return j10 > this.f7835d.longValue() + Math.min(this.f7832a.f7849b.longValue() * ((long) this.f7836e), Math.max(this.f7832a.f7849b.longValue(), this.f7832a.f7850c.longValue()));
        }

        public boolean i(i iVar) {
            iVar.m();
            return this.f7837f.remove(iVar);
        }

        public void j() {
            this.f7833b.a();
            this.f7834c.a();
        }

        public void k() {
            this.f7836e = 0;
        }

        public void l(g gVar) {
            this.f7832a = gVar;
        }

        public boolean m() {
            return this.f7835d != null;
        }

        public double n() {
            return this.f7834c.f7838a.get() / f();
        }

        public void o() {
            this.f7834c.a();
            a aVar = this.f7833b;
            this.f7833b = this.f7834c;
            this.f7834c = aVar;
        }

        public void p() {
            m.v(this.f7835d != null, "not currently ejected");
            this.f7835d = null;
            Iterator<i> it = this.f7837f.iterator();
            while (it.hasNext()) {
                it.next().q();
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.f7837f + '}';
        }
    }

    public static class c extends k6.m<SocketAddress, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<SocketAddress, b> f7840a = new HashMap();

        @Override // k6.n
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<SocketAddress, b> a() {
            return this.f7840a;
        }

        public void c() {
            for (b bVar : this.f7840a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double d() {
            if (this.f7840a.isEmpty()) {
                return 0.0d;
            }
            Iterator<b> it = this.f7840a.values().iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                i11++;
                if (it.next().m()) {
                    i10++;
                }
            }
            return (((double) i10) / ((double) i11)) * 100.0d;
        }

        public void e(Long l10) {
            for (b bVar : this.f7840a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l10.longValue())) {
                    bVar.p();
                }
            }
        }

        public void f(g gVar, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.f7840a.containsKey(socketAddress)) {
                    this.f7840a.put(socketAddress, new b(gVar));
                }
            }
        }

        public void g() {
            Iterator<b> it = this.f7840a.values().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }

        public void h() {
            Iterator<b> it = this.f7840a.values().iterator();
            while (it.hasNext()) {
                it.next().o();
            }
        }

        public void i(g gVar) {
            Iterator<b> it = this.f7840a.values().iterator();
            while (it.hasNext()) {
                it.next().l(gVar);
            }
        }
    }

    public class d extends ec.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t0.e f7841a;

        public d(t0.e eVar) {
            this.f7841a = new ec.f(eVar);
        }

        @Override // ec.c, vb.t0.e
        public t0.i a(t0.b bVar) {
            i iVar = h.this.new i(bVar, this.f7841a);
            List<y> listA = bVar.a();
            if (h.m(listA) && h.this.f7823g.containsKey(listA.get(0).a().get(0))) {
                b bVar2 = h.this.f7823g.get(listA.get(0).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f7835d != null) {
                    iVar.n();
                }
            }
            return iVar;
        }

        @Override // ec.c, vb.t0.e
        public void f(q qVar, t0.j jVar) {
            this.f7841a.f(qVar, h.this.new C0131h(jVar));
        }

        @Override // ec.c
        public t0.e g() {
            return this.f7841a;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f7843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vb.f f7844b;

        public e(g gVar, vb.f fVar) {
            this.f7843a = gVar;
            this.f7844b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f7830n = Long.valueOf(hVar.f7827k.a());
            h.this.f7823g.h();
            for (j jVar : j.b(this.f7843a, this.f7844b)) {
                h hVar2 = h.this;
                jVar.a(hVar2.f7823g, hVar2.f7830n.longValue());
            }
            h hVar3 = h.this;
            hVar3.f7823g.e(hVar3.f7830n);
        }
    }

    public static class f implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.f f7847b;

        public f(g gVar, vb.f fVar) {
            this.f7846a = gVar;
            this.f7847b = fVar;
        }

        @Override // ec.h.j
        public void a(c cVar, long j10) {
            List<b> listN = h.n(cVar, this.f7846a.f7853f.f7865d.intValue());
            if (listN.size() < this.f7846a.f7853f.f7864c.intValue() || listN.size() == 0) {
                return;
            }
            for (b bVar : listN) {
                if (cVar.d() >= this.f7846a.f7851d.intValue()) {
                    return;
                }
                if (bVar.f() >= this.f7846a.f7853f.f7865d.intValue() && bVar.e() > ((double) this.f7846a.f7853f.f7862a.intValue()) / 100.0d) {
                    this.f7847b.b(vb.f.a.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", bVar, Double.valueOf(bVar.e()));
                    if (new Random().nextInt(100) < this.f7846a.f7853f.f7863b.intValue()) {
                        bVar.d(j10);
                    }
                }
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f7848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f7849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f7850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f7851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f7852e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b f7853f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final k2.b f7854g;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Long f7855a = 10000000000L;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Long f7856b = 30000000000L;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Long f7857c = 300000000000L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Integer f7858d = 10;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f7859e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public b f7860f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public k2.b f7861g;

            public g a() {
                m.u(this.f7861g != null);
                return new g(this.f7855a, this.f7856b, this.f7857c, this.f7858d, this.f7859e, this.f7860f, this.f7861g);
            }

            public a b(Long l10) {
                m.d(l10 != null);
                this.f7856b = l10;
                return this;
            }

            public a c(k2.b bVar) {
                m.u(bVar != null);
                this.f7861g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f7860f = bVar;
                return this;
            }

            public a e(Long l10) {
                m.d(l10 != null);
                this.f7855a = l10;
                return this;
            }

            public a f(Integer num) {
                m.d(num != null);
                this.f7858d = num;
                return this;
            }

            public a g(Long l10) {
                m.d(l10 != null);
                this.f7857c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f7859e = cVar;
                return this;
            }
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f7862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f7863b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f7864c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f7865d;

            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f7866a = 85;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f7867b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f7868c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f7869d = 50;

                public b a() {
                    return new b(this.f7866a, this.f7867b, this.f7868c, this.f7869d);
                }

                public a b(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f7867b = num;
                    return this;
                }

                public a c(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f7868c = num;
                    return this;
                }

                public a d(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f7869d = num;
                    return this;
                }

                public a e(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f7866a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f7862a = num;
                this.f7863b = num2;
                this.f7864c = num3;
                this.f7865d = num4;
            }
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Integer f7870a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Integer f7871b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Integer f7872c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Integer f7873d;

            public static final class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Integer f7874a = 1900;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public Integer f7875b = 100;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public Integer f7876c = 5;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public Integer f7877d = 100;

                public c a() {
                    return new c(this.f7874a, this.f7875b, this.f7876c, this.f7877d);
                }

                public a b(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0 && num.intValue() <= 100);
                    this.f7875b = num;
                    return this;
                }

                public a c(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f7876c = num;
                    return this;
                }

                public a d(Integer num) {
                    m.d(num != null);
                    m.d(num.intValue() >= 0);
                    this.f7877d = num;
                    return this;
                }

                public a e(Integer num) {
                    m.d(num != null);
                    this.f7874a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f7870a = num;
                this.f7871b = num2;
                this.f7872c = num3;
                this.f7873d = num4;
            }
        }

        public g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, k2.b bVar2) {
            this.f7848a = l10;
            this.f7849b = l11;
            this.f7850c = l12;
            this.f7851d = num;
            this.f7852e = cVar;
            this.f7853f = bVar;
            this.f7854g = bVar2;
        }

        public boolean a() {
            return (this.f7852e == null && this.f7853f == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: ec.h$h, reason: collision with other inner class name */
    public class C0131h extends t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0.j f7878a;

        /* JADX INFO: renamed from: ec.h$h$a */
        public class a extends vb.k.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f7880a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final vb.k.a f7881b;

            /* JADX INFO: renamed from: ec.h$h$a$a, reason: collision with other inner class name */
            public class C0132a extends ec.a {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ vb.k f7883b;

                public C0132a(vb.k kVar) {
                    this.f7883b = kVar;
                }

                @Override // vb.o1
                public void i(l1 l1Var) {
                    a.this.f7880a.g(l1Var.o());
                    o().i(l1Var);
                }

                @Override // ec.a
                public vb.k o() {
                    return this.f7883b;
                }
            }

            /* JADX INFO: renamed from: ec.h$h$a$b */
            public class b extends vb.k {
                public b() {
                }

                @Override // vb.o1
                public void i(l1 l1Var) {
                    a.this.f7880a.g(l1Var.o());
                }
            }

            public a(b bVar, vb.k.a aVar) {
                this.f7880a = bVar;
                this.f7881b = aVar;
            }

            @Override // vb.k.a
            public vb.k a(vb.k.b bVar, a1 a1Var) {
                vb.k.a aVar = this.f7881b;
                return aVar != null ? new C0132a(aVar.a(bVar, a1Var)) : new b();
            }
        }

        public C0131h(t0.j jVar) {
            this.f7878a = jVar;
        }

        @Override // vb.t0.j
        public t0.f a(t0.g gVar) {
            t0.f fVarA = this.f7878a.a(gVar);
            t0.i iVarC = fVarA.c();
            return iVarC != null ? t0.f.i(iVarC, new a((b) iVarC.c().b(h.f7822p), fVarA.b())) : fVarA;
        }
    }

    public class i extends ec.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0.i f7886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f7887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7888c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public r f7889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t0.k f7890e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final vb.f f7891f;

        public class a implements t0.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final t0.k f7893a;

            public a(t0.k kVar) {
                this.f7893a = kVar;
            }

            @Override // vb.t0.k
            public void a(r rVar) {
                i.this.f7889d = rVar;
                if (i.this.f7888c) {
                    return;
                }
                this.f7893a.a(rVar);
            }
        }

        public i(t0.b bVar, t0.e eVar) {
            t0.i iVarA;
            t0.b.C0305b<t0.k> c0305b = t0.f17505c;
            t0.k kVar = (t0.k) bVar.c(c0305b);
            if (kVar != null) {
                this.f7890e = kVar;
                iVarA = eVar.a(bVar.e().b(c0305b, new a(kVar)).c());
            } else {
                iVarA = eVar.a(bVar);
            }
            this.f7886a = iVarA;
            this.f7891f = this.f7886a.d();
        }

        @Override // ec.d, vb.t0.i
        public vb.a c() {
            return this.f7887b != null ? this.f7886a.c().d().d(h.f7822p, this.f7887b).a() : this.f7886a.c();
        }

        @Override // ec.d, vb.t0.i
        public void g() {
            b bVar = this.f7887b;
            if (bVar != null) {
                bVar.i(this);
            }
            super.g();
        }

        @Override // ec.d, vb.t0.i
        public void h(t0.k kVar) {
            if (this.f7890e != null) {
                super.h(kVar);
            } else {
                this.f7890e = kVar;
                super.h(new a(kVar));
            }
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00aa A[PHI: r0
  0x00aa: PHI (r0v20 java.net.SocketAddress) = (r0v11 java.net.SocketAddress), (r0v32 java.net.SocketAddress) binds: [B:24:0x00a8, B:10:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // ec.d, vb.t0.i
        public void i(List<y> list) {
            SocketAddress socketAddress;
            if (h.m(b()) && h.m(list)) {
                if (h.this.f7823g.containsValue(this.f7887b)) {
                    this.f7887b.i(this);
                }
                socketAddress = list.get(0).a().get(0);
                if (h.this.f7823g.containsKey(socketAddress)) {
                    h.this.f7823g.get(socketAddress).b(this);
                }
            } else if (!h.m(b()) || h.m(list)) {
                if (!h.m(b()) && h.m(list)) {
                    socketAddress = list.get(0).a().get(0);
                    if (h.this.f7823g.containsKey(socketAddress)) {
                        h.this.f7823g.get(socketAddress).b(this);
                    }
                }
            } else if (h.this.f7823g.containsKey(a().a().get(0))) {
                b bVar = h.this.f7823g.get(a().a().get(0));
                bVar.i(this);
                bVar.j();
            }
            this.f7886a.i(list);
        }

        @Override // ec.d
        public t0.i j() {
            return this.f7886a;
        }

        public void m() {
            this.f7887b = null;
        }

        public void n() {
            this.f7888c = true;
            this.f7890e.a(r.b(l1.f17420t));
            this.f7891f.b(vb.f.a.INFO, "Subchannel ejected: {0}", this);
        }

        public boolean o() {
            return this.f7888c;
        }

        public void p(b bVar) {
            this.f7887b = bVar;
        }

        public void q() {
            this.f7888c = false;
            r rVar = this.f7889d;
            if (rVar != null) {
                this.f7890e.a(rVar);
                this.f7891f.b(vb.f.a.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // ec.d
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f7886a.b() + '}';
        }
    }

    public interface j {
        static List<j> b(g gVar, vb.f fVar) {
            k6.q.a aVarR = k6.q.r();
            if (gVar.f7852e != null) {
                aVarR.a(new k(gVar, fVar));
            }
            if (gVar.f7853f != null) {
                aVarR.a(new f(gVar, fVar));
            }
            return aVarR.k();
        }

        void a(c cVar, long j10);
    }

    public static class k implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vb.f f7896b;

        public k(g gVar, vb.f fVar) {
            m.e(gVar.f7852e != null, "success rate ejection config is null");
            this.f7895a = gVar;
            this.f7896b = fVar;
        }

        public static double c(Collection<Double> collection) {
            Iterator<Double> it = collection.iterator();
            double dDoubleValue = 0.0d;
            while (it.hasNext()) {
                dDoubleValue += it.next().doubleValue();
            }
            return dDoubleValue / ((double) collection.size());
        }

        public static double d(Collection<Double> collection, double d10) {
            Iterator<Double> it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double dDoubleValue = it.next().doubleValue() - d10;
                d11 += dDoubleValue * dDoubleValue;
            }
            return Math.sqrt(d11 / ((double) collection.size()));
        }

        @Override // ec.h.j
        public void a(c cVar, long j10) {
            List<b> listN = h.n(cVar, this.f7895a.f7852e.f7873d.intValue());
            if (listN.size() < this.f7895a.f7852e.f7872c.intValue() || listN.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = listN.iterator();
            while (it.hasNext()) {
                arrayList.add(Double.valueOf(((b) it.next()).n()));
            }
            double dC = c(arrayList);
            double d10 = d(arrayList, dC);
            double dIntValue = dC - (((double) (this.f7895a.f7852e.f7870a.intValue() / 1000.0f)) * d10);
            for (b bVar : listN) {
                if (cVar.d() >= this.f7895a.f7851d.intValue()) {
                    return;
                }
                if (bVar.n() < dIntValue) {
                    this.f7896b.b(vb.f.a.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", bVar, Double.valueOf(bVar.n()), Double.valueOf(dC), Double.valueOf(d10), Double.valueOf(dIntValue));
                    if (new Random().nextInt(100) < this.f7895a.f7852e.f7871b.intValue()) {
                        bVar.d(j10);
                    }
                }
            }
        }
    }

    public h(t0.e eVar, r2 r2Var) {
        vb.f fVarB = eVar.b();
        this.f7831o = fVarB;
        d dVar = new d((t0.e) m.p(eVar, "helper"));
        this.f7825i = dVar;
        this.f7826j = new ec.e(dVar);
        this.f7823g = new c();
        this.f7824h = (p1) m.p(eVar.d(), "syncContext");
        this.f7828l = (ScheduledExecutorService) m.p(eVar.c(), "timeService");
        this.f7827k = r2Var;
        fVarB.a(vb.f.a.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean m(List<y> list) {
        Iterator<y> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().a().size();
            if (size > 1) {
                return false;
            }
        }
        return true;
    }

    public static List<b> n(c cVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // vb.t0
    public l1 a(t0.h hVar) {
        this.f7831o.b(vb.f.a.DEBUG, "Received resolution result: {0}", hVar);
        g gVar = (g) hVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator<y> it = hVar.a().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().a());
        }
        this.f7823g.keySet().retainAll(arrayList);
        this.f7823g.i(gVar);
        this.f7823g.f(gVar, arrayList);
        this.f7826j.r(gVar.f7854g.b());
        if (gVar.a()) {
            Long lValueOf = this.f7830n == null ? gVar.f7848a : Long.valueOf(Math.max(0L, gVar.f7848a.longValue() - (this.f7827k.a() - this.f7830n.longValue())));
            p1.d dVar = this.f7829m;
            if (dVar != null) {
                dVar.a();
                this.f7823g.g();
            }
            this.f7829m = this.f7824h.e(new e(gVar, this.f7831o), lValueOf.longValue(), gVar.f7848a.longValue(), TimeUnit.NANOSECONDS, this.f7828l);
        } else {
            p1.d dVar2 = this.f7829m;
            if (dVar2 != null) {
                dVar2.a();
                this.f7830n = null;
                this.f7823g.c();
            }
        }
        this.f7826j.d(hVar.e().d(gVar.f7854g.a()).a());
        return l1.f17405e;
    }

    @Override // vb.t0
    public void c(l1 l1Var) {
        this.f7826j.c(l1Var);
    }

    @Override // vb.t0
    public void f() {
        this.f7826j.f();
    }
}
