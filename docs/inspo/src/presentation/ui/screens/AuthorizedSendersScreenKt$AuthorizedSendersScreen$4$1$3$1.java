package com.example.bingwahybrid.presentation.ui.screens;

import com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: AuthorizedSendersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1 extends FunctionReferenceImpl implements Function0<Unit> {
    AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$3$1(Object obj) {
        super(0, obj, AuthorizedSendersViewModel.class, "hideAddDialog", "hideAddDialog()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((AuthorizedSendersViewModel) this.receiver).hideAddDialog();
    }
}
