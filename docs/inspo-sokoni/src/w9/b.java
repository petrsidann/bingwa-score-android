package w9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import fb.i;
import fb.j;
import fb.l;
import java.util.Map;
import kotlin.jvm.internal.k;
import y9.f;
import z9.c;

/* JADX INFO: loaded from: classes.dex */
public final class b implements j.c, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f17825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f17826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f17827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j.d f17828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j.d f17829f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j.d f17830l;

    public static final class a implements z9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j.d f17831a;

        public a(j.d dVar) {
            this.f17831a = dVar;
        }

        @Override // z9.a
        public void a(x9.a errorCode) {
            k.e(errorCode, "errorCode");
            aa.a.f422a.a(this.f17831a, errorCode);
        }

        @Override // z9.a
        public void b(f permissionStatus) {
            k.e(permissionStatus, "permissionStatus");
            this.f17831a.a(Integer.valueOf(permissionStatus.ordinal()));
        }
    }

    public b(Context context, c provider) {
        k.e(context, "context");
        k.e(provider, "provider");
        this.f17824a = context;
        this.f17825b = provider;
    }

    public final Activity a(j.d dVar) {
        Activity activity = this.f17827d;
        if (activity != null) {
            return activity;
        }
        aa.a.f422a.a(dVar, x9.a.ACTIVITY_NOT_ATTACHED);
        return null;
    }

    public void b() {
        j jVar = this.f17826c;
        if (jVar != null) {
            if (jVar == null) {
                k.o("channel");
                jVar = null;
            }
            jVar.e(null);
        }
    }

    public void c(fb.b messenger) {
        k.e(messenger, "messenger");
        j jVar = new j(messenger, "flutter_foreground_task/methods");
        this.f17826c = jVar;
        jVar.e(this);
    }

    public void d(Activity activity) {
        this.f17827d = activity;
    }

    @Override // fb.l
    public boolean onActivityResult(int i10, int i11, Intent intent) {
        j.d dVar;
        boolean zC;
        switch (i10) {
            case 101:
                dVar = this.f17829f;
                if (dVar == null) {
                }
                zC = aa.c.f423a.c(this.f17824a);
                dVar.a(Boolean.valueOf(zC));
                break;
            case 102:
                dVar = this.f17828e;
                if (dVar == null) {
                }
                zC = aa.c.f423a.c(this.f17824a);
                dVar.a(Boolean.valueOf(zC));
                break;
            case 103:
                dVar = this.f17830l;
                if (dVar != null) {
                    zC = aa.c.f423a.a(this.f17824a);
                    dVar.a(Boolean.valueOf(zC));
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        Boolean bool;
        boolean zB;
        Object objValueOf;
        k.e(call, "call");
        k.e(result, "result");
        Object obj = call.f8285b;
        String str = call.f8284a;
        if (str != null) {
            switch (str.hashCode()) {
                case -2070189206:
                    if (str.equals("setOnLockScreenVisibility")) {
                        Activity activityA = a(result);
                        if (activityA != null) {
                            Map map = obj instanceof Map ? (Map) obj : null;
                            Object obj2 = map != null ? map.get("isVisible") : null;
                            bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                            aa.c.f423a.i(activityA, bool != null ? bool.booleanValue() : false);
                        }
                    }
                    break;
                case -1401626951:
                    if (str.equals("isAppOnForeground")) {
                        zB = aa.c.f423a.b(this.f17824a);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case -958428903:
                    if (str.equals("requestIgnoreBatteryOptimization")) {
                        Activity activityA2 = a(result);
                        if (activityA2 != null) {
                            this.f17829f = result;
                            aa.c.f423a.h(activityA2, 101);
                        }
                    }
                    break;
                case -917901449:
                    if (str.equals("canDrawOverlays")) {
                        zB = aa.c.f423a.a(this.f17824a);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case -843699029:
                    if (str.equals("wakeUpScreen")) {
                        aa.c.f423a.j(this.f17824a);
                    }
                    break;
                case -830276983:
                    if (str.equals("requestNotificationPermission")) {
                        Activity activityA3 = a(result);
                        if (activityA3 != null) {
                            this.f17825b.b().e(activityA3, new a(result));
                        }
                    }
                    break;
                case -802694078:
                    if (str.equals("checkNotificationPermission")) {
                        Activity activityA4 = a(result);
                        if (activityA4 != null) {
                            objValueOf = Integer.valueOf(this.f17825b.b().a(activityA4).ordinal());
                            result.a(objValueOf);
                        }
                    }
                    break;
                case -675127954:
                    if (str.equals("launchApp")) {
                        if (obj != null ? obj instanceof String : true) {
                            aa.c.f423a.d(this.f17824a, (String) obj);
                        }
                    }
                    break;
                case -386121002:
                    if (str.equals("openSystemAlertWindowSettings")) {
                        Activity activityA5 = a(result);
                        if (activityA5 != null) {
                            this.f17830l = result;
                            Map map2 = obj instanceof Map ? (Map) obj : null;
                            Object obj3 = map2 != null ? map2.get("forceOpen") : null;
                            bool = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                            aa.c.f423a.g(activityA5, 103, bool != null ? bool.booleanValue() : false);
                        }
                    }
                    break;
                case 310881216:
                    if (str.equals("isRunningService")) {
                        zB = this.f17825b.a().a();
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case 481665446:
                    if (str.equals("restartService")) {
                        zB = this.f17825b.a().b(this.f17824a, obj);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case 488202668:
                    if (str.equals("updateService")) {
                        zB = this.f17825b.a().e(this.f17824a, obj);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case 677170851:
                    if (str.equals("minimizeApp")) {
                        Activity activityA6 = a(result);
                        if (activityA6 != null) {
                            aa.c.f423a.e(activityA6);
                        }
                    }
                    break;
                case 699379795:
                    if (str.equals("stopService")) {
                        zB = this.f17825b.a().d(this.f17824a);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case 1263333587:
                    if (str.equals("attachedActivity")) {
                        objValueOf = Boolean.valueOf(this.f17827d != null);
                        result.a(objValueOf);
                    }
                    break;
                case 1465118721:
                    if (str.equals("openIgnoreBatteryOptimizationSettings")) {
                        Activity activityA7 = a(result);
                        if (activityA7 != null) {
                            this.f17828e = result;
                            aa.c.f423a.f(activityA7, 102);
                        }
                    }
                    break;
                case 1849706483:
                    if (str.equals("startService")) {
                        zB = this.f17825b.a().c(this.f17824a, obj);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
                case 2079768210:
                    if (str.equals("isIgnoringBatteryOptimizations")) {
                        zB = aa.c.f423a.c(this.f17824a);
                        objValueOf = Boolean.valueOf(zB);
                        result.a(objValueOf);
                    }
                    break;
            }
        }
        result.c();
    }
}
