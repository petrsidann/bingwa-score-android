package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetSiteLinkUseCaseFactory implements Factory<GetSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DomainModule_ProvideGetSiteLinkUseCaseFactory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSiteLinkUseCase get() {
        return provideGetSiteLinkUseCase(this.siteLinkRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetSiteLinkUseCaseFactory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DomainModule_ProvideGetSiteLinkUseCaseFactory(siteLinkRepositoryProvider);
    }

    public static GetSiteLinkUseCase provideGetSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        return (GetSiteLinkUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetSiteLinkUseCase(siteLinkRepository));
    }
}
