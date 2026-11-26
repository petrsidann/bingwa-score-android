package com.example.bingwahybrid.domain.sms.messageextractor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class MpesaMessageExtractor_Factory implements Factory<MpesaMessageExtractor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MpesaMessageExtractor get() {
        return newInstance();
    }

    public static MpesaMessageExtractor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MpesaMessageExtractor newInstance() {
        return new MpesaMessageExtractor();
    }

    private static final class InstanceHolder {
        static final MpesaMessageExtractor_Factory INSTANCE = new MpesaMessageExtractor_Factory();

        private InstanceHolder() {
        }
    }
}
