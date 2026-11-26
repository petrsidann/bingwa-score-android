package com.example.bingwahybrid.presentation.community.components;

import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OverwriteOfferDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"OverwriteOfferDialog", "", "showDialog", "", "onConfirm", "Lkotlin/Function0;", "onDismiss", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OverwriteOfferDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverwriteOfferDialog$lambda$2(boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        OverwriteOfferDialog(z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OverwriteOfferDialog(final boolean z, final Function0<Unit> onConfirm, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(780394242);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OverwriteOfferDialog)N(showDialog,onConfirm,onDismiss):OverwriteOfferDialog.kt#82zsnc");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onConfirm) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(780394242, i2, -1, "com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialog (OverwriteOfferDialog.kt:12)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(67049144);
                ComposerKt.sourceInformation(composerStartRestartGroup, "22@702L126,27@858L125,14@393L600");
                AndroidAlertDialog_androidKt.m2582AlertDialogOix01E0(onDismiss, ComposableLambdaKt.rememberComposableLambda(-1234166251, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OverwriteOfferDialogKt.OverwriteOfferDialog$lambda$0(onConfirm, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(1094814291, true, new Function2() { // from class: com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OverwriteOfferDialogKt.OverwriteOfferDialog$lambda$1(onDismiss, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableSingletons$OverwriteOfferDialogKt.INSTANCE.m9411getLambda$871172463$app_debug(), ComposableSingletons$OverwriteOfferDialogKt.INSTANCE.m9410getLambda$1854165840$app_debug(), null, 0L, 0L, 0L, 0L, 0.0f, null, composerStartRestartGroup, ((i2 >> 6) & 14) | 1772592, 0, 16276);
                composer2 = composerStartRestartGroup;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.startReplaceGroup(66649120);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverwriteOfferDialogKt.OverwriteOfferDialog$lambda$2(z, onConfirm, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverwriteOfferDialog$lambda$0(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C23@720L94:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1234166251, i, -1, "com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialog.<anonymous> (OverwriteOfferDialog.kt:23)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$OverwriteOfferDialogKt.INSTANCE.m9409getLambda$1384327112$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverwriteOfferDialog$lambda$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C28@876L93:OverwriteOfferDialog.kt#82zsnc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094814291, i, -1, "com.example.bingwahybrid.presentation.community.components.OverwriteOfferDialog.<anonymous> (OverwriteOfferDialog.kt:28)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$OverwriteOfferDialogKt.INSTANCE.getLambda$944653430$app_debug(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
