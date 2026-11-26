package com.example.bingwahybrid.presentation.hybridconnect.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.hybridconnect.viewmodel.HybridConnectViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HybridConnectScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.hybridconnect.screens.HybridConnectScreenKt$HybridConnectScreen$2$1", f = "HybridConnectScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HybridConnectScreenKt$HybridConnectScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ State<String> $successMessage$delegate;
    final /* synthetic */ HybridConnectViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HybridConnectScreenKt$HybridConnectScreen$2$1(State<String> state, CoroutineScope coroutineScope, HybridConnectViewModel hybridConnectViewModel, Continuation<? super HybridConnectScreenKt$HybridConnectScreen$2$1> continuation) {
        super(2, continuation);
        this.$successMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = hybridConnectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HybridConnectScreenKt$HybridConnectScreen$2$1(this.$successMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HybridConnectScreenKt$HybridConnectScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strHybridConnectScreen$lambda$5 = HybridConnectScreenKt.HybridConnectScreen$lambda$5(this.$successMessage$delegate);
            if (strHybridConnectScreen$lambda$5 != null) {
                CoroutineScope coroutineScope = this.$scope;
                HybridConnectViewModel hybridConnectViewModel = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strHybridConnectScreen$lambda$5);
                hybridConnectViewModel.resetSuccessMessage();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
