package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideCreateTransactionUseCaseFactory implements Factory<CreateTransactionUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideCreateTransactionUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateTransactionUseCase get() {
        return provideCreateTransactionUseCase(this.transactionRepositoryProvider.get(), this.customerRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DomainModule_ProvideCreateTransactionUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DomainModule_ProvideCreateTransactionUseCaseFactory(transactionRepositoryProvider, customerRepositoryProvider, transactionRelayProvider);
    }

    public static CreateTransactionUseCase provideCreateTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        return (CreateTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideCreateTransactionUseCase(transactionRepository, customerRepository, transactionRelay));
    }
}
