package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalRetryHandler_Factory implements Factory<InternalRetryHandler> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private InternalRetryHandler_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InternalRetryHandler get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static InternalRetryHandler_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new InternalRetryHandler_Factory(transactionRepositoryProvider, settingsRepositoryProvider);
    }

    public static InternalRetryHandler newInstance(TransactionRepository transactionRepository, SettingsRepository settingsRepository) {
        return new InternalRetryHandler(transactionRepository, settingsRepository);
    }
}
