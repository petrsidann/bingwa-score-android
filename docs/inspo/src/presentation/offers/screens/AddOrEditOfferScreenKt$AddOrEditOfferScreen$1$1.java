package com.example.bingwahybrid.presentation.offers.screens;

import com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel;
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

/* JADX INFO: compiled from: AddOrEditOfferScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1", f = "AddOrEditOfferScreen.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
final class AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UUID $offerId;
    final /* synthetic */ OffersViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(UUID uuid, OffersViewModel offersViewModel, Continuation<? super AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1> continuation) {
        super(2, continuation);
        this.$offerId = uuid;
        this.$viewModel = offersViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1(this.$offerId, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddOrEditOfferScreenKt$AddOrEditOfferScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UUID uuid = this.$offerId;
            if (uuid != null) {
                this.label = 1;
                if (this.$viewModel.getOfferById(uuid, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
