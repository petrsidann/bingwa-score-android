package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.ExternalRetryHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ExternalRetryChain_Factory implements Factory<ExternalRetryChain> {
    private final Provider<AutoReplyHandler> autoReplyHandlerProvider;
    private final Provider<ExternalRetryHandler> externalRetryHandlerProvider;

    private ExternalRetryChain_Factory(Provider<ExternalRetryHandler> externalRetryHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        this.externalRetryHandlerProvider = externalRetryHandlerProvider;
        this.autoReplyHandlerProvider = autoReplyHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ExternalRetryChain get() {
        return newInstance(this.externalRetryHandlerProvider.get(), this.autoReplyHandlerProvider.get());
    }

    public static ExternalRetryChain_Factory create(Provider<ExternalRetryHandler> externalRetryHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        return new ExternalRetryChain_Factory(externalRetryHandlerProvider, autoReplyHandlerProvider);
    }

    public static ExternalRetryChain newInstance(ExternalRetryHandler externalRetryHandler, AutoReplyHandler autoReplyHandler) {
        return new ExternalRetryChain(externalRetryHandler, autoReplyHandler);
    }
}
