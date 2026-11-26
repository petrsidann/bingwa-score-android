package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.validation.usecase.ValidateStartupUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideValidateStartupUseCaseFactory implements Factory<ValidateStartupUseCase> {
    private final Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private DomainModule_ProvideValidateStartupUseCaseFactory(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        this.deviceSettingsRepositoryProvider = deviceSettingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ValidateStartupUseCase get() {
        return provideValidateStartupUseCase(this.deviceSettingsRepositoryProvider.get(), this.tokenRepositoryProvider.get());
    }

    public static DomainModule_ProvideValidateStartupUseCaseFactory create(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        return new DomainModule_ProvideValidateStartupUseCaseFactory(deviceSettingsRepositoryProvider, tokenRepositoryProvider);
    }

    public static ValidateStartupUseCase provideValidateStartupUseCase(DeviceSettingsRepository deviceSettingsRepository, TokenRepository tokenRepository) {
        return (ValidateStartupUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideValidateStartupUseCase(deviceSettingsRepository, tokenRepository));
    }
}
