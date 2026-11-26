package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomerBlacklistValidator_Factory implements Factory<CustomerBlacklistValidator> {
    private final Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider;

    private CustomerBlacklistValidator_Factory(Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider) {
        this.sendAutoReplyMessageUseCaseProvider = sendAutoReplyMessageUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CustomerBlacklistValidator get() {
        return newInstance(this.sendAutoReplyMessageUseCaseProvider.get());
    }

    public static CustomerBlacklistValidator_Factory create(Provider<SendAutoReplyMessageUseCase> sendAutoReplyMessageUseCaseProvider) {
        return new CustomerBlacklistValidator_Factory(sendAutoReplyMessageUseCaseProvider);
    }

    public static CustomerBlacklistValidator newInstance(SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase) {
        return new CustomerBlacklistValidator(sendAutoReplyMessageUseCase);
    }
}
