package com.example.bingwahybrid.presentation.transactions.viewmodel;

import com.example.bingwahybrid.domain.engine.DialUssdUseCase;
import com.example.bingwahybrid.domain.offers.repository.OfferRepository;
import com.example.bingwahybrid.domain.usecase.CreateTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.GetTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class RescheduleTransactionViewModel_Factory implements Factory<RescheduleTransactionViewModel> {
    private final Provider<CreateTransactionUseCase> createTransactionUseCaseProvider;
    private final Provider<DialUssdUseCase> dialUssdUseCaseProvider;
    private final Provider<GetTransactionUseCase> getTransactionUseCaseProvider;
    private final Provider<OfferRepository> offerRepositoryProvider;
    private final Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;

    private RescheduleTransactionViewModel_Factory(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetTransactionUseCase> getTransactionUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider) {
        this.dialUssdUseCaseProvider = dialUssdUseCaseProvider;
        this.getTransactionUseCaseProvider = getTransactionUseCaseProvider;
        this.createTransactionUseCaseProvider = createTransactionUseCaseProvider;
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
        this.rescheduleTransactionUseCaseProvider = rescheduleTransactionUseCaseProvider;
        this.offerRepositoryProvider = offerRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RescheduleTransactionViewModel get() {
        return newInstance(this.dialUssdUseCaseProvider.get(), this.getTransactionUseCaseProvider.get(), this.createTransactionUseCaseProvider.get(), this.updateTransactionUseCaseProvider.get(), this.rescheduleTransactionUseCaseProvider.get(), this.offerRepositoryProvider.get());
    }

    public static RescheduleTransactionViewModel_Factory create(Provider<DialUssdUseCase> dialUssdUseCaseProvider, Provider<GetTransactionUseCase> getTransactionUseCaseProvider, Provider<CreateTransactionUseCase> createTransactionUseCaseProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider, Provider<RescheduleTransactionUseCase> rescheduleTransactionUseCaseProvider, Provider<OfferRepository> offerRepositoryProvider) {
        return new RescheduleTransactionViewModel_Factory(dialUssdUseCaseProvider, getTransactionUseCaseProvider, createTransactionUseCaseProvider, updateTransactionUseCaseProvider, rescheduleTransactionUseCaseProvider, offerRepositoryProvider);
    }

    public static RescheduleTransactionViewModel newInstance(DialUssdUseCase dialUssdUseCase, GetTransactionUseCase getTransactionUseCase, CreateTransactionUseCase createTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase, RescheduleTransactionUseCase rescheduleTransactionUseCase, OfferRepository offerRepository) {
        return new RescheduleTransactionViewModel(dialUssdUseCase, getTransactionUseCase, createTransactionUseCase, updateTransactionUseCase, rescheduleTransactionUseCase, offerRepository);
    }
}
