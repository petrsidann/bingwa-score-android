package com.example.bingwahybrid.domain.statistics.usecase;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class IncrementCustomerBalanceUseCase_Factory implements Factory<IncrementCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private IncrementCustomerBalanceUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IncrementCustomerBalanceUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static IncrementCustomerBalanceUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new IncrementCustomerBalanceUseCase_Factory(customerRepositoryProvider);
    }

    public static IncrementCustomerBalanceUseCase newInstance(CustomerRepository customerRepository) {
        return new IncrementCustomerBalanceUseCase(customerRepository);
    }
}
