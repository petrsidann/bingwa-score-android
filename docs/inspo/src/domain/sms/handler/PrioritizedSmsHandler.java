package com.example.bingwahybrid.domain.sms.handler;

import kotlin.Metadata;

/* JADX INFO: compiled from: PrioritizedSmsHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/handler/PrioritizedSmsHandler;", "Lcom/example/bingwahybrid/domain/sms/handler/SmsMessageHandler;", "priority", "", "getPriority", "()I", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PrioritizedSmsHandler extends SmsMessageHandler {
    int getPriority();
}
