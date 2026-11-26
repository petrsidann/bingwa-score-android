package com.example.bingwahybrid.domain.engine;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormatUssdUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\u0002¨\u0006\n"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/FormatUssdUseCase;", "", "<init>", "()V", "invoke", "", "ussdCode", HintConstants.AUTOFILL_HINT_PHONE, "amount", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FormatUssdUseCase {
    public static final int $stable = 0;

    public static /* synthetic */ String invoke$default(FormatUssdUseCase formatUssdUseCase, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return formatUssdUseCase.invoke(str, str2, i);
    }

    public final String invoke(String ussdCode, String phone, int amount) {
        Intrinsics.checkNotNullParameter(ussdCode, "ussdCode");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return StringsKt.replace$default(StringsKt.replace$default(ussdCode, "BH", phone, false, 4, (Object) null), "AMT", String.valueOf(amount), false, 4, (Object) null);
    }
}
