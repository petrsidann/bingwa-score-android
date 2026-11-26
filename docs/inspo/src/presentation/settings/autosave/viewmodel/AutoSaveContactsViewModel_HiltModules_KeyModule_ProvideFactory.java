package com.example.bingwahybrid.presentation.settings.autosave.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoSaveContactsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static AutoSaveContactsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return AutoSaveContactsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final AutoSaveContactsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new AutoSaveContactsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
