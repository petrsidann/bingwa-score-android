package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.presentation.viewmodel.AutoReplyViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EditAutoReplyMessageScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.screens.EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1", f = "EditAutoReplyMessageScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ State<Boolean> $updateSuccess$delegate;
    final /* synthetic */ AutoReplyViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1(NavHostController navHostController, AutoReplyViewModel autoReplyViewModel, State<Boolean> state, Continuation<? super EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$viewModel = autoReplyViewModel;
        this.$updateSuccess$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1(this.$navController, this.$viewModel, this.$updateSuccess$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditAutoReplyMessageScreenKt$EditAutoReplyMessageScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (EditAutoReplyMessageScreenKt.EditAutoReplyMessageScreen$lambda$6(this.$updateSuccess$delegate)) {
                this.$navController.popBackStack();
                this.$viewModel.resetSuccessStatus();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
