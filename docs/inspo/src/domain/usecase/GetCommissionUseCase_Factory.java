package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetCommissionUseCase_Factory implements Factory<GetCommissionUseCase> {
    private final Provider<CommissionRateRepository> commissionRateRepositoryProvider;

    private GetCommissionUseCase_Factory(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        this.commissionRateRepositoryProvider = commissionRateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCommissionUseCase get() {
        return newInstance(this.commissionRateRepositoryProvider.get());
    }

    public static GetCommissionUseCase_Factory create(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        return new GetCommissionUseCase_Factory(commissionRateRepositoryProvider);
    }

    public static GetCommissionUseCase newInstance(CommissionRateRepository commissionRateRepository) {
        return new GetCommissionUseCase(commissionRateRepository);
    }
}
