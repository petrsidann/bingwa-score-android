package w8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f17798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FirebaseMessaging f17799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExecutorService f17800d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k4.b("firebase-iid-executor"));

    public static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w0 f17801a;

        public a(w0 w0Var) {
            this.f17801a = w0Var;
        }

        public void a() {
            if (w0.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.f17801a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            w0 w0Var = this.f17801a;
            if (w0Var != null && w0Var.d()) {
                if (w0.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f17801a.f17799c.q(this.f17801a, 0L);
                this.f17801a.b().unregisterReceiver(this);
                this.f17801a = null;
            }
        }
    }

    public w0(FirebaseMessaging firebaseMessaging, long j10) {
        this.f17799c = firebaseMessaging;
        this.f17797a = j10;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f17798b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    public Context b() {
        return this.f17799c.r();
    }

    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean e() throws IOException {
        String str;
        try {
            if (this.f17799c.o() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e10) {
            if (e0.i(e10.getMessage())) {
                str = "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval";
            } else {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                str = "Token retrieval failed without exception message. Will retry token retrieval";
            }
            Log.w("FirebaseMessaging", str);
            return false;
        } catch (SecurityException unused) {
            str = "Token retrieval failed with SecurityException. Will retry token retrieval";
            Log.w("FirebaseMessaging", str);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (t0.b().e(b())) {
            this.f17798b.acquire();
        }
        try {
            this.f17799c.S(true);
            if (!this.f17799c.C()) {
                this.f17799c.S(false);
            } else if (t0.b().d(b()) && !d()) {
                new a(this).a();
            } else {
                if (e()) {
                    this.f17799c.S(false);
                } else {
                    this.f17799c.X(this.f17797a);
                }
            }
        } catch (IOException e10) {
            Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
            this.f17799c.S(false);
        } finally {
            if (t0.b().e(b())) {
                this.f17798b.release();
            }
        }
    }
}
