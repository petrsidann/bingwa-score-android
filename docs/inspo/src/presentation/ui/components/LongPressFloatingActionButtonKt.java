package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ax\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\rX\u008a\u008e\u0002²\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"LongPressFloatingActionButton", "", "onClick", "Lkotlin/Function0;", "onLongPress", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "longPressDurationMs", "", "onLongPressStart", "shouldCancel", "", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "LongPressFloatingActionButton-8r3B23s", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_debug", "isPressed", "longPressJob", "Lkotlinx/coroutines/Job;", "animationJob", "hasLongPressed"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LongPressFloatingActionButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LongPressFloatingActionButton_8r3B23s$lambda$22(Function0 function0, Function0 function1, Modifier modifier, long j, long j2, Function0 function2, boolean z, Function2 function3, int i, int i2, Composer composer, int i3) {
        m9774LongPressFloatingActionButton8r3B23s(function0, function1, modifier, j, j2, function2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0132  */
    /* JADX WARN: Code duplicated, block: B:104:0x0157  */
    /* JADX WARN: Code duplicated, block: B:107:0x017e  */
    /* JADX WARN: Code duplicated, block: B:110:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:117:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:120:0x020d  */
    /* JADX WARN: Code duplicated, block: B:121:0x021a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0240  */
    /* JADX WARN: Code duplicated, block: B:125:0x0242  */
    /* JADX WARN: Code duplicated, block: B:128:0x0253  */
    /* JADX WARN: Code duplicated, block: B:129:0x0255  */
    /* JADX WARN: Code duplicated, block: B:132:0x025e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0260  */
    /* JADX WARN: Code duplicated, block: B:136:0x0269  */
    /* JADX WARN: Code duplicated, block: B:140:0x027e  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:144:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:147:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:151:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:154:0x0367  */
    /* JADX WARN: Code duplicated, block: B:157:0x0373  */
    /* JADX WARN: Code duplicated, block: B:158:0x0377  */
    /* JADX WARN: Code duplicated, block: B:161:0x039c  */
    /* JADX WARN: Code duplicated, block: B:163:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:166:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:167:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:170:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:174:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:177:0x048c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0494  */
    /* JADX WARN: Code duplicated, block: B:182:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:184:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:187:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ff A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x0101  */
    /* JADX WARN: Code duplicated, block: B:86:0x0106  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:89:0x0112  */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0124  */
    /* JADX WARN: Code duplicated, block: B:97:0x0127  */
    /* JADX WARN: Code duplicated, block: B:98:0x012a  */
    /* JADX INFO: renamed from: LongPressFloatingActionButton-8r3B23s, reason: not valid java name */
    public static final void m9774LongPressFloatingActionButton8r3B23s(Function0<Unit> onClick, final Function0<Unit> onLongPress, Modifier modifier, long j, long j2, Function0<Unit> function0, boolean z, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        int i6;
        long j3;
        int i7;
        int i8;
        Function0<Unit> function1;
        int i9;
        int i10;
        boolean z2;
        int i11;
        boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        final Function0<Unit> function3;
        Composer composer2;
        final long j4;
        final Modifier modifier3;
        final Function0<Unit> function4;
        final long j5;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long jM5975getTransparent0d7_KjU;
        long j6;
        boolean z5;
        Object objRememberedValue;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        final MutableState mutableState;
        Object objRememberedValue3;
        MutableState mutableState2;
        Object objRememberedValue4;
        MutableState mutableState3;
        Object objRememberedValue5;
        MutableState mutableState4;
        Object objRememberedValue6;
        Animatable animatable;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        Modifier modifier4;
        String str;
        MutableState mutableState5;
        final MutableState mutableState6;
        Animatable animatable2;
        Function0<Unit> function5;
        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1;
        boolean z10;
        boolean zChangedInstance;
        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue;
        final float fM8684constructorimpl;
        final float fM8684constructorimpl2;
        final float fM8684constructorimpl3;
        final long primary;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z11;
        PointerInputEventHandler pointerInputEventHandlerRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        int i12;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onLongPress, "onLongPress");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(191068988);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LongPressFloatingActionButton)N(onClick,onLongPress,modifier,containerColor:c#ui.graphics.Color,longPressDurationMs,onLongPressStart,shouldCancel,content)47@1875L24,49@1922L34,50@1981L39,51@2045L39,52@2111L34,54@2176L27,56@2235L881,56@2209L907,86@3201L298,86@3172L327,102@3672L11,103@3696L2831:LongPressFloatingActionButton.kt#vpfmmr");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onLongPress) ? 32 : 16;
        }
        int i13 = i2 & 4;
        if (i13 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        j3 = j2;
                        if (composerStartRestartGroup.changed(j3)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function1 = function0;
                    } else {
                        function1 = function0;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(content)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            function2 = content;
                            function3 = onClick;
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            j4 = j3;
                            modifier3 = modifier2;
                            function4 = function1;
                            j5 = j;
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                            } else {
                                jM5975getTransparent0d7_KjU = j;
                            }
                            if (i6 != 0) {
                                j3 = 1500;
                            }
                            j6 = j3;
                            if (i8 != 0) {
                                function1 = null;
                            }
                            if (i10 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            coroutineScope = (CoroutineScope) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                                objRememberedValue2 = mutableStateMutableStateOf$default;
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            mutableState2 = (MutableState) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            mutableState3 = (MutableState) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                                objRememberedValue5 = mutableStateMutableStateOf$default2;
                            }
                            mutableState4 = (MutableState) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            animatable = (Animatable) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Boolean boolValueOf = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(animatable);
                            if ((i3 & 458752) == 131072) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            boolean zChangedInstance4 = z6 | zChangedInstance3 | composerStartRestartGroup.changedInstance(coroutineScope);
                            if ((i3 & 57344) == 16384) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            boolean z12 = zChangedInstance4 | z7;
                            if ((i3 & 112) == 32) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            z9 = z12 | z8;
                            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (!z9 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                modifier4 = companion;
                                str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                                mutableState5 = mutableState3;
                                mutableState6 = mutableState4;
                                animatable2 = animatable;
                                function5 = function1;
                                longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                            } else {
                                longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = objRememberedValue8;
                                modifier4 = companion;
                                mutableState5 = mutableState3;
                                str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                                mutableState6 = mutableState4;
                                animatable2 = animatable;
                                function5 = function1;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                            Boolean boolValueOf2 = Boolean.valueOf(z5);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                            if ((i3 & 3670016) == 1048576) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                boolean z13 = z5;
                                LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z13, animatable2, mutableState, mutableState5, mutableState2, null);
                                z2 = z13;
                                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1;
                                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                            } else {
                                z2 = z5;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                            final float fM8684constructorimpl4 = Dp.m8684constructorimpl(56);
                            fM8684constructorimpl = Dp.m8684constructorimpl(4);
                            fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                            float f = 2;
                            fM8684constructorimpl3 = Dp.m8684constructorimpl(f);
                            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                            Modifier modifierM1170size3ABfNKs = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl4);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            Modifier modifier5 = modifier4;
                            Function0<Unit> function6 = function5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                            composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                            }
                            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                            Modifier modifierM1170size3ABfNKs2 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl4);
                            Unit unit = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                            if ((i3 & 14) == 4) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z11 || pointerInputEventHandlerRememberedValue == Composer.INSTANCE.getEmpty()) {
                                function3 = onClick;
                                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                    @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                        final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                        final /* synthetic */ Function0<Unit> $onClick;
                                        private /* synthetic */ Object L$0;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                            super(3, continuation);
                                            this.$onClick = function0;
                                            this.$isPressed$delegate = mutableState;
                                            this.$hasLongPressed$delegate = mutableState2;
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                            return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                        }

                                        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                        public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                            anonymousClass1.L$0 = pressGestureScope;
                                            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                                this.label = 1;
                                                obj = pressGestureScope.tryAwaitRelease(this);
                                                if (obj == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                if (i != 1) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                            }
                                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                            if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                                this.$onClick.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                            } else {
                                function3 = onClick;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float f2 = 0;
                            function2 = content;
                            SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs2, unit, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f2), Dp.m8684constructorimpl(f2), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl4, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                            composer2 = composerStartRestartGroup;
                            Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                            ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                            zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                            objRememberedValue7 = composer2.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                final Animatable animatable3 = animatable2;
                                objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable3, primary, (DrawScope) obj);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            CanvasKt.Canvas(modifierMatchParentSize, (Function1) objRememberedValue7, composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            function4 = function6;
                            j5 = jM5975getTransparent0d7_KjU;
                            modifier3 = modifier5;
                        }
                        z4 = z2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Function0<Unit> function7 = function3;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function7, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z2 = z;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        function2 = content;
                        function3 = onClick;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j4 = j3;
                        modifier3 = modifier2;
                        function4 = function1;
                        j5 = j;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                        } else {
                            jM5975getTransparent0d7_KjU = j;
                        }
                        if (i6 != 0) {
                            j3 = 1500;
                        }
                        j6 = j3;
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if (i10 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default3);
                            objRememberedValue2 = mutableStateMutableStateOf$default3;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState3 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default4);
                            objRememberedValue5 = mutableStateMutableStateOf$default4;
                        }
                        mutableState4 = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        animatable = (Animatable) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Boolean boolValueOf3 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(animatable);
                        if ((i3 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        boolean zChangedInstance6 = z6 | zChangedInstance5 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if ((i3 & 57344) == 16384) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean z14 = zChangedInstance6 | z7;
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z14 | z8;
                        Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        } else {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                        Boolean boolValueOf4 = Boolean.valueOf(z5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                        if ((i3 & 3670016) == 1048576) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            boolean z15 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$2 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z15, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z15;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$2;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        } else {
                            boolean z16 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$3 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z16, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z16;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$3;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                        final float fM8684constructorimpl5 = Dp.m8684constructorimpl(56);
                        fM8684constructorimpl = Dp.m8684constructorimpl(4);
                        fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                        float f3 = 2;
                        fM8684constructorimpl3 = Dp.m8684constructorimpl(f3);
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        Modifier modifierM1170size3ABfNKs3 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl5);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        Modifier modifier6 = modifier4;
                        Function0<Unit> function8 = function5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs3);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl.getInserting()) {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        } else {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                        Modifier modifierM1170size3ABfNKs4 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl5);
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                        if ((i3 & 14) == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z11) {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        } else {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float f4 = 0;
                        function2 = content;
                        SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs4, unit2, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f3), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f4), Dp.m8684constructorimpl(f4), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl5, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierMatchParentSize2 = boxScopeInstance2.matchParentSize(Modifier.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                        zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            final Animatable animatable4 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable4, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            final Animatable animatable5 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable5, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierMatchParentSize2, (Function1) objRememberedValue7, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        function4 = function8;
                        j5 = jM5975getTransparent0d7_KjU;
                        modifier3 = modifier6;
                    }
                    z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function0 function9 = function3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function9, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                j3 = j2;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function1 = function0;
                } else {
                    function1 = function0;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        function2 = content;
                        function3 = onClick;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j4 = j3;
                        modifier3 = modifier2;
                        function4 = function1;
                        j5 = j;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                        } else {
                            jM5975getTransparent0d7_KjU = j;
                        }
                        if (i6 != 0) {
                            j3 = 1500;
                        }
                        j6 = j3;
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if (i10 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default5);
                            objRememberedValue2 = mutableStateMutableStateOf$default5;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState3 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default6);
                            objRememberedValue5 = mutableStateMutableStateOf$default6;
                        }
                        mutableState4 = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        animatable = (Animatable) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Boolean boolValueOf5 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(animatable);
                        if ((i3 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        boolean zChangedInstance8 = z6 | zChangedInstance7 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if ((i3 & 57344) == 16384) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean z17 = zChangedInstance8 | z7;
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z17 | z8;
                        Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        } else {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                        Boolean boolValueOf6 = Boolean.valueOf(z5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                        if ((i3 & 3670016) == 1048576) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            boolean z18 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$4 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z18, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z18;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$4;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        } else {
                            boolean z19 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$5 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z19, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z19;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$5;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                        final float fM8684constructorimpl6 = Dp.m8684constructorimpl(56);
                        fM8684constructorimpl = Dp.m8684constructorimpl(4);
                        fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                        float f5 = 2;
                        fM8684constructorimpl3 = Dp.m8684constructorimpl(f5);
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        Modifier modifierM1170size3ABfNKs5 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl6);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        Modifier modifier7 = modifier4;
                        Function0<Unit> function10 = function5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl.getInserting()) {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        } else {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                        Modifier modifierM1170size3ABfNKs6 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl6);
                        Unit unit3 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                        if ((i3 & 14) == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z11) {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        } else {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float f6 = 0;
                        function2 = content;
                        SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs6, unit3, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f5), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f6), Dp.m8684constructorimpl(f6), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl6, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierMatchParentSize3 = boxScopeInstance3.matchParentSize(Modifier.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                        zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            final Animatable animatable6 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable6, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            final Animatable animatable7 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable7, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierMatchParentSize3, (Function1) objRememberedValue7, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        function4 = function10;
                        j5 = jM5975getTransparent0d7_KjU;
                        modifier3 = modifier7;
                    }
                    z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function0 function11 = function3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function11, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default7);
                        objRememberedValue2 = mutableStateMutableStateOf$default7;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default8);
                        objRememberedValue5 = mutableStateMutableStateOf$default8;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf7 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance10 = z6 | zChangedInstance9 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z110 = zChangedInstance10 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z110 | z8;
                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf8 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z111 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$6 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z111;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$6;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z112 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$7 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z112, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z112;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$7;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl7 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f7 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f7);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs7 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl7);
                    Alignment center4 = Alignment.INSTANCE.getCenter();
                    Modifier modifier8 = modifier4;
                    Function0<Unit> function12 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs7);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs8 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl7);
                    Unit unit4 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f8 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs8, unit4, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f7), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f8), Dp.m8684constructorimpl(f8), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl7, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize4 = boxScopeInstance4.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable8 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable8, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable9 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable9, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize4, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function12;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier8;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function13 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function13, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    j3 = j2;
                    if (composerStartRestartGroup.changed(j3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function1 = function0;
                } else {
                    function1 = function0;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        function2 = content;
                        function3 = onClick;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j4 = j3;
                        modifier3 = modifier2;
                        function4 = function1;
                        j5 = j;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                        } else {
                            jM5975getTransparent0d7_KjU = j;
                        }
                        if (i6 != 0) {
                            j3 = 1500;
                        }
                        j6 = j3;
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if (i10 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default9);
                            objRememberedValue2 = mutableStateMutableStateOf$default9;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState3 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default10);
                            objRememberedValue5 = mutableStateMutableStateOf$default10;
                        }
                        mutableState4 = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        animatable = (Animatable) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Boolean boolValueOf9 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        boolean zChangedInstance11 = composerStartRestartGroup.changedInstance(animatable);
                        if ((i3 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        boolean zChangedInstance12 = z6 | zChangedInstance11 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if ((i3 & 57344) == 16384) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean z113 = zChangedInstance12 | z7;
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z113 | z8;
                        Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        } else {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                        Boolean boolValueOf10 = Boolean.valueOf(z5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                        if ((i3 & 3670016) == 1048576) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            boolean z114 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$8 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z114, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z114;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$8;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        } else {
                            boolean z115 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$9 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z115, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z115;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$9;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                        final float fM8684constructorimpl8 = Dp.m8684constructorimpl(56);
                        fM8684constructorimpl = Dp.m8684constructorimpl(4);
                        fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                        float f9 = 2;
                        fM8684constructorimpl3 = Dp.m8684constructorimpl(f9);
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        Modifier modifierM1170size3ABfNKs9 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl8);
                        Alignment center5 = Alignment.INSTANCE.getCenter();
                        Modifier modifier9 = modifier4;
                        Function0<Unit> function14 = function5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs9);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl.getInserting()) {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        } else {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                        Modifier modifierM1170size3ABfNKs10 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl8);
                        Unit unit5 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                        if ((i3 & 14) == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z11) {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        } else {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float f10 = 0;
                        function2 = content;
                        SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs10, unit5, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f9), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f10), Dp.m8684constructorimpl(f10), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl8, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierMatchParentSize5 = boxScopeInstance5.matchParentSize(Modifier.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                        zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            final Animatable animatable10 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable10, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            final Animatable animatable11 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable11, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierMatchParentSize5, (Function1) objRememberedValue7, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        function4 = function14;
                        j5 = jM5975getTransparent0d7_KjU;
                        modifier3 = modifier9;
                    }
                    z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function0 function15 = function3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function15, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11);
                        objRememberedValue2 = mutableStateMutableStateOf$default11;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default12);
                        objRememberedValue5 = mutableStateMutableStateOf$default12;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf11 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance13 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance14 = z6 | zChangedInstance13 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z116 = zChangedInstance14 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z116 | z8;
                    Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf12 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z117 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$10 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z117, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z117;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$10;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z118 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$11 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z118, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z118;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$11;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl9 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f11 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f11);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs11 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl9);
                    Alignment center6 = Alignment.INSTANCE.getCenter();
                    Modifier modifier10 = modifier4;
                    Function0<Unit> function16 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs11);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs12 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl9);
                    Unit unit6 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f12 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs12, unit6, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f11), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f12), Dp.m8684constructorimpl(f12), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize6 = boxScopeInstance6.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable12 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable12, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable13 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable13, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize6, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function16;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier10;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function17 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function17, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            j3 = j2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function1 = function0;
            } else {
                function1 = function0;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default13);
                        objRememberedValue2 = mutableStateMutableStateOf$default13;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default14);
                        objRememberedValue5 = mutableStateMutableStateOf$default14;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf13 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance15 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance16 = z6 | zChangedInstance15 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z119 = zChangedInstance16 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z119 | z8;
                    Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf14 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z1110 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$12 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1110, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z1110;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$12;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z1111 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$13 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1111, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z1111;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$13;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl10 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f13 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f13);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs13 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl10);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    Modifier modifier11 = modifier4;
                    Function0<Unit> function18 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs13);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs14 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl10);
                    Unit unit7 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f14 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs14, unit7, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f13), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f14), Dp.m8684constructorimpl(f14), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize7 = boxScopeInstance7.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable14 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable14, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable15 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable15, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize7, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function18;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier11;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function19 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function19, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                function2 = content;
                function3 = onClick;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j4 = j3;
                modifier3 = modifier2;
                function4 = function1;
                j5 = j;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                } else {
                    jM5975getTransparent0d7_KjU = j;
                }
                if (i6 != 0) {
                    j3 = 1500;
                }
                j6 = j3;
                if (i8 != 0) {
                    function1 = null;
                }
                if (i10 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default15);
                    objRememberedValue2 = mutableStateMutableStateOf$default15;
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState3 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default16);
                    objRememberedValue5 = mutableStateMutableStateOf$default16;
                }
                mutableState4 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                animatable = (Animatable) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Boolean boolValueOf15 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                boolean zChangedInstance17 = composerStartRestartGroup.changedInstance(animatable);
                if ((i3 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean zChangedInstance18 = z6 | zChangedInstance17 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((i3 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z1112 = zChangedInstance18 | z7;
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z1112 | z8;
                Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                } else {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                Boolean boolValueOf16 = Boolean.valueOf(z5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                if ((i3 & 3670016) == 1048576) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    boolean z1113 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$14 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1113, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z1113;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$14;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                } else {
                    boolean z1114 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$15 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1114, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z1114;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$15;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf16, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                final float fM8684constructorimpl11 = Dp.m8684constructorimpl(56);
                fM8684constructorimpl = Dp.m8684constructorimpl(4);
                fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                float f15 = 2;
                fM8684constructorimpl3 = Dp.m8684constructorimpl(f15);
                primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                Modifier modifierM1170size3ABfNKs15 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl11);
                Alignment center8 = Alignment.INSTANCE.getCenter();
                Modifier modifier12 = modifier4;
                Function0<Unit> function110 = function5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs15);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                Modifier modifierM1170size3ABfNKs16 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl11);
                Unit unit8 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                if ((i3 & 14) == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                } else {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f16 = 0;
                function2 = content;
                SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs16, unit8, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f15), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f16), Dp.m8684constructorimpl(f16), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl11, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                composer2 = composerStartRestartGroup;
                Modifier modifierMatchParentSize8 = boxScopeInstance8.matchParentSize(Modifier.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    final Animatable animatable16 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable16, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    final Animatable animatable17 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable17, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierMatchParentSize8, (Function1) objRememberedValue7, composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                function4 = function110;
                j5 = jM5975getTransparent0d7_KjU;
                modifier3 = modifier12;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function111 = function3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function111, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    j3 = j2;
                    if (composerStartRestartGroup.changed(j3)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function1 = function0;
                } else {
                    function1 = function0;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        function2 = content;
                        function3 = onClick;
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j4 = j3;
                        modifier3 = modifier2;
                        function4 = function1;
                        j5 = j;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                        } else {
                            jM5975getTransparent0d7_KjU = j;
                        }
                        if (i6 != 0) {
                            j3 = 1500;
                        }
                        j6 = j3;
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if (i10 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default17);
                            objRememberedValue2 = mutableStateMutableStateOf$default17;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        mutableState2 = (MutableState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        mutableState3 = (MutableState) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default18);
                            objRememberedValue5 = mutableStateMutableStateOf$default18;
                        }
                        mutableState4 = (MutableState) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        animatable = (Animatable) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Boolean boolValueOf17 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                        boolean zChangedInstance19 = composerStartRestartGroup.changedInstance(animatable);
                        if ((i3 & 458752) == 131072) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        boolean zChangedInstance110 = z6 | zChangedInstance19 | composerStartRestartGroup.changedInstance(coroutineScope);
                        if ((i3 & 57344) == 16384) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        boolean z1115 = zChangedInstance110 | z7;
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z1115 | z8;
                        Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (!z9) {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        } else {
                            modifier4 = companion;
                            str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                            mutableState5 = mutableState3;
                            mutableState6 = mutableState4;
                            animatable2 = animatable;
                            function5 = function1;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf17, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                        Boolean boolValueOf18 = Boolean.valueOf(z5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                        if ((i3 & 3670016) == 1048576) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            boolean z1116 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$16 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1116, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z1116;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$16;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        } else {
                            boolean z1117 = z5;
                            LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$17 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1117, animatable2, mutableState, mutableState5, mutableState2, null);
                            z2 = z1117;
                            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$17;
                            composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf18, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                        final float fM8684constructorimpl12 = Dp.m8684constructorimpl(56);
                        fM8684constructorimpl = Dp.m8684constructorimpl(4);
                        fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                        float f17 = 2;
                        fM8684constructorimpl3 = Dp.m8684constructorimpl(f17);
                        primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        Modifier modifierM1170size3ABfNKs17 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl12);
                        Alignment center9 = Alignment.INSTANCE.getCenter();
                        Modifier modifier13 = modifier4;
                        Function0<Unit> function112 = function5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center9, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                        iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs17);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                        Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM5259constructorimpl.getInserting()) {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        } else {
                            composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                            composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                        }
                        Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                        Modifier modifierM1170size3ABfNKs18 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl12);
                        Unit unit9 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                        if ((i3 & 14) == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z11) {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        } else {
                            function3 = onClick;
                            pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                                /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                                @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                                static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                    final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                    final /* synthetic */ Function0<Unit> $onClick;
                                    private /* synthetic */ Object L$0;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                        super(3, continuation);
                                        this.$onClick = function0;
                                        this.$isPressed$delegate = mutableState;
                                        this.$hasLongPressed$delegate = mutableState2;
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                        return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                    }

                                    /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                    public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                        anonymousClass1.L$0 = pressGestureScope;
                                        return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                            this.label = 1;
                                            obj = pressGestureScope.tryAwaitRelease(this);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        }
                                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                        if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                            this.$onClick.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                    Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                    return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float f18 = 0;
                        function2 = content;
                        SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs18, unit9, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f17), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f18), Dp.m8684constructorimpl(f18), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl12, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                        composer2 = composerStartRestartGroup;
                        Modifier modifierMatchParentSize9 = boxScopeInstance9.matchParentSize(Modifier.INSTANCE);
                        ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                        zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                        objRememberedValue7 = composer2.rememberedValue();
                        if (!zChangedInstance2) {
                            final Animatable animatable18 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable18, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        } else {
                            final Animatable animatable19 = animatable2;
                            objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable19, primary, (DrawScope) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierMatchParentSize9, (Function1) objRememberedValue7, composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        function4 = function112;
                        j5 = jM5975getTransparent0d7_KjU;
                        modifier3 = modifier13;
                    }
                    z4 = z2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Function0 function113 = function3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function113, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default19);
                        objRememberedValue2 = mutableStateMutableStateOf$default19;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default110);
                        objRememberedValue5 = mutableStateMutableStateOf$default110;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf19 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance111 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance112 = z6 | zChangedInstance111 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z1118 = zChangedInstance112 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z1118 | z8;
                    Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf19, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf110 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z1119 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$18 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z1119, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z1119;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$18;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z11110 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$19 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11110, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z11110;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$19;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl13 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f19 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f19);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs19 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl13);
                    Alignment center10 = Alignment.INSTANCE.getCenter();
                    Modifier modifier14 = modifier4;
                    Function0<Unit> function114 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center10, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs19);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs110 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl13);
                    Unit unit10 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f110 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs110, unit10, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f19), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f110), Dp.m8684constructorimpl(f110), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl13, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize10 = boxScopeInstance10.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable110 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable110, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable111 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable111, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize10, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function114;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier14;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function115 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function115, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            j3 = j2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function1 = function0;
            } else {
                function1 = function0;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111);
                        objRememberedValue2 = mutableStateMutableStateOf$default111;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default112);
                        objRememberedValue5 = mutableStateMutableStateOf$default112;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf111 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance113 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance114 = z6 | zChangedInstance113 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z11111 = zChangedInstance114 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z11111 | z8;
                    Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf112 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z11112 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$110 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11112, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z11112;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$110;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z11113 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$111 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11113, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z11113;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$111;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl14 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f111 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f111);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs111 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl14);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    Modifier modifier15 = modifier4;
                    Function0<Unit> function116 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center11, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs111);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs112 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl14);
                    Unit unit11 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f112 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs112, unit11, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f111), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f112), Dp.m8684constructorimpl(f112), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl14, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize11 = boxScopeInstance11.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable112 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable112, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable113 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable113, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize11, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function116;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier15;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function117 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function117, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                function2 = content;
                function3 = onClick;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j4 = j3;
                modifier3 = modifier2;
                function4 = function1;
                j5 = j;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                } else {
                    jM5975getTransparent0d7_KjU = j;
                }
                if (i6 != 0) {
                    j3 = 1500;
                }
                j6 = j3;
                if (i8 != 0) {
                    function1 = null;
                }
                if (i10 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default113);
                    objRememberedValue2 = mutableStateMutableStateOf$default113;
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState3 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default114);
                    objRememberedValue5 = mutableStateMutableStateOf$default114;
                }
                mutableState4 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                animatable = (Animatable) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Boolean boolValueOf113 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                boolean zChangedInstance115 = composerStartRestartGroup.changedInstance(animatable);
                if ((i3 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean zChangedInstance116 = z6 | zChangedInstance115 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((i3 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z11114 = zChangedInstance116 | z7;
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z11114 | z8;
                Object objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                } else {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf113, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                Boolean boolValueOf114 = Boolean.valueOf(z5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                if ((i3 & 3670016) == 1048576) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    boolean z11115 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$112 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11115, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z11115;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$112;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                } else {
                    boolean z11116 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$113 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11116, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z11116;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$113;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf114, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                final float fM8684constructorimpl15 = Dp.m8684constructorimpl(56);
                fM8684constructorimpl = Dp.m8684constructorimpl(4);
                fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                float f113 = 2;
                fM8684constructorimpl3 = Dp.m8684constructorimpl(f113);
                primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                Modifier modifierM1170size3ABfNKs113 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl15);
                Alignment center12 = Alignment.INSTANCE.getCenter();
                Modifier modifier16 = modifier4;
                Function0<Unit> function118 = function5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center12, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs113);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                Modifier modifierM1170size3ABfNKs114 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl15);
                Unit unit12 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                if ((i3 & 14) == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                } else {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f114 = 0;
                function2 = content;
                SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs114, unit12, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f113), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f114), Dp.m8684constructorimpl(f114), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl15, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                composer2 = composerStartRestartGroup;
                Modifier modifierMatchParentSize12 = boxScopeInstance12.matchParentSize(Modifier.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    final Animatable animatable114 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable114, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    final Animatable animatable115 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable115, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierMatchParentSize12, (Function1) objRememberedValue7, composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                function4 = function118;
                j5 = jM5975getTransparent0d7_KjU;
                modifier3 = modifier16;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function119 = function3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function119, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function1 = function0;
            } else {
                function1 = function0;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    function2 = content;
                    function3 = onClick;
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j4 = j3;
                    modifier3 = modifier2;
                    function4 = function1;
                    j5 = j;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                    } else {
                        jM5975getTransparent0d7_KjU = j;
                    }
                    if (i6 != 0) {
                        j3 = 1500;
                    }
                    j6 = j3;
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if (i10 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default115);
                        objRememberedValue2 = mutableStateMutableStateOf$default115;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    mutableState2 = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState3 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default116);
                        objRememberedValue5 = mutableStateMutableStateOf$default116;
                    }
                    mutableState4 = (MutableState) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    animatable = (Animatable) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Boolean boolValueOf115 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                    boolean zChangedInstance117 = composerStartRestartGroup.changedInstance(animatable);
                    if ((i3 & 458752) == 131072) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean zChangedInstance118 = z6 | zChangedInstance117 | composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i3 & 57344) == 16384) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    boolean z11117 = zChangedInstance118 | z7;
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z11117 | z8;
                    Object objRememberedValue110 = composerStartRestartGroup.rememberedValue();
                    if (!z9) {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    } else {
                        modifier4 = companion;
                        str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                        mutableState5 = mutableState3;
                        mutableState6 = mutableState4;
                        animatable2 = animatable;
                        function5 = function1;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf115, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                    Boolean boolValueOf116 = Boolean.valueOf(z5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                    if ((i3 & 3670016) == 1048576) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        boolean z11118 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$114 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11118, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z11118;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$114;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    } else {
                        boolean z11119 = z5;
                        LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$115 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z11119, animatable2, mutableState, mutableState5, mutableState2, null);
                        z2 = z11119;
                        longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$115;
                        composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf116, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                    final float fM8684constructorimpl16 = Dp.m8684constructorimpl(56);
                    fM8684constructorimpl = Dp.m8684constructorimpl(4);
                    fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                    float f115 = 2;
                    fM8684constructorimpl3 = Dp.m8684constructorimpl(f115);
                    primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    Modifier modifierM1170size3ABfNKs115 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl16);
                    Alignment center13 = Alignment.INSTANCE.getCenter();
                    Modifier modifier17 = modifier4;
                    Function0<Unit> function1110 = function5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(center13, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs115);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting()) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    } else {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                    Modifier modifierM1170size3ABfNKs116 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl16);
                    Unit unit13 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                    if ((i3 & 14) == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    } else {
                        function3 = onClick;
                        pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                            /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                            @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                            @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                            static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                                final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                                final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                                final /* synthetic */ Function0<Unit> $onClick;
                                private /* synthetic */ Object L$0;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                    super(3, continuation);
                                    this.$onClick = function0;
                                    this.$isPressed$delegate = mutableState;
                                    this.$hasLongPressed$delegate = mutableState2;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                    return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                                }

                                /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                                public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                    anonymousClass1.L$0 = pressGestureScope;
                                    return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                        this.label = 1;
                                        obj = pressGestureScope.tryAwaitRelease(this);
                                        if (obj == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i != 1) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                    if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                        this.$onClick.invoke();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                                return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float f116 = 0;
                    function2 = content;
                    SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs116, unit13, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f115), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f116), Dp.m8684constructorimpl(f116), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl16, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                    composer2 = composerStartRestartGroup;
                    Modifier modifierMatchParentSize13 = boxScopeInstance13.matchParentSize(Modifier.INSTANCE);
                    ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                    zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                    objRememberedValue7 = composer2.rememberedValue();
                    if (!zChangedInstance2) {
                        final Animatable animatable116 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable116, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    } else {
                        final Animatable animatable117 = animatable2;
                        objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable117, primary, (DrawScope) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierMatchParentSize13, (Function1) objRememberedValue7, composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    function4 = function1110;
                    j5 = jM5975getTransparent0d7_KjU;
                    modifier3 = modifier17;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function0 function1111 = function3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function1111, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                function2 = content;
                function3 = onClick;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j4 = j3;
                modifier3 = modifier2;
                function4 = function1;
                j5 = j;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                } else {
                    jM5975getTransparent0d7_KjU = j;
                }
                if (i6 != 0) {
                    j3 = 1500;
                }
                j6 = j3;
                if (i8 != 0) {
                    function1 = null;
                }
                if (i10 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default117);
                    objRememberedValue2 = mutableStateMutableStateOf$default117;
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState3 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default118);
                    objRememberedValue5 = mutableStateMutableStateOf$default118;
                }
                mutableState4 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                animatable = (Animatable) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Boolean boolValueOf117 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                boolean zChangedInstance119 = composerStartRestartGroup.changedInstance(animatable);
                if ((i3 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean zChangedInstance1110 = z6 | zChangedInstance119 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((i3 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z111110 = zChangedInstance1110 | z7;
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z111110 | z8;
                Object objRememberedValue111 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                } else {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf117, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                Boolean boolValueOf118 = Boolean.valueOf(z5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                if ((i3 & 3670016) == 1048576) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    boolean z111111 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$116 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111111, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z111111;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$116;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                } else {
                    boolean z111112 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$117 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111112, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z111112;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$117;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf118, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                final float fM8684constructorimpl17 = Dp.m8684constructorimpl(56);
                fM8684constructorimpl = Dp.m8684constructorimpl(4);
                fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                float f117 = 2;
                fM8684constructorimpl3 = Dp.m8684constructorimpl(f117);
                primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                Modifier modifierM1170size3ABfNKs117 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl17);
                Alignment center14 = Alignment.INSTANCE.getCenter();
                Modifier modifier18 = modifier4;
                Function0<Unit> function1112 = function5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center14, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs117);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                Modifier modifierM1170size3ABfNKs118 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl17);
                Unit unit14 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                if ((i3 & 14) == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                } else {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f118 = 0;
                function2 = content;
                SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs118, unit14, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f117), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f118), Dp.m8684constructorimpl(f118), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl17, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                composer2 = composerStartRestartGroup;
                Modifier modifierMatchParentSize14 = boxScopeInstance14.matchParentSize(Modifier.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    final Animatable animatable118 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable118, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    final Animatable animatable119 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable119, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierMatchParentSize14, (Function1) objRememberedValue7, composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                function4 = function1112;
                j5 = jM5975getTransparent0d7_KjU;
                modifier3 = modifier18;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function1113 = function3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function1113, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        j3 = j2;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
        } else {
            function1 = function0;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
        }
        i10 = i2 & 64;
        if (i10 != 0) {
            if ((1572864 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                function2 = content;
                function3 = onClick;
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j4 = j3;
                modifier3 = modifier2;
                function4 = function1;
                j5 = j;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
                } else {
                    jM5975getTransparent0d7_KjU = j;
                }
                if (i6 != 0) {
                    j3 = 1500;
                }
                j6 = j3;
                if (i8 != 0) {
                    function1 = null;
                }
                if (i10 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default119);
                    objRememberedValue2 = mutableStateMutableStateOf$default119;
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                mutableState2 = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                mutableState3 = (MutableState) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default1110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1110);
                    objRememberedValue5 = mutableStateMutableStateOf$default1110;
                }
                mutableState4 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                animatable = (Animatable) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Boolean boolValueOf119 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
                boolean zChangedInstance1111 = composerStartRestartGroup.changedInstance(animatable);
                if ((i3 & 458752) == 131072) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean zChangedInstance1112 = z6 | zChangedInstance1111 | composerStartRestartGroup.changedInstance(coroutineScope);
                if ((i3 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean z111113 = zChangedInstance1112 | z7;
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z111113 | z8;
                Object objRememberedValue112 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                } else {
                    modifier4 = companion;
                    str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                    mutableState5 = mutableState3;
                    mutableState6 = mutableState4;
                    animatable2 = animatable;
                    function5 = function1;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf119, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
                Boolean boolValueOf1110 = Boolean.valueOf(z5);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
                if ((i3 & 3670016) == 1048576) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    boolean z111114 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$118 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111114, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z111114;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$118;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                } else {
                    boolean z111115 = z5;
                    LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$119 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111115, animatable2, mutableState, mutableState5, mutableState2, null);
                    z2 = z111115;
                    longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$119;
                    composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf1110, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
                final float fM8684constructorimpl18 = Dp.m8684constructorimpl(56);
                fM8684constructorimpl = Dp.m8684constructorimpl(4);
                fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
                float f119 = 2;
                fM8684constructorimpl3 = Dp.m8684constructorimpl(f119);
                primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                Modifier modifierM1170size3ABfNKs119 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl18);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                Modifier modifier19 = modifier4;
                Function0<Unit> function1114 = function5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center15, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs119);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM5259constructorimpl.getInserting()) {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                } else {
                    composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                    composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                }
                Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
                Modifier modifierM1170size3ABfNKs1110 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl18);
                Unit unit15 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
                if ((i3 & 14) == 4) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                } else {
                    function3 = onClick;
                    pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                        /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                        static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                            final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                            final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                            final /* synthetic */ Function0<Unit> $onClick;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                                super(3, continuation);
                                this.$onClick = function0;
                                this.$isPressed$delegate = mutableState;
                                this.$hasLongPressed$delegate = mutableState2;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                                return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                            }

                            /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                            public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                                anonymousClass1.L$0 = pressGestureScope;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                    this.label = 1;
                                    obj = pressGestureScope.tryAwaitRelease(this);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                                if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                    this.$onClick.invoke();
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                            return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f1110 = 0;
                function2 = content;
                SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs1110, unit15, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f119), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f1110), Dp.m8684constructorimpl(f1110), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl18, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
                composer2 = composerStartRestartGroup;
                Modifier modifierMatchParentSize15 = boxScopeInstance15.matchParentSize(Modifier.INSTANCE);
                ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
                zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
                objRememberedValue7 = composer2.rememberedValue();
                if (!zChangedInstance2) {
                    final Animatable animatable1110 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable1110, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                } else {
                    final Animatable animatable1111 = animatable2;
                    objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable1111, primary, (DrawScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierMatchParentSize15, (Function1) objRememberedValue7, composer2, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                function4 = function1114;
                j5 = jM5975getTransparent0d7_KjU;
                modifier3 = modifier19;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function0 function1115 = function3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function1115, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z2 = z;
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i3 |= i12;
        }
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            function2 = content;
            function3 = onClick;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            j4 = j3;
            modifier3 = modifier2;
            function4 = function1;
            j5 = j;
        } else {
            if (i13 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                jM5975getTransparent0d7_KjU = Color.INSTANCE.m5975getTransparent0d7_KjU();
            } else {
                jM5975getTransparent0d7_KjU = j;
            }
            if (i6 != 0) {
                j3 = 1500;
            }
            j6 = j3;
            if (i8 != 0) {
                function1 = null;
            }
            if (i10 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(191068988, i3, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton (LongPressFloatingActionButton.kt:46)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066283298, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default1111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111);
                objRememberedValue2 = mutableStateMutableStateOf$default1111;
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066281405, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066279357, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            mutableState3 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066277250, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default1112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1112);
                objRememberedValue5 = mutableStateMutableStateOf$default1112;
            }
            mutableState4 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066275177, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            animatable = (Animatable) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Boolean boolValueOf1111 = Boolean.valueOf(LongPressFloatingActionButton_8r3B23s$lambda$1(mutableState));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066272435, "CC(remember):LongPressFloatingActionButton.kt#9igjgp");
            boolean zChangedInstance1113 = composerStartRestartGroup.changedInstance(animatable);
            if ((i3 & 458752) == 131072) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean zChangedInstance1114 = z6 | zChangedInstance1113 | composerStartRestartGroup.changedInstance(coroutineScope);
            if ((i3 & 57344) == 16384) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean z111116 = zChangedInstance1114 | z7;
            if ((i3 & 112) == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z111116 | z8;
            Object objRememberedValue113 = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                modifier4 = companion;
                str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                mutableState5 = mutableState3;
                mutableState6 = mutableState4;
                animatable2 = animatable;
                function5 = function1;
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
            } else {
                modifier4 = companion;
                str = "CC(remember):LongPressFloatingActionButton.kt#9igjgp";
                mutableState5 = mutableState3;
                mutableState6 = mutableState4;
                animatable2 = animatable;
                function5 = function1;
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1(animatable2, function5, coroutineScope, mutableState, mutableState6, j6, onLongPress, mutableState5, mutableState2, null);
                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf1111, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$1$1, composerStartRestartGroup, 0);
            Boolean boolValueOf1112 = Boolean.valueOf(z5);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1066242106, str);
            if ((i3 & 3670016) == 1048576) {
                z10 = true;
            } else {
                z10 = false;
            }
            zChangedInstance = z10 | composerStartRestartGroup.changedInstance(animatable2);
            longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                boolean z111117 = z5;
                LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1110 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111117, animatable2, mutableState, mutableState5, mutableState2, null);
                z2 = z111117;
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1110;
                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
            } else {
                boolean z111118 = z5;
                LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1 longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1111 = new LongPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1(z111118, animatable2, mutableState, mutableState5, mutableState2, null);
                z2 = z111118;
                longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue = longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1111;
                composerStartRestartGroup.updateRememberedValue(longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf1112, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) longPressFloatingActionButtonKt$LongPressFloatingActionButton$2$1RememberedValue, composerStartRestartGroup, (i3 >> 18) & 14);
            final float fM8684constructorimpl19 = Dp.m8684constructorimpl(56);
            fM8684constructorimpl = Dp.m8684constructorimpl(4);
            fM8684constructorimpl2 = Dp.m8684constructorimpl(16);
            float f1111 = 2;
            fM8684constructorimpl3 = Dp.m8684constructorimpl(f1111);
            primary = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
            Modifier modifierM1170size3ABfNKs1111 = SizeKt.m1170size3ABfNKs(modifier4, fM8684constructorimpl19);
            Alignment center16 = Alignment.INSTANCE.getCenter();
            Modifier modifier110 = modifier4;
            Function0<Unit> function1116 = function5;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(center16, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1170size3ABfNKs1111);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM5259constructorimpl = Updater.m5259constructorimpl(composerStartRestartGroup);
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM5259constructorimpl.getInserting()) {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            } else {
                composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
            }
            Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1505684147, "C110@3918L429,124@4433L11,131@4711L190,107@3807L1094,141@5031L1490,141@4985L1536:LongPressFloatingActionButton.kt#vpfmmr");
            Modifier modifierM1170size3ABfNKs1112 = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, fM8684constructorimpl19);
            Unit unit16 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -228522941, str);
            if ((i3 & 14) == 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            pointerInputEventHandlerRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11) {
                function3 = onClick;
                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                        final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                        final /* synthetic */ Function0<Unit> $onClick;
                        private /* synthetic */ Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                            super(3, continuation);
                            this.$onClick = function0;
                            this.$isPressed$delegate = mutableState;
                            this.$hasLongPressed$delegate = mutableState2;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                            return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                        }

                        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                        public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                            anonymousClass1.L$0 = pressGestureScope;
                            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                this.label = 1;
                                obj = pressGestureScope.tryAwaitRelease(this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                            if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                this.$onClick.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
            } else {
                function3 = onClick;
                pointerInputEventHandlerRememberedValue = new PointerInputEventHandler() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1

                    /* JADX INFO: renamed from: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: LongPressFloatingActionButton.kt */
                    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$LongPressFloatingActionButton$3$1$1$1", f = "LongPressFloatingActionButton.kt", i = {0}, l = {115}, m = "invokeSuspend", n = {"$this$detectTapGestures"}, s = {"L$0"})
                    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $hasLongPressed$delegate;
                        final /* synthetic */ MutableState<Boolean> $isPressed$delegate;
                        final /* synthetic */ Function0<Unit> $onClick;
                        private /* synthetic */ Object L$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super AnonymousClass1> continuation) {
                            super(3, continuation);
                            this.$onClick = function0;
                            this.$isPressed$delegate = mutableState;
                            this.$hasLongPressed$delegate = mutableState2;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                            return m9775invoked4ec7I(pressGestureScope, offset.m5706unboximpl(), continuation);
                        }

                        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
                        public final Object m9775invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$onClick, this.$isPressed$delegate, this.$hasLongPressed$delegate, continuation);
                            anonymousClass1.L$0 = pressGestureScope;
                            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, true);
                                this.L$0 = SpillingKt.nullOutSpilledVariable(pressGestureScope);
                                this.label = 1;
                                obj = pressGestureScope.tryAwaitRelease(this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$2(this.$isPressed$delegate, false);
                            if (zBooleanValue && !LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$10(this.$hasLongPressed$delegate)) {
                                this.$onClick.invoke();
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object objDetectTapGestures$default = TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, new AnonymousClass1(function3, mutableState, mutableState6, null), null, continuation, 11, null);
                        return objDetectTapGestures$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectTapGestures$default : Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(pointerInputEventHandlerRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f1112 = 0;
            function2 = content;
            SurfaceKt.m3692SurfaceT9BRK9s(BorderKt.m555borderxT4_qwU(SuspendingPointerInputFilterKt.pointerInput(modifierM1170size3ABfNKs1112, unit16, (PointerInputEventHandler) pointerInputEventHandlerRememberedValue), Dp.m8684constructorimpl(f1111), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2)), RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(fM8684constructorimpl2), jM5975getTransparent0d7_KjU, 0L, Dp.m8684constructorimpl(f1112), Dp.m8684constructorimpl(f1112), null, ComposableLambdaKt.rememberComposableLambda(-1586067589, true, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(fM8684constructorimpl19, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 896) | 12804096, 72);
            composer2 = composerStartRestartGroup;
            Modifier modifierMatchParentSize16 = boxScopeInstance16.matchParentSize(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer2, -228486264, str);
            zChangedInstance2 = composer2.changedInstance(animatable2) | composer2.changed(primary);
            objRememberedValue7 = composer2.rememberedValue();
            if (!zChangedInstance2) {
                final Animatable animatable1112 = animatable2;
                objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable1112, primary, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            } else {
                final Animatable animatable1113 = animatable2;
                objRememberedValue7 = new Function1() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(fM8684constructorimpl, fM8684constructorimpl3, fM8684constructorimpl2, animatable1113, primary, (DrawScope) obj);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifierMatchParentSize16, (Function1) objRememberedValue7, composer2, 0);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
            function4 = function1116;
            j5 = jM5975getTransparent0d7_KjU;
            modifier3 = modifier110;
        }
        z4 = z2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0 function1117 = function3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LongPressFloatingActionButtonKt.LongPressFloatingActionButton_8r3B23s$lambda$22(function1117, onLongPress, modifier3, j5, j4, function4, z4, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LongPressFloatingActionButton_8r3B23s$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LongPressFloatingActionButton_8r3B23s$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job LongPressFloatingActionButton_8r3B23s$lambda$4(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job LongPressFloatingActionButton_8r3B23s$lambda$7(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean LongPressFloatingActionButton_8r3B23s$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LongPressFloatingActionButton_8r3B23s$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$17(float f, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C132@4725L166:LongPressFloatingActionButton.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586067589, i, -1, "com.example.bingwahybrid.presentation.ui.components.LongPressFloatingActionButton.<anonymous>.<anonymous> (LongPressFloatingActionButton.kt:132)");
            }
            Modifier modifierM1170size3ABfNKs = SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, f);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1170size3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composer, 755319481, "C136@4868L9:LongPressFloatingActionButton.kt#vpfmmr");
            function2.invoke(composer, 0);
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
    public static final Unit LongPressFloatingActionButton_8r3B23s$lambda$21$lambda$20$lambda$19(float f, float f2, float f3, Animatable animatable, long j, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f4 = Canvas.mo705toPx0680j_4(f);
        float f5 = Canvas.mo705toPx0680j_4(f2);
        float f6 = Canvas.mo705toPx0680j_4(f3);
        float f7 = f4 / 2;
        float f8 = (-f5) + f7;
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (Canvas.mo6519getSizeNHjbRc() >> 32)) + f5) - f7;
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (Canvas.mo6519getSizeNHjbRc() & 4294967295L)) + f5) - f7;
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue > 0.0f) {
            Path Path = AndroidPath_androidKt.Path();
            Path.addRoundRect$default(Path, RoundRectKt.m5750RoundRectgG7oq9Y(f8, f8, fIntBitsToFloat, fIntBitsToFloat2, CornerRadius.m5650constructorimpl((((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f6)) & 4294967295L))), null, 2, null);
            PathMeasure PathMeasure = AndroidPathMeasure_androidKt.PathMeasure();
            PathMeasure.setPath(Path, false);
            float length = PathMeasure.getLength();
            float f9 = fFloatValue * length;
            DrawScope.m6509drawPathLG529CI$default(Canvas, Path, j, 0.0f, new Stroke(f4, 0.0f, StrokeCap.INSTANCE.m6311getRoundKaPHkGw(), 0, PathEffect.INSTANCE.dashPathEffect(new float[]{f9, length - f9}, 0.0f), 10, null), null, 0, 52, null);
        }
        return Unit.INSTANCE;
    }
}
