package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.security.repository.TokenRepository;
import com.example.bingwahybrid.domain.services.ConnectIdScheduler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class VerifyOtpUseCase_Factory implements Factory<VerifyOtpUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<ConnectIdScheduler> connectIdSchedulerProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    private VerifyOtpUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.authRepositoryProvider = authRepositoryProvider;
        this.connectIdSchedulerProvider = connectIdSchedulerProvider;
        this.tokenRepositoryProvider = tokenRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public VerifyOtpUseCase get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.authRepositoryProvider.get(), this.connectIdSchedulerProvider.get(), this.tokenRepositoryProvider.get());
    }

    public static VerifyOtpUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<ConnectIdScheduler> connectIdSchedulerProvider, Provider<TokenRepository> tokenRepositoryProvider) {
        return new VerifyOtpUseCase_Factory(settingsRepositoryProvider, authRepositoryProvider, connectIdSchedulerProvider, tokenRepositoryProvider);
    }

    public static VerifyOtpUseCase newInstance(SettingsRepository settingsRepository, AuthRepository authRepository, ConnectIdScheduler connectIdScheduler, TokenRepository tokenRepository) {
        return new VerifyOtpUseCase(settingsRepository, authRepository, connectIdScheduler, tokenRepository);
    }
}
