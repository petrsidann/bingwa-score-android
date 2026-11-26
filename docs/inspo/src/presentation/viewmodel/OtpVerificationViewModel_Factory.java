package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.VerifyOtpUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class OtpVerificationViewModel_Factory implements Factory<OtpVerificationViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<VerifyOtpUseCase> verifyOtpUseCaseProvider;

    private OtpVerificationViewModel_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<VerifyOtpUseCase> verifyOtpUseCaseProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.verifyOtpUseCaseProvider = verifyOtpUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OtpVerificationViewModel get() {
        return newInstance(this.authRepositoryProvider.get(), this.verifyOtpUseCaseProvider.get());
    }

    public static OtpVerificationViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<VerifyOtpUseCase> verifyOtpUseCaseProvider) {
        return new OtpVerificationViewModel_Factory(authRepositoryProvider, verifyOtpUseCaseProvider);
    }

    public static OtpVerificationViewModel newInstance(AuthRepository authRepository, VerifyOtpUseCase verifyOtpUseCase) {
        return new OtpVerificationViewModel(authRepository, verifyOtpUseCase);
    }
}
