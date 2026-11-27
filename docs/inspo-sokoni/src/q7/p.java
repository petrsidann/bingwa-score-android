package q7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class p {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q7.c<?> f14878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<b> f14879b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<b> f14880c = new HashSet();

        public b(q7.c<?> cVar) {
            this.f14878a = cVar;
        }

        public void a(b bVar) {
            this.f14879b.add(bVar);
        }

        public void b(b bVar) {
            this.f14880c.add(bVar);
        }

        public q7.c<?> c() {
            return this.f14878a;
        }

        public Set<b> d() {
            return this.f14879b;
        }

        public boolean e() {
            return this.f14879b.isEmpty();
        }

        public boolean f() {
            return this.f14880c.isEmpty();
        }

        public void g(b bVar) {
            this.f14880c.remove(bVar);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e0<?> f14881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14882b;

        public c(e0<?> e0Var, boolean z10) {
            this.f14881a = e0Var;
            this.f14882b = z10;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f14881a.equals(this.f14881a) && cVar.f14882b == this.f14882b;
        }

        public int hashCode() {
            return ((this.f14881a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f14882b).hashCode();
        }
    }

    public static void a(List<q7.c<?>> list) {
        Set<b> setC = c(list);
        Set<b> setB = b(setC);
        int i10 = 0;
        while (!setB.isEmpty()) {
            b next = setB.iterator().next();
            setB.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    setB.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : setC) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new r(arrayList);
    }

    public static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set<b> c(List<q7.c<?>> list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator<q7.c<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (q qVar : bVar.c().g()) {
                            if (qVar.e() && (set = (Set) map.get(new c(qVar.c(), qVar.g()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            q7.c<?> next = it.next();
            b bVar3 = new b(next);
            for (e0<? super Object> e0Var : next.j()) {
                c cVar = new c(e0Var, !next.p());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.f14882b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", e0Var));
                }
                set2.add(bVar3);
            }
        }
    }
}
