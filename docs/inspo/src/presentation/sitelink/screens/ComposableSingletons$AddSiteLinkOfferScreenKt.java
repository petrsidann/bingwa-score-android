package com.example.bingwahybrid.presentation.sitelink.screens;

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

/* JADX INFO: compiled from: AddSiteLinkOfferScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$AddSiteLinkOfferScreenKt {
    public static final ComposableSingletons$AddSiteLinkOfferScreenKt INSTANCE = new ComposableSingletons$AddSiteLinkOfferScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$2037988511 = ComposableLambdaKt.composableLambdaInstance(2037988511, false, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddSiteLinkOfferScreenKt.lambda_2037988511$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1014097215 = ComposableLambdaKt.composableLambdaInstance(1014097215, false, new Function2() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AddSiteLinkOfferScreenKt.lambda_1014097215$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1841772510 = ComposableLambdaKt.composableLambdaInstance(1841772510, false, new Function3() { // from class: com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$AddSiteLinkOfferScreenKt.lambda_1841772510$lambda$2((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1014097215$app_debug() {
        return lambda$1014097215;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1841772510$app_debug() {
        return lambda$1841772510;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2037988511$app_debug() {
        return lambda$2037988511;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_2037988511$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C55@2396L65:AddSiteLinkOfferScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2037988511, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt.lambda$2037988511.<anonymous> (AddSiteLinkOfferScreen.kt:55)");
            }
            TextKt.m3864TextNvy7gAk("Add SiteLink Offers", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1014097215$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C61@2601L70:AddSiteLinkOfferScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1014097215, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt.lambda$1014097215.<anonymous> (AddSiteLinkOfferScreen.kt:61)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1841772510$lambda$2(LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C98@3938L41:AddSiteLinkOfferScreen.kt#4cevh3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841772510, i, -1, "com.example.bingwahybrid.presentation.sitelink.screens.ComposableSingletons$AddSiteLinkOfferScreenKt.lambda$1841772510.<anonymous> (AddSiteLinkOfferScreen.kt:98)");
            }
            SpacerKt.Spacer(SizeKt.m1156height3ABfNKs(Modifier.INSTANCE, Dp.m8684constructorimpl(84)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
