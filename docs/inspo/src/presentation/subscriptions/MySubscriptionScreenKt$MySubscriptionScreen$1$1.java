package com.example.bingwahybrid.presentation.subscriptions;

import com.example.bingwahybrid.presentation.subscriptions.viewmodels.SubscriptionsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MySubscriptionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.subscriptions.MySubscriptionScreenKt$MySubscriptionScreen$1$1", f = "MySubscriptionScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MySubscriptionScreenKt$MySubscriptionScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $featureCode;
    final /* synthetic */ SubscriptionsViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MySubscriptionScreenKt$MySubscriptionScreen$1$1(String str, SubscriptionsViewModel subscriptionsViewModel, Continuation<? super MySubscriptionScreenKt$MySubscriptionScreen$1$1> continuation) {
        super(2, continuation);
        this.$featureCode = str;
        this.$viewModel = subscriptionsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MySubscriptionScreenKt$MySubscriptionScreen$1$1(this.$featureCode, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MySubscriptionScreenKt$MySubscriptionScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = this.$featureCode;
        if (str != null && str.length() != 0) {
            this.$viewModel.setFeatureCode(this.$featureCode, true);
        }
        return Unit.INSTANCE;
    }
}
