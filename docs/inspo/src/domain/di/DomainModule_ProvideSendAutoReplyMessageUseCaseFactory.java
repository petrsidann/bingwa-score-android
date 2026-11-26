package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
import com.example.bingwahybrid.domain.messaging.usecase.SendSmsUseCase;
import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideSendAutoReplyMessageUseCaseFactory implements Factory<SendAutoReplyMessageUseCase> {
    private final Provider<AutoReplyRepository> autoReplyRepositoryProvider;
    private final Provider<SendSmsUseCase> sendSmsUseCaseProvider;

    private DomainModule_ProvideSendAutoReplyMessageUseCaseFactory(Provider<AutoReplyRepository> autoReplyRepositoryProvider, Provider<SendSmsUseCase> sendSmsUseCaseProvider) {
        this.autoReplyRepositoryProvider = autoReplyRepositoryProvider;
        this.sendSmsUseCaseProvider = sendSmsUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SendAutoReplyMessageUseCase get() {
        return provideSendAutoReplyMessageUseCase(this.autoReplyRepositoryProvider.get(), this.sendSmsUseCaseProvider.get());
    }

    public static DomainModule_ProvideSendAutoReplyMessageUseCaseFactory create(Provider<AutoReplyRepository> autoReplyRepositoryProvider, Provider<SendSmsUseCase> sendSmsUseCaseProvider) {
        return new DomainModule_ProvideSendAutoReplyMessageUseCaseFactory(autoReplyRepositoryProvider, sendSmsUseCaseProvider);
    }

    public static SendAutoReplyMessageUseCase provideSendAutoReplyMessageUseCase(AutoReplyRepository autoReplyRepository, SendSmsUseCase sendSmsUseCase) {
        return (SendAutoReplyMessageUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideSendAutoReplyMessageUseCase(autoReplyRepository, sendSmsUseCase));
    }
}
