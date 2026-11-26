package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.repository.PaymentRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class LoginCoordinator_Factory implements Factory<LoginCoordinator> {
    private final Provider<LoginUserUseCase> loginUserUseCaseProvider;
    private final Provider<PaymentRepository> paymentRepositoryProvider;

    private LoginCoordinator_Factory(Provider<LoginUserUseCase> loginUserUseCaseProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        this.loginUserUseCaseProvider = loginUserUseCaseProvider;
        this.paymentRepositoryProvider = paymentRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LoginCoordinator get() {
        return newInstance(this.loginUserUseCaseProvider.get(), this.paymentRepositoryProvider.get());
    }

    public static LoginCoordinator_Factory create(Provider<LoginUserUseCase> loginUserUseCaseProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        return new LoginCoordinator_Factory(loginUserUseCaseProvider, paymentRepositoryProvider);
    }

    public static LoginCoordinator newInstance(LoginUserUseCase loginUserUseCase, PaymentRepository paymentRepository) {
        return new LoginCoordinator(loginUserUseCase, paymentRepository);
    }
}
