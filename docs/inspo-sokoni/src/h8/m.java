package h8;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s7.c<k, h> f9747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s7.e<h> f9748b;

    public m(s7.c<k, h> cVar, s7.e<h> eVar) {
        this.f9747a = cVar;
        this.f9748b = eVar;
    }

    public static m i(final Comparator<h> comparator) {
        return new m(i.a(), new s7.e(Collections.emptyList(), new Comparator() { // from class: h8.l
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return m.o(comparator, (h) obj, (h) obj2);
            }
        }));
    }

    public static /* synthetic */ int o(Comparator comparator, h hVar, h hVar2) {
        int iCompare = comparator.compare(hVar, hVar2);
        return iCompare == 0 ? h.f9741a.compare(hVar, hVar2) : iCompare;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (size() != mVar.size()) {
            return false;
        }
        Iterator<h> it = iterator();
        Iterator<h> it2 = mVar.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public m h(h hVar) {
        m mVarQ = q(hVar.getKey());
        return new m(mVarQ.f9747a.l(hVar.getKey(), hVar), mVarQ.f9748b.i(hVar));
    }

    public int hashCode() {
        int iHashCode = 0;
        for (h hVar : this) {
            iHashCode = (((iHashCode * 31) + hVar.getKey().hashCode()) * 31) + hVar.a().hashCode();
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f9747a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<h> iterator() {
        return this.f9748b.iterator();
    }

    public h j(k kVar) {
        return this.f9747a.h(kVar);
    }

    public h k() {
        return this.f9748b.h();
    }

    public h l() {
        return this.f9748b.e();
    }

    public int n(k kVar) {
        h hVarH = this.f9747a.h(kVar);
        if (hVarH == null) {
            return -1;
        }
        return this.f9748b.indexOf(hVarH);
    }

    public m q(k kVar) {
        h hVarH = this.f9747a.h(kVar);
        return hVarH == null ? this : new m(this.f9747a.o(kVar), this.f9748b.k(hVarH));
    }

    public int size() {
        return this.f9747a.size();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        boolean z10 = true;
        for (h hVar : this) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(hVar);
        }
        sb2.append("]");
        return sb2.toString();
    }
}
