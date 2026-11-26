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
import com.example.bingwahybrid.presentation.navigation.Route;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AccessibilityInfoScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AccessibilityInfoScreenKt {
    public static final ComposableSingletons$AccessibilityInfoScreenKt INSTANCE = new ComposableSingletons$AccessibilityInfoScreenKt();

    /* JADX INFO: renamed from: lambda$-42904935, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f121lambda$42904935 = ComposableLambdaKt.composableLambdaInstance(-42904935, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityInfoScreenKt.lambda__42904935$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1554894023, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f120lambda$1554894023 = ComposableLambdaKt.composableLambdaInstance(-1554894023, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityInfoScreenKt.lambda__1554894023$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1870330851 = ComposableLambdaKt.composableLambdaInstance(1870330851, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AccessibilityInfoScreenKt.lambda_1870330851$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1554894023$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9807getLambda$1554894023$app_debug() {
        return f120lambda$1554894023;
    }

    /* JADX INFO: renamed from: getLambda$-42904935$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9808getLambda$42904935$app_debug() {
        return f121lambda$42904935;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1870330851$app_debug() {
        return lambda$1870330851;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__42904935$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1729L35:AccessibilityInfoScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-42904935, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt.lambda$-42904935.<anonymous> (AccessibilityInfoScreen.kt:40)");
            }
            TextKt.m3864TextNvy7gAk(Route.AccessibilityInfo.INSTANCE.getTitle(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1554894023$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C43@1904L70:AccessibilityInfoScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1554894023, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt.lambda$-1554894023.<anonymous> (AccessibilityInfoScreen.kt:43)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1870330851$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C100@3841L10,99@3767L182:AccessibilityInfoScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1870330851, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AccessibilityInfoScreenKt.lambda$1870330851.<anonymous> (AccessibilityInfoScreen.kt:99)");
            }
            TextKt.m3864TextNvy7gAk("Open Accessibility Settings", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelLarge(), 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
