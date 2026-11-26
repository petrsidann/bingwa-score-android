package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetLastTransactionForCustomerUseCase_Factory implements Factory<GetLastTransactionForCustomerUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private GetLastTransactionForCustomerUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetLastTransactionForCustomerUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static GetLastTransactionForCustomerUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new GetLastTransactionForCustomerUseCase_Factory(transactionRepositoryProvider);
    }

    public static GetLastTransactionForCustomerUseCase newInstance(TransactionRepository transactionRepository) {
        return new GetLastTransactionForCustomerUseCase(transactionRepository);
    }
}
