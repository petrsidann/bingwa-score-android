package mc;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {
    public static final <T> Set<T> a(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        kotlin.jvm.internal.k.d(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
