package com.example.bingwahybrid.presentation.quickdial.screens;

import androidx.compose.foundation.lazy.grid.GridItemSpan;
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LazyGridDsl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$3 implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $span;

    public QuickDialScreenKt$QuickDialScreenContent$lambda$48$lambda$47$lambda$46$$inlined$items$default$3(Function2 function2, List list) {
        this.$span = function2;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ GridItemSpan invoke(LazyGridItemSpanScope lazyGridItemSpanScope, Integer num) {
        return GridItemSpan.m1258boximpl(m9553invoke_orMbw(lazyGridItemSpanScope, num.intValue()));
    }

    /* JADX INFO: renamed from: invoke-_-orMbw, reason: not valid java name */
    public final long m9553invoke_orMbw(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        return ((GridItemSpan) this.$span.invoke(lazyGridItemSpanScope, this.$items.get(i))).getPackedValue();
    }
}
