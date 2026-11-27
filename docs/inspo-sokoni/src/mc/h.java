package mc;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static final <T> T[] a(T[] reference, int i10) {
        kotlin.jvm.internal.k.e(reference, "reference");
        Object objNewInstance = Array.newInstance(reference.getClass().getComponentType(), i10);
        kotlin.jvm.internal.k.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void b(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }
}
