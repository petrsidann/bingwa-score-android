package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionValidator_Factory implements Factory<SubscriptionValidator> {
    private final Provider<FeatureRepository> featureRepositoryProvider;
    private final Provider<OfferVerificationRepository> offerVerificationRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private SubscriptionValidator_Factory(Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider, Provider<FeatureRepository> featureRepositoryProvider) {
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.offerVerificationRepositoryProvider = offerVerificationRepositoryProvider;
        this.featureRepositoryProvider = featureRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SubscriptionValidator get() {
        return newInstance(this.subscriptionRepositoryProvider.get(), this.offerVerificationRepositoryProvider.get(), this.featureRepositoryProvider.get());
    }

    public static SubscriptionValidator_Factory create(Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider, Provider<FeatureRepository> featureRepositoryProvider) {
        return new SubscriptionValidator_Factory(subscriptionRepositoryProvider, offerVerificationRepositoryProvider, featureRepositoryProvider);
    }

    public static SubscriptionValidator newInstance(SubscriptionRepository subscriptionRepository, OfferVerificationRepository offerVerificationRepository, FeatureRepository featureRepository) {
        return new SubscriptionValidator(subscriptionRepository, offerVerificationRepository, featureRepository);
    }
}
