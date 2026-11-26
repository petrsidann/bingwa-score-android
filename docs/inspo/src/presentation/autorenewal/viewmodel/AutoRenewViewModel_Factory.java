package com.example.bingwahybrid.presentation.autorenewal.viewmodel;

import com.example.bingwahybrid.domain.repository.TransactionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoRenewViewModel_Factory implements Factory<AutoRenewViewModel> {
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private AutoRenewViewModel_Factory(Provider<TransactionRepository> transactionRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoRenewViewModel get() {
        return newInstance(this.transactionRepositoryProvider.get());
    }

    public static AutoRenewViewModel_Factory create(Provider<TransactionRepository> transactionRepositoryProvider) {
        return new AutoRenewViewModel_Factory(transactionRepositoryProvider);
    }

    public static AutoRenewViewModel newInstance(TransactionRepository transactionRepository) {
        return new AutoRenewViewModel(transactionRepository);
    }
}
