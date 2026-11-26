package com.example.bingwahybrid.presentation.community.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.community.viewmodel.CommunityOffersViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommunityOffersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.community.screens.CommunityOffersScreenKt$CommunityOffersScreen$1$1", f = "CommunityOffersScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CommunityOffersScreenKt$CommunityOffersScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ State<String> $snackBarMessage$delegate;
    final /* synthetic */ CommunityOffersViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommunityOffersScreenKt$CommunityOffersScreen$1$1(State<String> state, CoroutineScope coroutineScope, CommunityOffersViewModel communityOffersViewModel, Continuation<? super CommunityOffersScreenKt$CommunityOffersScreen$1$1> continuation) {
        super(2, continuation);
        this.$snackBarMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = communityOffersViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommunityOffersScreenKt$CommunityOffersScreen$1$1(this.$snackBarMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommunityOffersScreenKt$CommunityOffersScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strCommunityOffersScreen$lambda$3 = CommunityOffersScreenKt.CommunityOffersScreen$lambda$3(this.$snackBarMessage$delegate);
            if (strCommunityOffersScreen$lambda$3 != null) {
                CoroutineScope coroutineScope = this.$scope;
                CommunityOffersViewModel communityOffersViewModel = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strCommunityOffersScreen$lambda$3);
                communityOffersViewModel.resetSnackBarMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
