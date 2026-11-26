package com.example.bingwahybrid.domain.engagebot.eventhandler;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OnAlternativeEngageNumber.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/eventhandler/OnAlternativeEngageNumber;", "", "onAlternativeNumberReceived", "", "transactionId", "Ljava/util/UUID;", "alternativeNumber", "", "(Ljava/util/UUID;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnAlternativeEngageNumber {
    Object onAlternativeNumberReceived(UUID uuid, String str, Continuation<? super Unit> continuation);
}
