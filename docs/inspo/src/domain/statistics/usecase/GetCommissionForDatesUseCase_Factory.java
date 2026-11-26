package com.example.bingwahybrid.domain.statistics.usecase;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetCommissionForDatesUseCase_Factory implements Factory<GetCommissionForDatesUseCase> {
    private final Provider<AgentCommissionRepository> agentCommissionRepositoryProvider;

    private GetCommissionForDatesUseCase_Factory(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        this.agentCommissionRepositoryProvider = agentCommissionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCommissionForDatesUseCase get() {
        return newInstance(this.agentCommissionRepositoryProvider.get());
    }

    public static GetCommissionForDatesUseCase_Factory create(Provider<AgentCommissionRepository> agentCommissionRepositoryProvider) {
        return new GetCommissionForDatesUseCase_Factory(agentCommissionRepositoryProvider);
    }

    public static GetCommissionForDatesUseCase newInstance(AgentCommissionRepository agentCommissionRepository) {
        return new GetCommissionForDatesUseCase(agentCommissionRepository);
    }
}
