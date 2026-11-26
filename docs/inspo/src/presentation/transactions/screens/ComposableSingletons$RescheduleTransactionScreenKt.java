package com.example.bingwahybrid.presentation.transactions.screens;

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

/* JADX INFO: compiled from: RescheduleTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RescheduleTransactionScreenKt {
    public static final ComposableSingletons$RescheduleTransactionScreenKt INSTANCE = new ComposableSingletons$RescheduleTransactionScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1649205296 = ComposableLambdaKt.composableLambdaInstance(1649205296, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RescheduleTransactionScreenKt.lambda_1649205296$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$421546192 = ComposableLambdaKt.composableLambdaInstance(421546192, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RescheduleTransactionScreenKt.lambda_421546192$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$273599861 = ComposableLambdaKt.composableLambdaInstance(273599861, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RescheduleTransactionScreenKt.lambda_273599861$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1649205296$app_debug() {
        return lambda$1649205296;
    }

    public final Function2<Composer, Integer, Unit> getLambda$273599861$app_debug() {
        return lambda$273599861;
    }

    public final Function2<Composer, Integer, Unit> getLambda$421546192$app_debug() {
        return lambda$421546192;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1649205296$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4351L30:RescheduleTransactionScreen.kt#jgxt63");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1649205296, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt.lambda$1649205296.<anonymous> (RescheduleTransactionScreen.kt:106)");
            }
            TextKt.m3864TextNvy7gAk("Reschedule Transaction", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_421546192$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@4729L70:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421546192, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt.lambda$421546192.<anonymous> (RescheduleTransactionScreen.kt:115)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_273599861$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C380@15669L10,378@15588L189:RescheduleTransactionScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(273599861, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$RescheduleTransactionScreenKt.lambda$273599861.<anonymous> (RescheduleTransactionScreen.kt:378)");
            }
            TextKt.m3864TextNvy7gAk("Reschedule", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
