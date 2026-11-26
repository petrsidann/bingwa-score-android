package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.sms.usecases.CreateSmsTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideCreateSmsTransactionUseCaseFactory implements Factory<CreateSmsTransactionUseCase> {
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideCreateSmsTransactionUseCaseFactory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CreateSmsTransactionUseCase get() {
        return provideCreateSmsTransactionUseCase(this.transactionRepositoryProvider.get(), this.customerRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DomainModule_ProvideCreateSmsTransactionUseCaseFactory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<CustomerRepository> customerRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DomainModule_ProvideCreateSmsTransactionUseCaseFactory(transactionRepositoryProvider, customerRepositoryProvider, transactionRelayProvider);
    }

    public static CreateSmsTransactionUseCase provideCreateSmsTransactionUseCase(TransactionRepository transactionRepository, CustomerRepository customerRepository, TransactionRelay transactionRelay) {
        return (CreateSmsTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideCreateSmsTransactionUseCase(transactionRepository, customerRepository, transactionRelay));
    }
}
