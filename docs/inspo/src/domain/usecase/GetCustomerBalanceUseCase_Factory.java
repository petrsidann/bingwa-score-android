package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetCustomerBalanceUseCase_Factory implements Factory<GetCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private GetCustomerBalanceUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCustomerBalanceUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static GetCustomerBalanceUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new GetCustomerBalanceUseCase_Factory(customerRepositoryProvider);
    }

    public static GetCustomerBalanceUseCase newInstance(CustomerRepository customerRepository) {
        return new GetCustomerBalanceUseCase(customerRepository);
    }
}
