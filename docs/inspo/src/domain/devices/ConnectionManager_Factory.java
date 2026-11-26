package com.example.bingwahybrid.domain.devices;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectionManager_Factory implements Factory<ConnectionManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ConnectionManager get() {
        return newInstance();
    }

    public static ConnectionManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ConnectionManager newInstance() {
        return new ConnectionManager();
    }

    private static final class InstanceHolder {
        static final ConnectionManager_Factory INSTANCE = new ConnectionManager_Factory();

        private InstanceHolder() {
        }
    }
}
