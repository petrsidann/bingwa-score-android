package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.GetTransactionsForCustomerUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetTransactionsForCustomerUseCaseFactory implements Factory<GetTransactionsForCustomerUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideGetTransactionsForCustomerUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionsForCustomerUseCase get() {
        return provideGetTransactionsForCustomerUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetTransactionsForCustomerUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideGetTransactionsForCustomerUseCaseFactory(transactionRepositoryProvider);
    }

    public static GetTransactionsForCustomerUseCase provideGetTransactionsForCustomerUseCase(TransactionRepository transactionRepository) {
        return (GetTransactionsForCustomerUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetTransactionsForCustomerUseCase(transactionRepository));
    }
}
