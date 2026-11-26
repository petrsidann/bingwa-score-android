package com.example.bingwahybrid.presentation.autorenewal.screens;

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

/* JADX INFO: compiled from: AddAutoRenewTransactionScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AddAutoRenewTransactionScreenKt {
    public static final ComposableSingletons$AddAutoRenewTransactionScreenKt INSTANCE = new ComposableSingletons$AddAutoRenewTransactionScreenKt();

    /* JADX INFO: renamed from: lambda$-38990470, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f57lambda$38990470 = ComposableLambdaKt.composableLambdaInstance(-38990470, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda__38990470$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1434590746 = ComposableLambdaKt.composableLambdaInstance(1434590746, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda_1434590746$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1643953444 = ComposableLambdaKt.composableLambdaInstance(1643953444, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda_1643953444$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1488186082, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f56lambda$1488186082 = ComposableLambdaKt.composableLambdaInstance(-1488186082, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda__1488186082$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1488186082$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9386getLambda$1488186082$app_debug() {
        return f56lambda$1488186082;
    }

    /* JADX INFO: renamed from: getLambda$-38990470$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9387getLambda$38990470$app_debug() {
        return f57lambda$38990470;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1434590746$app_debug() {
        return lambda$1434590746;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1643953444$app_debug() {
        return lambda$1643953444;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__38990470$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C102@4324L24:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-38990470, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda$-38990470.<anonymous> (AddAutoRenewTransactionScreen.kt:102)");
            }
            TextKt.m3864TextNvy7gAk("Reschedule Offer", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1434590746$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4695L70:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1434590746, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda$1434590746.<anonymous> (AddAutoRenewTransactionScreen.kt:111)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1643953444$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C181@7140L22:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1643953444, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda$1643953444.<anonymous> (AddAutoRenewTransactionScreen.kt:181)");
            }
            TextKt.m3864TextNvy7gAk("Customer Phone", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1488186082$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C391@16274L10,389@16195L187:AddAutoRenewTransactionScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1488186082, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AddAutoRenewTransactionScreenKt.lambda$-1488186082.<anonymous> (AddAutoRenewTransactionScreen.kt:389)");
            }
            TextKt.m3864TextNvy7gAk("Schedule", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
