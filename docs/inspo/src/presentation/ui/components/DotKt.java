package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.example.bingwahybrid.domain.enums.TransactionStatus;
import com.example.bingwahybrid.domain.utils.ColorUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Dot.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Dot", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "Dot-iJQMabo", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "DotPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DotKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DotPreview$lambda$1(int i, Composer composer, int i2) {
        DotPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Dot_iJQMabo$lambda$0(Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m9759DotiJQMabo(modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: Dot-iJQMabo, reason: not valid java name */
    public static final void m9759DotiJQMabo(Modifier modifier, final long j, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1069919333);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Dot)N(modifier,color:c#ui.graphics.Color)19@679L106:Dot.kt#vpfmmr");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1069919333, i3, -1, "com.example.bingwahybrid.presentation.ui.components.Dot (Dot.kt:18)");
            }
            BoxKt.Box(BackgroundKt.m542backgroundbw27NRU(SizeKt.m1170size3ABfNKs(modifier, Dp.m8684constructorimpl(8)), j, RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.DotKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DotKt.Dot_iJQMabo$lambda$0(modifier2, j, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DotPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1422894917);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DotPreview)30@854L55,29@833L82:Dot.kt#vpfmmr");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1422894917, i, -1, "com.example.bingwahybrid.presentation.ui.components.DotPreview (Dot.kt:28)");
            }
            m9759DotiJQMabo(null, ColorUtilsKt.getColorForTransactionStatus(TransactionStatus.SUCCESS, composerStartRestartGroup, 6), composerStartRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.DotKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DotKt.DotPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
