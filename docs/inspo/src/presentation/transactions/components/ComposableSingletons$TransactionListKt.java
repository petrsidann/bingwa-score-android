package com.example.bingwahybrid.presentation.transactions.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TransactionList.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TransactionListKt {
    public static final ComposableSingletons$TransactionListKt INSTANCE = new ComposableSingletons$TransactionListKt();

    /* JADX INFO: renamed from: lambda$-1692460006, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f110lambda$1692460006 = ComposableLambdaKt.composableLambdaInstance(-1692460006, false, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionListKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TransactionListKt.lambda__1692460006$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$512881430 = ComposableLambdaKt.composableLambdaInstance(512881430, false, new Function3() { // from class: com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionListKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TransactionListKt.lambda_512881430$lambda$1((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1692460006$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9687getLambda$1692460006$app_debug() {
        return f110lambda$1692460006;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$512881430$app_debug() {
        return lambda$512881430;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1692460006$lambda$0(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C136@5614L41,137@5680L148:TransactionList.kt#7qqvjm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1692460006, i, -1, "com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionListKt.lambda$-1692460006.<anonymous> (TransactionList.kt:136)");
            }
            float f = 16;
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), composer, 6);
            ProgressIndicatorKt.m3439CircularProgressIndicator4lLiAd8(PaddingKt.m1118padding3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(f)), 0L, 0.0f, 0L, 0, 0.0f, composer, 6, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_512881430$lambda$1(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C147@5921L41:TransactionList.kt#7qqvjm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(512881430, i, -1, "com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionListKt.lambda$512881430.<anonymous> (TransactionList.kt:147)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(84)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
