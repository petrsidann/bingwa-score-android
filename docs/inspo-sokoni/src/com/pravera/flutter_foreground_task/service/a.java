package com.pravera.flutter_foreground_task.service;

import android.content.Context;
import android.content.Intent;
import java.util.Map;
import kotlin.jvm.internal.k;
import y9.b;
import y9.e;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final boolean a() {
        return ForegroundService.f6071r.a();
    }

    public final boolean b(Context context, Object obj) {
        k.e(context, "context");
        try {
            Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
            y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.restart");
            f0.a.startForegroundService(context, intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean c(Context context, Object obj) {
        k.e(context, "context");
        try {
            Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
            Map<?, ?> map = obj instanceof Map ? (Map) obj : null;
            y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.start");
            b.f19436g.c(context, map);
            e.f19450p.c(context, map);
            f0.a.startForegroundService(context, intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean d(Context context) {
        k.e(context, "context");
        if (!ForegroundService.f6071r.a()) {
            return false;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
            y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.stop");
            b.f19436g.a(context);
            e.f19450p.a(context);
            f0.a.startForegroundService(context, intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean e(Context context, Object obj) {
        k.e(context, "context");
        try {
            Intent intent = new Intent(context, (Class<?>) ForegroundService.class);
            Map<?, ?> map = obj instanceof Map ? (Map) obj : null;
            y9.a.f19434b.b(context, "com.pravera.flutter_foreground_task.action.update");
            b.f19436g.d(context, map);
            e.f19450p.d(context, map);
            f0.a.startForegroundService(context, intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
