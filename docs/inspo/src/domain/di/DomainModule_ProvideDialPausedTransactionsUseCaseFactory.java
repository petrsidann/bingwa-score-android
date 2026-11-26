package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DialPausedTransactionsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDialPausedTransactionsUseCaseFactory implements Factory<DialPausedTransactionsUseCase> {
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideDialPausedTransactionsUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DialPausedTransactionsUseCase get() {
        return provideDialPausedTransactionsUseCase(this.transactionRepositoryProvider.get(), this.dialUssdUseCaseProvider.get());
    }

    public static DomainModule_ProvideDialPausedTransactionsUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        return new DomainModule_ProvideDialPausedTransactionsUseCaseFactory(transactionRepositoryProvider, dialUssdUseCaseProvider);
    }

    public static DialPausedTransactionsUseCase provideDialPausedTransactionsUseCase(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        return (DialPausedTransactionsUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDialPausedTransactionsUseCase(transactionRepository, dialUssdUseCase));
    }
}
