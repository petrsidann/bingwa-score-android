package com.example.bingwahybrid.domain.utils;

import androidx.autofill.HintConstants;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"formatCurrency", "", "amount", "", "formatPhoneToTenDigits", HintConstants.AUTOFILL_HINT_PHONE, "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FormatUtilsKt {
    public static final String formatCurrency(int i) {
        String str = new DecimalFormat("#,###").format(Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String formatPhoneToTenDigits(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        return "0" + StringsKt.takeLast(phone, 9);
    }
}
