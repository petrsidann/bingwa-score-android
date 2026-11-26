package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.offers.model.Offer;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: OfferValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/OfferValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "<init>", "()V", "excludedTypes", "", "Lcom/example/bingwahybrid/domain/enums/TransactionType;", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OfferValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final Set<TransactionType> excludedTypes = SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.SUBSCRIPTION_RENEWAL, TransactionType.AIRTIME_BALANCE_CHECK});

    @Inject
    public OfferValidator() {
    }

    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        if (this.excludedTypes.contains(transaction.getType())) {
            return ValidationResult.Success.INSTANCE;
        }
        Offer offer = transaction.getOffer();
        if (offer != null && !offer.isActive()) {
            return new ValidationResult.Failure(TransactionStatus.FAILED_OFFER_DEACTIVATED, "Offer is not currently active. Please activate this offer before dialing");
        }
        return ValidationResult.Success.INSTANCE;
    }
}
