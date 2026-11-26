package com.example.bingwahybrid.domain.socket;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.socket.client.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SocketService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H&J*\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0010\u0012\u0004\u0012\u00020\u00070\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J+\u0010\u0012\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u000fH&J@\u0010\u0016\u001a\u00020\u000726\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u0017H&J\b\u0010\u0019\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/socket/SocketService;", "", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", Socket.EVENT_CONNECT, "", Socket.EVENT_DISCONNECT, "sendMessage", NotificationCompat.CATEGORY_EVENT, "", "data", DebugKt.DEBUG_PROPERTY_VALUE_ON, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "setOnNewMessageListener", "Lkotlin/ParameterName;", "name", "message", "setOnNewSiteLinkMessageListener", "Lkotlin/Function2;", "transactionId", "cleanup", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SocketService {
    void cleanup();

    void connect();

    void disconnect();

    StateFlow<Boolean> isConnected();

    void off(String event);

    void on(String event, Function1<? super List<? extends Object>, Unit> listener);

    void sendMessage(String event, Object data);

    void setOnNewMessageListener(Function1<? super String, Unit> listener);

    void setOnNewSiteLinkMessageListener(Function2<? super String, ? super String, Unit> listener);
}
