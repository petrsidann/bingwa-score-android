package com.example.bingwahybrid.presentation.subscriptions.viewmodels;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import com.example.bingwahybrid.domain.usecase.GetOrCreateCustomerUseCase;
import com.example.bingwahybrid.domain.usecase.ObserveTransactionStatusUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionPaymentViewModel_Factory implements Factory<SubscriptionPaymentViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider;
    private final Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<PaymentRepository> paymentRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private SubscriptionPaymentViewModel_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<PaymentRepository> paymentRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.paymentRepositoryProvider = paymentRepositoryProvider;
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.getOrCreateCustomerUseCaseProvider = getOrCreateCustomerUseCaseProvider;
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.observeTransactionStatusUseCaseProvider = observeTransactionStatusUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SubscriptionPaymentViewModel get() {
        return newInstance(this.authRepositoryProvider.get(), this.paymentRepositoryProvider.get(), this.dialUssdUseCaseProvider.get(), this.getOrCreateCustomerUseCaseProvider.get(), this.subscriptionRepositoryProvider.get(), this.offerRepositoryProvider.get(), this.observeTransactionStatusUseCaseProvider.get());
    }

    public static SubscriptionPaymentViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<PaymentRepository> paymentRepositoryProvider, Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetOrCreateCustomerUseCase> getOrCreateCustomerUseCaseProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<ObserveTransactionStatusUseCase> observeTransactionStatusUseCaseProvider) {
        return new SubscriptionPaymentViewModel_Factory(authRepositoryProvider, paymentRepositoryProvider, dialUssdUseCaseProvider, getOrCreateCustomerUseCaseProvider, subscriptionRepositoryProvider, offerRepositoryProvider, observeTransactionStatusUseCaseProvider);
    }

    public static SubscriptionPaymentViewModel newInstance(AuthRepository authRepository, PaymentRepository paymentRepository, DialUssdUseCase dialUssdUseCase, GetOrCreateCustomerUseCase getOrCreateCustomerUseCase, SubscriptionRepository subscriptionRepository, OfferRepository offerRepository, ObserveTransactionStatusUseCase observeTransactionStatusUseCase) {
        return new SubscriptionPaymentViewModel(authRepository, paymentRepository, dialUssdUseCase, getOrCreateCustomerUseCase, subscriptionRepository, offerRepository, observeTransactionStatusUseCase);
    }
}
