package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CreateTransactionUseCase_Factory implements Factory<CreateTransactionUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private CreateTransactionUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateTransactionUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.customerRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static CreateTransactionUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new CreateTransactionUseCase_Factory(transactionRepositoryProvider, customerRepositoryProvider, transactionRelayProvider);
    }

    public static CreateTransactionUseCase newInstance(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        return new CreateTransactionUseCase(transactionRepository, customerRepository, transactionRelay);
    }
}
