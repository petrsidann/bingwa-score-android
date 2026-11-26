package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.usecase.DecrementCustomerBalanceUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDecrementCustomerBalanceUseCaseFactory implements Factory<DecrementCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideDecrementCustomerBalanceUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DecrementCustomerBalanceUseCase get() {
        return provideDecrementCustomerBalanceUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideDecrementCustomerBalanceUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideDecrementCustomerBalanceUseCaseFactory(customerRepositoryProvider);
    }

    public static DecrementCustomerBalanceUseCase provideDecrementCustomerBalanceUseCase(CustomerRepository customerRepository) {
        return (DecrementCustomerBalanceUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDecrementCustomerBalanceUseCase(customerRepository));
    }
}
