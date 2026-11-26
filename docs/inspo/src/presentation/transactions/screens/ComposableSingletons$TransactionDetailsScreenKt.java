package com.example.bingwahybrid.presentation.transactions.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionDetailsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TransactionDetailsScreenKt {
    public static final ComposableSingletons$TransactionDetailsScreenKt INSTANCE = new ComposableSingletons$TransactionDetailsScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$597422896 = ComposableLambdaKt.composableLambdaInstance(597422896, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransactionDetailsScreenKt.lambda_597422896$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$274699920 = ComposableLambdaKt.composableLambdaInstance(274699920, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransactionDetailsScreenKt.lambda_274699920$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1315963951, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f111lambda$1315963951 = ComposableLambdaKt.composableLambdaInstance(-1315963951, false, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TransactionDetailsScreenKt.lambda__1315963951$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1151417636 = ComposableLambdaKt.composableLambdaInstance(1151417636, false, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TransactionDetailsScreenKt.lambda_1151417636$lambda$3((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$116393855 = ComposableLambdaKt.composableLambdaInstance(116393855, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransactionDetailsScreenKt.lambda_116393855$lambda$4((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1315963951$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m9702getLambda$1315963951$app_debug() {
        return f111lambda$1315963951;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1151417636$app_debug() {
        return lambda$1151417636;
    }

    public final Function2<Composer, Integer, Unit> getLambda$116393855$app_debug() {
        return lambda$116393855;
    }

    public final Function2<Composer, Integer, Unit> getLambda$274699920$app_debug() {
        return lambda$274699920;
    }

    public final Function2<Composer, Integer, Unit> getLambda$597422896$app_debug() {
        return lambda$597422896;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_597422896$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C106@4638L27:TransactionDetailsScreen.kt#jgxt63");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(597422896, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt.lambda$597422896.<anonymous> (TransactionDetailsScreen.kt:106)");
            }
            TextKt.m3864TextNvy7gAk("Transaction Details", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_274699920$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4752L70:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274699920, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt.lambda$274699920.<anonymous> (TransactionDetailsScreen.kt:108)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_116393855$lambda$4(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C168@7318L26:TransactionDetailsScreen.kt#jgxt63");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(116393855, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt.lambda$116393855.<anonymous> (TransactionDetailsScreen.kt:168)");
            }
            TextKt.m3864TextNvy7gAk("Delete Transaction", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1315963951$lambda$2(RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C182@7944L14:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1315963951, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt.lambda$-1315963951.<anonymous> (TransactionDetailsScreen.kt:182)");
            }
            TextKt.m3864TextNvy7gAk("Delete", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1151417636$lambda$3(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C187@8111L14:TransactionDetailsScreen.kt#jgxt63");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1151417636, i, -1, "com.example.bingwahybrid.presentation.transactions.screens.ComposableSingletons$TransactionDetailsScreenKt.lambda$1151417636.<anonymous> (TransactionDetailsScreen.kt:187)");
            }
            TextKt.m3864TextNvy7gAk("Cancel", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
