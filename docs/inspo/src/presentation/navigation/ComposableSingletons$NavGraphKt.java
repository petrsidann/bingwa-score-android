package com.example.bingwahybrid.presentation.navigation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import com.example.bingwahybrid.presentation.ui.screens.SplashScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavGraph.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$NavGraphKt {
    public static final ComposableSingletons$NavGraphKt INSTANCE = new ComposableSingletons$NavGraphKt();
    private static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> lambda$56035208 = ComposableLambdaKt.composableLambdaInstance(56035208, false, new Function4() { // from class: com.example.bingwahybrid.presentation.navigation.ComposableSingletons$NavGraphKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$NavGraphKt.lambda_56035208$lambda$0((AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> getLambda$56035208$app_debug() {
        return lambda$56035208;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_56035208$lambda$0(AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)90@4875L14:NavGraph.kt#ejwevl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(56035208, i, -1, "com.example.bingwahybrid.presentation.navigation.ComposableSingletons$NavGraphKt.lambda$56035208.<anonymous> (NavGraph.kt:90)");
        }
        SplashScreenKt.SplashScreen(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
