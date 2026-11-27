package b4;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f2790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static PendingIntent f2791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Executor f2792j = new Executor() { // from class: b4.g0
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f2793k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f2796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f2797d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Messenger f2799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f2800g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t.g f2794a = new t.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Messenger f2798e = new Messenger(new i(this, Looper.getMainLooper()));

    public c(Context context) {
        this.f2795b = context;
        this.f2796c = new e0(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2797d = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ Task e(Bundle bundle) {
        return m(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    public static /* bridge */ /* synthetic */ void g(c cVar, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new k());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof l) {
                        cVar.f2800g = (l) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        cVar.f2799f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = f2793k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        cVar.l(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (cVar.f2794a) {
                        for (int i10 = 0; i10 < cVar.f2794a.size(); i10++) {
                            cVar.l((String) cVar.f2794a.i(i10), intent2.getExtras());
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !Objects.equals(strArrSplit[1], "ID")) {
                    Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(":")) {
                    strSubstring = strSubstring.substring(1);
                }
                cVar.l(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    public static synchronized String j() {
        int i10;
        i10 = f2790h;
        f2790h = i10 + 1;
        return Integer.toString(i10);
    }

    public static synchronized void k(Context context, Intent intent) {
        if (f2791i == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            f2791i = PendingIntent.getBroadcast(context, 0, intent2, zza.zza);
        }
        intent.putExtra("app", f2791i);
    }

    public static boolean m(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task<a> a() {
        return this.f2796c.a() >= 241100000 ? d0.b(this.f2795b).d(5, Bundle.EMPTY).continueWith(f2792j, new Continuation() { // from class: b4.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Intent intent = (Intent) ((Bundle) task.getResult()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
            }
        }) : Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public Task<Void> b(a aVar) {
        if (this.f2796c.a() < 233700000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", aVar.T());
        Integer numU = aVar.U();
        if (numU != null) {
            bundle.putInt("google.product_id", numU.intValue());
        }
        return d0.b(this.f2795b).c(3, bundle);
    }

    public Task<Bundle> c(final Bundle bundle) {
        if (this.f2796c.a() < 12000000) {
            return this.f2796c.b() != 0 ? i(bundle).continueWithTask(f2792j, new Continuation() { // from class: b4.h0
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return this.f2817a.f(bundle, task);
                }
            }) : Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return d0.b(this.f2795b).d(1, bundle).continueWith(f2792j, new Continuation() { // from class: b4.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws IOException {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(task.getException())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
            }
        });
    }

    public Task<Void> d(boolean z10) {
        if (this.f2796c.a() < 241100000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z10);
        return d0.b(this.f2795b).c(4, bundle);
    }

    public final /* synthetic */ Task f(Bundle bundle, Task task) {
        return (task.isSuccessful() && m((Bundle) task.getResult())) ? i(bundle).onSuccessTask(f2792j, new SuccessContinuation() { // from class: b4.f0
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return c.e((Bundle) obj);
            }
        }) : task;
    }

    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f2794a) {
            this.f2794a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ac  */
    public final Task i(Bundle bundle) {
        final String strJ = j();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f2794a) {
            this.f2794a.put(strJ, taskCompletionSource);
        }
        Intent intent = new Intent();
        intent.setPackage("com.google.android.gms");
        intent.setAction(this.f2796c.b() == 2 ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
        intent.putExtras(bundle);
        k(this.f2795b, intent);
        intent.putExtra("kid", "|ID|" + strJ + "|");
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending ".concat(String.valueOf(intent.getExtras())));
        }
        intent.putExtra("google.messenger", this.f2798e);
        if (this.f2799f != null || this.f2800g != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = intent;
            try {
                Messenger messenger = this.f2799f;
                if (messenger != null) {
                    messenger.send(messageObtain);
                } else {
                    this.f2800g.b(messageObtain);
                }
            } catch (RemoteException unused) {
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                if (this.f2796c.b() == 2) {
                    this.f2795b.sendBroadcast(intent);
                } else {
                    this.f2795b.startService(intent);
                }
            }
        } else if (this.f2796c.b() == 2) {
            this.f2795b.sendBroadcast(intent);
        } else {
            this.f2795b.startService(intent);
        }
        final ScheduledFuture<?> scheduledFutureSchedule = this.f2797d.schedule(new Runnable() { // from class: b4.g
            @Override // java.lang.Runnable
            public final void run() {
                if (taskCompletionSource.trySetException(new IOException("TIMEOUT"))) {
                    Log.w("Rpc", "No response");
                }
            }
        }, 30L, TimeUnit.SECONDS);
        taskCompletionSource.getTask().addOnCompleteListener(f2792j, new OnCompleteListener() { // from class: b4.h
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f2814a.h(strJ, scheduledFutureSchedule, task);
            }
        });
        return taskCompletionSource.getTask();
    }

    public final void l(String str, Bundle bundle) {
        synchronized (this.f2794a) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f2794a.remove(str);
            if (taskCompletionSource != null) {
                taskCompletionSource.setResult(bundle);
                return;
            }
            Log.w("Rpc", "Missing callback for " + str);
        }
    }
}
