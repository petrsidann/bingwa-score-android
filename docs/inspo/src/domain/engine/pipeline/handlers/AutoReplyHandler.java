package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.messaging.usecase.SendAutoReplyMessageUseCase;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AutoReplyHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/AutoReplyHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "sendAutoReplyMessageUseCase", "Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;", "<init>", "(Lcom/example/bingwahybrid/domain/messaging/usecase/SendAutoReplyMessageUseCase;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "determineAutoReplyType", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AutoReplyHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final CoroutineScope scope;
    private final SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase;

    /* JADX INFO: compiled from: AutoReplyHandler.kt */
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
                iArr[TransactionStatus.FAILED_ALREADY_RECOMMENDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TransactionStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TransactionStatus.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TransactionStatus.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TransactionStatus.UNMATCHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoReplyHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler", f = "AutoReplyHandler.kt", i = {0, 0}, l = {27}, m = "handle", n = {"context", "chain"}, s = {"L$0", "L$1"})
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
            return AutoReplyHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public AutoReplyHandler(SendAutoReplyMessageUseCase sendAutoReplyMessageUseCase) {
        Intrinsics.checkNotNullParameter(sendAutoReplyMessageUseCase, "sendAutoReplyMessageUseCase");
        this.sendAutoReplyMessageUseCase = sendAutoReplyMessageUseCase;
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0075  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        AnonymousClass1 anonymousClass1;
        AutoReplyType autoReplyType;
        TransactionContext transactionContext2;
        AutoReplyType autoReplyType2;
        TransactionContext transactionContext3 = transactionContext;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (!transactionContext3.getShouldSendAutoReply()) {
                return transactionContext3;
            }
            autoReplyType = transactionContext3.getAutoReplyType();
            if (autoReplyType == null) {
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AutoReplyHandler$handle$autoReplyType$1 autoReplyHandler$handle$autoReplyType$1 = new AutoReplyHandler$handle$autoReplyType$1(this, transactionContext3, null);
                anonymousClass1.L$0 = transactionContext3;
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io2, autoReplyHandler$handle$autoReplyType$1, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            transactionContext2 = transactionContext3;
            autoReplyType2 = autoReplyType;
            if (autoReplyType2 != null) {
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AutoReplyHandler$handle$2$1(this, transactionContext2, autoReplyType2, null), 3, null);
            }
            return TransactionContext.copy$default(transactionContext2, null, null, false, null, false, autoReplyType2, 31, null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        transactionContext3 = (TransactionContext) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objWithContext);
        autoReplyType = (AutoReplyType) objWithContext;
        transactionContext2 = transactionContext3;
        autoReplyType2 = autoReplyType;
        if (autoReplyType2 != null) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AutoReplyHandler$handle$2$1(this, transactionContext2, autoReplyType2, null), 3, null);
        }
        return TransactionContext.copy$default(transactionContext2, null, null, false, null, false, autoReplyType2, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AutoReplyType determineAutoReplyType(Transaction transaction) {
        switch (WhenMappings.$EnumSwitchMapping$0[transaction.getStatus().ordinal()]) {
            case 1:
                return AutoReplyType.SUCCESS;
            case 2:
                return AutoReplyType.ALREADY_RECOMMENDED;
            case 3:
                return AutoReplyType.FAILED;
            case 4:
                return AutoReplyType.APP_PAUSED;
            case 5:
                return AutoReplyType.CUSTOMER_BLOCKED;
            case 6:
                return AutoReplyType.OFFER_UNAVAILABLE;
            default:
                return null;
        }
    }
}
