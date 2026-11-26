package com.example.bingwahybrid.presentation.community.viewmodel;

import com.example.bingwahybrid.domain.features.repository.FeatureRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.usecase.CreateVerifiedOfferUseCase;
import com.example.bingwahybrid.domain.offers.usecase.DeleteOfferUseCase;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CommunityOffersViewModel_Factory implements Factory<CommunityOffersViewModel> {
    private final Provider<CreateVerifiedOfferUseCase> createVerifiedOfferUseCaseProvider;
    private final Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider;
    private final Provider<FeatureRepository> featureRepositoryProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private CommunityOffersViewModel_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<CreateVerifiedOfferUseCase> createVerifiedOfferUseCaseProvider, Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider, Provider<FeatureRepository> featureRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.createVerifiedOfferUseCaseProvider = createVerifiedOfferUseCaseProvider;
        this.deleteOfferUseCaseProvider = deleteOfferUseCaseProvider;
        this.featureRepositoryProvider = featureRepositoryProvider;
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommunityOffersViewModel get() {
        return newInstance(this.offerRepositoryProvider.get(), this.createVerifiedOfferUseCaseProvider.get(), this.deleteOfferUseCaseProvider.get(), this.featureRepositoryProvider.get(), this.subscriptionRepositoryProvider.get());
    }

    public static CommunityOffersViewModel_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<CreateVerifiedOfferUseCase> createVerifiedOfferUseCaseProvider, Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider, Provider<FeatureRepository> featureRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        return new CommunityOffersViewModel_Factory(offerRepositoryProvider, createVerifiedOfferUseCaseProvider, deleteOfferUseCaseProvider, featureRepositoryProvider, subscriptionRepositoryProvider);
    }

    public static CommunityOffersViewModel newInstance(OfferRepository offerRepository, CreateVerifiedOfferUseCase createVerifiedOfferUseCase, DeleteOfferUseCase deleteOfferUseCase, FeatureRepository featureRepository, SubscriptionRepository subscriptionRepository) {
        return new CommunityOffersViewModel(offerRepository, createVerifiedOfferUseCase, deleteOfferUseCase, featureRepository, subscriptionRepository);
    }
}
