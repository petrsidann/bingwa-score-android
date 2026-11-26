package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TokenValidator_Factory implements Factory<TokenValidator> {
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;

    private TokenValidator_Factory(Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TokenValidator get() {
        return newInstance(this.subscriptionRepositoryProvider.get());
    }

    public static TokenValidator_Factory create(Provider<SubscriptionRepository> subscriptionRepositoryProvider) {
        return new TokenValidator_Factory(subscriptionRepositoryProvider);
    }

    public static TokenValidator newInstance(SubscriptionRepository subscriptionRepository) {
        return new TokenValidator(subscriptionRepository);
    }
}
