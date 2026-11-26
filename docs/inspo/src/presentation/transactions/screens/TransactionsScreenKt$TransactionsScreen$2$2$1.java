package com.example.bingwahybrid.presentation.transactions.screens;

import com.example.bingwahybrid.presentation.transactions.viewmodel.TransactionsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: TransactionsScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class TransactionsScreenKt$TransactionsScreen$2$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    TransactionsScreenKt$TransactionsScreen$2$2$1(Object obj) {
        super(0, obj, TransactionsViewModel.class, "stopSelectionMode", "stopSelectionMode()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TransactionsViewModel) this.receiver).stopSelectionMode();
    }
}
