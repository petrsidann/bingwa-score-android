package com.example.bingwahybrid.presentation.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class AccessibilityInfoViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static AccessibilityInfoViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AccessibilityInfoViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final AccessibilityInfoViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AccessibilityInfoViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
