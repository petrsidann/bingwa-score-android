package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OnBoardingScreen2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$OnBoardingScreen2Kt {
    public static final ComposableSingletons$OnBoardingScreen2Kt INSTANCE = new ComposableSingletons$OnBoardingScreen2Kt();
    private static Function2<Composer, Integer, Unit> lambda$1673859633 = ComposableLambdaKt.composableLambdaInstance(1673859633, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen2Kt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnBoardingScreen2Kt.lambda_1673859633$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1257674408 = ComposableLambdaKt.composableLambdaInstance(1257674408, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen2Kt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnBoardingScreen2Kt.lambda_1257674408$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1257674408$app_debug() {
        return lambda$1257674408;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1673859633$app_debug() {
        return lambda$1673859633;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1673859633$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@3617L10,85@3703L11,82@3510L424:OnBoardingScreen2.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1673859633, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen2Kt.lambda$1673859633.<anonymous> (OnBoardingScreen2.kt:82)");
            }
            TextKt.m3864TextNvy7gAk("Prev", PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8684constructorimpl(20), 0.0f, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 54, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1257674408$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@4271L10,99@4357L11,96@4164L436:OnBoardingScreen2.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257674408, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen2Kt.lambda$1257674408.<anonymous> (OnBoardingScreen2.kt:96)");
            }
            TextKt.m3864TextNvy7gAk("Next", PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8684constructorimpl(20), 0.0f, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 54, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
