package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.engine.advanced.UssdAccessibilityService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideUssdAccessibilityServiceFactory implements Factory<UssdAccessibilityService> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UssdAccessibilityService get() {
        return provideUssdAccessibilityService();
    }

    public static DomainModule_ProvideUssdAccessibilityServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UssdAccessibilityService provideUssdAccessibilityService() {
        return (UssdAccessibilityService) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideUssdAccessibilityService());
    }

    private static final class InstanceHolder {
        static final DomainModule_ProvideUssdAccessibilityServiceFactory INSTANCE = new DomainModule_ProvideUssdAccessibilityServiceFactory();

        private InstanceHolder() {
        }
    }
}
