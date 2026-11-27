package com.pravera.flutter_foreground_task.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import ed.t;
import fb.i;
import fb.j;
import gd.c1;
import gd.m0;
import gd.n0;
import gd.y1;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.w;
import lc.q;
import qc.l;
import va.f;
import xc.p;

/* JADX INFO: loaded from: classes.dex */
public final class ForegroundService extends Service implements j.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f6071r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f6072s = ForegroundService.class.getSimpleName();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f6073t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y9.a f6074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y9.b f6075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y9.e f6076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y9.b f6077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PowerManager.WakeLock f6078e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WifiManager.WifiLock f6079f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f6080l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public io.flutter.embedding.engine.a f6081m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public io.flutter.embedding.engine.a f6082n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f6083o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public y1 f6084p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f6085q = new b();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final boolean a() {
            return ForegroundService.f6073t;
        }
    }

    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    if (action == null) {
                        return;
                    }
                    String stringExtra = intent.getStringExtra("data");
                    j jVar = ForegroundService.this.f6083o;
                    if (jVar != null) {
                        jVar.c(action, stringExtra);
                    }
                } catch (Exception e10) {
                    Log.e(ForegroundService.f6072s, "onReceive", e10);
                }
            }
        }
    }

    public static final class c implements j.d {
        public c() {
        }

        @Override // fb.j.d
        public void a(Object obj) {
            ForegroundService.this.x();
        }

        @Override // fb.j.d
        public void b(String errorCode, String str, Object obj) {
            k.e(errorCode, "errorCode");
        }

        @Override // fb.j.d
        public void c() {
        }
    }

    @qc.f(c = "com.pravera.flutter_foreground_task.service.ForegroundService$startRepeatTask$1", f = "ForegroundService.kt", l = {395, 403}, m = "invokeSuspend")
    public static final class d extends l implements p<m0, oc.e<? super q>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6088a;

        @qc.f(c = "com.pravera.flutter_foreground_task.service.ForegroundService$startRepeatTask$1$1", f = "ForegroundService.kt", l = {}, m = "invokeSuspend")
        public static final class a extends l implements p<m0, oc.e<? super Object>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6090a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ForegroundService f6091b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(ForegroundService foregroundService, oc.e<? super a> eVar) {
                super(2, eVar);
                this.f6091b = foregroundService;
            }

            @Override // xc.p
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m0 m0Var, oc.e<Object> eVar) {
                return ((a) create(m0Var, eVar)).invokeSuspend(q.f12711a);
            }

            @Override // qc.a
            public final oc.e<q> create(Object obj, oc.e<?> eVar) {
                return new a(this.f6091b, eVar);
            }

            @Override // qc.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                pc.c.c();
                if (this.f6090a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lc.k.b(obj);
                try {
                    j jVar = this.f6091b.f6083o;
                    if (jVar == null) {
                        return null;
                    }
                    jVar.c("onRepeatEvent", null);
                    return q.f12711a;
                } catch (Exception e10) {
                    return qc.b.b(Log.e(ForegroundService.f6072s, "invokeMethod", e10));
                }
            }
        }

        public d(oc.e<? super d> eVar) {
            super(2, eVar);
        }

        @Override // xc.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(m0 m0Var, oc.e<? super q> eVar) {
            return ((d) create(m0Var, eVar)).invokeSuspend(q.f12711a);
        }

        @Override // qc.a
        public final oc.e<q> create(Object obj, oc.e<?> eVar) {
            return ForegroundService.this.new d(eVar);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x003a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:16:0x0043  */
        /* JADX WARN: Code duplicated, block: B:19:0x0053 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x005c  */
        /* JADX WARN: Code duplicated, block: B:25:0x0066  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:20:0x0054). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x0053
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // qc.a
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = pc.c.c()
                int r1 = r8.f6088a
                java.lang.String r2 = "foregroundTaskOptions"
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                lc.k.b(r9)
                r9 = r8
                goto L54
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1e:
                lc.k.b(r9)
                r9 = r8
                goto L3b
            L23:
                lc.k.b(r9)
                r9 = r8
            L27:
                gd.k2 r1 = gd.c1.c()
                com.pravera.flutter_foreground_task.service.ForegroundService$d$a r6 = new com.pravera.flutter_foreground_task.service.ForegroundService$d$a
                com.pravera.flutter_foreground_task.service.ForegroundService r7 = com.pravera.flutter_foreground_task.service.ForegroundService.this
                r6.<init>(r7, r5)
                r9.f6088a = r4
                java.lang.Object r1 = gd.i.g(r1, r6, r9)
                if (r1 != r0) goto L3b
                return r0
            L3b:
                com.pravera.flutter_foreground_task.service.ForegroundService r1 = com.pravera.flutter_foreground_task.service.ForegroundService.this
                y9.b r1 = com.pravera.flutter_foreground_task.service.ForegroundService.b(r1)
                if (r1 != 0) goto L47
                kotlin.jvm.internal.k.o(r2)
                r1 = r5
            L47:
                long r6 = r1.e()
                r9.f6088a = r3
                java.lang.Object r1 = gd.w0.a(r6, r9)
                if (r1 != r0) goto L54
                return r0
            L54:
                com.pravera.flutter_foreground_task.service.ForegroundService r1 = com.pravera.flutter_foreground_task.service.ForegroundService.this
                y9.b r1 = com.pravera.flutter_foreground_task.service.ForegroundService.b(r1)
                if (r1 != 0) goto L60
                kotlin.jvm.internal.k.o(r2)
                r1 = r5
            L60:
                boolean r1 = r1.f()
                if (r1 == 0) goto L27
                lc.q r9 = lc.q.f12711a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pravera.flutter_foreground_task.service.ForegroundService.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class e implements j.d {
        public e() {
        }

        @Override // fb.j.d
        public void a(Object obj) {
            io.flutter.embedding.engine.a aVar = ForegroundService.this.f6081m;
            if (aVar != null) {
                aVar.g();
            }
            ForegroundService.this.f6081m = null;
        }

        @Override // fb.j.d
        public void b(String errorCode, String str, Object obj) {
            k.e(errorCode, "errorCode");
            io.flutter.embedding.engine.a aVar = ForegroundService.this.f6081m;
            if (aVar != null) {
                aVar.g();
            }
            ForegroundService.this.f6081m = null;
        }

        @Override // fb.j.d
        public void c() {
            io.flutter.embedding.engine.a aVar = ForegroundService.this.f6081m;
            if (aVar != null) {
                aVar.g();
            }
            ForegroundService.this.f6081m = null;
        }
    }

    public final void A() {
        y1 y1Var = this.f6084p;
        if (y1Var != null) {
            y1.a.b(y1Var, null, 1, null);
        }
        this.f6084p = null;
    }

    public final void B() {
        unregisterReceiver(this.f6085q);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0024  */
    public final void h() {
        y9.b bVar = this.f6075b;
        y9.b bVar2 = null;
        if (bVar == null) {
            k.o("foregroundTaskOptions");
            bVar = null;
        }
        if (bVar.a()) {
            PowerManager.WakeLock wakeLock = this.f6078e;
            if (wakeLock == null) {
                Object systemService = getApplicationContext().getSystemService("power");
                k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, "ForegroundService:WakeLock");
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire();
                this.f6078e = wakeLockNewWakeLock;
            } else {
                if ((wakeLock == null || wakeLock.isHeld()) ? false : true) {
                    Object systemService2 = getApplicationContext().getSystemService("power");
                    k.c(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
                    PowerManager.WakeLock wakeLockNewWakeLock2 = ((PowerManager) systemService2).newWakeLock(1, "ForegroundService:WakeLock");
                    wakeLockNewWakeLock2.setReferenceCounted(false);
                    wakeLockNewWakeLock2.acquire();
                    this.f6078e = wakeLockNewWakeLock2;
                }
            }
        }
        y9.b bVar3 = this.f6075b;
        if (bVar3 == null) {
            k.o("foregroundTaskOptions");
        } else {
            bVar2 = bVar3;
        }
        if (bVar2.b()) {
            WifiManager.WifiLock wifiLock = this.f6079f;
            if (wifiLock != null) {
                if (!((wifiLock == null || wifiLock.isHeld()) ? false : true)) {
                    return;
                }
            }
            Object systemService3 = getApplicationContext().getSystemService("wifi");
            k.c(systemService3, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager.WifiLock wifiLockCreateWifiLock = ((WifiManager) systemService3).createWifiLock(3, "ForegroundService:WifiLock");
            wifiLockCreateWifiLock.setReferenceCounted(false);
            wifiLockCreateWifiLock.acquire();
            this.f6079f = wifiLockCreateWifiLock;
        }
    }

    public final List<Notification.Action> i() {
        ArrayList arrayList = new ArrayList();
        y9.e eVar = this.f6076c;
        if (eVar == null) {
            k.o("notificationOptions");
            eVar = null;
        }
        List<y9.c> listA = eVar.a();
        int size = listA.size();
        for (int i10 = 0; i10 < size; i10++) {
            Intent intent = new Intent("onNotificationButtonPressed");
            intent.putExtra("data", listA.get(i10).a());
            PendingIntent broadcast = PendingIntent.getBroadcast(this, i10 + 1, intent, 67108864);
            String strC = listA.get(i10).c();
            Notification.Action actionBuild = new Notification.Action.Builder((Icon) null, p(listA.get(i10).b(), strC != null ? o(strC) : null), broadcast).build();
            k.b(actionBuild);
            arrayList.add(actionBuild);
        }
        return arrayList;
    }

    public final void j(Long l10) {
        String strJ;
        ta.a aVarK;
        if (l10 == null) {
            return;
        }
        q();
        f fVar = this.f6080l;
        if (fVar == null || (strJ = fVar.j()) == null) {
            return;
        }
        ta.a.b bVar = new ta.a.b(getAssets(), strJ, FlutterCallbackInformation.lookupCallbackInformation(l10.longValue()));
        io.flutter.embedding.engine.a aVar = this.f6082n;
        if (aVar == null || (aVarK = aVar.k()) == null) {
            return;
        }
        aVarK.i(bVar);
    }

    public final void k() {
        y9.a.C0338a c0338a = y9.a.f19434b;
        Context applicationContext = getApplicationContext();
        k.d(applicationContext, "getApplicationContext(...)");
        this.f6074a = c0338a.a(applicationContext);
        y9.b bVar = this.f6075b;
        if (bVar != null) {
            if (bVar == null) {
                k.o("foregroundTaskOptions");
                bVar = null;
            }
            this.f6077d = bVar;
        }
        y9.b.a aVar = y9.b.f19436g;
        Context applicationContext2 = getApplicationContext();
        k.d(applicationContext2, "getApplicationContext(...)");
        this.f6075b = aVar.b(applicationContext2);
        y9.e.a aVar2 = y9.e.f19450p;
        Context applicationContext3 = getApplicationContext();
        k.d(applicationContext3, "getApplicationContext(...)");
        this.f6076c = aVar2.b(applicationContext3);
    }

    public final int l(PackageManager packageManager) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getApplicationContext().getPackageName(), 128);
            k.d(applicationInfo, "getApplicationInfo(...)");
            return applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e(f6072s, "getIconResIdFromAppInfo", e10);
            return 0;
        }
    }

    public final int m(y9.d dVar) {
        String str;
        String strD = dVar.d();
        String strC = dVar.c();
        String strB = dVar.b();
        if (!(strD.length() == 0)) {
            if (!(strC.length() == 0)) {
                if (!(strB.length() == 0)) {
                    if (t.v(strC, "ic", false, 2, null)) {
                        w wVar = w.f12384a;
                        str = String.format("ic_%s", Arrays.copyOf(new Object[]{strB}, 1));
                    } else {
                        w wVar2 = w.f12384a;
                        str = String.format("img_%s", Arrays.copyOf(new Object[]{strB}, 1));
                    }
                    k.d(str, "format(...)");
                    return getApplicationContext().getResources().getIdentifier(str, strD, getApplicationContext().getPackageName());
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    public final PendingIntent n(PackageManager packageManager) {
        PendingIntent broadcast;
        if (Build.VERSION.SDK_INT >= 29) {
            aa.c.a aVar = aa.c.f423a;
            Context applicationContext = getApplicationContext();
            k.d(applicationContext, "getApplicationContext(...)");
            if (aVar.a(applicationContext)) {
                broadcast = PendingIntent.getBroadcast(this, 20000, new Intent("onNotificationPressed"), 67108864);
            } else {
                broadcast = PendingIntent.getActivity(this, 20000, packageManager.getLaunchIntentForPackage(getApplicationContext().getPackageName()), 67108864);
            }
        } else {
            broadcast = PendingIntent.getBroadcast(this, 20000, new Intent("onNotificationPressed"), 67108864);
        }
        k.b(broadcast);
        return broadcast;
    }

    public final Integer o(String str) {
        List listC0 = t.c0(str, new String[]{","}, false, 0, 6, null);
        if (listC0.size() == 3) {
            return Integer.valueOf(Color.rgb(Integer.parseInt((String) listC0.get(0)), Integer.parseInt((String) listC0.get(1)), Integer.parseInt((String) listC0.get(2))));
        }
        return null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002d A[PHI: r0
  0x002d: PHI (r0v5 y9.b) = (r0v4 y9.b), (r0v7 y9.b) binds: [B:15:0x0043, B:8:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    @Override // android.app.Service
    public void onCreate() {
        y9.b bVar;
        super.onCreate();
        k();
        s();
        y9.a aVar = this.f6074a;
        y9.b bVar2 = null;
        if (aVar == null) {
            k.o("foregroundServiceStatus");
            aVar = null;
        }
        String strA = aVar.a();
        if (k.a(strA, "com.pravera.flutter_foreground_task.action.start")) {
            v();
            bVar = this.f6075b;
            if (bVar == null) {
                k.o("foregroundTaskOptions");
            } else {
                bVar2 = bVar;
            }
        } else {
            if (!k.a(strA, "com.pravera.flutter_foreground_task.action.reboot")) {
                return;
            }
            v();
            bVar = this.f6075b;
            if (bVar == null) {
                k.o("foregroundTaskOptions");
            } else {
                bVar2 = bVar;
            }
        }
        j(bVar2.d());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        z();
        y();
        B();
        y9.a aVar = this.f6074a;
        y9.e eVar = null;
        if (aVar == null) {
            k.o("foregroundServiceStatus");
            aVar = null;
        }
        if (k.a(aVar.a(), "com.pravera.flutter_foreground_task.action.stop")) {
            return;
        }
        if (r()) {
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
        String str = f6072s;
        Log.i(str, "The foreground service was terminated due to an unexpected problem.");
        y9.e eVar2 = this.f6076c;
        if (eVar2 == null) {
            k.o("notificationOptions");
        } else {
            eVar = eVar2;
        }
        if (eVar.n()) {
            if (Build.VERSION.SDK_INT >= 31) {
                aa.c.a aVar2 = aa.c.f423a;
                Context applicationContext = getApplicationContext();
                k.d(applicationContext, "getApplicationContext(...)");
                if (!aVar2.c(applicationContext)) {
                    Log.i(str, "Turn off battery optimization to restart service in the background.");
                    return;
                }
            }
            u();
        }
    }

    @Override // fb.j.c
    public void onMethodCall(i call, j.d result) {
        k.e(call, "call");
        k.e(result, "result");
        if (k.a(call.f8284a, "initialize")) {
            w();
        } else {
            result.c();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        k();
        y9.a aVar = this.f6074a;
        y9.e eVar = null;
        if (aVar == null) {
            k.o("foregroundServiceStatus");
            aVar = null;
        }
        String strA = aVar.a();
        int iHashCode = strA.hashCode();
        if (iHashCode != -2054347821) {
            if (iHashCode != 2000039308) {
                if (iHashCode == 2071663685 && strA.equals("com.pravera.flutter_foreground_task.action.restart")) {
                    v();
                    y9.b bVar = this.f6075b;
                    if (bVar == null) {
                        k.o("foregroundTaskOptions");
                        bVar = null;
                    }
                    j(bVar.d());
                }
            } else if (strA.equals("com.pravera.flutter_foreground_task.action.stop")) {
                y();
                return 2;
            }
        } else if (strA.equals("com.pravera.flutter_foreground_task.action.update")) {
            v();
            y9.b bVar2 = this.f6077d;
            Long lD = bVar2 != null ? bVar2.d() : null;
            y9.b bVar3 = this.f6075b;
            if (bVar3 == null) {
                k.o("foregroundTaskOptions");
                bVar3 = null;
            }
            Long lD2 = bVar3.d();
            if (k.a(lD, lD2)) {
                y9.b bVar4 = this.f6077d;
                Long lValueOf = bVar4 != null ? Long.valueOf(bVar4.e()) : null;
                y9.b bVar5 = this.f6075b;
                if (bVar5 == null) {
                    k.o("foregroundTaskOptions");
                    bVar5 = null;
                }
                long jE = bVar5.e();
                y9.b bVar6 = this.f6077d;
                Boolean boolValueOf = bVar6 != null ? Boolean.valueOf(bVar6.f()) : null;
                y9.b bVar7 = this.f6075b;
                if (bVar7 == null) {
                    k.o("foregroundTaskOptions");
                    bVar7 = null;
                }
                boolean zF = bVar7.f();
                if (lValueOf == null || lValueOf.longValue() != jE || !k.a(boolValueOf, Boolean.valueOf(zF))) {
                    x();
                }
            } else {
                j(lD2);
            }
        }
        y9.e eVar2 = this.f6076c;
        if (eVar2 == null) {
            k.o("notificationOptions");
        } else {
            eVar = eVar2;
        }
        return eVar.n() ? 1 : 2;
    }

    public final Spannable p(String str, Integer num) {
        SpannableString spannableString;
        if (num != null) {
            spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableString.length(), 0);
        } else {
            spannableString = new SpannableString(str);
        }
        return spannableString;
    }

    public final void q() {
        ta.a aVarK;
        fb.b bVarL;
        f fVar;
        if (this.f6083o != null) {
            z();
        }
        this.f6082n = new io.flutter.embedding.engine.a(this);
        f fVarC = qa.a.e().c();
        this.f6080l = fVarC;
        boolean z10 = false;
        if (fVarC != null && !fVarC.n()) {
            z10 = true;
        }
        if (z10 && (fVar = this.f6080l) != null) {
            fVar.r(this);
        }
        f fVar2 = this.f6080l;
        if (fVar2 != null) {
            fVar2.h(this, null);
        }
        io.flutter.embedding.engine.a aVar = this.f6082n;
        if (aVar == null || (aVarK = aVar.k()) == null || (bVarL = aVarK.l()) == null) {
            return;
        }
        j jVar = new j(bVarL, "flutter_foreground_task/background");
        this.f6083o = jVar;
        jVar.e(this);
    }

    public final boolean r() {
        return (getApplicationContext().getPackageManager().getServiceInfo(new ComponentName(this, (Class<?>) ForegroundService.class), 128).flags & 1) == 1;
    }

    public final void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("onNotificationButtonPressed");
        intentFilter.addAction("onNotificationPressed");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f6085q, intentFilter, 4);
        } else {
            registerReceiver(this.f6085q, intentFilter);
        }
    }

    public final void t() {
        PowerManager.WakeLock wakeLock = this.f6078e;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
            this.f6078e = null;
        }
        WifiManager.WifiLock wifiLock = this.f6079f;
        if (wifiLock == null || !wifiLock.isHeld()) {
            return;
        }
        wifiLock.release();
        this.f6079f = null;
    }

    public final void u() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(13, 1);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, new Intent(this, (Class<?>) RestartReceiver.class), 67108864);
        Object systemService = getSystemService("alarm");
        k.c(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(0, calendar.getTimeInMillis(), broadcast);
    }

    public final void v() {
        int iL;
        Integer numO;
        PackageManager packageManager = getApplicationContext().getPackageManager();
        y9.e eVar = this.f6076c;
        y9.e eVar2 = null;
        if (eVar == null) {
            k.o("notificationOptions");
            eVar = null;
        }
        String strC = eVar.c();
        y9.e eVar3 = this.f6076c;
        if (eVar3 == null) {
            k.o("notificationOptions");
            eVar3 = null;
        }
        String strE = eVar3.e();
        y9.e eVar4 = this.f6076c;
        if (eVar4 == null) {
            k.o("notificationOptions");
            eVar4 = null;
        }
        String strB = eVar4.b();
        y9.e eVar5 = this.f6076c;
        if (eVar5 == null) {
            k.o("notificationOptions");
            eVar5 = null;
        }
        int iD = eVar5.d();
        y9.e eVar6 = this.f6076c;
        if (eVar6 == null) {
            k.o("notificationOptions");
            eVar6 = null;
        }
        y9.d dVarI = eVar6.i();
        if (dVarI != null) {
            String strA = dVarI.a();
            numO = strA != null ? o(strA) : null;
            iL = m(dVarI);
        } else {
            k.b(packageManager);
            iL = l(packageManager);
            numO = null;
        }
        k.b(packageManager);
        PendingIntent pendingIntentN = n(packageManager);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager.getNotificationChannel(strC) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(strC, strE, iD);
            if (strB != null) {
                notificationChannel.setDescription(strB);
            }
            y9.e eVar7 = this.f6076c;
            if (eVar7 == null) {
                k.o("notificationOptions");
                eVar7 = null;
            }
            notificationChannel.enableVibration(eVar7.h());
            y9.e eVar8 = this.f6076c;
            if (eVar8 == null) {
                k.o("notificationOptions");
                eVar8 = null;
            }
            if (!eVar8.k()) {
                notificationChannel.setSound(null, null);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification.Builder builder = new Notification.Builder(this, strC);
        builder.setOngoing(true);
        y9.e eVar9 = this.f6076c;
        if (eVar9 == null) {
            k.o("notificationOptions");
            eVar9 = null;
        }
        builder.setShowWhen(eVar9.l());
        builder.setSmallIcon(iL);
        builder.setContentIntent(pendingIntentN);
        y9.e eVar10 = this.f6076c;
        if (eVar10 == null) {
            k.o("notificationOptions");
            eVar10 = null;
        }
        builder.setContentTitle(eVar10.g());
        y9.e eVar11 = this.f6076c;
        if (eVar11 == null) {
            k.o("notificationOptions");
            eVar11 = null;
        }
        builder.setContentText(eVar11.f());
        y9.e eVar12 = this.f6076c;
        if (eVar12 == null) {
            k.o("notificationOptions");
            eVar12 = null;
        }
        builder.setVisibility(eVar12.m());
        if (numO != null) {
            builder.setColor(numO.intValue());
        }
        Iterator<Notification.Action> it = i().iterator();
        while (it.hasNext()) {
            builder.addAction(it.next());
        }
        if (Build.VERSION.SDK_INT >= 31) {
            builder.setForegroundServiceBehavior(1);
        }
        y9.e eVar13 = this.f6076c;
        if (eVar13 == null) {
            k.o("notificationOptions");
        } else {
            eVar2 = eVar13;
        }
        startForeground(eVar2.j(), builder.build());
        t();
        h();
        f6073t = true;
    }

    public final void w() {
        A();
        c cVar = new c();
        j jVar = this.f6083o;
        if (jVar != null) {
            jVar.d("onStart", null, cVar);
        }
    }

    public final void x() {
        A();
        this.f6084p = gd.k.d(n0.a(c1.a()), null, null, new d(null), 3, null);
    }

    public final void y() {
        t();
        stopForeground(true);
        stopSelf();
        f6073t = false;
    }

    public final void z() {
        A();
        this.f6080l = null;
        this.f6081m = this.f6082n;
        this.f6082n = null;
        e eVar = new e();
        j jVar = this.f6083o;
        if (jVar != null) {
            jVar.d("onDestroy", null, eVar);
        }
        j jVar2 = this.f6083o;
        if (jVar2 != null) {
            jVar2.e(null);
        }
        this.f6083o = null;
    }
}
