package com.example.bingwahybrid.domain.sms.messageextractor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class PayBillMessageExtractor_Factory implements Factory<PayBillMessageExtractor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PayBillMessageExtractor get() {
        return newInstance();
    }

    public static PayBillMessageExtractor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PayBillMessageExtractor newInstance() {
        return new PayBillMessageExtractor();
    }

    private static final class InstanceHolder {
        static final PayBillMessageExtractor_Factory INSTANCE = new PayBillMessageExtractor_Factory();

        private InstanceHolder() {
        }
    }
}
