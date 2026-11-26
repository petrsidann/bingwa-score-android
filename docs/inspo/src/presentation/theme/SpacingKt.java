package com.example.bingwahybrid.presentation.theme;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Spacing.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"spacing", "Lcom/example/bingwahybrid/presentation/theme/Spacing;", "Landroidx/compose/material3/MaterialTheme;", "getSpacing", "(Landroidx/compose/material3/MaterialTheme;Landroidx/compose/runtime/Composer;I)Lcom/example/bingwahybrid/presentation/theme/Spacing;", "app_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SpacingKt {
    public static final Spacing getSpacing(MaterialTheme materialTheme, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(materialTheme, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 819782625, "C(<get-spacing>):Spacing.kt#wj0ot0");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(819782625, i, -1, "com.example.bingwahybrid.presentation.theme.<get-spacing> (Spacing.kt:9)");
        }
        Spacing spacing = new Spacing(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return spacing;
    }
}
