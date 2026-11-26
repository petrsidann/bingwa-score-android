package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.enums.ProcessingMode;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import com.example.bingwahybrid.domain.repository.SettingsRepository;
import com.example.bingwahybrid.domain.usecase.UpdateTransactionUseCase;
import com.example.bingwahybrid.domain.ussd.repository.UssdSessionManager;
import com.example.bingwahybrid.domain.ussd.repository.UssdStepsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimeoutHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/handlers/TimeoutHandler;", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "updateTransactionUseCase", "Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;", "settingsRepository", "Lcom/example/bingwahybrid/domain/repository/SettingsRepository;", "ussdStepsRepository", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;", "ussdSessionManager", "Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;", "<init>", "(Lcom/example/bingwahybrid/domain/usecase/UpdateTransactionUseCase;Lcom/example/bingwahybrid/domain/repository/SettingsRepository;Lcom/example/bingwahybrid/domain/ussd/repository/UssdStepsRepository;Lcom/example/bingwahybrid/domain/ussd/repository/UssdSessionManager;)V", "handle", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "chain", "Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TimeoutHandler implements TransactionHandler {
    public static final int $stable = 8;
    private final SettingsRepository settingsRepository;
    private final UpdateTransactionUseCase updateTransactionUseCase;
    private final UssdSessionManager ussdSessionManager;
    private final UssdStepsRepository ussdStepsRepository;

    /* JADX INFO: compiled from: TimeoutHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessingMode.values().length];
            try {
                iArr[ProcessingMode.ADVANCED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.handlers.TimeoutHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: TimeoutHandler.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.TimeoutHandler", f = "TimeoutHandler.kt", i = {0, 0, 0}, l = {34}, m = "handle", n = {"context", "chain", "updated"}, s = {"L$0", "L$1", "L$2"})
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
            return TimeoutHandler.this.handle(null, null, this);
        }
    }

    @Inject
    public TimeoutHandler(UpdateTransactionUseCase updateTransactionUseCase, SettingsRepository settingsRepository, UssdStepsRepository ussdStepsRepository, UssdSessionManager ussdSessionManager) {
        Intrinsics.checkNotNullParameter(updateTransactionUseCase, "updateTransactionUseCase");
        Intrinsics.checkNotNullParameter(settingsRepository, "settingsRepository");
        Intrinsics.checkNotNullParameter(ussdStepsRepository, "ussdStepsRepository");
        Intrinsics.checkNotNullParameter(ussdSessionManager, "ussdSessionManager");
        this.updateTransactionUseCase = updateTransactionUseCase;
        this.settingsRepository = settingsRepository;
        this.ussdStepsRepository = ussdStepsRepository;
        this.ussdSessionManager = ussdSessionManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler
    public Object handle(TransactionContext transactionContext, HandlerChain handlerChain, Continuation<? super TransactionContext> continuation) {
        AnonymousClass1 anonymousClass1;
        TransactionContext transactionContext2;
        Transaction transaction;
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Transaction transactionCopy$default = Transaction.copy$default(transactionContext.getTransaction(), null, null, 0, 0L, null, "Failed: Transaction timed out", TransactionStatus.FAILED, null, null, null, null, 0, 0, 0L, null, null, null, 130975, null);
            UpdateTransactionUseCase updateTransactionUseCase = this.updateTransactionUseCase;
            transactionContext2 = transactionContext;
            anonymousClass1.L$0 = transactionContext2;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(handlerChain);
            anonymousClass1.L$2 = transactionCopy$default;
            anonymousClass1.label = 1;
            if (updateTransactionUseCase.invoke(transactionCopy$default, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            transaction = transactionCopy$default;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Transaction transaction2 = (Transaction) anonymousClass1.L$2;
            TransactionContext transactionContext3 = (TransactionContext) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            transactionContext2 = transactionContext3;
            transaction = transaction2;
        }
        if (WhenMappings.$EnumSwitchMapping$0[this.settingsRepository.getProcessingMode().getValue().ordinal()] == 1) {
            this.ussdStepsRepository.clearSteps();
            this.ussdSessionManager.resetSession();
        }
        return TransactionContext.copy$default(transactionContext2, transaction, null, false, null, false, AutoReplyType.FAILED, 30, null);
    }
}
