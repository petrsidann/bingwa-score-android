package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateTransactionUseCase_Factory implements Factory<UpdateTransactionUseCase> {
    private final Provider<StatisticsRepository> statisticsRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private UpdateTransactionUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.statisticsRepositoryProvider = statisticsRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateTransactionUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.statisticsRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static UpdateTransactionUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new UpdateTransactionUseCase_Factory(transactionRepositoryProvider, statisticsRepositoryProvider, transactionRelayProvider);
    }

    public static UpdateTransactionUseCase newInstance(TransactionRepository transactionRepository, StatisticsRepository statisticsRepository, TransactionRelay transactionRelay) {
        return new UpdateTransactionUseCase(transactionRepository, statisticsRepository, transactionRelay);
    }
}
