package com.example.bingwahybrid.presentation.qr.screens;

import androidx.compose.material.TextFieldImplKt;
import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: QrScannerScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$QrScannerScreen$2$1", f = "QrScannerScreen.kt", i = {}, l = {TextFieldImplKt.AnimationDuration}, m = "invokeSuspend", n = {}, s = {})
final class QrScannerScreenKt$QrScannerScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Boolean> $isConnected$delegate;
    final /* synthetic */ NavHostController $navController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QrScannerScreenKt$QrScannerScreen$2$1(NavHostController navHostController, State<Boolean> state, Continuation<? super QrScannerScreenKt$QrScannerScreen$2$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$isConnected$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrScannerScreenKt$QrScannerScreen$2$1(this.$navController, this.$isConnected$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QrScannerScreenKt$QrScannerScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (QrScannerScreenKt.QrScannerScreen$lambda$0(this.$isConnected$delegate)) {
                this.label = 1;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$navController.popBackStack();
        return Unit.INSTANCE;
    }
}
