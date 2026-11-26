package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetOrCreateCustomerUseCase_Factory implements Factory<GetOrCreateCustomerUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private GetOrCreateCustomerUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetOrCreateCustomerUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static GetOrCreateCustomerUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new GetOrCreateCustomerUseCase_Factory(customerRepositoryProvider);
    }

    public static GetOrCreateCustomerUseCase newInstance(CustomerRepository customerRepository) {
        return new GetOrCreateCustomerUseCase(customerRepository);
    }
}
