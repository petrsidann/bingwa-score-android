package com.example.bingwahybrid.presentation.updates.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class CheckForUpdatesViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CheckForUpdatesViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CheckForUpdatesViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CheckForUpdatesViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CheckForUpdatesViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
