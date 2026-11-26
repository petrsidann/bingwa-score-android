package com.example.bingwahybrid.presentation.offers.viewmodel;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferSettingsViewModel_Factory implements Factory<OfferSettingsViewModel> {
    private final Provider<OfferRepository> offerRepositoryProvider;

    private OfferSettingsViewModel_Factory(Provider<OfferRepository> offerRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfferSettingsViewModel get() {
        return newInstance(this.offerRepositoryProvider.get());
    }

    public static OfferSettingsViewModel_Factory create(Provider<OfferRepository> offerRepositoryProvider) {
        return new OfferSettingsViewModel_Factory(offerRepositoryProvider);
    }

    public static OfferSettingsViewModel newInstance(OfferRepository offerRepository) {
        return new OfferSettingsViewModel(offerRepository);
    }
}
