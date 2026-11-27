package g8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class t0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<h8.k, i8.k> f8950a = new TreeMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Set<h8.k>> f8951b = new HashMap();

    @Override // g8.b
    public Map<h8.k, i8.k> a(SortedSet<h8.k> sortedSet) {
        HashMap map = new HashMap();
        for (h8.k kVar : sortedSet) {
            i8.k kVar2 = this.f8950a.get(kVar);
            if (kVar2 != null) {
                map.put(kVar, kVar2);
            }
        }
        return map;
    }

    @Override // g8.b
    public Map<h8.k, i8.k> b(h8.t tVar, int i10) {
        HashMap map = new HashMap();
        int iU = tVar.u() + 1;
        for (i8.k kVar : this.f8950a.tailMap(h8.k.n(tVar.h(""))).values()) {
            h8.k kVarB = kVar.b();
            if (!tVar.t(kVarB.s())) {
                break;
            }
            if (kVarB.s().u() == iU && kVar.c() > i10) {
                map.put(kVar.b(), kVar);
            }
        }
        return map;
    }

    @Override // g8.b
    public i8.k c(h8.k kVar) {
        return this.f8950a.get(kVar);
    }

    @Override // g8.b
    public void d(int i10) {
        if (this.f8951b.containsKey(Integer.valueOf(i10))) {
            Set<h8.k> set = this.f8951b.get(Integer.valueOf(i10));
            this.f8951b.remove(Integer.valueOf(i10));
            Iterator<h8.k> it = set.iterator();
            while (it.hasNext()) {
                this.f8950a.remove(it.next());
            }
        }
    }

    @Override // g8.b
    public void e(int i10, Map<h8.k, i8.f> map) {
        for (Map.Entry<h8.k, i8.f> entry : map.entrySet()) {
            g(i10, (i8.f) l8.x.d(entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // g8.b
    public Map<h8.k, i8.k> f(String str, int i10, int i11) {
        TreeMap treeMap = new TreeMap();
        for (i8.k kVar : this.f8950a.values()) {
            if (kVar.b().p().equals(str) && kVar.c() > i10) {
                Map map = (Map) treeMap.get(Integer.valueOf(kVar.c()));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(kVar.c()), map);
                }
                map.put(kVar.b(), kVar);
            }
        }
        HashMap map2 = new HashMap();
        Iterator it = treeMap.values().iterator();
        while (it.hasNext()) {
            map2.putAll((Map) it.next());
            if (map2.size() >= i11) {
                break;
            }
        }
        return map2;
    }

    public final void g(int i10, i8.f fVar) {
        i8.k kVar = this.f8950a.get(fVar.g());
        if (kVar != null) {
            this.f8951b.get(Integer.valueOf(kVar.c())).remove(fVar.g());
        }
        this.f8950a.put(fVar.g(), i8.k.a(i10, fVar));
        if (this.f8951b.get(Integer.valueOf(i10)) == null) {
            this.f8951b.put(Integer.valueOf(i10), new HashSet());
        }
        this.f8951b.get(Integer.valueOf(i10)).add(fVar.g());
    }
}
