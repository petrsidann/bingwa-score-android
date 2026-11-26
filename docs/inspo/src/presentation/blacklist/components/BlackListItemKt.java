package com.example.bingwahybrid.presentation.blacklist.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BlackListItem.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"BlackListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlackListItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlackListItem$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        BlackListItem(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BlackListItem(final Modifier modifier, Composer composer, final int i, final int i2) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2127574611);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BlackListItem)N(modifier):BlackListItem.kt#rn5rwc");
        int i3 = i & 1;
        if (composerStartRestartGroup.shouldExecute(i3 != 0, i3)) {
            if ((i2 & 1) != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2127574611, i, -1, "com.example.bingwahybrid.presentation.blacklist.components.BlackListItem (BlackListItem.kt:6)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.example.bingwahybrid.presentation.blacklist.components.BlackListItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlackListItemKt.BlackListItem$lambda$0(modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
