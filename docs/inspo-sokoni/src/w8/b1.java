package w8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class b1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f17692f = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Boolean f17693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Boolean f17694m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f17696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PowerManager.WakeLock f17697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a1 f17698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f17699e;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1 f17700a;

        public a(b1 b1Var) {
            this.f17700a = b1Var;
        }

        public void a() {
            if (b1.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            b1.this.f17695a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            b1 b1Var = this.f17700a;
            if (b1Var == null) {
                return;
            }
            if (b1Var.i()) {
                if (b1.j()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f17700a.f17698d.m(this.f17700a, 0L);
                context.unregisterReceiver(this);
                this.f17700a = null;
            }
        }
    }

    public b1(a1 a1Var, Context context, i0 i0Var, long j10) {
        this.f17698d = a1Var;
        this.f17695a = context;
        this.f17699e = j10;
        this.f17696b = i0Var;
        this.f17697c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    public static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f17692f) {
            Boolean bool = f17694m;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            f17694m = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    public static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z10 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z10;
    }

    public static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f17692f) {
            Boolean bool = f17693l;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            f17693l = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public final synchronized boolean i() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f17695a.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.f17695a)) {
            this.f17697c.acquire(com.google.firebase.messaging.a.f5585a);
        }
        try {
            try {
                try {
                    this.f17698d.o(true);
                    if (!this.f17696b.g()) {
                        this.f17698d.o(false);
                        if (h(this.f17695a)) {
                            try {
                                this.f17697c.release();
                                return;
                            } catch (RuntimeException unused) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (f(this.f17695a) && !i()) {
                        new a(this).a();
                        if (h(this.f17695a)) {
                            try {
                                this.f17697c.release();
                                return;
                            } catch (RuntimeException unused2) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (this.f17698d.s()) {
                        this.f17698d.o(false);
                    } else {
                        this.f17698d.t(this.f17699e);
                    }
                    if (h(this.f17695a)) {
                        wakeLock = this.f17697c;
                        wakeLock.release();
                    }
                } catch (Throwable th) {
                    if (h(this.f17695a)) {
                        try {
                            this.f17697c.release();
                        } catch (RuntimeException unused3) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e10) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e10.getMessage());
                this.f17698d.o(false);
                if (!h(this.f17695a)) {
                } else {
                    wakeLock = this.f17697c;
                }
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
