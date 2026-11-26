package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoReplyHandler_Factory implements Factory<AutoReplyHandler> {
    private final Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider;

    private AutoReplyHandler_Factory(Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider) {
        this.sendAutoReplyMessageUseCaseProvider = sendAutoReplyMessageUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoReplyHandler get() {
        return newInstance(this.sendAutoReplyMessageUseCaseProvider.get());
    }

    public static AutoReplyHandler_Factory create(Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider) {
        return new AutoReplyHandler_Factory(sendAutoReplyMessageUseCaseProvider);
    }

    public static AutoReplyHandler newInstance(SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase) {
        return new AutoReplyHandler(sendAutoReplyMessageUseCase);
    }
}
