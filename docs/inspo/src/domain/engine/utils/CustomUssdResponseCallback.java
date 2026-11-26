package com.example.bingwahybrid.domain.engine.utils;

import android.telephony.TelephonyManager;
import com.example.bingwahybrid.domain.model.Transaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomUssdResponseCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0094\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/utils/CustomUssdResponseCallback;", "Landroid/telephony/TelephonyManager$UssdResponseCallback;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "response", "", "onFailure", "Lkotlin/Function3;", "", "failureCode", "<init>", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "onReceiveUssdResponse", "telephonyManager", "Landroid/telephony/TelephonyManager;", "request", "", "onReceiveUssdResponseFailed", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomUssdResponseCallback extends TelephonyManager.UssdResponseCallback {
    public static final int $stable = 8;
    private final Function3<Transaction, Integer, String, Unit> onFailure;
    private final Function2<Transaction, String, Unit> onSuccess;
    private final Transaction transaction;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomUssdResponseCallback(Transaction transaction, Function2<? super Transaction, ? super String, Unit> onSuccess, Function3<? super Transaction, ? super Integer, ? super String, Unit> onFailure) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        this.transaction = transaction;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    @Override // android.telephony.TelephonyManager.UssdResponseCallback
    public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
        String string;
        Intrinsics.checkNotNullParameter(telephonyManager, "telephonyManager");
        Intrinsics.checkNotNullParameter(request, "request");
        if (response == null || (string = response.toString()) == null) {
            string = "";
        }
        String str = string;
        if (str.length() > 0 && UssdUtils.INSTANCE.isSuccessfulResponse(string)) {
            this.onSuccess.invoke(this.transaction, string);
            return;
        }
        Function3<Transaction, Integer, String, Unit> function3 = this.onFailure;
        Transaction transaction = this.transaction;
        if (str.length() == 0) {
            str = "No response received";
        }
        function3.invoke(transaction, -1, str);
    }

    @Override // android.telephony.TelephonyManager.UssdResponseCallback
    public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int failureCode) {
        Intrinsics.checkNotNullParameter(telephonyManager, "telephonyManager");
        Intrinsics.checkNotNullParameter(request, "request");
        this.onFailure.invoke(this.transaction, Integer.valueOf(failureCode), "Connection problem or invalid MMI code");
    }
}
