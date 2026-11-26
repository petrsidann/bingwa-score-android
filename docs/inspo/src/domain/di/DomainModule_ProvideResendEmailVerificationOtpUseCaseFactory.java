package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.ResendEmailVerificationOtpUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideResendEmailVerificationOtpUseCaseFactory implements Factory<ResendEmailVerificationOtpUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private DomainModule_ProvideResendEmailVerificationOtpUseCaseFactory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ResendEmailVerificationOtpUseCase get() {
        return provideResendEmailVerificationOtpUseCase(this.authRepositoryProvider.get());
    }

    public static DomainModule_ProvideResendEmailVerificationOtpUseCaseFactory create(Provider<AuthRepository> authRepositoryProvider) {
        return new DomainModule_ProvideResendEmailVerificationOtpUseCaseFactory(authRepositoryProvider);
    }

    public static ResendEmailVerificationOtpUseCase provideResendEmailVerificationOtpUseCase(AuthRepository authRepository) {
        return (ResendEmailVerificationOtpUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideResendEmailVerificationOtpUseCase(authRepository));
    }
}
