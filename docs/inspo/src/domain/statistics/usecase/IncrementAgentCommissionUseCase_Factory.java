package com.example.bingwahybrid.domain.statistics.usecase;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class IncrementAgentCommissionUseCase_Factory implements Factory<IncrementAgentCommissionUseCase> {
    private final Provider<AgentCommissionRepository> agentCommissionRepositoryProvider;

    private IncrementAgentCommissionUseCase_Factory(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        this.agentCommissionRepositoryProvider = agentCommissionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IncrementAgentCommissionUseCase get() {
        return newInstance(this.agentCommissionRepositoryProvider.get());
    }

    public static IncrementAgentCommissionUseCase_Factory create(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        return new IncrementAgentCommissionUseCase_Factory(agentCommissionRepositoryProvider);
    }

    public static IncrementAgentCommissionUseCase newInstance(AgentCommissionRepository agentCommissionRepository) {
        return new IncrementAgentCommissionUseCase(agentCommissionRepository);
    }
}
