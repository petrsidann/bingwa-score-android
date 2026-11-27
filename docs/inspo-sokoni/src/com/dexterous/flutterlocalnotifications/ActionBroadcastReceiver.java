package com.dexterous.flutterlocalnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Keep;
import e0.o0;
import io.flutter.view.FlutterCallbackInformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import va.f;

/* JADX INFO: loaded from: classes.dex */
public class ActionBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f3489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static io.flutter.embedding.engine.a f3490c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v2.a f3491a;

    public static class b implements fb.c.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Map<String, Object>> f3492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fb.c.b f3493b;

        public b() {
            this.f3492a = new ArrayList();
        }

        public void a(Map<String, Object> map) {
            fb.c.b bVar = this.f3493b;
            if (bVar != null) {
                bVar.a(map);
            } else {
                this.f3492a.add(map);
            }
        }

        @Override // fb.c.d
        public void onCancel(Object obj) {
            this.f3493b = null;
        }

        @Override // fb.c.d
        public void onListen(Object obj, fb.c.b bVar) {
            Iterator<Map<String, Object>> it = this.f3492a.iterator();
            while (it.hasNext()) {
                bVar.a(it.next());
            }
            this.f3492a.clear();
            this.f3493b = bVar;
        }
    }

    @Keep
    public ActionBroadcastReceiver() {
    }

    public final void a(ta.a aVar) {
        new fb.c(aVar.l(), "dexterous.com/flutter/local_notifications/actions").d(f3489b);
    }

    public final void b(Context context) {
        if (f3490c != null) {
            Log.e("ActionBroadcastReceiver", "Engine is already initialised");
            return;
        }
        f fVarC = qa.a.e().c();
        fVarC.r(context);
        fVarC.h(context, null);
        f3490c = new io.flutter.embedding.engine.a(context);
        FlutterCallbackInformation flutterCallbackInformationD = this.f3491a.d();
        if (flutterCallbackInformationD == null) {
            Log.w("ActionBroadcastReceiver", "Callback information could not be retrieved");
            return;
        }
        ta.a aVarK = f3490c.k();
        a(aVarK);
        aVarK.i(new ta.a.b(context.getAssets(), fVarC.j(), flutterCallbackInformationD));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.dexterous.flutterlocalnotifications.ActionBroadcastReceiver.ACTION_TAPPED".equalsIgnoreCase(intent.getAction())) {
            v2.a aVar = this.f3491a;
            if (aVar == null) {
                aVar = new v2.a(context);
            }
            this.f3491a = aVar;
            Map<String, Object> mapExtractNotificationResponseMap = FlutterLocalNotificationsPlugin.extractNotificationResponseMap(intent);
            if (intent.getBooleanExtra("cancelNotification", false)) {
                o0.e(context).b(((Integer) mapExtractNotificationResponseMap.get("notificationId")).intValue());
            }
            if (f3489b == null) {
                f3489b = new b();
            }
            f3489b.a(mapExtractNotificationResponseMap);
            b(context);
        }
    }
}
