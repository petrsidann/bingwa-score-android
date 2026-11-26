package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.UpdateTransactionHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SuccessChain_Factory implements Factory<SuccessChain> {
    private final Provider<AgentCommissionHandler> agentCommissionHandlerProvider;
    private final Provider<AutoReplyHandler> autoReplyHandlerProvider;
    private final Provider<UpdateTransactionHandler> updateTransactionHandlerProvider;

    private SuccessChain_Factory(Provider<UpdateTransactionHandler> updateTransactionHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider, Provider<AgentCommissionHandler> agentCommissionHandlerProvider) {
        this.updateTransactionHandlerProvider = updateTransactionHandlerProvider;
        this.autoReplyHandlerProvider = autoReplyHandlerProvider;
        this.agentCommissionHandlerProvider = agentCommissionHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SuccessChain get() {
        return newInstance(this.updateTransactionHandlerProvider.get(), this.autoReplyHandlerProvider.get(), this.agentCommissionHandlerProvider.get());
    }

    public static SuccessChain_Factory create(Provider<UpdateTransactionHandler> updateTransactionHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider, Provider<AgentCommissionHandler> agentCommissionHandlerProvider) {
        return new SuccessChain_Factory(updateTransactionHandlerProvider, autoReplyHandlerProvider, agentCommissionHandlerProvider);
    }

    public static SuccessChain newInstance(UpdateTransactionHandler updateTransactionHandler, AutoReplyHandler autoReplyHandler, AgentCommissionHandler agentCommissionHandler) {
        return new SuccessChain(updateTransactionHandler, autoReplyHandler, agentCommissionHandler);
    }
}
