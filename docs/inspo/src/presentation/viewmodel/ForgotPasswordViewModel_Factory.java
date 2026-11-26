package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private ForgotPasswordViewModel_Factory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForgotPasswordViewModel get() {
        return newInstance(this.authRepositoryProvider.get());
    }

    public static ForgotPasswordViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider) {
        return new ForgotPasswordViewModel_Factory(authRepositoryProvider);
    }

    public static ForgotPasswordViewModel newInstance(AuthRepository authRepository) {
        return new ForgotPasswordViewModel(authRepository);
    }
}
