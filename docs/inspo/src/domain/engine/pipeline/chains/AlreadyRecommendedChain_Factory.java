package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AlreadyRecommendedHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AlreadyRecommendedChain_Factory implements Factory<AlreadyRecommendedChain> {
    private final Provider<AlreadyRecommendedHandler> alreadyRecommendedHandlerProvider;
    private final Provider<AutoReplyHandler> autoReplyHandlerProvider;

    private AlreadyRecommendedChain_Factory(Provider<AlreadyRecommendedHandler> alreadyRecommendedHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        this.alreadyRecommendedHandlerProvider = alreadyRecommendedHandlerProvider;
        this.autoReplyHandlerProvider = autoReplyHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AlreadyRecommendedChain get() {
        return newInstance(this.alreadyRecommendedHandlerProvider.get(), this.autoReplyHandlerProvider.get());
    }

    public static AlreadyRecommendedChain_Factory create(Provider<AlreadyRecommendedHandler> alreadyRecommendedHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        return new AlreadyRecommendedChain_Factory(alreadyRecommendedHandlerProvider, autoReplyHandlerProvider);
    }

    public static AlreadyRecommendedChain newInstance(AlreadyRecommendedHandler alreadyRecommendedHandler, AutoReplyHandler autoReplyHandler) {
        return new AlreadyRecommendedChain(alreadyRecommendedHandler, autoReplyHandler);
    }
}
