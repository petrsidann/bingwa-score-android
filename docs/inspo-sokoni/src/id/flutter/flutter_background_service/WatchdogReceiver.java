package id.flutter.flutter_background_service;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import e0.f;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WatchdogReceiver extends BroadcastReceiver {
    private static final String ACTION_RESPAWN = "id.flutter.background_service.RESPAWN";
    private static final int QUEUE_REQUEST_ID = 111;

    public static void enqueue(Context context) {
        enqueue(context, 5000);
    }

    public static void enqueue(Context context, int i10) {
        Intent intent = new Intent(context, (Class<?>) WatchdogReceiver.class);
        intent.setAction(ACTION_RESPAWN);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i11 = Build.VERSION.SDK_INT;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, QUEUE_REQUEST_ID, intent, i11 >= 31 ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) i10);
        if (i11 >= 33) {
            f.b(alarmManager, 0, jCurrentTimeMillis, broadcast);
        } else {
            f.c(alarmManager, 0, jCurrentTimeMillis, broadcast);
        }
    }

    public static void remove(Context context) {
        Intent intent = new Intent(context, (Class<?>) WatchdogReceiver.class);
        intent.setAction(ACTION_RESPAWN);
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, QUEUE_REQUEST_ID, intent, Build.VERSION.SDK_INT >= 31 ? 301989888 : 268435456));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_RESPAWN)) {
            Config config = new Config(context);
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER).iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                if (BackgroundService.class.getName().equals(it.next().service.getClassName())) {
                    z10 = true;
                }
            }
            if (config.isManuallyStopped() || z10) {
                return;
            }
            try {
                if (config.isForeground()) {
                    f0.a.startForegroundService(context, new Intent(context, (Class<?>) BackgroundService.class));
                } else {
                    context.getApplicationContext().startService(new Intent(context, (Class<?>) BackgroundService.class));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
