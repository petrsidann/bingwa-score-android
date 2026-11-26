package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RescheduleTransactionUseCase_Factory implements Factory<RescheduleTransactionUseCase> {
    private final Provider<CreateTransactionUseCase> createTransactionUseCaseProvider;
    private final Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private RescheduleTransactionUseCase_Factory(Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.createTransactionUseCaseProvider = createTransactionUseCaseProvider;
        this.deleteTransactionUseCaseProvider = deleteTransactionUseCaseProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RescheduleTransactionUseCase get() {
        return newInstance(this.createTransactionUseCaseProvider.get(), this.deleteTransactionUseCaseProvider.get(), this.dialUssdUseCaseProvider.get(), this.transactionRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static RescheduleTransactionUseCase_Factory create(Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new RescheduleTransactionUseCase_Factory(createTransactionUseCaseProvider, deleteTransactionUseCaseProvider, dialUssdUseCaseProvider, transactionRepositoryProvider, transactionRelayProvider);
    }

    public static RescheduleTransactionUseCase newInstance(CreateTransactionUseCase createTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        return new RescheduleTransactionUseCase(createTransactionUseCase, deleteTransactionUseCase, dialUssdUseCase, transactionRepository, transactionRelay);
    }
}
