package com.example.bingwahybrid.domain.engagebot.usecase;

import com.example.bingwahybrid.domain.engagebot.repository.EngageBotRepository;
import com.example.bingwahybrid.domain.engagebot.repository.EngageBotSessionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class StartEngageBotForTransactionUseCase_Factory implements Factory<StartEngageBotForTransactionUseCase> {
    private final Provider<EngageBotRepository> engageBotRepositoryProvider;
    private final Provider<EngageBotSessionRepository> engageBotSessionRepositoryProvider;

    private StartEngageBotForTransactionUseCase_Factory(Provider<EngageBotRepository> engageBotRepositoryProvider, Provider<EngageBotSessionRepository> engageBotSessionRepositoryProvider) {
        this.engageBotRepositoryProvider = engageBotRepositoryProvider;
        this.engageBotSessionRepositoryProvider = engageBotSessionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StartEngageBotForTransactionUseCase get() {
        return newInstance(this.engageBotRepositoryProvider.get(), this.engageBotSessionRepositoryProvider.get());
    }

    public static StartEngageBotForTransactionUseCase_Factory create(Provider<EngageBotRepository> engageBotRepositoryProvider, Provider<EngageBotSessionRepository> engageBotSessionRepositoryProvider) {
        return new StartEngageBotForTransactionUseCase_Factory(engageBotRepositoryProvider, engageBotSessionRepositoryProvider);
    }

    public static StartEngageBotForTransactionUseCase newInstance(EngageBotRepository engageBotRepository, EngageBotSessionRepository engageBotSessionRepository) {
        return new StartEngageBotForTransactionUseCase(engageBotRepository, engageBotSessionRepository);
    }
}
