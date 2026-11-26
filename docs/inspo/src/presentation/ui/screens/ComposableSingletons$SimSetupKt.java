package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SimSetup.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SimSetupKt {
    public static final ComposableSingletons$SimSetupKt INSTANCE = new ComposableSingletons$SimSetupKt();
    private static Function2<Composer, Integer, Unit> lambda$357822963 = ComposableLambdaKt.composableLambdaInstance(357822963, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$SimSetupKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SimSetupKt.lambda_357822963$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$357822963$app_debug() {
        return lambda$357822963;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_357822963$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C126@4854L14:SimSetup.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(357822963, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$SimSetupKt.lambda$357822963.<anonymous> (SimSetup.kt:126)");
            }
            TextKt.m3864TextNvy7gAk("Finish", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
