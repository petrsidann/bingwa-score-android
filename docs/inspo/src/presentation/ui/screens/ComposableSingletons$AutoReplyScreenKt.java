package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.AddKt;
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

/* JADX INFO: compiled from: AutoReplyScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AutoReplyScreenKt {
    public static final ComposableSingletons$AutoReplyScreenKt INSTANCE = new ComposableSingletons$AutoReplyScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1230965811 = ComposableLambdaKt.composableLambdaInstance(1230965811, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoReplyScreenKt.lambda_1230965811$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$472711059 = ComposableLambdaKt.composableLambdaInstance(472711059, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoReplyScreenKt.lambda_472711059$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$351635516 = ComposableLambdaKt.composableLambdaInstance(351635516, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AutoReplyScreenKt.lambda_351635516$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1405903152 = ComposableLambdaKt.composableLambdaInstance(1405903152, false, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AutoReplyScreenKt.lambda_1405903152$lambda$3((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1230965811$app_debug() {
        return lambda$1230965811;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1405903152$app_debug() {
        return lambda$1405903152;
    }

    public final Function2<Composer, Integer, Unit> getLambda$351635516$app_debug() {
        return lambda$351635516;
    }

    public final Function2<Composer, Integer, Unit> getLambda$472711059$app_debug() {
        return lambda$472711059;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1230965811$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2523L26:AutoReplyScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1230965811, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt.lambda$1230965811.<anonymous> (AutoReplyScreen.kt:61)");
            }
            TextKt.m3864TextNvy7gAk("AutoReply Messages", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_472711059$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2733L70:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(472711059, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt.lambda$472711059.<anonymous> (AutoReplyScreen.kt:66)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_351635516$lambda$2(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C77@3090L142:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(351635516, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt.lambda$351635516.<anonymous> (AutoReplyScreen.kt:77)");
            }
            IconKt.m3158Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add Auto Reply Message", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1405903152$lambda$3(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C127@4579L42:AutoReplyScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1405903152, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$AutoReplyScreenKt.lambda$1405903152.<anonymous> (AutoReplyScreen.kt:127)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(100)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
