package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.UpdateTransactionHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class FailureChain_Factory implements Factory<FailureChain> {
    private final Provider<AutoReplyHandler> autoReplyHandlerProvider;
    private final Provider<UpdateTransactionHandler> updateTransactionHandlerProvider;

    private FailureChain_Factory(Provider<UpdateTransactionHandler> updateTransactionHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        this.updateTransactionHandlerProvider = updateTransactionHandlerProvider;
        this.autoReplyHandlerProvider = autoReplyHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FailureChain get() {
        return newInstance(this.updateTransactionHandlerProvider.get(), this.autoReplyHandlerProvider.get());
    }

    public static FailureChain_Factory create(Provider<UpdateTransactionHandler> updateTransactionHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        return new FailureChain_Factory(updateTransactionHandlerProvider, autoReplyHandlerProvider);
    }

    public static FailureChain newInstance(UpdateTransactionHandler updateTransactionHandler, AutoReplyHandler autoReplyHandler) {
        return new FailureChain(updateTransactionHandler, autoReplyHandler);
    }
}
