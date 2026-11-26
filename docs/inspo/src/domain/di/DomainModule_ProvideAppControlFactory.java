package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.validation.usecase.ValidateStartupUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideAppControlFactory implements Factory<AppControl> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<ValidateStartupUseCase> validateStartupUseCaseProvider;

    private DomainModule_ProvideAppControlFactory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<ValidateStartupUseCase> validateStartupUseCaseProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.validateStartupUseCaseProvider = validateStartupUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppControl get() {
        return provideAppControl(this.settingsRepositoryProvider.get(), this.validateStartupUseCaseProvider.get());
    }

    public static DomainModule_ProvideAppControlFactory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<ValidateStartupUseCase> validateStartupUseCaseProvider) {
        return new DomainModule_ProvideAppControlFactory(settingsRepositoryProvider, validateStartupUseCaseProvider);
    }

    public static AppControl provideAppControl(SettingsRepository settingsRepository, ValidateStartupUseCase validateStartupUseCase) {
        return (AppControl) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideAppControl(settingsRepository, validateStartupUseCase));
    }
}
