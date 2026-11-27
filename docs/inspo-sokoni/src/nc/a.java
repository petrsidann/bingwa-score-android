package nc;

import kotlin.jvm.internal.k;
import xc.l;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final <T extends Comparable<?>> int a(T t10, T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    public static final <T> int b(T t10, T t11, l<? super T, ? extends Comparable<?>>... selectors) {
        k.e(selectors, "selectors");
        if (selectors.length > 0) {
            return c(t10, t11, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T> int c(T t10, T t11, l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iA = a(lVar.invoke(t10), lVar.invoke(t11));
            if (iA != 0) {
                return iA;
            }
        }
        return 0;
    }
}
