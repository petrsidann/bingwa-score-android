package com.example.bingwahybrid.domain.sms.processor;

import com.example.bingwahybrid.domain.sms.handler.PrioritizedSmsHandler;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class SmsProcessor_Factory implements Factory<SmsProcessor> {
    private final Provider<Set<PrioritizedSmsHandler>> handlersProvider;

    private SmsProcessor_Factory(Provider<Set<PrioritizedSmsHandler>> handlersProvider) {
        this.handlersProvider = handlersProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SmsProcessor get() {
        return newInstance(this.handlersProvider.get());
    }

    public static SmsProcessor_Factory create(Provider<Set<PrioritizedSmsHandler>> handlersProvider) {
        return new SmsProcessor_Factory(handlersProvider);
    }

    public static SmsProcessor newInstance(Set<PrioritizedSmsHandler> handlers) {
        return new SmsProcessor(handlers);
    }
}
