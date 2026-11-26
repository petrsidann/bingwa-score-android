package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RetryTransactionUseCase_Factory implements Factory<RetryTransactionUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private RetryTransactionUseCase_Factory(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<Context> contextProvider) {
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RetryTransactionUseCase get() {
        return newInstance(this.updateTransactionUseCaseProvider.get(), this.dialUssdUseCaseProvider.get(), this.transactionRepositoryProvider.get(), this.contextProvider.get());
    }

    public static RetryTransactionUseCase_Factory create(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<Context> contextProvider) {
        return new RetryTransactionUseCase_Factory(updateTransactionUseCaseProvider, dialUssdUseCaseProvider, transactionRepositoryProvider, contextProvider);
    }

    public static RetryTransactionUseCase newInstance(UpdateTransactionUseCase updateTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, Context context) {
        return new RetryTransactionUseCase(updateTransactionUseCase, dialUssdUseCase, transactionRepository, context);
    }
}
