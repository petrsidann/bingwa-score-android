package b4;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference f2788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SoftReference f2789b;

    public Executor a() {
        ExecutorService executorServiceUnconfigurableExecutorService;
        synchronized (b.class) {
            SoftReference softReference = f2788a;
            executorServiceUnconfigurableExecutorService = softReference != null ? (ExecutorService) softReference.get() : null;
            if (executorServiceUnconfigurableExecutorService == null) {
                zze.zza();
                executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new k4.b("firebase-iid-executor")));
                f2788a = new SoftReference(executorServiceUnconfigurableExecutorService);
            }
        }
        return executorServiceUnconfigurableExecutorService;
    }

    public abstract int b(Context context, a aVar);

    public void c(Context context, Bundle bundle) {
    }

    public final /* synthetic */ void d(Intent intent, final Context context, boolean z10, BroadcastReceiver.PendingResult pendingResult) {
        Executor executorUnconfigurableExecutorService;
        int iE;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                iE = e(context, intent2);
            } else if (intent.getExtras() == null) {
                iE = 500;
            } else {
                final a aVar = new a(intent);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                synchronized (b.class) {
                    SoftReference softReference = f2789b;
                    executorUnconfigurableExecutorService = softReference != null ? (Executor) softReference.get() : null;
                    if (executorUnconfigurableExecutorService == null) {
                        zze.zza();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new k4.b("pscm-ack-executor"));
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                        f2789b = new SoftReference(executorUnconfigurableExecutorService);
                    }
                }
                executorUnconfigurableExecutorService.execute(new Runnable() { // from class: b4.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        Task taskC;
                        a aVar2 = aVar;
                        if (TextUtils.isEmpty(aVar2.T())) {
                            taskC = Tasks.forResult(null);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putString("google.message_id", aVar2.T());
                            Integer numU = aVar2.U();
                            if (numU != null) {
                                bundle.putInt("google.product_id", numU.intValue());
                            }
                            Context context2 = context;
                            bundle.putBoolean("supports_message_handled", true);
                            taskC = d0.b(context2).c(2, bundle);
                        }
                        final CountDownLatch countDownLatch2 = countDownLatch;
                        taskC.addOnCompleteListener(new Executor() { // from class: b4.m
                            @Override // java.util.concurrent.Executor
                            public final void execute(Runnable runnable) {
                                runnable.run();
                            }
                        }, new OnCompleteListener() { // from class: b4.n
                            @Override // com.google.android.gms.tasks.OnCompleteListener
                            public final void onComplete(Task task) {
                                countDownLatch2.countDown();
                            }
                        });
                    }
                });
                int iB = b(context, aVar);
                try {
                    if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                        Log.w("CloudMessagingReceiver", "Message ack timed out");
                    }
                } catch (InterruptedException e10) {
                    Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e10.toString()));
                }
                iE = iB;
            }
            if (z10 && pendingResult != null) {
                pendingResult.setResultCode(iE);
            }
            if (pendingResult != null) {
                pendingResult.finish();
            }
        } catch (Throwable th) {
            if (pendingResult != null) {
                pendingResult.finish();
            }
            throw th;
        }
    }

    public final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if (Objects.equals(intent.getAction(), "com.google.firebase.messaging.NOTIFICATION_DISMISS")) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean zIsOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        a().execute(new Runnable() { // from class: b4.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f2826a.d(intent, context, zIsOrderedBroadcast, pendingResultGoAsync);
            }
        });
    }
}
