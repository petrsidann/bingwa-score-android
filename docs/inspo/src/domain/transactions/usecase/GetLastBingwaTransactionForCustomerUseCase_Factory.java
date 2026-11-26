package com.example.bingwahybrid.domain.transactions.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetLastBingwaTransactionForCustomerUseCase_Factory implements Factory<GetLastBingwaTransactionForCustomerUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private GetLastBingwaTransactionForCustomerUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetLastBingwaTransactionForCustomerUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static GetLastBingwaTransactionForCustomerUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new GetLastBingwaTransactionForCustomerUseCase_Factory(transactionRepositoryProvider);
    }

    public static GetLastBingwaTransactionForCustomerUseCase newInstance(TransactionRepository transactionRepository) {
        return new GetLastBingwaTransactionForCustomerUseCase(transactionRepository);
    }
}
