package com.example.bingwahybrid.domain.workers;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppUpdateWorkManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/example/bingwahybrid/domain/workers/AppUpdateWorkerManager;", "", "<init>", "()V", "scheduleAppUpdateWorker", "", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateWorkerManager {
    public static final int $stable = 0;
    public static final AppUpdateWorkerManager INSTANCE = new AppUpdateWorkerManager();

    private AppUpdateWorkerManager() {
    }

    public final void scheduleAppUpdateWorker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkManager.INSTANCE.getInstance(context).enqueueUniquePeriodicWork("AppUpdateWorker", ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) AppUpdateWorker.class, 30L, TimeUnit.MINUTES).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
    }
}
