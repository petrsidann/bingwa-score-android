package com.example.bingwahybrid.domain.engine.validation;

import com.example.bingwahybrid.domain.engine.validation.enums.ValidationResult;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.repository.DeviceSettingsRepository;
import com.example.bingwahybrid.domain.repository.TransactionRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.utils.Responses;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoTimeValidator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/validation/AutoTimeValidator;", "Lcom/example/bingwahybrid/domain/engine/validation/TransactionValidator;", "deviceSettingsRepository", "Lcom/example/bingwahybrid/domain/repository/DeviceSettingsRepository;", "transactionRepository", "Lcom/example/bingwahybrid/domain/repository/TransactionRepository;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/repository/DeviceSettingsRepository;Lcom/example/bingwahybrid/domain/repository/TransactionRepository;Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;)V", "validate", "Lcom/example/bingwahybrid/domain/engine/validation/enums/ValidationResult;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoTimeValidator implements TransactionValidator {
    public static final int $stable = 8;
    private final DeviceSettingsRepository deviceSettingsRepository;
    private final TransactionRepository transactionRepository;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.validation.AutoTimeValidator$validate$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoTimeValidator.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.validation.AutoTimeValidator", f = "AutoTimeValidator.kt", i = {0, 0, 0, 0, 0, 0}, l = {22}, m = "validate", n = {"transaction", "$this$forEach$iv", "element$iv", "queued", "$i$f$forEach", "$i$a$-forEach-AutoTimeValidator$validate$2"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AutoTimeValidator.this.validate(null, this);
        }
    }

    @Inject
    public AutoTimeValidator(DeviceSettingsRepository deviceSettingsRepository, TransactionRepository transactionRepository, UpdateTransactionUseCase updateTransactionUseCase) {
        Intrinsics.checkNotNullParameter(deviceSettingsRepository, "deviceSettingsRepository");
        Intrinsics.checkNotNullParameter(transactionRepository, "transactionRepository");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        this.deviceSettingsRepository = deviceSettingsRepository;
        this.transactionRepository = transactionRepository;
        this.updateTransactionUseCase = updateTransactionUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.example.bingwahybrid.domain.engine.validation.TransactionValidator
    public Object validate(Transaction transaction, Continuation<? super ValidationResult> continuation) {
        AnonymousClass1 anonymousClass1;
        Iterable iterable;
        Iterator it;
        int i;
        Transaction transaction2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.deviceSettingsRepository.isAutoTimeEnabled()) {
                PriorityBlockingQueue<Transaction> transactionQueue = this.transactionRepository.getTransactionQueue();
                iterable = transactionQueue;
                it = transactionQueue.iterator();
                i = 0;
                transaction2 = transaction;
            } else {
                return ValidationResult.Success.INSTANCE;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$1;
            i = anonymousClass1.I$0;
            Object obj2 = anonymousClass1.L$3;
            it = (Iterator) anonymousClass1.L$2;
            iterable = (Iterable) anonymousClass1.L$1;
            Transaction transaction3 = (Transaction) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            transaction2 = transaction3;
        }
        while (it.hasNext()) {
            Object next = it.next();
            Transaction transaction4 = (Transaction) next;
            UpdateTransactionUseCase updateTransactionUseCase = this.updateTransactionUseCase;
            Transaction transactionCopy$default = Transaction.copy$default(transaction4, null, null, 0, 0L, null, Responses.AUTOMATIC_TIME_DISABLED, TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction2);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
            anonymousClass1.L$2 = it;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(next);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(transaction4);
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 1;
            if (updateTransactionUseCase.invoke(transactionCopy$default, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.transactionRepository.getTransactionQueue().clear();
        return new ValidationResult.Failure(TransactionStatus.FAILED, Responses.AUTOMATIC_TIME_DISABLED);
    }
}
