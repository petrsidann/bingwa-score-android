package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ObserveTransactionsUseCase_Factory implements Factory<ObserveTransactionsUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private ObserveTransactionsUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ObserveTransactionsUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static ObserveTransactionsUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new ObserveTransactionsUseCase_Factory(transactionRepositoryProvider);
    }

    public static ObserveTransactionsUseCase newInstance(TransactionRepository transactionRepository) {
        return new ObserveTransactionsUseCase(transactionRepository);
    }
}
