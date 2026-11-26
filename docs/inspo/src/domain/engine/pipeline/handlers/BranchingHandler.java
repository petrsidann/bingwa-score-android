package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.AlreadyRecommendedChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.ExternalRetryChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.FailureChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.InternalRetryChain;
import com.example.bingwahybrid.domain.engine.pipeline.chains.SuccessChain;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
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

/* JADX INFO: compiled from: BranchingHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/BranchingHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "successChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/SuccessChain;", "failureChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/FailureChain;", "internalRetryChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/InternalRetryChain;", "externalRetryChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/ExternalRetryChain;", "alreadyRecommendedChain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/AlreadyRecommendedChain;", "<init>", "(Lcom/example/bingwahybrid/domain/engine/pipeline/chains/SuccessChain;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/FailureChain;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/InternalRetryChain;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/ExternalRetryChain;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/AlreadyRecommendedChain;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BranchingHandler implements TransactionHandler {
    public static final int $stable = (((AlreadyRecommendedChain.$stable | ExternalRetryChain.$stable) | InternalRetryChain.$stable) | FailureChain.$stable) | SuccessChain.$stable;
    private final AlreadyRecommendedChain alreadyRecommendedChain;
    private final ExternalRetryChain externalRetryChain;
    private final FailureChain failureChain;
    private final InternalRetryChain internalRetryChain;
    private final SuccessChain successChain;

    /* JADX INFO: compiled from: BranchingHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TransactionStatus.values().length];
            try {
                iArr[TransactionStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.PENDING_AWAITING_COMMISSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.BranchingHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: BranchingHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.BranchingHandler", f = "BranchingHandler.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6}, l = {30, 34, 39, 44, 48, 52, 56}, m = "handle", n = {"context", "chain", "context", "chain", "context", "chain", "result", "context", "chain", "result", "context", "chain", "context", "chain", "context", "chain"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
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
            return BranchingHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public BranchingHandler(SuccessChain successChain, FailureChain failureChain, InternalRetryChain internalRetryChain, ExternalRetryChain externalRetryChain, AlreadyRecommendedChain alreadyRecommendedChain) {
        Intrinsics.checkNotNullParameter(successChain, "successChain");
        Intrinsics.checkNotNullParameter(failureChain, "failureChain");
        Intrinsics.checkNotNullParameter(internalRetryChain, "internalRetryChain");
        Intrinsics.checkNotNullParameter(externalRetryChain, "externalRetryChain");
        Intrinsics.checkNotNullParameter(alreadyRecommendedChain, "alreadyRecommendedChain");
        this.successChain = successChain;
        this.failureChain = failureChain;
        this.internalRetryChain = internalRetryChain;
        this.externalRetryChain = externalRetryChain;
        this.alreadyRecommendedChain = alreadyRecommendedChain;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:46:0x0107  */
    /* JADX WARN: Code duplicated, block: B:49:0x010e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0132 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        AnonymousClass1 anonymousClass1;
        TransactionContext transactionContext2;
        TransactionContext transactionContext3;
        HandlerChain handlerChain2;
        Object objProceed;
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
        Object objProceed2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure(objProceed2);
                int i = WhenMappings.$EnumSwitchMapping$0[transactionContext.getTransaction().getStatus().ordinal()];
                if (i == 1) {
                    SuccessChain successChain = this.successChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.label = 1;
                    Object objProceed3 = successChain.proceed(transactionContext, anonymousClass1);
                    if (objProceed3 != coroutine_suspended) {
                        return objProceed3;
                    }
                } else if (i == 2) {
                    InternalRetryChain internalRetryChain = this.internalRetryChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.label = 2;
                    objProceed2 = internalRetryChain.proceed(transactionContext, anonymousClass1);
                    if (objProceed2 != coroutine_suspended) {
                        transactionContext2 = (TransactionContext) objProceed2;
                        if (transactionContext2 != null && !transactionContext2.getStopPipeline()) {
                            ExternalRetryChain externalRetryChain = this.externalRetryChain;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(transactionContext2);
                            anonymousClass1.label = 3;
                            objProceed2 = externalRetryChain.proceed(transactionContext2, anonymousClass1);
                            if (objProceed2 != coroutine_suspended) {
                                HandlerChain handlerChain3 = handlerChain;
                                transactionContext3 = transactionContext;
                                handlerChain2 = handlerChain3;
                                transactionContext2 = (TransactionContext) objProceed2;
                                if (transactionContext2 != null && !transactionContext2.getStopPipeline()) {
                                    FailureChain failureChain = this.failureChain;
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext3);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(transactionContext2);
                                    anonymousClass1.label = 4;
                                    objProceed = failureChain.proceed(transactionContext2, anonymousClass1);
                                    if (objProceed == coroutine_suspended) {
                                        return objProceed;
                                    }
                                }
                            }
                        }
                        return transactionContext2;
                    }
                } else if (i == 3) {
                    AlreadyRecommendedChain alreadyRecommendedChain = this.alreadyRecommendedChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.label = 5;
                    Object objProceed4 = alreadyRecommendedChain.proceed(transactionContext, anonymousClass1);
                    if (objProceed4 != coroutine_suspended) {
                        return objProceed4;
                    }
                } else if (i == 4) {
                    SuccessChain successChain2 = this.successChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.label = 6;
                    Object objProceed5 = successChain2.proceed(transactionContext, anonymousClass1);
                    if (objProceed5 != coroutine_suspended) {
                        return objProceed5;
                    }
                } else {
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.label = 7;
                    Object objProceed6 = handlerChain.proceed(transactionContext, anonymousClass1);
                    if (objProceed6 != coroutine_suspended) {
                        return objProceed6;
                    }
                }
                return coroutine_suspended;
            case 1:
            case 5:
            case 6:
            case 7:
                ResultKt.throwOnFailure(objProceed2);
                return objProceed2;
            case 2:
                handlerChain = (HandlerChain) anonymousClass1.L$1;
                transactionContext = (TransactionContext) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objProceed2);
                transactionContext2 = (TransactionContext) objProceed2;
                if (transactionContext2 != null) {
                    ExternalRetryChain externalRetryChain2 = this.externalRetryChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(transactionContext2);
                    anonymousClass1.label = 3;
                    objProceed2 = externalRetryChain2.proceed(transactionContext2, anonymousClass1);
                    if (objProceed2 != coroutine_suspended) {
                        HandlerChain handlerChain4 = handlerChain;
                        transactionContext3 = transactionContext;
                        handlerChain2 = handlerChain4;
                        transactionContext2 = (TransactionContext) objProceed2;
                        if (transactionContext2 != null) {
                            FailureChain failureChain2 = this.failureChain;
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext3);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(transactionContext2);
                            anonymousClass1.label = 4;
                            objProceed = failureChain2.proceed(transactionContext2, anonymousClass1);
                            if (objProceed == coroutine_suspended) {
                                return objProceed;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                return transactionContext2;
            case 3:
                handlerChain2 = (HandlerChain) anonymousClass1.L$1;
                transactionContext3 = (TransactionContext) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objProceed2);
                transactionContext2 = (TransactionContext) objProceed2;
                if (transactionContext2 != null) {
                    FailureChain failureChain3 = this.failureChain;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transactionContext3);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(transactionContext2);
                    anonymousClass1.label = 4;
                    objProceed = failureChain3.proceed(transactionContext2, anonymousClass1);
                    if (objProceed == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objProceed;
                }
                return transactionContext2;
            case 4:
                ResultKt.throwOnFailure(objProceed2);
                return objProceed2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
