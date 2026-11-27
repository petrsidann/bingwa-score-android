package com.example.bingwa;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Telephony;
import android.util.Log;
import com.example.bingwa.MainActivity;
import fb.i;
import fb.j;
import fb.q;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import mc.w;
import ra.d;

/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f3530l = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PowerManager.WakeLock f3531f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void X(MainActivity mainActivity, i call, j.d result) {
        k.e(call, "call");
        k.e(result, "result");
        Log.d("MainActivity", "Method call received: " + call.f8284a);
        String str = call.f8284a;
        if (str != null) {
            switch (str.hashCode()) {
                case -2096263152:
                    if (str.equals("stopForegroundService")) {
                        mainActivity.e0(result);
                        return;
                    }
                    break;
                case -675127954:
                    if (str.equals("launchApp")) {
                        mainActivity.c0((String) call.a("packageName"), result);
                        return;
                    }
                    break;
                case 1207771056:
                    if (str.equals("startForegroundService")) {
                        mainActivity.d0(result);
                        return;
                    }
                    break;
                case 1247457527:
                    if (str.equals("sendUSSD")) {
                        mainActivity.a0((String) call.a("code"), (Integer) call.a("slot"), result);
                        return;
                    }
                    break;
                case 1316768351:
                    if (str.equals("startApp")) {
                        mainActivity.b0(result);
                        return;
                    }
                    break;
                case 1872803484:
                    if (str.equals("saveSms")) {
                        mainActivity.Y((String) call.a("address"), (String) call.a("body"), result);
                        return;
                    }
                    break;
                case 1979901105:
                    if (str.equals("sendSMS")) {
                        mainActivity.Z((List) call.a("receiver"), (String) call.a("message"), result);
                        return;
                    }
                    break;
            }
        }
        Log.d("MainActivity", "Method not implemented: " + call.f8284a);
        result.c();
    }

    public final void Y(String str, String str2, j.d dVar) {
        if (str == null || str2 == null) {
            dVar.b("INVALID_ARGUMENT", "Address or body is null", null);
            return;
        }
        try {
            Context applicationContext = getApplicationContext();
            k.d(applicationContext, "getApplicationContext(...)");
            j0(applicationContext, str, str2);
            dVar.a(null);
        } catch (Exception e10) {
            Log.e("MainActivity", "Failed to save SMS", e10);
            dVar.b("SAVE_SMS_FAILED", "Failed to save SMS", e10);
        }
    }

    public final void Z(List<String> list, String str, j.d dVar) {
        List<String> list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            if (!(str == null || str.length() == 0)) {
                String strA = w.A(list, ",", null, null, 0, null, null, 62, null);
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("smsto:" + strA));
                intent.putExtra("sms_body", str);
                try {
                    startActivity(intent);
                    dVar.a("SMS Intent Opened");
                    return;
                } catch (Exception e10) {
                    Log.e("MainActivity", "Error opening SMS app: " + e10.getLocalizedMessage());
                    dVar.b("ERROR", "Failed to open SMS app", e10.getLocalizedMessage());
                    return;
                }
            }
        }
        dVar.b("INVALID_ARGUMENTS", "Receiver list or message is empty", null);
    }

    public final void a0(String str, Integer num, j.d dVar) {
        if (str == null) {
            dVar.b("INVALID_ARGUMENT", "USSD code cannot be null", null);
            return;
        }
        try {
            if (num != null) {
                l0(str, num.intValue());
            } else {
                k0(str);
            }
            dVar.a("USSD code sent");
        } catch (Exception e10) {
            Log.e("MainActivity", "Error sending USSD: " + e10.getMessage(), e10);
            dVar.b("USSD_ERROR", e10.getMessage(), null);
        }
    }

    public final void b0(j.d dVar) {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
        }
        startActivity(launchIntentForPackage);
        dVar.a(null);
    }

    public final void c0(String str, j.d dVar) {
        if (str == null || str.length() == 0) {
            dVar.b("INVALID_ARGUMENTS", "Package name is null", null);
            return;
        }
        try {
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                getContext().startActivity(launchIntentForPackage);
                dVar.a("App started successfully");
            } else {
                dVar.b("APP_NOT_FOUND", "No launch intent found for package: " + str, null);
            }
        } catch (Exception e10) {
            Log.e("MainActivity", "Error starting app: " + e10.getMessage());
            dVar.b("ACTIVITY_NOT_FOUND", e10.getMessage(), null);
        }
    }

    public final void d0(j.d dVar) {
        startForegroundService(new Intent(this, (Class<?>) MyForegroundService.class));
        dVar.a(null);
    }

    public final void e0(j.d dVar) {
        stopService(new Intent(this, (Class<?>) MyForegroundService.class));
        dVar.a(null);
    }

    public final boolean f0(Context context) {
        return k.a(Telephony.Sms.getDefaultSmsPackage(context), context.getPackageName());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void g0(Context context) {
        ComponentName componentName;
        Intent intent = new Intent();
        try {
            String MANUFACTURER = Build.MANUFACTURER;
            k.d(MANUFACTURER, "MANUFACTURER");
            Locale ROOT = Locale.ROOT;
            k.d(ROOT, "ROOT");
            String lowerCase = MANUFACTURER.toLowerCase(ROOT);
            k.d(lowerCase, "toLowerCase(...)");
            switch (lowerCase.hashCode()) {
                case -1206476313:
                    componentName = !lowerCase.equals("huawei") ? null : new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                    break;
                case -759499589:
                    if (lowerCase.equals("xiaomi")) {
                        componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
                    }
                    break;
                case 3418016:
                    if (lowerCase.equals("oppo")) {
                        componentName = new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity");
                    }
                    break;
                case 3620012:
                    if (lowerCase.equals("vivo")) {
                        componentName = new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                    }
                    break;
                default:
                    break;
            }
            intent.setComponent(componentName);
            if (intent.getComponent() != null) {
                startActivity(intent);
                context.getSharedPreferences("auto_start_prefs", 0).edit().putBoolean("is_auto_start_enabled", true).apply();
            }
        } catch (Exception e10) {
            Log.e("MainActivity", "Error requesting auto-start permission: " + e10.getMessage(), e10);
        }
    }

    public final void h0(Context context) {
        if (context.getSharedPreferences("auto_start_prefs", 0).getBoolean("is_auto_start_enabled", false)) {
            return;
        }
        g0(context);
    }

    public final void i0(Context context) {
        Object systemService = context.getSystemService("power");
        k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isIgnoringBatteryOptimizations(context.getPackageName())) {
            return;
        }
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        startActivity(intent);
    }

    public final void j0(Context context, String str, String str2) {
        StringBuilder sb2;
        String str3;
        if (!f0(context)) {
            Log.e("SMS", "App must be set as the default SMS app to save messages.");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("address", str);
        contentValues.put("body", str2);
        contentValues.put("date", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("read", (Integer) 0);
        contentValues.put("type", (Integer) 1);
        try {
            Uri uriInsert = context.getContentResolver().insert(Telephony.Sms.Inbox.CONTENT_URI, contentValues);
            if (uriInsert == null) {
                Log.e("SMS", "Failed to insert message into inbox.");
            } else {
                Log.d("SMS", "Message successfully saved: " + uriInsert);
            }
        } catch (SecurityException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "Permission denied. Ensure WRITE_SMS is granted: ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            Log.e("SMS", sb2.toString());
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "Unexpected error while saving SMS: ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            Log.e("SMS", sb2.toString());
        }
    }

    public final void k0(String str) {
        try {
            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(str))));
        } catch (SecurityException e10) {
            Log.e("MainActivity", "USSD Permission Denied: " + e10.getMessage());
        }
    }

    public final void l0(String str, int i10) {
        try {
            Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + Uri.encode(str)));
            intent.putExtra("com.android.phone.extra.slot", i10);
            startActivity(intent);
        } catch (SecurityException e10) {
            Log.e("MainActivity", "USSD Permission Denied: " + e10.getMessage());
        }
    }

    @Override // ra.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.example.bingwa.a.C0071a c0071a = com.example.bingwa.a.f3539a;
        io.flutter.embedding.engine.a aVar = new io.flutter.embedding.engine.a(this);
        aVar.k().j(ta.a.c.a());
        c0071a.b(aVar);
        i0(this);
        h0(this);
        Intent intent = getIntent();
        boolean z10 = false;
        if (intent != null && intent.getBooleanExtra("after_boot", false)) {
            z10 = true;
        }
        PowerManager.WakeLock wakeLock = null;
        if (z10) {
            new j(c0071a.a().k().l(), "com.example.foreground/native").c("runAfterBoot", null);
        }
        getWindow().addFlags(6815872);
        Object systemService = getSystemService("power");
        k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(268435482, "MyApp::WakeLock");
        this.f3531f = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock == null) {
            k.o("wakeLock");
        } else {
            wakeLock = wakeLockNewWakeLock;
        }
        wakeLock.acquire();
    }

    @Override // ra.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PowerManager.WakeLock wakeLock = this.f3531f;
        PowerManager.WakeLock wakeLock2 = null;
        if (wakeLock == null) {
            k.o("wakeLock");
            wakeLock = null;
        }
        if (wakeLock.isHeld()) {
            PowerManager.WakeLock wakeLock3 = this.f3531f;
            if (wakeLock3 == null) {
                k.o("wakeLock");
            } else {
                wakeLock2 = wakeLock3;
            }
            wakeLock2.release();
        }
    }

    @Override // ra.d, ra.e.c
    public void r(io.flutter.embedding.engine.a flutterEngine) {
        k.e(flutterEngine, "flutterEngine");
        super.r(flutterEngine);
        new j(flutterEngine.k(), "com.example.foreground/native", q.f8299b, flutterEngine.k().b()).e(new j.c() { // from class: x2.b
            @Override // fb.j.c
            public final void onMethodCall(i iVar, j.d dVar) {
                MainActivity.X(this.f17954a, iVar, dVar);
            }
        });
    }
}
