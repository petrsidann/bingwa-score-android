package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.GetTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetTransactionUseCaseFactory implements Factory<GetTransactionUseCase> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideGetTransactionUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetTransactionUseCase get() {
        return provideGetTransactionUseCase(this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetTransactionUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideGetTransactionUseCaseFactory(transactionRepositoryProvider);
    }

    public static GetTransactionUseCase provideGetTransactionUseCase(TransactionRepository transactionRepository) {
        return (GetTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetTransactionUseCase(transactionRepository));
    }
}
