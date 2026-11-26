package com.example.bingwahybrid.presentation.subscriptions.components;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: PaymentSuccessDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$PaymentSuccessDialogKt {
    public static final ComposableSingletons$PaymentSuccessDialogKt INSTANCE = new ComposableSingletons$PaymentSuccessDialogKt();
    private static Function2<Composer, Integer, Unit> lambda$1111441206 = ComposableLambdaKt.composableLambdaInstance(1111441206, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.components.ComposableSingletons$PaymentSuccessDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PaymentSuccessDialogKt.lambda_1111441206$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1111441206$app_debug() {
        return lambda$1111441206;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1111441206$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3524L10,80@3423L245:PaymentSuccessDialog.kt#n7hr4b");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1111441206, i, -1, "com.example.bingwahybrid.presentation.subscriptions.components.ComposableSingletons$PaymentSuccessDialogKt.lambda$1111441206.<anonymous> (PaymentSuccessDialog.kt:80)");
            }
            TextKt.m3864TextNvy7gAk("Finish", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
