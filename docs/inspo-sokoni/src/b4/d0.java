package b4;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static d0 f2801e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f2803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x f2804c = new x(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2805d = 1;

    public d0(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f2803b = scheduledExecutorService;
        this.f2802a = context.getApplicationContext();
    }

    public static synchronized d0 b(Context context) {
        if (f2801e == null) {
            zze.zza();
            f2801e = new d0(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new k4.b("MessengerIpcClient"))));
        }
        return f2801e;
    }

    public final Task c(int i10, Bundle bundle) {
        return g(new z(f(), i10, bundle));
    }

    public final Task d(int i10, Bundle bundle) {
        return g(new c0(f(), i10, bundle));
    }

    public final synchronized int f() {
        int i10;
        i10 = this.f2805d;
        this.f2805d = i10 + 1;
        return i10;
    }

    public final synchronized Task g(a0 a0Var) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Queueing ".concat(a0Var.toString()));
        }
        if (!this.f2804c.g(a0Var)) {
            x xVar = new x(this, null);
            this.f2804c = xVar;
            xVar.g(a0Var);
        }
        return a0Var.f2785b.getTask();
    }
}
