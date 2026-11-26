package com.example.bingwahybrid.domain.usecase.customer.exceptions;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerAlreadySavedInPhoneBookException.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/usecase/customer/exceptions/CustomerAlreadySavedInPhoneBookException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", HintConstants.AUTOFILL_HINT_PHONE, "", "<init>", "(Ljava/lang/String;)V", "getPhone", "()Ljava/lang/String;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomerAlreadySavedInPhoneBookException extends Exception {
    public static final int $stable = 8;
    private final String phone;

    public final String getPhone() {
        return this.phone;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerAlreadySavedInPhoneBookException(String phone) {
        super("Customer with phone " + phone + " is already saved in phonebook.");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.phone = phone;
    }
}
