package me;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static List<ResolveInfo> a(Context context, Intent intent) {
        List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        return listQueryBroadcastReceivers != null ? listQueryBroadcastReceivers : Collections.emptyList();
    }

    public static void b(Context context, Intent intent) throws ke.b {
        boolean z10;
        Intent intent2 = new Intent(intent);
        intent2.setAction("me.leolin.shortcutbadger.BADGE_COUNT_UPDATE");
        try {
            c(context, intent2);
            z10 = true;
        } catch (ke.b unused) {
            z10 = false;
        }
        if (z10) {
            return;
        }
        c(context, intent);
    }

    public static void c(Context context, Intent intent) throws ke.b {
        List<ResolveInfo> listA = a(context, intent);
        if (listA.size() == 0) {
            throw new ke.b("unable to resolve intent: " + intent.toString());
        }
        for (ResolveInfo resolveInfo : listA) {
            Intent intent2 = new Intent(intent);
            if (resolveInfo != null) {
                intent2.setPackage(resolveInfo.resolvePackageName);
                context.sendBroadcast(intent2);
            }
        }
    }
}
