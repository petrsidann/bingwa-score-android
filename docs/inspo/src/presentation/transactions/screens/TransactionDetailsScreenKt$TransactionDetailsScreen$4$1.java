package com.example.bingwahybrid.presentation.transactions.screens;

import com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionDetailsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$TransactionDetailsScreen$4$1", f = "TransactionDetailsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionDetailsScreenKt$TransactionDetailsScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $hasScheduledTransactions;
    final /* synthetic */ UUID $transactionId;
    final /* synthetic */ TransactionDetailsViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(TransactionDetailsViewModel transactionDetailsViewModel, UUID uuid, boolean z, Continuation<? super TransactionDetailsScreenKt$TransactionDetailsScreen$4$1> continuation) {
        super(2, continuation);
        this.$viewModel = transactionDetailsViewModel;
        this.$transactionId = uuid;
        this.$hasScheduledTransactions = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionDetailsScreenKt$TransactionDetailsScreen$4$1(this.$viewModel, this.$transactionId, this.$hasScheduledTransactions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionDetailsScreenKt$TransactionDetailsScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.getTransaction(this.$transactionId);
        if (this.$hasScheduledTransactions) {
            this.$viewModel.getScheduledTransactionsForTransactionId(this.$transactionId);
        }
        return Unit.INSTANCE;
    }
}
