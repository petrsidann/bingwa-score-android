package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DecrementCustomerBalanceUseCase_Factory implements Factory<DecrementCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DecrementCustomerBalanceUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DecrementCustomerBalanceUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static DecrementCustomerBalanceUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DecrementCustomerBalanceUseCase_Factory(customerRepositoryProvider);
    }

    public static DecrementCustomerBalanceUseCase newInstance(CustomerRepository customerRepository) {
        return new DecrementCustomerBalanceUseCase(customerRepository);
    }
}
