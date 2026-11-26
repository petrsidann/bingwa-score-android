package com.example.bingwahybrid.presentation.ui.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GlobalSnackbarHost.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"GlobalSnackbarHost", "", "(Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GlobalSnackbarHostKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GlobalSnackbarHost$lambda$1(int i, Composer composer, int i2) {
        GlobalSnackbarHost(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void GlobalSnackbarHost(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-955524513);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(GlobalSnackbarHost)16@619L32,21@815L3,21@819L17,18@700L143:GlobalSnackbarHost.kt#vpfmmr");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-955524513, i, -1, "com.example.bingwahybrid.presentation.ui.components.GlobalSnackbarHost (GlobalSnackbarHost.kt:15)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 863946527, "CC(remember):GlobalSnackbarHost.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SnackbarManager.INSTANCE.init(snackbarHostState);
            SnackbarHostKt.SnackbarHost(snackbarHostState, PaddingKt.padding(Modifier.INSTANCE, WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composerStartRestartGroup, 6), composerStartRestartGroup, 0)), null, composerStartRestartGroup, 6, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.ui.components.GlobalSnackbarHostKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GlobalSnackbarHostKt.GlobalSnackbarHost$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
