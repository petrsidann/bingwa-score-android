package com.example.bingwahybrid.presentation.quickdial.viewmodel;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetCustomersUseCase;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class QuickDialViewModel_Factory implements Factory<QuickDialViewModel> {
    private final Provider<CreateTransactionUseCase> createTransactionUseCaseProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<GetCustomersUseCase> getCustomersUseCaseProvider;
    private final Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider;
    private final Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;

    private QuickDialViewModel_Factory(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetCustomersUseCase> getCustomersUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider) {
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.getCustomersUseCaseProvider = getCustomersUseCaseProvider;
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.getOrCreateCustomerUseCaseProvider = getOrCreateCustomerUseCaseProvider;
        this.createTransactionUseCaseProvider = createTransactionUseCaseProvider;
        this.observeTransactionStatusUseCaseProvider = observeTransactionStatusUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public QuickDialViewModel get() {
        return newInstance(this.dialUssdUseCaseProvider.get(), this.getCustomersUseCaseProvider.get(), this.offerRepositoryProvider.get(), this.getOrCreateCustomerUseCaseProvider.get(), this.createTransactionUseCaseProvider.get(), this.observeTransactionStatusUseCaseProvider.get());
    }

    public static QuickDialViewModel_Factory create(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetCustomersUseCase> getCustomersUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider) {
        return new QuickDialViewModel_Factory(dialUssdUseCaseProvider, getCustomersUseCaseProvider, offerRepositoryProvider, getOrCreateCustomerUseCaseProvider, createTransactionUseCaseProvider, observeTransactionStatusUseCaseProvider);
    }

    public static QuickDialViewModel newInstance(DialUssdUseCase dialUssdUseCase, GetCustomersUseCase getCustomersUseCase, OfferRepository offerRepository, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, CreateTransactionUseCase createTransactionUseCase, ObserveTransactionStatusUseCase observeTransactionStatusUseCase) {
        return new QuickDialViewModel(dialUssdUseCase, getCustomersUseCase, offerRepository, getOrCreateCustomerUseCase, createTransactionUseCase, observeTransactionStatusUseCase);
    }
}
