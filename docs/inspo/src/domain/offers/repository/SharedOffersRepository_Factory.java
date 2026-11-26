package com.example.bingwahybrid.domain.offers.repository;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedOffersRepository_Factory implements Factory<SharedOffersRepository> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SharedOffersRepository get() {
        return newInstance();
    }

    public static SharedOffersRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SharedOffersRepository newInstance() {
        return new SharedOffersRepository();
    }

    private static final class InstanceHolder {
        static final SharedOffersRepository_Factory INSTANCE = new SharedOffersRepository_Factory();

        private InstanceHolder() {
        }
    }
}
