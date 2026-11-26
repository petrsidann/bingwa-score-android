package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.CommissionRateRepository;
import com.example.bingwahybrid.domain.usecase.GetCommissionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetCommissionUseCaseFactory implements Factory<GetCommissionUseCase> {
    private final Provider<CommissionRateRepository> commissionRateRepositoryProvider;

    private DomainModule_ProvideGetCommissionUseCaseFactory(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        this.commissionRateRepositoryProvider = commissionRateRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetCommissionUseCase get() {
        return provideGetCommissionUseCase(this.commissionRateRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetCommissionUseCaseFactory create(Provider<CommissionRateRepository> commissionRateRepositoryProvider) {
        return new DomainModule_ProvideGetCommissionUseCaseFactory(commissionRateRepositoryProvider);
    }

    public static GetCommissionUseCase provideGetCommissionUseCase(CommissionRateRepository commissionRateRepository) {
        return (GetCommissionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetCommissionUseCase(commissionRateRepository));
    }
}
