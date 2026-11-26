package com.example.bingwahybrid.presentation.offers.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.offers.dto.OfferSettingsState;
import com.example.bingwahybrid.presentation.offers.viewmodel.OfferSettingsViewModel;
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

/* JADX INFO: compiled from: OfferSettingsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.OfferSettingsScreenKt$OfferSettingsScreen$2$1", f = "OfferSettingsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OfferSettingsScreenKt$OfferSettingsScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ State<OfferSettingsState> $state$delegate;
    final /* synthetic */ OfferSettingsViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfferSettingsScreenKt$OfferSettingsScreen$2$1(CoroutineScope coroutineScope, OfferSettingsViewModel offerSettingsViewModel, State<OfferSettingsState> state, Continuation<? super OfferSettingsScreenKt$OfferSettingsScreen$2$1> continuation) {
        super(2, continuation);
        this.$scope = coroutineScope;
        this.$viewModel = offerSettingsViewModel;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfferSettingsScreenKt$OfferSettingsScreen$2$1(this.$scope, this.$viewModel, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OfferSettingsScreenKt$OfferSettingsScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (OfferSettingsScreenKt.OfferSettingsScreen$lambda$0(this.$state$delegate).getErrorMessage() != null) {
                SnackbarManager snackbarManager = SnackbarManager.INSTANCE;
                CoroutineScope coroutineScope = this.$scope;
                String errorMessage = OfferSettingsScreenKt.OfferSettingsScreen$lambda$0(this.$state$delegate).getErrorMessage();
                Intrinsics.checkNotNull(errorMessage);
                snackbarManager.showMessage(coroutineScope, errorMessage);
                this.$viewModel.clearErrorMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
