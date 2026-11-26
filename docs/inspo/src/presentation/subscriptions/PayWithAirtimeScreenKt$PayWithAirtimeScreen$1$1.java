package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionPaymentViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PayWithAirtimeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1", f = "PayWithAirtimeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $errorMessage$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SubscriptionPaymentViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1(State<String> state, CoroutineScope coroutineScope, SubscriptionPaymentViewModel subscriptionPaymentViewModel, Continuation<? super PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1> continuation) {
        super(2, continuation);
        this.$errorMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = subscriptionPaymentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1(this.$errorMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PayWithAirtimeScreenKt$PayWithAirtimeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strPayWithAirtimeScreen$lambda$1 = PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$1(this.$errorMessage$delegate);
            if (strPayWithAirtimeScreen$lambda$1 != null) {
                CoroutineScope coroutineScope = this.$scope;
                SubscriptionPaymentViewModel subscriptionPaymentViewModel = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strPayWithAirtimeScreen$lambda$1);
                subscriptionPaymentViewModel.resetSnackBarMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
