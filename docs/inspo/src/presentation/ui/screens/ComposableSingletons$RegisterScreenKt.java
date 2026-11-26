package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RegisterScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RegisterScreenKt {
    public static final ComposableSingletons$RegisterScreenKt INSTANCE = new ComposableSingletons$RegisterScreenKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$284261687 = ComposableLambdaKt.composableLambdaInstance(284261687, false, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$RegisterScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RegisterScreenKt.lambda_284261687$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$284261687$app_debug() {
        return lambda$284261687;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_284261687$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C227@8701L10,228@8775L11,225@8600L289:RegisterScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284261687, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$RegisterScreenKt.lambda$284261687.<anonymous> (RegisterScreen.kt:225)");
            }
            TextKt.m3865TextZ58ophY(new AnnotatedString("Login", null, 2, null), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
