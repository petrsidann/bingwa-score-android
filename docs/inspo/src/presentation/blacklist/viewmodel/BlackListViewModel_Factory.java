package com.example.bingwahybrid.presentation.blacklist.viewmodel;

import com.example.bingwahybrid.domain.repository.CustomerRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class BlackListViewModel_Factory implements Factory<BlackListViewModel> {
    private final Provider<CustomerRepository> customerRepositoryProvider;

    private BlackListViewModel_Factory(Provider<CustomerRepository> customerRepositoryProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BlackListViewModel get() {
        return newInstance(this.customerRepositoryProvider.get());
    }

    public static BlackListViewModel_Factory create(Provider<CustomerRepository> customerRepositoryProvider) {
        return new BlackListViewModel_Factory(customerRepositoryProvider);
    }

    public static BlackListViewModel newInstance(CustomerRepository customerRepository) {
        return new BlackListViewModel(customerRepository);
    }
}
