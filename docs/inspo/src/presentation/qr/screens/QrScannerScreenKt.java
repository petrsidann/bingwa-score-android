package com.example.bingwahybrid.presentation.qr.screens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavHostController;
import com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.common.InputImage;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QrScannerScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a)\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001a\u001a1\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u001d\u001a#\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u001f¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\"X\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\u000fX\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\"X\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u0004\u0018\u00010)X\u008a\u008e\u0002²\u0006\f\u0010*\u001a\u0004\u0018\u00010+X\u008a\u008e\u0002"}, d2 = {"QrScannerScreen", "", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/example/bingwahybrid/presentation/qr/viewmodels/QrScannerViewModel;", "(Landroidx/navigation/NavHostController;Lcom/example/bingwahybrid/presentation/qr/viewmodels/QrScannerViewModel;Landroidx/compose/runtime/Composer;II)V", "PermissionRationaleDialog", "onDismiss", "Lkotlin/Function0;", "onRequestPermission", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CameraPreview", "onQrCodeDetected", "Lkotlin/Function1;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lkotlin/jvm/functions/Function1;Landroidx/lifecycle/LifecycleOwner;Landroidx/compose/runtime/Composer;I)V", "processImageProxy", "imageProxy", "Landroidx/camera/core/ImageProxy;", "ScanningFrameOverlay", "(Landroidx/compose/runtime/Composer;I)V", "ConnectingOverlay", "message", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ErrorOverlay", "onRetry", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SuccessOverlay", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "isConnected", "", "isConnecting", "connectionError", "hasCameraPermission", "showPermissionRationale", "isProcessingQrCode", "preview", "Landroidx/camera/core/Preview;", "imageAnalysis", "Landroidx/camera/core/ImageAnalysis;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class QrScannerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraPreview$lambda$63(Function1 function1, LifecycleOwner lifecycleOwner, int i, Composer composer, int i2) {
        CameraPreview(function1, lifecycleOwner, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConnectingOverlay$lambda$77(String str, int i, Composer composer, int i2) {
        ConnectingOverlay(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorOverlay$lambda$81(String str, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ErrorOverlay(str, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionRationaleDialog$lambda$44(Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        PermissionRationaleDialog(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$41(NavHostController navHostController, QrScannerViewModel qrScannerViewModel, int i, int i2, Composer composer, int i3) {
        QrScannerScreen(navHostController, qrScannerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScanningFrameOverlay$lambda$74(int i, Composer composer, int i2) {
        ScanningFrameOverlay(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuccessOverlay$lambda$85(String str, Function0 function0, int i, Composer composer, int i2) {
        SuccessOverlay(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r20v1 java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public static final void QrScannerScreen(androidx.navigation.NavHostController r52, com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel r53, androidx.compose.runtime.Composer r54, final int r55, final int r56) {
        /*
            Method dump skipped, instruction units count: 2000
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt.QrScannerScreen(androidx.navigation.NavHostController, com.example.bingwahybrid.presentation.qr.viewmodels.QrScannerViewModel, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QrScannerScreen$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QrScannerScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean QrScannerScreen$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void QrScannerScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$11$lambda$10(MutableState mutableState, MutableState mutableState2, boolean z) {
        QrScannerScreen$lambda$5(mutableState, z);
        if (!z) {
            QrScannerScreen$lambda$8(mutableState2, true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$20$lambda$19(Context context, final QrScannerViewModel qrScannerViewModel, Uri uri) {
        if (uri != null) {
            try {
                InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                if (bitmapDecodeStream != null) {
                    InputImage inputImageFromBitmap = InputImage.fromBitmap(bitmapDecodeStream, 0);
                    Intrinsics.checkNotNullExpressionValue(inputImageFromBitmap, "fromBitmap(...)");
                    BarcodeScanner client = BarcodeScanning.getClient();
                    Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
                    Task<List<Barcode>> taskProcess = client.process(inputImageFromBitmap);
                    final Function1 function1 = new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda34
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return QrScannerScreenKt.QrScannerScreen$lambda$20$lambda$19$lambda$18$lambda$15(qrScannerViewModel, (List) obj);
                        }
                    };
                    taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda35
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            function1.invoke(obj);
                        }
                    }).addOnFailureListener(new OnFailureListener() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            QrScannerScreenKt.QrScannerScreen$lambda$20$lambda$19$lambda$18$lambda$17(qrScannerViewModel, exc);
                        }
                    });
                }
            } catch (Exception e) {
                qrScannerViewModel.setError("Failed to load image: " + e.getMessage());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$20$lambda$19$lambda$18$lambda$15(QrScannerViewModel qrScannerViewModel, List list) {
        Object next;
        String rawValue;
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Barcode) next).getFormat() != 256);
        Barcode barcode = (Barcode) next;
        if (barcode != null && (rawValue = barcode.getRawValue()) != null) {
            qrScannerViewModel.handleQrCodeScanned(rawValue);
        } else {
            qrScannerViewModel.setError("No QR code found in the selected image");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void QrScannerScreen$lambda$20$lambda$19$lambda$18$lambda$17(QrScannerViewModel qrScannerViewModel, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        qrScannerViewModel.setError("Failed to read QR code: " + e.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$24$lambda$23(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$26$lambda$25(QrScannerViewModel qrScannerViewModel, State state, State state2, State state3, String qrCodeData) {
        Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
        Log.d("QrScanner", "QR Code detected: " + qrCodeData);
        Log.d("QrScanner", "isProcessingQrCode: " + QrScannerScreen$lambda$9(state) + ", isConnecting: " + QrScannerScreen$lambda$1(state2) + ", isConnected: " + QrScannerScreen$lambda$0(state3));
        if (!QrScannerScreen$lambda$9(state) && !QrScannerScreen$lambda$0(state3)) {
            Log.d("QrScanner", "Processing QR code: " + qrCodeData + " - locking processing");
            qrScannerViewModel.handleQrCodeScanned(qrCodeData);
        } else {
            Log.d("QrScanner", "Skipping QR code - processing: " + QrScannerScreen$lambda$9(state) + ", connected: " + QrScannerScreen$lambda$0(state3));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$28$lambda$27(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("image/*");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$31$lambda$30(QrScannerViewModel qrScannerViewModel) {
        qrScannerViewModel.clearError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$33$lambda$32(QrScannerViewModel qrScannerViewModel) {
        qrScannerViewModel.clearError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$35$lambda$34(NavHostController navHostController) {
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$37$lambda$36(NavHostController navHostController, MutableState mutableState) {
        QrScannerScreen$lambda$8(mutableState, false);
        navHostController.popBackStack();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QrScannerScreen$lambda$40$lambda$39$lambda$38(ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        QrScannerScreen$lambda$8(mutableState, false);
        managedActivityResultLauncher.launch("android.permission.CAMERA");
        return Unit.INSTANCE;
    }

    private static final void PermissionRationaleDialog(final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(19915752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermissionRationaleDialog)N(onDismiss,onRequestPermission)305@12110L11,306@12173L11,307@12237L11,295@11819L122,300@11967L102,280@11286L985:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changedInstance(function0) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(19915752, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.PermissionRationaleDialog (QrScannerScreen.kt:279)");
            }
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(-1329302880, true, new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.PermissionRationaleDialog$lambda$42(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(2042496990, true, new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.PermissionRationaleDialog$lambda$43(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableSingletons$QrScannerScreenKt.INSTANCE.getLambda$1119329564$app_debug(), ComposableSingletons$QrScannerScreenKt.INSTANCE.m9530getLambda$1489737797$app_debug(), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurfaceVariant(), 0.0f, null, composer2, (i2 & 14) | 1772592, 0, 12948);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.PermissionRationaleDialog$lambda$44(function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionRationaleDialog$lambda$42(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C296@11833L98:QrScannerScreen.kt#if8x6x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1329302880, i, -1, "com.example.bingwahybrid.presentation.qr.screens.PermissionRationaleDialog.<anonymous> (QrScannerScreen.kt:296)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$QrScannerScreenKt.INSTANCE.getLambda$1348775747$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionRationaleDialog$lambda$43(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C301@11981L78:QrScannerScreen.kt#if8x6x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042496990, i, -1, "com.example.bingwahybrid.presentation.qr.screens.PermissionRationaleDialog.<anonymous> (QrScannerScreen.kt:301)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$QrScannerScreenKt.INSTANCE.getLambda$425608321$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CameraPreview(final Function1<? super String, Unit> function1, final LifecycleOwner lifecycleOwner, Composer composer, final int i) {
        int i2;
        final ListenableFuture listenableFuture;
        final MutableState mutableState;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1567571239);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CameraPreview)N(onQrCodeDetected,lifecycleOwner)316@12443L7,317@12482L55,318@12557L43,319@12626L49,322@12712L1736,321@12681L1816,369@14526L131,369@14503L154:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(lifecycleOwner) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1567571239, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.CameraPreview (QrScannerScreen.kt:315)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1097566896, "CC(remember):QrScannerScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = ProcessCameraProvider.getInstance(context);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ListenableFuture listenableFuture2 = (ListenableFuture) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Intrinsics.checkNotNull(listenableFuture2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1097569284, "CC(remember):QrScannerScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1097571498, "CC(remember):QrScannerScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1097575937, "CC(remember):QrScannerScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(listenableFuture2) | ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(lifecycleOwner);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                listenableFuture = listenableFuture2;
                mutableState = mutableState3;
                Function1 function2 = new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QrScannerScreenKt.CameraPreview$lambda$59$lambda$58(listenableFuture, lifecycleOwner, mutableState2, function1, mutableState, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function2);
                objRememberedValue4 = function2;
            } else {
                listenableFuture = listenableFuture2;
                mutableState = mutableState3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue4, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 48, 4);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1097632380, "CC(remember):QrScannerScreen.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(listenableFuture);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QrScannerScreenKt.CameraPreview$lambda$62$lambda$61(listenableFuture, mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.CameraPreview$lambda$63(function1, lifecycleOwner, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Preview CameraPreview$lambda$47(MutableState<Preview> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageAnalysis CameraPreview$lambda$50(MutableState<ImageAnalysis> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PreviewView CameraPreview$lambda$59$lambda$58(final ListenableFuture listenableFuture, final LifecycleOwner lifecycleOwner, final MutableState mutableState, final Function1 function1, final MutableState mutableState2, Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        final PreviewView previewView = new PreviewView(ctx);
        final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        listenableFuture.addListener(new Runnable() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                QrScannerScreenKt.CameraPreview$lambda$59$lambda$58$lambda$57(listenableFuture, lifecycleOwner, previewView, mutableState, executorServiceNewSingleThreadExecutor, function1, mutableState2);
            }
        }, ContextCompat.getMainExecutor(ctx));
        return previewView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void CameraPreview$lambda$59$lambda$58$lambda$57(ListenableFuture listenableFuture, LifecycleOwner lifecycleOwner, PreviewView previewView, MutableState mutableState, ExecutorService executorService, final Function1 function1, MutableState mutableState2) {
        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) listenableFuture.get();
        Preview previewBuild = new Preview.Builder().build();
        previewBuild.setSurfaceProvider(previewView.getSurfaceProvider());
        mutableState.setValue(previewBuild);
        ImageAnalysis imageAnalysisBuild = new ImageAnalysis.Builder().setBackpressureStrategy(0).build();
        imageAnalysisBuild.setAnalyzer(executorService, new ImageAnalysis.Analyzer() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.ImageAnalysis.Analyzer
            public final void analyze(ImageProxy imageProxy) {
                QrScannerScreenKt.CameraPreview$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55(function1, imageProxy);
            }
        });
        mutableState2.setValue(imageAnalysisBuild);
        CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
        try {
            processCameraProvider.unbindAll();
            Intrinsics.checkNotNull(processCameraProvider.bindToLifecycle(lifecycleOwner, DEFAULT_BACK_CAMERA, CameraPreview$lambda$47(mutableState), CameraPreview$lambda$50(mutableState2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CameraPreview$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55(final Function1 function1, ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        processImageProxy(imageProxy, new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QrScannerScreenKt.CameraPreview$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55$lambda$54(function1, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CameraPreview$lambda$59$lambda$58$lambda$57$lambda$56$lambda$55$lambda$54(final Function1 function1, final String qrCodeData) {
        Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(qrCodeData);
            }
        });
        return Unit.INSTANCE;
    }

    private static final void processImageProxy(final ImageProxy imageProxy, final Function1<? super String, Unit> function1) {
        Image image = imageProxy.getImage();
        if (image != null) {
            InputImage inputImageFromMediaImage = InputImage.fromMediaImage(image, imageProxy.getImageInfo().getRotationDegrees());
            Intrinsics.checkNotNullExpressionValue(inputImageFromMediaImage, "fromMediaImage(...)");
            BarcodeScanner client = BarcodeScanning.getClient();
            Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            Task<List<Barcode>> taskProcess = client.process(inputImageFromMediaImage);
            final Function1 function2 = new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QrScannerScreenKt.processImageProxy$lambda$66(function1, (List) obj);
                }
            };
            Intrinsics.checkNotNull(taskProcess.addOnSuccessListener(new OnSuccessListener() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda20
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function2.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda21
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "it");
                }
            }).addOnCompleteListener(new OnCompleteListener() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda23
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    QrScannerScreenKt.processImageProxy$lambda$69(imageProxy, task);
                }
            }));
            return;
        }
        imageProxy.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processImageProxy$lambda$66(Function1 function1, List list) {
        Object next;
        Intrinsics.checkNotNull(list);
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Barcode) next).getFormat() != 256);
        Barcode barcode = (Barcode) next;
        if (barcode != null) {
            Log.d("QrScanner", "ML Kit found QR code: " + barcode.getRawValue());
            String rawValue = barcode.getRawValue();
            if (rawValue != null) {
                function1.invoke(rawValue);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processImageProxy$lambda$69(ImageProxy imageProxy, Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        imageProxy.close();
    }

    private static final void ScanningFrameOverlay(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(584507696);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScanningFrameOverlay)410@15744L2944,408@15676L3012:QrScannerScreen.kt#if8x6x");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(584507696, i, -1, "com.example.bingwahybrid.presentation.qr.screens.ScanningFrameOverlay (QrScannerScreen.kt:405)");
            }
            final float fM8684constructorimpl = Dp.m8684constructorimpl(280);
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(1494763270, true, new Function3() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QrScannerScreenKt.ScanningFrameOverlay$lambda$73(fM8684constructorimpl, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3078, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.ScanningFrameOverlay$lambda$74(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScanningFrameOverlay$lambda$73(float f, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C417@15955L2727:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(BoxWithConstraints) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1494763270, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.ScanningFrameOverlay.<anonymous> (QrScannerScreen.kt:411)");
            }
            float fMo1006getMaxWidthD9Ej5fM = BoxWithConstraints.mo1006getMaxWidthD9Ej5fM();
            float f2 = 2;
            float fM8684constructorimpl = Dp.m8684constructorimpl(Dp.m8684constructorimpl(BoxWithConstraints.mo1005getMaxHeightD9Ej5fM() - f) / f2);
            float fM8684constructorimpl2 = Dp.m8684constructorimpl(Dp.m8684constructorimpl(fMo1006getMaxWidthD9Ej5fM - f) / f2);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 886830961, "C420@16042L153,427@16233L247,436@16521L250,445@16810L253,454@17103L251,467@17537L1135,463@17397L1275:QrScannerScreen.kt#if8x6x");
            BoxKt.Box(BackgroundKt.m543backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m5939copywmQWz5c$default(Color.INSTANCE.m5966getBlack0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer, 6);
            BoxKt.Box(BackgroundKt.m543backgroundbw27NRU$default(SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), 0.0f, 1, null), fM8684constructorimpl), Color.m5939copywmQWz5c$default(Color.INSTANCE.m5966getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer, 0);
            BoxKt.Box(BackgroundKt.m543backgroundbw27NRU$default(SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 1, null), fM8684constructorimpl), Color.m5939copywmQWz5c$default(Color.INSTANCE.m5966getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer, 0);
            BoxKt.Box(BackgroundKt.m543backgroundbw27NRU$default(SizeKt.m1156height3ABfNKs(SizeKt.m1175width3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), fM8684constructorimpl2), f), Color.m5939copywmQWz5c$default(Color.INSTANCE.m5966getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer, 0);
            BoxKt.Box(BackgroundKt.m543backgroundbw27NRU$default(SizeKt.m1156height3ABfNKs(SizeKt.m1175width3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterEnd()), fM8684constructorimpl2), f), Color.m5939copywmQWz5c$default(Color.INSTANCE.m5966getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composer, 0);
            Modifier modifierM1170size3ABfNKs = SizeKt.m1170size3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), f);
            ComposerKt.sourceInformationMarkerStart(composer, -248440869, "CC(remember):QrScannerScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return QrScannerScreenKt.ScanningFrameOverlay$lambda$73$lambda$72$lambda$71$lambda$70((DrawScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CanvasKt.Canvas(modifierM1170size3ABfNKs, (Function1) objRememberedValue, composer, 48);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ConnectingOverlay(final String str, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1284692167);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ConnectingOverlay)N(message)500@18855L11,497@18757L778:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1284692167, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.ConnectingOverlay (QrScannerScreen.kt:496)");
            }
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getScrim(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM543backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -765387810, "C503@18935L594:QrScannerScreen.kt#if8x6x");
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(16));
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1118padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl2 = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl2.rememberedValue(), Integer.valueOf(iHashCode2))) {
                composerM5259constructorimpl2.updateRememberedValue(Integer.valueOf(iHashCode2));
                composerM5259constructorimpl2.apply(Integer.valueOf(iHashCode2), setCompositeKeyHash2);
            }
            Updater.m5266setimpl(composerM5259constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1532986836, "C510@19255L11,508@19141L147,515@19378L10,516@19438L11,513@19302L217:QrScannerScreen.kt#if8x6x");
            ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 6, 60);
            composer2 = composerStartRestartGroup;
            TextKt.m3864TextNvy7gAk(str, null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), composer2, i2 & 14, 0, 130042);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.ConnectingOverlay$lambda$77(str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ErrorOverlay(final String str, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1339983867);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ErrorOverlay)N(message,onRetry,onDismiss)532@19755L11,529@19657L2001:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1339983867, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.ErrorOverlay (QrScannerScreen.kt:528)");
            }
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getScrim(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM543backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1878959905, "C541@20082L11,540@20023L92,543@20154L38,544@20203L1449,535@19835L1817:QrScannerScreen.kt#if8x6x");
            composer2 = composerStartRestartGroup;
            CardKt.Card(PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.9f), Dp.m8684constructorimpl(24)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(16)), CardDefaults.INSTANCE.m2692cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14), CardDefaults.INSTANCE.m2693cardElevationaqJV_2Y(Dp.m8684constructorimpl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(1214838013, true, new Function3() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QrScannerScreenKt.ErrorOverlay$lambda$80$lambda$79(str, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 196614, 16);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.ErrorOverlay$lambda$81(str, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ErrorOverlay$lambda$80$lambda$79(String str, Function0 function0, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C545@20217L1425:QrScannerScreen.kt#if8x6x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1214838013, i, -1, "com.example.bingwahybrid.presentation.qr.screens.ErrorOverlay.<anonymous>.<anonymous> (QrScannerScreen.kt:545)");
            }
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_4, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1118padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1265579793, "C552@20527L10,553@20592L11,550@20443L252,559@20797L10,560@20862L11,557@20713L309,571@21320L11,572@21394L11,570@21251L186,565@21040L588:QrScannerScreen.kt#if8x6x");
            float f = 8;
            TextKt.m3864TextNvy7gAk("Error", PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 54, 0, 131064);
            TextKt.m3864TextNvy7gAk(str, PaddingKt.m1122paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m8684constructorimpl(f), 7, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 48, 0, 130040);
            ButtonKt.Button(function0, SizeKt.m1156height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m8684constructorimpl(48)), false, null, ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimary(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableSingletons$QrScannerScreenKt.INSTANCE.getLambda$359689059$app_debug(), composer, 805306416, 492);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SuccessOverlay(final String str, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(870535412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SuccessOverlay)N(message,onDismiss)593@21855L11,590@21757L1105:QrScannerScreen.kt#if8x6x");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(870535412, i2, -1, "com.example.bingwahybrid.presentation.qr.screens.SuccessOverlay (QrScannerScreen.kt:589)");
            }
            Modifier modifierM543backgroundbw27NRU$default = BackgroundKt.m543backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getScrim(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM543backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1681756944, "C602@22182L11,601@22123L92,604@22254L38,605@22303L553,596@21935L921:QrScannerScreen.kt#if8x6x");
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.9f), Dp.m8684constructorimpl(24));
            RoundedCornerShape roundedCornerShapeM1483RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(16));
            CardColors cardColorsM2692cardColorsro_MJ88 = CardDefaults.INSTANCE.m2692cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 14);
            CardElevation cardElevationM2693cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2693cardElevationaqJV_2Y(Dp.m8684constructorimpl(8), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
            composerStartRestartGroup = composerStartRestartGroup;
            CardKt.Card(modifierM1118padding3ABfNKs, roundedCornerShapeM1483RoundedCornerShape0680j_4, cardColorsM2692cardColorsro_MJ88, cardElevationM2693cardElevationaqJV_2Y, null, ComposableLambdaKt.rememberComposableLambda(-1894562324, true, new Function3() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QrScannerScreenKt.SuccessOverlay$lambda$84$lambda$83(str, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QrScannerScreenKt.SuccessOverlay$lambda$85(str, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SuccessOverlay$lambda$84$lambda$83(String str, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C606@22317L529:QrScannerScreen.kt#if8x6x");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894562324, i, -1, "com.example.bingwahybrid.presentation.qr.screens.SuccessOverlay.<anonymous>.<anonymous> (QrScannerScreen.kt:606)");
            }
            Modifier modifierM1118padding3ABfNKs = PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(24));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM977spacedBy0680j_4 = Arrangement.INSTANCE.m977spacedBy0680j_4(Dp.m8684constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM977spacedBy0680j_4, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1118padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM5259constructorimpl = Updater.m5259constructorimpl(composer);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1347413216, "C613@22627L10,614@22691L11,611@22543L289:QrScannerScreen.kt#if8x6x");
            TextKt.m3864TextNvy7gAk(str, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), null, 0L, null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, TextAlign.m8533boximpl(TextAlign.INSTANCE.m8540getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 1572864, 0, 129978);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean QrScannerScreen$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean QrScannerScreen$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String QrScannerScreen$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final boolean QrScannerScreen$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CameraPreview$lambda$62$lambda$61(final ListenableFuture listenableFuture, final MutableState mutableState, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.example.bingwahybrid.presentation.qr.screens.QrScannerScreenKt$CameraPreview$lambda$62$lambda$61$$inlined$onDispose$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ImageAnalysis imageAnalysisCameraPreview$lambda$50 = QrScannerScreenKt.CameraPreview$lambda$50(mutableState);
                if (imageAnalysisCameraPreview$lambda$50 != null) {
                    imageAnalysisCameraPreview$lambda$50.clearAnalyzer();
                }
                ((ProcessCameraProvider) listenableFuture.get()).unbindAll();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScanningFrameOverlay$lambda$73$lambda$72$lambda$71$lambda$70(DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f = Canvas.mo705toPx0680j_4(Dp.m8684constructorimpl(30));
        float f2 = Canvas.mo705toPx0680j_4(Dp.m8684constructorimpl(2));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.mo6519getSizeNHjbRc() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.mo6519getSizeNHjbRc() & 4294967295L));
        int iM6311getRoundKaPHkGw = StrokeCap.INSTANCE.m6311getRoundKaPHkGw();
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        float f3 = fIntBitsToFloat - f;
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        float f4 = fIntBitsToFloat2 - f;
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        DrawScope.m6505drawLineNGM6Ib0$default(Canvas, Color.INSTANCE.m5977getWhite0d7_KjU(), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), Offset.m5688constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)), f2, iM6311getRoundKaPHkGw, null, 0.0f, null, 0, 480, null);
        return Unit.INSTANCE;
    }
}
