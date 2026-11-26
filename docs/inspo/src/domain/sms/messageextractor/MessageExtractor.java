package com.example.bingwahybrid.domain.sms.messageextractor;

import com.example.bingwahybrid.domain.sms.model.SmsMessage;
import kotlin.Metadata;

/* JADX INFO: compiled from: MessageExtractor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/sms/messageextractor/MessageExtractor;", "", "extractDetails", "Lcom/example/bingwahybrid/domain/sms/model/SmsMessage;", "message", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageExtractor {
    SmsMessage extractDetails(String message);
}
