package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideUpdateAgentUseCaseFactory implements Factory<UpdateAgentUseCase> {
    private final Provider<AuthRepository> authRepositoryProvider;

    private DomainModule_ProvideUpdateAgentUseCaseFactory(Provider<AuthRepository> authRepositoryProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateAgentUseCase get() {
        return provideUpdateAgentUseCase(this.authRepositoryProvider.get());
    }

    public static DomainModule_ProvideUpdateAgentUseCaseFactory create(Provider<AuthRepository> authRepositoryProvider) {
        return new DomainModule_ProvideUpdateAgentUseCaseFactory(authRepositoryProvider);
    }

    public static UpdateAgentUseCase provideUpdateAgentUseCase(AuthRepository authRepository) {
        return (UpdateAgentUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUpdateAgentUseCase(authRepository));
    }
}
