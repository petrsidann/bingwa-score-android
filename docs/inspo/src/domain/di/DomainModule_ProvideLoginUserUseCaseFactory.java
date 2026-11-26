package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import com.example.bingwahybrid.domain.socket.SocketService;
import com.example.bingwahybrid.infrastructure.messaging.FcmTokenRegistrationHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideLoginUserUseCaseFactory implements Factory<LoginUserUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<ConnectIdScheduler> connectIdSchedulerProvider;
    private final Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SocketService> socketServiceProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private DomainModule_ProvideLoginUserUseCaseFactory(Provider<AuthRepository> authRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
        this.socketServiceProvider = socketServiceProvider;
        this.connectIdSchedulerProvider = connectIdSchedulerProvider;
        this.fcmTokenRegistrationHelperProvider = fcmTokenRegistrationHelperProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LoginUserUseCase get() {
        return provideLoginUserUseCase(this.authRepositoryProvider.get(), this.settingsRepositoryProvider.get(), this.tokenRepositoryProvider.get(), this.socketServiceProvider.get(), this.connectIdSchedulerProvider.get(), this.fcmTokenRegistrationHelperProvider.get());
    }

    public static DomainModule_ProvideLoginUserUseCaseFactory create(Provider<AuthRepository> authRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<TokenRepository> tokenRepositoryProvider, Provider<SocketService> socketServiceProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<FcmTokenRegistrationHelper> fcmTokenRegistrationHelperProvider) {
        return new DomainModule_ProvideLoginUserUseCaseFactory(authRepositoryProvider, settingsRepositoryProvider, tokenRepositoryProvider, socketServiceProvider, connectIdSchedulerProvider, fcmTokenRegistrationHelperProvider);
    }

    public static LoginUserUseCase provideLoginUserUseCase(AuthRepository authRepository, SettingsRepository settingsRepository, TokenRepository tokenRepository, SocketService socketService, ConnectIdScheduler connectIdScheduler, FcmTokenRegistrationHelper fcmTokenRegistrationHelper) {
        return (LoginUserUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideLoginUserUseCase(authRepository, settingsRepository, tokenRepository, socketService, connectIdScheduler, fcmTokenRegistrationHelper));
    }
}
