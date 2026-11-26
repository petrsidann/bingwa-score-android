package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoTimeValidator_Factory implements Factory<AutoTimeValidator> {
    private final Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private AutoTimeValidator_Factory(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        this.deviceSettingsRepositoryProvider = deviceSettingsRepositoryProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoTimeValidator get() {
        return newInstance(this.deviceSettingsRepositoryProvider.get(), this.transactionRepositoryProvider.get(), this.updateTransactionUseCaseProvider.get());
    }

    public static AutoTimeValidator_Factory create(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        return new AutoTimeValidator_Factory(deviceSettingsRepositoryProvider, transactionRepositoryProvider, updateTransactionUseCaseProvider);
    }

    public static AutoTimeValidator newInstance(DeviceSettingsRepository deviceSettingsRepository, TransactionRepository transactionRepository, UpdateTransactionUseCase updateTransactionUseCase) {
        return new AutoTimeValidator(deviceSettingsRepository, transactionRepository, updateTransactionUseCase);
    }
}
