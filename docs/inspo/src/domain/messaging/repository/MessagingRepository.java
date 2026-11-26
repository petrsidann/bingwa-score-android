package com.example.bingwahybrid.domain.messaging.repository;

import com.example.bingwahybrid.domain.messaging.model.DeviceMessage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MessagingRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/messaging/repository/MessagingRepository;", "", "sendMessageToDevice", "", "token", "", "message", "Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;", "(Ljava/lang/String;Lcom/example/bingwahybrid/domain/messaging/model/DeviceMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessagingRepository {
    Object sendMessageToDevice(String str, DeviceMessage deviceMessage, Continuation<? super Unit> continuation);
}
