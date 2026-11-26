package com.example.bingwahybrid.presentation.offers.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferSettingsViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static OfferSettingsViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return OfferSettingsViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final OfferSettingsViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OfferSettingsViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
