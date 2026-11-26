package com.example.bingwahybrid.domain.validation.usecase;

import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ValidateStartupUseCase_Factory implements Factory<ValidateStartupUseCase> {
    private final Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private ValidateStartupUseCase_Factory(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        this.deviceSettingsRepositoryProvider = deviceSettingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ValidateStartupUseCase get() {
        return newInstance(this.deviceSettingsRepositoryProvider.get(), this.tokenRepositoryProvider.get());
    }

    public static ValidateStartupUseCase_Factory create(Provider<DeviceSettingsRepository> deviceSettingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        return new ValidateStartupUseCase_Factory(deviceSettingsRepositoryProvider, tokenRepositoryProvider);
    }

    public static ValidateStartupUseCase newInstance(DeviceSettingsRepository deviceSettingsRepository, TokenRepository tokenRepository) {
        return new ValidateStartupUseCase(deviceSettingsRepository, tokenRepository);
    }
}
