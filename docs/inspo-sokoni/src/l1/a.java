package l1;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<PowerManager.WakeLock> f12408a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f12409b = 1;

    public static boolean b(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f12408a;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }

    public static ComponentName c(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f12408a;
        synchronized (sparseArray) {
            int i10 = f12409b;
            int i11 = i10 + 1;
            f12409b = i11;
            if (i11 <= 0) {
                f12409b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i10);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(60000L);
            sparseArray.put(i10, wakeLockNewWakeLock);
            return componentNameStartService;
        }
    }
}
