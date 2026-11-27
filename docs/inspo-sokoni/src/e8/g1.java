package e8;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a1> f7166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q> f7167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h8.t f7168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f7170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f7171g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f7172h;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7173a;

        static {
            int[] iArr = new int[p.b.values().length];
            f7173a = iArr;
            try {
                iArr[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7173a[p.b.ARRAY_CONTAINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7173a[p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7173a[p.b.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7173a[p.b.NOT_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f7173a[p.b.NOT_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f7173a[p.b.LESS_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f7173a[p.b.LESS_THAN_OR_EQUAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f7173a[p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f7173a[p.b.GREATER_THAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public g1(h8.t tVar, String str, List<q> list, List<a1> list2, long j10, i iVar, i iVar2) {
        this.f7168d = tVar;
        this.f7169e = str;
        this.f7166b = list2;
        this.f7167c = list;
        this.f7170f = j10;
        this.f7171g = iVar;
        this.f7172h = iVar2;
    }

    public List<d9.d0> a(h8.p pVar) {
        h8.p.c cVarC = pVar.c();
        if (cVarC == null) {
            return null;
        }
        for (p pVar2 : g(cVarC.i())) {
            int i10 = a.f7173a[pVar2.g().ordinal()];
            if (i10 == 1) {
                return pVar2.h().p0().m();
            }
            if (i10 == 2) {
                return Collections.singletonList(pVar2.h());
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Pair<d9.d0, Boolean> b(h8.p.c cVar, i iVar) {
        d9.d0 d0Var = h8.y.f9785c;
        Iterator<p> it = g(cVar.i()).iterator();
        boolean zC = true;
        while (true) {
            boolean z10 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    for (int i10 = 0; i10 < this.f7166b.size(); i10++) {
                        if (this.f7166b.get(i10).c().equals(cVar.i())) {
                            d9.d0 d0Var2 = iVar.b().get(i10);
                            if (h8.y.E(d0Var, zC, d0Var2, iVar.c()) < 0) {
                                zC = iVar.c();
                                d0Var = d0Var2;
                            }
                        }
                    }
                }
                return new Pair<>(d0Var, Boolean.valueOf(zC));
            }
            p next = it.next();
            d9.d0 d0VarH = h8.y.f9785c;
            switch (a.f7173a[next.g().ordinal()]) {
                case 3:
                case 4:
                case 9:
                    d0VarH = next.h();
                    z10 = true;
                    break;
                case 5:
                case 6:
                default:
                    z10 = true;
                    break;
                case 7:
                case 8:
                    d0VarH = h8.y.s(next.h());
                    z10 = true;
                    break;
                case 10:
                    d0VarH = next.h();
                    break;
            }
            if (h8.y.E(d0Var, zC, d0VarH, z10) < 0) {
                zC = z10;
                d0Var = d0VarH;
            }
        }
    }

    public String c() {
        String str = this.f7165a;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(n().i());
        if (this.f7169e != null) {
            sb2.append("|cg:");
            sb2.append(this.f7169e);
        }
        sb2.append("|f:");
        Iterator<q> it = h().iterator();
        while (it.hasNext()) {
            sb2.append(it.next().a());
        }
        sb2.append("|ob:");
        for (a1 a1Var : m()) {
            sb2.append(a1Var.c().i());
            sb2.append(a1Var.b().equals(a1.a.ASCENDING) ? "asc" : "desc");
        }
        if (r()) {
            sb2.append("|l:");
            sb2.append(j());
        }
        if (this.f7171g != null) {
            sb2.append("|lb:");
            sb2.append(this.f7171g.c() ? "b:" : "a:");
            sb2.append(this.f7171g.d());
        }
        if (this.f7172h != null) {
            sb2.append("|ub:");
            sb2.append(this.f7172h.c() ? "a:" : "b:");
            sb2.append(this.f7172h.d());
        }
        String string = sb2.toString();
        this.f7165a = string;
        return string;
    }

    public String d() {
        return this.f7169e;
    }

    public final Pair<d9.d0, Boolean> e(h8.p.c cVar, i iVar) {
        d9.d0 d0Var = h8.y.f9787e;
        Iterator<p> it = g(cVar.i()).iterator();
        boolean zC = true;
        while (true) {
            z = false;
            boolean z10 = false;
            if (!it.hasNext()) {
                if (iVar != null) {
                    for (int i10 = 0; i10 < this.f7166b.size(); i10++) {
                        if (this.f7166b.get(i10).c().equals(cVar.i())) {
                            d9.d0 d0Var2 = iVar.b().get(i10);
                            if (h8.y.J(d0Var, zC, d0Var2, iVar.c()) > 0) {
                                zC = iVar.c();
                                d0Var = d0Var2;
                            }
                        }
                    }
                }
                return new Pair<>(d0Var, Boolean.valueOf(zC));
            }
            p next = it.next();
            d9.d0 d0VarH = h8.y.f9787e;
            switch (a.f7173a[next.g().ordinal()]) {
                case 3:
                case 4:
                case 8:
                    d0VarH = next.h();
                case 5:
                case 6:
                default:
                    z10 = true;
                    break;
                case 7:
                    d0VarH = next.h();
                    break;
                case 9:
                case 10:
                    d0VarH = h8.y.t(next.h());
                    break;
            }
            if (h8.y.J(d0Var, zC, d0VarH, z10) > 0) {
                zC = z10;
                d0Var = d0VarH;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g1.class != obj.getClass()) {
            return false;
        }
        g1 g1Var = (g1) obj;
        String str = this.f7169e;
        if (str == null ? g1Var.f7169e != null : !str.equals(g1Var.f7169e)) {
            return false;
        }
        if (this.f7170f != g1Var.f7170f || !this.f7166b.equals(g1Var.f7166b) || !this.f7167c.equals(g1Var.f7167c) || !this.f7168d.equals(g1Var.f7168d)) {
            return false;
        }
        i iVar = this.f7171g;
        if (iVar == null ? g1Var.f7171g != null : !iVar.equals(g1Var.f7171g)) {
            return false;
        }
        i iVar2 = this.f7172h;
        i iVar3 = g1Var.f7172h;
        if (iVar2 != null) {
            return iVar2.equals(iVar3);
        }
        return iVar3 == null;
    }

    public i f() {
        return this.f7172h;
    }

    public final List<p> g(h8.q qVar) {
        ArrayList arrayList = new ArrayList();
        for (q qVar2 : this.f7167c) {
            if (qVar2 instanceof p) {
                p pVar = (p) qVar2;
                if (pVar.f().equals(qVar)) {
                    arrayList.add(pVar);
                }
            }
        }
        return arrayList;
    }

    public List<q> h() {
        return this.f7167c;
    }

    public int hashCode() {
        int iHashCode = this.f7166b.hashCode() * 31;
        String str = this.f7169e;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f7167c.hashCode()) * 31) + this.f7168d.hashCode()) * 31;
        long j10 = this.f7170f;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        i iVar = this.f7171g;
        int iHashCode3 = (i10 + (iVar != null ? iVar.hashCode() : 0)) * 31;
        i iVar2 = this.f7172h;
        return iHashCode3 + (iVar2 != null ? iVar2.hashCode() : 0);
    }

    public a1.a i() {
        List<a1> list = this.f7166b;
        return list.get(list.size() - 1).b();
    }

    public long j() {
        return this.f7170f;
    }

    public i k(h8.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (h8.p.c cVar : pVar.e()) {
            Pair<d9.d0, Boolean> pairB = cVar.k().equals(h8.p.c.a.ASCENDING) ? b(cVar, this.f7171g) : e(cVar, this.f7171g);
            arrayList.add((d9.d0) pairB.first);
            zBooleanValue &= ((Boolean) pairB.second).booleanValue();
        }
        return new i(arrayList, zBooleanValue);
    }

    public Collection<d9.d0> l(h8.p pVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (h8.p.c cVar : pVar.e()) {
            for (p pVar2 : g(cVar.i())) {
                int i10 = a.f7173a[pVar2.g().ordinal()];
                if (i10 == 3 || i10 == 4) {
                    linkedHashMap.put(cVar.i(), pVar2.h());
                } else if (i10 == 5 || i10 == 6) {
                    linkedHashMap.put(cVar.i(), pVar2.h());
                    return linkedHashMap.values();
                }
            }
        }
        return null;
    }

    public List<a1> m() {
        return this.f7166b;
    }

    public h8.t n() {
        return this.f7168d;
    }

    public int o() {
        HashSet hashSet = new HashSet();
        Iterator<q> it = this.f7167c.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            for (p pVar : it.next().c()) {
                if (!pVar.f().B()) {
                    if (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY)) {
                        i10 = 1;
                    } else {
                        hashSet.add(pVar.f());
                    }
                }
            }
        }
        for (a1 a1Var : this.f7166b) {
            if (!a1Var.c().B()) {
                hashSet.add(a1Var.c());
            }
        }
        return hashSet.size() + i10;
    }

    public i p() {
        return this.f7171g;
    }

    public i q(h8.p pVar) {
        ArrayList arrayList = new ArrayList();
        boolean zBooleanValue = true;
        for (h8.p.c cVar : pVar.e()) {
            Pair<d9.d0, Boolean> pairE = cVar.k().equals(h8.p.c.a.ASCENDING) ? e(cVar, this.f7172h) : b(cVar, this.f7172h);
            arrayList.add((d9.d0) pairE.first);
            zBooleanValue &= ((Boolean) pairE.second).booleanValue();
        }
        return new i(arrayList, zBooleanValue);
    }

    public boolean r() {
        return this.f7170f != -1;
    }

    public boolean s() {
        return h8.k.u(this.f7168d) && this.f7169e == null && this.f7167c.isEmpty();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Query(");
        sb2.append(this.f7168d.i());
        if (this.f7169e != null) {
            sb2.append(" collectionGroup=");
            sb2.append(this.f7169e);
        }
        if (!this.f7167c.isEmpty()) {
            sb2.append(" where ");
            for (int i10 = 0; i10 < this.f7167c.size(); i10++) {
                if (i10 > 0) {
                    sb2.append(" and ");
                }
                sb2.append(this.f7167c.get(i10));
            }
        }
        if (!this.f7166b.isEmpty()) {
            sb2.append(" order by ");
            for (int i11 = 0; i11 < this.f7166b.size(); i11++) {
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(this.f7166b.get(i11));
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
