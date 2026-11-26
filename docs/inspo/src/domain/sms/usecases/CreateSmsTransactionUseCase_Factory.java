package com.example.bingwahybrid.domain.sms.usecases;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CreateSmsTransactionUseCase_Factory implements Factory<CreateSmsTransactionUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private CreateSmsTransactionUseCase_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateSmsTransactionUseCase get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.customerRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static CreateSmsTransactionUseCase_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new CreateSmsTransactionUseCase_Factory(transactionRepositoryProvider, customerRepositoryProvider, transactionRelayProvider);
    }

    public static CreateSmsTransactionUseCase newInstance(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        return new CreateSmsTransactionUseCase(transactionRepository, customerRepository, transactionRelay);
    }
}
