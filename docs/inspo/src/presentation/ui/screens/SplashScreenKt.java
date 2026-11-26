package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SplashScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"SplashScreen", "", "(Landroidx/compose/runtime/Composer;I)V", "SplashScreenPreview", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SplashScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashScreen$lambda$0(int i, Composer composer, int i2) {
        SplashScreen(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashScreenPreview$lambda$1(int i, Composer composer, int i2) {
        SplashScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SplashScreen(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-870368178);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SplashScreen)31@1244L11,29@1162L1346:SplashScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-870368178, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SplashScreen (SplashScreen.kt:28)");
            }
            SurfaceKt.m3692SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground(), 0L, 0.0f, 0.0f, null, ComposableSingletons$SplashScreenKt.INSTANCE.getLambda$2049117907$app_debug(), composerStartRestartGroup, 12582918, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SplashScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SplashScreenKt.SplashScreen$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SplashScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2094408172);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SplashScreenPreview)71@2588L14:SplashScreen.kt#oif8tm");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2094408172, i, -1, "com.example.bingwahybrid.presentation.ui.screens.SplashScreenPreview (SplashScreen.kt:70)");
            }
            SplashScreen(composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.SplashScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SplashScreenKt.SplashScreenPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
