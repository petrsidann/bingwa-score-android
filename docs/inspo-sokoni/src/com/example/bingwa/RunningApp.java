package com.example.bingwa;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class RunningApp extends Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3533a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final void a() {
        NotificationChannel notificationChannel = new NotificationChannel("running_channel", "Running Notifications", 2);
        notificationChannel.setDescription("Notifications for background running services.");
        Object systemService = getSystemService("notification");
        k.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a();
    }
}
