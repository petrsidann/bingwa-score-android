package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import com.example.bingwahybrid.domain.usecase.RefreshCommissionRatesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideRefreshCommissionRatesUseCaseFactory implements Factory<RefreshCommissionRatesUseCase> {
    private final Provider<CommissionRateRepository> commissionRateRepositoryProvider;

    private DomainModule_ProvideRefreshCommissionRatesUseCaseFactory(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        this.commissionRateRepositoryProvider = commissionRateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RefreshCommissionRatesUseCase get() {
        return provideRefreshCommissionRatesUseCase(this.commissionRateRepositoryProvider.get());
    }

    public static DomainModule_ProvideRefreshCommissionRatesUseCaseFactory create(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        return new DomainModule_ProvideRefreshCommissionRatesUseCaseFactory(commissionRateRepositoryProvider);
    }

    public static RefreshCommissionRatesUseCase provideRefreshCommissionRatesUseCase(CommissionRateRepository commissionRateRepository) {
        return (RefreshCommissionRatesUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideRefreshCommissionRatesUseCase(commissionRateRepository));
    }
}
