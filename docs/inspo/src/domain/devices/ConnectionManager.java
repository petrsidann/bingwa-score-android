package com.example.bingwahybrid.domain.devices;

import com.example.bingwahybrid.domain.hybridconnect.enums.ConnectionState;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ConnectionManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0011R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/example/bingwahybrid/domain/devices/ConnectionManager;", "", "<init>", "()V", "_connectionStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lcom/example/bingwahybrid/domain/hybridconnect/enums/ConnectionState;", "connectionStates", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionStates", "()Lkotlinx/coroutines/flow/StateFlow;", "_qrConnectionState", "qrConnectionState", "getQrConnectionState", "updateConnectionState", "", "key", "state", "removeConnectionState", "updateQrConnectionState", "clearAll", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConnectionManager {
    public static final int $stable = 8;
    private final MutableStateFlow<Map<String, ConnectionState>> _connectionStates;
    private final MutableStateFlow<ConnectionState> _qrConnectionState;
    private final StateFlow<Map<String, ConnectionState>> connectionStates;
    private final StateFlow<ConnectionState> qrConnectionState;

    @Inject
    public ConnectionManager() {
        MutableStateFlow<Map<String, ConnectionState>> MutableStateFlow = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
        this._connectionStates = MutableStateFlow;
        this.connectionStates = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<ConnectionState> MutableStateFlow2 = StateFlowKt.MutableStateFlow(ConnectionState.Disconnected.INSTANCE);
        this._qrConnectionState = MutableStateFlow2;
        this.qrConnectionState = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<Map<String, ConnectionState>> getConnectionStates() {
        return this.connectionStates;
    }

    public final StateFlow<ConnectionState> getQrConnectionState() {
        return this.qrConnectionState;
    }

    public final void updateConnectionState(String key, ConnectionState state) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(state, "state");
        Map<String, ConnectionState> mutableMap = MapsKt.toMutableMap(this._connectionStates.getValue());
        mutableMap.put(key, state);
        this._connectionStates.setValue(mutableMap);
    }

    public final void removeConnectionState(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, ConnectionState> mutableMap = MapsKt.toMutableMap(this._connectionStates.getValue());
        mutableMap.remove(key);
        this._connectionStates.setValue(mutableMap);
    }

    public final void updateQrConnectionState(ConnectionState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this._qrConnectionState.setValue(state);
    }

    public final void clearAll() {
        this._connectionStates.setValue(MapsKt.emptyMap());
        this._qrConnectionState.setValue(ConnectionState.Disconnected.INSTANCE);
    }
}
