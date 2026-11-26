package com.example.bingwahybrid.presentation.settings.autosave.viewmodel;

import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoSaveContactsViewModel_Factory implements Factory<AutoSaveContactsViewModel> {
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private AutoSaveContactsViewModel_Factory(Provider<SettingsRepository> settingsRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoSaveContactsViewModel get() {
        return newInstance(this.settingsRepositoryProvider.get());
    }

    public static AutoSaveContactsViewModel_Factory create(Provider<SettingsRepository> settingsRepositoryProvider) {
        return new AutoSaveContactsViewModel_Factory(settingsRepositoryProvider);
    }

    public static AutoSaveContactsViewModel newInstance(SettingsRepository settingsRepository) {
        return new AutoSaveContactsViewModel(settingsRepository);
    }
}
