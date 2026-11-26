package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.SubscriptionIdFetcherUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideSubscriptionIdFetcherUseCaseFactory implements Factory<SubscriptionIdFetcherUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private DomainModule_ProvideSubscriptionIdFetcherUseCaseFactory(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SubscriptionIdFetcherUseCase get() {
        return provideSubscriptionIdFetcherUseCase(this.contextProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static DomainModule_ProvideSubscriptionIdFetcherUseCaseFactory create(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new DomainModule_ProvideSubscriptionIdFetcherUseCaseFactory(contextProvider, settingsRepositoryProvider);
    }

    public static SubscriptionIdFetcherUseCase provideSubscriptionIdFetcherUseCase(Context context, SettingsRepository settingsRepository) {
        return (SubscriptionIdFetcherUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideSubscriptionIdFetcherUseCase(context, settingsRepository));
    }
}
