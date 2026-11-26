package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackagesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetSubscriptionPackagesUseCaseFactory implements Factory<GetSubscriptionPackagesUseCase> {
    private final Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider;

    private DomainModule_ProvideGetSubscriptionPackagesUseCaseFactory(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        this.subscriptionPackageRepositoryProvider = subscriptionPackageRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSubscriptionPackagesUseCase get() {
        return provideGetSubscriptionPackagesUseCase(this.subscriptionPackageRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetSubscriptionPackagesUseCaseFactory create(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        return new DomainModule_ProvideGetSubscriptionPackagesUseCaseFactory(subscriptionPackageRepositoryProvider);
    }

    public static GetSubscriptionPackagesUseCase provideGetSubscriptionPackagesUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        return (GetSubscriptionPackagesUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetSubscriptionPackagesUseCase(subscriptionPackageRepository));
    }
}
