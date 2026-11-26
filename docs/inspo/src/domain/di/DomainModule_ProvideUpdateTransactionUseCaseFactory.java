package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideUpdateTransactionUseCaseFactory implements Factory<UpdateTransactionUseCase> {
    private final Provider<StatisticsRepository> statisticsRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideUpdateTransactionUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.statisticsRepositoryProvider = statisticsRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateTransactionUseCase get() {
        return provideUpdateTransactionUseCase(this.transactionRepositoryProvider.get(), this.statisticsRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DomainModule_ProvideUpdateTransactionUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DomainModule_ProvideUpdateTransactionUseCaseFactory(transactionRepositoryProvider, statisticsRepositoryProvider, transactionRelayProvider);
    }

    public static UpdateTransactionUseCase provideUpdateTransactionUseCase(TransactionRepository transactionRepository, StatisticsRepository statisticsRepository, TransactionRelay transactionRelay) {
        return (UpdateTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUpdateTransactionUseCase(transactionRepository, statisticsRepository, transactionRelay));
    }
}
