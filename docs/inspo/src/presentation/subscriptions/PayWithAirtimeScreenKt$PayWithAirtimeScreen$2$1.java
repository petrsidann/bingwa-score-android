package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.enums.LoadingState;
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
@DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1", f = "PayWithAirtimeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<LoadingState> $loadingState$delegate;
    final /* synthetic */ MutableState<Boolean> $showSubscriptionSuccessDialog$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1(State<? extends LoadingState> state, MutableState<Boolean> mutableState, Continuation<? super PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1> continuation) {
        super(2, continuation);
        this.$loadingState$delegate = state;
        this.$showSubscriptionSuccessDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1(this.$loadingState$delegate, this.$showSubscriptionSuccessDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PayWithAirtimeScreenKt$PayWithAirtimeScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$3(this.$loadingState$delegate) instanceof LoadingState.Success) {
            PayWithAirtimeScreenKt.PayWithAirtimeScreen$lambda$6(this.$showSubscriptionSuccessDialog$delegate, true);
        }
        return Unit.INSTANCE;
    }
}
