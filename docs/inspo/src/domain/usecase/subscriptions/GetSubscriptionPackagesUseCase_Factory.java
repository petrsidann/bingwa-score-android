package com.example.bingwahybrid.domain.usecase.subscriptions;

import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetSubscriptionPackagesUseCase_Factory implements Factory<GetSubscriptionPackagesUseCase> {
    private final Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider;

    private GetSubscriptionPackagesUseCase_Factory(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        this.subscriptionPackageRepositoryProvider = subscriptionPackageRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSubscriptionPackagesUseCase get() {
        return newInstance(this.subscriptionPackageRepositoryProvider.get());
    }

    public static GetSubscriptionPackagesUseCase_Factory create(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        return new GetSubscriptionPackagesUseCase_Factory(subscriptionPackageRepositoryProvider);
    }

    public static GetSubscriptionPackagesUseCase newInstance(SubscriptionPackageRepository subscriptionPackageRepository) {
        return new GetSubscriptionPackagesUseCase(subscriptionPackageRepository);
    }
}
