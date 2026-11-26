package com.example.bingwahybrid.domain.auth.usecase;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateAgentUseCase_Factory implements Factory<UpdateAgentUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private UpdateAgentUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateAgentUseCase get() {
        return newInstance(this.authRepositoryProvider.get());
    }

    public static UpdateAgentUseCase_Factory create(Provider<AuthRepository> authRepositoryProvider) {
        return new UpdateAgentUseCase_Factory(authRepositoryProvider);
    }

    public static UpdateAgentUseCase newInstance(AuthRepository authRepository) {
        return new UpdateAgentUseCase(authRepository);
    }
}
