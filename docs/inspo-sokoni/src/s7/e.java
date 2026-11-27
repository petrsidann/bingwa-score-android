package s7;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<T, Void> f15596a;

    public static class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<T, Void>> f15597a;

        public a(Iterator<Map.Entry<T, Void>> it) {
            this.f15597a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15597a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f15597a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f15597a.remove();
        }
    }

    public e(List<T> list, Comparator<T> comparator) {
        this.f15596a = c.a.b(list, Collections.emptyMap(), c.a.d(), comparator);
    }

    public e(c<T, Void> cVar) {
        this.f15596a = cVar;
    }

    public boolean contains(T t10) {
        return this.f15596a.e(t10);
    }

    public T e() {
        return this.f15596a.j();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f15596a.equals(((e) obj).f15596a);
        }
        return false;
    }

    public T h() {
        return this.f15596a.k();
    }

    public int hashCode() {
        return this.f15596a.hashCode();
    }

    public e<T> i(T t10) {
        return new e<>(this.f15596a.l(t10, null));
    }

    public int indexOf(T t10) {
        return this.f15596a.indexOf(t10);
    }

    public boolean isEmpty() {
        return this.f15596a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f15596a.iterator());
    }

    public Iterator<T> j(T t10) {
        return new a(this.f15596a.n(t10));
    }

    public e<T> k(T t10) {
        c<T, Void> cVarO = this.f15596a.o(t10);
        return cVarO == this.f15596a ? this : new e<>(cVarO);
    }

    public e<T> l(e<T> eVar) {
        e<T> eVarI;
        if (size() < eVar.size()) {
            eVarI = eVar;
            eVar = this;
        } else {
            eVarI = this;
        }
        Iterator<T> it = eVar.iterator();
        while (it.hasNext()) {
            eVarI = eVarI.i(it.next());
        }
        return eVarI;
    }

    public int size() {
        return this.f15596a.size();
    }
}
