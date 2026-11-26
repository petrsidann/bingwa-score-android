package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetCustomersUseCase_Factory implements Factory<GetCustomersUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private GetCustomersUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCustomersUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static GetCustomersUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new GetCustomersUseCase_Factory(customerRepositoryProvider);
    }

    public static GetCustomersUseCase newInstance(CustomerRepository customerRepository) {
        return new GetCustomersUseCase(customerRepository);
    }
}
