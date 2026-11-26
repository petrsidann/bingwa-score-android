package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideActivateSiteLinkUseCaseFactory implements Factory<ActivateSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DomainModule_ProvideActivateSiteLinkUseCaseFactory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ActivateSiteLinkUseCase get() {
        return provideActivateSiteLinkUseCase(this.siteLinkRepositoryProvider.get());
    }

    public static DomainModule_ProvideActivateSiteLinkUseCaseFactory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DomainModule_ProvideActivateSiteLinkUseCaseFactory(siteLinkRepositoryProvider);
    }

    public static ActivateSiteLinkUseCase provideActivateSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        return (ActivateSiteLinkUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideActivateSiteLinkUseCase(siteLinkRepository));
    }
}
