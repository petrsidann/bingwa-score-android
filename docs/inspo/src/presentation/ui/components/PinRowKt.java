package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PinRow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"PinRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "pin", "", "isLoading", "", "hasError", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZZLandroidx/compose/runtime/Composer;II)V", "PinRowPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug", "animatedPin", "color", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PinRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinRow$lambda$7(Modifier modifier, String str, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        PinRow(modifier, str, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PinRowPreview$lambda$8(int i, Composer composer, int i2) {
        PinRowPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0231  */
    /* JADX WARN: Code duplicated, block: B:102:0x024c  */
    /* JADX WARN: Code duplicated, block: B:105:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:106:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:110:0x0301  */
    /* JADX WARN: Code duplicated, block: B:112:0x0306  */
    /* JADX WARN: Code duplicated, block: B:115:0x0312  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0097 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:50:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:73:0x0117  */
    /* JADX WARN: Code duplicated, block: B:74:0x011a  */
    /* JADX WARN: Code duplicated, block: B:77:0x011e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0128  */
    /* JADX WARN: Code duplicated, block: B:82:0x0130  */
    /* JADX WARN: Code duplicated, block: B:85:0x018d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0199  */
    /* JADX WARN: Code duplicated, block: B:89:0x019d  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:97:0x020a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x020c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0227  */
    public static final void PinRow(Modifier modifier, final String pin, boolean z, boolean z2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        int i6;
        boolean z5;
        final Modifier.Companion companion;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        Object objRememberedValue;
        MutableState mutableState;
        int i7;
        boolean z9;
        PinRowKt$PinRow$1$1 pinRowKt$PinRow$1$1RememberedValue;
        boolean z10;
        boolean z11;
        PinRowKt$PinRow$2$1 pinRowKt$PinRow$2$1RememberedValue;
        int iHashCode;
        Function0<ComposeUiNode> constructor;
        Composer composerM5259constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i8;
        int i9;
        long jM5939copywmQWz5c$default;
        char c;
        Intrinsics.checkNotNullParameter(pin, "pin");
        Composer composerStartRestartGroup = composer.startRestartGroup(1723706985);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinRow)N(modifier,pin,isLoading,hasError)33@1223L31,35@1280L33,35@1260L53,39@1345L187,39@1319L213,49@1538L838:PinRow.kt#vpfmmr");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(pin) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                z3 = z;
                i3 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = 0;
                if ((i3 & 1171) != 1170) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    z6 = z3;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i11 != 0) {
                        z8 = false;
                    } else {
                        z8 = z3;
                    }
                    if (i4 != 0) {
                        z4 = false;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1723706985, i3, -1, "com.example.bingwahybrid.presentation.ui.components.PinRow (PinRow.kt:31)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374958296, "CC(remember):PinRow.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374956470, "CC(remember):PinRow.kt#9igjgp");
                    i7 = i3 & 112;
                    if (i7 == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    pinRowKt$PinRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z9 || pinRowKt$PinRow$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(pin, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$1$1RememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
                    Boolean boolValueOf = Boolean.valueOf(z8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374954236, "CC(remember):PinRow.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = z10 | (i7 == 32);
                    pinRowKt$PinRow$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z11 || pinRowKt$PinRow$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                    iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                    Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m5266setimpl(composerM5259constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM5259constructorimpl.getInserting() || !Intrinsics.areEqual(composerM5259constructorimpl.rememberedValue(), Integer.valueOf(iHashCode))) {
                        composerM5259constructorimpl.updateRememberedValue(Integer.valueOf(iHashCode));
                        composerM5259constructorimpl.apply(Integer.valueOf(iHashCode), setCompositeKeyHash);
                    }
                    Updater.m5266setimpl(composerM5259constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863628049, "C:PinRow.kt#vpfmmr");
                    composerStartRestartGroup.startReplaceGroup(2018092948);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*53@1635L355,62@2004L260");
                    i8 = 0;
                    i9 = 4;
                    while (i8 < i9) {
                        if (z4) {
                            composerStartRestartGroup.startReplaceGroup(2018097418);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "55@1739L11");
                            jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError();
                            composerStartRestartGroup.endReplaceGroup();
                        } else if (i8 < PinRow$lambda$1(mutableState).length()) {
                            composerStartRestartGroup.startReplaceGroup(2018099916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "56@1817L11");
                            jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(2018102231);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "57@1879L11");
                            jM5939copywmQWz5c$default = Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        int i12 = i6;
                        BoxKt.Box(BackgroundKt.m542backgroundbw27NRU(PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), Dp.m8684constructorimpl(4)), PinRow$lambda$6$lambda$5(SingleValueAnimationKt.m406animateColorAsStateeuL9pac(jM5939copywmQWz5c$default, null, "PinRowColor", null, composerStartRestartGroup, 384, 10)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, i12);
                        if (i8 < 3) {
                            composerStartRestartGroup.startReplaceGroup(-1862954699);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "72@2306L40");
                            c = 6;
                            SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
                        } else {
                            c = 6;
                            composerStartRestartGroup.startReplaceGroup(-1865227619);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        i8++;
                        i9 = 4;
                        i6 = i12;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z8;
                }
                z7 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.PinRowKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PinRowKt.PinRow$lambda$7(companion, pin, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            i6 = 0;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                z6 = z3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i11 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z4 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1723706985, i3, -1, "com.example.bingwahybrid.presentation.ui.components.PinRow (PinRow.kt:31)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374958296, "CC(remember):PinRow.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374956470, "CC(remember):PinRow.kt#9igjgp");
                i7 = i3 & 112;
                if (i7 == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                pinRowKt$PinRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
                } else {
                    pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(pin, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$1$1RememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
                Boolean boolValueOf2 = Boolean.valueOf(z8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374954236, "CC(remember):PinRow.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = z10 | (i7 == 32);
                pinRowKt$PinRow$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
                } else {
                    pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863628049, "C:PinRow.kt#vpfmmr");
                composerStartRestartGroup.startReplaceGroup(2018092948);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*53@1635L355,62@2004L260");
                i8 = 0;
                i9 = 4;
                while (i8 < i9) {
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(2018097418);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "55@1739L11");
                        jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError();
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (i8 < PinRow$lambda$1(mutableState).length()) {
                        composerStartRestartGroup.startReplaceGroup(2018099916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "56@1817L11");
                        jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2018102231);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "57@1879L11");
                        jM5939copywmQWz5c$default = Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i13 = i6;
                    BoxKt.Box(BackgroundKt.m542backgroundbw27NRU(PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), Dp.m8684constructorimpl(4)), PinRow$lambda$6$lambda$5(SingleValueAnimationKt.m406animateColorAsStateeuL9pac(jM5939copywmQWz5c$default, null, "PinRowColor", null, composerStartRestartGroup, 384, 10)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, i13);
                    if (i8 < 3) {
                        composerStartRestartGroup.startReplaceGroup(-1862954699);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@2306L40");
                        c = 6;
                        SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
                    } else {
                        c = 6;
                        composerStartRestartGroup.startReplaceGroup(-1865227619);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    i8++;
                    i9 = 4;
                    i6 = i13;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z8;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.PinRowKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinRowKt.PinRow$lambda$7(companion, pin, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z3 = z;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = 0;
            if ((i3 & 1171) != 1170) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                z6 = z3;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i11 != 0) {
                    z8 = false;
                } else {
                    z8 = z3;
                }
                if (i4 != 0) {
                    z4 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1723706985, i3, -1, "com.example.bingwahybrid.presentation.ui.components.PinRow (PinRow.kt:31)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374958296, "CC(remember):PinRow.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374956470, "CC(remember):PinRow.kt#9igjgp");
                i7 = i3 & 112;
                if (i7 == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                pinRowKt$PinRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
                } else {
                    pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(pin, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$1$1RememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
                Boolean boolValueOf3 = Boolean.valueOf(z8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374954236, "CC(remember):PinRow.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = z10 | (i7 == 32);
                pinRowKt$PinRow$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z11) {
                    pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
                } else {
                    pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863628049, "C:PinRow.kt#vpfmmr");
                composerStartRestartGroup.startReplaceGroup(2018092948);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*53@1635L355,62@2004L260");
                i8 = 0;
                i9 = 4;
                while (i8 < i9) {
                    if (z4) {
                        composerStartRestartGroup.startReplaceGroup(2018097418);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "55@1739L11");
                        jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError();
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (i8 < PinRow$lambda$1(mutableState).length()) {
                        composerStartRestartGroup.startReplaceGroup(2018099916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "56@1817L11");
                        jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(2018102231);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "57@1879L11");
                        jM5939copywmQWz5c$default = Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i14 = i6;
                    BoxKt.Box(BackgroundKt.m542backgroundbw27NRU(PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), Dp.m8684constructorimpl(4)), PinRow$lambda$6$lambda$5(SingleValueAnimationKt.m406animateColorAsStateeuL9pac(jM5939copywmQWz5c$default, null, "PinRowColor", null, composerStartRestartGroup, 384, 10)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, i14);
                    if (i8 < 3) {
                        composerStartRestartGroup.startReplaceGroup(-1862954699);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "72@2306L40");
                        c = 6;
                        SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
                    } else {
                        c = 6;
                        composerStartRestartGroup.startReplaceGroup(-1865227619);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    i8++;
                    i9 = 4;
                    i6 = i14;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z8;
            }
            z7 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.PinRowKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PinRowKt.PinRow$lambda$7(companion, pin, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        i6 = 0;
        if ((i3 & 1171) != 1170) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            z6 = z3;
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i11 != 0) {
                z8 = false;
            } else {
                z8 = z3;
            }
            if (i4 != 0) {
                z4 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1723706985, i3, -1, "com.example.bingwahybrid.presentation.ui.components.PinRow (PinRow.kt:31)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374958296, "CC(remember):PinRow.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374956470, "CC(remember):PinRow.kt#9igjgp");
            i7 = i3 & 112;
            if (i7 == 32) {
                z9 = true;
            } else {
                z9 = false;
            }
            pinRowKt$PinRow$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
            } else {
                pinRowKt$PinRow$1$1RememberedValue = new PinRowKt$PinRow$1$1(pin, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(pin, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$1$1RememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
            Boolean boolValueOf4 = Boolean.valueOf(z8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1374954236, "CC(remember):PinRow.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = z10 | (i7 == 32);
            pinRowKt$PinRow$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z11) {
                pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
            } else {
                pinRowKt$PinRow$2$1RememberedValue = new PinRowKt$PinRow$2$1(z8, pin, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(pinRowKt$PinRow$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) pinRowKt$PinRow$2$1RememberedValue, composerStartRestartGroup, (i3 >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
            iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m5266setimpl(composerM5259constructorimpl, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1863628049, "C:PinRow.kt#vpfmmr");
            composerStartRestartGroup.startReplaceGroup(2018092948);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*53@1635L355,62@2004L260");
            i8 = 0;
            i9 = 4;
            while (i8 < i9) {
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(2018097418);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "55@1739L11");
                    jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getError();
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i8 < PinRow$lambda$1(mutableState).length()) {
                    composerStartRestartGroup.startReplaceGroup(2018099916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "56@1817L11");
                    jM5939copywmQWz5c$default = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary();
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2018102231);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@1879L11");
                    jM5939copywmQWz5c$default = Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i15 = i6;
                BoxKt.Box(BackgroundKt.m542backgroundbw27NRU(PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), Dp.m8684constructorimpl(4)), PinRow$lambda$6$lambda$5(SingleValueAnimationKt.m406animateColorAsStateeuL9pac(jM5939copywmQWz5c$default, null, "PinRowColor", null, composerStartRestartGroup, 384, 10)), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, i15);
                if (i8 < 3) {
                    composerStartRestartGroup.startReplaceGroup(-1862954699);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "72@2306L40");
                    c = 6;
                    SpacerKt.Spacer(SizeKt.m1175width3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(12)), composerStartRestartGroup, 6);
                } else {
                    c = 6;
                    composerStartRestartGroup.startReplaceGroup(-1865227619);
                }
                composerStartRestartGroup.endReplaceGroup();
                i8++;
                i9 = 4;
                i6 = i15;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z8;
        }
        z7 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.PinRowKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinRowKt.PinRow$lambda$7(companion, pin, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String PinRow$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final void PinRowPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-547517997);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PinRowPreview)81@2458L37:PinRow.kt#vpfmmr");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547517997, i, -1, "com.example.bingwahybrid.presentation.ui.components.PinRowPreview (PinRow.kt:80)");
            }
            PinRow(null, "123", true, false, composerStartRestartGroup, 432, 9);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.PinRowKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PinRowKt.PinRowPreview$lambda$8(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long PinRow$lambda$6$lambda$5(State<Color> state) {
        return state.getValue().m5950unboximpl();
    }
}
