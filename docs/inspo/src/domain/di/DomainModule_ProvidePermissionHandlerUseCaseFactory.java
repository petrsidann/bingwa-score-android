package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.usecase.PermissionHandlerUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvidePermissionHandlerUseCaseFactory implements Factory<PermissionHandlerUseCase> {
    private final Provider<Context> contextProvider;

    private DomainModule_ProvidePermissionHandlerUseCaseFactory(Provider<Context> contextProvider) {
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PermissionHandlerUseCase get() {
        return providePermissionHandlerUseCase(this.contextProvider.get());
    }

    public static DomainModule_ProvidePermissionHandlerUseCaseFactory create(Provider<Context> contextProvider) {
        return new DomainModule_ProvidePermissionHandlerUseCaseFactory(contextProvider);
    }

    public static PermissionHandlerUseCase providePermissionHandlerUseCase(Context context) {
        return (PermissionHandlerUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.providePermissionHandlerUseCase(context));
    }
}
