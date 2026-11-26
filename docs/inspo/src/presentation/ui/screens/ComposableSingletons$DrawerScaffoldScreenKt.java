package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DrawerScaffoldScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DrawerScaffoldScreenKt {
    public static final ComposableSingletons$DrawerScaffoldScreenKt INSTANCE = new ComposableSingletons$DrawerScaffoldScreenKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1463100224 = ComposableLambdaKt.composableLambdaInstance(1463100224, false, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$DrawerScaffoldScreenKt.lambda_1463100224$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$211139227 = ComposableLambdaKt.composableLambdaInstance(211139227, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DrawerScaffoldScreenKt.lambda_211139227$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$447309050 = ComposableLambdaKt.composableLambdaInstance(447309050, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DrawerScaffoldScreenKt.lambda_447309050$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1463100224$app_debug() {
        return lambda$1463100224;
    }

    public final Function2<Composer, Integer, Unit> getLambda$211139227$app_debug() {
        return lambda$211139227;
    }

    public final Function2<Composer, Integer, Unit> getLambda$447309050$app_debug() {
        return lambda$447309050;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_211139227$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C160@5321L29:DrawerScaffoldScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(211139227, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt.lambda$211139227.<anonymous> (DrawerScaffoldScreen.kt:160)");
            }
            TextKt.m3864TextNvy7gAk("Confirm Logout", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_447309050$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C162@5383L48:DrawerScaffoldScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(447309050, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt.lambda$447309050.<anonymous> (DrawerScaffoldScreen.kt:162)");
            }
            TextKt.m3864TextNvy7gAk("Are you sure you want to log out?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1463100224$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C169@5690L21:DrawerScaffoldScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1463100224, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$DrawerScaffoldScreenKt.lambda$1463100224.<anonymous> (DrawerScaffoldScreen.kt:169)");
            }
            TextKt.m3864TextNvy7gAk("Cancel", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
