package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetTransactionsForPeriodUseCase_Factory implements Factory<GetTransactionsForPeriodUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private GetTransactionsForPeriodUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionsForPeriodUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static GetTransactionsForPeriodUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new GetTransactionsForPeriodUseCase_Factory(transactionRepositoryProvider);
    }

    public static GetTransactionsForPeriodUseCase newInstance(TransactionRepository transactionRepository) {
        return new GetTransactionsForPeriodUseCase(transactionRepository);
    }
}
