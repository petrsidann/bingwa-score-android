package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class LoginUserUseCase_Factory implements Factory<LoginUserUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<ConnectIdScheduler> connectIdSchedulerProvider;
    private final Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SocketService> socketServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private LoginUserUseCase_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
        this.socketServiceProvider = socketServiceProvider;
        this.connectIdSchedulerProvider = connectIdSchedulerProvider;
        this.fcmTokenRegistrationHelperProvider = fcmTokenRegistrationHelperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LoginUserUseCase get() {
        return newInstance(this.authRepositoryProvider.get(), this.settingsRepositoryProvider.get(), this.tokenRepositoryProvider.get(), this.socketServiceProvider.get(), this.connectIdSchedulerProvider.get(), this.fcmTokenRegistrationHelperProvider.get());
    }

    public static LoginUserUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        return new LoginUserUseCase_Factory(authRepositoryProvider, settingsRepositoryProvider, tokenRepositoryProvider, socketServiceProvider, connectIdSchedulerProvider, fcmTokenRegistrationHelperProvider);
    }

    public static LoginUserUseCase newInstance(AuthRepository authRepository, SettingsRepository settingsRepository, TokenRepository tokenRepository, SocketService socketService, ConnectIdScheduler connectIdScheduler, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        return new LoginUserUseCase(authRepository, settingsRepository, tokenRepository, socketService, connectIdScheduler, fcmTokenRegistrationHelper);
    }
}
