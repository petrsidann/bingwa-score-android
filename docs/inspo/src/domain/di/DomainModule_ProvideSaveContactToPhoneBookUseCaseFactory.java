package com.example.bingwahybrid.domain.di;

import android.content.Context;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.customer.SaveContactToPhoneBookUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class DomainModule_ProvideSaveContactToPhoneBookUseCaseFactory implements Factory<SaveContactToPhoneBookUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private DomainModule_ProvideSaveContactToPhoneBookUseCaseFactory(Provider<CustomerRepository> customerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<Context> contextProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SaveContactToPhoneBookUseCase get() {
        return provideSaveContactToPhoneBookUseCase(this.customerRepositoryProvider.get(), this.settingsRepositoryProvider.get(), this.contextProvider.get());
    }

    public static DomainModule_ProvideSaveContactToPhoneBookUseCaseFactory create(Provider<CustomerRepository> customerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<Context> contextProvider) {
        return new DomainModule_ProvideSaveContactToPhoneBookUseCaseFactory(customerRepositoryProvider, settingsRepositoryProvider, contextProvider);
    }

    public static SaveContactToPhoneBookUseCase provideSaveContactToPhoneBookUseCase(CustomerRepository customerRepository, SettingsRepository settingsRepository, Context context) {
        return (SaveContactToPhoneBookUseCase) Preconditions.checkNotNullFromProvides(DomainModule.INSTANCE.provideSaveContactToPhoneBookUseCase(customerRepository, settingsRepository, context));
    }
}
