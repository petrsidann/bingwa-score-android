package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.RequestSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideRequestSiteLinkUseCaseFactory implements Factory<RequestSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DomainModule_ProvideRequestSiteLinkUseCaseFactory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RequestSiteLinkUseCase get() {
        return provideRequestSiteLinkUseCase(this.siteLinkRepositoryProvider.get());
    }

    public static DomainModule_ProvideRequestSiteLinkUseCaseFactory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DomainModule_ProvideRequestSiteLinkUseCaseFactory(siteLinkRepositoryProvider);
    }

    public static RequestSiteLinkUseCase provideRequestSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        return (RequestSiteLinkUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideRequestSiteLinkUseCase(siteLinkRepository));
    }
}
