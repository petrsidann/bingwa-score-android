package id.flutter.flutter_background_service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import fb.b;
import fb.c;
import fb.f;
import fb.i;
import fb.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FlutterBackgroundServicePlugin implements xa.a, j.c, c.d {
    private static final String TAG = "BackgroundServicePlugin";
    private j channel;
    private Config config;
    private Context context;
    private c eventChannel;
    private final Map<Object, c.b> eventSinks = new HashMap();
    private final Pipe.PipeListener listener = new Pipe.PipeListener() { // from class: id.flutter.flutter_background_service.FlutterBackgroundServicePlugin.1
        @Override // id.flutter.flutter_background_service.Pipe.PipeListener
        public void onReceived(JSONObject jSONObject) {
            FlutterBackgroundServicePlugin.this.receiveData(jSONObject);
        }
    };
    private Handler mainHandler;
    public static final Pipe servicePipe = new Pipe();
    public static final Pipe mainPipe = new Pipe();

    private boolean isServiceRunning() {
        Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) this.context.getSystemService("activity")).getRunningServices(com.google.android.gms.common.api.a.e.API_PRIORITY_OTHER).iterator();
        while (it.hasNext()) {
            if (BackgroundService.class.getName().equals(it.next().service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveData(final JSONObject jSONObject) {
        synchronized (this) {
            for (final c.b bVar : this.eventSinks.values()) {
                this.mainHandler.post(new Runnable() { // from class: id.flutter.flutter_background_service.FlutterBackgroundServicePlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.a(jSONObject);
                    }
                });
            }
        }
    }

    public static void registerWith(io.flutter.embedding.engine.a aVar) {
        Log.d(TAG, "registering with FlutterEngine");
    }

    private void start() {
        WatchdogReceiver.enqueue(this.context);
        boolean zIsForeground = this.config.isForeground();
        Intent intent = new Intent(this.context, (Class<?>) BackgroundService.class);
        if (zIsForeground) {
            f0.a.startForegroundService(this.context, intent);
        } else {
            this.context.startService(intent);
        }
    }

    @Override // xa.a
    public void onAttachedToEngine(xa.a.b bVar) {
        Context contextA = bVar.a();
        this.context = contextA;
        this.config = new Config(contextA);
        this.mainHandler = new Handler(this.context.getMainLooper());
        b bVarB = bVar.b();
        f fVar = f.f8283a;
        j jVar = new j(bVarB, "id.flutter/background_service/android/method", fVar);
        this.channel = jVar;
        jVar.e(this);
        c cVar = new c(bVar.b(), "id.flutter/background_service/android/event", fVar);
        this.eventChannel = cVar;
        cVar.d(this);
        mainPipe.addListener(this.listener);
    }

    @Override // fb.c.d
    public void onCancel(Object obj) {
        synchronized (this) {
            this.eventSinks.remove(obj);
        }
    }

    @Override // xa.a
    public void onDetachedFromEngine(xa.a.b bVar) {
        mainPipe.removeListener(this.listener);
        this.channel.e(null);
        this.channel = null;
        synchronized (this.eventSinks) {
            this.eventSinks.clear();
        }
        this.eventChannel.d(null);
        this.eventChannel = null;
    }

    @Override // fb.c.d
    public void onListen(Object obj, c.b bVar) {
        synchronized (this) {
            this.eventSinks.put(obj, bVar);
        }
    }

    @Override // fb.j.c
    public void onMethodCall(i iVar, j.d dVar) {
        String str = iVar.f8284a;
        JSONObject jSONObject = (JSONObject) iVar.f8285b;
        try {
            if (!"configure".equals(str)) {
                if ("start".equals(str)) {
                    start();
                    dVar.a(Boolean.TRUE);
                    return;
                }
                if (!str.equalsIgnoreCase("sendData")) {
                    if (str.equalsIgnoreCase("isServiceRunning")) {
                        dVar.a(Boolean.valueOf(isServiceRunning()));
                        return;
                    } else {
                        dVar.c();
                        return;
                    }
                }
                Pipe pipe = servicePipe;
                synchronized (pipe) {
                    if (!pipe.hasListener()) {
                        dVar.a(Boolean.FALSE);
                        return;
                    } else {
                        pipe.invoke((JSONObject) iVar.f8285b);
                        dVar.a(Boolean.TRUE);
                        return;
                    }
                }
            }
            long j10 = jSONObject.getLong("background_handle");
            boolean z10 = jSONObject.getBoolean("is_foreground_mode");
            boolean z11 = jSONObject.getBoolean("auto_start_on_boot");
            boolean z12 = jSONObject.getBoolean("auto_start");
            Integer numValueOf = null;
            String string = jSONObject.isNull("initial_notification_title") ? null : jSONObject.getString("initial_notification_title");
            String string2 = jSONObject.isNull("initial_notification_content") ? null : jSONObject.getString("initial_notification_content");
            String string3 = jSONObject.isNull("notification_channel_id") ? null : jSONObject.getString("notification_channel_id");
            if (!jSONObject.isNull("foreground_notification_id")) {
                numValueOf = Integer.valueOf(jSONObject.getInt("foreground_notification_id"));
            }
            int iIntValue = numValueOf.intValue();
            this.config.setBackgroundHandle(j10);
            this.config.setIsForeground(z10);
            this.config.setAutoStartOnBoot(z11);
            this.config.setInitialNotificationTitle(string);
            this.config.setInitialNotificationContent(string2);
            this.config.setNotificationChannelId(string3);
            this.config.setForegroundNotificationId(iIntValue);
            if (z12) {
                start();
            }
            dVar.a(Boolean.TRUE);
        } catch (Exception e10) {
            dVar.b("100", "Failed while read arguments", e10.getMessage());
        }
    }
}
