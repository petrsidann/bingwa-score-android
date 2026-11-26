package com.example.bingwahybrid.domain.engine.validation;

import android.content.Context;
import com.example.bingwahybrid.domain.usecase.PermissionHandlerUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class PermissionValidator_Factory implements Factory<PermissionValidator> {
    private final Provider<Context> contextProvider;
    private final Provider<PermissionHandlerUseCase> permissionHandlerProvider;

    private PermissionValidator_Factory(Provider<PermissionHandlerUseCase> permissionHandlerProvider, Provider<Context> contextProvider) {
        this.permissionHandlerProvider = permissionHandlerProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PermissionValidator get() {
        return newInstance(this.permissionHandlerProvider.get(), this.contextProvider.get());
    }

    public static PermissionValidator_Factory create(Provider<PermissionHandlerUseCase> permissionHandlerProvider, Provider<Context> contextProvider) {
        return new PermissionValidator_Factory(permissionHandlerProvider, contextProvider);
    }

    public static PermissionValidator newInstance(PermissionHandlerUseCase permissionHandler, Context context) {
        return new PermissionValidator(permissionHandler, context);
    }
}
