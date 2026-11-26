package com.example.bingwahybrid.presentation.offers.screens;

import com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel;
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

/* JADX INFO: compiled from: OfferSettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$OfferSettingsScreen$1$1", f = "OfferSettingsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfferSettingsScreenKt$OfferSettingsScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UUID $offerId;
    final /* synthetic */ OfferSettingsViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfferSettingsScreenKt$OfferSettingsScreen$1$1(OfferSettingsViewModel offerSettingsViewModel, UUID uuid, Continuation<? super OfferSettingsScreenKt$OfferSettingsScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = offerSettingsViewModel;
        this.$offerId = uuid;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfferSettingsScreenKt$OfferSettingsScreen$1$1(this.$viewModel, this.$offerId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OfferSettingsScreenKt$OfferSettingsScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.loadOffer(this.$offerId);
        return Unit.INSTANCE;
    }
}
