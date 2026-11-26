package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.EditKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ProfileScreenContent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ProfileScreenContentKt {
    public static final ComposableSingletons$ProfileScreenContentKt INSTANCE = new ComposableSingletons$ProfileScreenContentKt();
    private static Function2<Composer, Integer, Unit> lambda$1852317336 = ComposableLambdaKt.composableLambdaInstance(1852317336, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$ProfileScreenContentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ProfileScreenContentKt.lambda_1852317336$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1852317336$app_debug() {
        return lambda$1852317336;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1852317336$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2517L220:ProfileScreenContent.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1852317336, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$ProfileScreenContentKt.lambda$1852317336.<anonymous> (ProfileScreenContent.kt:66)");
            }
            IconKt.m3158Iconww6aTOc(EditKt.getEdit(Icons.Outlined.INSTANCE), "Edit", PaddingKt.m1118padding3ABfNKs(SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(42)), Dp.m8684constructorimpl(8)), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
