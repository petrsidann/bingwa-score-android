package com.example.bingwahybrid.domain.app_lifecycle;

import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.validation.usecase.ValidateStartupUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAppControl_Factory implements Factory<DefaultAppControl> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<ValidateStartupUseCase> validateStartupUseCaseProvider;

    private DefaultAppControl_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<ValidateStartupUseCase> validateStartupUseCaseProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.validateStartupUseCaseProvider = validateStartupUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DefaultAppControl get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.validateStartupUseCaseProvider.get());
    }

    public static DefaultAppControl_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<ValidateStartupUseCase> validateStartupUseCaseProvider) {
        return new DefaultAppControl_Factory(settingsRepositoryProvider, validateStartupUseCaseProvider);
    }

    public static DefaultAppControl newInstance(SettingsRepository settingsRepository, ValidateStartupUseCase validateStartupUseCase) {
        return new DefaultAppControl(settingsRepository, validateStartupUseCase);
    }
}
