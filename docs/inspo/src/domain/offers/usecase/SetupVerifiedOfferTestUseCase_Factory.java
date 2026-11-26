package com.example.bingwahybrid.domain.offers.usecase;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SetupVerifiedOfferTestUseCase_Factory implements Factory<SetupVerifiedOfferTestUseCase> {
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<OfferVerificationRepository> offerVerificationRepositoryProvider;

    private SetupVerifiedOfferTestUseCase_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.offerVerificationRepositoryProvider = offerVerificationRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SetupVerifiedOfferTestUseCase get() {
        return newInstance(this.offerRepositoryProvider.get(), this.offerVerificationRepositoryProvider.get());
    }

    public static SetupVerifiedOfferTestUseCase_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        return new SetupVerifiedOfferTestUseCase_Factory(offerRepositoryProvider, offerVerificationRepositoryProvider);
    }

    public static SetupVerifiedOfferTestUseCase newInstance(OfferRepository offerRepository, OfferVerificationRepository offerVerificationRepository) {
        return new SetupVerifiedOfferTestUseCase(offerRepository, offerVerificationRepository);
    }
}
