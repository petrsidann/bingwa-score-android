package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.GetLastTransactionForCustomerUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetLastTransactionForCustomerUseCaseFactory implements Factory<GetLastTransactionForCustomerUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideGetLastTransactionForCustomerUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetLastTransactionForCustomerUseCase get() {
        return provideGetLastTransactionForCustomerUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetLastTransactionForCustomerUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideGetLastTransactionForCustomerUseCaseFactory(transactionRepositoryProvider);
    }

    public static GetLastTransactionForCustomerUseCase provideGetLastTransactionForCustomerUseCase(TransactionRepository transactionRepository) {
        return (GetLastTransactionForCustomerUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetLastTransactionForCustomerUseCase(transactionRepository));
    }
}
