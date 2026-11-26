package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import com.example.bingwahybrid.domain.usecase.GetAutoRepliesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideGetAutoRepliesUseCaseFactory implements Factory<GetAutoRepliesUseCase> {
    private final Provider<AutoReplyRepository> autoReplyRepositoryProvider;

    private DomainModule_ProvideGetAutoRepliesUseCaseFactory(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        this.autoReplyRepositoryProvider = autoReplyRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetAutoRepliesUseCase get() {
        return provideGetAutoRepliesUseCase(this.autoReplyRepositoryProvider.get());
    }

    public static DomainModule_ProvideGetAutoRepliesUseCaseFactory create(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        return new DomainModule_ProvideGetAutoRepliesUseCaseFactory(autoReplyRepositoryProvider);
    }

    public static GetAutoRepliesUseCase provideGetAutoRepliesUseCase(AutoReplyRepository autoReplyRepository) {
        return (GetAutoRepliesUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideGetAutoRepliesUseCase(autoReplyRepository));
    }
}
