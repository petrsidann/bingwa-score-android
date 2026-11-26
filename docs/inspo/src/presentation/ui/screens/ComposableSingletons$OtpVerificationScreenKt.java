package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OtpVerificationScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$OtpVerificationScreenKt {
    public static final ComposableSingletons$OtpVerificationScreenKt INSTANCE = new ComposableSingletons$OtpVerificationScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1356810295 = ComposableLambdaKt.composableLambdaInstance(1356810295, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OtpVerificationScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OtpVerificationScreenKt.lambda_1356810295$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1243078871 = ComposableLambdaKt.composableLambdaInstance(1243078871, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OtpVerificationScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OtpVerificationScreenKt.lambda_1243078871$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1243078871$app_debug() {
        return lambda$1243078871;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1356810295$app_debug() {
        return lambda$1356810295;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1356810295$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C99@4162L10,100@4240L11,97@4072L295:OtpVerificationScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1356810295, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OtpVerificationScreenKt.lambda$1356810295.<anonymous> (OtpVerificationScreen.kt:97)");
            }
            TextKt.m3864TextNvy7gAk("Verify OTP", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1243078871$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@4731L70:OtpVerificationScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1243078871, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$OtpVerificationScreenKt.lambda$1243078871.<anonymous> (OtpVerificationScreen.kt:113)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
