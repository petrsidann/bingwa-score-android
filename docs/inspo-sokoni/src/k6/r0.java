package k6;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public final class r0 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? i0.c() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        j6.m.o(comparator);
        j6.m.o(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof q0)) {
                return false;
            }
            comparator2 = ((q0) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
