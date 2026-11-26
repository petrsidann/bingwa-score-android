package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aL\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"CustomButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "primary", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PreviewCustomButton", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CustomButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomButton$lambda$2(Function0 function0, Modifier modifier, boolean z, boolean z2, Function2 function2, int i, int i2, Composer composer, int i3) {
        CustomButton(function0, modifier, z, z2, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewCustomButton$lambda$5(int i, Composer composer, int i2) {
        PreviewCustomButton(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:70:0x0160  */
    /* JADX WARN: Code duplicated, block: B:73:0x0202  */
    /* JADX WARN: Code duplicated, block: B:75:0x020b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0219  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void CustomButton(final Function0<Unit> onClick, Modifier modifier, boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        boolean z5;
        Composer composer2;
        final Modifier modifier3;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z8;
        Modifier modifier4;
        boolean z9;
        int i8;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1572335461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomButton)N(onClick,modifier,enabled,primary,content):CustomButton.kt#vpfmmr");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(content)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 9363) != 9362) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z6 = z3;
                        z7 = z4;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z8 = true;
                        } else {
                            z8 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                        }
                        if (z8) {
                            composerStartRestartGroup.startReplaceGroup(-532166916);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                            int i10 = 805306368 | (i3 & 14) | (i3 & 896);
                            z9 = z3;
                            ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, i10, 480);
                            composerStartRestartGroup.endReplaceGroup();
                            composer2 = composerStartRestartGroup;
                            modifier4 = companion;
                        } else {
                            Modifier modifier5 = companion;
                            composerStartRestartGroup.startReplaceGroup(-531608482);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                            modifier4 = modifier5;
                            int i11 = 805306368 | (i3 & 14) | (i3 & 896);
                            z9 = z3;
                            ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier5, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, i11, 416);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z6 = z9;
                        z7 = z8;
                        modifier3 = modifier4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z4 = z2;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z8 = true;
                    } else {
                        z8 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                    }
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-532166916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                        int i12 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i12, 480);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                        modifier4 = companion;
                    } else {
                        Modifier modifier6 = companion;
                        composerStartRestartGroup.startReplaceGroup(-531608482);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                        modifier4 = modifier6;
                        int i13 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier6, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i13, 416);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z9;
                    z7 = z8;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z3 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z8 = true;
                    } else {
                        z8 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                    }
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-532166916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                        int i14 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i14, 480);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                        modifier4 = companion;
                    } else {
                        Modifier modifier7 = companion;
                        composerStartRestartGroup.startReplaceGroup(-531608482);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                        modifier4 = modifier7;
                        int i15 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier7, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i15, 416);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z9;
                    z7 = z8;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z8 = true;
                } else {
                    z8 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                }
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-532166916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                    int i16 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i16, 480);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    modifier4 = companion;
                } else {
                    Modifier modifier8 = companion;
                    composerStartRestartGroup.startReplaceGroup(-531608482);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                    modifier4 = modifier8;
                    int i17 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier8, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i17, 416);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z9;
                z7 = z8;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(content)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z8 = true;
                    } else {
                        z8 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                    }
                    if (z8) {
                        composerStartRestartGroup.startReplaceGroup(-532166916);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                        int i18 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i18, 480);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                        modifier4 = companion;
                    } else {
                        Modifier modifier9 = companion;
                        composerStartRestartGroup.startReplaceGroup(-531608482);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                        modifier4 = modifier9;
                        int i19 = 805306368 | (i3 & 14) | (i3 & 896);
                        z9 = z3;
                        ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier9, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i19, 416);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z6 = z9;
                    z7 = z8;
                    modifier3 = modifier4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z8 = true;
                } else {
                    z8 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                }
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-532166916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                    int i110 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i110, 480);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    modifier4 = companion;
                } else {
                    Modifier modifier10 = companion;
                    composerStartRestartGroup.startReplaceGroup(-531608482);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                    modifier4 = modifier10;
                    int i111 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier10, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i111, 416);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z9;
                z7 = z8;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z3 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z8 = true;
                } else {
                    z8 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
                }
                if (z8) {
                    composerStartRestartGroup.startReplaceGroup(-532166916);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                    int i112 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i112, 480);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    modifier4 = companion;
                } else {
                    Modifier modifier11 = companion;
                    composerStartRestartGroup.startReplaceGroup(-531608482);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                    modifier4 = modifier11;
                    int i113 = 805306368 | (i3 & 14) | (i3 & 896);
                    z9 = z3;
                    ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier11, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i113, 416);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z9;
                z7 = z8;
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        if ((i3 & 9363) != 9362) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z6 = z3;
            z7 = z4;
        } else {
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z3 = true;
            }
            if (i6 != 0) {
                z8 = true;
            } else {
                z8 = z4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1572335461, i3, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton (CustomButton.kt:22)");
            }
            if (z8) {
                composerStartRestartGroup.startReplaceGroup(-532166916);
                ComposerKt.sourceInformation(composerStartRestartGroup, "31@1109L11,32@1184L11,30@1048L181,35@1322L33,24@816L539");
                int i114 = 805306368 | (i3 & 14) | (i3 & 896);
                z9 = z3;
                ButtonKt.Button(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(companion, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(20)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(507296614, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CustomButtonKt.CustomButton$lambda$0(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i114, 480);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                modifier4 = companion;
            } else {
                Modifier modifier12 = companion;
                composerStartRestartGroup.startReplaceGroup(-531608482);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1647L11,46@1713L11,44@1586L160,50@1914L11,51@1945L33,39@1377L601");
                modifier4 = modifier12;
                int i115 = 805306368 | (i3 & 14) | (i3 & 896);
                z9 = z3;
                ButtonKt.OutlinedButton(onClick, SizeKt.m1156height3ABfNKs(PaddingKt.m1119paddingVpY3zN4(modifier12, Dp.m8684constructorimpl(16), Dp.m8684constructorimpl(8)), Dp.m8684constructorimpl(52)), z9, RoundedCornerShapeKt.m1483RoundedCornerShape0680j_4(Dp.m8684constructorimpl(12)), ButtonDefaults.INSTANCE.m2670buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, BorderStrokeKt.m573BorderStrokecXLIe8U(Dp.m8684constructorimpl(1), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary()), null, null, ComposableLambdaKt.rememberComposableLambda(242415793, true, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CustomButtonKt.CustomButton$lambda$1(content, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, i115, 416);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z6 = z9;
            z7 = z8;
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomButtonKt.CustomButton$lambda$2(onClick, modifier3, z6, z7, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomButton$lambda$0(Function2 function2, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C36@1336L9:CustomButton.kt#vpfmmr");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(507296614, i, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton.<anonymous> (CustomButton.kt:36)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomButton$lambda$1(Function2 function2, RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C52@1959L9:CustomButton.kt#vpfmmr");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(242415793, i, -1, "com.example.bingwahybrid.presentation.ui.components.CustomButton.<anonymous> (CustomButton.kt:52)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void PreviewCustomButton(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2136499437);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewCustomButton)60@2087L2,60@2064L80:CustomButton.kt#vpfmmr");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136499437, i, -1, "com.example.bingwahybrid.presentation.ui.components.PreviewCustomButton (CustomButton.kt:59)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 181594639, "CC(remember):CustomButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CustomButton((Function0) objRememberedValue, null, false, true, ComposableSingletons$CustomButtonKt.INSTANCE.m9750getLambda$1493248551$app_debug(), composerStartRestartGroup, 27654, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.CustomButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomButtonKt.PreviewCustomButton$lambda$5(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
