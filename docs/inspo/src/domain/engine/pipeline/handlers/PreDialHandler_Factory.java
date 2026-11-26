package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.FormatUssdUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferVerificationRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class PreDialHandler_Factory implements Factory<PreDialHandler> {
    private final Provider<FormatUssdUseCase> formatUssdUseCaseProvider;
    private final Provider<OfferSession> offerSessionProvider;
    private final Provider<OfferVerificationRepository> offerVerificationRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;
    private final Provider<UssdSessionManager> ussdSessionManagerProvider;

    private PreDialHandler_Factory(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<FormatUssdUseCase> formatUssdUseCaseProvider, Provider<UssdSessionManager> ussdSessionManagerProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider, Provider<OfferSession> offerSessionProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.formatUssdUseCaseProvider = formatUssdUseCaseProvider;
        this.ussdSessionManagerProvider = ussdSessionManagerProvider;
        this.offerVerificationRepositoryProvider = offerVerificationRepositoryProvider;
        this.offerSessionProvider = offerSessionProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreDialHandler get() {
        return newInstance(this.updateTransactionUseCaseProvider.get(), this.formatUssdUseCaseProvider.get(), this.ussdSessionManagerProvider.get(), this.offerVerificationRepositoryProvider.get(), this.offerSessionProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static PreDialHandler_Factory create(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<FormatUssdUseCase> formatUssdUseCaseProvider, Provider<UssdSessionManager> ussdSessionManagerProvider, Provider<OfferVerificationRepository> offerVerificationRepositoryProvider, Provider<OfferSession> offerSessionProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new PreDialHandler_Factory(updateTransactionUseCaseProvider, formatUssdUseCaseProvider, ussdSessionManagerProvider, offerVerificationRepositoryProvider, offerSessionProvider, settingsRepositoryProvider);
    }

    public static PreDialHandler newInstance(UpdateTransactionUseCase updateTransactionUseCase, FormatUssdUseCase formatUssdUseCase, UssdSessionManager ussdSessionManager, OfferVerificationRepository offerVerificationRepository, OfferSession offerSession, SettingsRepository settingsRepository) {
        return new PreDialHandler(updateTransactionUseCase, formatUssdUseCase, ussdSessionManager, offerVerificationRepository, offerSession, settingsRepository);
    }
}
