package com.example.bingwahybrid.domain.portal;

import com.example.bingwahybrid.domain.repository.AgentCommissionRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.subscriptions.repository.SubscriptionRepository;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class KpiRelay_Factory implements Factory<KpiRelay> {
    private final Provider<AgentCommissionRepository> agentCommissionRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SubscriptionRepository> subscriptionRepositoryProvider;
    private final Provider<TransactionRepository> transactionRepositoryProvider;

    private KpiRelay_Factory(Provider<TransactionRepository> transactionRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<AgentCommissionRepository> agentCommissionRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        this.transactionRepositoryProvider = transactionRepositoryProvider;
        this.subscriptionRepositoryProvider = subscriptionRepositoryProvider;
        this.agentCommissionRepositoryProvider = agentCommissionRepositoryProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public KpiRelay get() {
        return newInstance(this.transactionRepositoryProvider.get(), this.subscriptionRepositoryProvider.get(), this.agentCommissionRepositoryProvider.get(), this.settingsRepositoryProvider.get());
    }

    public static KpiRelay_Factory create(Provider<TransactionRepository> transactionRepositoryProvider, Provider<SubscriptionRepository> subscriptionRepositoryProvider, Provider<AgentCommissionRepository> agentCommissionRepositoryProvider, Provider<SettingsRepository> settingsRepositoryProvider) {
        return new KpiRelay_Factory(transactionRepositoryProvider, subscriptionRepositoryProvider, agentCommissionRepositoryProvider, settingsRepositoryProvider);
    }

    public static KpiRelay newInstance(TransactionRepository transactionRepository, SubscriptionRepository subscriptionRepository, AgentCommissionRepository agentCommissionRepository, SettingsRepository settingsRepository) {
        return new KpiRelay(transactionRepository, subscriptionRepository, agentCommissionRepository, settingsRepository);
    }
}
