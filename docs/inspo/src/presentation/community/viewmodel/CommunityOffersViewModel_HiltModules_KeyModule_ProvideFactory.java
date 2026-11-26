package com.example.bingwahybrid.presentation.community.viewmodel;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class CommunityOffersViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static CommunityOffersViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return CommunityOffersViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final CommunityOffersViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new CommunityOffersViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
