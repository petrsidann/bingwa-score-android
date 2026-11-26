package com.example.bingwahybrid.presentation.ui.components;

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

/* JADX INFO: compiled from: DurationFilterChips.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$DurationFilterChipsKt {
    public static final ComposableSingletons$DurationFilterChipsKt INSTANCE = new ComposableSingletons$DurationFilterChipsKt();

    /* JADX INFO: renamed from: lambda$-1623801256, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f117lambda$1623801256 = ComposableLambdaKt.composableLambdaInstance(-1623801256, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$DurationFilterChipsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$DurationFilterChipsKt.lambda__1623801256$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1623801256$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9751getLambda$1623801256$app_debug() {
        return f117lambda$1623801256;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1623801256$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@1945L236:DurationFilterChips.kt#vpfmmr");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1623801256, i, -1, "com.example.bingwahybrid.presentation.ui.components.ComposableSingletons$DurationFilterChipsKt.lambda$-1623801256.<anonymous> (DurationFilterChips.kt:51)");
            }
            IconKt.m3158Iconww6aTOc(DoneKt.getDone(Icons.Filled.INSTANCE), "Done icon", SizeKt.m1170size3ABfNKs(Modifier.INSTANCE, FilterChipDefaults.INSTANCE.m3086getIconSizeD9Ej5fM()), 0L, composer, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
