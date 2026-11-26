package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.LoginCoordinator;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class PinLoginViewModel_Factory implements Factory<PinLoginViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<LoginCoordinator> loginCoordinatorProvider;

    private PinLoginViewModel_Factory(Provider<LoginCoordinator> loginCoordinatorProvider, Provider<AuthRepository> authRepositoryProvider) {
        this.loginCoordinatorProvider = loginCoordinatorProvider;
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PinLoginViewModel get() {
        return newInstance(this.loginCoordinatorProvider.get(), this.authRepositoryProvider.get());
    }

    public static PinLoginViewModel_Factory create(Provider<LoginCoordinator> loginCoordinatorProvider, Provider<AuthRepository> authRepositoryProvider) {
        return new PinLoginViewModel_Factory(loginCoordinatorProvider, authRepositoryProvider);
    }

    public static PinLoginViewModel newInstance(LoginCoordinator loginCoordinator, AuthRepository authRepository) {
        return new PinLoginViewModel(loginCoordinator, authRepository);
    }
}
