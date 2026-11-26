package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.engine.FormatUssdUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideFormatUssdUseCaseFactory implements Factory<FormatUssdUseCase> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FormatUssdUseCase get() {
        return provideFormatUssdUseCase();
    }

    public static DomainModule_ProvideFormatUssdUseCaseFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FormatUssdUseCase provideFormatUssdUseCase() {
        return (FormatUssdUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideFormatUssdUseCase());
    }

    private static final class InstanceHolder {
        static final DomainModule_ProvideFormatUssdUseCaseFactory INSTANCE = new DomainModule_ProvideFormatUssdUseCaseFactory();

        private InstanceHolder() {
        }
    }
}
