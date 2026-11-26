package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AddAutoRenewTransactionViewModel_Factory implements Factory<AddAutoRenewTransactionViewModel> {
    private final Provider<CreateTransactionUseCase> createTransactionUseCaseProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;

    private AddAutoRenewTransactionViewModel_Factory(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider) {
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.createTransactionUseCaseProvider = createTransactionUseCaseProvider;
        this.getOrCreateCustomerUseCaseProvider = getOrCreateCustomerUseCaseProvider;
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AddAutoRenewTransactionViewModel get() {
        return newInstance(this.dialUssdUseCaseProvider.get(), this.createTransactionUseCaseProvider.get(), this.getOrCreateCustomerUseCaseProvider.get(), this.offerRepositoryProvider.get());
    }

    public static AddAutoRenewTransactionViewModel_Factory create(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider) {
        return new AddAutoRenewTransactionViewModel_Factory(dialUssdUseCaseProvider, createTransactionUseCaseProvider, getOrCreateCustomerUseCaseProvider, offerRepositoryProvider);
    }

    public static AddAutoRenewTransactionViewModel newInstance(DialUssdUseCase dialUssdUseCase, CreateTransactionUseCase createTransactionUseCase, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, OfferRepository offerRepository) {
        return new AddAutoRenewTransactionViewModel(dialUssdUseCase, createTransactionUseCase, getOrCreateCustomerUseCase, offerRepository);
    }
}
