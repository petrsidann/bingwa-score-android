package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.SubscriptionPackageRepository;
import com.example.bingwahybrid.domain.usecase.subscriptions.GetSubscriptionPackageUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetSubscriptionUseCaseFactory implements Factory<GetSubscriptionPackageUseCase> {
    private final Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider;

    private DomainModule_ProvideGetSubscriptionUseCaseFactory(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        this.subscriptionPackageRepositoryProvider = subscriptionPackageRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetSubscriptionPackageUseCase get() {
        return provideGetSubscriptionUseCase(this.subscriptionPackageRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetSubscriptionUseCaseFactory create(Provider<SubscriptionPackageRepository> subscriptionPackageRepositoryProvider) {
        return new DomainModule_ProvideGetSubscriptionUseCaseFactory(subscriptionPackageRepositoryProvider);
    }

    public static GetSubscriptionPackageUseCase provideGetSubscriptionUseCase(SubscriptionPackageRepository subscriptionPackageRepository) {
        return (GetSubscriptionPackageUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetSubscriptionUseCase(subscriptionPackageRepository));
    }
}
