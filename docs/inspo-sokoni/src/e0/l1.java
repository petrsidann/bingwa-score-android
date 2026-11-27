package e0;

import android.app.Notification;
import android.app.Service;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    public static class a {
        public static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 == 0 || i11 == -1) {
                service.startForeground(i10, notification, i11);
            } else {
                service.startForeground(i10, notification, i11 & 255);
            }
        }
    }

    public static class b {
        public static void a(Service service, int i10, Notification notification, int i11) {
            if (i11 == 0 || i11 == -1) {
                service.startForeground(i10, notification, i11);
            } else {
                service.startForeground(i10, notification, i11 & 1073745919);
            }
        }
    }

    public static void a(Service service, int i10, Notification notification, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 34) {
            b.a(service, i10, notification, i11);
        } else if (i12 >= 29) {
            a.a(service, i10, notification, i11);
        } else {
            service.startForeground(i10, notification);
        }
    }
}
