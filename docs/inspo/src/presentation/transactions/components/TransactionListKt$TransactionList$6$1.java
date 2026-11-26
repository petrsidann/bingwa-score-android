package com.example.bingwahybrid.presentation.transactions.components;

import androidx.compose.foundation.lazy.LazyListState;
import com.example.bingwahybrid.presentation.transactions.dto.TransactionSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.components.TransactionListKt$TransactionList$6$1", f = "TransactionList.kt", i = {}, l = {64, 70}, m = "invokeSuspend", n = {}, s = {})
final class TransactionListKt$TransactionList$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoScroll;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ TransactionSource $source;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionListKt$TransactionList$6$1(TransactionSource transactionSource, boolean z, LazyListState lazyListState, Continuation<? super TransactionListKt$TransactionList$6$1> continuation) {
        super(2, continuation);
        this.$source = transactionSource;
        this.$autoScroll = z;
        this.$listState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionListKt$TransactionList$6$1(this.$source, this.$autoScroll, this.$listState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionListKt$TransactionList$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (androidx.compose.foundation.lazy.LazyListState.animateScrollToItem$default(r10.$listState, 0, 0, r10, 2, null) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        if (androidx.compose.foundation.lazy.LazyListState.animateScrollToItem$default(r10.$listState, 0, 0, r10, 2, null) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TransactionSource transactionSource = this.$source;
            if (transactionSource instanceof TransactionSource.ListSource) {
                if (this.$autoScroll && !((TransactionSource.ListSource) transactionSource).getItems().isEmpty()) {
                    this.label = 1;
                }
            } else {
                if (!(transactionSource instanceof TransactionSource.PagingSource)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.$autoScroll && ((TransactionSource.PagingSource) transactionSource).getItems().getItemCount() > 0) {
                    this.label = 2;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
