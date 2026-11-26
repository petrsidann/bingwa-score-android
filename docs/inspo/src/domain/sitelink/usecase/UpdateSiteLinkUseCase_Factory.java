package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateSiteLinkUseCase_Factory implements Factory<UpdateSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private UpdateSiteLinkUseCase_Factory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateSiteLinkUseCase get() {
        return newInstance(this.siteLinkRepositoryProvider.get());
    }

    public static UpdateSiteLinkUseCase_Factory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new UpdateSiteLinkUseCase_Factory(siteLinkRepositoryProvider);
    }

    public static UpdateSiteLinkUseCase newInstance(SiteLinkRepository siteLinkRepository) {
        return new UpdateSiteLinkUseCase(siteLinkRepository);
    }
}
