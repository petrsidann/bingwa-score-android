package com.example.bingwahybrid.domain.engine.validation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class StatusValidator_Factory implements Factory<StatusValidator> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public StatusValidator get() {
        return newInstance();
    }

    public static StatusValidator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static StatusValidator newInstance() {
        return new StatusValidator();
    }

    private static final class InstanceHolder {
        static final StatusValidator_Factory INSTANCE = new StatusValidator_Factory();

        private InstanceHolder() {
        }
    }
}
