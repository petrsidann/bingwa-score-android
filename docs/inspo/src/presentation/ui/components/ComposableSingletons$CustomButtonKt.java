package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CustomButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CustomButtonKt {
    public static final ComposableSingletons$CustomButtonKt INSTANCE = new ComposableSingletons$CustomButtonKt();

    /* JADX INFO: renamed from: lambda$-1493248551, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f116lambda$1493248551 = ComposableLambdaKt.composableLambdaInstance(-1493248551, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomButtonKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CustomButtonKt.lambda__1493248551$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1493248551$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9750getLambda$1493248551$app_debug() {
        return f116lambda$1493248551;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1493248551$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2117L21:CustomButton.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1493248551, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomButtonKt.lambda$-1493248551.<anonymous> (CustomButton.kt:61)");
            }
            TextKt.m3864TextNvy7gAk("Custom Button", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
