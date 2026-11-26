package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AddSiteLinkOfferViewModel_Factory implements Factory<AddSiteLinkOfferViewModel> {
    private final Provider<OfferRepository> offerRepositoryProvider;

    private AddSiteLinkOfferViewModel_Factory(Provider<OfferRepository> offerRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AddSiteLinkOfferViewModel get() {
        return newInstance(this.offerRepositoryProvider.get());
    }

    public static AddSiteLinkOfferViewModel_Factory create(Provider<OfferRepository> offerRepositoryProvider) {
        return new AddSiteLinkOfferViewModel_Factory(offerRepositoryProvider);
    }

    public static AddSiteLinkOfferViewModel newInstance(OfferRepository offerRepository) {
        return new AddSiteLinkOfferViewModel(offerRepository);
    }
}
