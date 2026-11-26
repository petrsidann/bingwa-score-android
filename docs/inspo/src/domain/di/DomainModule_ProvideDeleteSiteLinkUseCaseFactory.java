package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDeleteSiteLinkUseCaseFactory implements Factory<DeleteSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DomainModule_ProvideDeleteSiteLinkUseCaseFactory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteSiteLinkUseCase get() {
        return provideDeleteSiteLinkUseCase(this.siteLinkRepositoryProvider.get());
    }

    public static DomainModule_ProvideDeleteSiteLinkUseCaseFactory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DomainModule_ProvideDeleteSiteLinkUseCaseFactory(siteLinkRepositoryProvider);
    }

    public static DeleteSiteLinkUseCase provideDeleteSiteLinkUseCase(SiteLinkRepository siteLinkRepository) {
        return (DeleteSiteLinkUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDeleteSiteLinkUseCase(siteLinkRepository));
    }
}
