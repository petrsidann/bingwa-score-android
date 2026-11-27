package e0;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f6833d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e f6836g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NotificationManager f6838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f6832c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Set<String> f6834e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f6835f = new Object();

    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    public static class b {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    public static class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f6840b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f6841c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Notification f6842d;

        public c(String str, int i10, String str2, Notification notification) {
            this.f6839a = str;
            this.f6840b = i10;
            this.f6841c = str2;
            this.f6842d = notification;
        }

        @Override // e0.o0.f
        public void a(b.a aVar) {
            aVar.d1(this.f6839a, this.f6840b, this.f6841c, this.f6842d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f6839a + ", id:" + this.f6840b + ", tag:" + this.f6841c + "]";
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ComponentName f6843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f6844b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f6843a = componentName;
            this.f6844b = iBinder;
        }
    }

    public static class e implements Handler.Callback, ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f6845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HandlerThread f6846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f6847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<ComponentName, a> f6848d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set<String> f6849e = new HashSet();

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ComponentName f6850a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b.a f6852c;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f6851b = false;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public ArrayDeque<f> f6853d = new ArrayDeque<>();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f6854e = 0;

            public a(ComponentName componentName) {
                this.f6850a = componentName;
            }
        }

        public e(Context context) {
            this.f6845a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f6846b = handlerThread;
            handlerThread.start();
            this.f6847c = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f6851b) {
                return true;
            }
            boolean zBindService = this.f6845a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f6850a), this, 33);
            aVar.f6851b = zBindService;
            if (zBindService) {
                aVar.f6854e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f6850a);
                this.f6845a.unbindService(this);
            }
            return aVar.f6851b;
        }

        public final void b(a aVar) {
            if (aVar.f6851b) {
                this.f6845a.unbindService(this);
                aVar.f6851b = false;
            }
            aVar.f6852c = null;
        }

        public final void c(f fVar) {
            j();
            for (a aVar : this.f6848d.values()) {
                aVar.f6853d.add(fVar);
                g(aVar);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f6848d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f6848d.get(componentName);
            if (aVar != null) {
                aVar.f6852c = b.a.AbstractBinderC0044a.b(iBinder);
                aVar.f6854e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f6848d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f6850a + ", " + aVar.f6853d.size() + " queued tasks");
            }
            if (aVar.f6853d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f6852c == null) {
                i(aVar);
                return;
            }
            while (true) {
                f fVarPeek = aVar.f6853d.peek();
                if (fVarPeek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + fVarPeek);
                    }
                    fVarPeek.a(aVar.f6852c);
                    aVar.f6853d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f6850a);
                    }
                } catch (RemoteException e10) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f6850a, e10);
                }
            }
            if (aVar.f6853d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        public void h(f fVar) {
            this.f6847c.obtainMessage(0, fVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((f) message.obj);
                return true;
            }
            if (i10 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f6843a, dVar.f6844b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        public final void i(a aVar) {
            if (this.f6847c.hasMessages(3, aVar.f6850a)) {
                return;
            }
            int i10 = aVar.f6854e + 1;
            aVar.f6854e = i10;
            if (i10 <= 6) {
                int i11 = (1 << (i10 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i11 + " ms");
                }
                this.f6847c.sendMessageDelayed(this.f6847c.obtainMessage(3, aVar.f6850a), i11);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f6853d.size() + " tasks to " + aVar.f6850a + " after " + aVar.f6854e + " retries");
            aVar.f6853d.clear();
        }

        public final void j() {
            Set<String> setF = o0.f(this.f6845a);
            if (setF.equals(this.f6849e)) {
                return;
            }
            this.f6849e = setF;
            List<ResolveInfo> listQueryIntentServices = this.f6845a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (setF.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f6848d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f6848d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f6848d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f6847c.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f6847c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface f {
        void a(b.a aVar);
    }

    public o0(Context context) {
        this.f6837a = context;
        this.f6838b = (NotificationManager) context.getSystemService("notification");
    }

    public static o0 e(Context context) {
        return new o0(context);
    }

    public static Set<String> f(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f6832c) {
            if (string != null) {
                if (!string.equals(f6833d)) {
                    String[] strArrSplit = string.split(":", -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f6834e = hashSet;
                    f6833d = string;
                }
                set = f6834e;
            } else {
                set = f6834e;
            }
            throw th;
        }
        return set;
    }

    public static boolean k(Notification notification) {
        Bundle bundleA = q.a(notification);
        return bundleA != null && bundleA.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        return a.a(this.f6838b);
    }

    public void b(int i10) {
        c(null, i10);
    }

    public void c(String str, int i10) {
        this.f6838b.cancel(str, i10);
    }

    public void d() {
        this.f6838b.cancelAll();
    }

    public List<NotificationChannel> g() {
        return b.k(this.f6838b);
    }

    public void h(int i10, Notification notification) {
        i(null, i10, notification);
    }

    public void i(String str, int i10, Notification notification) {
        if (!k(notification)) {
            this.f6838b.notify(str, i10, notification);
        } else {
            j(new c(this.f6837a.getPackageName(), i10, str, notification));
            this.f6838b.cancel(str, i10);
        }
    }

    public final void j(f fVar) {
        synchronized (f6835f) {
            if (f6836g == null) {
                f6836g = new e(this.f6837a.getApplicationContext());
            }
            f6836g.h(fVar);
        }
    }
}
