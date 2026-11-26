package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engagebot.usecase.StartEngageBotForTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AlreadyRecommendedHandler_Factory implements Factory<AlreadyRecommendedHandler> {
    private final Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider;
    private final Provider<StartEngageBotForTransactionUseCase> startEngageBotForTransactionUseCaseProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private AlreadyRecommendedHandler_Factory(Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<StartEngageBotForTransactionUseCase> startEngageBotForTransactionUseCaseProvider) {
        this.rescheduleTransactionUseCaseProvider = rescheduleTransactionUseCaseProvider;
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.startEngageBotForTransactionUseCaseProvider = startEngageBotForTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AlreadyRecommendedHandler get() {
        return newInstance(this.rescheduleTransactionUseCaseProvider.get(), this.updateTransactionUseCaseProvider.get(), this.startEngageBotForTransactionUseCaseProvider.get());
    }

    public static AlreadyRecommendedHandler_Factory create(Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<StartEngageBotForTransactionUseCase> startEngageBotForTransactionUseCaseProvider) {
        return new AlreadyRecommendedHandler_Factory(rescheduleTransactionUseCaseProvider, updateTransactionUseCaseProvider, startEngageBotForTransactionUseCaseProvider);
    }

    public static AlreadyRecommendedHandler newInstance(RescheduleTransactionUseCase rescheduleTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase, StartEngageBotForTransactionUseCase startEngageBotForTransactionUseCase) {
        return new AlreadyRecommendedHandler(rescheduleTransactionUseCase, updateTransactionUseCase, startEngageBotForTransactionUseCase);
    }
}
