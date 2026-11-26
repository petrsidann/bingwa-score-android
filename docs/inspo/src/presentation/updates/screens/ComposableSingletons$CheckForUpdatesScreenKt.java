package com.example.bingwahybrid.presentation.updates.screens;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.UpdateKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CheckForUpdatesScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CheckForUpdatesScreenKt {
    public static final ComposableSingletons$CheckForUpdatesScreenKt INSTANCE = new ComposableSingletons$CheckForUpdatesScreenKt();

    /* JADX INFO: renamed from: lambda$-313990957, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f156lambda$313990957 = ComposableLambdaKt.composableLambdaInstance(-313990957, false, new Function2() { // from class: com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CheckForUpdatesScreenKt.lambda__313990957$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1057956211 = ComposableLambdaKt.composableLambdaInstance(1057956211, false, new Function2() { // from class: com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CheckForUpdatesScreenKt.lambda_1057956211$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1694003028, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f155lambda$1694003028 = ComposableLambdaKt.composableLambdaInstance(-1694003028, false, new Function2() { // from class: com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CheckForUpdatesScreenKt.lambda__1694003028$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1694003028$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9980getLambda$1694003028$app_debug() {
        return f155lambda$1694003028;
    }

    /* JADX INFO: renamed from: getLambda$-313990957$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9981getLambda$313990957$app_debug() {
        return f156lambda$313990957;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1057956211$app_debug() {
        return lambda$1057956211;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__313990957$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C57@2543L25:CheckForUpdatesScreen.kt#3mjzuu");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-313990957, i, -1, "com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt.lambda$-313990957.<anonymous> (CheckForUpdatesScreen.kt:57)");
            }
            TextKt.m3864TextNvy7gAk("Check For Updates", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1057956211$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2785L70:CheckForUpdatesScreen.kt#3mjzuu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1057956211, i, -1, "com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt.lambda$1057956211.<anonymous> (CheckForUpdatesScreen.kt:63)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1694003028$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C110@4125L192:CheckForUpdatesScreen.kt#3mjzuu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1694003028, i, -1, "com.example.bingwahybrid.presentation.updates.screens.ComposableSingletons$CheckForUpdatesScreenKt.lambda$-1694003028.<anonymous> (CheckForUpdatesScreen.kt:110)");
            }
            IconKt.m3158Iconww6aTOc(UpdateKt.getUpdate(Icons.Filled.INSTANCE), "Check For Updates", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(54)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
