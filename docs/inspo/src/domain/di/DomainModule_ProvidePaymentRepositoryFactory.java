package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.data.remote.api.ApiService;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvidePaymentRepositoryFactory implements Factory<PaymentRepository> {
    private final Provider<ApiService> apiServiceProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private DomainModule_ProvidePaymentRepositoryFactory(Provider<ApiService> apiServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.apiServiceProvider = apiServiceProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PaymentRepository get() {
        return providePaymentRepository(this.apiServiceProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static DomainModule_ProvidePaymentRepositoryFactory create(Provider<ApiService> apiServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new DomainModule_ProvidePaymentRepositoryFactory(apiServiceProvider, settingsRepositoryProvider);
    }

    public static PaymentRepository providePaymentRepository(ApiService apiService, SettingsRepository settingsRepository) {
        return (PaymentRepository) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.providePaymentRepository(apiService, settingsRepository));
    }
}
