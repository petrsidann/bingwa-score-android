package com.phan_tech.ussd_advanced;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import e0.q;
import java.util.List;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class USSDForegroundService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6039b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6040c;

    public static final class a implements b.a {
        public a() {
        }

        @Override // com.phan_tech.ussd_advanced.b.a
        public void a(String message) {
            k.e(message, "message");
            try {
                Log.d("USSDForegroundService", "USSD session completed: " + message);
                USSDForegroundService.this.stopSelf();
            } catch (Exception e10) {
                Log.e("USSDForegroundService", "Error completing USSD session: " + e10.getMessage());
                USSDForegroundService.this.stopSelf();
            }
        }

        @Override // com.phan_tech.ussd_advanced.b.a
        public void b(AccessibilityEvent ev) {
            k.e(ev, "ev");
            try {
                if (USSDForegroundService.this.f6040c) {
                    return;
                }
                List<CharSequence> text = ev.getText();
                k.d(text, "getText(...)");
                if (!text.isEmpty()) {
                    Log.d("USSDForegroundService", "USSD response: " + ev.getText());
                    USSDForegroundService.this.f6040c = true;
                }
            } catch (Exception e10) {
                Log.e("USSDForegroundService", "Error processing USSD response: " + e10.getMessage());
            }
        }
    }

    public final void c() {
        NotificationChannel notificationChannel = new NotificationChannel("USSD_CHANNEL_ID", "USSD Service Channel", 2);
        notificationChannel.setDescription("Notifications for USSD service");
        Object systemService = getSystemService("notification");
        k.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    public final void d(String str, int i10) {
        if (i10 == -1) {
            i10 = 0;
        }
        try {
            b.f6045a.c(this, str, i10, new a());
        } catch (Exception e10) {
            Log.e("USSDForegroundService", "Error initiating USSD request: " + e10.getMessage());
            stopSelf();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        this.f6038a = intent != null ? intent.getStringExtra("ussd_code") : null;
        this.f6039b = intent != null ? intent.getIntExtra("subscription_id", -1) : -1;
        String str = this.f6038a;
        if (str == null || str.length() == 0) {
            Log.e("USSDForegroundService", "Invalid USSD code");
            stopSelf();
            return 2;
        }
        Notification notificationC = new q.e(this, "USSD_CHANNEL_ID").n("USSD Service").m("Running USSD request: " + this.f6038a).H(R.drawable.ic_dialog_info).c();
        k.d(notificationC, "build(...)");
        startForeground(1, notificationC);
        String str2 = this.f6038a;
        k.b(str2);
        d(str2, this.f6039b);
        return 2;
    }
}
