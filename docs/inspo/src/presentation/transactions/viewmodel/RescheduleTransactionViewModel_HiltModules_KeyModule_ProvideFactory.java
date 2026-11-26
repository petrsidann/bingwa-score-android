package com.example.bingwahybrid.presentation.transactions.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class RescheduleTransactionViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static RescheduleTransactionViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return RescheduleTransactionViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final RescheduleTransactionViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new RescheduleTransactionViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
