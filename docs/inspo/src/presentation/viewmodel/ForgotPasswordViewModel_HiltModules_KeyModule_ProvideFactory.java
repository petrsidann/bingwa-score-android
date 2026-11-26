package com.example.bingwahybrid.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return ForgotPasswordViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
