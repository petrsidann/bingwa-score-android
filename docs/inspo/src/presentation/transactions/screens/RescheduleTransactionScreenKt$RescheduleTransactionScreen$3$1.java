package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.transactions.viewmodel.RescheduleTransactionViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RescheduleTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.transactions.screens.RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1", f = "RescheduleTransactionScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ State<String> $snackbarMessage$delegate;
    final /* synthetic */ RescheduleTransactionViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1(State<String> state, CoroutineScope coroutineScope, RescheduleTransactionViewModel rescheduleTransactionViewModel, Continuation<? super RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1> continuation) {
        super(2, continuation);
        this.$snackbarMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = rescheduleTransactionViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1(this.$snackbarMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RescheduleTransactionScreenKt$RescheduleTransactionScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strRescheduleTransactionScreen$lambda$3 = RescheduleTransactionScreenKt.RescheduleTransactionScreen$lambda$3(this.$snackbarMessage$delegate);
            if (strRescheduleTransactionScreen$lambda$3 != null) {
                CoroutineScope coroutineScope = this.$scope;
                RescheduleTransactionViewModel rescheduleTransactionViewModel = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strRescheduleTransactionScreen$lambda$3);
                rescheduleTransactionViewModel.resetSnackBarMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
