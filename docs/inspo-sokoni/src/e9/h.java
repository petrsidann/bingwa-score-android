package e9;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class h extends k implements Iterable<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<k> f7444a = new ArrayList<>();

    @Override // e9.k
    public boolean e() {
        return s().e();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f7444a.equals(this.f7444a));
    }

    public int hashCode() {
        return this.f7444a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f7444a.iterator();
    }

    @Override // e9.k
    public String k() {
        return s().k();
    }

    public void r(k kVar) {
        if (kVar == null) {
            kVar = m.f7445a;
        }
        this.f7444a.add(kVar);
    }

    public final k s() {
        int size = this.f7444a.size();
        if (size == 1) {
            return this.f7444a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
