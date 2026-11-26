package com.example.bingwahybrid.domain.usecase.customer;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteCustomerUseCase_Factory implements Factory<DeleteCustomerUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DeleteCustomerUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteCustomerUseCase get() {
        return newInstance(this.customerRepositoryProvider.get(), this.transactionRepositoryProvider.get());
    }

    public static DeleteCustomerUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DeleteCustomerUseCase_Factory(customerRepositoryProvider, transactionRepositoryProvider);
    }

    public static DeleteCustomerUseCase newInstance(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        return new DeleteCustomerUseCase(customerRepository, transactionRepository);
    }
}
