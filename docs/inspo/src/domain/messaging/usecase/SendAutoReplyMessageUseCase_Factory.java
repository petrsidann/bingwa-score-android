package com.example.bingwahybrid.domain.messaging.usecase;

import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SendAutoReplyMessageUseCase_Factory implements Factory<SendAutoReplyMessageUseCase> {
    private final Provider<AutoReplyRepository> autoReplyRepositoryProvider;
    private final Provider<SendSmsUseCase> sendSmsUseCaseProvider;

    private SendAutoReplyMessageUseCase_Factory(Provider<AutoReplyRepository> autoReplyRepositoryProvider, Provider<SendSmsUseCase> sendSmsUseCaseProvider) {
        this.autoReplyRepositoryProvider = autoReplyRepositoryProvider;
        this.sendSmsUseCaseProvider = sendSmsUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SendAutoReplyMessageUseCase get() {
        return newInstance(this.autoReplyRepositoryProvider.get(), this.sendSmsUseCaseProvider.get());
    }

    public static SendAutoReplyMessageUseCase_Factory create(Provider<AutoReplyRepository> autoReplyRepositoryProvider, Provider<SendSmsUseCase> sendSmsUseCaseProvider) {
        return new SendAutoReplyMessageUseCase_Factory(autoReplyRepositoryProvider, sendSmsUseCaseProvider);
    }

    public static SendAutoReplyMessageUseCase newInstance(AutoReplyRepository autoReplyRepository, SendSmsUseCase sendSmsUseCase) {
        return new SendAutoReplyMessageUseCase(autoReplyRepository, sendSmsUseCase);
    }
}
