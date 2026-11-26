package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class UpdateTransactionHandler_Factory implements Factory<UpdateTransactionHandler> {
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private UpdateTransactionHandler_Factory(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UpdateTransactionHandler get() {
        return newInstance(this.updateTransactionUseCaseProvider.get());
    }

    public static UpdateTransactionHandler_Factory create(Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        return new UpdateTransactionHandler_Factory(updateTransactionUseCaseProvider);
    }

    public static UpdateTransactionHandler newInstance(UpdateTransactionUseCase updateTransactionUseCase) {
        return new UpdateTransactionHandler(updateTransactionUseCase);
    }
}
