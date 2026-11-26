package com.example.bingwahybrid.presentation.transactions.viewmodel;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TransactionsViewModel_Factory implements Factory<TransactionsViewModel> {
    private final Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider;
    private final Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private TransactionsViewModel_Factory(Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider) {
        this.retryTransactionUseCaseProvider = retryTransactionUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.deleteTransactionUseCaseProvider = deleteTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TransactionsViewModel get() {
        return newInstance(this.retryTransactionUseCaseProvider.get(), this.transactionRepositoryProvider.get(), this.deleteTransactionUseCaseProvider.get());
    }

    public static TransactionsViewModel_Factory create(Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider) {
        return new TransactionsViewModel_Factory(retryTransactionUseCaseProvider, transactionRepositoryProvider, deleteTransactionUseCaseProvider);
    }

    public static TransactionsViewModel newInstance(RetryTransactionUseCase retryTransactionUseCase, TransactionRepository transactionRepository, DeleteTransactionUseCase deleteTransactionUseCase) {
        return new TransactionsViewModel(retryTransactionUseCase, transactionRepository, deleteTransactionUseCase);
    }
}
