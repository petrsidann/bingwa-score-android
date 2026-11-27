package aa;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.Window;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f423a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final boolean a(Context context) {
            k.e(context, "context");
            return Settings.canDrawOverlays(context);
        }

        public final boolean b(Context context) {
            k.e(context, "context");
            Object systemService = context.getSystemService("activity");
            k.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
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

        public final boolean c(Context context) {
            k.e(context, "context");
            Object systemService = context.getSystemService("power");
            k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            return ((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName());
        }

        public final void d(Context context, String str) {
            k.e(context, "context");
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                if (str != null) {
                    launchIntentForPackage.putExtra("route", str);
                }
                context.startActivity(launchIntentForPackage);
            }
        }

        public final void e(Activity activity) {
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
        }

        public final void f(Activity activity, int i10) {
            Intent intent = new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
            if (activity != null) {
                activity.startActivityForResult(intent, i10);
            }
        }

        public final void g(Activity activity, int i10, boolean z10) {
            if (activity != null) {
                Context applicationContext = activity.getApplicationContext();
                k.d(applicationContext, "getApplicationContext(...)");
                if (!a(applicationContext) || z10) {
                    Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                    intent.setData(Uri.parse("package:" + activity.getPackageName()));
                    activity.startActivityForResult(intent, i10);
                }
            }
        }

        public final void h(Activity activity, int i10) {
            if (activity != null) {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                activity.startActivityForResult(intent, i10);
            }
        }

        public final void i(Activity activity, boolean z10) {
            Window window;
            Window window2;
            if (Build.VERSION.SDK_INT >= 27) {
                if (activity != null) {
                    activity.setShowWhenLocked(z10);
                }
            } else {
                if (z10) {
                    if (activity == null || (window2 = activity.getWindow()) == null) {
                        return;
                    }
                    window2.addFlags(524288);
                    return;
                }
                if (activity == null || (window = activity.getWindow()) == null) {
                    return;
                }
                window.clearFlags(524288);
            }
        }

        public final void j(Context context) {
            k.e(context, "context");
            Object systemService = context.getSystemService("power");
            k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(805306378, "ForegroundServiceUtils:WakeLock");
            wakeLockNewWakeLock.acquire(1000L);
            wakeLockNewWakeLock.release();
        }
    }
}
