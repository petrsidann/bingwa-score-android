package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.model.TransactionContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HandlerChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$3$1$1", f = "HandlerChain.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class HandlerChain$proceed$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TransactionContext>, Object> {
    final /* synthetic */ Ref.ObjectRef<TransactionContext> $current;
    final /* synthetic */ TransactionHandler $it;
    int label;
    final /* synthetic */ HandlerChain this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandlerChain$proceed$3$1$1(TransactionHandler transactionHandler, Ref.ObjectRef<TransactionContext> objectRef, HandlerChain handlerChain, Continuation<? super HandlerChain$proceed$3$1$1> continuation) {
        super(2, continuation);
        this.$it = transactionHandler;
        this.$current = objectRef;
        this.this$0 = handlerChain;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HandlerChain$proceed$3$1$1(this.$it, this.$current, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TransactionContext> continuation) {
        return ((HandlerChain$proceed$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objHandle = this.$it.handle(this.$current.element, this.this$0, this);
        return objHandle == coroutine_suspended ? coroutine_suspended : objHandle;
    }
}
