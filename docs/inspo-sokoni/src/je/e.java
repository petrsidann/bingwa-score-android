package je;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null || obj2 == null || !(obj instanceof List) || !(obj2 instanceof List)) {
            return false;
        }
        List list = (List) obj;
        List list2 = (List) obj2;
        if (list.size() != list2.size()) {
            return false;
        }
        ArrayList arrayList = new ArrayList(list2);
        Iterator it = list.iterator();
        while (true) {
            boolean z10 = true;
            if (!it.hasNext()) {
                return true;
            }
            Object next = it.next();
            Iterator it2 = arrayList.iterator();
            do {
                if (!it2.hasNext()) {
                    z10 = false;
                    break;
                }
            } while (!d(next, it2.next()));
            if (!z10) {
                return false;
            }
            arrayList.remove(next);
        }
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null || obj2 == null || !(obj instanceof Map) || !(obj2 instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        Map map2 = (Map) obj2;
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            if (!map2.containsKey(key) || !d(entry.getValue(), map2.get(key))) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj instanceof Number) && (obj2 instanceof Number) && BigDecimal.valueOf(((Number) obj).doubleValue()).compareTo(BigDecimal.valueOf(((Number) obj2).doubleValue())) == 0;
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj2 != null) {
            if (obj.equals(obj2)) {
                return true;
            }
            if (obj instanceof Number) {
                if (obj2 instanceof Number) {
                    return c(obj, obj2);
                }
                return false;
            }
            if (obj instanceof List) {
                if (obj2 instanceof List) {
                    return a(obj, obj2);
                }
                return false;
            }
            if ((obj instanceof Map) && (obj2 instanceof Map)) {
                return b(obj, obj2);
            }
        }
        return false;
    }
}
