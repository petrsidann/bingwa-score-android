package mc;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class j extends i {
    public static final <T> List<T> c(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        List<T> listA = l.a(tArr);
        kotlin.jvm.internal.k.d(listA, "asList(...)");
        return listA;
    }

    public static final byte[] d(byte[] bArr, byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static final <T> T[] e(T[] tArr, T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return d(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return e(objArr, objArr2, i10, i11, i12);
    }

    public static final byte[] h(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        h.b(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.k.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static final <T> void i(T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }
}
