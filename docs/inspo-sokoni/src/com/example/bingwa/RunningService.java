package com.example.bingwa;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.appengineer.bingwa.R;
import e0.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class RunningService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3534a = new b(null);

    public enum a {
        START,
        STOP;


        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ rc.a f3538d = rc.b.a(d());
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    public final void a() {
        NotificationChannel notificationChannel = new NotificationChannel("running_channel", "Bingwa Background Service", 2);
        notificationChannel.setDescription("Channel for Bingwa background service");
        notificationChannel.setSound(null, null);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public final void b() {
        a();
        Notification notificationC = new q.e(this, "running_channel").n("Bingwa is active").m("Running in the background").H(R.drawable.ic_launcher).J(null).B(-1).g("service").c();
        k.d(notificationC, "build(...)");
        startForeground(10, notificationC);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        String action = intent != null ? intent.getAction() : null;
        if (k.a(action, a.START.toString())) {
            b();
            return 1;
        }
        if (!k.a(action, a.STOP.toString())) {
            return 1;
        }
        stopSelf();
        return 1;
    }
}
