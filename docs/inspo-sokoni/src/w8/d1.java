package w8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f17712a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f17713b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static y4.a f17714c;

    public static void b(Context context) {
        if (f17714c == null) {
            y4.a aVar = new y4.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f17714c = aVar;
            aVar.d(true);
        }
    }

    public static void c(Intent intent) {
        synchronized (f17713b) {
            if (f17714c != null && d(intent)) {
                g(intent, false);
                f17714c.c();
            }
        }
    }

    public static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    public static void f(Context context, i1 i1Var, final Intent intent) {
        synchronized (f17713b) {
            b(context);
            boolean zD = d(intent);
            g(intent, true);
            if (!zD) {
                f17714c.a(f17712a);
            }
            i1Var.d(intent).addOnCompleteListener(new OnCompleteListener() { // from class: w8.c1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    d1.c(intent);
                }
            });
        }
    }

    public static void g(Intent intent, boolean z10) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z10);
    }

    public static ComponentName h(Context context, Intent intent) {
        synchronized (f17713b) {
            b(context);
            boolean zD = d(intent);
            g(intent, true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!zD) {
                f17714c.a(f17712a);
            }
            return componentNameStartService;
        }
    }
}
