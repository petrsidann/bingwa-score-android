package com.example.bingwahybrid.presentation.subscriptions;

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

/* JADX INFO: compiled from: PayWithAirtimeScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PayWithAirtimeScreenKt {
    public static final ComposableSingletons$PayWithAirtimeScreenKt INSTANCE = new ComposableSingletons$PayWithAirtimeScreenKt();

    /* JADX INFO: renamed from: lambda$-1134516038, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f107lambda$1134516038 = ComposableLambdaKt.composableLambdaInstance(-1134516038, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PayWithAirtimeScreenKt.lambda__1134516038$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$237431130 = ComposableLambdaKt.composableLambdaInstance(237431130, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PayWithAirtimeScreenKt.lambda_237431130$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$144016186 = ComposableLambdaKt.composableLambdaInstance(144016186, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PayWithAirtimeScreenKt.lambda_144016186$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1134516038$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9644getLambda$1134516038$app_debug() {
        return f107lambda$1134516038;
    }

    public final Function2<Composer, Integer, Unit> getLambda$144016186$app_debug() {
        return lambda$144016186;
    }

    public final Function2<Composer, Integer, Unit> getLambda$237431130$app_debug() {
        return lambda$237431130;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1134516038$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C75@3105L24:PayWithAirtimeScreen.kt#6tb7vd");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1134516038, i, -1, "com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt.lambda$-1134516038.<anonymous> (PayWithAirtimeScreen.kt:75)");
            }
            TextKt.m3864TextNvy7gAk("Pay With Airtime", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_237431130$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3270L70:PayWithAirtimeScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(237431130, i, -1, "com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt.lambda$237431130.<anonymous> (PayWithAirtimeScreen.kt:78)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_144016186$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@4456L14:PayWithAirtimeScreen.kt#6tb7vd");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144016186, i, -1, "com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$PayWithAirtimeScreenKt.lambda$144016186.<anonymous> (PayWithAirtimeScreen.kt:120)");
            }
            TextKt.m3864TextNvy7gAk("Amount", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
