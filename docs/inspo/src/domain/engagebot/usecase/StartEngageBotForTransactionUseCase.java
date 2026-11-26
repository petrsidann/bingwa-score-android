package com.example.bingwahybrid.domain.engagebot.usecase;

import com.example.bingwahybrid.domain.engagebot.model.EngageBot;
import com.example.bingwahybrid.domain.engagebot.repository.EngageBotRepository;
import com.example.bingwahybrid.domain.engagebot.repository.EngageBotSessionRepository;
import com.example.bingwahybrid.domain.model.Transaction;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StartEngageBotForTransactionUseCase.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/usecase/StartEngageBotForTransactionUseCase;", "", "engageBotRepository", "Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotRepository;", "engageBotSessionRepository", "Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotSessionRepository;", "<init>", "(Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotRepository;Lcom/example/bingwahybrid/domain/engagebot/repository/EngageBotSessionRepository;)V", "invoke", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StartEngageBotForTransactionUseCase {
    public static final int $stable = 0;
    private final EngageBotRepository engageBotRepository;
    private final EngageBotSessionRepository engageBotSessionRepository;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engagebot.usecase.StartEngageBotForTransactionUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: StartEngageBotForTransactionUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engagebot.usecase.StartEngageBotForTransactionUseCase", f = "StartEngageBotForTransactionUseCase.kt", i = {0, 1, 1, 1}, l = {14, 25}, m = "invoke", n = {"transaction", "transaction", "engageBot", "customerId"}, s = {"L$0", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StartEngageBotForTransactionUseCase.this.invoke(null, this);
        }
    }

    @Inject
    public StartEngageBotForTransactionUseCase(EngageBotRepository engageBotRepository, EngageBotSessionRepository engageBotSessionRepository) {
        Intrinsics.checkNotNullParameter(engageBotRepository, "engageBotRepository");
        Intrinsics.checkNotNullParameter(engageBotSessionRepository, "engageBotSessionRepository");
        this.engageBotRepository = engageBotRepository;
        this.engageBotSessionRepository = engageBotSessionRepository;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
    
        if (r7.startSession(r2, r6, r0) == r1) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(Transaction transaction, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object engageBot = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(engageBot);
                EngageBotRepository engageBotRepository = this.engageBotRepository;
                anonymousClass1.L$0 = transaction;
                anonymousClass1.label = 1;
                engageBot = engageBotRepository.getEngageBot(anonymousClass1);
                if (engageBot == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                transaction = (Transaction) anonymousClass1.L$0;
                ResultKt.throwOnFailure(engageBot);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(engageBot);
            }
            z = true;
            return Boxing.boxBoolean(z);
            EngageBot engageBot2 = (EngageBot) engageBot;
            if (!engageBot2.isActive()) {
                return Boxing.boxBoolean(false);
            }
            UUID stableId = transaction.getCustomer().getStableId();
            if (stableId == null) {
                return Boxing.boxBoolean(false);
            }
            EngageBotSessionRepository engageBotSessionRepository = this.engageBotSessionRepository;
            UUID id = transaction.getId();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(engageBot2);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(stableId);
            anonymousClass1.label = 2;
        } catch (Exception unused) {
        }
    }
}
