package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetOrCreateCustomerUseCaseFactory implements Factory<GetOrCreateCustomerUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideGetOrCreateCustomerUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetOrCreateCustomerUseCase get() {
        return provideGetOrCreateCustomerUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetOrCreateCustomerUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideGetOrCreateCustomerUseCaseFactory(customerRepositoryProvider);
    }

    public static GetOrCreateCustomerUseCase provideGetOrCreateCustomerUseCase(CustomerRepository customerRepository) {
        return (GetOrCreateCustomerUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetOrCreateCustomerUseCase(customerRepository));
    }
}
