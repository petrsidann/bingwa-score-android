package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideRescheduleTransactionUseCaseFactory implements Factory<RescheduleTransactionUseCase> {
    private final Provider<CreateTransactionUseCase> createTransactionUseCaseProvider;
    private final Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideRescheduleTransactionUseCaseFactory(Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.createTransactionUseCaseProvider = createTransactionUseCaseProvider;
        this.deleteTransactionUseCaseProvider = deleteTransactionUseCaseProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RescheduleTransactionUseCase get() {
        return provideRescheduleTransactionUseCase(this.createTransactionUseCaseProvider.get(), this.deleteTransactionUseCaseProvider.get(), this.dialUssdUseCaseProvider.get(), this.transactionRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DomainModule_ProvideRescheduleTransactionUseCaseFactory create(Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<DeleteTransactionUseCase> deleteTransactionUseCaseProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DomainModule_ProvideRescheduleTransactionUseCaseFactory(createTransactionUseCaseProvider, deleteTransactionUseCaseProvider, dialUssdUseCaseProvider, transactionRepositoryProvider, transactionRelayProvider);
    }

    public static RescheduleTransactionUseCase provideRescheduleTransactionUseCase(CreateTransactionUseCase createTransactionUseCase, DeleteTransactionUseCase deleteTransactionUseCase, DialUssdUseCase dialUssdUseCase, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        return (RescheduleTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideRescheduleTransactionUseCase(createTransactionUseCase, deleteTransactionUseCase, dialUssdUseCase, transactionRepository, transactionRelay));
    }
}
