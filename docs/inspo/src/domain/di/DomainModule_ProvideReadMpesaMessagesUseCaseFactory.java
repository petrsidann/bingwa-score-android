package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.sms.usecases.ReadMpesaMessagesUseCase;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideReadMpesaMessagesUseCaseFactory implements Factory<ReadMpesaMessagesUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider;

    private DomainModule_ProvideReadMpesaMessagesUseCaseFactory(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        this.contextProvider = contextProvider;
        this.subscriptionIdFetcherUseCaseProvider = subscriptionIdFetcherUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ReadMpesaMessagesUseCase get() {
        return provideReadMpesaMessagesUseCase(this.contextProvider.get(), this.subscriptionIdFetcherUseCaseProvider.get());
    }

    public static DomainModule_ProvideReadMpesaMessagesUseCaseFactory create(Provider<Context> contextProvider, Provider<SubscriptionIdFetcherUseCase> subscriptionIdFetcherUseCaseProvider) {
        return new DomainModule_ProvideReadMpesaMessagesUseCaseFactory(contextProvider, subscriptionIdFetcherUseCaseProvider);
    }

    public static ReadMpesaMessagesUseCase provideReadMpesaMessagesUseCase(Context context, SubscriptionIdFetcherUseCase subscriptionIdFetcherUseCase) {
        return (ReadMpesaMessagesUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideReadMpesaMessagesUseCase(context, subscriptionIdFetcherUseCase));
    }
}
