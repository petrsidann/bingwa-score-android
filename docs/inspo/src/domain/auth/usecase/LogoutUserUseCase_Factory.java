package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.app_lifecycle.interfaces.AppControl;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class LogoutUserUseCase_Factory implements Factory<LogoutUserUseCase> {
    private final Provider<AppControl> appControlProvider;
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SocketService> socketServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private LogoutUserUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<AppControl> appControlProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
        this.authRepositoryProvider = authRepositoryProvider;
        this.socketServiceProvider = socketServiceProvider;
        this.appControlProvider = appControlProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LogoutUserUseCase get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.tokenRepositoryProvider.get(), this.authRepositoryProvider.get(), this.socketServiceProvider.get(), this.appControlProvider.get());
    }

    public static LogoutUserUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<AppControl> appControlProvider) {
        return new LogoutUserUseCase_Factory(settingsRepositoryProvider, tokenRepositoryProvider, authRepositoryProvider, socketServiceProvider, appControlProvider);
    }

    public static LogoutUserUseCase newInstance(SettingsRepository settingsRepository, TokenRepository tokenRepository, AuthRepository authRepository, SocketService socketService, AppControl appControl) {
        return new LogoutUserUseCase(settingsRepository, tokenRepository, authRepository, socketService, appControl);
    }
}
