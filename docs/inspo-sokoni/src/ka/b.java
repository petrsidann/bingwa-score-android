package ka;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.os.PowerManager;
import e0.q;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11925c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f11926d = "SHUTDOWN";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11927e = "START";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11928f = "FlutterBackgroundPlugin:Wakelock";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f11929l = "FlutterBackgroundPlugin:WifiLock";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f11930m = "flutter_background";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f11931n = "IsolateHolderService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f11932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WifiManager.WifiLock f11933b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return b.f11926d;
        }

        public final String b() {
            return b.f11927e;
        }
    }

    public final void c() {
        WifiManager.WifiLock wifiLock;
        PowerManager.WakeLock wakeLock = this.f11932a;
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
        if (ka.a.f11904e.b() && (wifiLock = this.f11933b) != null && wifiLock.isHeld()) {
            wifiLock.release();
        }
        stopForeground(true);
    }

    public final void d() {
        PendingIntent activity = PendingIntent.getActivity(this, 0, getApplicationContext().getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName()), 201326592);
        String str = f11930m;
        ka.a.C0203a c0203a = ka.a.f11904e;
        NotificationChannel notificationChannel = new NotificationChannel(str, c0203a.l(), c0203a.j());
        notificationChannel.setDescription(c0203a.k());
        notificationChannel.setShowBadge(c0203a.n());
        Object systemService = getSystemService("notification");
        k.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        Notification notificationC = new q.e(this, str).n(c0203a.l()).m(c0203a.k()).H(getResources().getIdentifier(c0203a.i(), c0203a.h(), getPackageName())).l(activity).B(c0203a.j()).c();
        k.d(notificationC, "build(...)");
        Object systemService2 = getSystemService("power");
        k.c(systemService2, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService2).newWakeLock(1, f11928f);
        wakeLockNewWakeLock.setReferenceCounted(false);
        wakeLockNewWakeLock.acquire();
        this.f11932a = wakeLockNewWakeLock;
        Object systemService3 = getApplicationContext().getSystemService("wifi");
        k.c(systemService3, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        WifiManager.WifiLock wifiLockCreateWifiLock = ((WifiManager) systemService3).createWifiLock(1, f11929l);
        wifiLockCreateWifiLock.setReferenceCounted(false);
        wifiLockCreateWifiLock.acquire();
        this.f11933b = wifiLockCreateWifiLock;
        startForeground(1, notificationC);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        k.e(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        ka.a.f11904e.o(getApplicationContext());
    }

    @Override // android.app.Service
    public void onDestroy() {
        c();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (k.a(intent != null ? intent.getAction() : null, f11926d)) {
            c();
            stopSelf();
            return 1;
        }
        if (!k.a(intent != null ? intent.getAction() : null, f11927e)) {
            return 1;
        }
        d();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        k.e(rootIntent, "rootIntent");
        super.onTaskRemoved(rootIntent);
        c();
        stopSelf();
    }
}
