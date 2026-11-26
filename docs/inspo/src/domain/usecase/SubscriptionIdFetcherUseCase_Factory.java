package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionIdFetcherUseCase_Factory implements Factory<SubscriptionIdFetcherUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SubscriptionIdFetcherUseCase_Factory(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SubscriptionIdFetcherUseCase get() {
        return newInstance(this.contextProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static SubscriptionIdFetcherUseCase_Factory create(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new SubscriptionIdFetcherUseCase_Factory(contextProvider, settingsRepositoryProvider);
    }

    public static SubscriptionIdFetcherUseCase newInstance(Context context, SettingsRepository settingsRepository) {
        return new SubscriptionIdFetcherUseCase(context, settingsRepository);
    }
}
