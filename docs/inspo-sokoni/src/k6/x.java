package k6;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class x {
    public static <E> Collection<E> a(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : z.h(iterable.iterator());
    }

    public static <T> T b(Iterable<? extends T> iterable, T t10) {
        return (T) y.c(iterable.iterator(), t10);
    }

    public static Object[] c(Iterable<?> iterable) {
        return a(iterable).toArray();
    }
}
