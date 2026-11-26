package com.example.bingwahybrid.presentation.autorenewal.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AutoRenewScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AutoRenewScreenKt {
    public static final ComposableSingletons$AutoRenewScreenKt INSTANCE = new ComposableSingletons$AutoRenewScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1782136779 = ComposableLambdaKt.composableLambdaInstance(1782136779, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoRenewScreenKt.lambda_1782136779$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2105069675 = ComposableLambdaKt.composableLambdaInstance(2105069675, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoRenewScreenKt.lambda_2105069675$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1912787210, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f58lambda$1912787210 = ComposableLambdaKt.composableLambdaInstance(-1912787210, false, new Function2() { // from class: com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoRenewScreenKt.lambda__1912787210$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1912787210$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9389getLambda$1912787210$app_debug() {
        return f58lambda$1912787210;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1782136779$app_debug() {
        return lambda$1782136779;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2105069675$app_debug() {
        return lambda$2105069675;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1782136779$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C56@2458L21:AutoRenewScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1782136779, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt.lambda$1782136779.<anonymous> (AutoRenewScreen.kt:56)");
            }
            TextKt.m3864TextNvy7gAk("Auto Renewals", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2105069675$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C60@2619L70:AutoRenewScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2105069675, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt.lambda$2105069675.<anonymous> (AutoRenewScreen.kt:60)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1912787210$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C131@4922L127:AutoRenewScreen.kt#cnhgb");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1912787210, i, -1, "com.example.bingwahybrid.presentation.autorenewal.screens.ComposableSingletons$AutoRenewScreenKt.lambda$-1912787210.<anonymous> (AutoRenewScreen.kt:131)");
            }
            IconKt.m3158Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add AutoRenew Offer", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
