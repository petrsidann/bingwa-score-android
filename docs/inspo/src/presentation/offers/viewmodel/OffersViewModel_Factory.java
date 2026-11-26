package com.example.bingwahybrid.presentation.offers.viewmodel;

import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.offers.repository.SharedOffersRepository;
import com.example.bingwahybrid.domain.offers.usecase.DeleteOfferUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class OffersViewModel_Factory implements Factory<OffersViewModel> {
    private final Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<SharedOffersRepository> sharedOffersRepositoryProvider;

    private OffersViewModel_Factory(Provider<OfferRepository> offerRepositoryProvider, Provider<SharedOffersRepository> sharedOffersRepositoryProvider, Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider) {
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.sharedOffersRepositoryProvider = sharedOffersRepositoryProvider;
        this.deleteOfferUseCaseProvider = deleteOfferUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OffersViewModel get() {
        return newInstance(this.offerRepositoryProvider.get(), this.sharedOffersRepositoryProvider.get(), this.deleteOfferUseCaseProvider.get());
    }

    public static OffersViewModel_Factory create(Provider<OfferRepository> offerRepositoryProvider, Provider<SharedOffersRepository> sharedOffersRepositoryProvider, Provider<DeleteOfferUseCase> deleteOfferUseCaseProvider) {
        return new OffersViewModel_Factory(offerRepositoryProvider, sharedOffersRepositoryProvider, deleteOfferUseCaseProvider);
    }

    public static OffersViewModel newInstance(OfferRepository offerRepository, SharedOffersRepository sharedOffersRepository, DeleteOfferUseCase deleteOfferUseCase) {
        return new OffersViewModel(offerRepository, sharedOffersRepository, deleteOfferUseCase);
    }
}
