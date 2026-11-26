package com.example.bingwahybrid.presentation.transactions.viewmodel;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import com.example.bingwahybrid.domain.usecase.RetryTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TransactionDetailsViewModel_Factory implements Factory<TransactionDetailsViewModel> {
    private final Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider;
    private final Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider;
    private final Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private TransactionDetailsViewModel_Factory(Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        this.deleteTransactionUseCaseProvider = deleteTransactionUseCaseProvider;
        this.retryTransactionUseCaseProvider = retryTransactionUseCaseProvider;
        this.observeTransactionStatusUseCaseProvider = observeTransactionStatusUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TransactionDetailsViewModel get() {
        return newInstance(this.deleteTransactionUseCaseProvider.get(), this.retryTransactionUseCaseProvider.get(), this.observeTransactionStatusUseCaseProvider.get(), this.transactionRepositoryProvider.get());
    }

    public static TransactionDetailsViewModel_Factory create(Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<RetryTransactionUseCase> retryTransactionUseCaseProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        return new TransactionDetailsViewModel_Factory(deleteTransactionUseCaseProvider, retryTransactionUseCaseProvider, observeTransactionStatusUseCaseProvider, transactionRepositoryProvider);
    }

    public static TransactionDetailsViewModel newInstance(DeleteTransactionUseCase deleteTransactionUseCase, RetryTransactionUseCase retryTransactionUseCase, ObserveTransactionStatusUseCase observeTransactionStatusUseCase, TransactionRepository transactionRepository) {
        return new TransactionDetailsViewModel(deleteTransactionUseCase, retryTransactionUseCase, observeTransactionStatusUseCase, transactionRepository);
    }
}
