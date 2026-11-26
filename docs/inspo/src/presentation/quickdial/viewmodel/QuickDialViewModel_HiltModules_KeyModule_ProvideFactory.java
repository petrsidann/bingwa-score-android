package com.example.bingwahybrid.presentation.quickdial.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class QuickDialViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static QuickDialViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return QuickDialViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final QuickDialViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new QuickDialViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
