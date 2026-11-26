package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.repository.AutoReplyRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoReplyViewModel_Factory implements Factory<AutoReplyViewModel> {
    private final Provider<AutoReplyRepository> autoReplyRepositoryProvider;

    private AutoReplyViewModel_Factory(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        this.autoReplyRepositoryProvider = autoReplyRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AutoReplyViewModel get() {
        return newInstance(this.autoReplyRepositoryProvider.get());
    }

    public static AutoReplyViewModel_Factory create(Provider<AutoReplyRepository> autoReplyRepositoryProvider) {
        return new AutoReplyViewModel_Factory(autoReplyRepositoryProvider);
    }

    public static AutoReplyViewModel newInstance(AutoReplyRepository autoReplyRepository) {
        return new AutoReplyViewModel(autoReplyRepository);
    }
}
