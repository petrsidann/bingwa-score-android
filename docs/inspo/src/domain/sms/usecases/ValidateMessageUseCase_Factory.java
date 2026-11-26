package com.example.bingwahybrid.domain.sms.usecases;

import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class ValidateMessageUseCase_Factory implements Factory<ValidateMessageUseCase> {
    private final Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private ValidateMessageUseCase_Factory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.authorizedSenderRepositoryProvider = authorizedSenderRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ValidateMessageUseCase get() {
        return newInstance(this.settingsRepositoryProvider.get(), this.authorizedSenderRepositoryProvider.get());
    }

    public static ValidateMessageUseCase_Factory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        return new ValidateMessageUseCase_Factory(settingsRepositoryProvider, authorizedSenderRepositoryProvider);
    }

    public static ValidateMessageUseCase newInstance(SettingsRepository settingsRepository, AuthorizedSenderRepository authorizedSenderRepository) {
        return new ValidateMessageUseCase(settingsRepository, authorizedSenderRepository);
    }
}
