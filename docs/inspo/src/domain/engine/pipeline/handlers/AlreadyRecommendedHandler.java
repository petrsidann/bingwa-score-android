package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.engagebot.usecase.StartEngageBotForTransactionUseCase;
import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.offers.model.Offer;
import com.example.bingwahybrid.domain.usecase.RescheduleTransactionUseCase;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlreadyRecommendedHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AlreadyRecommendedHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "rescheduleTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "startEngageBotForTransactionUseCase", "Lcom/example/bingwahybrid/domain/engagebot/usecase/StartEngageBotForTransactionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/RescheduleTransactionUseCase;Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;Lcom/example/bingwahybrid/domain/engagebot/usecase/StartEngageBotForTransactionUseCase;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AlreadyRecommendedHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final RescheduleTransactionUseCase rescheduleTransactionUseCase;
    private final StartEngageBotForTransactionUseCase startEngageBotForTransactionUseCase;
    private final UpdateTransactionUseCase updateTransactionUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.AlreadyRecommendedHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlreadyRecommendedHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AlreadyRecommendedHandler", f = "AlreadyRecommendedHandler.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {29, 35, MotionEventCompat.AXIS_GENERIC_12, 56}, m = "handle", n = {"context", "chain", "transaction", "offer", "context", "chain", "transaction", "offer", "updatedTransaction", "engageBotActivated", "context", "chain", "transaction", "offer", "engageBotActivated", "context", "chain", "transaction", "offer", "time", "rescheduleDateTime", "engageBotActivated", "rescheduleMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlreadyRecommendedHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public AlreadyRecommendedHandler(RescheduleTransactionUseCase rescheduleTransactionUseCase, UpdateTransactionUseCase updateTransactionUseCase, StartEngageBotForTransactionUseCase startEngageBotForTransactionUseCase) {
        Intrinsics.checkNotNullParameter(rescheduleTransactionUseCase, "rescheduleTransactionUseCase");
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(startEngageBotForTransactionUseCase, "startEngageBotForTransactionUseCase");
        this.rescheduleTransactionUseCase = rescheduleTransactionUseCase;
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.startEngageBotForTransactionUseCase = startEngageBotForTransactionUseCase;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.time.ZonedDateTime] */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        AnonymousClass1 anonymousClass1;
        Offer offer;
        Transaction transaction;
        Object obj;
        HandlerChain handlerChain2;
        TransactionContext transactionContext2;
        TransactionContext transactionContext3;
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
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke$default);
            Transaction transaction3 = transactionContext4.getTransaction();
            offer = transaction3.getOffer();
            if (offer == null) {
                return transactionContext4;
            }
            StartEngageBotForTransactionUseCase startEngageBotForTransactionUseCase = this.startEngageBotForTransactionUseCase;
            anonymousClass2.L$0 = transactionContext4;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
            anonymousClass2.L$2 = transaction3;
            anonymousClass2.L$3 = offer;
            anonymousClass2.label = 1;
            Object objInvoke = startEngageBotForTransactionUseCase.invoke(transaction3, anonymousClass2);
            if (objInvoke != coroutine_suspended) {
                transaction = transaction3;
                obj = objInvoke;
                handlerChain2 = handlerChain;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2) {
                boolean z = anonymousClass2.Z$0;
                Transaction transaction4 = (Transaction) anonymousClass2.L$4;
                transactionContext4 = (TransactionContext) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objInvoke$default);
                transaction2 = transaction4;
                return TransactionContext.copy$default(transactionContext4, transaction2, null, true, null, false, null, 58, null);
            }
            if (i == 3) {
                boolean z2 = anonymousClass2.Z$0;
                TransactionContext transactionContext5 = (TransactionContext) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objInvoke$default);
                transactionContext3 = transactionContext5;
                return TransactionContext.copy$default(transactionContext3, null, null, true, null, false, null, 59, null);
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j = anonymousClass2.J$0;
            boolean z3 = anonymousClass2.Z$0;
            TransactionContext transactionContext6 = (TransactionContext) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objInvoke$default);
            transactionContext2 = transactionContext6;
            return TransactionContext.copy$default(transactionContext2, (Transaction) objInvoke$default, null, true, null, false, null, 58, null);
        }
        Offer offer2 = (Offer) anonymousClass2.L$3;
        Transaction transaction5 = (Transaction) anonymousClass2.L$2;
        handlerChain2 = (HandlerChain) anonymousClass2.L$1;
        TransactionContext transactionContext7 = (TransactionContext) anonymousClass2.L$0;
        ResultKt.throwOnFailure(objInvoke$default);
        transaction = transaction5;
        obj = objInvoke$default;
        offer = offer2;
        transactionContext4 = transactionContext7;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (zBooleanValue) {
            Transaction transactionCopy$default = Transaction.copy$default(transaction, null, null, 0, 0L, null, "EngageBot activated. Customer has already been recommended this offer today", TransactionStatus.ENGAGE_BOT_ACTIVE, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
            UpdateTransactionUseCase updateTransactionUseCase = this.updateTransactionUseCase;
            anonymousClass2.L$0 = transactionContext4;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
            anonymousClass2.L$4 = transactionCopy$default;
            anonymousClass2.Z$0 = zBooleanValue;
            anonymousClass2.label = 2;
            if (updateTransactionUseCase.invoke(transactionCopy$default, anonymousClass2) != coroutine_suspended) {
                transaction2 = transactionCopy$default;
                return TransactionContext.copy$default(transactionContext4, transaction2, null, true, null, false, null, 58, null);
            }
        } else if (!offer.getAutoReschedule()) {
            UpdateTransactionUseCase updateTransactionUseCase2 = this.updateTransactionUseCase;
            anonymousClass2.L$0 = transactionContext4;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
            anonymousClass2.Z$0 = zBooleanValue;
            anonymousClass2.label = 3;
            if (updateTransactionUseCase2.invoke(transaction, anonymousClass2) != coroutine_suspended) {
                transactionContext3 = transactionContext4;
                return TransactionContext.copy$default(transactionContext3, null, null, true, null, false, null, 59, null);
            }
        } else {
            LocalTime localTime = LocalTime.parse(offer.getAutoRescheduleRunTime(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime localDateTimeOf = LocalDateTime.of(LocalDate.now().plusDays(1L), localTime);
            long epochMilli = localDateTimeOf.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            RescheduleTransactionUseCase rescheduleTransactionUseCase = this.rescheduleTransactionUseCase;
            anonymousClass2.L$0 = transactionContext4;
            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(offer);
            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(localTime);
            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(localDateTimeOf);
            anonymousClass2.Z$0 = zBooleanValue;
            anonymousClass2.J$0 = epochMilli;
            anonymousClass2.label = 4;
            objInvoke$default = RescheduleTransactionUseCase.invoke$default(rescheduleTransactionUseCase, transaction, epochMilli, null, "Rescheduled. Customer has already been recommended this offer today", false, anonymousClass2, 4, null);
            if (objInvoke$default != coroutine_suspended) {
                transactionContext2 = transactionContext4;
                return TransactionContext.copy$default(transactionContext2, (Transaction) objInvoke$default, null, true, null, false, null, 58, null);
            }
        }
        return coroutine_suspended;
    }
}
