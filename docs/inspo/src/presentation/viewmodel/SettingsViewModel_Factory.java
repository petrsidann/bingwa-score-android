package com.example.bingwahybrid.presentation.viewmodel;

import android.content.Context;
import com.example.bingwahybrid.data.local.database.DatabaseInitializer;
import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.engagebot.repository.EngageBotRepository;
import com.example.bingwahybrid.domain.repository.AccessibilityRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
    private final Provider<AccessibilityRepository> accessibilityRepositoryProvider;
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DatabaseInitializer> databaseInitializerProvider;
    private final Provider<EngageBotRepository> engageBotRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;

    private SettingsViewModel_Factory(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<DatabaseInitializer> databaseInitializerProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<EngageBotRepository> engageBotRepositoryProvider) {
        this.contextProvider = contextProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.authRepositoryProvider = authRepositoryProvider;
        this.databaseInitializerProvider = databaseInitializerProvider;
        this.accessibilityRepositoryProvider = accessibilityRepositoryProvider;
        this.engageBotRepositoryProvider = engageBotRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SettingsViewModel get() {
        return newInstance(this.contextProvider.get(), this.settingsRepositoryProvider.get(), this.authRepositoryProvider.get(), this.databaseInitializerProvider.get(), this.accessibilityRepositoryProvider.get(), this.engageBotRepositoryProvider.get());
    }

    public static SettingsViewModel_Factory create(Provider<Context> contextProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<AuthRepository> authRepositoryProvider, Provider<DatabaseInitializer> databaseInitializerProvider, Provider<AccessibilityRepository> accessibilityRepositoryProvider, Provider<EngageBotRepository> engageBotRepositoryProvider) {
        return new SettingsViewModel_Factory(contextProvider, settingsRepositoryProvider, authRepositoryProvider, databaseInitializerProvider, accessibilityRepositoryProvider, engageBotRepositoryProvider);
    }

    public static SettingsViewModel newInstance(Context context, SettingsRepository settingsRepository, AuthRepository authRepository, DatabaseInitializer databaseInitializer, AccessibilityRepository accessibilityRepository, EngageBotRepository engageBotRepository) {
        return new SettingsViewModel(context, settingsRepository, authRepository, databaseInitializer, accessibilityRepository, engageBotRepository);
    }
}
