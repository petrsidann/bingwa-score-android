package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import com.example.bingwahybrid.domain.portal.TransactionRelay;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DeleteTransactionUseCase_Factory implements Factory<DeleteTransactionUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<TransactionRelay> transactionRelayProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private DeleteTransactionUseCase_Factory(Provider<Context> contextProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        this.contextProvider = contextProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.transactionRelayProvider = transactionRelayProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteTransactionUseCase get() {
        return newInstance(this.contextProvider.get(), this.transactionRepositoryProvider.get(), this.transactionRelayProvider.get());
    }

    public static DeleteTransactionUseCase_Factory create(Provider<Context> contextProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<TransactionRelay> transactionRelayProvider) {
        return new DeleteTransactionUseCase_Factory(contextProvider, transactionRepositoryProvider, transactionRelayProvider);
    }

    public static DeleteTransactionUseCase newInstance(Context context, TransactionRepository transactionRepository, TransactionRelay transactionRelay) {
        return new DeleteTransactionUseCase(context, transactionRepository, transactionRelay);
    }
}
