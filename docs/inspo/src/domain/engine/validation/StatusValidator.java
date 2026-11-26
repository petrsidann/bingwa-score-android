package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: StatusValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/StatusValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "<init>", "()V", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StatusValidator implements TransactionValidator {
    public static final int $stable = 0;

    @Inject
    public StatusValidator() {
    }

    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        if (transaction.getStatus() == TransactionStatus.SUCCESS) {
            return new ValidationResult.Failure(TransactionStatus.SUCCESS, "Transaction already completed");
        }
        return ValidationResult.Success.INSTANCE;
    }
}
