package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.RegisterUserUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RegisterViewModel_Factory implements Factory<RegisterViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<RegisterUserUseCase> registerUserUseCaseProvider;

    private RegisterViewModel_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<RegisterUserUseCase> registerUserUseCaseProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.registerUserUseCaseProvider = registerUserUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RegisterViewModel get() {
        return newInstance(this.authRepositoryProvider.get(), this.registerUserUseCaseProvider.get());
    }

    public static RegisterViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<RegisterUserUseCase> registerUserUseCaseProvider) {
        return new RegisterViewModel_Factory(authRepositoryProvider, registerUserUseCaseProvider);
    }

    public static RegisterViewModel newInstance(AuthRepository authRepository, RegisterUserUseCase registerUserUseCase) {
        return new RegisterViewModel(authRepository, registerUserUseCase);
    }
}
