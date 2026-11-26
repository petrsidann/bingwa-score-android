package com.example.bingwahybrid.domain.engine.pipeline;

import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.BranchingHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.PreDialHandler;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.TransactionStatusClassifier;
import com.example.bingwahybrid.domain.engine.pipeline.handlers.UssdDialingHandler;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionPipeline.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionPipeline;", "", "preDialHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/PreDialHandler;", "ussdDialingHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/UssdDialingHandler;", "transactionStatusClassifier", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/TransactionStatusClassifier;", "branchingHandler", "Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/BranchingHandler;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/PreDialHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/UssdDialingHandler;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/TransactionStatusClassifier;Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/BranchingHandler;)V", "pipeline", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "execute", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transaction", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransactionPipeline {
    public static final int $stable = HandlerChain.$stable;
    private final HandlerChain pipeline;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.TransactionPipeline$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionPipeline.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.TransactionPipeline", f = "TransactionPipeline.kt", i = {0, 0}, l = {27}, m = "execute", n = {"transaction", "context"}, s = {"L$0", "L$1"})
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
            return TransactionPipeline.this.execute(null, this);
        }
    }

    @Inject
    public TransactionPipeline(PreDialHandler preDialHandler, UssdDialingHandler ussdDialingHandler, TransactionStatusClassifier transactionStatusClassifier, BranchingHandler branchingHandler) {
        Intrinsics.checkNotNullParameter(preDialHandler, "preDialHandler");
        Intrinsics.checkNotNullParameter(ussdDialingHandler, "ussdDialingHandler");
        Intrinsics.checkNotNullParameter(transactionStatusClassifier, "transactionStatusClassifier");
        Intrinsics.checkNotNullParameter(branchingHandler, "branchingHandler");
        this.pipeline = new PipelineBuilder().addSequential(preDialHandler).addSequential(ussdDialingHandler).addSequential(transactionStatusClassifier).addSequential(branchingHandler).build();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object execute(Transaction transaction, Continuation<? super Transaction> continuation) {
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
        Object objProceed = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objProceed);
            TransactionContext transactionContext = new TransactionContext(transaction, null, false, null, false, null, 62, null);
            HandlerChain handlerChain = this.pipeline;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(transactionContext);
            anonymousClass1.label = 1;
            objProceed = handlerChain.proceed(transactionContext, anonymousClass1);
            if (objProceed == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objProceed);
        }
        TransactionContext transactionContext2 = (TransactionContext) objProceed;
        if (transactionContext2 != null) {
            return transactionContext2.getTransaction();
        }
        return null;
    }
}
