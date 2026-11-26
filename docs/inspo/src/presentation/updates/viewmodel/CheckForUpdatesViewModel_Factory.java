package com.example.bingwahybrid.presentation.updates.viewmodel;

import com.example.bingwahybrid.domain.repository.AppUpdateRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CheckForUpdatesViewModel_Factory implements Factory<CheckForUpdatesViewModel> {
    private final Provider<AppUpdateRepository> appUpdateRepositoryProvider;

    private CheckForUpdatesViewModel_Factory(Provider<AppUpdateRepository> appUpdateRepositoryProvider) {
        this.appUpdateRepositoryProvider = appUpdateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CheckForUpdatesViewModel get() {
        return newInstance(this.appUpdateRepositoryProvider.get());
    }

    public static CheckForUpdatesViewModel_Factory create(Provider<AppUpdateRepository> appUpdateRepositoryProvider) {
        return new CheckForUpdatesViewModel_Factory(appUpdateRepositoryProvider);
    }

    public static CheckForUpdatesViewModel newInstance(AppUpdateRepository appUpdateRepository) {
        return new CheckForUpdatesViewModel(appUpdateRepository);
    }
}
