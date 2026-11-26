package com.example.bingwahybrid.presentation.transactions.viewmodel;

import com.example.bingwahybrid.domain.model.Transaction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TransactionsViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "transaction", "Lcom/example/bingwahybrid/domain/model/Transaction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel$pagedTransactions$1$1$1", f = "TransactionsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionsViewModel$pagedTransactions$1$1$1 extends SuspendLambda implements Function2<Transaction, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransactionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionsViewModel$pagedTransactions$1$1$1(TransactionsViewModel transactionsViewModel, Continuation<? super TransactionsViewModel$pagedTransactions$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = transactionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransactionsViewModel$pagedTransactions$1$1$1 transactionsViewModel$pagedTransactions$1$1$1 = new TransactionsViewModel$pagedTransactions$1$1$1(this.this$0, continuation);
        transactionsViewModel$pagedTransactions$1$1$1.L$0 = obj;
        return transactionsViewModel$pagedTransactions$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Transaction transaction, Continuation<? super Boolean> continuation) {
        return ((TransactionsViewModel$pagedTransactions$1$1$1) create(transaction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Transaction transaction = (Transaction) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!this.this$0.transactionRepository.getTransactionQueue().contains(transaction));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
