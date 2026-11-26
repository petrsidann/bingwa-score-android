package com.example.bingwahybrid.domain.engine.validation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class OfferValidator_Factory implements Factory<OfferValidator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfferValidator get() {
        return newInstance();
    }

    public static OfferValidator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OfferValidator newInstance() {
        return new OfferValidator();
    }

    private static final class InstanceHolder {
        static final OfferValidator_Factory INSTANCE = new OfferValidator_Factory();

        private InstanceHolder() {
        }
    }
}
