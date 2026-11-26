package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MenuKt;
import androidx.compose.material.icons.filled.QrCodeScannerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CustomAppBar.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CustomAppBarKt {
    public static final ComposableSingletons$CustomAppBarKt INSTANCE = new ComposableSingletons$CustomAppBarKt();

    /* JADX INFO: renamed from: lambda$-424279860, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f115lambda$424279860 = ComposableLambdaKt.composableLambdaInstance(-424279860, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomAppBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CustomAppBarKt.lambda__424279860$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2026609384 = ComposableLambdaKt.composableLambdaInstance(2026609384, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomAppBarKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CustomAppBarKt.lambda_2026609384$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-424279860$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9749getLambda$424279860$app_debug() {
        return f115lambda$424279860;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2026609384$app_debug() {
        return lambda$2026609384;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__424279860$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1487L53:CustomAppBar.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-424279860, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomAppBarKt.lambda$-424279860.<anonymous> (CustomAppBar.kt:40)");
            }
            IconKt.m3158Iconww6aTOc(MenuKt.getMenu(Icons.INSTANCE.getDefault()), "Menu", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2026609384$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2120L70:CustomAppBar.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2026609384, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$CustomAppBarKt.lambda$2026609384.<anonymous> (CustomAppBar.kt:59)");
            }
            IconKt.m3158Iconww6aTOc(QrCodeScannerKt.getQrCodeScanner(Icons.INSTANCE.getDefault()), "Scan QR Code", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
