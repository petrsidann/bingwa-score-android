package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.RegisterUserUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideRegisterUserUseCaseFactory implements Factory<RegisterUserUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private DomainModule_ProvideRegisterUserUseCaseFactory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RegisterUserUseCase get() {
        return provideRegisterUserUseCase(this.authRepositoryProvider.get());
    }

    public static DomainModule_ProvideRegisterUserUseCaseFactory create(Provider<AuthRepository> authRepositoryProvider) {
        return new DomainModule_ProvideRegisterUserUseCaseFactory(authRepositoryProvider);
    }

    public static RegisterUserUseCase provideRegisterUserUseCase(AuthRepository authRepository) {
        return (RegisterUserUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideRegisterUserUseCase(authRepository));
    }
}
