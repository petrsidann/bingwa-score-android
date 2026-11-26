package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.GetTransactionsForPeriodUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetTransactionsForPeriodUseCaseFactory implements Factory<GetTransactionsForPeriodUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideGetTransactionsForPeriodUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionsForPeriodUseCase get() {
        return provideGetTransactionsForPeriodUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetTransactionsForPeriodUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideGetTransactionsForPeriodUseCaseFactory(transactionRepositoryProvider);
    }

    public static GetTransactionsForPeriodUseCase provideGetTransactionsForPeriodUseCase(TransactionRepository transactionRepository) {
        return (GetTransactionsForPeriodUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetTransactionsForPeriodUseCase(transactionRepository));
    }
}
