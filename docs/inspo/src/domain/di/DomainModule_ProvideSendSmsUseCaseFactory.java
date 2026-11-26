package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.messaging.usecase.SendSmsUseCase;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideSendSmsUseCaseFactory implements Factory<SendSmsUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider;

    private DomainModule_ProvideSendSmsUseCaseFactory(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        this.contextProvider = contextProvider;
        this.subscriptionIdFetcherUseCaseProvider = subscriptionIdFetcherUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SendSmsUseCase get() {
        return provideSendSmsUseCase(this.contextProvider.get(), this.subscriptionIdFetcherUseCaseProvider.get());
    }

    public static DomainModule_ProvideSendSmsUseCaseFactory create(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        return new DomainModule_ProvideSendSmsUseCaseFactory(contextProvider, subscriptionIdFetcherUseCaseProvider);
    }

    public static SendSmsUseCase provideSendSmsUseCase(Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        return (SendSmsUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideSendSmsUseCase(context, subscriptionIdFetcherUseCase));
    }
}
