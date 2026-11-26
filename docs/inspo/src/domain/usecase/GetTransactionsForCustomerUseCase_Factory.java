package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetTransactionsForCustomerUseCase_Factory implements Factory<GetTransactionsForCustomerUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private GetTransactionsForCustomerUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionsForCustomerUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static GetTransactionsForCustomerUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new GetTransactionsForCustomerUseCase_Factory(transactionRepositoryProvider);
    }

    public static GetTransactionsForCustomerUseCase newInstance(TransactionRepository transactionRepository) {
        return new GetTransactionsForCustomerUseCase(transactionRepository);
    }
}
