package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetCustomersUseCaseFactory implements Factory<GetCustomersUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideGetCustomersUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCustomersUseCase get() {
        return provideGetCustomersUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetCustomersUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideGetCustomersUseCaseFactory(customerRepositoryProvider);
    }

    public static GetCustomersUseCase provideGetCustomersUseCase(CustomerRepository customerRepository) {
        return (GetCustomersUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetCustomersUseCase(customerRepository));
    }
}
