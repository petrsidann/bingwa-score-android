package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DialPausedTransactionsUseCase_Factory implements Factory<DialPausedTransactionsUseCase> {
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DialPausedTransactionsUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DialPausedTransactionsUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.dialUssdUseCaseProvider.get());
    }

    public static DialPausedTransactionsUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider) {
        return new DialPausedTransactionsUseCase_Factory(transactionRepositoryProvider, dialUssdUseCaseProvider);
    }

    public static DialPausedTransactionsUseCase newInstance(TransactionRepository transactionRepository, DialUssdUseCase dialUssdUseCase) {
        return new DialPausedTransactionsUseCase(transactionRepository, dialUssdUseCase);
    }
}
