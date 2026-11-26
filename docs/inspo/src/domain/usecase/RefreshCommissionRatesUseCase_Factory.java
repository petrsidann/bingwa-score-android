package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RefreshCommissionRatesUseCase_Factory implements Factory<RefreshCommissionRatesUseCase> {
    private final Provider<CommissionRateRepository> commissionRateRepositoryProvider;

    private RefreshCommissionRatesUseCase_Factory(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        this.commissionRateRepositoryProvider = commissionRateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RefreshCommissionRatesUseCase get() {
        return newInstance(this.commissionRateRepositoryProvider.get());
    }

    public static RefreshCommissionRatesUseCase_Factory create(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        return new RefreshCommissionRatesUseCase_Factory(commissionRateRepositoryProvider);
    }

    public static RefreshCommissionRatesUseCase newInstance(CommissionRateRepository commissionRateRepository) {
        return new RefreshCommissionRatesUseCase(commissionRateRepository);
    }
}
