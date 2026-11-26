package com.example.bingwahybrid.presentation.offers.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.presentation.offers.viewmodel.OffersViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AddOrEditOfferScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.offers.screens.AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1", f = "AddOrEditOfferScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $deleteSuccess$delegate;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ MutableState<Boolean> $showDeleteConfirmationDialog$delegate;
    final /* synthetic */ OffersViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(OffersViewModel offersViewModel, NavHostController navHostController, State<Boolean> state, MutableState<Boolean> mutableState, Continuation<? super AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1> continuation) {
        super(2, continuation);
        this.$viewModel = offersViewModel;
        this.$navController = navHostController;
        this.$deleteSuccess$delegate = state;
        this.$showDeleteConfirmationDialog$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1(this.$viewModel, this.$navController, this.$deleteSuccess$delegate, this.$showDeleteConfirmationDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddOrEditOfferScreenKt$AddOrEditOfferScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$6(this.$deleteSuccess$delegate)) {
                AddOrEditOfferScreenKt.AddOrEditOfferScreen$lambda$9(this.$showDeleteConfirmationDialog$delegate, false);
                this.$viewModel.resetDeleteSuccess();
                NavHostController navHostController = this.$navController;
                if (navHostController != null) {
                    Boxing.boxBoolean(navHostController.popBackStack());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
