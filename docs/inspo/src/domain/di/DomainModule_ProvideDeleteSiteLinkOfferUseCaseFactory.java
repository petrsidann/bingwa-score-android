package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkOfferUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDeleteSiteLinkOfferUseCaseFactory implements Factory<DeleteSiteLinkOfferUseCase> {
    private final Provider<OfferRepository> offerRepositoryProvider;

    private DomainModule_ProvideDeleteSiteLinkOfferUseCaseFactory(Provider<OfferRepository> offerRepositoryProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteSiteLinkOfferUseCase get() {
        return provideDeleteSiteLinkOfferUseCase(this.offerRepositoryProvider.get());
    }

    public static DomainModule_ProvideDeleteSiteLinkOfferUseCaseFactory create(Provider<OfferRepository> offerRepositoryProvider) {
        return new DomainModule_ProvideDeleteSiteLinkOfferUseCaseFactory(offerRepositoryProvider);
    }

    public static DeleteSiteLinkOfferUseCase provideDeleteSiteLinkOfferUseCase(OfferRepository offerRepository) {
        return (DeleteSiteLinkOfferUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDeleteSiteLinkOfferUseCase(offerRepository));
    }
}
