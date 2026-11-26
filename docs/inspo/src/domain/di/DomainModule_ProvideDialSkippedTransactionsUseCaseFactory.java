package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DialSkippedTransactionsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDialSkippedTransactionsUseCaseFactory implements Factory<DialSkippedTransactionsUseCase> {
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideDialSkippedTransactionsUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DialSkippedTransactionsUseCase get() {
        return provideDialSkippedTransactionsUseCase(this.transactionRepositoryProvider.get(), this.dialUssdUseCaseProvider.get());
    }

    public static DomainModule_ProvideDialSkippedTransactionsUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        return new DomainModule_ProvideDialSkippedTransactionsUseCaseFactory(transactionRepositoryProvider, dialUssdUseCaseProvider);
    }

    public static DialSkippedTransactionsUseCase provideDialSkippedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        return (DialSkippedTransactionsUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDialSkippedTransactionsUseCase(transactionRepository, dialUssdUseCase));
    }
}
