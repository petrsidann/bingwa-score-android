package com.example.bingwahybrid.presentation.sitelink.screens;

import androidx.appcompat.app.AppCompatDelegate;
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

/* JADX INFO: compiled from: SiteLinkScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.screens.SiteLinkScreenKt$SiteLinkScreen$3$1", f = "SiteLinkScreen.kt", i = {0, 0}, l = {AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR}, m = "invokeSuspend", n = {"it", "$i$a$-let-SiteLinkScreenKt$SiteLinkScreen$3$1$1"}, s = {"L$1", "I$0"})
final class SiteLinkScreenKt$SiteLinkScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<String> $errorMessage$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SiteLinkViewModel $viewModel;
    int I$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SiteLinkScreenKt$SiteLinkScreen$3$1(State<String> state, CoroutineScope coroutineScope, SiteLinkViewModel siteLinkViewModel, Continuation<? super SiteLinkScreenKt$SiteLinkScreen$3$1> continuation) {
        super(2, continuation);
        this.$errorMessage$delegate = state;
        this.$scope = coroutineScope;
        this.$viewModel = siteLinkViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteLinkScreenKt$SiteLinkScreen$3$1(this.$errorMessage$delegate, this.$scope, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SiteLinkScreenKt$SiteLinkScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SiteLinkViewModel siteLinkViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strSiteLinkScreen$lambda$2 = SiteLinkScreenKt.SiteLinkScreen$lambda$2(this.$errorMessage$delegate);
            if (strSiteLinkScreen$lambda$2 != null) {
                CoroutineScope coroutineScope = this.$scope;
                SiteLinkViewModel siteLinkViewModel2 = this.$viewModel;
                SnackbarManager.INSTANCE.showMessage(coroutineScope, strSiteLinkScreen$lambda$2);
                this.L$0 = siteLinkViewModel2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(strSiteLinkScreen$lambda$2);
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
