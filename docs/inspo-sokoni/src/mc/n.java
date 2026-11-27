package mc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static final <T> Object[] a(T[] tArr, boolean z10) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        if (z10 && kotlin.jvm.internal.k.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(...)");
        return objArrCopyOf;
    }

    public static final <T> List<T> b(T t10) {
        List<T> listSingletonList = Collections.singletonList(t10);
        kotlin.jvm.internal.k.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.k.e(iterable, "<this>");
        List<T> listN = w.N(iterable);
        Collections.shuffle(listN);
        return listN;
    }

    public static final <T> T[] d(int i10, T[] array) {
        kotlin.jvm.internal.k.e(array, "array");
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }
}
