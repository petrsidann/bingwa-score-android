package com.example.bingwahybrid.domain.offers.usecase;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteOfferUseCase_Factory implements Factory<DeleteOfferUseCase> {
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<OfferVerificationRepository> offerVerificationRepositoryProvider;

    private DeleteOfferUseCase_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.offerVerificationRepositoryProvider = offerVerificationRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteOfferUseCase get() {
        return newInstance(this.offerRepositoryProvider.get(), this.offerVerificationRepositoryProvider.get());
    }

    public static DeleteOfferUseCase_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider) {
        return new DeleteOfferUseCase_Factory(offerRepositoryProvider, offerVerificationRepositoryProvider);
    }

    public static DeleteOfferUseCase newInstance(OfferRepository offerRepository, OfferVerificationRepository offerVerificationRepository) {
        return new DeleteOfferUseCase(offerRepository, offerVerificationRepository);
    }
}
