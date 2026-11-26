package com.example.bingwahybrid.presentation.subscriptions;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RedeemCouponScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$RedeemCouponScreenKt {
    public static final ComposableSingletons$RedeemCouponScreenKt INSTANCE = new ComposableSingletons$RedeemCouponScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$602003301 = ComposableLambdaKt.composableLambdaInstance(602003301, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$RedeemCouponScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RedeemCouponScreenKt.lambda_602003301$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-75646267, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f108lambda$75646267 = ComposableLambdaKt.composableLambdaInstance(-75646267, false, new Function2() { // from class: com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$RedeemCouponScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$RedeemCouponScreenKt.lambda__75646267$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-75646267$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9645getLambda$75646267$app_debug() {
        return f108lambda$75646267;
    }

    public final Function2<Composer, Integer, Unit> getLambda$602003301$app_debug() {
        return lambda$602003301;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_602003301$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@2444L21:RedeemCouponScreen.kt#6tb7vd");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(602003301, i, -1, "com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$RedeemCouponScreenKt.lambda$602003301.<anonymous> (RedeemCouponScreen.kt:58)");
            }
            TextKt.m3864TextNvy7gAk("Redeem Coupon", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__75646267$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2606L70:RedeemCouponScreen.kt#6tb7vd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-75646267, i, -1, "com.example.bingwahybrid.presentation.subscriptions.ComposableSingletons$RedeemCouponScreenKt.lambda$-75646267.<anonymous> (RedeemCouponScreen.kt:61)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
