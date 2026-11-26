package com.example.bingwahybrid.domain.sms.messageextractor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class TillMessageExtractor_Factory implements Factory<TillMessageExtractor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public TillMessageExtractor get() {
        return newInstance();
    }

    public static TillMessageExtractor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TillMessageExtractor newInstance() {
        return new TillMessageExtractor();
    }

    private static final class InstanceHolder {
        static final TillMessageExtractor_Factory INSTANCE = new TillMessageExtractor_Factory();

        private InstanceHolder() {
        }
    }
}
