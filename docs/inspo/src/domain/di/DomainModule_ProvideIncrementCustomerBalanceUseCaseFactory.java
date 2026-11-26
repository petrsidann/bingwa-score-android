package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.statistics.usecase.IncrementCustomerBalanceUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideIncrementCustomerBalanceUseCaseFactory implements Factory<IncrementCustomerBalanceUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private DomainModule_ProvideIncrementCustomerBalanceUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IncrementCustomerBalanceUseCase get() {
        return provideIncrementCustomerBalanceUseCase(this.customerRepositoryProvider.get());
    }

    public static DomainModule_ProvideIncrementCustomerBalanceUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new DomainModule_ProvideIncrementCustomerBalanceUseCaseFactory(customerRepositoryProvider);
    }

    public static IncrementCustomerBalanceUseCase provideIncrementCustomerBalanceUseCase(CustomerRepository customerRepository) {
        return (IncrementCustomerBalanceUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideIncrementCustomerBalanceUseCase(customerRepository));
    }
}
