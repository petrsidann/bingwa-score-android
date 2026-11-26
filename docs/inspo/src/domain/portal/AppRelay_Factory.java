package com.example.bingwahybrid.domain.portal;

import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.TokenRefreshService;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AppRelay_Factory implements Factory<AppRelay> {
    private final Provider<AppControl> appControlProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<TokenRefreshService> tokenRefreshServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private AppRelay_Factory(Provider<AppControl> appControlProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<TokenRefreshService> tokenRefreshServiceProvider) {
        this.appControlProvider = appControlProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
        this.tokenRefreshServiceProvider = tokenRefreshServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppRelay get() {
        return newInstance(this.appControlProvider.get(), this.settingsRepositoryProvider.get(), this.tokenRepositoryProvider.get(), this.tokenRefreshServiceProvider.get());
    }

    public static AppRelay_Factory create(Provider<AppControl> appControlProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<TokenRefreshService> tokenRefreshServiceProvider) {
        return new AppRelay_Factory(appControlProvider, settingsRepositoryProvider, tokenRepositoryProvider, tokenRefreshServiceProvider);
    }

    public static AppRelay newInstance(AppControl appControl, SettingsRepository settingsRepository, TokenRepository tokenRepository, TokenRefreshService tokenRefreshService) {
        return new AppRelay(appControl, settingsRepository, tokenRepository, tokenRefreshService);
    }
}
