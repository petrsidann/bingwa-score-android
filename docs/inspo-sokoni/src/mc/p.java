package mc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class p extends o {
    public static final <T> int m(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }

    public static final <T> List<T> n(Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            t.o(arrayList, it.next());
        }
        return arrayList;
    }
}
