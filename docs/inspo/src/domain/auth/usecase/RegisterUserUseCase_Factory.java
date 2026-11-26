package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RegisterUserUseCase_Factory implements Factory<RegisterUserUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private RegisterUserUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RegisterUserUseCase get() {
        return newInstance(this.authRepositoryProvider.get());
    }

    public static RegisterUserUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider) {
        return new RegisterUserUseCase_Factory(authRepositoryProvider);
    }

    public static RegisterUserUseCase newInstance(AuthRepository authRepository) {
        return new RegisterUserUseCase(authRepository);
    }
}
