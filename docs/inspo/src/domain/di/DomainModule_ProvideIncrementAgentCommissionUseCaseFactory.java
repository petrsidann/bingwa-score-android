package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideIncrementAgentCommissionUseCaseFactory implements Factory<IncrementAgentCommissionUseCase> {
    private final Provider<AgentCommissionRepository> agentCommissionRepositoryProvider;

    private DomainModule_ProvideIncrementAgentCommissionUseCaseFactory(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        this.agentCommissionRepositoryProvider = agentCommissionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IncrementAgentCommissionUseCase get() {
        return provideIncrementAgentCommissionUseCase(this.agentCommissionRepositoryProvider.get());
    }

    public static DomainModule_ProvideIncrementAgentCommissionUseCaseFactory create(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        return new DomainModule_ProvideIncrementAgentCommissionUseCaseFactory(agentCommissionRepositoryProvider);
    }

    public static IncrementAgentCommissionUseCase provideIncrementAgentCommissionUseCase(AgentCommissionRepository agentCommissionRepository) {
        return (IncrementAgentCommissionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideIncrementAgentCommissionUseCase(agentCommissionRepository));
    }
}
