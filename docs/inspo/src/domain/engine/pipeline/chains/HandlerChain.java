package com.example.bingwahybrid.domain.engine.pipeline.chains;

import com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler;
import com.example.bingwahybrid.domain.model.Transaction;
import com.example.bingwahybrid.domain.model.TransactionContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HandlerChain.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/example/bingwahybrid/domain/engine/pipeline/chains/HandlerChain;", "", "sequentialHandlers", "", "Lcom/example/bingwahybrid/domain/engine/pipeline/TransactionHandler;", "parallelHandlers", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "proceed", "Lcom/example/bingwahybrid/domain/model/Transaction;", "transaction", "(Lcom/example/bingwahybrid/domain/model/Transaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "context", "(Lcom/example/bingwahybrid/domain/model/TransactionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class HandlerChain {
    public static final int $stable = 8;
    private final List<TransactionHandler> parallelHandlers;
    private final List<TransactionHandler> sequentialHandlers;

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$1, reason: invalid class name */
    /* JADX INFO: compiled from: HandlerChain.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain", f = "HandlerChain.kt", i = {0, 0}, l = {16}, m = "proceed", n = {"transaction", "initialContext"}, s = {"L$0", "L$1"})
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
            return HandlerChain.this.proceed((Transaction) null, this);
        }
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$2, reason: invalid class name */
    /* JADX INFO: compiled from: HandlerChain.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain", f = "HandlerChain.kt", i = {0, 0, 0, 1, 1}, l = {23, 26}, m = "proceed", n = {"context", "current", "handler", "context", "current"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HandlerChain.this.proceed((TransactionContext) null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HandlerChain(List<? extends TransactionHandler> sequentialHandlers, List<? extends TransactionHandler> parallelHandlers) {
        Intrinsics.checkNotNullParameter(sequentialHandlers, "sequentialHandlers");
        Intrinsics.checkNotNullParameter(parallelHandlers, "parallelHandlers");
        this.sequentialHandlers = sequentialHandlers;
        this.parallelHandlers = parallelHandlers;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object proceed(Transaction transaction, Continuation<? super Transaction> continuation) {
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
            if (transaction != null) {
                TransactionContext transactionContext = new TransactionContext(transaction, null, false, null, false, null, 62, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(transaction);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(transactionContext);
                anonymousClass1.label = 1;
                objProceed = proceed(transactionContext, anonymousClass1);
                if (objProceed == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objProceed);
        TransactionContext transactionContext2 = (TransactionContext) objProceed;
        if (transactionContext2 != null) {
            return transactionContext2.getTransaction();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x006d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0092  */
    /* JADX WARN: Code duplicated, block: B:25:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x009b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, com.example.bingwahybrid.domain.model.TransactionContext] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0092 -> B:23:0x0096). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object proceed(com.example.bingwahybrid.domain.model.TransactionContext r10, kotlin.coroutines.Continuation<? super com.example.bingwahybrid.domain.model.TransactionContext> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r11
            com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$2 r0 = (com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$2 r0 = new com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L57
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r9 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r0.L$0
            com.example.bingwahybrid.domain.model.TransactionContext r10 = (com.example.bingwahybrid.domain.model.TransactionContext) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lbf
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            java.lang.Object r10 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r2 = r0.L$3
            com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler r2 = (com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler) r2
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$0
            com.example.bingwahybrid.domain.model.TransactionContext r7 = (com.example.bingwahybrid.domain.model.TransactionContext) r7
            kotlin.ResultKt.throwOnFailure(r11)
            goto L96
        L57:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            r11.element = r10
            java.util.List<com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler> r2 = r9.sequentialHandlers
            java.util.Iterator r2 = r2.iterator()
        L67:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto La0
            java.lang.Object r6 = r2.next()
            com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler r6 = (com.example.bingwahybrid.domain.engine.pipeline.TransactionHandler) r6
            T r7 = r11.element
            com.example.bingwahybrid.domain.model.TransactionContext r7 = (com.example.bingwahybrid.domain.model.TransactionContext) r7
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r8
            r0.L$1 = r11
            r0.L$2 = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$3 = r8
            r0.L$4 = r11
            r0.label = r4
            java.lang.Object r6 = r6.handle(r7, r9, r0)
            if (r6 != r1) goto L92
            goto Lbd
        L92:
            r7 = r10
            r10 = r11
            r11 = r6
            r6 = r10
        L96:
            com.example.bingwahybrid.domain.model.TransactionContext r11 = (com.example.bingwahybrid.domain.model.TransactionContext) r11
            if (r11 != 0) goto L9b
            return r5
        L9b:
            r10.element = r11
            r11 = r6
            r10 = r7
            goto L67
        La0:
            com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$3 r2 = new com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$3
            r2.<init>(r11, r5)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.L$2 = r5
            r0.L$3 = r5
            r0.L$4 = r5
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)
            if (r9 != r1) goto Lbe
        Lbd:
            return r1
        Lbe:
            r9 = r11
        Lbf:
            T r9 = r9.element
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain.proceed(com.example.bingwahybrid.domain.model.TransactionContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$3, reason: invalid class name */
    /* JADX INFO: compiled from: HandlerChain.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/example/bingwahybrid/domain/model/TransactionContext;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.bingwahybrid.domain.engine.pipeline.chains.HandlerChain$proceed$3", f = "HandlerChain.kt", i = {0}, l = {27}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends TransactionContext>>, Object> {
        final /* synthetic */ Ref.ObjectRef<TransactionContext> $current;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<TransactionContext> objectRef, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$current = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = HandlerChain.this.new AnonymousClass3(this.$current, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends TransactionContext>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<TransactionContext>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<TransactionContext>> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
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
            List list = HandlerChain.this.parallelHandlers;
            Ref.ObjectRef<TransactionContext> objectRef = this.$current;
            HandlerChain handlerChain = HandlerChain.this;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new HandlerChain$proceed$3$1$1((TransactionHandler) it.next(), objectRef, handlerChain, null), 3, null));
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            Object objAwaitAll = AwaitKt.awaitAll(arrayList, this);
            return objAwaitAll == coroutine_suspended ? coroutine_suspended : objAwaitAll;
        }
    }
}
