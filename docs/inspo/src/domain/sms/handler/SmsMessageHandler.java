package com.example.bingwahybrid.domain.sms.handler;

import com.example.bingwahybrid.domain.sms.model.SmsContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SmsMessageHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/handler/SmsMessageHandler;", "", "canHandle", "", "context", "Lcom/example/bingwahybrid/domain/sms/model/SmsContext;", "(Lcom/example/bingwahybrid/domain/sms/model/SmsContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SmsMessageHandler {
    Object canHandle(SmsContext smsContext, Continuation<? super Boolean> continuation);

    Object handle(SmsContext smsContext, Continuation<? super Unit> continuation);
}
