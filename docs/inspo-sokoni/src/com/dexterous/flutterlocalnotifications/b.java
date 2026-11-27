package com.dexterous.flutterlocalnotifications;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b extends Service {
    public static int a(ArrayList<Integer> arrayList) {
        int iIntValue = arrayList.get(0).intValue();
        for (int i10 = 1; i10 < arrayList.size(); i10++) {
            iIntValue |= arrayList.get(i10).intValue();
        }
        return iIntValue;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        c cVar = (c) (i12 >= 33 ? intent.getSerializableExtra("com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter", c.class) : intent.getSerializableExtra("com.dexterous.flutterlocalnotifications.ForegroundServiceStartParameter"));
        Notification notificationCreateNotification = FlutterLocalNotificationsPlugin.createNotification(this, cVar.f3510a);
        if (cVar.f3512c == null || i12 < 29) {
            startForeground(cVar.f3510a.f3520id.intValue(), notificationCreateNotification);
        } else {
            startForeground(cVar.f3510a.f3520id.intValue(), notificationCreateNotification, a(cVar.f3512c));
        }
        return cVar.f3511b;
    }
}
