package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideObserveTransactionsUseCaseFactory implements Factory<ObserveTransactionsUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideObserveTransactionsUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObserveTransactionsUseCase get() {
        return provideObserveTransactionsUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideObserveTransactionsUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideObserveTransactionsUseCaseFactory(transactionRepositoryProvider);
    }

    public static ObserveTransactionsUseCase provideObserveTransactionsUseCase(TransactionRepository transactionRepository) {
        return (ObserveTransactionsUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideObserveTransactionsUseCase(transactionRepository));
    }
}
