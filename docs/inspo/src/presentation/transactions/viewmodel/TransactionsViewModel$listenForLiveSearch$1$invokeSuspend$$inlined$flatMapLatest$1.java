package com.example.bingwahybrid.presentation.transactions.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import com.example.bingwahybrid.domain.model.Transaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n¨\u0006\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1", f = "TransactionsViewModel.kt", i = {0, 0}, l = {189}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"})
public final class TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Transaction>>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ TransactionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation, TransactionsViewModel transactionsViewModel) {
        super(3, continuation);
        this.this$0 = transactionsViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super List<? extends Transaction>> flowCollector, String str, Continuation<? super Unit> continuation) {
        TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1 transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1 = new TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1(continuation, this.this$0);
        transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1.L$0 = flowCollector;
        transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1.L$1 = str;
        return transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Flow<List<Transaction>> flowSearchTransaction;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object obj2 = this.L$1;
            TransactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1 transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1 = this;
            String str = (String) obj2;
            if (StringsKt.isBlank(str)) {
                this.this$0._isSearching.setValue(Boxing.boxBoolean(false));
                flowSearchTransaction = FlowKt.flowOf(CollectionsKt.emptyList());
            } else {
                this.this$0._isSearching.setValue(Boxing.boxBoolean(true));
                flowSearchTransaction = this.this$0.transactionRepository.searchTransaction(str);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flowSearchTransaction, transactionsViewModel$listenForLiveSearch$1$invokeSuspend$$inlined$flatMapLatest$1) == coroutine_suspended) {
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
