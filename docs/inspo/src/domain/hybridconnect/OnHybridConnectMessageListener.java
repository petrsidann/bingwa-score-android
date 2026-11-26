package com.example.bingwahybrid.domain.hybridconnect;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OnHybridConnectMessageListener.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/example/bingwahybrid/domain/hybridconnect/OnHybridConnectMessageListener;", "", "setOnMessageReceivedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "mpesaMessage", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnHybridConnectMessageListener {
    void setOnMessageReceivedListener(Function1<? super String, Unit> listener);
}
