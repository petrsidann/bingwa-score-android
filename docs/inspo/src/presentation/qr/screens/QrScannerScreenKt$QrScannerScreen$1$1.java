package com.example.bingwahybrid.presentation.qr.screens;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import androidx.core.content.ContextCompat;
import com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: QrScannerScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$QrScannerScreen$1$1", f = "QrScannerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class QrScannerScreenKt$QrScannerScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $cameraPermissionLauncher;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<Boolean> $hasCameraPermission$delegate;
    final /* synthetic */ QrScannerViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QrScannerScreenKt$QrScannerScreen$1$1(QrScannerViewModel qrScannerViewModel, Context context, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, MutableState<Boolean> mutableState, Continuation<? super QrScannerScreenKt$QrScannerScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = qrScannerViewModel;
        this.$context = context;
        this.$cameraPermissionLauncher = managedActivityResultLauncher;
        this.$hasCameraPermission$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrScannerScreenKt$QrScannerScreen$1$1(this.$viewModel, this.$context, this.$cameraPermissionLauncher, this.$hasCameraPermission$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QrScannerScreenKt$QrScannerScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.resetConnectionState();
        QrScannerScreenKt.QrScannerScreen$lambda$5(this.$hasCameraPermission$delegate, ContextCompat.checkSelfPermission(this.$context, "android.permission.CAMERA") == 0);
        if (!QrScannerScreenKt.QrScannerScreen$lambda$4(this.$hasCameraPermission$delegate)) {
            this.$cameraPermissionLauncher.launch("android.permission.CAMERA");
        }
        return Unit.INSTANCE;
    }
}
