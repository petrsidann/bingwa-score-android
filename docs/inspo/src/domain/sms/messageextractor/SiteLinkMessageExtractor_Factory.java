package com.example.bingwahybrid.domain.sms.messageextractor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class SiteLinkMessageExtractor_Factory implements Factory<SiteLinkMessageExtractor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SiteLinkMessageExtractor get() {
        return newInstance();
    }

    public static SiteLinkMessageExtractor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SiteLinkMessageExtractor newInstance() {
        return new SiteLinkMessageExtractor();
    }

    private static final class InstanceHolder {
        static final SiteLinkMessageExtractor_Factory INSTANCE = new SiteLinkMessageExtractor_Factory();

        private InstanceHolder() {
        }
    }
}
