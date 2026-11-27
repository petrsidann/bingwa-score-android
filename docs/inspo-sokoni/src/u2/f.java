package u2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static Map<String, Object> a(int i10, String str) {
        HashMap map = new HashMap();
        map.put("type", Integer.valueOf(i10));
        map.put("message", str);
        return map;
    }
}
