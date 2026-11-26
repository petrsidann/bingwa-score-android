package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ResetPasswordScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ResetPasswordScreenKt {
    public static final ComposableSingletons$ResetPasswordScreenKt INSTANCE = new ComposableSingletons$ResetPasswordScreenKt();

    /* JADX INFO: renamed from: lambda$-63589023, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f148lambda$63589023 = ComposableLambdaKt.composableLambdaInstance(-63589023, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$ResetPasswordScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ResetPasswordScreenKt.lambda__63589023$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1357396161 = ComposableLambdaKt.composableLambdaInstance(1357396161, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$ResetPasswordScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ResetPasswordScreenKt.lambda_1357396161$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-63589023$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9857getLambda$63589023$app_debug() {
        return f148lambda$63589023;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1357396161$app_debug() {
        return lambda$1357396161;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__63589023$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C79@3121L10,80@3199L11,77@3032L294:ResetPasswordScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-63589023, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$ResetPasswordScreenKt.lambda$-63589023.<anonymous> (ResetPasswordScreen.kt:77)");
            }
            TextKt.m3864TextNvy7gAk("Reset PIN", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777210, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1357396161$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C93@3689L70:ResetPasswordScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357396161, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$ResetPasswordScreenKt.lambda$1357396161.<anonymous> (ResetPasswordScreen.kt:93)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
