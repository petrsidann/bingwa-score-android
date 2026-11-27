package td;

import android.content.Context;
import android.content.Intent;
import fe.l;
import je.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15933a = "ScheduledNotificationReceiver";

    @Override // td.a
    public void b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("notificationJson");
        if (o.c().e(stringExtra).booleanValue()) {
            return;
        }
        try {
            l lVarA = new l().a(stringExtra);
            if (lVarA == null) {
                return;
            }
            ie.c.l(context, vd.b.m(), rd.a.D(), lVarA, null);
            if (lVarA.f8413m.f8418l.booleanValue()) {
                ie.b.t(context, lVarA, intent, null);
            } else {
                ie.b.l(context, lVarA);
                if (rd.a.f15359i.booleanValue()) {
                    de.a.a(f15933a, "Schedule " + lVarA.f8412l.f8380l.toString() + " finished since repeat option is off");
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
