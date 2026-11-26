package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.UpdateSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideUpdateSiteLinkUseCaseFactory implements Factory<UpdateSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DomainModule_ProvideUpdateSiteLinkUseCaseFactory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateSiteLinkUseCase get() {
        return provideUpdateSiteLinkUseCase(this.siteLinkRepositoryProvider.get());
    }

    public static DomainModule_ProvideUpdateSiteLinkUseCaseFactory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DomainModule_ProvideUpdateSiteLinkUseCaseFactory(siteLinkRepositoryProvider);
    }

    public static UpdateSiteLinkUseCase provideUpdateSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        return (UpdateSiteLinkUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUpdateSiteLinkUseCase(siteLinkRepository));
    }
}
