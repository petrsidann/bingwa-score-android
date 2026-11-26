package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class PinSetupViewModel_Factory implements Factory<PinSetupViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private PinSetupViewModel_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PinSetupViewModel get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.authRepositoryProvider.get());
    }

    public static PinSetupViewModel_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider) {
        return new PinSetupViewModel_Factory(settingsRepositoryProvider, authRepositoryProvider);
    }

    public static PinSetupViewModel newInstance(SettingsRepository settingsRepository, AuthRepository authRepository) {
        return new PinSetupViewModel(settingsRepository, authRepository);
    }
}
