package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivateSiteLinkUseCase_Factory implements Factory<ActivateSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private ActivateSiteLinkUseCase_Factory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ActivateSiteLinkUseCase get() {
        return newInstance(this.siteLinkRepositoryProvider.get());
    }

    public static ActivateSiteLinkUseCase_Factory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new ActivateSiteLinkUseCase_Factory(siteLinkRepositoryProvider);
    }

    public static ActivateSiteLinkUseCase newInstance(SiteLinkRepository siteLinkRepository) {
        return new ActivateSiteLinkUseCase(siteLinkRepository);
    }
}
