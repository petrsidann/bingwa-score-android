package com.pravera.flutter_foreground_task.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;
import y9.b;

/* JADX INFO: loaded from: classes.dex */
public final class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            if (k.a(intent != null ? intent.getAction() : null, "android.intent.action.BOOT_COMPLETED") && b.f19436g.b(context).c()) {
                Intent intent2 = new Intent(context, (Class<?>) ForegroundService.class);
                y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.reboot");
                f0.a.startForegroundService(context, intent2);
            }
        }
    }
}
