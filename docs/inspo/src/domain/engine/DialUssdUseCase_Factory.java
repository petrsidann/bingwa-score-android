package com.example.bingwahybrid.domain.engine;

import android.content.Context;
import com.example.bingwahybrid.domain.engine.validation.TransactionValidator;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class DialUssdUseCase_Factory implements Factory<DialUssdUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;
    private final Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider;
    private final Provider<Set<TransactionValidator>> validatorsProvider;

    private DialUssdUseCase_Factory(Provider<Context> contextProvider, Provider<Set<TransactionValidator>> validatorsProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        this.contextProvider = contextProvider;
        this.validatorsProvider = validatorsProvider;
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.updateTransactionUseCaseProvider = updateTransactionUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DialUssdUseCase get() {
        return newInstance(this.contextProvider.get(), this.validatorsProvider.get(), this.transactionRepositoryProvider.get(), this.updateTransactionUseCaseProvider.get());
    }

    public static DialUssdUseCase_Factory create(Provider<Context> contextProvider, Provider<Set<TransactionValidator>> validatorsProvider, Provider<TransactionRepository> transactionRepositoryProvider, Provider<UpdateTransactionUseCase> updateTransactionUseCaseProvider) {
        return new DialUssdUseCase_Factory(contextProvider, validatorsProvider, transactionRepositoryProvider, updateTransactionUseCaseProvider);
    }

    public static DialUssdUseCase newInstance(Context context, Set<TransactionValidator> validators, TransactionRepository transactionRepository, UpdateTransactionUseCase updateTransactionUseCase) {
        return new DialUssdUseCase(context, validators, transactionRepository, updateTransactionUseCase);
    }
}
