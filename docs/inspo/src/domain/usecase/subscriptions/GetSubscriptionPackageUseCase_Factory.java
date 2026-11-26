package com.example.bingwahybrid.domain.usecase.subscriptions;

import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetSubscriptionPackageUseCase_Factory implements Factory<GetSubscriptionPackageUseCase> {
    private final Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider;

    private GetSubscriptionPackageUseCase_Factory(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        this.subscriptionPackageRepositoryProvider = subscriptionPackageRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSubscriptionPackageUseCase get() {
        return newInstance(this.subscriptionPackageRepositoryProvider.get());
    }

    public static GetSubscriptionPackageUseCase_Factory create(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        return new GetSubscriptionPackageUseCase_Factory(subscriptionPackageRepositoryProvider);
    }

    public static GetSubscriptionPackageUseCase newInstance(SubscriptionPackageRepository subscriptionPackageRepository) {
        return new GetSubscriptionPackageUseCase(subscriptionPackageRepository);
    }
}
