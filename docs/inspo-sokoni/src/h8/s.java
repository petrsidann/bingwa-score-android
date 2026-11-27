package h8;

import d9.d0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f9774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f9775b;

    public s() {
        this(d0.B0().P(d9.u.f0()).build());
    }

    public s(d0 d0Var) {
        this.f9775b = new HashMap();
        l8.b.d(d0Var.A0() == d0.c.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        l8.b.d(!u.c(d0Var), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.f9774a = d0Var;
    }

    public static s h(Map<String, d0> map) {
        return new s(d0.B0().O(d9.u.n0().F(map)).build());
    }

    public final d9.u a(q qVar, Map<String, Object> map) {
        d0 d0VarG = g(this.f9774a, qVar);
        d9.u.b bVarB = y.x(d0VarG) ? d0VarG.w0().b() : d9.u.n0();
        boolean z10 = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                d9.u uVarA = a(qVar.h(key), (Map) value);
                if (uVarA != null) {
                    bVarB.H(key, d0.B0().P(uVarA).build());
                    z10 = true;
                }
            } else {
                if (value instanceof d0) {
                    bVarB.H(key, (d0) value);
                } else if (bVarB.E(key)) {
                    l8.b.d(value == null, "Expected entry to be a Map, a Value or null", new Object[0]);
                    bVarB.I(key);
                }
                z10 = true;
            }
        }
        if (z10) {
            return bVarB.build();
        }
        return null;
    }

    public final d0 b() {
        synchronized (this.f9775b) {
            d9.u uVarA = a(q.f9758c, this.f9775b);
            if (uVarA != null) {
                this.f9774a = d0.B0().P(uVarA).build();
                this.f9775b.clear();
            }
        }
        return this.f9774a;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s clone() {
        return new s(b());
    }

    public void d(q qVar) {
        l8.b.d(!qVar.r(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        o(qVar, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            return y.r(b(), ((s) obj).b());
        }
        return false;
    }

    public final i8.d f(d9.u uVar) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, d0> entry : uVar.h0().entrySet()) {
            q qVarA = q.A(entry.getKey());
            if (y.x(entry.getValue())) {
                Set<q> setC = f(entry.getValue().w0()).c();
                if (!setC.isEmpty()) {
                    Iterator<q> it = setC.iterator();
                    while (it.hasNext()) {
                        hashSet.add(qVarA.d(it.next()));
                    }
                }
            }
            hashSet.add(qVarA);
        }
        return i8.d.b(hashSet);
    }

    public final d0 g(d0 d0Var, q qVar) {
        if (qVar.r()) {
            return d0Var;
        }
        int i10 = 0;
        while (true) {
            int iU = qVar.u() - 1;
            d9.u uVarW0 = d0Var.w0();
            if (i10 >= iU) {
                return uVarW0.i0(qVar.p(), null);
            }
            d0Var = uVarW0.i0(qVar.q(i10), null);
            if (!y.x(d0Var)) {
                return null;
            }
            i10++;
        }
    }

    public int hashCode() {
        return b().hashCode();
    }

    public d0 i(q qVar) {
        return g(b(), qVar);
    }

    public i8.d j() {
        return f(b().w0());
    }

    public Map<String, d0> l() {
        return b().w0().h0();
    }

    public void m(q qVar, d0 d0Var) {
        l8.b.d(!qVar.r(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        o(qVar, d0Var);
    }

    public void n(Map<q, d0> map) {
        for (Map.Entry<q, d0> entry : map.entrySet()) {
            q key = entry.getKey();
            if (entry.getValue() == null) {
                d(key);
            } else {
                m(key, entry.getValue());
            }
        }
    }

    public final void o(q qVar, d0 d0Var) {
        Map<String, Object> map;
        Map<String, Object> map2 = this.f9775b;
        for (int i10 = 0; i10 < qVar.u() - 1; i10++) {
            String strQ = qVar.q(i10);
            Object obj = map2.get(strQ);
            if (obj instanceof Map) {
                map = (Map) obj;
            } else {
                if (obj instanceof d0) {
                    d0 d0Var2 = (d0) obj;
                    if (d0Var2.A0() == d0.c.MAP_VALUE) {
                        HashMap map3 = new HashMap(d0Var2.w0().h0());
                        map2.put(strQ, map3);
                        map2 = map3;
                    }
                }
                map = new HashMap<>();
                map2.put(strQ, map);
            }
            map2 = map;
        }
        map2.put(qVar.p(), d0Var);
    }

    public String toString() {
        return "ObjectValue{internalValue=" + y.b(b()) + '}';
    }
}
