package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ObserveTransactionStatusUseCase_Factory implements Factory<ObserveTransactionStatusUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private ObserveTransactionStatusUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObserveTransactionStatusUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static ObserveTransactionStatusUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new ObserveTransactionStatusUseCase_Factory(transactionRepositoryProvider);
    }

    public static ObserveTransactionStatusUseCase newInstance(TransactionRepository transactionRepository) {
        return new ObserveTransactionStatusUseCase(transactionRepository);
    }
}
