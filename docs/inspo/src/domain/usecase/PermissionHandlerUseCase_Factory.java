package com.example.bingwahybrid.domain.usecase;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class PermissionHandlerUseCase_Factory implements Factory<PermissionHandlerUseCase> {
    private final Provider<Context> contextProvider;

    private PermissionHandlerUseCase_Factory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PermissionHandlerUseCase get() {
        return newInstance(this.contextProvider.get());
    }

    public static PermissionHandlerUseCase_Factory create(Provider<Context> contextProvider) {
        return new PermissionHandlerUseCase_Factory(contextProvider);
    }

    public static PermissionHandlerUseCase newInstance(Context context) {
        return new PermissionHandlerUseCase(context);
    }
}
