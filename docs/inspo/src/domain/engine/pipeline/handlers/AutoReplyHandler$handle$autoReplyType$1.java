package com.example.bingwahybrid.domain.engine.pipeline.handlers;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/bingwahybrid/domain/enums/AutoReplyType;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.handlers.AutoReplyHandler$handle$autoReplyType$1", f = "AutoReplyHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoReplyHandler$handle$autoReplyType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AutoReplyType>, Object> {
    final /* synthetic */ TransactionContext $context;
    int label;
    final /* synthetic */ AutoReplyHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoReplyHandler$handle$autoReplyType$1(AutoReplyHandler autoReplyHandler, TransactionContext transactionContext, Continuation<? super AutoReplyHandler$handle$autoReplyType$1> continuation) {
        super(2, continuation);
        this.this$0 = autoReplyHandler;
        this.$context = transactionContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoReplyHandler$handle$autoReplyType$1(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AutoReplyType> continuation) {
        return ((AutoReplyHandler$handle$autoReplyType$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                return this.this$0.determineAutoReplyType(this.$context.getTransaction());
            } catch (Exception unused) {
                return null;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
