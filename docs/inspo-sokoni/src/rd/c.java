package rd;

import java.util.HashMap;
import java.util.Map;
import je.d;
import zd.e;
import zd.f;
import zd.i;
import zd.j;
import zd.n;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f15379a = new a();

    public class a extends HashMap<String, Object> {
        public a() {
            Boolean bool = Boolean.TRUE;
            put("repeats", bool);
            put("id", 0);
            put("importance", i.Default);
            put("notificationLayout", j.Default);
            put("groupSort", f.Desc);
            put("groupAlertBehavior", e.All);
            put("defaultPrivacy", n.Private);
            put("channelDescription", "Notifications");
            put("channelName", "Notifications");
            Boolean bool2 = Boolean.FALSE;
            put("channelShowBadge", bool2);
            put("displayOnForeground", bool);
            put("displayOnBackground", bool);
            put("hideLargeIconOnExpand", bool2);
            put("enabled", bool);
            put("showWhen", bool);
            put("requireInputText", bool2);
            put("actionType", zd.a.Default);
            put("payload", null);
            put("enableVibration", bool);
            put("defaultColor", -16777216);
            put("ledColor", -1);
            put("enableLights", bool);
            put("ledOffMs", 700);
            put("ledOnMs", 300);
            put("playSound", bool);
            put("autoDismissible", bool);
            put("defaultRingtoneType", zd.b.Notification);
            put("timeZone", d.g().h().toString());
            put("allowWhileIdle", bool2);
            put("onlyAlertOnce", bool2);
            put("showInCompactView", bool);
            put("isDangerousOption", bool2);
            put("wakeUpScreen", bool2);
            put("criticalAlerts", bool2);
            put("roundedLargeIcon", bool2);
            put("roundedBigPicture", bool2);
        }
    }
}
