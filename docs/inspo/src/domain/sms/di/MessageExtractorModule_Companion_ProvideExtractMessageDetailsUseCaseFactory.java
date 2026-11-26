package com.example.bingwahybrid.domain.sms.di;

import com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor;
import com.example.bingwahybrid.domain.sms.usecases.ExtractMessageDetailsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class MessageExtractorModule_Companion_ProvideExtractMessageDetailsUseCaseFactory implements Factory<ExtractMessageDetailsUseCase> {
    private final Provider<MessageExtractor> mpesaMessageExtractorProvider;
    private final Provider<MessageExtractor> payBillMessageExtractorProvider;
    private final Provider<MessageExtractor> siteLinkMessageExtractorProvider;
    private final Provider<MessageExtractor> tillMessagesExtractorProvider;

    private MessageExtractorModule_Companion_ProvideExtractMessageDetailsUseCaseFactory(Provider<MessageExtractor> mpesaMessageExtractorProvider, Provider<MessageExtractor> tillMessagesExtractorProvider, Provider<MessageExtractor> payBillMessageExtractorProvider, Provider<MessageExtractor> siteLinkMessageExtractorProvider) {
        this.mpesaMessageExtractorProvider = mpesaMessageExtractorProvider;
        this.tillMessagesExtractorProvider = tillMessagesExtractorProvider;
        this.payBillMessageExtractorProvider = payBillMessageExtractorProvider;
        this.siteLinkMessageExtractorProvider = siteLinkMessageExtractorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ExtractMessageDetailsUseCase get() {
        return provideExtractMessageDetailsUseCase(this.mpesaMessageExtractorProvider.get(), this.tillMessagesExtractorProvider.get(), this.payBillMessageExtractorProvider.get(), this.siteLinkMessageExtractorProvider.get());
    }

    public static MessageExtractorModule_Companion_ProvideExtractMessageDetailsUseCaseFactory create(Provider<MessageExtractor> mpesaMessageExtractorProvider, Provider<MessageExtractor> tillMessagesExtractorProvider, Provider<MessageExtractor> payBillMessageExtractorProvider, Provider<MessageExtractor> siteLinkMessageExtractorProvider) {
        return new MessageExtractorModule_Companion_ProvideExtractMessageDetailsUseCaseFactory(mpesaMessageExtractorProvider, tillMessagesExtractorProvider, payBillMessageExtractorProvider, siteLinkMessageExtractorProvider);
    }

    public static ExtractMessageDetailsUseCase provideExtractMessageDetailsUseCase(MessageExtractor mpesaMessageExtractor, MessageExtractor tillMessagesExtractor, MessageExtractor payBillMessageExtractor, MessageExtractor siteLinkMessageExtractor) {
        return (ExtractMessageDetailsUseCase) Preconditions.checkNotNullFromProvides(MessageExtractorModule.INSTANCE.provideExtractMessageDetailsUseCase(mpesaMessageExtractor, tillMessagesExtractor, payBillMessageExtractor, siteLinkMessageExtractor));
    }
}
