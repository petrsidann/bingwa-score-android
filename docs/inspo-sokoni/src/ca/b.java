package ca;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Process;
import fb.j;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import lc.q;

/* JADX INFO: loaded from: classes.dex */
public final class b implements j.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f3447a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<HashMap<String, Object>> f3448b = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f3449c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static j f3450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static io.flutter.embedding.engine.a f3451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static va.f f3452f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Long f3453l;

    public final void a(Context context, HashMap<String, Object> message) {
        k.e(context, "context");
        k.e(message, "message");
        if (f3450d == null) {
            throw new RuntimeException("setBackgroundChannel was not called before messages came in, exiting.");
        }
        HashMap map = new HashMap();
        if (f3453l == null) {
            f3453l = Long.valueOf(b(context));
        }
        map.put("handle", f3453l);
        map.put("message", message);
        j jVar = f3450d;
        if (jVar == null) {
            k.o("backgroundChannel");
            jVar = null;
        }
        jVar.c("handleBackgroundMessage", map);
    }

    public final long b(Context context) {
        return context.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).getLong("background_message_handle", 0L);
    }

    public final List<HashMap<String, Object>> c() {
        return f3448b;
    }

    public final void d(Context context) {
        k.e(context, "context");
        va.f fVarC = qa.a.e().c();
        f3452f = fVarC;
        if (fVarC == null) {
            k.o("flutterLoader");
            fVarC = null;
        }
        fVarC.r(context);
        va.f fVar = f3452f;
        if (fVar == null) {
            k.o("flutterLoader");
            fVar = null;
        }
        fVar.h(context.getApplicationContext(), null);
    }

    public final boolean e(Context context) {
        k.e(context, "context");
        Object systemService = context.getSystemService("keyguard");
        k.c(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        if (((KeyguardManager) systemService).isKeyguardLocked()) {
            return false;
        }
        int iMyPid = Process.myPid();
        Object systemService2 = context.getSystemService("activity");
        k.c(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService2).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public final AtomicBoolean f() {
        return f3449c;
    }

    public final void g(Context applicationContext) {
        k.e(applicationContext, "applicationContext");
        f3449c.set(true);
        List<HashMap<String, Object>> backgroundMessageQueue = f3448b;
        k.d(backgroundMessageQueue, "backgroundMessageQueue");
        synchronized (backgroundMessageQueue) {
            for (HashMap<String, Object> map : backgroundMessageQueue) {
                b bVar = f3447a;
                k.d(map, "next(...)");
                bVar.a(applicationContext, map);
            }
            f3448b.clear();
            q qVar = q.f12711a;
        }
    }

    public final void h(Context context, long j10) {
        k.e(context, "context");
        f3453l = Long.valueOf(j10);
        context.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).edit().putLong("background_message_handle", j10).apply();
    }

    public final void i(Context context, long j10) {
        k.e(context, "context");
        context.getSharedPreferences("com.shounakmulay.android_telephony_plugin", 0).edit().putLong("background_setup_handle", j10).apply();
    }

    public final void j(Context context, long j10) {
        k.e(context, "context");
        va.f fVar = f3452f;
        io.flutter.embedding.engine.a aVar = null;
        if (fVar == null) {
            k.o("flutterLoader");
            fVar = null;
        }
        String strJ = fVar.j();
        k.d(strJ, "findAppBundlePath(...)");
        ta.a.b bVar = new ta.a.b(context.getAssets(), strJ, FlutterCallbackInformation.lookupCallbackInformation(j10));
        va.f fVar2 = f3452f;
        if (fVar2 == null) {
            k.o("flutterLoader");
            fVar2 = null;
        }
        io.flutter.embedding.engine.a aVar2 = new io.flutter.embedding.engine.a(context, fVar2, new FlutterJNI());
        f3451e = aVar2;
        aVar2.k().i(bVar);
        io.flutter.embedding.engine.a aVar3 = f3451e;
        if (aVar3 == null) {
            k.o("backgroundFlutterEngine");
        } else {
            aVar = aVar3;
        }
        j jVar = new j(aVar.k(), "plugins.shounakmulay.com/background_sms_channel");
        f3450d = jVar;
        jVar.e(this);
    }

    @Override // fb.j.c
    public void onMethodCall(fb.i call, j.d result) {
        k.e(call, "call");
        k.e(result, "result");
        da.d.a aVar = da.d.f6677b;
        String method = call.f8284a;
        k.d(method, "method");
        if (aVar.a(method) == da.d.BACKGROUND_SERVICE_INITIALIZED) {
            Context contextA = a.f3445a.a();
            if (contextA == null) {
                throw new RuntimeException("Context not initialised!");
            }
            g(contextA);
        }
    }
}
