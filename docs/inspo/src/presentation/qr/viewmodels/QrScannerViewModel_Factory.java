package com.example.bingwahybrid.presentation.qr.viewmodels;

import com.example.bingwahybrid.domain.devices.ConnectionManager;
import com.example.bingwahybrid.domain.hybridconnect.HybridConnectWebSocketClient;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class QrScannerViewModel_Factory implements Factory<QrScannerViewModel> {
    private final Provider<ConnectionManager> connectionManagerProvider;
    private final Provider<HybridConnectWebSocketClient> webSocketClientProvider;

    private QrScannerViewModel_Factory(Provider<HybridConnectWebSocketClient> webSocketClientProvider, Provider<ConnectionManager> connectionManagerProvider) {
        this.webSocketClientProvider = webSocketClientProvider;
        this.connectionManagerProvider = connectionManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public QrScannerViewModel get() {
        return newInstance(this.webSocketClientProvider.get(), this.connectionManagerProvider.get());
    }

    public static QrScannerViewModel_Factory create(Provider<HybridConnectWebSocketClient> webSocketClientProvider, Provider<ConnectionManager> connectionManagerProvider) {
        return new QrScannerViewModel_Factory(webSocketClientProvider, connectionManagerProvider);
    }

    public static QrScannerViewModel newInstance(HybridConnectWebSocketClient webSocketClient, ConnectionManager connectionManager) {
        return new QrScannerViewModel(webSocketClient, connectionManager);
    }
}
