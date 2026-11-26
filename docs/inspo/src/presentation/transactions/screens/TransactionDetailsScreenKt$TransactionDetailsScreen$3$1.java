package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionDetailsViewModel;
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
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$TransactionDetailsScreen$3$1", f = "TransactionDetailsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionDetailsScreenKt$TransactionDetailsScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ State<String> $snackBarMessage$delegate;
    final /* synthetic */ TransactionDetailsViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(State<String> state, CoroutineScope coroutineScope, TransactionDetailsViewModel transactionDetailsViewModel, Continuation<? super TransactionDetailsScreenKt$TransactionDetailsScreen$3$1> continuation) {
        super(2, continuation);
        this.$snackBarMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = transactionDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionDetailsScreenKt$TransactionDetailsScreen$3$1(this.$snackBarMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionDetailsScreenKt$TransactionDetailsScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strTransactionDetailsScreen$lambda$6 = TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$6(this.$snackBarMessage$delegate);
            if (strTransactionDetailsScreen$lambda$6 != null) {
                CoroutineScope coroutineScope = this.$scope;
                TransactionDetailsViewModel transactionDetailsViewModel = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strTransactionDetailsScreen$lambda$6);
                transactionDetailsViewModel.resetSnackbarMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
