package w8;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f17708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f17709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.messaging.c f17710c;

    public d(Context context, com.google.firebase.messaging.c cVar, ExecutorService executorService) {
        this.f17708a = executorService;
        this.f17709b = context;
        this.f17710c = cVar;
    }

    public boolean a() {
        if (this.f17710c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        g0 g0VarD = d();
        c.a aVarE = c.e(this.f17709b, this.f17710c);
        e(aVarE.f17703a, g0VarD);
        c(aVarE);
        return true;
    }

    public final boolean b() {
        if (((KeyguardManager) this.f17709b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!j4.m.c()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f17709b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public final void c(c.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f17709b.getSystemService("notification")).notify(aVar.f17704b, aVar.f17705c, aVar.f17703a.c());
    }

    public final g0 d() {
        g0 g0VarT = g0.t(this.f17710c.p("gcm.n.image"));
        if (g0VarT != null) {
            g0VarT.B(this.f17708a);
        }
        return g0VarT;
    }

    public final void e(e0.q.e eVar, g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.await(g0Var.v(), 5L, TimeUnit.SECONDS);
            eVar.v(bitmap);
            eVar.K(new e0.q.b().p(bitmap).o(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            g0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e10) {
            Log.w("FirebaseMessaging", "Failed to download image: " + e10.getCause());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            g0Var.close();
        }
    }
}
