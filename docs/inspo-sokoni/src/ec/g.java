package ec;

import j6.m;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import vb.l1;
import vb.q;
import vb.t0;
import vb.u0;
import vb.y;
import xb.v1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends t0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f7802l = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t0.e f7804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7805i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f7807k;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Object, c> f7803g = new LinkedHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u0 f7806j = new v1();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f7808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f7809b;

        public b(l1 l1Var, List<c> list) {
            this.f7808a = l1Var;
            this.f7809b = list;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f7810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t0.h f7811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f7812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f7813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u0 f7814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public q f7815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public t0.j f7816g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f7817h;

        public final class a extends ec.c {
            public a() {
            }

            @Override // ec.c, vb.t0.e
            public void f(q qVar, t0.j jVar) {
                if (g.this.f7803g.containsKey(c.this.f7810a)) {
                    c.this.f7815f = qVar;
                    c.this.f7816g = jVar;
                    if (c.this.f7817h) {
                        return;
                    }
                    g gVar = g.this;
                    if (gVar.f7805i) {
                        return;
                    }
                    if (qVar == q.IDLE && gVar.v()) {
                        c.this.f7813d.e();
                    }
                    g.this.x();
                }
            }

            @Override // ec.c
            public t0.e g() {
                return g.this.f7804h;
            }
        }

        public c(g gVar, Object obj, u0 u0Var, Object obj2, t0.j jVar) {
            this(obj, u0Var, obj2, jVar, null, false);
        }

        public c(Object obj, u0 u0Var, Object obj2, t0.j jVar, t0.h hVar, boolean z10) {
            this.f7810a = obj;
            this.f7814e = u0Var;
            this.f7817h = z10;
            this.f7816g = jVar;
            this.f7812c = obj2;
            e eVar = new e(new a());
            this.f7813d = eVar;
            this.f7815f = z10 ? q.IDLE : q.CONNECTING;
            this.f7811b = hVar;
            if (z10) {
                return;
            }
            eVar.r(u0Var);
        }

        public void h() {
            if (this.f7817h) {
                return;
            }
            g.this.f7803g.remove(this.f7810a);
            this.f7817h = true;
            g.f7802l.log(Level.FINE, "Child balancer {0} deactivated", this.f7810a);
        }

        public Object i() {
            return this.f7812c;
        }

        public t0.j j() {
            return this.f7816g;
        }

        public q k() {
            return this.f7815f;
        }

        public u0 l() {
            return this.f7814e;
        }

        public boolean m() {
            return this.f7817h;
        }

        public void n(u0 u0Var) {
            this.f7817h = false;
        }

        public void o(t0.h hVar) {
            m.p(hVar, "Missing address list for child");
            this.f7811b = hVar;
        }

        public void p() {
            this.f7813d.f();
            this.f7815f = q.SHUTDOWN;
            g.f7802l.log(Level.FINE, "Child balancer {0} deleted", this.f7810a);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Address = ");
            sb2.append(this.f7810a);
            sb2.append(", state = ");
            sb2.append(this.f7815f);
            sb2.append(", picker type: ");
            sb2.append(this.f7816g.getClass());
            sb2.append(", lb: ");
            sb2.append(this.f7813d.g().getClass());
            sb2.append(this.f7817h ? ", deactivated" : "");
            return sb2.toString();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f7820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7821b;

        public d(y yVar) {
            m.p(yVar, "eag");
            this.f7820a = new String[yVar.a().size()];
            Iterator<SocketAddress> it = yVar.a().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                this.f7820a[i10] = it.next().toString();
                i10++;
            }
            Arrays.sort(this.f7820a);
            this.f7821b = Arrays.hashCode(this.f7820a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (dVar.f7821b == this.f7821b) {
                String[] strArr = dVar.f7820a;
                int length = strArr.length;
                String[] strArr2 = this.f7820a;
                if (length == strArr2.length) {
                    return Arrays.equals(strArr, strArr2);
                }
            }
            return false;
        }

        public int hashCode() {
            return this.f7821b;
        }

        public String toString() {
            return Arrays.toString(this.f7820a);
        }
    }

    public g(t0.e eVar) {
        this.f7804h = (t0.e) m.p(eVar, "helper");
        f7802l.log(Level.FINE, "Created");
    }

    public static q k(q qVar, q qVar2) {
        if (qVar == null) {
            return qVar2;
        }
        q qVar3 = q.READY;
        return (qVar == qVar3 || qVar2 == qVar3 || qVar == (qVar3 = q.CONNECTING) || qVar2 == qVar3 || qVar == (qVar3 = q.IDLE) || qVar2 == qVar3) ? qVar3 : qVar;
    }

    @Override // vb.t0
    public l1 a(t0.h hVar) {
        try {
            this.f7805i = true;
            b bVarG = g(hVar);
            if (!bVarG.f7808a.o()) {
                return bVarG.f7808a;
            }
            x();
            w(bVarG.f7809b);
            return bVarG.f7808a;
        } finally {
            this.f7805i = false;
        }
    }

    @Override // vb.t0
    public void c(l1 l1Var) {
        if (this.f7807k != q.READY) {
            this.f7804h.f(q.TRANSIENT_FAILURE, p(l1Var));
        }
    }

    @Override // vb.t0
    public void f() {
        f7802l.log(Level.FINE, "Shutdown");
        Iterator<c> it = this.f7803g.values().iterator();
        while (it.hasNext()) {
            it.next().p();
        }
        this.f7803g.clear();
    }

    public b g(t0.h hVar) {
        f7802l.log(Level.FINE, "Received resolution result: {0}", hVar);
        Map<Object, c> mapL = l(hVar);
        if (mapL.isEmpty()) {
            l1 l1VarQ = l1.f17420t.q("NameResolver returned no usable address. " + hVar);
            c(l1VarQ);
            return new b(l1VarQ, null);
        }
        for (Map.Entry<Object, c> entry : mapL.entrySet()) {
            Object key = entry.getKey();
            u0 u0VarL = entry.getValue().l();
            Object objI = entry.getValue().i();
            if (this.f7803g.containsKey(key)) {
                c cVar = this.f7803g.get(key);
                if (cVar.m() && u()) {
                    cVar.n(u0VarL);
                }
            } else {
                this.f7803g.put(key, entry.getValue());
            }
            c cVar2 = this.f7803g.get(key);
            t0.h hVarN = n(key, hVar, objI);
            this.f7803g.get(key).o(hVarN);
            if (!cVar2.f7817h) {
                cVar2.f7813d.d(hVarN);
            }
        }
        ArrayList arrayList = new ArrayList();
        k6.t0 it = k6.q.t(this.f7803g.keySet()).iterator();
        while (it.hasNext()) {
            E next = it.next();
            if (!mapL.containsKey(next)) {
                c cVar3 = this.f7803g.get(next);
                cVar3.h();
                arrayList.add(cVar3);
            }
        }
        return new b(l1.f17405e, arrayList);
    }

    public Map<Object, c> l(t0.h hVar) {
        HashMap map = new HashMap();
        Iterator<y> it = hVar.a().iterator();
        while (it.hasNext()) {
            d dVar = new d(it.next());
            c cVarM = this.f7803g.get(dVar);
            if (cVarM == null) {
                cVarM = m(dVar, null, r(), hVar);
            }
            map.put(dVar, cVarM);
        }
        return map;
    }

    public c m(Object obj, Object obj2, t0.j jVar, t0.h hVar) {
        return new c(this, obj, this.f7806j, obj2, jVar);
    }

    public t0.h n(Object obj, t0.h hVar, Object obj2) {
        d dVar;
        if (obj instanceof y) {
            dVar = new d((y) obj);
        } else {
            m.e(obj instanceof d, "key is wrong type");
            dVar = (d) obj;
        }
        for (y yVar : hVar.a()) {
            if (dVar.equals(new d(yVar))) {
                m.p(yVar, obj + " no longer present in load balancer children");
                return hVar.e().b(Collections.singletonList(yVar)).c(vb.a.c().d(t0.f17507e, Boolean.TRUE).a()).d(obj2).a();
            }
        }
        yVar = null;
        m.p(yVar, obj + " no longer present in load balancer children");
        return hVar.e().b(Collections.singletonList(yVar)).c(vb.a.c().d(t0.f17507e, Boolean.TRUE).a()).d(obj2).a();
    }

    public Collection<c> o() {
        return this.f7803g.values();
    }

    public t0.j p(l1 l1Var) {
        return new t0.d(t0.f.f(l1Var));
    }

    public t0.e q() {
        return this.f7804h;
    }

    public t0.j r() {
        return new t0.d(t0.f.g());
    }

    public List<c> s() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : o()) {
            if (!cVar.m() && cVar.k() == q.READY) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public abstract t0.j t(Map<Object, t0.j> map);

    public boolean u() {
        return true;
    }

    public boolean v() {
        return true;
    }

    public void w(List<c> list) {
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    public void x() {
        HashMap map = new HashMap();
        q qVarK = null;
        for (c cVar : o()) {
            if (!cVar.f7817h) {
                map.put(cVar.f7810a, cVar.f7816g);
                qVarK = k(qVarK, cVar.f7815f);
            }
        }
        if (qVarK != null) {
            this.f7804h.f(qVarK, t(map));
            this.f7807k = qVarK;
        }
    }
}
