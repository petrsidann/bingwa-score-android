package k6;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f11599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set f11600b;

        /* JADX INFO: renamed from: k6.o0$a$a, reason: collision with other inner class name */
        public class C0199a extends k6.b<E> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<? extends E> f11601c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final Iterator<? extends E> f11602d;

            public C0199a() {
                this.f11601c = a.this.f11599a.iterator();
                this.f11602d = a.this.f11600b.iterator();
            }

            @Override // k6.b
            public E b() {
                if (this.f11601c.hasNext()) {
                    return this.f11601c.next();
                }
                while (this.f11602d.hasNext()) {
                    E next = this.f11602d.next();
                    if (!a.this.f11599a.contains(next)) {
                        return next;
                    }
                }
                return c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f11599a = set;
            this.f11600b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f11599a.contains(obj) || this.f11600b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public t0<E> iterator() {
            return new C0199a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f11599a.isEmpty() && this.f11600b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f11599a.size();
            Iterator<E> it = this.f11600b.iterator();
            while (it.hasNext()) {
                if (!this.f11599a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    public static abstract class b<E> extends AbstractSet<E> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean add(E e10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: renamed from: e */
        public abstract t0<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static <E> b<E> c(Set<? extends E> set, Set<? extends E> set2) {
        j6.m.p(set, "set1");
        j6.m.p(set2, "set2");
        return new a(set, set2);
    }
}
