package i8;

import g8.g1;
import h8.r;
import h8.v;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h7.q f10531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f> f10532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f> f10533d;

    public g(int i10, h7.q qVar, List<f> list, List<f> list2) {
        l8.b.d(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.f10530a = i10;
        this.f10531b = qVar;
        this.f10532c = list;
        this.f10533d = list2;
    }

    public Map<h8.k, f> a(Map<h8.k, g1> map, Set<h8.k> set) {
        HashMap map2 = new HashMap();
        for (h8.k kVar : f()) {
            r rVar = (r) map.get(kVar).a();
            d dVarB = b(rVar, map.get(kVar).b());
            if (set.contains(kVar)) {
                dVarB = null;
            }
            f fVarC = f.c(rVar, dVarB);
            if (fVarC != null) {
                map2.put(kVar, fVarC);
            }
            if (!rVar.q()) {
                rVar.o(v.f9777b);
            }
        }
        return map2;
    }

    public d b(r rVar, d dVar) {
        for (int i10 = 0; i10 < this.f10532c.size(); i10++) {
            f fVar = this.f10532c.get(i10);
            if (fVar.g().equals(rVar.getKey())) {
                dVar = fVar.a(rVar, dVar, this.f10531b);
            }
        }
        for (int i11 = 0; i11 < this.f10533d.size(); i11++) {
            f fVar2 = this.f10533d.get(i11);
            if (fVar2.g().equals(rVar.getKey())) {
                dVar = fVar2.a(rVar, dVar, this.f10531b);
            }
        }
        return dVar;
    }

    public void c(r rVar, h hVar) {
        int size = this.f10533d.size();
        List<i> listE = hVar.e();
        l8.b.d(listE.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(listE.size()));
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = this.f10533d.get(i10);
            if (fVar.g().equals(rVar.getKey())) {
                fVar.b(rVar, listE.get(i10));
            }
        }
    }

    public List<f> d() {
        return this.f10532c;
    }

    public int e() {
        return this.f10530a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f10530a == gVar.f10530a && this.f10531b.equals(gVar.f10531b) && this.f10532c.equals(gVar.f10532c) && this.f10533d.equals(gVar.f10533d);
    }

    public Set<h8.k> f() {
        HashSet hashSet = new HashSet();
        Iterator<f> it = this.f10533d.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().g());
        }
        return hashSet;
    }

    public h7.q g() {
        return this.f10531b;
    }

    public List<f> h() {
        return this.f10533d;
    }

    public int hashCode() {
        return (((((this.f10530a * 31) + this.f10531b.hashCode()) * 31) + this.f10532c.hashCode()) * 31) + this.f10533d.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.f10530a + ", localWriteTime=" + this.f10531b + ", baseMutations=" + this.f10532c + ", mutations=" + this.f10533d + ')';
    }
}
