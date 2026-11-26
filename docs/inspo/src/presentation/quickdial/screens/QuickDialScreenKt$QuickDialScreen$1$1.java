package com.example.bingwahybrid.presentation.quickdial.screens;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.example.bingwahybrid.presentation.quickdial.viewmodel.QuickDialViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QuickDialScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.quickdial.screens.QuickDialScreenKt$QuickDialScreen$1$1", f = "QuickDialScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class QuickDialScreenKt$QuickDialScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $dialogMessage$delegate;
    final /* synthetic */ MutableState<Boolean> $showDialog$delegate;
    final /* synthetic */ State<String> $ussdResponse$delegate;
    final /* synthetic */ QuickDialViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickDialScreenKt$QuickDialScreen$1$1(State<String> state, QuickDialViewModel quickDialViewModel, MutableState<String> mutableState, MutableState<Boolean> mutableState2, Continuation<? super QuickDialScreenKt$QuickDialScreen$1$1> continuation) {
        super(2, continuation);
        this.$ussdResponse$delegate = state;
        this.$viewModel = quickDialViewModel;
        this.$dialogMessage$delegate = mutableState;
        this.$showDialog$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QuickDialScreenKt$QuickDialScreen$1$1(this.$ussdResponse$delegate, this.$viewModel, this.$dialogMessage$delegate, this.$showDialog$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QuickDialScreenKt$QuickDialScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String strQuickDialScreen$lambda$4 = QuickDialScreenKt.QuickDialScreen$lambda$4(this.$ussdResponse$delegate);
            if (strQuickDialScreen$lambda$4 != null) {
                QuickDialViewModel quickDialViewModel = this.$viewModel;
                MutableState<String> mutableState = this.$dialogMessage$delegate;
                MutableState<Boolean> mutableState2 = this.$showDialog$delegate;
                mutableState.setValue(strQuickDialScreen$lambda$4);
                QuickDialScreenKt.QuickDialScreen$lambda$8(mutableState2, true);
                quickDialViewModel.resetUssdResponse();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
