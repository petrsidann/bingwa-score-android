package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AgentCommissionHandler_Factory implements Factory<AgentCommissionHandler> {
    private final Provider<IncrementAgentCommissionUseCase> incrementAgentCommissionUseCaseProvider;

    private AgentCommissionHandler_Factory(Provider<IncrementAgentCommissionUseCase> incrementAgentCommissionUseCaseProvider) {
        this.incrementAgentCommissionUseCaseProvider = incrementAgentCommissionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AgentCommissionHandler get() {
        return newInstance(this.incrementAgentCommissionUseCaseProvider.get());
    }

    public static AgentCommissionHandler_Factory create(Provider<IncrementAgentCommissionUseCase> incrementAgentCommissionUseCaseProvider) {
        return new AgentCommissionHandler_Factory(incrementAgentCommissionUseCaseProvider);
    }

    public static AgentCommissionHandler newInstance(IncrementAgentCommissionUseCase incrementAgentCommissionUseCase) {
        return new AgentCommissionHandler(incrementAgentCommissionUseCase);
    }
}
