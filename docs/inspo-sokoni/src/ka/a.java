package ka;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import fb.i;
import fb.j;
import fb.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import lc.q;
import xc.l;

/* JADX INFO: loaded from: classes.dex */
public final class a implements xa.a, j.c, ya.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f11915u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f11921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f11922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f11923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f11924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0203a f11904e = new C0203a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11905f = "android.notificationTitle";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11906l = "android.notificationIconName";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11907m = "android.notificationIconDefType";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11908n = "android.notificationText";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f11909o = "android.notificationImportance";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f11910p = "android.enableWifiLock";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f11911q = "android.showBadge";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f11912r = "android.shouldRequestBatteryOptimizationsOff";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f11913s = "flutter_background foreground service";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f11914t = "Keeps the flutter app running in the background";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f11916v = "ic_launcher";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f11917w = "mipmap";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f11918x = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f11919y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f11920z = true;

    /* JADX INFO: renamed from: ka.a$a, reason: collision with other inner class name */
    public static final class C0203a {
        public C0203a() {
        }

        public /* synthetic */ C0203a(g gVar) {
            this();
        }

        public final String a() {
            return a.f11910p;
        }

        public final boolean b() {
            return a.f11918x;
        }

        public final String c() {
            return a.f11907m;
        }

        public final String d() {
            return a.f11906l;
        }

        public final String e() {
            return a.f11909o;
        }

        public final String f() {
            return a.f11908n;
        }

        public final String g() {
            return a.f11905f;
        }

        public final String h() {
            return a.f11917w;
        }

        public final String i() {
            return a.f11916v;
        }

        public final int j() {
            return a.f11915u;
        }

        public final String k() {
            return a.f11914t;
        }

        public final String l() {
            return a.f11913s;
        }

        public final String m() {
            return a.f11911q;
        }

        public final boolean n() {
            return a.f11919y;
        }

        public final void o(Context context) {
            SharedPreferences sharedPreferences;
            String strL;
            String strK;
            String strI;
            String strH;
            if (context != null) {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            } else {
                sharedPreferences = null;
            }
            if (sharedPreferences == null || (strL = sharedPreferences.getString(g(), l())) == null) {
                strL = l();
            }
            v(strL);
            if (sharedPreferences == null || (strK = sharedPreferences.getString(f(), k())) == null) {
                strK = k();
            }
            u(strK);
            t(sharedPreferences != null ? sharedPreferences.getInt(e(), j()) : j());
            if (sharedPreferences == null || (strI = sharedPreferences.getString(d(), i())) == null) {
                strI = i();
            }
            s(strI);
            if (sharedPreferences == null || (strH = sharedPreferences.getString(c(), h())) == null) {
                strH = h();
            }
            r(strH);
            q(sharedPreferences != null ? sharedPreferences.getBoolean(a(), false) : false);
            w(sharedPreferences != null ? sharedPreferences.getBoolean(m(), false) : false);
        }

        public final void p(Context context) {
            SharedPreferences sharedPreferences;
            if (context != null) {
                sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            } else {
                sharedPreferences = null;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences != null ? sharedPreferences.edit() : null;
            if (editorEdit != null) {
                C0203a c0203a = a.f11904e;
                editorEdit.putString(c0203a.g(), c0203a.l());
            }
            if (editorEdit != null) {
                C0203a c0203a2 = a.f11904e;
                editorEdit.putString(c0203a2.f(), c0203a2.k());
            }
            if (editorEdit != null) {
                C0203a c0203a3 = a.f11904e;
                editorEdit.putInt(c0203a3.e(), c0203a3.j());
            }
            if (editorEdit != null) {
                C0203a c0203a4 = a.f11904e;
                editorEdit.putString(c0203a4.d(), c0203a4.i());
            }
            if (editorEdit != null) {
                C0203a c0203a5 = a.f11904e;
                editorEdit.putString(c0203a5.c(), c0203a5.h());
            }
            if (editorEdit != null) {
                C0203a c0203a6 = a.f11904e;
                editorEdit.putBoolean(c0203a6.a(), c0203a6.b());
            }
            if (editorEdit != null) {
                C0203a c0203a7 = a.f11904e;
                editorEdit.putBoolean(c0203a7.m(), c0203a7.n());
            }
            if (editorEdit != null) {
                editorEdit.apply();
            }
        }

        public final void q(boolean z10) {
            a.f11918x = z10;
        }

        public final void r(String str) {
            k.e(str, "<set-?>");
            a.f11917w = str;
        }

        public final void s(String str) {
            k.e(str, "<set-?>");
            a.f11916v = str;
        }

        public final void t(int i10) {
            a.f11915u = i10;
        }

        public final void u(String str) {
            k.e(str, "<set-?>");
            a.f11914t = str;
        }

        public final void v(String str) {
            k.e(str, "<set-?>");
            a.f11913s = str;
        }

        public final void w(boolean z10) {
            a.f11919y = z10;
        }
    }

    public /* synthetic */ class b extends kotlin.jvm.internal.j implements l<fb.l, q> {
        public b(Object obj) {
            super(1, obj, ya.c.class, "addActivityResultListener", "addActivityResultListener(Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;)V", 0);
        }

        public final void d(fb.l p10) {
            k.e(p10, "p0");
            ((ya.c) this.receiver).b(p10);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(fb.l lVar) {
            d(lVar);
            return q.f12711a;
        }
    }

    public /* synthetic */ class c extends kotlin.jvm.internal.j implements l<n, q> {
        public c(Object obj) {
            super(1, obj, ya.c.class, "addRequestPermissionsResultListener", "addRequestPermissionsResultListener(Lio/flutter/plugin/common/PluginRegistry$RequestPermissionsResultListener;)V", 0);
        }

        public final void d(n p10) {
            k.e(p10, "p0");
            ((ya.c) this.receiver).h(p10);
        }

        @Override // xc.l
        public /* bridge */ /* synthetic */ q invoke(n nVar) {
            d(nVar);
            return q.f12711a;
        }
    }

    @Override // ya.a
    public void onAttachedToActivity(ya.c binding) {
        k.e(binding, "binding");
        Activity activityG = binding.g();
        k.d(activityG, "getActivity(...)");
        w(activityG, new b(binding), new c(binding));
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b binding) {
        k.e(binding, "binding");
        Context contextA = binding.a();
        k.d(contextA, "getApplicationContext(...)");
        fb.b bVarB = binding.b();
        k.d(bVarB, "getBinaryMessenger(...)");
        v(contextA, bVarB);
    }

    @Override // ya.a
    public void onDetachedFromActivity() {
        y();
    }

    @Override // ya.a
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b binding) {
        k.e(binding, "binding");
        x();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0063  */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0116, code lost:
    
        if (r12.a() != false) goto L59;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // fb.j.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMethodCall(i call, j.d result) {
        Intent intent;
        Object objValueOf;
        boolean z10;
        k.e(call, "call");
        k.e(result, "result");
        String str = call.f8284a;
        if (str != null) {
            switch (str.hashCode()) {
                case -1207077502:
                    if (str.equals("disableBackgroundExecution")) {
                        Context context = this.f11924d;
                        k.b(context);
                        intent = new Intent(context, (Class<?>) ka.b.class);
                        intent.setAction(ka.b.f11925c.a());
                        Context context2 = this.f11924d;
                        k.b(context2);
                        context2.startForegroundService(intent);
                        objValueOf = Boolean.TRUE;
                        result.a(objValueOf);
                    }
                    break;
                case 39845639:
                    if (str.equals("enableBackgroundExecution")) {
                        d dVar = this.f11923c;
                        k.b(dVar);
                        if (!dVar.b()) {
                            result.b("PermissionError", "Please add the WAKE_LOCK permission to the AndroidManifest.xml in order to use background_sockets.", "");
                        } else {
                            if (f11920z) {
                                d dVar2 = this.f11923c;
                                k.b(dVar2);
                                if (!dVar2.a()) {
                                    result.b("PermissionError", "The battery optimizations are not turned off.", "");
                                }
                            }
                            intent = new Intent(this.f11924d, (Class<?>) ka.b.class);
                            intent.setAction(ka.b.f11925c.b());
                            Context context3 = this.f11924d;
                            k.b(context3);
                            context3.startForegroundService(intent);
                            objValueOf = Boolean.TRUE;
                            result.a(objValueOf);
                        }
                    }
                    break;
                case 871091088:
                    if (str.equals("initialize")) {
                        String str2 = (String) call.a(f11905f);
                        String str3 = (String) call.a(f11908n);
                        Integer num = (Integer) call.a(f11909o);
                        String str4 = (String) call.a(f11906l);
                        String str5 = (String) call.a(f11907m);
                        Boolean bool = (Boolean) call.a(f11910p);
                        Boolean bool2 = (Boolean) call.a(f11911q);
                        Boolean bool3 = (Boolean) call.a(f11912r);
                        f11915u = num != null ? num.intValue() : f11915u;
                        if (str2 == null) {
                            str2 = f11913s;
                        }
                        f11913s = str2;
                        if (str3 == null) {
                            str3 = f11914t;
                        }
                        f11914t = str3;
                        if (str4 == null) {
                            str4 = f11916v;
                        }
                        f11916v = str4;
                        if (str5 == null) {
                            str5 = f11917w;
                        }
                        f11917w = str5;
                        f11918x = bool != null ? bool.booleanValue() : f11918x;
                        f11919y = bool2 != null ? bool2.booleanValue() : f11919y;
                        f11920z = bool3 != null ? bool3.booleanValue() : f11920z;
                        f11904e.p(this.f11924d);
                        d dVar3 = this.f11923c;
                        k.b(dVar3);
                        if (dVar3.b()) {
                            if (f11920z) {
                                d dVar4 = this.f11923c;
                                k.b(dVar4);
                            }
                            result.a(Boolean.TRUE);
                        }
                        d dVar5 = this.f11923c;
                        k.b(dVar5);
                        if (!dVar5.b()) {
                            result.b("PermissionError", "Please add the WAKE_LOCK permission to the AndroidManifest.xml in order to use background_sockets.", "");
                        } else if (f11920z) {
                            d dVar6 = this.f11923c;
                            k.b(dVar6);
                            if (!dVar6.a()) {
                                if (this.f11922b == null) {
                                    result.b("NoActivityError", "The plugin is not attached to an activity", "The plugin is not attached to an activity. This is required in order to request battery optimization to be off.");
                                } else {
                                    d dVar7 = this.f11923c;
                                    k.b(dVar7);
                                    Activity activity = this.f11922b;
                                    k.b(activity);
                                    dVar7.c(result, activity);
                                }
                            }
                        }
                    }
                    break;
                case 1032406410:
                    if (str.equals("hasPermissions")) {
                        d dVar8 = this.f11923c;
                        k.b(dVar8);
                        if (dVar8.a()) {
                            d dVar9 = this.f11923c;
                            k.b(dVar9);
                            if (dVar9.b()) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                        } else {
                            z10 = false;
                        }
                        objValueOf = Boolean.valueOf(z10);
                        result.a(objValueOf);
                    }
                    break;
                case 1385449135:
                    if (str.equals("getPlatformVersion")) {
                        objValueOf = "Android " + Build.VERSION.RELEASE;
                        result.a(objValueOf);
                    }
                    break;
            }
        }
        result.c();
    }

    @Override // ya.a
    public void onReattachedToActivityForConfigChanges(ya.c binding) {
        k.e(binding, "binding");
        onAttachedToActivity(binding);
    }

    public final void v(Context context, fb.b bVar) {
        j jVar = new j(bVar, "flutter_background");
        this.f11921a = jVar;
        k.b(jVar);
        jVar.e(this);
        this.f11924d = context;
    }

    public final void w(Activity activity, l<? super fb.l, q> lVar, l<? super n, q> lVar2) {
        this.f11922b = activity;
        Context applicationContext = activity.getApplicationContext();
        k.d(applicationContext, "getApplicationContext(...)");
        this.f11923c = new d(applicationContext, lVar, lVar2);
    }

    public final void x() {
        j jVar = this.f11921a;
        k.b(jVar);
        jVar.e(null);
        this.f11921a = null;
        this.f11924d = null;
    }

    public final void y() {
        this.f11922b = null;
        this.f11923c = null;
    }
}
