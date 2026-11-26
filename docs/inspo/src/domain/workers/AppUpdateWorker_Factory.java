package com.example.bingwahybrid.domain.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AppUpdateWorker_Factory implements Factory<AppUpdateWorker> {
    private final Provider<Context> contextProvider;
    private final Provider<WorkerParameters> workerParamsProvider;

    private AppUpdateWorker_Factory(Provider<Context> contextProvider, Provider<WorkerParameters> workerParamsProvider) {
        this.contextProvider = contextProvider;
        this.workerParamsProvider = workerParamsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateWorker get() {
        return newInstance(this.contextProvider.get(), this.workerParamsProvider.get());
    }

    public static AppUpdateWorker_Factory create(Provider<Context> contextProvider, Provider<WorkerParameters> workerParamsProvider) {
        return new AppUpdateWorker_Factory(contextProvider, workerParamsProvider);
    }

    public static AppUpdateWorker newInstance(Context context, WorkerParameters workerParams) {
        return new AppUpdateWorker(context, workerParams);
    }
}
