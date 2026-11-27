package fe;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8410e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8411f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f8412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m f8413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<c> f8414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, j> f8415o;

    public static List<c> R(Map<String, Object> map) {
        if (!map.containsKey("actionButtons")) {
            return null;
        }
        Object obj = map.get("actionButtons");
        if (!(obj instanceof List)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            if (!(obj2 instanceof Map)) {
                return null;
            }
            Map<String, Object> map2 = (Map) obj2;
            if (!map2.isEmpty()) {
                arrayList.add(new c().b(map2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static g S(Map<String, Object> map) {
        if (!map.containsKey("content")) {
            return null;
        }
        Object obj = map.get("content");
        if (!(obj instanceof Map)) {
            return null;
        }
        Map<String, Object> map2 = (Map) obj;
        if (map2.isEmpty()) {
            return null;
        }
        return new g().b(map2);
    }

    public static m U(Map<String, Object> map) {
        if (!map.containsKey("schedule")) {
            return null;
        }
        Object obj = map.get("schedule");
        if (obj instanceof Map) {
            return m.S((Map) obj);
        }
        return null;
    }

    @Override // fe.a
    public String N() {
        return M();
    }

    @Override // fe.a
    public Map<String, Object> O() {
        if (this.f8412l == null) {
            return null;
        }
        HashMap map = new HashMap();
        C("content", map, this.f8412l);
        C("schedule", map, this.f8413m);
        F("actionButtons", map, this.f8414n);
        H("localizations", map, this.f8415o);
        return map;
    }

    @Override // fe.a
    public void P(Context context) {
        g gVar = this.f8412l;
        if (gVar == null) {
            throw ae.b.e().c("NotificationModel", "INVALID_ARGUMENTS", "Notification content is required", "arguments.invalid.notificationContent");
        }
        gVar.P(context);
        m mVar = this.f8413m;
        if (mVar != null) {
            mVar.P(context);
        }
        List<c> list = this.f8414n;
        if (list != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                it.next().P(context);
            }
        }
    }

    public l Q() {
        return new l().b(O());
    }

    public final Map<String, j> T(Map<String, Object> map) {
        Map map2;
        if (!map.containsKey("localizations")) {
            return null;
        }
        Object obj = map.get("localizations");
        if (!(obj instanceof Map) || (map2 = (Map) obj) == null) {
            return null;
        }
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            if (entry.getValue() instanceof Map) {
                j jVarB = new j().b((Map) entry.getValue());
                if (jVarB != null) {
                    map3.put((String) entry.getKey(), jVarB);
                }
            }
        }
        if (map3.isEmpty()) {
            return null;
        }
        return map3;
    }

    @Override // fe.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public l a(String str) {
        return (l) super.L(str);
    }

    @Override // fe.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public l b(Map<String, Object> map) {
        g gVarS = S(map);
        this.f8412l = gVarS;
        if (gVarS == null) {
            return null;
        }
        this.f8413m = U(map);
        this.f8414n = R(map);
        this.f8415o = T(map);
        return this;
    }
}
