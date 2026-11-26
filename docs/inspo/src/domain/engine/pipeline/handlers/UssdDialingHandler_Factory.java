package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import android.content.Context;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import com.example.bingwahybrid.domain.ussd.repository.OfferSession;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UssdDialingHandler_Factory implements Factory<UssdDialingHandler> {
    private final Provider<Context> contextProvider;
    private final Provider<OfferSession> offerSessionProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherProvider;
    private final Provider<UssdSessionManager> ussdSessionManagerProvider;
    private final Provider<UssdStepsRepository> ussdStepsRepositoryProvider;

    private UssdDialingHandler_Factory(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherProvider, Provider<UssdSessionManager> ussdSessionManagerProvider, Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<OfferSession> offerSessionProvider) {
        this.contextProvider = contextProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.subscriptionIdFetcherProvider = subscriptionIdFetcherProvider;
        this.ussdSessionManagerProvider = ussdSessionManagerProvider;
        this.ussdStepsRepositoryProvider = ussdStepsRepositoryProvider;
        this.offerSessionProvider = offerSessionProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UssdDialingHandler get() {
        return newInstance(this.contextProvider.get(), this.settingsRepositoryProvider.get(), this.subscriptionIdFetcherProvider.get(), this.ussdSessionManagerProvider.get(), this.ussdStepsRepositoryProvider.get(), this.offerSessionProvider.get());
    }

    public static UssdDialingHandler_Factory create(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherProvider, Provider<UssdSessionManager> ussdSessionManagerProvider, Provider<UssdStepsRepository> ussdStepsRepositoryProvider, Provider<OfferSession> offerSessionProvider) {
        return new UssdDialingHandler_Factory(contextProvider, settingsRepositoryProvider, subscriptionIdFetcherProvider, ussdSessionManagerProvider, ussdStepsRepositoryProvider, offerSessionProvider);
    }

    public static UssdDialingHandler newInstance(Context context, SettingsRepository settingsRepository, SubscriptionIdFetcherUseCase subscriptionIdFetcher, UssdSessionManager ussdSessionManager, UssdStepsRepository ussdStepsRepository, OfferSession offerSession) {
        return new UssdDialingHandler(context, settingsRepository, subscriptionIdFetcher, ussdSessionManager, ussdStepsRepository, offerSession);
    }
}
