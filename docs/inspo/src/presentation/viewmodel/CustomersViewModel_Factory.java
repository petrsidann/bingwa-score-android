package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionsUseCase;
import com.example.bingwahybrid.domain.usecase.customer.DeleteCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.customer.UpdateCustomerInfoUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomersViewModel_Factory implements Factory<CustomersViewModel> {
    private final Provider<DeleteCustomerUseCase> deleteCustomerUseCaseProvider;
    private final Provider<GetCustomersUseCase> getCustomersUseCaseProvider;
    private final Provider<ObserveTransactionsUseCase> observeTransactionsUseCaseProvider;
    private final Provider<UpdateCustomerInfoUseCase> updateCustomerInfoUseCaseProvider;

    private CustomersViewModel_Factory(Provider<GetCustomersUseCase> getCustomersUseCaseProvider, Provider<UpdateCustomerInfoUseCase> updateCustomerInfoUseCaseProvider, Provider<DeleteCustomerUseCase> deleteCustomerUseCaseProvider, Provider<ObserveTransactionsUseCase> observeTransactionsUseCaseProvider) {
        this.getCustomersUseCaseProvider = getCustomersUseCaseProvider;
        this.updateCustomerInfoUseCaseProvider = updateCustomerInfoUseCaseProvider;
        this.deleteCustomerUseCaseProvider = deleteCustomerUseCaseProvider;
        this.observeTransactionsUseCaseProvider = observeTransactionsUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CustomersViewModel get() {
        return newInstance(this.getCustomersUseCaseProvider.get(), this.updateCustomerInfoUseCaseProvider.get(), this.deleteCustomerUseCaseProvider.get(), this.observeTransactionsUseCaseProvider.get());
    }

    public static CustomersViewModel_Factory create(Provider<GetCustomersUseCase> getCustomersUseCaseProvider, Provider<UpdateCustomerInfoUseCase> updateCustomerInfoUseCaseProvider, Provider<DeleteCustomerUseCase> deleteCustomerUseCaseProvider, Provider<ObserveTransactionsUseCase> observeTransactionsUseCaseProvider) {
        return new CustomersViewModel_Factory(getCustomersUseCaseProvider, updateCustomerInfoUseCaseProvider, deleteCustomerUseCaseProvider, observeTransactionsUseCaseProvider);
    }

    public static CustomersViewModel newInstance(GetCustomersUseCase getCustomersUseCase, UpdateCustomerInfoUseCase updateCustomerInfoUseCase, DeleteCustomerUseCase deleteCustomerUseCase, ObserveTransactionsUseCase observeTransactionsUseCase) {
        return new CustomersViewModel(getCustomersUseCase, updateCustomerInfoUseCase, deleteCustomerUseCase, observeTransactionsUseCase);
    }
}
