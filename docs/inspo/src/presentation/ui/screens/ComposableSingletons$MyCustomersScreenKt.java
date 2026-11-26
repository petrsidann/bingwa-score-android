package com.example.bingwahybrid.presentation.ui.screens;

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

/* JADX INFO: compiled from: MyCustomersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$MyCustomersScreenKt {
    public static final ComposableSingletons$MyCustomersScreenKt INSTANCE = new ComposableSingletons$MyCustomersScreenKt();

    /* JADX INFO: renamed from: lambda$-1276178151, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f146lambda$1276178151 = ComposableLambdaKt.composableLambdaInstance(-1276178151, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$MyCustomersScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MyCustomersScreenKt.lambda__1276178151$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1110158215, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f145lambda$1110158215 = ComposableLambdaKt.composableLambdaInstance(-1110158215, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$MyCustomersScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MyCustomersScreenKt.lambda__1110158215$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1110158215$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9852getLambda$1110158215$app_debug() {
        return f145lambda$1110158215;
    }

    /* JADX INFO: renamed from: getLambda$-1276178151$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9853getLambda$1276178151$app_debug() {
        return f146lambda$1276178151;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1276178151$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@2054L25:MyCustomersScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1276178151, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$MyCustomersScreenKt.lambda$-1276178151.<anonymous> (MyCustomersScreen.kt:49)");
            }
            TextKt.m3864TextNvy7gAk("Customer Balances", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1110158215$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C52@2220L70:MyCustomersScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1110158215, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$MyCustomersScreenKt.lambda$-1110158215.<anonymous> (MyCustomersScreen.kt:52)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
