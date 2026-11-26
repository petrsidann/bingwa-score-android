package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ExternalRetryHandler_Factory implements Factory<ExternalRetryHandler> {
    private final Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private ExternalRetryHandler_Factory(Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        this.rescheduleTransactionUseCaseProvider = rescheduleTransactionUseCaseProvider;
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ExternalRetryHandler get() {
        return newInstance(this.rescheduleTransactionUseCaseProvider.get(), this.updateTransactionUseCaseProvider.get());
    }

    public static ExternalRetryHandler_Factory create(Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        return new ExternalRetryHandler_Factory(rescheduleTransactionUseCaseProvider, updateTransactionUseCaseProvider);
    }

    public static ExternalRetryHandler newInstance(RescheduleTransactionUseCase rescheduleTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase) {
        return new ExternalRetryHandler(rescheduleTransactionUseCase, updateTransactionUseCase);
    }
}
