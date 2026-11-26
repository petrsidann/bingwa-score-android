package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.domain.enums.DeleteState;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TransactionDetailsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.TransactionDetailsScreenKt$TransactionDetailsScreen$2$1", f = "TransactionDetailsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TransactionDetailsScreenKt$TransactionDetailsScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<DeleteState> $deleteState$delegate;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableState<Boolean> $showDeleteDialog$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(NavHostController navHostController, CoroutineScope coroutineScope, State<? extends DeleteState> state, MutableState<Boolean> mutableState, Continuation<? super TransactionDetailsScreenKt$TransactionDetailsScreen$2$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$scope = coroutineScope;
        this.$deleteState$delegate = state;
        this.$showDeleteDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransactionDetailsScreenKt$TransactionDetailsScreen$2$1(this.$navController, this.$scope, this.$deleteState$delegate, this.$showDeleteDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransactionDetailsScreenKt$TransactionDetailsScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$5(this.$deleteState$delegate), DeleteState.Deleted.INSTANCE)) {
            TransactionDetailsScreenKt.TransactionDetailsScreen$lambda$4(this.$showDeleteDialog$delegate, false);
            this.$navController.popBackStack();
            SnackbarManager.INSTANCE.showMessage(this.$scope, "Transaction deleted successfully");
        }
        return Unit.INSTANCE;
    }
}
