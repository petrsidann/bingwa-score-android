package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f3512c;

    public c(NotificationDetails notificationDetails, int i10, ArrayList<Integer> arrayList) {
        this.f3510a = notificationDetails;
        this.f3511b = i10;
        this.f3512c = arrayList;
    }

    public String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f3510a + ", startMode=" + this.f3511b + ", foregroundServiceTypes=" + this.f3512c + '}';
    }
}
