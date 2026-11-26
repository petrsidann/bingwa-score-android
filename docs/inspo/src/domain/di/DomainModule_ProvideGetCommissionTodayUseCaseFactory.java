package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.statistics.usecase.GetCommissionForDatesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetCommissionTodayUseCaseFactory implements Factory<GetCommissionForDatesUseCase> {
    private final Provider<AgentCommissionRepository> agentCommissionRateRepositoryProvider;

    private DomainModule_ProvideGetCommissionTodayUseCaseFactory(Provider<AgentCommissionRepository> agentCommissionRateRepositoryProvider) {
        this.agentCommissionRateRepositoryProvider = agentCommissionRateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCommissionForDatesUseCase get() {
        return provideGetCommissionTodayUseCase(this.agentCommissionRateRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetCommissionTodayUseCaseFactory create(Provider<AgentCommissionRepository> agentCommissionRateRepositoryProvider) {
        return new DomainModule_ProvideGetCommissionTodayUseCaseFactory(agentCommissionRateRepositoryProvider);
    }

    public static GetCommissionForDatesUseCase provideGetCommissionTodayUseCase(AgentCommissionRepository agentCommissionRateRepository) {
        return (GetCommissionForDatesUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetCommissionTodayUseCase(agentCommissionRateRepository));
    }
}
