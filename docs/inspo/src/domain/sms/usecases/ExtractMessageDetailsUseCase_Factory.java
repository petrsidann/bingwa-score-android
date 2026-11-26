package com.example.bingwahybrid.domain.sms.usecases;

import com.example.bingwahybrid.domain.sms.messageextractor.MessageExtractor;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ExtractMessageDetailsUseCase_Factory implements Factory<ExtractMessageDetailsUseCase> {
    private final Provider<MessageExtractor> mpesaMessageExtractorProvider;
    private final Provider<MessageExtractor> payBillMessageExtractorProvider;
    private final Provider<MessageExtractor> siteLinkMessageExtractorProvider;
    private final Provider<MessageExtractor> tillMessageExtractorProvider;

    private ExtractMessageDetailsUseCase_Factory(Provider<MessageExtractor> mpesaMessageExtractorProvider, Provider<MessageExtractor> tillMessageExtractorProvider, Provider<MessageExtractor> payBillMessageExtractorProvider, Provider<MessageExtractor> siteLinkMessageExtractorProvider) {
        this.mpesaMessageExtractorProvider = mpesaMessageExtractorProvider;
        this.tillMessageExtractorProvider = tillMessageExtractorProvider;
        this.payBillMessageExtractorProvider = payBillMessageExtractorProvider;
        this.siteLinkMessageExtractorProvider = siteLinkMessageExtractorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ExtractMessageDetailsUseCase get() {
        return newInstance(this.mpesaMessageExtractorProvider.get(), this.tillMessageExtractorProvider.get(), this.payBillMessageExtractorProvider.get(), this.siteLinkMessageExtractorProvider.get());
    }

    public static ExtractMessageDetailsUseCase_Factory create(Provider<MessageExtractor> mpesaMessageExtractorProvider, Provider<MessageExtractor> tillMessageExtractorProvider, Provider<MessageExtractor> payBillMessageExtractorProvider, Provider<MessageExtractor> siteLinkMessageExtractorProvider) {
        return new ExtractMessageDetailsUseCase_Factory(mpesaMessageExtractorProvider, tillMessageExtractorProvider, payBillMessageExtractorProvider, siteLinkMessageExtractorProvider);
    }

    public static ExtractMessageDetailsUseCase newInstance(MessageExtractor mpesaMessageExtractor, MessageExtractor tillMessageExtractor, MessageExtractor payBillMessageExtractor, MessageExtractor siteLinkMessageExtractor) {
        return new ExtractMessageDetailsUseCase(mpesaMessageExtractor, tillMessageExtractor, payBillMessageExtractor, siteLinkMessageExtractor);
    }
}
