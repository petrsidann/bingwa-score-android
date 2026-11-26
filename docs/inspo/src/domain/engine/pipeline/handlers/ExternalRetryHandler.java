package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.engine.utils.TransactionUtilsKt;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.enums.TransactionType;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.sms.utils.SmsUtilsKt;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.utils.TimeUtilsKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExternalRetryHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/ExternalRetryHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "rescheduleTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExternalRetryHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final RescheduleTransactionUseCase rescheduleTransactionUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.ExternalRetryHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExternalRetryHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.ExternalRetryHandler", f = "ExternalRetryHandler.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {MotionEventCompat.AXIS_GENERIC_7, MotionEventCompat.AXIS_GENERIC_16, 58, 72}, m = "handle", n = {"context", "chain", "transaction", "offer", "updated", "context", "chain", "transaction", "offer", "updated", "context", "chain", "transaction", "offer", "incrementedTransaction", "retryTime", "context", "chain", "transaction", "offer", "incrementedTransaction", "retryTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return ExternalRetryHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public ExternalRetryHandler(RescheduleTransactionUseCase rescheduleTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase) {
        Intrinsics.checkNotNullParameter(rescheduleTransactionUseCase, "rescheduleTransactionUseCase");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        this.rescheduleTransactionUseCase = rescheduleTransactionUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        AnonymousClass1 anonymousClass1;
        TransactionContext transactionContext2;
        TransactionContext transactionContext3;
        Transaction transaction;
        Transaction transaction2;
        TransactionContext transactionContext4 = transactionContext;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objInvoke$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i != 0) {
            if (i == 1) {
                Transaction transaction3 = (Transaction) anonymousClass2.L$4;
                transactionContext4 = (TransactionContext) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objInvoke$default);
                transaction2 = transaction3;
                return TransactionContext.copy$default(transactionContext4, transaction2, null, true, null, false, null, 58, null);
            }
            if (i == 2) {
                Transaction transaction4 = (Transaction) anonymousClass2.L$4;
                transactionContext4 = (TransactionContext) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objInvoke$default);
                transaction = transaction4;
                return TransactionContext.copy$default(transactionContext4, transaction, null, true, null, false, null, 58, null);
            }
            if (i == 3) {
                long j = anonymousClass2.J$0;
                TransactionContext transactionContext5 = (TransactionContext) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objInvoke$default);
                transactionContext3 = transactionContext5;
                return TransactionContext.copy$default(transactionContext3, (Transaction) objInvoke$default, null, true, null, false, null, 42, null);
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j2 = anonymousClass2.J$0;
            TransactionContext transactionContext6 = (TransactionContext) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objInvoke$default);
            transactionContext2 = transactionContext6;
            return TransactionContext.copy$default(transactionContext2, (Transaction) objInvoke$default, null, true, null, false, null, 58, null);
        }
        ResultKt.throwOnFailure(objInvoke$default);
        Transaction transaction5 = transactionContext4.getTransaction();
        Offer offer = transaction5.getOffer();
        if (offer != null && !SetsKt.setOf((Object[]) new TransactionType[]{TransactionType.AIRTIME_BALANCE_CHECK, TransactionType.SUBSCRIPTION_RENEWAL}).contains(transaction5.getType())) {
            if (TransactionUtilsKt.isNonRetriableResponse(transaction5.getResponseMessage())) {
                Transaction transactionCopy$default = Transaction.copy$default(transaction5, null, null, 0, 0L, null, null, TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 131007, null);
                UpdateTransactionUseCase updateTransactionUseCase = this.updateTransactionUseCase;
                anonymousClass2.L$0 = transactionContext4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction5);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
                anonymousClass2.L$4 = transactionCopy$default;
                anonymousClass2.label = 1;
                if (updateTransactionUseCase.invoke(transactionCopy$default, anonymousClass2) != coroutine_suspended) {
                    transaction2 = transactionCopy$default;
                    return TransactionContext.copy$default(transactionContext4, transaction2, null, true, null, false, null, 58, null);
                }
            } else if (transaction5.getExternalRetries() >= offer.getNumberOfRetries()) {
                Transaction transactionCopy$default2 = Transaction.copy$default(transaction5, null, null, 0, 0L, null, "Failed after " + transaction5.getExternalRetries() + " retries.\n" + transaction5.getResponseMessage(), TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
                UpdateTransactionUseCase updateTransactionUseCase2 = this.updateTransactionUseCase;
                anonymousClass2.L$0 = transactionContext4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction5);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
                anonymousClass2.L$4 = transactionCopy$default2;
                anonymousClass2.label = 2;
                if (updateTransactionUseCase2.invoke(transactionCopy$default2, anonymousClass2) != coroutine_suspended) {
                    transaction = transactionCopy$default2;
                    return TransactionContext.copy$default(transactionContext4, transaction, null, true, null, false, null, 58, null);
                }
            } else if (offer.getAutoRetry()) {
                Transaction transactionCopy$default3 = Transaction.copy$default(transaction5, null, null, 0, 0L, null, null, null, null, null, null, null, 0, transaction5.getExternalRetries() + 1, 0L, null, null, null, 126975, null);
                long timeAfterMinutes = TimeUtilsKt.getTimeAfterMinutes(offer.getRetryIntervalMins());
                if (SmsUtilsKt.isConnectionProblemResponse(transaction5.getResponseMessage()) && offer.getAutoRetryConnectionProblems()) {
                    RescheduleTransactionUseCase rescheduleTransactionUseCase = this.rescheduleTransactionUseCase;
                    anonymousClass2.L$0 = transactionContext4;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction5);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(transactionCopy$default3);
                    anonymousClass2.J$0 = timeAfterMinutes;
                    anonymousClass2.label = 3;
                    objInvoke$default = RescheduleTransactionUseCase.invoke$default(rescheduleTransactionUseCase, transactionCopy$default3, timeAfterMinutes, null, "Rescheduled. Initial request failed due to connection problems", false, anonymousClass2, 4, null);
                    if (objInvoke$default != coroutine_suspended) {
                        transactionContext3 = transactionContext4;
                        return TransactionContext.copy$default(transactionContext3, (Transaction) objInvoke$default, null, true, null, false, null, 42, null);
                    }
                } else {
                    RescheduleTransactionUseCase rescheduleTransactionUseCase2 = this.rescheduleTransactionUseCase;
                    anonymousClass2.L$0 = transactionContext4;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction5);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(transactionCopy$default3);
                    anonymousClass2.J$0 = timeAfterMinutes;
                    anonymousClass2.label = 4;
                    objInvoke$default = RescheduleTransactionUseCase.invoke$default(rescheduleTransactionUseCase2, transactionCopy$default3, timeAfterMinutes, null, null, false, anonymousClass2, 12, null);
                    if (objInvoke$default != coroutine_suspended) {
                        transactionContext2 = transactionContext4;
                        return TransactionContext.copy$default(transactionContext2, (Transaction) objInvoke$default, null, true, null, false, null, 58, null);
                    }
                }
            }
            return coroutine_suspended;
        }
        return transactionContext4;
    }
}
