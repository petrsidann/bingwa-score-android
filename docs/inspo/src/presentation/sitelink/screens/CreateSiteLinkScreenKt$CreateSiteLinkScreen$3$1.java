package com.example.bingwahybrid.presentation.sitelink.screens;

import androidx.compose.runtime.State;
import androidx.navigation.NavHostController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateSiteLinkScreen.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.bingwahybrid.presentation.sitelink.screens.CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1", f = "CreateSiteLinkScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ State<Boolean> $siteLinkGenerationSuccess$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1(NavHostController navHostController, State<Boolean> state, Continuation<? super CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$siteLinkGenerationSuccess$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1(this.$navController, this.$siteLinkGenerationSuccess$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateSiteLinkScreenKt$CreateSiteLinkScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (CreateSiteLinkScreenKt.CreateSiteLinkScreen$lambda$5(this.$siteLinkGenerationSuccess$delegate)) {
                this.$navController.popBackStack();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
