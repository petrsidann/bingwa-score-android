package com.example.bingwahybrid.presentation.hybridconnect.viewmodel;

import android.content.Context;
import com.example.bingwahybrid.domain.devices.ConnectionManager;
import com.example.bingwahybrid.domain.devices.repository.LinkedDevicesRepository;
import com.example.bingwahybrid.domain.hybridconnect.HybridConnectWebSocketClient;
import com.example.bingwahybrid.domain.repository.HybridConnectRepository;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.socket.SocketService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class HybridConnectViewModel_Factory implements Factory<HybridConnectViewModel> {
    private final Provider<ConnectionManager> connectionManagerProvider;
    private final Provider<Context> contextProvider;
    private final Provider<HybridConnectRepository> hybridConnectRepositoryProvider;
    private final Provider<HybridConnectWebSocketClient> hybridConnectWebSocketClientProvider;
    private final Provider<LinkedDevicesRepository> linkedDevicesRepositoryProvider;
    private final Provider<SettingsRepository> settingsRepositoryProvider;
    private final Provider<SocketService> socketServiceProvider;

    private HybridConnectViewModel_Factory(Provider<Context> contextProvider, Provider<SocketService> socketServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<HybridConnectRepository> hybridConnectRepositoryProvider, Provider<LinkedDevicesRepository> linkedDevicesRepositoryProvider, Provider<ConnectionManager> connectionManagerProvider, Provider<HybridConnectWebSocketClient> hybridConnectWebSocketClientProvider) {
        this.contextProvider = contextProvider;
        this.socketServiceProvider = socketServiceProvider;
        this.settingsRepositoryProvider = settingsRepositoryProvider;
        this.hybridConnectRepositoryProvider = hybridConnectRepositoryProvider;
        this.linkedDevicesRepositoryProvider = linkedDevicesRepositoryProvider;
        this.connectionManagerProvider = connectionManagerProvider;
        this.hybridConnectWebSocketClientProvider = hybridConnectWebSocketClientProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HybridConnectViewModel get() {
        return newInstance(this.contextProvider.get(), this.socketServiceProvider.get(), this.settingsRepositoryProvider.get(), this.hybridConnectRepositoryProvider.get(), this.linkedDevicesRepositoryProvider.get(), this.connectionManagerProvider.get(), this.hybridConnectWebSocketClientProvider.get());
    }

    public static HybridConnectViewModel_Factory create(Provider<Context> contextProvider, Provider<SocketService> socketServiceProvider, Provider<SettingsRepository> settingsRepositoryProvider, Provider<HybridConnectRepository> hybridConnectRepositoryProvider, Provider<LinkedDevicesRepository> linkedDevicesRepositoryProvider, Provider<ConnectionManager> connectionManagerProvider, Provider<HybridConnectWebSocketClient> hybridConnectWebSocketClientProvider) {
        return new HybridConnectViewModel_Factory(contextProvider, socketServiceProvider, settingsRepositoryProvider, hybridConnectRepositoryProvider, linkedDevicesRepositoryProvider, connectionManagerProvider, hybridConnectWebSocketClientProvider);
    }

    public static HybridConnectViewModel newInstance(Context context, SocketService socketService, SettingsRepository settingsRepository, HybridConnectRepository hybridConnectRepository, LinkedDevicesRepository linkedDevicesRepository, ConnectionManager connectionManager, HybridConnectWebSocketClient hybridConnectWebSocketClient) {
        return new HybridConnectViewModel(context, socketService, settingsRepository, hybridConnectRepository, linkedDevicesRepository, connectionManager, hybridConnectWebSocketClient);
    }
}
