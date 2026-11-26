package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.example.bingwahybrid.data.remote.api.response.RedeemCouponResult;
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
@DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.RedeemCouponScreenKt$RedeemCouponScreen$1$1", f = "RedeemCouponScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RedeemCouponScreenKt$RedeemCouponScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<RedeemCouponResult> $redeemCouponResult$delegate;
    final /* synthetic */ MutableState<Boolean> $showSuccessDialog$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RedeemCouponScreenKt$RedeemCouponScreen$1$1(State<RedeemCouponResult> state, MutableState<Boolean> mutableState, Continuation<? super RedeemCouponScreenKt$RedeemCouponScreen$1$1> continuation) {
        super(2, continuation);
        this.$redeemCouponResult$delegate = state;
        this.$showSuccessDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RedeemCouponScreenKt$RedeemCouponScreen$1$1(this.$redeemCouponResult$delegate, this.$showSuccessDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RedeemCouponScreenKt$RedeemCouponScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableState<Boolean> mutableState = this.$showSuccessDialog$delegate;
        RedeemCouponResult redeemCouponResultRedeemCouponScreen$lambda$7 = RedeemCouponScreenKt.RedeemCouponScreen$lambda$7(this.$redeemCouponResult$delegate);
        RedeemCouponScreenKt.RedeemCouponScreen$lambda$11(mutableState, (redeemCouponResultRedeemCouponScreen$lambda$7 != null ? redeemCouponResultRedeemCouponScreen$lambda$7.getName() : null) != null);
        return Unit.INSTANCE;
    }
}
