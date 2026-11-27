package mc;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends c0 {
    public static final int a(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        return i10 < 1073741824 ? (int) ((i10 / 0.75f) + 1.0f) : com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER;
    }

    public static final <K, V> Map<K, V> b(lc.i<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.k.e(pair, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(pair.c(), pair.d());
        kotlin.jvm.internal.k.d(mapSingletonMap, "singletonMap(...)");
        return mapSingletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.k.e(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.k.d(mapSingletonMap, "with(...)");
        return mapSingletonMap;
    }
}
