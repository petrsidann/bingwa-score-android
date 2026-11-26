package com.example.bingwahybrid.domain.offers.usecase;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CreateVerifiedOfferUseCase_Factory implements Factory<CreateVerifiedOfferUseCase> {
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<OfferVerificationRepository> offerVerificationRepositoryProvider;

    private CreateVerifiedOfferUseCase_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.offerVerificationRepositoryProvider = offerVerificationRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateVerifiedOfferUseCase get() {
        return newInstance(this.offerRepositoryProvider.get(), this.offerVerificationRepositoryProvider.get());
    }

    public static CreateVerifiedOfferUseCase_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        return new CreateVerifiedOfferUseCase_Factory(offerRepositoryProvider, offerVerificationRepositoryProvider);
    }

    public static CreateVerifiedOfferUseCase newInstance(OfferRepository offerRepository, OfferVerificationRepository offerVerificationRepository) {
        return new CreateVerifiedOfferUseCase(offerRepository, offerVerificationRepository);
    }
}
