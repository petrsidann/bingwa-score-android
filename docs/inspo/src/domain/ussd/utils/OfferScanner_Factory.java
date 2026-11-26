package com.example.bingwahybrid.domain.ussd.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferScanner_Factory implements Factory<OfferScanner> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfferScanner get() {
        return newInstance();
    }

    public static OfferScanner_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OfferScanner newInstance() {
        return new OfferScanner();
    }

    private static final class InstanceHolder {
        static final OfferScanner_Factory INSTANCE = new OfferScanner_Factory();

        private InstanceHolder() {
        }
    }
}
