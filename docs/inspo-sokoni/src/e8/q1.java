package e8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f7305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<h8.q> f7306b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<i8.e> f7307c = new ArrayList<>();

    public q1(u1 u1Var) {
        this.f7305a = u1Var;
    }

    public void b(h8.q qVar) {
        this.f7306b.add(qVar);
    }

    public void c(h8.q qVar, i8.p pVar) {
        this.f7307c.add(new i8.e(qVar, pVar));
    }

    public boolean d(h8.q qVar) {
        Iterator<h8.q> it = this.f7306b.iterator();
        while (it.hasNext()) {
            if (qVar.t(it.next())) {
                return true;
            }
        }
        Iterator<i8.e> it2 = this.f7307c.iterator();
        while (it2.hasNext()) {
            if (qVar.t(it2.next().a())) {
                return true;
            }
        }
        return false;
    }

    public List<i8.e> e() {
        return this.f7307c;
    }

    public r1 f() {
        return new r1(this, h8.q.f9758c, false, null);
    }

    public s1 g(h8.s sVar) {
        return new s1(sVar, i8.d.b(this.f7306b), Collections.unmodifiableList(this.f7307c));
    }

    public s1 h(h8.s sVar, i8.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (i8.e eVar : this.f7307c) {
            if (dVar.a(eVar.a())) {
                arrayList.add(eVar);
            }
        }
        return new s1(sVar, dVar, Collections.unmodifiableList(arrayList));
    }

    public s1 i(h8.s sVar) {
        return new s1(sVar, null, Collections.unmodifiableList(this.f7307c));
    }

    public t1 j(h8.s sVar) {
        return new t1(sVar, i8.d.b(this.f7306b), Collections.unmodifiableList(this.f7307c));
    }
}
