package td;

import android.content.Context;
import android.content.Intent;
import me.carda.awesome_notifications.core.managers.StatusBarManager;
import zd.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f15930a = "DismissedNotificationReceiver";

    @Override // td.a
    public void b(Context context, Intent intent) throws ae.a {
        ge.a aVarA;
        String action = intent.getAction();
        if (action == null || !action.equals("DISMISSED_NOTIFICATION")) {
            return;
        }
        k kVarD = rd.a.D();
        try {
            aVarA = vd.b.m().a(context, intent, kVarD);
        } catch (ae.a e10) {
            e10.printStackTrace();
            aVarA = null;
        }
        if (aVarA == null) {
            if (rd.a.f15359i.booleanValue()) {
                de.a.d(f15930a, "The action received do not contain any awesome notification data and was discarded");
            }
        } else {
            aVarA.e0(kVarD);
            StatusBarManager.k(context).E(context, aVarA.f8380l.intValue());
            ud.a.c().h(context, aVarA);
        }
    }
}
