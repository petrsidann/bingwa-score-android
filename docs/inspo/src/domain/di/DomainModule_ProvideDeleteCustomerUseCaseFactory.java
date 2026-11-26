package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.customer.DeleteCustomerUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDeleteCustomerUseCaseFactory implements Factory<DeleteCustomerUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideDeleteCustomerUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteCustomerUseCase get() {
        return provideDeleteCustomerUseCase(this.customerRepositoryProvider.get(), this.transactionRepositoryProvider.get());
    }

    public static DomainModule_ProvideDeleteCustomerUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRepository> transactionRepositoryProvider) {
        return new DomainModule_ProvideDeleteCustomerUseCaseFactory(customerRepositoryProvider, transactionRepositoryProvider);
    }

    public static DeleteCustomerUseCase provideDeleteCustomerUseCase(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        return (DeleteCustomerUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDeleteCustomerUseCase(customerRepository, transactionRepository));
    }
}
