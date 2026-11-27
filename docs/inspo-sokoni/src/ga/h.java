package ga;

import ea.c0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static Map<String, Object> a(e eVar) {
        c0 c0VarD = eVar.d();
        if (c0VarD == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("sql", c0VarD.c());
        map.put("arguments", c0VarD.b());
        return map;
    }
}
