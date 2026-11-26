package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.ScheduleKt;
import androidx.compose.material.icons.outlined.DeleteKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InfoCard.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$InfoCardKt {
    public static final ComposableSingletons$InfoCardKt INSTANCE = new ComposableSingletons$InfoCardKt();
    private static Function2<Composer, Integer, Unit> lambda$1559528380 = ComposableLambdaKt.composableLambdaInstance(1559528380, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InfoCardKt.lambda_1559528380$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-666981453, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f119lambda$666981453 = ComposableLambdaKt.composableLambdaInstance(-666981453, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InfoCardKt.lambda__666981453$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1755670743 = ComposableLambdaKt.composableLambdaInstance(1755670743, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InfoCardKt.lambda_1755670743$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-564765344, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f118lambda$564765344 = ComposableLambdaKt.composableLambdaInstance(-564765344, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$InfoCardKt.lambda__564765344$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-564765344$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9753getLambda$564765344$app_debug() {
        return f118lambda$564765344;
    }

    /* JADX INFO: renamed from: getLambda$-666981453$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9754getLambda$666981453$app_debug() {
        return f119lambda$666981453;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1559528380$app_debug() {
        return lambda$1559528380;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1755670743$app_debug() {
        return lambda$1755670743;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1559528380$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C269@10993L72:InfoCard.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1559528380, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt.lambda$1559528380.<anonymous> (InfoCard.kt:269)");
            }
            IconKt.m3158Iconww6aTOc(DeleteKt.getDelete(Icons.Outlined.INSTANCE), "Delete", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__666981453$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C276@11269L77:InfoCard.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-666981453, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt.lambda$-666981453.<anonymous> (InfoCard.kt:276)");
            }
            IconKt.m3158Iconww6aTOc(ScheduleKt.getSchedule(Icons.INSTANCE.getDefault()), "Reschedule", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1755670743$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C280@11471L27:InfoCard.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1755670743, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt.lambda$1755670743.<anonymous> (InfoCard.kt:280)");
            }
            ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(null, 0L, 0.0f, 0L, 0, 0.0f, composer, 0, 63);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__564765344$lambda$3(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C294@12064L70:InfoCard.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-564765344, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$InfoCardKt.lambda$-564765344.<anonymous> (InfoCard.kt:294)");
            }
            IconKt.m3158Iconww6aTOc(RefreshKt.getRefresh(Icons.Filled.INSTANCE), "Retry", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
