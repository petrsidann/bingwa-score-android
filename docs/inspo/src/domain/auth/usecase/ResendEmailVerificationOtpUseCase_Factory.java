package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ResendEmailVerificationOtpUseCase_Factory implements Factory<ResendEmailVerificationOtpUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private ResendEmailVerificationOtpUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ResendEmailVerificationOtpUseCase get() {
        return newInstance(this.authRepositoryProvider.get());
    }

    public static ResendEmailVerificationOtpUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider) {
        return new ResendEmailVerificationOtpUseCase_Factory(authRepositoryProvider);
    }

    public static ResendEmailVerificationOtpUseCase newInstance(AuthRepository authRepository) {
        return new ResendEmailVerificationOtpUseCase(authRepository);
    }
}
