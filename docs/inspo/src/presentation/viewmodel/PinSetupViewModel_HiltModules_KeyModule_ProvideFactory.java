package com.example.bingwahybrid.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class PinSetupViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static PinSetupViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return PinSetupViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final PinSetupViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new PinSetupViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
