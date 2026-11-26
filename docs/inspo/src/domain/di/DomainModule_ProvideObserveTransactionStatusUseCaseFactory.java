package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideObserveTransactionStatusUseCaseFactory implements Factory<ObserveTransactionStatusUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideObserveTransactionStatusUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObserveTransactionStatusUseCase get() {
        return provideObserveTransactionStatusUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideObserveTransactionStatusUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideObserveTransactionStatusUseCaseFactory(transactionRepositoryProvider);
    }

    public static ObserveTransactionStatusUseCase provideObserveTransactionStatusUseCase(TransactionRepository transactionRepository) {
        return (ObserveTransactionStatusUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideObserveTransactionStatusUseCase(transactionRepository));
    }
}
