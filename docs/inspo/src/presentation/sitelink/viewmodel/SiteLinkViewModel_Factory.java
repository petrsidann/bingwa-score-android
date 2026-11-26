package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import com.example.bingwahybrid.domain.devices.repository.DeviceRepository;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.sitelink.repository.SiteLinkRepository;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkOfferUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.DeleteSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.GetSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.RequestSiteLinkUseCase;
import com.example.bingwahybrid.domain.sitelink.usecase.UpdateSiteLinkUseCase;
import com.example.bingwahybrid.domain.usecase.ActivateSiteLinkUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SiteLinkViewModel_Factory implements Factory<SiteLinkViewModel> {
    private final Provider<ActivateSiteLinkUseCase> activateSiteLinkUseCaseProvider;
    private final Provider<DeleteSiteLinkOfferUseCase> deleteSiteLinkOfferUseCaseProvider;
    private final Provider<DeleteSiteLinkUseCase> deleteSiteLinkUseCaseProvider;
    private final Provider<DeviceRepository> deviceRepositoryProvider;
    private final Provider<GetSiteLinkUseCase> getSiteLinkUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<RequestSiteLinkUseCase> requestSiteLinkUseCaseProvider;
    private final Provider<SiteLinkRepository> siteLinkRepositoryProvider;
    private final Provider<UpdateSiteLinkUseCase> updateSiteLinkUseCaseProvider;

    private SiteLinkViewModel_Factory(Provider<GetSiteLinkUseCase> getSiteLinkUseCaseProvider, Provider<RequestSiteLinkUseCase> requestSiteLinkUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<DeleteSiteLinkOfferUseCase> deleteSiteLinkOfferUseCaseProvider, Provider<ActivateSiteLinkUseCase> activateSiteLinkUseCaseProvider, Provider<UpdateSiteLinkUseCase> updateSiteLinkUseCaseProvider, Provider<DeleteSiteLinkUseCase> deleteSiteLinkUseCaseProvider, Provider<SiteLinkRepository> siteLinkRepositoryProvider, Provider<DeviceRepository> deviceRepositoryProvider) {
        this.getSiteLinkUseCaseProvider = getSiteLinkUseCaseProvider;
        this.requestSiteLinkUseCaseProvider = requestSiteLinkUseCaseProvider;
        this.offerRepositoryProvider = offerRepositoryProvider;
        this.deleteSiteLinkOfferUseCaseProvider = deleteSiteLinkOfferUseCaseProvider;
        this.activateSiteLinkUseCaseProvider = activateSiteLinkUseCaseProvider;
        this.updateSiteLinkUseCaseProvider = updateSiteLinkUseCaseProvider;
        this.deleteSiteLinkUseCaseProvider = deleteSiteLinkUseCaseProvider;
        this.siteLinkRepositoryProvider = siteLinkRepositoryProvider;
        this.deviceRepositoryProvider = deviceRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SiteLinkViewModel get() {
        return newInstance(this.getSiteLinkUseCaseProvider.get(), this.requestSiteLinkUseCaseProvider.get(), this.offerRepositoryProvider.get(), this.deleteSiteLinkOfferUseCaseProvider.get(), this.activateSiteLinkUseCaseProvider.get(), this.updateSiteLinkUseCaseProvider.get(), this.deleteSiteLinkUseCaseProvider.get(), this.siteLinkRepositoryProvider.get(), this.deviceRepositoryProvider.get());
    }

    public static SiteLinkViewModel_Factory create(Provider<GetSiteLinkUseCase> getSiteLinkUseCaseProvider, Provider<RequestSiteLinkUseCase> requestSiteLinkUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider, Provider<DeleteSiteLinkOfferUseCase> deleteSiteLinkOfferUseCaseProvider, Provider<ActivateSiteLinkUseCase> activateSiteLinkUseCaseProvider, Provider<UpdateSiteLinkUseCase> updateSiteLinkUseCaseProvider, Provider<DeleteSiteLinkUseCase> deleteSiteLinkUseCaseProvider, Provider<SiteLinkRepository> siteLinkRepositoryProvider, Provider<DeviceRepository> deviceRepositoryProvider) {
        return new SiteLinkViewModel_Factory(getSiteLinkUseCaseProvider, requestSiteLinkUseCaseProvider, offerRepositoryProvider, deleteSiteLinkOfferUseCaseProvider, activateSiteLinkUseCaseProvider, updateSiteLinkUseCaseProvider, deleteSiteLinkUseCaseProvider, siteLinkRepositoryProvider, deviceRepositoryProvider);
    }

    public static SiteLinkViewModel newInstance(GetSiteLinkUseCase getSiteLinkUseCase, RequestSiteLinkUseCase requestSiteLinkUseCase, OfferRepository offerRepository, DeleteSiteLinkOfferUseCase deleteSiteLinkOfferUseCase, ActivateSiteLinkUseCase activateSiteLinkUseCase, UpdateSiteLinkUseCase updateSiteLinkUseCase, DeleteSiteLinkUseCase deleteSiteLinkUseCase, SiteLinkRepository siteLinkRepository, DeviceRepository deviceRepository) {
        return new SiteLinkViewModel(getSiteLinkUseCase, requestSiteLinkUseCase, offerRepository, deleteSiteLinkOfferUseCase, activateSiteLinkUseCase, updateSiteLinkUseCase, deleteSiteLinkUseCase, siteLinkRepository, deviceRepository);
    }
}
