package com.example.bingwahybrid.domain.portal;

import com.example.bingwahybrid.domain.socket.SocketService;
import kotlin.Metadata;

/* JADX INFO: compiled from: SocketRelay.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/portal/SocketRelay;", "", "setup", "", "socketService", "Lcom/example/bingwahybrid/domain/socket/SocketService;", "registerListeners", "unregisterListeners", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SocketRelay {
    void registerListeners();

    void setup(SocketService socketService);

    void unregisterListeners();
}
