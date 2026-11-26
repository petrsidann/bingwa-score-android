package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.InternalRetryHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class InternalRetryChain_Factory implements Factory<InternalRetryChain> {
    private final Provider<InternalRetryHandler> internalRetryHandlerProvider;

    private InternalRetryChain_Factory(Provider<InternalRetryHandler> internalRetryHandlerProvider) {
        this.internalRetryHandlerProvider = internalRetryHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public InternalRetryChain get() {
        return newInstance(this.internalRetryHandlerProvider.get());
    }

    public static InternalRetryChain_Factory create(Provider<InternalRetryHandler> internalRetryHandlerProvider) {
        return new InternalRetryChain_Factory(internalRetryHandlerProvider);
    }

    public static InternalRetryChain newInstance(InternalRetryHandler internalRetryHandler) {
        return new InternalRetryChain(internalRetryHandler);
    }
}
