package com.example.bingwahybrid.domain.messaging.usecase;

import android.content.Context;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SendSmsUseCase_Factory implements Factory<SendSmsUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider;

    private SendSmsUseCase_Factory(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        this.contextProvider = contextProvider;
        this.subscriptionIdFetcherUseCaseProvider = subscriptionIdFetcherUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SendSmsUseCase get() {
        return newInstance(this.contextProvider.get(), this.subscriptionIdFetcherUseCaseProvider.get());
    }

    public static SendSmsUseCase_Factory create(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        return new SendSmsUseCase_Factory(contextProvider, subscriptionIdFetcherUseCaseProvider);
    }

    public static SendSmsUseCase newInstance(Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        return new SendSmsUseCase(context, subscriptionIdFetcherUseCase);
    }
}
