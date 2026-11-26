package com.example.bingwahybrid.domain.portal;

import com.example.bingwahybrid.domain.repository.BalanceRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.StatisticsRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class AirtimeRelay_Factory implements Factory<AirtimeRelay> {
    private final Provider<BalanceRepository> balanceRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<StatisticsRepository> statisticsRepositoryProvider;

    private AirtimeRelay_Factory(Provider<BalanceRepository> balanceRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.balanceRepositoryProvider = balanceRepositoryProvider;
        this.statisticsRepositoryProvider = statisticsRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AirtimeRelay get() {
        return newInstance(this.balanceRepositoryProvider.get(), this.statisticsRepositoryProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static AirtimeRelay_Factory create(Provider<BalanceRepository> balanceRepositoryProvider, Provider<StatisticsRepository> statisticsRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new AirtimeRelay_Factory(balanceRepositoryProvider, statisticsRepositoryProvider, settingsRepositoryProvider);
    }

    public static AirtimeRelay newInstance(BalanceRepository balanceRepository, StatisticsRepository statisticsRepository, SettingsRepository settingsRepository) {
        return new AirtimeRelay(balanceRepository, statisticsRepository, settingsRepository);
    }
}
