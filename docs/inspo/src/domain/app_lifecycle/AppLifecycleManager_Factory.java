package com.example.bingwahybrid.domain.app_lifecycle;

import android.content.Context;
import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AppLifecycleManager_Factory implements Factory<AppLifecycleManager> {
    private final Provider<AppControl> appControlProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DialPausedTransactionsUseCase> dialPausedTransactionsUseCaseProvider;
    private final Provider<DialSkippedTransactionsUseCase> dialSkippedTransactionsUseCaseProvider;
    private final Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private AppLifecycleManager_Factory(Provider<Context> contextProvider, Provider<AppControl> appControlProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialSkippedTransactionsUseCase> dialSkippedTransactionsUseCaseProvider, Provider<DialPausedTransactionsUseCase> dialPausedTransactionsUseCaseProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        this.contextProvider = contextProvider;
        this.appControlProvider = appControlProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.dialSkippedTransactionsUseCaseProvider = dialSkippedTransactionsUseCaseProvider;
        this.dialPausedTransactionsUseCaseProvider = dialPausedTransactionsUseCaseProvider;
        this.fcmTokenRegistrationHelperProvider = fcmTokenRegistrationHelperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppLifecycleManager get() {
        return newInstance(this.contextProvider.get(), this.appControlProvider.get(), this.transactionRepositoryProvider.get(), this.dialSkippedTransactionsUseCaseProvider.get(), this.dialPausedTransactionsUseCaseProvider.get(), this.fcmTokenRegistrationHelperProvider.get());
    }

    public static AppLifecycleManager_Factory create(Provider<Context> contextProvider, Provider<AppControl> appControlProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialSkippedTransactionsUseCase> dialSkippedTransactionsUseCaseProvider, Provider<DialPausedTransactionsUseCase> dialPausedTransactionsUseCaseProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        return new AppLifecycleManager_Factory(contextProvider, appControlProvider, transactionRepositoryProvider, dialSkippedTransactionsUseCaseProvider, dialPausedTransactionsUseCaseProvider, fcmTokenRegistrationHelperProvider);
    }

    public static AppLifecycleManager newInstance(Context context, AppControl appControl, TransactionRepository transactionRepository, DialSkippedTransactionsUseCase dialSkippedTransactionsUseCase, DialPausedTransactionsUseCase dialPausedTransactionsUseCase, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        return new AppLifecycleManager(context, appControl, transactionRepository, dialSkippedTransactionsUseCase, dialPausedTransactionsUseCase, fcmTokenRegistrationHelper);
    }
}
