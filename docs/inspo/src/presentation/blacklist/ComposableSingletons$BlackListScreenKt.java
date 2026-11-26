package com.example.bingwahybrid.presentation.blacklist;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackListScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$BlackListScreenKt {
    public static final ComposableSingletons$BlackListScreenKt INSTANCE = new ComposableSingletons$BlackListScreenKt();

    /* JADX INFO: renamed from: lambda$-155457676, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f60lambda$155457676 = ComposableLambdaKt.composableLambdaInstance(-155457676, false, new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$BlackListScreenKt.lambda__155457676$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2006946367, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f61lambda$2006946367 = ComposableLambdaKt.composableLambdaInstance(-2006946367, false, new Function3() { // from class: com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BlackListScreenKt.lambda__2006946367$lambda$1((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$162813068 = ComposableLambdaKt.composableLambdaInstance(162813068, false, new Function3() { // from class: com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BlackListScreenKt.lambda_162813068$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1272866808, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f59lambda$1272866808 = ComposableLambdaKt.composableLambdaInstance(-1272866808, false, new Function3() { // from class: com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BlackListScreenKt.lambda__1272866808$lambda$3((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1962504858 = ComposableLambdaKt.composableLambdaInstance(1962504858, false, new Function3() { // from class: com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$BlackListScreenKt.lambda_1962504858$lambda$4((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1272866808$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9402getLambda$1272866808$app_debug() {
        return f59lambda$1272866808;
    }

    /* JADX INFO: renamed from: getLambda$-155457676$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9403getLambda$155457676$app_debug() {
        return f60lambda$155457676;
    }

    /* JADX INFO: renamed from: getLambda$-2006946367$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m9404getLambda$2006946367$app_debug() {
        return f61lambda$2006946367;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$162813068$app_debug() {
        return lambda$162813068;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1962504858$app_debug() {
        return lambda$1962504858;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__155457676$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3694L70:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-155457676, i, -1, "com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt.lambda$-155457676.<anonymous> (BlackListScreen.kt:82)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2006946367$lambda$1(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C144@5641L41:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2006946367, i, -1, "com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt.lambda$-2006946367.<anonymous> (BlackListScreen.kt:144)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_162813068$lambda$2(RowScope FilledTonalButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
        ComposerKt.sourceInformation(composer, "C170@6413L17:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(162813068, i, -1, "com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt.lambda$162813068.<anonymous> (BlackListScreen.kt:170)");
            }
            TextKt.m3864TextNvy7gAk("Blacklist", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1272866808$lambda$3(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C212@7708L41:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1272866808, i, -1, "com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt.lambda$-1272866808.<anonymous> (BlackListScreen.kt:212)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(48)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1962504858$lambda$4(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C258@9345L14:BlackListScreen.kt#m0htc0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1962504858, i, -1, "com.example.bingwahybrid.presentation.blacklist.ComposableSingletons$BlackListScreenKt.lambda$1962504858.<anonymous> (BlackListScreen.kt:258)");
            }
            TextKt.m3864TextNvy7gAk("Remove", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
