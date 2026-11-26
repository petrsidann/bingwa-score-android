package com.example.bingwahybrid.domain.sitelink.usecase;

import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteSiteLinkUseCase_Factory implements Factory<DeleteSiteLinkUseCase> {
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;

    private DeleteSiteLinkUseCase_Factory(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteSiteLinkUseCase get() {
        return newInstance(this.siteLinkRepositoryProvider.get());
    }

    public static DeleteSiteLinkUseCase_Factory create(Provider<SiteLinkRepository> siteLinkRepositoryProvider) {
        return new DeleteSiteLinkUseCase_Factory(siteLinkRepositoryProvider);
    }

    public static DeleteSiteLinkUseCase newInstance(SiteLinkRepository siteLinkRepository) {
        return new DeleteSiteLinkUseCase(siteLinkRepository);
    }
}
