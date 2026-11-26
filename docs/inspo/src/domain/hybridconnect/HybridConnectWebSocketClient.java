package com.example.bingwahybrid.domain.hybridconnect;

import androidx.core.app.NotificationCompat;
import com.example.bingwahybrid.domain.messaging.model.DeviceMessage;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.socket.client.Socket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: HybridConnectWebSocketClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\fJ\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u0017H&J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0005H&J\u000e\u0010\u0019\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000e¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/HybridConnectWebSocketClient;", "", Socket.EVENT_CONNECT, "", "wsUrl", "", "deviceId", "autoReconnect", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", Socket.EVENT_DISCONNECT, "", "serverId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unlinkServer", "sendMessage", "message", "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;", "(Ljava/lang/String;Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onEvent", NotificationCompat.CATEGORY_EVENT, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "offEvent", "cleanup", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface HybridConnectWebSocketClient {
    Object cleanup(Continuation<? super Unit> continuation);

    Object connect(String str, String str2, boolean z, Continuation<? super Boolean> continuation);

    Object disconnect(String str, Continuation<? super Unit> continuation);

    Object disconnectAll(Continuation<? super Unit> continuation);

    void offEvent(String event);

    void onEvent(String event, Function1<? super DeviceMessage, Unit> listener);

    Object sendMessage(String str, DeviceMessage deviceMessage, Continuation<? super Unit> continuation);

    Object unlinkServer(String str, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: HybridConnectWebSocketClient.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object connect$default(HybridConnectWebSocketClient hybridConnectWebSocketClient, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return hybridConnectWebSocketClient.connect(str, str2, z, continuation);
    }
}
