package com.example.bingwahybrid.domain.portal;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferRelay_Factory implements Factory<OfferRelay> {
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private OfferRelay_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfferRelay get() {
        return newInstance(this.offerRepositoryProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static OfferRelay_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new OfferRelay_Factory(offerRepositoryProvider, settingsRepositoryProvider);
    }

    public static OfferRelay newInstance(OfferRepository offerRepository, SettingsRepository settingsRepository) {
        return new OfferRelay(offerRepository, settingsRepository);
    }
}
