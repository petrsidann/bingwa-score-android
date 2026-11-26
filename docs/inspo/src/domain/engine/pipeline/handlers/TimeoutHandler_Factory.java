package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeoutHandler_Factory implements Factory<TimeoutHandler> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;
    private final Provider<UssdSessionManager> ussdSessionManagerProvider;
    private final Provider<UssdStepsRepository> ussdStepsRepositoryProvider;

    private TimeoutHandler_Factory(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<UssdSessionManager> ussdSessionManagerProvider) {
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.ussdStepsRepositoryProvider = ussdStepsRepositoryProvider;
        this.ussdSessionManagerProvider = ussdSessionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TimeoutHandler get() {
        return newInstance(this.updateTransactionUseCaseProvider.get(), this.settingsRepositoryProvider.get(), this.ussdStepsRepositoryProvider.get(), this.ussdSessionManagerProvider.get());
    }

    public static TimeoutHandler_Factory create(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<UssdSessionManager> ussdSessionManagerProvider) {
        return new TimeoutHandler_Factory(updateTransactionUseCaseProvider, settingsRepositoryProvider, ussdStepsRepositoryProvider, ussdSessionManagerProvider);
    }

    public static TimeoutHandler newInstance(UpdateTransactionUseCase updateTransactionUseCase, SettingsRepository settingsRepository, UssdStepsRepository ussdStepsRepository, UssdSessionManager ussdSessionManager) {
        return new TimeoutHandler(updateTransactionUseCase, settingsRepository, ussdStepsRepository, ussdSessionManager);
    }
}
