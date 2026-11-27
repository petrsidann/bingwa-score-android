package je;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    public class a extends o6.b<Map<String, Object>> {
    }

    public static String a(Object obj) {
        if (obj == null) {
            return "null";
        }
        e9.e eVar = new e9.e();
        if ((obj instanceof Map) || (obj instanceof List)) {
            return d(obj);
        }
        return ((obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof String)) ? eVar.r(obj) : "null";
    }

    public static String b(List<Object> list) {
        if (list == null) {
            return "null";
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return "[" + f(arrayList) + "]";
    }

    public static String c(Map<String, Object> map) {
        if (map == null) {
            return "null";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList(map.keySet());
        Collections.sort(arrayList2);
        for (String str : arrayList2) {
            Object obj = map.get(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\"");
            sb2.append(str);
            sb2.append("\":");
            if (obj == null) {
                sb2.append("null");
            } else {
                sb2.append(d(obj));
            }
            arrayList.add(sb2.toString());
        }
        return "{" + f(arrayList) + "}";
    }

    public static String d(Object obj) {
        String strB;
        if (obj == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        if (obj instanceof Map) {
            strB = c((Map) obj);
        } else {
            strB = obj instanceof List ? b((List) obj) : a(obj);
        }
        sb2.append(strB);
        return sb2.toString();
    }

    public static Map<String, Object> e(String str) {
        return (Map) new e9.e().h(str, new a().b());
    }

    public static String f(List<String> list) {
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 < size) {
            sb2.append(list.get(i10));
            sb2.append(",");
            i10++;
        }
        sb2.append(list.get(i10));
        return sb2.toString();
    }

    public static String g(Map<String, Object> map) {
        return d(map);
    }
}
