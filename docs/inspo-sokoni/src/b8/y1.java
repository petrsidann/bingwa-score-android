package b8;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h8.f f3011a;

    public y1(h8.f fVar) {
        this.f3011a = fVar;
    }

    public final h8.s a(Object obj, e8.r1 r1Var) {
        if (obj.getClass().isArray()) {
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
        }
        d9.d0 d0VarD = d(l8.o.c(obj), r1Var);
        if (d0VarD.A0() == d9.d0.c.MAP_VALUE) {
            return new h8.s(d0VarD);
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + l8.g0.C(obj));
    }

    public d9.d0 b(Object obj, e8.r1 r1Var) {
        return d(l8.o.c(obj), r1Var);
    }

    public final List<d9.d0> c(List<Object> list) {
        e8.q1 q1Var = new e8.q1(e8.u1.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            arrayList.add(b(list.get(i10), q1Var.f().c(i10)));
        }
        return arrayList;
    }

    public final d9.d0 d(Object obj, e8.r1 r1Var) {
        if (obj instanceof Map) {
            return f((Map) obj, r1Var);
        }
        if (obj instanceof u) {
            k((u) obj, r1Var);
            return null;
        }
        if (r1Var.h() != null) {
            r1Var.a(r1Var.h());
        }
        if (!(obj instanceof List)) {
            return j(obj, r1Var);
        }
        if (!r1Var.i() || r1Var.g() == e8.u1.ArrayArgument) {
            return e((List) obj, r1Var);
        }
        throw r1Var.f("Nested arrays are not supported");
    }

    public final <T> d9.d0 e(List<T> list, e8.r1 r1Var) {
        d9.b.C0113b c0113bN0 = d9.b.n0();
        Iterator<T> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            d9.d0 d0VarD = d(it.next(), r1Var.c(i10));
            if (d0VarD == null) {
                d0VarD = d9.d0.B0().Q(com.google.protobuf.f1.NULL_VALUE).build();
            }
            c0113bN0.F(d0VarD);
            i10++;
        }
        return d9.d0.B0().F(c0113bN0).build();
    }

    public final <K, V> d9.d0 f(Map<K, V> map, e8.r1 r1Var) {
        d9.d0.b bVarO;
        if (map.isEmpty()) {
            if (r1Var.h() != null && !r1Var.h().r()) {
                r1Var.a(r1Var.h());
            }
            bVarO = d9.d0.B0().P(d9.u.f0());
        } else {
            d9.u.b bVarN0 = d9.u.n0();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!(entry.getKey() instanceof String)) {
                    throw r1Var.f(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
                }
                String str = (String) entry.getKey();
                d9.d0 d0VarD = d(entry.getValue(), r1Var.e(str));
                if (d0VarD != null) {
                    bVarN0.H(str, d0VarD);
                }
            }
            bVarO = d9.d0.B0().O(bVarN0);
        }
        return bVarO.build();
    }

    public e8.s1 g(Object obj, i8.d dVar) {
        e8.q1 q1Var = new e8.q1(e8.u1.MergeSet);
        h8.s sVarA = a(obj, q1Var.f());
        if (dVar == null) {
            return q1Var.g(sVarA);
        }
        for (h8.q qVar : dVar.c()) {
            if (!q1Var.d(qVar)) {
                throw new IllegalArgumentException("Field '" + qVar.toString() + "' is specified in your field mask but not in your input data.");
            }
        }
        return q1Var.h(sVarA, dVar);
    }

    public d9.d0 h(Object obj) {
        return i(obj, false);
    }

    public d9.d0 i(Object obj, boolean z10) {
        e8.q1 q1Var = new e8.q1(z10 ? e8.u1.ArrayArgument : e8.u1.Argument);
        d9.d0 d0VarB = b(obj, q1Var.f());
        l8.b.d(d0VarB != null, "Parsed data should not be null.", new Object[0]);
        l8.b.d(q1Var.e().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return d0VarB;
    }

    public final d9.d0 j(Object obj, e8.r1 r1Var) {
        if (obj == null) {
            return d9.d0.B0().Q(com.google.protobuf.f1.NULL_VALUE).build();
        }
        if (obj instanceof Integer) {
            return d9.d0.B0().N(((Integer) obj).intValue()).build();
        }
        if (obj instanceof Long) {
            return d9.d0.B0().N(((Long) obj).longValue()).build();
        }
        if (obj instanceof Float) {
            return d9.d0.B0().L(((Float) obj).doubleValue()).build();
        }
        if (obj instanceof Double) {
            return d9.d0.B0().L(((Double) obj).doubleValue()).build();
        }
        if (obj instanceof Boolean) {
            return d9.d0.B0().I(((Boolean) obj).booleanValue()).build();
        }
        if (obj instanceof String) {
            return d9.d0.B0().S((String) obj).build();
        }
        if (obj instanceof Date) {
            return m(new h7.q((Date) obj));
        }
        if (obj instanceof h7.q) {
            return m((h7.q) obj);
        }
        if (obj instanceof q0) {
            q0 q0Var = (q0) obj;
            return d9.d0.B0().M(o9.a.j0().E(q0Var.h()).F(q0Var.i())).build();
        }
        if (obj instanceof e) {
            return d9.d0.B0().K(((e) obj).k()).build();
        }
        if (obj instanceof com.google.firebase.firestore.c) {
            com.google.firebase.firestore.c cVar = (com.google.firebase.firestore.c) obj;
            if (cVar.p() != null) {
                h8.f fVarB = cVar.p().B();
                if (!fVarB.equals(this.f3011a)) {
                    throw r1Var.f(String.format("Document reference is for database %s/%s but should be for database %s/%s", fVarB.l(), fVarB.k(), this.f3011a.l(), this.f3011a.k()));
                }
            }
            return d9.d0.B0().R(String.format("projects/%s/databases/%s/documents/%s", this.f3011a.l(), this.f3011a.k(), cVar.r())).build();
        }
        if (obj instanceof z1) {
            return p((z1) obj, r1Var);
        }
        if (obj.getClass().isArray()) {
            throw r1Var.f("Arrays are not supported; use a List instead");
        }
        throw r1Var.f("Unsupported type: " + l8.g0.C(obj));
    }

    public final void k(u uVar, e8.r1 r1Var) {
        i8.p jVar;
        h8.q qVarH;
        if (!r1Var.j()) {
            throw r1Var.f(String.format("%s() can only be used with set() and update()", uVar.d()));
        }
        if (r1Var.h() == null) {
            throw r1Var.f(String.format("%s() is not currently supported inside arrays", uVar.d()));
        }
        if (uVar instanceof u.c) {
            if (r1Var.g() == e8.u1.MergeSet) {
                r1Var.a(r1Var.h());
                return;
            } else {
                if (r1Var.g() != e8.u1.Update) {
                    throw r1Var.f("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                }
                l8.b.d(r1Var.h().u() > 0, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                throw r1Var.f("FieldValue.delete() can only appear at the top level of your update data");
            }
        }
        if (uVar instanceof u.e) {
            qVarH = r1Var.h();
            jVar = i8.n.d();
        } else {
            if (uVar instanceof u.b) {
                jVar = new i8.a.b(c(((u.b) uVar).i()));
            } else if (uVar instanceof u.a) {
                jVar = new i8.a.C0175a(c(((u.a) uVar).i()));
            } else {
                if (!(uVar instanceof u.d)) {
                    throw l8.b.a("Unknown FieldValue type: %s", l8.g0.C(uVar));
                }
                jVar = new i8.j(h(((u.d) uVar).i()));
            }
            qVarH = r1Var.h();
        }
        r1Var.b(qVarH, jVar);
    }

    public e8.s1 l(Object obj) {
        e8.q1 q1Var = new e8.q1(e8.u1.Set);
        return q1Var.i(a(obj, q1Var.f()));
    }

    public final d9.d0 m(h7.q qVar) {
        return d9.d0.B0().T(com.google.protobuf.u1.j0().F(qVar.k()).E((qVar.h() / 1000) * 1000)).build();
    }

    public e8.t1 n(List<Object> list) {
        l8.b.d(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        e8.q1 q1Var = new e8.q1(e8.u1.Update);
        e8.r1 r1VarF = q1Var.f();
        h8.s sVar = new h8.s();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z10 = next instanceof String;
            l8.b.d(z10 || (next instanceof t), "Expected argument to be String or FieldPath.", new Object[0]);
            h8.q qVarC = (z10 ? t.b((String) next) : (t) next).c();
            if (next2 instanceof u.c) {
                r1VarF.a(qVarC);
            } else {
                d9.d0 d0VarB = b(next2, r1VarF.d(qVarC));
                if (d0VarB != null) {
                    r1VarF.a(qVarC);
                    sVar.m(qVarC, d0VarB);
                }
            }
        }
        return q1Var.j(sVar);
    }

    public e8.t1 o(Map<String, Object> map) {
        l8.x.c(map, "Provided update data must not be null.");
        e8.q1 q1Var = new e8.q1(e8.u1.Update);
        e8.r1 r1VarF = q1Var.f();
        h8.s sVar = new h8.s();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            h8.q qVarC = t.b(entry.getKey()).c();
            Object value = entry.getValue();
            if (value instanceof u.c) {
                r1VarF.a(qVarC);
            } else {
                d9.d0 d0VarB = b(value, r1VarF.d(qVarC));
                if (d0VarB != null) {
                    r1VarF.a(qVarC);
                    sVar.m(qVarC, d0VarB);
                }
            }
        }
        return q1Var.j(sVar);
    }

    public final d9.d0 p(z1 z1Var, e8.r1 r1Var) {
        d9.u.b bVarN0 = d9.u.n0();
        bVarN0.H("__type__", h8.y.f9788f);
        bVarN0.H("value", d(z1Var.b(), r1Var));
        return d9.d0.B0().O(bVarN0).build();
    }
}
