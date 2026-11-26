package com.example.bingwahybrid.domain.usecase.customer;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateCustomerInfoUseCase_Factory implements Factory<UpdateCustomerInfoUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private UpdateCustomerInfoUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateCustomerInfoUseCase get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static UpdateCustomerInfoUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new UpdateCustomerInfoUseCase_Factory(customerRepositoryProvider);
    }

    public static UpdateCustomerInfoUseCase newInstance(CustomerRepository customerRepository) {
        return new UpdateCustomerInfoUseCase(customerRepository);
    }
}
