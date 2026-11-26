package com.example.bingwahybrid.presentation.sitelink.screens;

import androidx.compose.runtime.State;
import com.example.bingwahybrid.domain.utils.SnackbarManager;
import com.example.bingwahybrid.presentation.sitelink.viewmodel.SiteLinkViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: EditSiteLinkScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.screens.EditSiteLinkScreenKt$EditSiteLinkScreen$2$1", f = "EditSiteLinkScreen.kt", i = {0, 0}, l = {90}, m = "invokeSuspend", n = {"it", "$i$a$-let-EditSiteLinkScreenKt$EditSiteLinkScreen$2$1$1"}, s = {"L$1", "I$0"})
final class EditSiteLinkScreenKt$EditSiteLinkScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $errorMessage$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SiteLinkViewModel $viewModel;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditSiteLinkScreenKt$EditSiteLinkScreen$2$1(State<String> state, CoroutineScope coroutineScope, SiteLinkViewModel siteLinkViewModel, Continuation<? super EditSiteLinkScreenKt$EditSiteLinkScreen$2$1> continuation) {
        super(2, continuation);
        this.$errorMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = siteLinkViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EditSiteLinkScreenKt$EditSiteLinkScreen$2$1(this.$errorMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EditSiteLinkScreenKt$EditSiteLinkScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SiteLinkViewModel siteLinkViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strEditSiteLinkScreen$lambda$5 = EditSiteLinkScreenKt.EditSiteLinkScreen$lambda$5(this.$errorMessage$delegate);
            if (strEditSiteLinkScreen$lambda$5 != null) {
                CoroutineScope coroutineScope = this.$scope;
                SiteLinkViewModel siteLinkViewModel2 = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strEditSiteLinkScreen$lambda$5);
                this.L$0 = siteLinkViewModel2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(strEditSiteLinkScreen$lambda$5);
                this.I$0 = 0;
                this.label = 1;
                if (DelayKt.delay(2000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                siteLinkViewModel = siteLinkViewModel2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        siteLinkViewModel = (SiteLinkViewModel) this.L$0;
        ResultKt.throwOnFailure(obj);
        siteLinkViewModel.resetSnackBarMessage();
        return Unit.INSTANCE;
    }
}
