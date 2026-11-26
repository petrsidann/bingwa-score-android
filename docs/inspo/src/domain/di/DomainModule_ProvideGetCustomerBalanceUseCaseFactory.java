package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.usecase.GetCustomerBalanceUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetCustomerBalanceUseCaseFactory implements Factory<GetCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideGetCustomerBalanceUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCustomerBalanceUseCase get() {
        return provideGetCustomerBalanceUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetCustomerBalanceUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideGetCustomerBalanceUseCaseFactory(customerRepositoryProvider);
    }

    public static GetCustomerBalanceUseCase provideGetCustomerBalanceUseCase(CustomerRepository customerRepository) {
        return (GetCustomerBalanceUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetCustomerBalanceUseCase(customerRepository));
    }
}
