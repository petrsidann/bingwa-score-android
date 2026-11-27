package com.example.bingwa;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class MyDeviceAdminReceiver extends DeviceAdminReceiver {
    @Override // android.app.admin.DeviceAdminReceiver
    public void onDisabled(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        Toast.makeText(context, "Device Admin Disabled", 0).show();
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public void onEnabled(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        Toast.makeText(context, "Device Admin Enabled", 0).show();
    }
}
