package ec;

import j6.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import vb.q;
import vb.t0;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicInteger f7897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t0.j f7898n;

    public static final class a extends t0.j {
        @Override // vb.t0.j
        public t0.f a(t0.g gVar) {
            return t0.f.g();
        }

        public boolean equals(Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public static class b extends t0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<t0.j> f7899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f7900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7901c;

        public b(List<t0.j> list, AtomicInteger atomicInteger) {
            m.e(!list.isEmpty(), "empty list");
            this.f7899a = list;
            this.f7900b = (AtomicInteger) m.p(atomicInteger, "index");
            Iterator<t0.j> it = list.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            this.f7901c = iHashCode;
        }

        @Override // vb.t0.j
        public t0.f a(t0.g gVar) {
            return this.f7899a.get(c()).a(gVar);
        }

        public final int c() {
            return (this.f7900b.getAndIncrement() & com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER) % this.f7899a.size();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == this) {
                return true;
            }
            return this.f7901c == bVar.f7901c && this.f7900b == bVar.f7900b && this.f7899a.size() == bVar.f7899a.size() && new HashSet(this.f7899a).containsAll(bVar.f7899a);
        }

        public int hashCode() {
            return this.f7901c;
        }

        public String toString() {
            return j6.g.a(b.class).d("subchannelPickers", this.f7899a).toString();
        }
    }

    public j(t0.e eVar) {
        super(eVar);
        this.f7897m = new AtomicInteger(new Random().nextInt());
        this.f7898n = new a();
    }

    @Override // ec.g
    public t0.j t(Map<Object, t0.j> map) {
        throw new UnsupportedOperationException();
    }

    @Override // ec.g
    public void x() {
        boolean z10;
        q qVar;
        t0.j jVarY;
        List<g.c> listS = s();
        if (!listS.isEmpty()) {
            z(q.READY, y(listS));
            return;
        }
        Iterator<g.c> it = o().iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            q qVarK = it.next().k();
            if (qVarK == q.CONNECTING || qVarK == q.IDLE) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            qVar = q.CONNECTING;
            jVarY = new a();
        } else {
            qVar = q.TRANSIENT_FAILURE;
            jVarY = y(o());
        }
        z(qVar, jVarY);
    }

    public t0.j y(Collection<g.c> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<g.c> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().j());
        }
        return new b(arrayList, this.f7897m);
    }

    public final void z(q qVar, t0.j jVar) {
        if (qVar == this.f7807k && jVar.equals(this.f7898n)) {
            return;
        }
        q().f(qVar, jVar);
        this.f7807k = qVar;
        this.f7898n = jVar;
    }
}
