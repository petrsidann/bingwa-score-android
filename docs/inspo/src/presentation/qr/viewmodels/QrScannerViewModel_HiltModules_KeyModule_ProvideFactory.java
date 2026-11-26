package com.example.bingwahybrid.presentation.qr.viewmodels;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class QrScannerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(provide());
    }

    public static QrScannerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static boolean provide() {
        return QrScannerViewModel_HiltModules.KeyModule.provide();
    }

    private static final class InstanceHolder {
        static final QrScannerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new QrScannerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
