package w8;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f17760c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static i1 f17761d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f17763b = new x1.b();

    public l(Context context) {
        this.f17762a = context;
    }

    public static Task<Integer> e(Context context, Intent intent, boolean z10) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        i1 i1VarF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z10) {
            return i1VarF.d(intent).continueWith(new x1.b(), new Continuation() { // from class: w8.k
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return l.g(task);
                }
            });
        }
        if (t0.b().e(context)) {
            d1.f(context, i1VarF, intent);
        } else {
            i1VarF.d(intent);
        }
        return Tasks.forResult(-1);
    }

    public static i1 f(Context context, String str) {
        i1 i1Var;
        synchronized (f17760c) {
            if (f17761d == null) {
                f17761d = new i1(context, str);
            }
            i1Var = f17761d;
        }
        return i1Var;
    }

    public static /* synthetic */ Integer g(Task task) {
        return -1;
    }

    public static /* synthetic */ Integer h(Context context, Intent intent) {
        return Integer.valueOf(t0.b().g(context, intent));
    }

    public static /* synthetic */ Integer i(Task task) {
        return 403;
    }

    public static /* synthetic */ Task j(Context context, Intent intent, boolean z10, Task task) {
        return (j4.m.e() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z10).continueWith(new x1.b(), new Continuation() { // from class: w8.j
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return l.i(task2);
            }
        }) : task;
    }

    public Task<Integer> k(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return l(this.f17762a, intent);
    }

    public Task<Integer> l(final Context context, final Intent intent) {
        boolean z10 = j4.m.e() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z11 = (intent.getFlags() & 268435456) != 0;
        return (!z10 || z11) ? Tasks.call(this.f17763b, new Callable() { // from class: w8.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return l.h(context, intent);
            }
        }).continueWithTask(this.f17763b, new Continuation() { // from class: w8.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return l.j(context, intent, z11, task);
            }
        }) : e(context, intent, z11);
    }
}
