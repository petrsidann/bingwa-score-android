package k6;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends t0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f11637b;

        public a(Object obj) {
            this.f11637b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f11636a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f11636a) {
                throw new NoSuchElementException();
            }
            this.f11636a = true;
            return (T) this.f11637b;
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        j6.m.o(collection);
        j6.m.o(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static boolean b(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !j6.i.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> T c(Iterator<? extends T> it, T t10) {
        return it.hasNext() ? it.next() : t10;
    }

    public static <T> t0<T> d(T t10) {
        return new a(t10);
    }
}
