package com.example.bingwahybrid.domain.di;

import com.example.bingwahybrid.domain.repository.AuthorizedSenderRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.sms.usecases.ValidateMessageUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideValidateMessageUseCaseFactory implements Factory<ValidateMessageUseCase> {
    private final Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private DomainModule_ProvideValidateMessageUseCaseFactory(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.authorizedSenderRepositoryProvider = authorizedSenderRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ValidateMessageUseCase get() {
        return provideValidateMessageUseCase(this.settingsRepositoryProvider.get(), this.authorizedSenderRepositoryProvider.get());
    }

    public static DomainModule_ProvideValidateMessageUseCaseFactory create(Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthorizedSenderRepository> authorizedSenderRepositoryProvider) {
        return new DomainModule_ProvideValidateMessageUseCaseFactory(settingsRepositoryProvider, authorizedSenderRepositoryProvider);
    }

    public static ValidateMessageUseCase provideValidateMessageUseCase(SettingsRepository settingsRepository, AuthorizedSenderRepository authorizedSenderRepository) {
        return (ValidateMessageUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideValidateMessageUseCase(settingsRepository, authorizedSenderRepository));
    }
}
