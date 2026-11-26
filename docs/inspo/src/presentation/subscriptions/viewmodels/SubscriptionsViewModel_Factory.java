package com.example.bingwahybrid.presentation.subscriptions.viewmodels;

import com.example.bingwahybrid.domain.features.repository.FeaturePassRepository;
import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionsViewModel_Factory implements Factory<SubscriptionsViewModel> {
    private final Provider<FeaturePassRepository> featurePassRepositoryProvider;
    private final Provider<FeatureRepository> featureRepositoryProvider;
    private final Provider<PaymentRepository> paymentRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private SubscriptionsViewModel_Factory(Provider<FeatureRepository> featureRepositoryProvider, Provider<FeaturePassRepository> featurePassRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        this.featureRepositoryProvider = featureRepositoryProvider;
        this.featurePassRepositoryProvider = featurePassRepositoryProvider;
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.paymentRepositoryProvider = paymentRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SubscriptionsViewModel get() {
        return newInstance(this.featureRepositoryProvider.get(), this.featurePassRepositoryProvider.get(), this.subscriptionRepositoryProvider.get(), this.paymentRepositoryProvider.get());
    }

    public static SubscriptionsViewModel_Factory create(Provider<FeatureRepository> featureRepositoryProvider, Provider<FeaturePassRepository> featurePassRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        return new SubscriptionsViewModel_Factory(featureRepositoryProvider, featurePassRepositoryProvider, subscriptionRepositoryProvider, paymentRepositoryProvider);
    }

    public static SubscriptionsViewModel newInstance(FeatureRepository featureRepository, FeaturePassRepository featurePassRepository, SubscriptionRepository subscriptionRepository, PaymentRepository paymentRepository) {
        return new SubscriptionsViewModel(featureRepository, featurePassRepository, subscriptionRepository, paymentRepository);
    }
}
