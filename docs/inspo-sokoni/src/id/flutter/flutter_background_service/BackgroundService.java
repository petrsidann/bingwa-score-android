package id.flutter.flutter_background_service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import e0.l1;
import e0.q;
import fb.i;
import fb.j;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import va.f;

/* JADX INFO: loaded from: classes.dex */
public class BackgroundService extends Service implements j.c {
    private static final String TAG = "BackgroundService";
    private io.flutter.embedding.engine.a backgroundEngine;
    private Config config;
    private ta.a.c dartEntrypoint;
    private Handler mainHandler;
    private j methodChannel;
    private String notificationChannelId;
    private String notificationContent;
    private int notificationId;
    private String notificationTitle;
    private static final String LOCK_NAME = BackgroundService.class.getName() + ".Lock";
    public static volatile PowerManager.WakeLock lockStatic = null;
    AtomicBoolean isRunning = new AtomicBoolean(false);
    private boolean isManuallyStopped = false;
    private final Pipe.PipeListener listener = new Pipe.PipeListener() { // from class: id.flutter.flutter_background_service.BackgroundService.1
        @Override // id.flutter.flutter_background_service.Pipe.PipeListener
        public void onReceived(JSONObject jSONObject) {
            BackgroundService.this.receiveData(jSONObject);
        }
    };

    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(this.notificationChannelId, "Background Service", 2);
        notificationChannel.setDescription("Executing process in background");
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public static synchronized PowerManager.WakeLock getLock(Context context) {
        if (lockStatic == null) {
            lockStatic = ((PowerManager) context.getSystemService("power")).newWakeLock(1, LOCK_NAME);
            lockStatic.setReferenceCounted(true);
        }
        return lockStatic;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$receiveData$0(JSONObject jSONObject) {
        j jVar = this.methodChannel;
        if (jVar == null) {
            return;
        }
        jVar.c("onReceiveData", jSONObject);
    }

    private void runService() {
        io.flutter.embedding.engine.a aVar;
        try {
            if (!this.isRunning.get() && ((aVar = this.backgroundEngine) == null || aVar.k().m())) {
                Log.v(TAG, "Starting flutter engine for background service");
                getLock(getApplicationContext()).acquire();
                updateNotificationInfo();
                f fVarC = qa.a.e().c();
                if (!fVarC.n()) {
                    fVarC.r(getApplicationContext());
                }
                fVarC.h(getApplicationContext(), null);
                this.isRunning.set(true);
                io.flutter.embedding.engine.a aVar2 = new io.flutter.embedding.engine.a(this);
                this.backgroundEngine = aVar2;
                aVar2.r().f(FlutterBackgroundServicePlugin.class);
                this.backgroundEngine.v().g(this, null, this.config.isForeground());
                j jVar = new j(this.backgroundEngine.k().l(), "id.flutter/background_service_android_bg", fb.f.f8283a);
                this.methodChannel = jVar;
                jVar.e(this);
                this.dartEntrypoint = new ta.a.c(fVarC.j(), "package:flutter_background_service_android/flutter_background_service_android.dart", "entrypoint");
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.valueOf(this.config.getBackgroundHandle()));
                this.backgroundEngine.k().k(this.dartEntrypoint, arrayList);
                return;
            }
            Log.v(TAG, "Service already running, using existing service");
        } catch (UnsatisfiedLinkError e10) {
            this.notificationContent = "Error " + e10.getMessage();
            updateNotificationInfo();
            Log.w(TAG, "UnsatisfiedLinkError: After a reboot this may happen for a short period and it is ok to ignore then!" + e10.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        FlutterBackgroundServicePlugin.servicePipe.addListener(this.listener);
        this.config = new Config(this);
        this.mainHandler = new Handler(Looper.getMainLooper());
        String notificationChannelId = this.config.getNotificationChannelId();
        if (notificationChannelId == null) {
            this.notificationChannelId = "FOREGROUND_DEFAULT";
            createNotificationChannel();
        } else {
            this.notificationChannelId = notificationChannelId;
        }
        this.notificationTitle = this.config.getInitialNotificationTitle();
        this.notificationContent = this.config.getInitialNotificationContent();
        this.notificationId = this.config.getForegroundNotificationId();
        updateNotificationInfo();
        onStartCommand(null, -1, -1);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.isManuallyStopped) {
            this.config.setManuallyStopped(true);
        } else {
            WatchdogReceiver.enqueue(this);
        }
        stopForeground(true);
        this.isRunning.set(false);
        io.flutter.embedding.engine.a aVar = this.backgroundEngine;
        if (aVar != null) {
            aVar.v().i();
            this.backgroundEngine.g();
            this.backgroundEngine = null;
        }
        FlutterBackgroundServicePlugin.servicePipe.removeListener(this.listener);
        this.methodChannel = null;
        this.dartEntrypoint = null;
        super.onDestroy();
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String str = iVar.f8284a;
        try {
            if (str.equalsIgnoreCase("setNotificationInfo")) {
                JSONObject jSONObject = (JSONObject) iVar.f8285b;
                if (jSONObject.has("title")) {
                    this.notificationTitle = jSONObject.getString("title");
                    this.notificationContent = jSONObject.getString("content");
                    updateNotificationInfo();
                    dVar.a(Boolean.TRUE);
                    return;
                }
                return;
            }
            if (str.equalsIgnoreCase("setAutoStartOnBootMode")) {
                this.config.setAutoStartOnBoot(((JSONObject) iVar.f8285b).getBoolean("value"));
                dVar.a(Boolean.TRUE);
                return;
            }
            if (str.equalsIgnoreCase("setForegroundMode")) {
                boolean z10 = ((JSONObject) iVar.f8285b).getBoolean("value");
                this.config.setIsForeground(z10);
                if (z10) {
                    updateNotificationInfo();
                    this.backgroundEngine.v().e();
                } else {
                    stopForeground(true);
                    this.backgroundEngine.v().a();
                }
                dVar.a(Boolean.TRUE);
                return;
            }
            if (str.equalsIgnoreCase("isForegroundMode")) {
                dVar.a(Boolean.valueOf(this.config.isForeground()));
                return;
            }
            if (str.equalsIgnoreCase("stopService")) {
                this.isManuallyStopped = true;
                WatchdogReceiver.remove(this);
                stopSelf();
                dVar.a(Boolean.TRUE);
                return;
            }
            if (str.equalsIgnoreCase("sendData")) {
                try {
                    Pipe pipe = FlutterBackgroundServicePlugin.mainPipe;
                    if (pipe.hasListener()) {
                        pipe.invoke((JSONObject) iVar.f8285b);
                    }
                    dVar.a(Boolean.TRUE);
                    return;
                } catch (Exception e10) {
                    dVar.b("send-data-failure", e10.getMessage(), e10);
                    return;
                }
            }
            if (str.equalsIgnoreCase("openApp")) {
                try {
                    Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.addFlags(268435456);
                        launchIntentForPackage.addFlags(32768);
                        startActivity(launchIntentForPackage);
                        dVar.a(Boolean.TRUE);
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    dVar.b("open app failure", e11.getMessage(), e11);
                    return;
                }
            }
            dVar.c();
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
            dVar.c();
        } catch (JSONException e12) {
            Log.e(TAG, e12.getMessage());
            e12.printStackTrace();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        this.config.setManuallyStopped(false);
        WatchdogReceiver.enqueue(this);
        runService();
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (this.isRunning.get()) {
            WatchdogReceiver.enqueue(getApplicationContext(), 1000);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void receiveData(final JSONObject jSONObject) {
        if (this.methodChannel == null) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: id.flutter.flutter_background_service.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10623a.lambda$receiveData$0(jSONObject);
                }
            });
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void updateNotificationInfo() {
        if (this.config.isForeground()) {
            try {
                l1.a(this, this.notificationId, new q.e(this, this.notificationChannelId).H(R.drawable.ic_bg_service_small).f(true).z(true).n(this.notificationTitle).m(this.notificationContent).l(PendingIntent.getActivity(this, 11, getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName()), Build.VERSION.SDK_INT >= 31 ? 301989888 : 268435456)).c(), -1);
            } catch (SecurityException e10) {
                Log.w(TAG, "Failed to start foreground service due to SecurityException - have you forgotten to request a permission? - " + e10.getMessage());
            }
        }
    }
}
