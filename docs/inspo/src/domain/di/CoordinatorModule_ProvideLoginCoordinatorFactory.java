package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator;
import com.example.bingwahybrid.domain.auth.usecase.LoginUserUseCase;
import com.example.bingwahybrid.domain.repository.PaymentRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CoordinatorModule_ProvideLoginCoordinatorFactory implements Factory<LoginCoordinator> {
    private final Provider<LoginUserUseCase> loginUserUseCaseProvider;
    private final Provider<PaymentRepository> paymentRepositoryProvider;

    private CoordinatorModule_ProvideLoginCoordinatorFactory(Provider<LoginUserUseCase> loginUserUseCaseProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        this.loginUserUseCaseProvider = loginUserUseCaseProvider;
        this.paymentRepositoryProvider = paymentRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LoginCoordinator get() {
        return provideLoginCoordinator(this.loginUserUseCaseProvider.get(), this.paymentRepositoryProvider.get());
    }

    public static CoordinatorModule_ProvideLoginCoordinatorFactory create(Provider<LoginUserUseCase> loginUserUseCaseProvider, Provider<PaymentRepository> paymentRepositoryProvider) {
        return new CoordinatorModule_ProvideLoginCoordinatorFactory(loginUserUseCaseProvider, paymentRepositoryProvider);
    }

    public static LoginCoordinator provideLoginCoordinator(LoginUserUseCase loginUserUseCase, PaymentRepository paymentRepository) {
        return (LoginCoordinator) Preconditions.checkNotNullFromProvides(CoordinatorModule.INSTANCE.provideLoginCoordinator(loginUserUseCase, paymentRepository));
    }
}
