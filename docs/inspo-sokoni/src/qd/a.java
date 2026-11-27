package qd;

import android.content.Context;
import me.carda.awesome_notifications.DartBackgroundService;
import me.carda.awesome_notifications.DartDismissedNotificationReceiver;
import me.carda.awesome_notifications.DartNotificationActionReceiver;
import me.carda.awesome_notifications.DartScheduledNotificationReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class a extends rd.b {
    public static void b() {
        if (rd.a.f15365o != null) {
            return;
        }
        rd.a.f15360j = DartNotificationActionReceiver.class;
        rd.a.f15361k = DartDismissedNotificationReceiver.class;
        rd.a.f15362l = DartScheduledNotificationReceiver.class;
        rd.a.f15363m = DartBackgroundService.class;
        rd.a.f15365o = new a();
        if (rd.a.f15359i.booleanValue()) {
            de.a.a("AwesomeNotificationsFlutterExtension", "Flutter extensions attached to Awesome Notification's core.");
        }
    }

    @Override // rd.b
    public void a(Context context) {
        d.o();
        sd.a.d(c.class);
    }
}
