package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetTransactionUseCase_Factory implements Factory<GetTransactionUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private GetTransactionUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static GetTransactionUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new GetTransactionUseCase_Factory(transactionRepositoryProvider);
    }

    public static GetTransactionUseCase newInstance(TransactionRepository transactionRepository) {
        return new GetTransactionUseCase(transactionRepository);
    }
}
