package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.usecase.customer.UpdateCustomerInfoUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideUpdateCustomerInfoUseCaseFactory implements Factory<UpdateCustomerInfoUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideUpdateCustomerInfoUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateCustomerInfoUseCase get() {
        return provideUpdateCustomerInfoUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideUpdateCustomerInfoUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideUpdateCustomerInfoUseCaseFactory(customerRepositoryProvider);
    }

    public static UpdateCustomerInfoUseCase provideUpdateCustomerInfoUseCase(CustomerRepository customerRepository) {
        return (UpdateCustomerInfoUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUpdateCustomerInfoUseCase(customerRepository));
    }
}
