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

/* JADX INFO: compiled from: OnBoardingScreen1.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$OnBoardingScreen1Kt {
    public static final ComposableSingletons$OnBoardingScreen1Kt INSTANCE = new ComposableSingletons$OnBoardingScreen1Kt();

    /* JADX INFO: renamed from: lambda$-2145442073, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f147lambda$2145442073 = ComposableLambdaKt.composableLambdaInstance(-2145442073, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen1Kt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnBoardingScreen1Kt.lambda__2145442073$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1610515486 = ComposableLambdaKt.composableLambdaInstance(1610515486, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen1Kt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OnBoardingScreen1Kt.lambda_1610515486$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2145442073$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9854getLambda$2145442073$app_debug() {
        return f147lambda$2145442073;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1610515486$app_debug() {
        return lambda$1610515486;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2145442073$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C84@3573L10,86@3725L11,82@3466L424:OnBoardingScreen1.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145442073, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen1Kt.lambda$-2145442073.<anonymous> (OnBoardingScreen1.kt:82)");
            }
            TextKt.m3864TextNvy7gAk("Skip", PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8684constructorimpl(20), 0.0f, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 54, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1610515486$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@4227L10,100@4379L11,96@4120L435:OnBoardingScreen1.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1610515486, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OnBoardingScreen1Kt.lambda$1610515486.<anonymous> (OnBoardingScreen1.kt:96)");
            }
            TextKt.m3864TextNvy7gAk("Next", PaddingKt.m1120paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m8684constructorimpl(20), 0.0f, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 54, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
