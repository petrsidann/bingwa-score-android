package com.example.bingwahybrid.presentation.ui.screens;

import com.example.bingwahybrid.domain.sms.model.AuthorizedSender;
import com.example.bingwahybrid.presentation.viewmodel.AuthorizedSendersViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthorizedSendersScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1 extends FunctionReferenceImpl implements Function1<AuthorizedSender, Unit> {
    AuthorizedSendersScreenKt$AuthorizedSendersScreen$4$1$1$1(Object obj) {
        super(1, obj, AuthorizedSendersViewModel.class, "deleteAuthorizedSender", "deleteAuthorizedSender(Lcom/example/bingwahybrid/domain/sms/model/AuthorizedSender;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AuthorizedSender authorizedSender) {
        invoke2(authorizedSender);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AuthorizedSender p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AuthorizedSendersViewModel) this.receiver).deleteAuthorizedSender(p0);
    }
}
