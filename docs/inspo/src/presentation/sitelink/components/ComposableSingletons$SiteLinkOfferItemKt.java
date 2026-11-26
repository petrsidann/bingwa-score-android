package com.example.bingwahybrid.presentation.sitelink.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.RemoveCircleOutlineKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SiteLinkOfferItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SiteLinkOfferItemKt {
    public static final ComposableSingletons$SiteLinkOfferItemKt INSTANCE = new ComposableSingletons$SiteLinkOfferItemKt();
    private static Function2<Composer, Integer, Unit> lambda$1531242631 = ComposableLambdaKt.composableLambdaInstance(1531242631, false, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.components.ComposableSingletons$SiteLinkOfferItemKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SiteLinkOfferItemKt.lambda_1531242631$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1531242631$app_debug() {
        return lambda$1531242631;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1531242631$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5110L11,112@4876L319:SiteLinkOfferItem.kt#hf9vpi");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1531242631, i, -1, "com.example.bingwahybrid.presentation.sitelink.components.ComposableSingletons$SiteLinkOfferItemKt.lambda$1531242631.<anonymous> (SiteLinkOfferItem.kt:112)");
            }
            IconKt.m3158Iconww6aTOc(RemoveCircleOutlineKt.getRemoveCircleOutline(Icons.Outlined.INSTANCE), "Delete Offer", (Modifier) null, Color.m5939copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
