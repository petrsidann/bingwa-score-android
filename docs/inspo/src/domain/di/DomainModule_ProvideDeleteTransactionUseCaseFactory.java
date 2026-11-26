package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.DeleteTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideDeleteTransactionUseCaseFactory implements Factory<DeleteTransactionUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DomainModule_ProvideDeleteTransactionUseCaseFactory(Provider<Context> contextProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.contextProvider = contextProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteTransactionUseCase get() {
        return provideDeleteTransactionUseCase(this.contextProvider.get(), this.transactionRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DomainModule_ProvideDeleteTransactionUseCaseFactory create(Provider<Context> contextProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DomainModule_ProvideDeleteTransactionUseCaseFactory(contextProvider, transactionRepositoryProvider, transactionRelayProvider);
    }

    public static DeleteTransactionUseCase provideDeleteTransactionUseCase(Context context, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        return (DeleteTransactionUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideDeleteTransactionUseCase(context, transactionRepository, transactionRelay));
    }
}
