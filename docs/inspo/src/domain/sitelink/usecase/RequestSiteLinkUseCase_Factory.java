package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestSiteLinkUseCase_Factory implements Factory<RequestSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private RequestSiteLinkUseCase_Factory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RequestSiteLinkUseCase get() {
        return newInstance(this.siteLinkRepositoryProvider.get());
    }

    public static RequestSiteLinkUseCase_Factory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new RequestSiteLinkUseCase_Factory(siteLinkRepositoryProvider);
    }

    public static RequestSiteLinkUseCase newInstance(SiteLinkRepository siteLinkRepository) {
        return new RequestSiteLinkUseCase(siteLinkRepository);
    }
}
