package com.example.bingwa;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import com.appengineer.bingwa.R;
import e0.l1;
import e0.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class MyForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3532a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final Notification a() {
        Notification notificationC = new q.e(this, "my_foreground_service").n("Service Running").m("Listening for incoming messages").H(R.drawable.ic_launcher).B(-1).g("service").z(true).c();
        k.d(notificationC, "build(...)");
        return notificationC;
    }

    public final void b() {
        NotificationChannel notificationChannel = new NotificationChannel("my_foreground_service", "Foreground Service", 2);
        notificationChannel.setDescription("Channel for MyForegroundService");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public final void c() {
        Object systemService = getSystemService("alarm");
        k.c(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).setRepeating(2, ((long) 300000) + SystemClock.elapsedRealtime(), 300000L, PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) AlarmReceiver.class), 201326592));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(1);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        b();
        startForeground(100, a());
        if (Build.VERSION.SDK_INT >= 29) {
            l1.a(this, 100, a(), 1);
        } else {
            startForeground(100, a());
        }
        c();
        return 1;
    }
}
