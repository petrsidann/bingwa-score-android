package com.pravera.flutter_foreground_task.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class RestartReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) ForegroundService.class);
        y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.restart");
        context.startForegroundService(intent2);
    }
}
