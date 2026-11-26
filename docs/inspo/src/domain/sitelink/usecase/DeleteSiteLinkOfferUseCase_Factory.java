package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteSiteLinkOfferUseCase_Factory implements Factory<DeleteSiteLinkOfferUseCase> {
    private final Provider<OfferRepository> offerRepositoryProvider;

    private DeleteSiteLinkOfferUseCase_Factory(Provider<OfferRepository> offerRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteSiteLinkOfferUseCase get() {
        return newInstance(this.offerRepositoryProvider.get());
    }

    public static DeleteSiteLinkOfferUseCase_Factory create(Provider<OfferRepository> offerRepositoryProvider) {
        return new DeleteSiteLinkOfferUseCase_Factory(offerRepositoryProvider);
    }

    public static DeleteSiteLinkOfferUseCase newInstance(OfferRepository offerRepository) {
        return new DeleteSiteLinkOfferUseCase(offerRepository);
    }
}
