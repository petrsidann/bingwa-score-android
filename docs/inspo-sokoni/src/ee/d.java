package ee;

import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<fe.e> f7940a = new o<>(je.o.c(), "ChannelGroupManager", fe.e.class, "NotificationChannelGroup");

    public static fe.e a(Context context, String str) {
        return (fe.e) f7940a.c(context, "channelGroup", str);
    }

    public static void b(Context context, fe.e eVar) {
        try {
            eVar.P(context);
            c(context, eVar);
            f7940a.h(context, "channelGroup", eVar.f8358f, eVar);
        } catch (ae.a e10) {
            e10.printStackTrace();
        }
    }

    public static void c(Context context, fe.e eVar) {
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannelGroup(new NotificationChannelGroup(eVar.f8358f, eVar.f8357e));
    }
}
