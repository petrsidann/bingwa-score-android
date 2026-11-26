package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.ExternalRetryHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.TimeoutHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeoutChain_Factory implements Factory<TimeoutChain> {
    private final Provider<AutoReplyHandler> autoReplyHandlerProvider;
    private final Provider<ExternalRetryHandler> externalRetryHandlerProvider;
    private final Provider<TimeoutHandler> timeoutHandlerProvider;

    private TimeoutChain_Factory(Provider<TimeoutHandler> timeoutHandlerProvider, Provider<ExternalRetryHandler> externalRetryHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        this.timeoutHandlerProvider = timeoutHandlerProvider;
        this.externalRetryHandlerProvider = externalRetryHandlerProvider;
        this.autoReplyHandlerProvider = autoReplyHandlerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TimeoutChain get() {
        return newInstance(this.timeoutHandlerProvider.get(), this.externalRetryHandlerProvider.get(), this.autoReplyHandlerProvider.get());
    }

    public static TimeoutChain_Factory create(Provider<TimeoutHandler> timeoutHandlerProvider, Provider<ExternalRetryHandler> externalRetryHandlerProvider, Provider<AutoReplyHandler> autoReplyHandlerProvider) {
        return new TimeoutChain_Factory(timeoutHandlerProvider, externalRetryHandlerProvider, autoReplyHandlerProvider);
    }

    public static TimeoutChain newInstance(TimeoutHandler timeoutHandler, ExternalRetryHandler externalRetryHandler, AutoReplyHandler autoReplyHandler) {
        return new TimeoutChain(timeoutHandler, externalRetryHandler, autoReplyHandler);
    }
}
