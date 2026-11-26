package com.example.bingwahybrid.presentation.ui.screens;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditProfileScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$EditProfileScreenKt {
    public static final ComposableSingletons$EditProfileScreenKt INSTANCE = new ComposableSingletons$EditProfileScreenKt();

    /* JADX INFO: renamed from: lambda$-873230225, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f139lambda$873230225 = ComposableLambdaKt.composableLambdaInstance(-873230225, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$EditProfileScreenKt.lambda__873230225$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-241861681, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f138lambda$241861681 = ComposableLambdaKt.composableLambdaInstance(-241861681, false, new Function2() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$EditProfileScreenKt.lambda__241861681$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1459862539, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f137lambda$1459862539 = ComposableLambdaKt.composableLambdaInstance(-1459862539, false, new Function3() { // from class: com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$EditProfileScreenKt.lambda__1459862539$lambda$2((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1459862539$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m9838getLambda$1459862539$app_debug() {
        return f137lambda$1459862539;
    }

    /* JADX INFO: renamed from: getLambda$-241861681$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9839getLambda$241861681$app_debug() {
        return f138lambda$241861681;
    }

    /* JADX INFO: renamed from: getLambda$-873230225$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m9840getLambda$873230225$app_debug() {
        return f139lambda$873230225;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__873230225$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3183L20:EditProfileScreen.kt#oif8tm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-873230225, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt.lambda$-873230225.<anonymous> (EditProfileScreen.kt:73)");
            }
            TextKt.m3864TextNvy7gAk("Edit Profile", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__241861681$lambda$1(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3388L70:EditProfileScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-241861681, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt.lambda$-241861681.<anonymous> (EditProfileScreen.kt:78)");
            }
            IconKt.m3158Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", (Modifier) null, 0L, composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1459862539$lambda$2(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C187@7291L10,186@7229L249:EditProfileScreen.kt#oif8tm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1459862539, i, -1, "com.example.bingwahybrid.presentation.ui.screens.ComposableSingletons$EditProfileScreenKt.lambda$-1459862539.<anonymous> (EditProfileScreen.kt:186)");
            }
            TextKt.m3864TextNvy7gAk("Change PIN", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m8131copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), 0L, 0L, new FontWeight(500), null, null, null, null, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773115, null), composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
