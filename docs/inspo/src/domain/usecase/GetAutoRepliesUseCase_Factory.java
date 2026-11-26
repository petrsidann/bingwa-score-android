package com.example.bingwahybrid.domain.usecase;

import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class GetAutoRepliesUseCase_Factory implements Factory<GetAutoRepliesUseCase> {
    private final Provider<AutoReplyRepository> autoReplyRepositoryProvider;

    private GetAutoRepliesUseCase_Factory(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        this.autoReplyRepositoryProvider = autoReplyRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetAutoRepliesUseCase get() {
        return newInstance(this.autoReplyRepositoryProvider.get());
    }

    public static GetAutoRepliesUseCase_Factory create(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        return new GetAutoRepliesUseCase_Factory(autoReplyRepositoryProvider);
    }

    public static GetAutoRepliesUseCase newInstance(AutoReplyRepository autoReplyRepository) {
        return new GetAutoRepliesUseCase(autoReplyRepository);
    }
}
