package com.example.bingwahybrid.domain.engine.pipeline.handlers;

import androidx.core.view.MotionEventCompat;
import com.example.bingwahybrid.domain.enums.AutoReplyType;
import com.example.bingwahybrid.domain.model.TransactionContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AutoReplyHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler$handle$2$1", f = "AutoReplyHandler.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_7}, m = "invokeSuspend", n = {}, s = {})
final class AutoReplyHandler$handle$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TransactionContext $context;
    final /* synthetic */ AutoReplyType $it;
    int label;
    final /* synthetic */ AutoReplyHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoReplyHandler$handle$2$1(AutoReplyHandler autoReplyHandler, TransactionContext transactionContext, AutoReplyType autoReplyType, Continuation<? super AutoReplyHandler$handle$2$1> continuation) {
        super(2, continuation);
        this.this$0 = autoReplyHandler;
        this.$context = transactionContext;
        this.$it = autoReplyType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoReplyHandler$handle$2$1(this.this$0, this.$context, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AutoReplyHandler$handle$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.sendAutoReplyMessageUseCase.invoke(this.$context.getTransaction(), this.$it, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
