package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetSiteLinkUseCase_Factory implements Factory<GetSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private GetSiteLinkUseCase_Factory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSiteLinkUseCase get() {
        return newInstance(this.siteLinkRepositoryProvider.get());
    }

    public static GetSiteLinkUseCase_Factory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new GetSiteLinkUseCase_Factory(siteLinkRepositoryProvider);
    }

    public static GetSiteLinkUseCase newInstance(SiteLinkRepository siteLinkRepository) {
        return new GetSiteLinkUseCase(siteLinkRepository);
    }
}
