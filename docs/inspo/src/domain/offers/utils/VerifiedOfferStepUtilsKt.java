package com.example.bingwahybrid.domain.offers.utils;

import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.VerifiedOfferStep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifiedOfferStepUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"processDynamicInput", "", "Lcom/example/bingwahybrid/domain/offers/model/VerifiedOfferStep;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VerifiedOfferStepUtilsKt {
    public static final String processDynamicInput(VerifiedOfferStep verifiedOfferStep, Transaction transaction) {
        Intrinsics.checkNotNullParameter(verifiedOfferStep, "<this>");
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        if (verifiedOfferStep.getInputKey() != null && Intrinsics.areEqual(verifiedOfferStep.getInputKey(), "BH")) {
            return transaction.getCustomer().getPhone();
        }
        return null;
    }
}
