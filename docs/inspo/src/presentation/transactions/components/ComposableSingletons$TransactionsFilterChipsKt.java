package com.example.bingwahybrid.presentation.transactions.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DoneKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: TransactionsFilterChips.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$TransactionsFilterChipsKt {
    public static final ComposableSingletons$TransactionsFilterChipsKt INSTANCE = new ComposableSingletons$TransactionsFilterChipsKt();
    private static Function2<Composer, Integer, Unit> lambda$1885509413 = ComposableLambdaKt.composableLambdaInstance(1885509413, false, new Function2() { // from class: com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionsFilterChipsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TransactionsFilterChipsKt.lambda_1885509413$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1885509413$app_debug() {
        return lambda$1885509413;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1885509413$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C67@2705L236:TransactionsFilterChips.kt#7qqvjm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1885509413, i, -1, "com.example.bingwahybrid.presentation.transactions.components.ComposableSingletons$TransactionsFilterChipsKt.lambda$1885509413.<anonymous> (TransactionsFilterChips.kt:67)");
            }
            IconKt.m3158Iconww6aTOc(DoneKt.getDone(Icons.Filled.INSTANCE), "Done icon", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, FilterChipDefaults.INSTANCE.m3086getIconSizeD9Ej5fM()), 0L, composer, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
