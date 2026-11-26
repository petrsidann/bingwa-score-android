package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AdvancedModeValidator_Factory implements Factory<AdvancedModeValidator> {
    private final Provider<AccessibilityRepository> accessibilityRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private AdvancedModeValidator_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.accessibilityRepositoryProvider = accessibilityRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AdvancedModeValidator get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.accessibilityRepositoryProvider.get());
    }

    public static AdvancedModeValidator_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider) {
        return new AdvancedModeValidator_Factory(settingsRepositoryProvider, accessibilityRepositoryProvider);
    }

    public static AdvancedModeValidator newInstance(SettingsRepository settingsRepository, AccessibilityRepository accessibilityRepository) {
        return new AdvancedModeValidator(settingsRepository, accessibilityRepository);
    }
}
