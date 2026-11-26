package com.example.bingwahybrid.domain.engine.utils;

import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"isNonRetriableResponse", "", "response", "", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TransactionUtilsKt {
    public static final boolean isNonRetriableResponse(String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return SmsUtilsKt.isOkoaJahaziFailureResponse(response) || SmsUtilsKt.isSQLResponseError(response);
    }
}
