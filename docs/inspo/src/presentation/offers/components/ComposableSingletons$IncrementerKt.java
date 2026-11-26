package com.example.bingwahybrid.presentation.offers.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Incrementer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$IncrementerKt {
    public static final ComposableSingletons$IncrementerKt INSTANCE = new ComposableSingletons$IncrementerKt();
    private static Function2<Composer, Integer, Unit> lambda$1661855256 = ComposableLambdaKt.composableLambdaInstance(1661855256, false, new Function2() { // from class: com.example.bingwahybrid.presentation.offers.components.ComposableSingletons$IncrementerKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$IncrementerKt.lambda_1661855256$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1661855256$app_debug() {
        return lambda$1661855256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1661855256$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C93@3310L11,90@3156L191:Incrementer.kt#m9828");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1661855256, i, -1, "com.example.bingwahybrid.presentation.offers.components.ComposableSingletons$IncrementerKt.lambda$1661855256.<anonymous> (Incrementer.kt:90)");
            }
            IconKt.m3158Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Increment", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
