package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideRetryTransactionUseCaseFactory implements Factory<RetryTransactionUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private DomainModule_ProvideRetryTransactionUseCaseFactory(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<Context> contextProvider) {
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RetryTransactionUseCase get() {
        return provideRetryTransactionUseCase(this.updateTransactionUseCaseProvider.get(), this.dialUssdUseCaseProvider.get(), this.transactionRepositoryProvider.get(), this.contextProvider.get());
    }

    public static DomainModule_ProvideRetryTransactionUseCaseFactory create(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<Context> contextProvider) {
        return new DomainModule_ProvideRetryTransactionUseCaseFactory(updateTransactionUseCaseProvider, dialUssdUseCaseProvider, transactionRepositoryProvider, contextProvider);
    }

    public static RetryTransactionUseCase provideRetryTransactionUseCase(UpdateTransactionUseCase updateTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, Context context) {
        return (RetryTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideRetryTransactionUseCase(updateTransactionUseCase, dialUssdUseCase, transactionRepository, context));
    }
}
