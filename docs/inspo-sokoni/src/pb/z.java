package pb;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static FirebaseMessaging a(Map<String, Object> map) {
        return FirebaseMessaging.s();
    }

    public static com.google.firebase.messaging.d b(Map<String, Object> map) {
        Object obj = map.get("message");
        Objects.requireNonNull(obj);
        Map map2 = (Map) obj;
        Object obj2 = map2.get("to");
        Objects.requireNonNull(obj2);
        com.google.firebase.messaging.d.b bVar = new com.google.firebase.messaging.d.b((String) obj2);
        String str = (String) map2.get("collapseKey");
        String str2 = (String) map2.get("messageId");
        String str3 = (String) map2.get("messageType");
        Integer num = (Integer) map2.get("ttl");
        Map<String, String> map3 = (Map) map2.get("data");
        if (str != null) {
            bVar.b(str);
        }
        if (str3 != null) {
            bVar.e(str3);
        }
        if (str2 != null) {
            bVar.d(str2);
        }
        if (num != null) {
            bVar.f(num.intValue());
        }
        if (map3 != null) {
            bVar.c(map3);
        }
        return bVar.a();
    }

    public static Map<String, Object> c(Map<String, Object> map) {
        Object obj = map.get("message");
        Objects.requireNonNull(obj);
        Map map2 = (Map) obj;
        if (map2.get("notification") == null) {
            return null;
        }
        return (Map) map2.get("notification");
    }

    public static boolean d(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        if ((keyguardManager != null && keyguardManager.isKeyguardLocked()) || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static Map<String, Object> e(com.google.firebase.messaging.d.c cVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (cVar.p() != null) {
            map.put("title", cVar.p());
        }
        if (cVar.r() != null) {
            map.put("titleLocKey", cVar.r());
        }
        if (cVar.q() != null) {
            map.put("titleLocArgs", Arrays.asList(cVar.q()));
        }
        if (cVar.a() != null) {
            map.put("body", cVar.a());
        }
        if (cVar.c() != null) {
            map.put("bodyLocKey", cVar.c());
        }
        if (cVar.b() != null) {
            map.put("bodyLocArgs", Arrays.asList(cVar.b()));
        }
        if (cVar.d() != null) {
            map2.put("channelId", cVar.d());
        }
        if (cVar.e() != null) {
            map2.put("clickAction", cVar.e());
        }
        if (cVar.f() != null) {
            map2.put("color", cVar.f());
        }
        if (cVar.g() != null) {
            map2.put("smallIcon", cVar.g());
        }
        if (cVar.h() != null) {
            map2.put("imageUrl", cVar.h().toString());
        }
        if (cVar.i() != null) {
            map2.put("link", cVar.i().toString());
        }
        if (cVar.k() != null) {
            map2.put("count", cVar.k());
        }
        if (cVar.l() != null) {
            map2.put("priority", cVar.l());
        }
        if (cVar.m() != null) {
            map2.put("sound", cVar.m());
        }
        if (cVar.o() != null) {
            map2.put("ticker", cVar.o());
        }
        if (cVar.s() != null) {
            map2.put("visibility", cVar.s());
        }
        if (cVar.n() != null) {
            map2.put("tag", cVar.n());
        }
        map.put("android", map2);
        return map;
    }

    public static Map<String, Object> f(com.google.firebase.messaging.d dVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        if (dVar.S() != null) {
            map.put("collapseKey", dVar.S());
        }
        if (dVar.U() != null) {
            map.put("from", dVar.U());
        }
        if (dVar.b0() != null) {
            map.put("to", dVar.b0());
        }
        if (dVar.V() != null) {
            map.put("messageId", dVar.V());
        }
        if (dVar.X() != null) {
            map.put("messageType", dVar.X());
        }
        if (dVar.T().size() > 0) {
            for (Map.Entry<String, String> entry : dVar.T().entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        map.put("data", map2);
        map.put("ttl", Integer.valueOf(dVar.c0()));
        map.put("sentTime", Long.valueOf(dVar.a0()));
        if (dVar.Y() != null) {
            map.put("notification", e(dVar.Y()));
        }
        return map;
    }
}
