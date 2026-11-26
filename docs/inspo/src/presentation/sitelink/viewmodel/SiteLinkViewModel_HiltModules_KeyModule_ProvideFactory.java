package com.example.bingwahybrid.presentation.sitelink.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class SiteLinkViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static SiteLinkViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return SiteLinkViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final SiteLinkViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SiteLinkViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
