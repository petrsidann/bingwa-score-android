package ke;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import le.d;
import le.e;
import le.f;
import le.g;
import le.h;
import me.leolin.shortcutbadger.impl.AdwHomeBadger;
import me.leolin.shortcutbadger.impl.ApexHomeBadger;
import me.leolin.shortcutbadger.impl.DefaultBadger;
import me.leolin.shortcutbadger.impl.NewHtcHomeBadger;
import me.leolin.shortcutbadger.impl.NovaHomeBadger;
import me.leolin.shortcutbadger.impl.SonyHomeBadger;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Class<? extends a>> f12362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f12364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ComponentName f12365d;

    static {
        LinkedList linkedList = new LinkedList();
        f12362a = linkedList;
        f12363b = new Object();
        linkedList.add(AdwHomeBadger.class);
        linkedList.add(ApexHomeBadger.class);
        linkedList.add(DefaultBadger.class);
        linkedList.add(NewHtcHomeBadger.class);
        linkedList.add(NovaHomeBadger.class);
        linkedList.add(SonyHomeBadger.class);
        linkedList.add(le.a.class);
        linkedList.add(le.c.class);
        linkedList.add(d.class);
        linkedList.add(e.class);
        linkedList.add(h.class);
        linkedList.add(f.class);
        linkedList.add(g.class);
        linkedList.add(le.b.class);
    }

    public static boolean a(Context context, int i10) {
        try {
            b(context, i10);
            return true;
        } catch (b e10) {
            if (!Log.isLoggable("ShortcutBadger", 3)) {
                return false;
            }
            Log.d("ShortcutBadger", "Unable to execute badge", e10);
            return false;
        }
    }

    public static void b(Context context, int i10) throws b {
        if (f12364c == null && !c(context)) {
            throw new b("No default launcher available");
        }
        try {
            f12364c.b(context, f12365d, i10);
        } catch (Exception e10) {
            throw new b("Unable to execute badge", e10);
        }
    }

    public static boolean c(Context context) {
        a gVar;
        a aVarNewInstance;
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            Log.e("ShortcutBadger", "Unable to find launch intent for package " + context.getPackageName());
            return false;
        }
        f12365d = launchIntentForPackage.getComponent();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            Iterator<Class<? extends a>> it2 = f12362a.iterator();
            while (it2.hasNext()) {
                try {
                    aVarNewInstance = it2.next().newInstance();
                } catch (Exception unused) {
                    aVarNewInstance = null;
                }
                if (aVarNewInstance != null && aVarNewInstance.a().contains(str)) {
                    f12364c = aVarNewInstance;
                    break;
                }
            }
            if (f12364c != null) {
                break;
            }
        }
        if (f12364c != null) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equalsIgnoreCase("ZUK")) {
            gVar = new h();
        } else if (str2.equalsIgnoreCase("OPPO")) {
            gVar = new d();
        } else if (str2.equalsIgnoreCase("VIVO")) {
            gVar = new f();
        } else {
            gVar = str2.equalsIgnoreCase("ZTE") ? new g() : new DefaultBadger();
        }
        f12364c = gVar;
        return true;
    }
}
