package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.statistics.usecase.IncrementAgentCommissionUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AgentCommissionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AgentCommissionHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "incrementAgentCommissionUseCase", "Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementAgentCommissionUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/statistics/usecase/IncrementAgentCommissionUseCase;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AgentCommissionHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final IncrementAgentCommissionUseCase incrementAgentCommissionUseCase;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: AgentCommissionHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler", f = "AgentCommissionHandler.kt", i = {0, 0}, l = {15}, m = "handle", n = {"context", "chain"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentCommissionHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public AgentCommissionHandler(IncrementAgentCommissionUseCase incrementAgentCommissionUseCase) {
        Intrinsics.checkNotNullParameter(incrementAgentCommissionUseCase, "incrementAgentCommissionUseCase");
        this.incrementAgentCommissionUseCase = incrementAgentCommissionUseCase;
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler$handle$2, reason: invalid class name */
    /* JADX INFO: compiled from: AgentCommissionHandler.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AgentCommissionHandler$handle$2", f = "AgentCommissionHandler.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TransactionContext $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TransactionContext transactionContext, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = transactionContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AgentCommissionHandler.this.new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AgentCommissionHandler.this.incrementAgentCommissionUseCase.invoke(this.$context.getTransaction().getOffer(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            TransactionContext transactionContext2 = (TransactionContext) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            return transactionContext2;
        }
        ResultKt.throwOnFailure(obj);
        CoroutineDispatcher io2 = Dispatchers.getIO();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(transactionContext, null);
        anonymousClass1.L$0 = transactionContext;
        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
        anonymousClass1.label = 1;
        return BuildersKt.withContext(io2, anonymousClass2, anonymousClass1) == coroutine_suspended ? coroutine_suspended : transactionContext;
    }
}
