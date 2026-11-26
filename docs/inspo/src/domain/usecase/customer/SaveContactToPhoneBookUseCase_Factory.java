package com.example.bingwahybrid.domain.usecase.customer;

import android.content.Context;
import com.example.bingwahybrid.domain.repository.CustomerRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SaveContactToPhoneBookUseCase_Factory implements Factory<SaveContactToPhoneBookUseCase> {
    private final Provider<Context> contextProvider;
    private final Provider<CustomerRepository> customerRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SaveContactToPhoneBookUseCase_Factory(Provider<CustomerRepository> customerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<Context> contextProvider) {
        this.customerRepositoryProvider = customerRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.contextProvider = contextProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SaveContactToPhoneBookUseCase get() {
        return newInstance(this.customerRepositoryProvider.get(), this.settingsRepositoryProvider.get(), this.contextProvider.get());
    }

    public static SaveContactToPhoneBookUseCase_Factory create(Provider<CustomerRepository> customerRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<Context> contextProvider) {
        return new SaveContactToPhoneBookUseCase_Factory(customerRepositoryProvider, settingsRepositoryProvider, contextProvider);
    }

    public static SaveContactToPhoneBookUseCase newInstance(CustomerRepository customerRepository, SettingsRepository settingsRepository, Context context) {
        return new SaveContactToPhoneBookUseCase(customerRepository, settingsRepository, context);
    }
}
