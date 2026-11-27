package pe;

import kotlin.jvm.internal.k;
import oe.q;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a(int[] iArr, int i10, int i11, int i12) {
        k.e(iArr, "<this>");
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int i15 = iArr[i14];
            if (i15 < i10) {
                i11 = i14 + 1;
            } else {
                if (i15 <= i10) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return (-i11) - 1;
    }

    public static final int b(q qVar, int i10) {
        k.e(qVar, "<this>");
        int iA = a(qVar.E(), i10 + 1, 0, qVar.F().length);
        return iA >= 0 ? iA : ~iA;
    }
}
