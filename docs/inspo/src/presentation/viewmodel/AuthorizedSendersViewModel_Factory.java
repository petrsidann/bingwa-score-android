package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthorizedSendersViewModel_Factory implements Factory<AuthorizedSendersViewModel> {
    private final Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider;

    private AuthorizedSendersViewModel_Factory(Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        this.authorizedSenderRepositoryProvider = authorizedSenderRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AuthorizedSendersViewModel get() {
        return newInstance(this.authorizedSenderRepositoryProvider.get());
    }

    public static AuthorizedSendersViewModel_Factory create(Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        return new AuthorizedSendersViewModel_Factory(authorizedSenderRepositoryProvider);
    }

    public static AuthorizedSendersViewModel newInstance(AuthorizedSenderRepository authorizedSenderRepository) {
        return new AuthorizedSendersViewModel(authorizedSenderRepository);
    }
}
