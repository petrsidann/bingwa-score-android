package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RedeemCouponScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$RedeemCouponScreen$2$1", f = "RedeemCouponScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RedeemCouponScreenKt$RedeemCouponScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $error$delegate;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RedeemCouponScreenKt$RedeemCouponScreen$2$1(State<String> state, CoroutineScope coroutineScope, Continuation<? super RedeemCouponScreenKt$RedeemCouponScreen$2$1> continuation) {
        super(2, continuation);
        this.$error$delegate = state;
        this.$scope = coroutineScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RedeemCouponScreenKt$RedeemCouponScreen$2$1(this.$error$delegate, this.$scope, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RedeemCouponScreenKt$RedeemCouponScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strRedeemCouponScreen$lambda$8 = RedeemCouponScreenKt.RedeemCouponScreen$lambda$8(this.$error$delegate);
            if (strRedeemCouponScreen$lambda$8 != null) {
                SnackbarManager.INSTANCE.showMessage(this.$scope, strRedeemCouponScreen$lambda$8);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
