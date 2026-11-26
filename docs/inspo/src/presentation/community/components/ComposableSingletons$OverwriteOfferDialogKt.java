package com.example.bingwahybrid.presentation.community.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverwriteOfferDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$OverwriteOfferDialogKt {
    public static final ComposableSingletons$OverwriteOfferDialogKt INSTANCE = new ComposableSingletons$OverwriteOfferDialogKt();

    /* JADX INFO: renamed from: lambda$-1384327112, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f62lambda$1384327112 = ComposableLambdaKt.composableLambdaInstance(-1384327112, false, new Function3() { // from class: com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OverwriteOfferDialogKt.lambda__1384327112$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$944653430 = ComposableLambdaKt.composableLambdaInstance(944653430, false, new Function3() { // from class: com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OverwriteOfferDialogKt.lambda_944653430$lambda$1((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-871172463, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f64lambda$871172463 = ComposableLambdaKt.composableLambdaInstance(-871172463, false, new Function2() { // from class: com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OverwriteOfferDialogKt.lambda__871172463$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1854165840, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f63lambda$1854165840 = ComposableLambdaKt.composableLambdaInstance(-1854165840, false, new Function2() { // from class: com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$OverwriteOfferDialogKt.lambda__1854165840$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1384327112$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m9409getLambda$1384327112$app_debug() {
        return f62lambda$1384327112;
    }

    /* JADX INFO: renamed from: getLambda$-1854165840$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9410getLambda$1854165840$app_debug() {
        return f63lambda$1854165840;
    }

    /* JADX INFO: renamed from: getLambda$-871172463$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9411getLambda$871172463$app_debug() {
        return f64lambda$871172463;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$944653430$app_debug() {
        return lambda$944653430;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__871172463$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C17@486L30:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-871172463, i, -1, "com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt.lambda$-871172463.<anonymous> (OverwriteOfferDialog.kt:17)");
            }
            TextKt.m3864TextNvy7gAk("Overwrite Offer", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1854165840$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C20@569L89:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1854165840, i, -1, "com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt.lambda$-1854165840.<anonymous> (OverwriteOfferDialog.kt:20)");
            }
            TextKt.m3864TextNvy7gAk("You have an existing offer with the same price. Do you want to replace it?", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1384327112$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C24@774L22:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1384327112, i, -1, "com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt.lambda$-1384327112.<anonymous> (OverwriteOfferDialog.kt:24)");
            }
            TextKt.m3864TextNvy7gAk("Proceed", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_944653430$lambda$1(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C29@930L21:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(944653430, i, -1, "com.example.bingwahybrid.presentation.community.components.ComposableSingletons$OverwriteOfferDialogKt.lambda$944653430.<anonymous> (OverwriteOfferDialog.kt:29)");
            }
            TextKt.m3864TextNvy7gAk("Cancel", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
