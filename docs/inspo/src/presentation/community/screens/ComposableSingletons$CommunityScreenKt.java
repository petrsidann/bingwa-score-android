package com.example.bingwahybrid.presentation.community.screens;

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

/* JADX INFO: compiled from: CommunityScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CommunityScreenKt {
    public static final ComposableSingletons$CommunityScreenKt INSTANCE = new ComposableSingletons$CommunityScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1691847360 = ComposableLambdaKt.composableLambdaInstance(1691847360, false, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.ComposableSingletons$CommunityScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CommunityScreenKt.lambda_1691847360$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1704182944, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f66lambda$1704182944 = ComposableLambdaKt.composableLambdaInstance(-1704182944, false, new Function2() { // from class: com.example.bingwahybrid.presentation.community.screens.ComposableSingletons$CommunityScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CommunityScreenKt.lambda__1704182944$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1704182944$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9428getLambda$1704182944$app_debug() {
        return f66lambda$1704182944;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1691847360$app_debug() {
        return lambda$1691847360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1691847360$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C42@1773L17:CommunityScreen.kt#ryol0b");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691847360, i, -1, "com.example.bingwahybrid.presentation.community.screens.ComposableSingletons$CommunityScreenKt.lambda$1691847360.<anonymous> (CommunityScreen.kt:42)");
            }
            TextKt.m3864TextNvy7gAk("Community", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1704182944$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C45@1930L70:CommunityScreen.kt#ryol0b");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1704182944, i, -1, "com.example.bingwahybrid.presentation.community.screens.ComposableSingletons$CommunityScreenKt.lambda$-1704182944.<anonymous> (CommunityScreen.kt:45)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
